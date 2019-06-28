package com.xxoocode.card.controller;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.*;
import com.xxoocode.card.service.CardBagDetailsService;
import com.xxoocode.card.service.CardBagService;
import com.xxoocode.card.service.CardService;
import com.xxoocode.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 用户卡包表
 *
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@RestController
@RequestMapping("cardbag")
public class CardBagController extends AbstractController {
    @Autowired
    private CardBagService cardBagService;
    @Autowired
    private CardService cardService;
    @Autowired
    private CardBagDetailsService cardBagDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:cardbag:list")
    public R list(@RequestParam Map<String, Object> params){
        String page = params.get("page").toString().trim();
        String limit = params.get("limit").toString().trim();

        List<CardBagExEntity> cardBagList = cardBagService.getBagList();

        List<CardEntity> cardList = cardService.list(new QueryWrapper<CardEntity>().last("order by crystal limit "+((Integer.parseInt(page) - 1) * Integer.parseInt(limit))+","+Integer.parseInt(limit)));

        return R.ok().put("cardBagList", cardBagList).put("cardList",cardList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cardBagId}")
    @RequiresPermissions("generator:cardbag:info")
    public R info(@PathVariable("cardBagId") Long cardBagId){
			CardBagEntity cardBag = cardBagService.getById(cardBagId);

        return R.ok().put("cardBag", cardBag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Transactional
//    @RequiresPermissions("generator:cardbag:save")
    public R save(@RequestBody Map<String, Object> params){
        String bagName = params.get("bagName").toString().trim();
        String[] str = params.get("arr").toString().trim().split("-#-");
        List<CardBagDetailsEntity> list = new ArrayList<>();
        CardBagEntity cardBagEntity = new CardBagEntity();
        cardBagEntity.setBagName(bagName);
        cardBagEntity.setCreateTime(new Date());
        cardBagEntity.setUserId(getUserId());
        cardBagService.save(cardBagEntity);
        for(String strs : str){
            JSONObject jsonObject = JSONObject.parseObject(strs);
            CardBagDetailsEntity cardBagDetailsEntity = new CardBagDetailsEntity();
            cardBagDetailsEntity.setCardBagId(cardBagEntity.getCardBagId());
            cardBagDetailsEntity.setCardName(jsonObject.getString("cardName"));
            cardBagDetailsEntity.setNumber(jsonObject.getInteger("number"));
            cardBagDetailsEntity.setCrystal(jsonObject.getInteger("crystal"));
            cardBagDetailsEntity.setCardId(jsonObject.getLong("cardId"));
            cardBagDetailsEntity.setRarity(jsonObject.getInteger("rarity"));
            cardBagDetailsEntity.setCreateTime(new Date());
            list.add(cardBagDetailsEntity);
        }
        cardBagDetailsService.saveBatch(list);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
//    @RequiresPermissions("generator:cardbag:update")
    public R update(@RequestBody Map<String, Object> params){
        String bagName = params.get("bagName").toString().trim();
        String[] str = params.get("arr").toString().trim().split("-#-");
        String cardBagId = params.get("cardBagId").toString().trim();
        CardBagEntity cardBagEntity = cardBagService.getById(Long.valueOf(cardBagId));
        cardBagEntity.setBagName(bagName);
        cardBagService.updateById(cardBagEntity);
        cardBagDetailsService.remove(new QueryWrapper<CardBagDetailsEntity>().eq("card_bag_id",cardBagId));
        List<CardBagDetailsEntity> list = new ArrayList<>();
        for(String strs : str){
            JSONObject jsonObject = JSONObject.parseObject(strs);
            CardBagDetailsEntity cardBagDetailsEntity = new CardBagDetailsEntity();
            cardBagDetailsEntity.setCardBagId(cardBagEntity.getCardBagId());
            cardBagDetailsEntity.setCardName(jsonObject.getString("cardName"));
            cardBagDetailsEntity.setNumber(jsonObject.getInteger("number"));
            cardBagDetailsEntity.setCrystal(jsonObject.getInteger("crystal"));
            cardBagDetailsEntity.setCardId(jsonObject.getLong("cardId"));
            cardBagDetailsEntity.setRarity(jsonObject.getInteger("rarity"));
            cardBagDetailsEntity.setCreateTime(new Date());
            list.add(cardBagDetailsEntity);
        }
        cardBagDetailsService.saveBatch(list);

        return R.ok();
    }

}
