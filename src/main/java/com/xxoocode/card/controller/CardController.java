package com.xxoocode.card.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.CardEntity;
import com.xxoocode.card.entity.UserCardEntity;
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
 * 卡牌表
 *
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@RestController
@RequestMapping("card")
public class CardController extends AbstractController {
    @Autowired
    private CardService cardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("generator:card:list")
    public R list(@RequestParam Map<String, Object> params){
        List<CardEntity> page = cardService.list(new QueryWrapper<CardEntity>());

        return R.ok().put("list", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cardId}")
    @RequiresPermissions("generator:card:info")
    public R info(@PathVariable("cardId") Long cardId){
			CardEntity card = cardService.getById(cardId);

        return R.ok().put("card", card);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("generator:card:save")
    public R save(@RequestBody CardEntity card){
        card.setCreateTime(new Date());
			cardService.save(card);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:card:update")
    public R update(@RequestBody CardEntity card){
			cardService.updateById(card);

        return R.ok();
    }


}
