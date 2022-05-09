package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import net.xdclass.services.VideoFeignclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequestMapping("api/v1/videoOrder")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private VideoFeignclient videoFeignclient;

    @RequestMapping("/findById")
    public Object findById(int videoId) {
        // Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find?id=" + videoId, Video.class);
        //List<ServiceInstance> list = discoveryClient.getInstances("xdclass-video-service");
        //ServiceInstance serviceInstance = list.get(0);
        //Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/find?id=" + videoId, Video.class);
        Video video = videoFeignclient.findById(videoId);

        VideoOrder vo = new VideoOrder();
        vo.setCreateTime(new Date());
        vo.setId(video.getId());
        vo.setVideoTitle(video.getTitle());
        vo.setServerInfo(video.getServerInfo());
        return vo;
    }

    @RequestMapping("/saveOrder")
    public Object saveOrder(@RequestBody Video video) {

        return videoFeignclient.saveOrder(video);
    }

    @RequestMapping("list")
    public Object list(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String,String> map  = new HashMap<>();
        map.put("title1","AlibabaCloud微服务sentinel");
        map.put("title2","Sentinel by Thread");
        return map;
    }
}
