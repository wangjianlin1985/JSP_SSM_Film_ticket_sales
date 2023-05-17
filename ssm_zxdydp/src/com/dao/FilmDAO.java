// 
// 
// 

package com.dao;

import java.util.List;
import com.entity.Film;
import org.springframework.stereotype.Repository;

@Repository("filmDAO")
public interface FilmDAO
{
    int insertFilm(Film p0);
    
    int updateFilm(Film p0);
    
    int deleteFilm(String p0);
    
    List<Film> getAllFilm();
    
    List<Film> getFilmByHot();
    
    List<Film> getFilmByNews();
    
    List<Film> getFilmByCate(String p0);
    
    List<Film> getFilmByCond(Film p0);
    
    List<Film> getFilmByLike(Film p0);
    
    Film getFilmById(String p0);
}
