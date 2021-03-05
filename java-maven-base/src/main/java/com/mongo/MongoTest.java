package com.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

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
 * 2020年6月22日 下午2:19:20
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
     * 初始化连接数据库
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
     * 查询集合中所有文档
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
     * 1、创建文档 org.bson.Document 参数为key-value的格式；
     * 2、创建文档集合List<Document>；
     * 3、将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>)；
     * 4、插入单个文档可以用mongoCollection.insertOne(Document)；
     */
    public void insertDocument() {
        Document doc = new Document("name", "jack").append("sex", 1).append("age", 30).append("hobbies",
                Arrays.toString(new String[]{"游戏", "听音乐"}));
//		ArrayList<Document> documents = new ArrayList<Document>();
//		documents.add(doc);
        MongoCollection<Document> collection = this.mongoDatabase.getCollection(this.collections);
        FindOneAndUpdateOptions updateOptions = new FindOneAndUpdateOptions();
        updateOptions.upsert(true);
        // findOneAndUpdate 查询不到数据再插入数据，避免inset插入重复数据
        collection.findOneAndUpdate(Filters.eq("name", "jack"), new Document("$set", doc), updateOptions);
    }

    /**
     * 更新文档，updateMany 更新多个，updateOne 更新一个；
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
     * 删除文档，deleteOne 删除一个，deleteMany 删除多个
     */
    public void deleteDocument() {
        MongoCollection<Document> collection = this.mongoDatabase.getCollection(this.collections);
        // 删除符合条件的第一个文档
        collection.deleteOne(Filters.eq("name", "jack"));
    }

}
