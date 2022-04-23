package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RequestMapping("api/v1/videoOrder")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/save")
    public Object saveOrder(int videoId) {
        // Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find?id=" + videoId, Video.class);
        //List<ServiceInstance> list = discoveryClient.getInstances("xdclass-video-service");
        //ServiceInstance serviceInstance = list.get(0);
        Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/find?id=" + videoId, Video.class);


        VideoOrder vo = new VideoOrder();
        vo.setCreateTime(new Date());
        vo.setId(video.getId());
        vo.setVideoTitle(video.getTitle());
        vo.setServerInfo(video.getServerInfo());
        return vo;

    }
}
