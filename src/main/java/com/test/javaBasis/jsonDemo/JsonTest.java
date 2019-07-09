package com.test.javaBasis.jsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.sql.Timestamp;

public class JsonTest {

    @Test
    public void test(){

        String jsonStr = "{" +
                "\"list\": [" +
                "{" +
                "\"template\": \"10001\"," +
                "\"taskid\": \"0000021231231\"," +
                "\"sendto\": \"15058160265\"," +
                "\"create_time\": \"2018-12-06 09:30:10\"," +
                "\"info\": {" +
                "\"SYSDATE\":\"2018-12-14\"" +
                "}" +
                "}" +
                "]" +
                "}";

        //字符串转换json
        JSONObject obj = JSON.parseObject(jsonStr);
        //json获取集合元素方法1
        JSONArray list = obj.getJSONArray("list");
        //json获取集合元素方法2
        String listStr = obj.getString("list");
        JSONArray list2= JSON.parseArray(listStr);


        JSONObject obj1 = (JSONObject) list.get(0);
        //json获取其他类型元素
        String taskId = obj1.getString("taskid");
        Long endto = obj1.getLong("sendto");
        JSONObject info = obj1.getJSONObject("info");
        Timestamp time = obj1.getTimestamp("create_time");

        System.out.println(time);

    }

}
