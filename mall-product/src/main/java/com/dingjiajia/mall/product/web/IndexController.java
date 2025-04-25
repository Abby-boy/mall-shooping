package com.dingjiajia.mall.product.web;


import com.dingjiajia.mall.product.entity.CategoryEntity;
import com.dingjiajia.mall.product.service.CategoryService;
import com.dingjiajia.mall.product.vo.Catelog2Vo;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    RedissonClient redisson;

    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){

        System.out.println(""+Thread.currentThread().getId());
        //TODO 1、查出所有的1级分类
        List<CategoryEntity> categoryEntities =  categoryService.getLevel1Categorys();

        // 视图解析器进行拼串：
        // classpath:/templates/ +返回值+  .html
        model.addAttribute("categorys",categoryEntities);
        return "index";
    }


    //index/catalog.json
    @ResponseBody
    @GetMapping("/index/json/catalog.json")
    public Map<String, List<Catelog2Vo>> getCatalogJson(){
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }



    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        //1.获取一把锁，只要锁的名字一样，就是同一把锁
        RLock lock = redisson.getLock("my-lock");
        //2.加锁   解锁
        lock.lock();      //阻塞式等待，默认加的所都是 30s 时间
        // 1）.锁定自动续期，如果业务超长，运行期间自动给锁续上新的 30s 不用担心业务时间长，锁自动过期被删除
        // 2）.加锁的业务只要运行完成，就不会给当前锁 续期，即使不动手解锁，锁默认在 30s 以后自动删除
        //lock.lock(10, TimeUnit.SECONDS);   // 10s 自动解锁，自动解锁时间一定大于业务的执行时间
        // 问题： lock.lock(10, TimeUnit.SECONDS); 在锁到时间了以后，不会自动续期
        // 1.如果我们传递了锁的超时时间，
        try {

            System.out.println("加锁成功---"+Thread.currentThread().getId());
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("解锁成功---"+Thread.currentThread().getId());
            lock.unlock();
        }
        return "hello";
    }
}
