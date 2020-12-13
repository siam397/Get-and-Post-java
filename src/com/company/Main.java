package com.company;



import org.json.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {
        ApiCalls apiCalls=new ApiCalls("http://localhost:3000");
        apiCalls.GETAsync("/getValues").thenAccept(Main::work).join();
        Map<String,String> params = new LinkedHashMap<>();
        params.put("name", "Siam Ahmed");
        params.put("email", "fassterthanflash@gmail.com");
        params.put("password", "123");
        params.put("message", "testingApi");
        apiCalls.post("/newId",params);
    }

    private static void work(Object o) {
        String s=o.toString();
        JSONObject jsonObject=new JSONObject(s);
        System.out.println(jsonObject.get("name"));
    }

}


