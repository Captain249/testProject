package com.test.nosql.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MongoDBJDBC {
    private Logger logger = Logger.getLogger(MongoDBJDBC.class);
    // 连接到  database:test collection:test
    private MongoClient mongoClient = new MongoClient( "192.168.1.129" , 27017 );
    private MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
    private MongoCollection<Document> collection = mongoDatabase.getCollection("test");

    @Test
    public void insertDocument(){
        //插入文档集
        Document document = new Document("name", "孙志涛").append("age", 18).append("gender", "男");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        logger.info("文档插入成功");
    }

    @Test
    public void selectAllDocument(){
        //检索所有文档 迭代器FindIterable<Document> 游标MongoCursor<Document>
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            logger.info(mongoCursor.next());
        }
    }

    @Test
    public void updateDocumentByName(){
        //更新文档   将文档中likes=100的文档修改为likes=200
        collection.updateMany(Filters.eq("name", "孙志涛"), new Document("$set",new Document("age",200)));
    }

    @Test
    public void deleteDocumentByName(){
        //删除符合条件的第一个文档
        //collection.deleteOne(Filters.eq("name", "孙志涛"));
        //删除所有符合条件的文档
        collection.deleteMany (Filters.eq("gender", "男"));
    }
}
