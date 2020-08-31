package com.mongo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;

public class MongoTest {
	public static void main(String[] args) {
		MongoClientInit mongoClient = new MongoClientInit("localhost", 27017, "test", "users");
		mongoClient.init();
		mongoClient.insertDocument();
		mongoClient.updateDocument();
		mongoClient.queryAllData();
	}
}

/**
 * @author chenjun 
 * 2020��6��22�� ����2:19:20
 */
class MongoClientInit {
	public String url;
	public int port;
	public String database;
	public String collections;
	public MongoClient mongoClient;
	public MongoDatabase mongoDatabase;

	public MongoClientInit(String url, int port, String database, String collections) {
		this.collections = collections;
		this.port = port;
		this.url = url;
		this.database = database;
	}

	/**
	 * 	��ʼ���������ݿ�
	 */
	public void init() {
		try {
			this.mongoClient = new MongoClient(this.url, this.port);
			this.mongoDatabase = this.mongoClient.getDatabase(this.database);
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	��ѯ�����������ĵ�
	 */
	public void queryAllData() {
		MongoCollection<Document> collection = this.mongoDatabase.getCollection(this.collections);
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			System.out.println(mongoCursor.next().toJson());
//			System.out.println(mongoCursor.next().getInteger("age"));
		}
	}

	/**
	 * 1�������ĵ� org.bson.Document ����Ϊkey-value�ĸ�ʽ��
	 * 2�������ĵ�����List<Document>��
	 * 3�����ĵ����ϲ������ݿ⼯���� mongoCollection.insertMany(List<Document>)��
	 * 4�����뵥���ĵ�������mongoCollection.insertOne(Document)��
	 */
	public void insertDocument() {
		Document doc = new Document("name", "jack").append("sex", 1).append("age", 30).append("hobbies",
				Arrays.toString(new String[] { "��Ϸ", "������" }));
//		ArrayList<Document> documents = new ArrayList<Document>();
//		documents.add(doc);
		MongoCollection<Document> collection = this.mongoDatabase.getCollection(this.collections);
		FindOneAndUpdateOptions updateOptions = new FindOneAndUpdateOptions();
		updateOptions.upsert(true);
		// findOneAndUpdate ��ѯ���������ٲ������ݣ�����inset�����ظ�����
		collection.findOneAndUpdate(Filters.eq("name", "jack"), new Document("$set", doc), updateOptions);
	}

	/**
	 * 	�����ĵ���updateMany ���¶����updateOne ����һ����
	 */
	public void updateDocument() {
		MongoCollection<Document> collection = this.mongoDatabase.getCollection(this.collections);
		Bson filter = Filters.eq("name", "jack");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 10, 25);
		collection.updateOne(filter, new Document("$set",
				new Document()
						.append("birthDay", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()))
						.append("createTime", calendar.getTime())));
	}

	/**
	 *	 ɾ���ĵ���deleteOne ɾ��һ����deleteMany ɾ�����
	 */
	public void deleteDocument() {
		MongoCollection<Document> collection = this.mongoDatabase.getCollection(this.collections);
		// ɾ�����������ĵ�һ���ĵ�
		collection.deleteOne(Filters.eq("name", "jack"));
	}

}
