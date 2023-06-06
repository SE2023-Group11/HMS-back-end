package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.News;
import com.se.hmsbackend.service.NewsService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NewsConrtoller {
    @Autowired
    private NewsService newsService;

    @PostMapping("/getAllNews")
    public R<List<News>> getAllNews(){
        List<News> news = newsService.getAllNews();
        return R.success(news);
    }
    @PostMapping("/addNews")
    public R<News> addNews(@RequestBody News news){
        if(newsService.addNews(news))return R.success(news);
        return R.error("添加失败");
    }
    @DeleteMapping("/deleteNews")
    public R<String> deleteNews(@RequestBody Map params){
        List<Integer> ids = null;
        try {
            ids = (List<Integer>) params.get("id");
        }catch (Exception e){
            return R.error("参数错误: "+e.getMessage());
        }
        for(Integer id : ids) {
           News news = newsService.getById(id);
           newsService.deleteNews(news);
        }
        return R.success("删除成功");
    }
}
