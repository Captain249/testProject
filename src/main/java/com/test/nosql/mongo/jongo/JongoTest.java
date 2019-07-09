package com.test.nosql.mongo.jongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.test.nosql.mongo.jongo.vo.User;
import org.apache.log4j.Logger;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

public class JongoTest {
    private static Logger logger = Logger.getLogger(JongoTest.class);

    public static void main(String[] args) {
        MongoClient mongo = null;
        try {
            DB db = new MongoClient("192.168.1.129",27017).getDB("test");
            Jongo jongo = new Jongo(db);
            MongoCollection collection = jongo.getCollection("test");

            MongoCursor<User> all = collection.find("{name: '孙志涛'}").as(User.class);
            while(all.hasNext()){
                User user = all.next();
                logger.info(user.toString());
            }
            /*User one = collection.findOne("{name: '孙志涛'}").as(User.class);
            logger.info(one.toString());

            Iterator<User> all = (Iterator<User>) collection.find().as(User.class);
            while(all.hasNext()) {
                User user = all.next();
                logger.info(user.toString());
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
