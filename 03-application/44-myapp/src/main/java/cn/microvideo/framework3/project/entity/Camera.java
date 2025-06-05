package cn.microvideo.framework3.project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_hw_camera")
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_camera_id")
    private Integer camera_id;
    @Column(name = "f_vc_camera_name")
    private String camera_name;
    @Column(name = "f_dl_longitude")
    private Double longitude;
    @Column(name = "f_dl_latitude")
    private Double latitude;
    @Column(name = "f_int_direction")
    private Integer direction;
    @Column(name = "f_vc_video_url")
    private String video_url;
    @Column(name = "f_int_status")
    private Integer status;
    @Column(name = "f_int_line_id")
    private Integer line_id;
    @Column(name = "f_int_type_id")
    private Integer type_id;
    @Column(name = "f_int_stake_id")
    private Integer stake_id;
    @JsonIgnore
    @Column(name = "f_dt_data_create_time")
    private String create_time;
    @JsonIgnore
    @Column(name = "f_dt_data_update_time")
    private String update_time;
    @JsonIgnore
    @Column(name = "f_int_data_del_flag")
    private Integer del_flag;
    @JsonIgnore
    @Column(name = "f_int_version")
    private Integer version;

    private String type_name;
    private String line_name;
    private String stake_name;

}
