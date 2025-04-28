package com.dingjiajia.mall.product;


import com.dingjiajia.mall.product.dao.AttrGroupDao;
import com.dingjiajia.mall.product.entity.BrandEntity;
import com.dingjiajia.mall.product.service.BrandService;


import com.dingjiajia.mall.product.vo.SpuItemAttrGroupVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Test
    public void test2(){
        System.out.println(redissonClient);
    }


    @Test
    public void redisTest(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // 保存数据
        ops.set("hello","world-"+ UUID.randomUUID().toString());
        // 查询数据
        String hello = ops.get("hello");
        System.out.println("redis里保存的数据："+hello);
    }


    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setBrandId(31L);
        brandEntity.setDescript("狗改不了吃屎，何况人");
        /*brandEntity.setName("狗屎吧");
        brandService.save(brandEntity);
        System.out.println("6666");*/

        brandService.updateById(brandEntity);
    }

    @Test
    public void test3(){
        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(13L, 225L);

        System.out.println(attrGroupWithAttrsBySpuId);
    }


}
