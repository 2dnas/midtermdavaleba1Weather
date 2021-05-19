package com.example.sandro_shanshiashvili_davaleba_1;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class Controller {

    @GET
    @Path("/weather")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getWeathers() {
        List<Weather> weatherList=new ArrayList<>();
        weatherList.add(new Weather(DirectionType.EAST,20,"Tbilisi",70,20,15));
        weatherList.add(new Weather(DirectionType.WEST,20,"Batumi",72,25,11));
        weatherList.add(new Weather(DirectionType.EAST,20,"Kutaisi",71,22,12));
        return weatherList;
    }

    @GET
    @Path("/weather/{cityName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeatherByCity(@PathParam("cityName") String cityName) {
        List<Weather> weatherList=new ArrayList<>();
        weatherList.add(new Weather(DirectionType.EAST,20,"Tbilisi",70,20,15));
        weatherList.add(new Weather(DirectionType.WEST,20,"Batumi",72,25,11));
        weatherList.add(new Weather(DirectionType.EAST,20,"Kutaisi",71,22,12));
        for (int i = 0; i < weatherList.size() ; i++){
            if(weatherList.get(i).getCityName().equals(cityName)){
                return weatherList.get(i);
            }
        }
        return null;
    }
}
