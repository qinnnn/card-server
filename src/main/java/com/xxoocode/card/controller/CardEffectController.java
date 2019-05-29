package com.xxoocode.card.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxoocode.card.entity.CardEffectEntity;
import com.xxoocode.card.entity.UserCardEntity;
import com.xxoocode.card.service.CardEffectService;
import com.xxoocode.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 卡牌效果表
 *
 * @author zhuanghaoqin
 * @email zzz
 * @date 2019-05-29 15:33:38
 */
@RestController
@RequestMapping("cardeffect")
public class CardEffectController {
    @Autowired
    private CardEffectService cardEffectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:cardeffect:list")
    public R list(@RequestParam Map<String, Object> params){
        List<CardEffectEntity> page = cardEffectService.list(new QueryWrapper<CardEffectEntity>());

        return R.ok().put("list", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{effectId}")
    @RequiresPermissions("generator:cardeffect:info")
    public R info(@PathVariable("effectId") Long effectId){
			CardEffectEntity cardEffect = cardEffectService.getById(effectId);

        return R.ok().put("cardEffect", cardEffect);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:cardeffect:save")
    public R save(@RequestBody CardEffectEntity cardEffect){
			cardEffectService.save(cardEffect);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:cardeffect:update")
    public R update(@RequestBody CardEffectEntity cardEffect){
			cardEffectService.updateById(cardEffect);

        return R.ok();
    }

}
