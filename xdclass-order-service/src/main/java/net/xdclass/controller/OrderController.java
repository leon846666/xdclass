package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RequestMapping("api/v1/videoOrder")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/save")
    public Object saveOrder(int videoId){
        Video forObject = restTemplate.getForObject("http://localhost:9000/api/v1/video/find?id=" + videoId, Video.class);

        VideoOrder vo  = new VideoOrder();
        vo.setCreateTime(new Date());
        vo.setId(forObject.getId());
        vo.setVideoTitle(forObject.getTitle());
        return vo;

    }
}
