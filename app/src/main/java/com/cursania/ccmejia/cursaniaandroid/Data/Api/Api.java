package com.cursania.ccmejia.cursaniaandroid.Data.Api;

public class Api {

    //private static final String BASE_URL = "http://fundacionnuevafiladelphia.org/ApiAndroid/public/api/";
    private static final String BASE_URL = "http://10.200.21.50:8080/api/public/api/";

    public static ApiRoutes getApi(){
        return RetrofitClient.getClient(BASE_URL).create(ApiRoutes.class);
    }

}
