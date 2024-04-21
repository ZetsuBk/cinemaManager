package com.example.cinema.dto;



import java.util.Date;
import java.util.List;
import com.example.cinema.entity.Film;
import org.springframework.data.rest.core.config.Projection;



@Projection(name = "inlineFilm", types = { Film.class })
public interface InlineFilm {
    Long getId();

}

