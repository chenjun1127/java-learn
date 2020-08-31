
package com.springboot.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;
import com.springboot.study.entity.Book;

@Repository
public class BookService {

	private final String INDEX = "bookdata";
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private RestHighLevelClient restHighLevelClient;

	/**    
	 * @Description: 插入（新增）
	 * @param: @param book
	 * @param: @return      
	 * @return: Book      
	 * @throws   
	 */
	public Book insertBook(Book book) {
		book.setId(UUID.randomUUID().toString());
		// bean对象转换为map;
		Map<String, Object> dataMap = mapper.convertValue(book, new TypeReference<Map<String, Object>>() {});
		IndexRequest indexRequest = new IndexRequest(INDEX).id(book.getId()).source(dataMap);
		try {
			IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
			System.out.println(response);
		} catch (ElasticsearchException e) {
			e.getDetailedMessage();
		} catch (java.io.IOException ex) {
			ex.getLocalizedMessage();
		}
		return book;
	}

	/**    
	 * @Description: 根据ID查询
	 * @param: @param id
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws   
	 */
	public Map<String, Object> getBookById(String id) {
		// 获取文档
		GetRequest getRequest = new GetRequest(INDEX, id);
		GetResponse getResponse = null;
		try {
			getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
			boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
			if (!exists) {
				return null;
			}
			System.out.println(getResponse);
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
		return sourceAsMap;
	}

	/**    
	 * @Description: 根据ID更新，参数为JSON对象
	 * @param: @param book
	 * @param: @param id
	 * @param: @return      
	 * @return: Book      
	 * @throws   
	 */
	public Book updateBookById(Book book, String id) {
		UpdateRequest updateRequest = new UpdateRequest(INDEX, id);
		GetRequest getRequest = new GetRequest(INDEX, id);
		// 对没有的字段添加, 对已有的字段替换
		try {
			boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
			if (exists) {
				updateRequest.doc(XContentFactory.jsonBuilder().startObject().field("author", book.getAuthor())
						.field("title", book.getTitle()).field("price", book.getPrice()).endObject());
				UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
				System.out.println(updateResponse);
			} else {
				return null;
			}

		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		return book;
	}

	/**
	 * @Description: 根据ID删除 
	 * @param: @param id 
	 * @return: void 
	 * @throws
	 */
	public void deleteBookById(String id) {
		DeleteRequest deleteRequest = new DeleteRequest(INDEX, id);
		try {
			DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
			System.out.println(deleteResponse);
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
	}

	/**
	 * @Description: 搜索
	 * @param: @param title 
	 * @param: @return 
	 * @return: ArrayList<Map<String,Object>> 
	 * @throws
	 */
	public Map<String, Object> search(String title, int index, int size) {
		Map<String, Object> map = new HashMap<String, Object>();
		SearchRequest searchRequest = new SearchRequest(INDEX);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		if (!StringUtils.isNullOrEmpty(title)) {
			searchSourceBuilder.query(QueryBuilders.termQuery("title", title));
		} else {
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		}
		searchSourceBuilder.sort(new FieldSortBuilder("price").order(SortOrder.DESC));
		// 强制精准的计算,否则大于10000就只返回最大的10000条
		searchSourceBuilder.trackTotalHits(true);
		int start = (index-1) * size;
		searchSourceBuilder.from(start);
		searchSourceBuilder.size(size);
		searchRequest.source(searchSourceBuilder);
		SearchResponse searchResponse = null;
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			SearchHits hits = searchResponse.getHits();
			int total = (int) hits.getTotalHits().value;
			map.clear();
			map.put("total", total);
			for (SearchHit hit : hits) {
				Map<String, Object> tempSource = hit.getSourceAsMap();
				list.add(tempSource);
			}
			map.put("list", list);
			return map;
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		return null;
	}
}