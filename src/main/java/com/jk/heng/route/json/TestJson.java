package com.jk.heng.route.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestJson {

    // https://www.cnblogs.com/QQParadise/articles/5558816.html


    public static void main(String [] args){

        jsonTx();



        getJson();
    }


    // 第一种解析
    public static void jsonTx(){
        String json = "{'status':200,'message':'查询成功','data':[{'id':1,'name':'name1','describe':'第一条数据'}]}";

        JSONObject jsonObject = JSONObject.fromObject(json);
        int status = jsonObject.optInt("status");

        System.out.println("status:"+status);

        JSONArray data = jsonObject.getJSONArray("data");
        JSONArray data1 = jsonObject.optJSONArray("data");

        System.out.println("data :\n"+data);
        System.out.println("data1 :\n"+data1);

        for(Object obj : data){

            String str = obj.toString();

            System.out.println(str);

            JSONObject data2 = JSONObject.fromObject(str);

            System.out.println(data2.getString("id"));
            System.out.println(data2.getString("name"));
            System.out.println(data2.getString("describe"));
        }


        System.out.println("\n\n\n");
    }

    //第二种
    public static void getJson() {
        String json = "{'response':{'data':[{'address':'北京','province':'海淀','district':'西三旗','city':'地铁'}]},'status':'ok'}";
        String json1 = "[{\"TaskID\":3,\"Mobile\":\"13789679619\",\"Status\":5,\"ReportTime\":\"2015-06-24T15:52:54.73\",\"ReportCode\":\"S:终止\"},{\"TaskID\":4,\"Mobile\":\"13789679618\",\"Status\":4,\"ReportTime\":\"2015-06-24T16:32:35.583\",\"ReportCode\":\"成功\"}]";

        String string = "[{\"depid\":\"5\",\"score\":\"10\"},{\"depid\":\"4\",\"score\":\"40\"},{\"depid\":\"4\",\"score\":\"30\"},{\"depid\":\"5\",\"score\":\"30\"}]";

        JSONArray jsonArray11 = new JSONArray();
        JSONObject jsonObject = JSONObject.fromObject(json);
        String status = jsonObject.getString("status");
// System.out.println(str);
        String response = jsonObject.getString("response");
        JSONObject jsonObject2 = JSONObject.fromObject(response);
        JSONArray data = jsonObject2.getJSONArray("data");
        for(int i=0;i<data.size();i++){
            String s = data.getString(i);
            JSONObject data2 = JSONObject.fromObject(s);
            System.out.println(data2.getString("address"));
            System.out.println(data2.getString("province"));
            System.out.println(data2.getString("district"));
            System.out.println(data2.getString("city"));
        }

//解析第二个
        JSONArray jsonObject1 = JSONArray.fromObject(json1);
        for(int i=0;i<jsonObject1.size();i++){
            String s = jsonObject1.getString(i);
            JSONObject data2 = JSONObject.fromObject(s);
            System.out.println(data2.getString("TaskID"));
            System.out.println(data2.getString("Mobile"));
            System.out.println(data2.getString("Status"));
            System.out.println(data2.getString("ReportTime"));
            System.out.println(jsonArray11.size());
        }
        System.out.println("*******************");

    //解析第三个
        JSONArray fromObject = JSONArray.fromObject(string);
        Map<String,Integer> map = new HashMap<String, Integer>();

        for (Object object : fromObject)
        {
            JSONObject jsonObject3 = (JSONObject) object;
            String depid = (String)jsonObject3.get("depid");
            Integer score = Integer.valueOf((String)jsonObject3.get("score"));
            if (map.containsKey(depid))
            {
                int integer = map.get(depid);
                map.put(depid, integer+score);
            }
            else
            {
                map.put(depid, score);
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<String, Integer> entry : entrySet)
        {
            JSONObject jsonObject4 = new JSONObject();
            jsonObject4.put("depid",entry.getKey());
            jsonObject4.put("score",String.valueOf(entry.getValue()));
            jsonArray.add(jsonObject4);
        }
        System.out.println(jsonArray.toString());
    }
}
