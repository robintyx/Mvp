package cn.microvideo.framework3.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_hw_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_user_id")
    private Integer id;
    @Column(name = "f_vc_username")
    private String username;
    @Column(name = "f_vc_password")
    private String password;
    @JsonIgnore
    @Column(name = "f_dt_data_create_time")
    private String createTime;
    @JsonIgnore
    @Column(name = "f_dt_data_update_time")
    private String updateTime;
    @JsonIgnore
    @Column(name = "f_int_data_del_flag")
    private Integer delFlag;
    @JsonIgnore
    @Column(name = "f_int_version")
    private Integer version;
}