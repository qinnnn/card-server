package com.xxoocode.card.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.CardBagEntity;
import com.xxoocode.card.entity.CardEntity;
import com.xxoocode.card.entity.UserCardEntity;
import com.xxoocode.card.service.CardBagService;
import com.xxoocode.card.service.CardService;
import com.xxoocode.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CardBagController {
    @Autowired
    private CardBagService cardBagService;
    @Autowired
    private CardService cardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:cardbag:list")
    public R list(@RequestParam Map<String, Object> params){
        String page = params.get("page").toString().trim();
        String limit = params.get("limit").toString().trim();

        List<CardBagEntity> cardBagList = cardBagService.list(new QueryWrapper<CardBagEntity>());

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
    @RequiresPermissions("generator:cardbag:save")
    public R save(@RequestBody CardBagEntity cardBag){
			cardBagService.save(cardBag);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:cardbag:update")
    public R update(@RequestBody CardBagEntity cardBag){
			cardBagService.updateById(cardBag);

        return R.ok();
    }

}
