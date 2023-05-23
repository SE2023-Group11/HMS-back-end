package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.NewsDao;
import com.se.hmsbackend.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public News getById(Integer id){
        return newsDao.getById(id);
    }
    public List<News> getAllNews(){
        return newsDao.getAllNews();
    }
    public boolean addNews(News news){
        try{
            newsDao.insertNews(news);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean deleteNews(News news){
        try{
            newsDao.deleteNews(news);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
