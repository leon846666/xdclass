package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("api/v1/video")
@RestController
public class VideoController {


    @Autowired
    private VideoService videoService;


    @RequestMapping("find")
    public Object findById(int id, HttpServletRequest request){
        Video video = videoService.findById(id);
        // to see which instance is using
        video.setServerInfo(request.getServerName()+":"+request.getServerPort());
        return video;
    }

}
