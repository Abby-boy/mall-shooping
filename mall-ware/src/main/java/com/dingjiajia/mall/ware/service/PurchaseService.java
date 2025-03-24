package com.dingjiajia.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.mall.ware.entity.PurchaseEntity;
import com.dingjiajia.mall.ware.vo.MergeVo;
import com.dingjiajia.mall.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购单
 *
 * @author ding
 * @email 2278797260@qq.com
 * @date 2025-03-16 18:15:51
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);
}

