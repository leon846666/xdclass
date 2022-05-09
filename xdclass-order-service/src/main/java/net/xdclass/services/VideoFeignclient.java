package net.xdclass.services;


import net.xdclass.domain.Video;
import net.xdclass.services.fallback.VideoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "xdclass-video-service",fallback = VideoServiceFallBack.class)
public interface VideoFeignclient {


    @GetMapping("/api/v1/video/find")
    Video findById(@RequestParam("id" ) int videoId);

    @PostMapping("/api/v1/video/saveOrder")
    int saveOrder(@RequestBody Video video);
}
