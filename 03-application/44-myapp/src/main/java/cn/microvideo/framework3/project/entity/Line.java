package cn.microvideo.framework3.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "t_hw_line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_line_id")
    private Integer line_id;

    @Column(name = "f_vc_line_name")
    private String line_name;

    @JsonIgnore
    private String coordinates;
    @JsonIgnore
    @Transient
    private String wkt;

    @Column(name = "f_geom_line_spatial_data", columnDefinition = "geometry")
    private List<List<Double>> line_spatial_data;

    @Column(name = "f_int_company_id")
    private Integer company_id;

    @Column(name = "f_int_section_id")
    private Integer section_id;

    @Column(name = "f_int_status")
    private Integer status;

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

    private String company_name;
    private String section_name;

}
