package net.xdclass.services.fallback;

import net.xdclass.domain.Video;
import net.xdclass.services.VideoFeignclient;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceFallBack implements VideoFeignclient {


    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("熔断降级数据");
        return video;
    }

    @Override
    public int saveOrder(Video video) {
        return 0;
    }
}
