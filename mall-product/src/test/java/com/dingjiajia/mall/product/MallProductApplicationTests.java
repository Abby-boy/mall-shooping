package com.dingjiajia.mall.product;


import com.dingjiajia.mall.product.entity.BrandEntity;
import com.dingjiajia.mall.product.service.BrandService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;


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


}
