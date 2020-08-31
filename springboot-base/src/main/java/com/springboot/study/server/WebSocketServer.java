package com.springboot.study.server;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;

/**
 * @Description: TODO
 * @author: chenjun
 * @date: 2020年7月8日 下午2:59:41
 */
@Component
@ServerEndpoint("/endpoint/{userId}")
public class WebSocketServer {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
	/** 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。 */
	public static int onlineCount = 0;
	/** concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。 */
	private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
	/** 与某个客户端的连接会话，需要通过它来给客户端发送数据 */
	private Session session;
	/** 接收userId */
	private String userId = "";

	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId) {
		this.session = session;
		this.userId = userId;
		if (webSocketMap.containsKey(userId)) {
			webSocketMap.remove(userId);
			webSocketMap.put(userId, this);
		} else {
			webSocketMap.put(userId, this);
			addOnlineCount();
		}
		logger.info("用户连接:" + userId + ",当前在线人数为:" + getOnlineCount());
		try {
			sendMessage("连接成功");
		} catch (IOException e) {
			logger.error("用户:" + userId + ",网络异常!!!!!!");
		}
	}

	@OnClose
	public void onClose() {
		if (webSocketMap.containsKey(userId)) {
			webSocketMap.remove(userId);
			// 从set中删除
			subOnlineCount();
		}
		logger.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		logger.info("用户消息:" + userId + ",报文:" + message);
		if (!StringUtil.isNullOrEmpty(message)) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				Map<String, Object> jsonMap = objectMapper.readValue(message, new TypeReference<Map<String, Object>>() {
				});
				System.out.println(jsonMap);
				jsonMap.put("fromUserId", userId);
//				String toUserId = (String) jsonMap.get("toUserId");
//				System.out.println(toUserId);
//				if (!StringUtil.isNullOrEmpty(toUserId) && webSocketMap.contains(toUserId)) {
//					logger.info(jsonMap.toString());
//					webSocketMap.get(toUserId).sendMessage(jsonMap.toString());
//				}
				/* 收到客户端的消息，给以回应，此处可以自己写逻辑 */
				webSocketMap.get(userId).sendMessage(jsonMap.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@OnError
	public void onError(Session session, Throwable error) {
		logger.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
		error.printStackTrace();
	}

	/**
	 * 实现服务器主动推送
	 */
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	/**
	 * 发送自定义消息
	 */
	public static void sendInfo(String message, @PathParam("userId") String userId) throws IOException {
		logger.info("发送消息到:" + userId + "，报文:" + message);
		if (!StringUtil.isNullOrEmpty(userId) && webSocketMap.containsKey(userId)) {
			webSocketMap.get(userId).sendMessage(message);
		} else {
			logger.error("用户" + userId + ",不在线！");
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}

}
