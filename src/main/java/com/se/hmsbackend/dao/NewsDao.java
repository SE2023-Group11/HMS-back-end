package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {
    @Select("SELECT * FROM news")
    public List<News> getAllNews();

    @Select("SELECT * FROM news WHERE id=#{id}")
    public News getById(Integer id);

    @Insert("INSERT INTO news (img,body) VALUES (#{img},#{body})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insertNews(News news);

    @Update("UPDATE news SET img=#{img},body=#{body} WHERE id=#{id}")
    public void updateNews(News news);

    @Delete("DELETE FROM news WHERE id=#{id}")
    public void deleteNews(News news);
}
