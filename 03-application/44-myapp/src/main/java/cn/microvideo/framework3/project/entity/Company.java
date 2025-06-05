package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_hw_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_company_id")
    private Integer company_id;
    @Column(name = "f_vc_company_name")
    private String company_name;
}