package com.dingjiajia.mall.search;

import com.alibaba.fastjson.JSON;
import com.dingjiajia.mall.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSearchApplicationTests {


	@Autowired
	private RestHighLevelClient client;


	/**
	 * 测试存储数据到 es
	 * @throws IOException
	 */
	@Test
	public void searchData() throws IOException{
		//1. 创建检索请求
		SearchRequest searchRequest = new SearchRequest();
		// 指定检索
		searchRequest.indices("bank");
		// 指定DSL 检索条件
		// SearchSourceBuilder   sourceBuilder
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

		// 1.1 构造检索条件
		sourceBuilder.query(QueryBuilders.matchQuery("address","mill"));
		System.out.println(searchRequest.toString());
		searchRequest.source(sourceBuilder);


		//2. 执行检索
		SearchResponse searchResponse = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

		//3. 分析结果
		System.out.println(searchResponse);

	}

	/**
	 * 测试存储数据到 es
	 * @throws IOException
	 */
	@Test
	public void indexData() throws IOException {
		IndexRequest indexRequest = new IndexRequest("user");
		indexRequest.id("1");
		// 1.可以直接传入 k - v 键值对
		//indexRequest.source("userName","zhangsan","age",18,"gender","男");
		// 2.传入一个 json 数据
		User user = new User();
		user.setUserName("lisi");
		user.setAge(20);
		user.setGender("女");
		String s = JSON.toJSONString(user);
		indexRequest.source(s, XContentType.JSON);


		// 执行保存操作
		IndexResponse index = client.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

		System.out.println(index);
	}


	@Data
	class User{
		private String userName;
		private String gender;
		private Integer age;
	}


	@Test
	public void contextLoads() {

		System.out.println(client);
	}

}
