// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Film;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.FilmDAO;
import org.springframework.stereotype.Service;
import com.service.FilmService;

@Service("filmService")
public class FilmServiceImpl implements FilmService
{
    @Autowired
    @Resource
    private FilmDAO filmDAO;
    
    @Override
    public int insertFilm(final Film film) {
        return this.filmDAO.insertFilm(film);
    }
    
    @Override
    public int updateFilm(final Film film) {
        return this.filmDAO.updateFilm(film);
    }
    
    @Override
    public int deleteFilm(final String filmid) {
        return this.filmDAO.deleteFilm(filmid);
    }
    
    @Override
    public List<Film> getAllFilm() {
        return this.filmDAO.getAllFilm();
    }
    
    @Override
    public List<Film> getFilmByHot() {
        return this.filmDAO.getFilmByHot();
    }
    
    @Override
    public List<Film> getFilmByNews() {
        return this.filmDAO.getAllFilm();
    }
    
    @Override
    public List<Film> getFilmByCate(final String cateid) {
        return this.filmDAO.getFilmByCate(cateid);
    }
    
    @Override
    public List<Film> getFilmByCond(final Film film) {
        return this.filmDAO.getFilmByCond(film);
    }
    
    @Override
    public List<Film> getFilmByLike(final Film film) {
        return this.filmDAO.getFilmByLike(film);
    }
    
    @Override
    public Film getFilmById(final String filmid) {
        return this.filmDAO.getFilmById(filmid);
    }
}
