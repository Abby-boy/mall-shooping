package com.dingjiajia.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.dingjiajia.mall.product.dao.BrandDao;
import com.dingjiajia.mall.product.dao.CategoryDao;
import com.dingjiajia.mall.product.entity.BrandEntity;
import com.dingjiajia.mall.product.entity.CategoryEntity;
import com.dingjiajia.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiajia.common.utils.PageUtils;
import com.dingjiajia.common.utils.Query;

import com.dingjiajia.mall.product.dao.CategoryBrandRelationDao;
import com.dingjiajia.mall.product.entity.CategoryBrandRelationEntity;
import com.dingjiajia.mall.product.service.CategoryBrandRelationService;
import org.springframework.util.CollectionUtils;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Autowired
    BrandDao brandDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryBrandRelationDao relationDao;

    @Autowired
    BrandService brandService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();
        //1、查询详细名字
        BrandEntity brandEntity = brandDao.selectById(brandId);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);

        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());

        this.save(categoryBrandRelation);

    }

    @Override
    public void updateBrand(Long brandId, String name) {
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        relationEntity.setBrandId(brandId);
        relationEntity.setBrandName(name);
        this.update(relationEntity,new UpdateWrapper<CategoryBrandRelationEntity>().eq("brand_id",brandId));

    }

    @Override
    public void updateCategory(Long catId, String name) {
        this.baseMapper.updateCategory(catId,name);
    }

    /**
     *
     * @param catId
     * @return
     *
     * 根据三级分类ID查询所有品牌
     * 但是封装了品牌的所有信息，为了该service方法重用
     */
    @Override
    public List<BrandEntity> getBrandsByCatId(Long catId) {
        // 查询分类关联的所有品牌
        List<CategoryBrandRelationEntity> relationEntities = relationDao.
                selectList(new QueryWrapper<CategoryBrandRelationEntity>().eq("catelog_id", catId));
        if (!CollectionUtils.isEmpty(relationEntities)) {
            // 封装品牌IDs
            List<Long> brandIds = relationEntities.stream().map(relation -> relation.getBrandId()).collect(Collectors.toList());
            List<BrandEntity> brands = brandDao.selectBatchIds(brandIds);
            return brands;
        }
        return new ArrayList<>();
    }

}