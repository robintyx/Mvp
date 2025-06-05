package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_section_id")
    private Integer section_id;
    @Column(name = "f_vc_section_name")
    private String section_name;
}