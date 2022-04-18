package net.xdclass.controller;

import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/video")
@RestController
public class VideoController {


    @Autowired
    private VideoService videoService;


    @RequestMapping("find")
    public Object findById(int id){
        return videoService.findById(id);
    }

}
