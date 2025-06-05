package cn.microvideo.framework3.db.ags.services.bus.dbm.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 南京感动科技有限公司.
 * 企业信息表-表单参数
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
@Schema(name = "企业信息表", description = "企业信息表")
@Data
public class GntInfoFormParam implements Serializable {

    @NotNull(message = "道路门架唯一标识符不能为空")
    @NotEmpty(message = "道路门架唯一标识符不能为空")
    @Size(min = 0, max = 35, message = "道路门架唯一标识符长度最大35")
    @Schema(description= "道路门架唯一标识符", name = "id", example = "RandomString_1", required = true)
    private String id;

    @NotNull(message = "路线名称不能为空")
    @NotEmpty(message = "路线名称不能为空")
    @Size(min = 0, max = 9, message = "路线名称长度最大9")
    @Schema(description= "路线名称", name = "roadName", example = "RandomString_1", required = true)
    private String roadName;

    @NotNull(message = "路线编号不能为空")
    @NotEmpty(message = "路线编号不能为空")
    @Size(min = 0, max = 9, message = "路线编号长度最大9")
    @Schema(description= "路线编号", name = "roadCode", example = "RandomString_1", required = true)
    private String roadCode;

    @NotNull(message = "门架名称不能为空")
    @NotEmpty(message = "门架名称不能为空")
    @Size(min = 0, max = 9, message = "门架名称长度最大9")
    @Schema(description= "门架名称", name = "gntName", example = "RandomString_1", required = true)
    private String gntName;

    @NotNull(message = "门架编号不能为空")
    @NotEmpty(message = "门架编号不能为空")
    @Size(min = 0, max = 19, message = "门架编号长度最大19")
    @Schema(description= "门架编号", name = "gntNum", example = "RandomString_1", required = true)
    private String gntNum;

    @NotNull(message = "门架桩号字符串不能为空")
    @NotEmpty(message = "门架桩号字符串不能为空")
    @Size(min = 0, max = 9, message = "门架桩号字符串长度最大9")
    @Schema(description= "门架桩号字符串", name = "gntMileageStr", example = "RandomString_1", required = true)
    private String gntMileageStr;

    @NotNull(message = "门架桩号数字不能为空")
    private BigDecimal gntMileage;

    @NotNull(message = "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)不能为空")
    @Max(value = 999999999L, message = "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)最大999999999")
    @Schema(description= "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", example = "5", required = true)
    private Integer roadClf;

    @NotNull(message = "定义门架类型不能为空")
    @NotEmpty(message = "定义门架类型不能为空")
    @Size(min = 0, max = 35, message = "定义门架类型长度最大35")
    @Schema(description= "定义门架类型", name = "dgtId", example = "RandomString_1", required = true)
    private String dgtId;

    @NotNull(message = "门架是否启用(0:启用、1:停用)不能为空")
    @Max(value = 999999999L, message = "门架是否启用(0:启用、1:停用)最大999999999")
    @Schema(description= "门架是否启用(0:启用、1:停用)", name = "gntEnabled", example = "5", required = true)
    private Integer gntEnabled;

    @NotNull(message = "观测点编号不能为空")
    @NotEmpty(message = "观测点编号不能为空")
    @Size(min = 0, max = 9, message = "观测点编号长度最大9")
    @Schema(description= "观测点编号", name = "obsPointNumber", example = "RandomString_1", required = true)
    private String obsPointNumber;

    @NotNull(message = "厂家名称不能为空")
    @NotEmpty(message = "厂家名称不能为空")
    @Size(min = 0, max = 19, message = "厂家名称长度最大19")
    @Schema(description= "厂家名称", name = "mfrName", example = "RandomString_1", required = true)
    private String mfrName;

    @NotNull(message = "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)不能为空")
    @Max(value = 999999999L, message = "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)最大999999999")
    @Schema(description= "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", example = "5", required = true)
    private Integer queryContent;

    @Max(value = 999999999L, message = "车道数最大999999999")
    @Schema(description= "车道数", name = "numOfLanes", example = "5", required = false)
    private Integer numOfLanes;

    @Size(min = 0, max = 9, message = "备注长度最大9")
    @Schema(description= "备注", name = "remarks", example = "RandomString_1", required = false)
    private String remarks;

    @Size(min = 0, max = 9, message = "建设年限长度最大9")
    @Schema(description= "建设年限", name = "constYear", example = "RandomString_1", required = false)
    private String constYear;

    @Size(min = 0, max = 19, message = "建设单位长度最大19")
    @Schema(description= "建设单位", name = "constCompany", example = "RandomString_1", required = false)
    private String constCompany;

    @Size(min = 0, max = 19, message = "管养单位长度最大19")
    @Schema(description= "管养单位", name = "mgmtCompany", example = "RandomString_1", required = false)
    private String mgmtCompany;

    @Schema(description= "创建时间", name = "dataCreateTime", example = "2023-12-09", required = false)
    private Date dataCreateTime;

    @Schema(description= "最后修改时间", name = "dataUpdateTime", example = "2023-12-09", required = false)
    private Date dataUpdateTime;

    @Max(value = 999999999L, message = "0：代表正常，1：代表删除最大999999999")
    @Schema(description= "0：代表正常，1：代表删除", name = "dataDelFlag", example = "5", required = false)
    private Integer dataDelFlag;

    @Max(value = 999999999L, message = "版本标记最大999999999")
    @Schema(description= "版本标记", name = "version", example = "5", required = false)
    private Integer version;

}
