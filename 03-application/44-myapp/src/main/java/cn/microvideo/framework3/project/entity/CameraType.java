package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_hw_camera_type")
public class CameraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_type_id")
    private Integer type_id;
    @Column(name = "f_vc_type_name")
    private String type_name;
}
