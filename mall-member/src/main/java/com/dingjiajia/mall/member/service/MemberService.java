package com.dingjiajia.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 17:57:05
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

