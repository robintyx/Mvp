package cn.microvideo.framework3.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_hw_stake")
public class Stake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_int_stake_id")
    private Integer stake_id;

    @Column(name = "f_vc_stake_name")
    private String stake_name;

    @Column(name = "f_int_line_id")
    private Integer line_id;

    private String line_name;
}