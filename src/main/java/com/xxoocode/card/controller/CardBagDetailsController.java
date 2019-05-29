package com.xxoocode.card.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.CardBagDetailsEntity;
import com.xxoocode.card.entity.UserCardEntity;
import com.xxoocode.card.service.CardBagDetailsService;
import com.xxoocode.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 卡包详情表
 *
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@RestController
@RequestMapping("cardbagdetails")
public class CardBagDetailsController {
    @Autowired
    private CardBagDetailsService cardBagDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:cardbagdetails:list")
    public R list(@RequestParam Map<String, Object> params){
        List<CardBagDetailsEntity> page = cardBagDetailsService.list(new QueryWrapper<CardBagDetailsEntity>());

        return R.ok().put("list", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cardBagDetailsId}")
    @RequiresPermissions("generator:cardbagdetails:info")
    public R info(@PathVariable("cardBagDetailsId") Long cardBagDetailsId){
			CardBagDetailsEntity cardBagDetails = cardBagDetailsService.getById(cardBagDetailsId);

        return R.ok().put("cardBagDetails", cardBagDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:cardbagdetails:save")
    public R save(@RequestBody CardBagDetailsEntity cardBagDetails){
			cardBagDetailsService.save(cardBagDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:cardbagdetails:update")
    public R update(@RequestBody CardBagDetailsEntity cardBagDetails){
			cardBagDetailsService.updateById(cardBagDetails);

        return R.ok();
    }

}
