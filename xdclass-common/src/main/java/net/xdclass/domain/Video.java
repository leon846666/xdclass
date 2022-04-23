package net.xdclass.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Video {
    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer price;
    private Date createTime;
    private Double point;
    private String serverInfo;
}
