package net.xdclass.domain;

import lombok.Data;

import java.util.Date;

@Data
public class VideoOrder {
    private Integer id;
    private String outTradeNo;
    private Integer state;
    private Date createTime;
    private Integer totalFee;
    private Integer videoId;
    private String videoTitle;
    private String videoImg;
    private Integer userId;
    private String serverInfo;
}
