package com.xxoocode.card.webSocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.controller.AbstractController;
import com.xxoocode.card.dao.UserTokenDao;
import com.xxoocode.card.entity.UserTokenEntity;
import com.xxoocode.card.entity.WebSocketEntity;
import com.xxoocode.card.service.ShiroService;
import com.xxoocode.card.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 对战用websocket
 */
@Component
@ServerEndpoint(value = "/webSocket",configurator = SpringWebSocketConfig.class)
public class WebSocket extends AbstractController{

    @Autowired
    private ShiroService shiroService;


    private static UserTokenService userTokenService;

    @Autowired
    public void setUserTokenService(UserTokenService userTokenService) {
        WebSocket.userTokenService = userTokenService;
    }

    //线程安全的静态变量，表示在线连接数
    private static volatile int onlineCount = 0;

    //用来存放每个客户端对应的WebSocket对象，适用于同时与多个客户端通信
    public static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    //若要实现服务端与指定客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static ConcurrentHashMap<Session, Object> webSocketMap = new ConcurrentHashMap<Session, Object>();

    //与某个客户端的连接会话，通过它实现定向推送(只推送给某个用户)
    private Session session;

    //保存当前房间列表
    public static List<WebSocketEntity> rommSockeList = new ArrayList<WebSocketEntity>();

    //用户列表
    private static List<HashMap<String,Object>> userList = new ArrayList<HashMap<String,Object>>();

    /**
     * 建立连接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);  // 添加到set中
        webSocketMap.put(session,this);    // 添加到map中
        addOnlineCount();    // 添加在线人数
        System.out.println("有人加入，当前在线人数为："  + getOnlineCount());
    }

    /**
     * 关闭连接调用的方法
     */
    @OnClose
    public void onClose(Session closeSession){
        webSocketMap.remove(session);
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有人离开，当前在线人数为：" + getOnlineCount());
    }

    /**
     *  收到客户端调用的方法
     */
    @OnMessage
    public void onMessage(String message,Session mysession) throws Exception{
        JSONObject object = JSONObject.parseObject(message);
        if (object.getString("key").equals("token")){ //key值为token表示刚连接，准备接入服务器
            //添加到匹配对战列表内
            UserTokenEntity userTokenEntity = userTokenService.queryByToken(object.getString("value")); //根据token的值获取用户信息
            if (userTokenEntity == null){
                return; //用户信息不存在 假的token
            }
            Boolean isUser = false;
            for (HashMap<String,Object> hashMap :userList){ //判断是否已存在用户
                if(hashMap.get("userId").equals(userTokenEntity.getUserId())){
                    isUser = true;
                }
            }
            if(isUser){ //如已有数据，说明之前有连接，具体判断是否需要重连等
                webSocketMap.get(mysession);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("key","token");
                jsonObject.put("type",1); //1表示已有房间需要重连等等
                jsonObject.put("msg","正在尝试重连...");
                mysession.getBasicRemote().sendObject(jsonObject);
            }else{ // 不存在用户-生成uuid进行保存 并且将用户的信息保存下来，以便进行后续匹配
                HashMap<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put("session",mysession);
                hashMap.put("message",message);
                hashMap.put("type",0); // 初始化状态为等待中
//                hashMap.put("socket",this);
                hashMap.put("userId",userTokenEntity.getUserId());
                userList.add(hashMap);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("key","token");
                jsonObject.put("type",0); //0表示进入准备匹配状态
                jsonObject.put("msg","已连接成功");
                mysession.getBasicRemote().sendObject(jsonObject);
            }

//            HashMap<String,Object> map = new HashMap<String,Object>();
//            map.put("")
//
//            userList.add()
//            webSocketMap.size()
        }
        if (object.getString("key").equals("mate")){ //key 为mate表示进行房间匹配
            UserTokenEntity userTokenEntity = userTokenService.queryByToken(object.getString("value")); //根据token的值获取用户信息
            if (userTokenEntity == null){
                return; //用户信息不存在 假的token
            }
            Boolean room = false;
            WebSocketEntity webSocketEntity = new WebSocketEntity();
            for(WebSocketEntity webSocketroom:rommSockeList){
                if (webSocketroom.getType()==0){
                    webSocketEntity = webSocketroom;
                    room = true;
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key","mate");
            jsonObject.put("type",0); //0表示匹配中状态
            jsonObject.put("msg","匹配中...");
            mysession.getBasicRemote().sendObject(jsonObject);

            if (room){ //有在匹配中的房间 直接加入

            }else{ //无房间 创建房间进行等待
                //生成uuid
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                webSocketEntity.setOne(this);
                webSocketEntity.setOneUserId(userTokenEntity.getUserId());
                webSocketEntity.setType(1);
                webSocketEntity.setUuid(uuid);
                rommSockeList.add(webSocketEntity);
            }

        }


//        for (WebSocket item: webSocketSet) {
//            item.sendAllMessage(message);
//        }
    }

    public void sendAllMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    // 获取在线人数
    public static synchronized int getOnlineCount(){
        return onlineCount;
    }

    // 添加在线人+1
    public static synchronized void addOnlineCount(){
        onlineCount ++;
    }

    // 减少在线人-1
    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
