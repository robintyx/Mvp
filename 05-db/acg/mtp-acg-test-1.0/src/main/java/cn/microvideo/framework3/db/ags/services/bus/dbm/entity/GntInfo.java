package cn.microvideo.framework3.db.ags.services.bus.dbm.entity;

import cn.microvideo.framework3.core.initialization.dao.MicrovideoBasicDaoEntity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 感动科技.
 * 企业信息表-实体.
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
@Data
@Schema(name = "企业信息表", description = "企业信息表")
public class GntInfo extends MicrovideoBasicDaoEntity {

    /**
    * 道路门架唯一标识符.
    */
    @Schema(description = "道路门架唯一标识符", name = "id", example = "RandomString_112490879", required = true)
    private String id;

    /**
    * 路线名称.
    */
    @Schema(description = "路线名称", name = "roadName", example = "RandomString_-1066779423", required = true)
    private String roadName;

    /**
    * 路线编号.
    */
    @Schema(description = "路线编号", name = "roadCode", example = "RandomString_-878294855", required = true)
    private String roadCode;

    /**
    * 门架名称.
    */
    @Schema(description = "门架名称", name = "gntName", example = "RandomString_434653056", required = true)
    private String gntName;

    /**
    * 门架编号.
    */
    @Schema(description = "门架编号", name = "gntNum", example = "RandomString_464757134", required = true)
    private String gntNum;

    /**
    * 门架桩号字符串.
    */
    @Schema(description = "门架桩号字符串", name = "gntMileageStr", example = "RandomString_-1947381763", required = true)
    private String gntMileageStr;

    /**
    * 门架桩号数字.
    */
    @Schema(description = "门架桩号数字", name = "gntMileage", example = "45.506687061775565", required = true)
    private BigDecimal gntMileage;

    /**
    * 道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...).
    */
    @Schema(description = "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", example = "1", required = true)
    private Integer roadClf;

    /**
    * 定义门架类型.
    */
    @Schema(description = "定义门架类型", name = "dgtId", example = "RandomString_-1538344871", required = true)
    private String dgtId;

    /**
    * 门架是否启用(0:启用、1:停用).
    */
    @Schema(description = "门架是否启用(0:启用、1:停用)", name = "gntEnabled", example = "7", required = true)
    private Integer gntEnabled;

    /**
    * 观测点编号.
    */
    @Schema(description = "观测点编号", name = "obsPointNumber", example = "RandomString_1563043882", required = true)
    private String obsPointNumber;

    /**
    * 厂家名称.
    */
    @Schema(description = "厂家名称", name = "mfrName", example = "RandomString_919515308", required = true)
    private String mfrName;

    /**
    * 查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型).
    */
    @Schema(description = "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", example = "6", required = true)
    private Integer queryContent;

    /**
    * 车道数.
    */
    @Schema(description = "车道数", name = "numOfLanes", example = "4", required = false)
    private Integer numOfLanes;

    /**
    * 备注.
    */
    @Schema(description = "备注", name = "remarks", example = "RandomString_1951645514", required = false)
    private String remarks;

    /**
    * 建设年限.
    */
    @Schema(description = "建设年限", name = "constYear", example = "RandomString_3906424", required = false)
    private String constYear;

    /**
    * 建设单位.
    */
    @Schema(description = "建设单位", name = "constCompany", example = "RandomString_-1040660855", required = false)
    private String constCompany;

    /**
    * 管养单位.
    */
    @Schema(description = "管养单位", name = "mgmtCompany", example = "RandomString_677650220", required = false)
    private String mgmtCompany;

    /**
    * 创建时间.
    */
    @Schema(description = "创建时间", name = "dataCreateTime", example = "2022-07-19 16:41:31", required = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date dataCreateTime;

    /**
    * 最后修改时间.
    */
    @Schema(description = "最后修改时间", name = "dataUpdateTime", example = "2023-10-12 21:47:22", required = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date dataUpdateTime;

    /**
    * 0：代表正常，1：代表删除.
    */
    @Schema(description = "0：代表正常，1：代表删除", name = "dataDelFlag", example = "9", required = false)
    private Integer dataDelFlag;

    /**
    * 版本标记.
    */
    @Schema(description = "版本标记", name = "version", example = "3", required = false)
    private Integer version;
}
