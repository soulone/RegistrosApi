package com.soulone.registrosapi.Interfaces;

import com.soulone.registrosapi.models.Solicitud;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPostsApi {

    @GET("/solicitudes")
    Call<List<Solicitud>> getSolicitudes();

    @POST("/solicitudes")
    Call<Solicitud> createSolicitud(@Body Solicitud solicitud);


}
