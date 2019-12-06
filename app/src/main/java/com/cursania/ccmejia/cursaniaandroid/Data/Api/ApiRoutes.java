package com.cursania.ccmejia.cursaniaandroid.Data.Api;

import com.cursania.ccmejia.cursaniaandroid.Data.Model.Cuarto;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.LoginBody;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.Profesor;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.ServerResponse;
import com.cursania.ccmejia.cursaniaandroid.Data.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiRoutes {

  String BASE_URL_IMAGES = "http://10.200.21.50:8080/api/public/";

  @POST("login2")
  Call<User> login(@Body LoginBody loginBody);

  @POST("register2")
  Call<User> registrar(@Body User user);

  @GET("cuarto")
  Call<List<Cuarto>> getCuartos();

  /**@GET("curso/{id}")
  Call<Curso> getCurso(@Path("id") int id);

  @GET("categorias")
  Call<List<Categoria>> getCategorias();

  @GET("categoria/cursos/{id}")
  Call<List<Curso>> getCategoriaDetalle(@Path("id") int id);

  @GET("profesores")
  Call<List<Profesor>> getProfesores();

  @GET("profesor/cursos/{id}")
  Call<List<Curso>> getProfesorDetalle(@Path("id") int id);

  @GET("user/{id}")
  Call<User> getUser(@Path("id") int id);

  @POST("user/edit")
  Call<User> editar(@Body User user);

  @POST("user/curso/{user_id}/{curso_id}")
  Call<ServerResponse> agregarCurso(@Path("user_id") int user_id, @Path("curso_id") int curso_id);

  @GET("curso/user/{id}")
  Call<List<Curso>> getCursosUser(@Path("id") int id);**/
}
