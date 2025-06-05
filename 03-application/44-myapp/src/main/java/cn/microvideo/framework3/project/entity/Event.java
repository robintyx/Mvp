package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_hw_event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_event_id")
    private Integer event_id;

    @Column(name = "f_vc_car_client")
    private String car_client;

    @Column(name = "f_vc_issue")
    private String issue;

    @Column(name = "f_int_line_id")
    private Integer line_id;

    @Column(name = "f_int_camera_id")
    private Integer camera_id;

    private String line_name;
    private String camera_name;
}