package cn.microvideo.framework3.db.ags.services.bus.dbm.param;

import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 南京感动科技有限公司.
 * 企业信息表-公共参数
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
@Schema(name = "企业信息表", description = "企业信息表")
@Data
public class GntInfoCommonParam extends GntInfo {


    /**
    * 道路门架唯一标识符.
    */
    @Schema(description= "道路门架唯一标识符", name = "id", example = "RandomString_1", required = false)
    private String idText;

    /**
    * 路线名称.
    */
    @Schema(description= "路线名称", name = "roadName", example = "RandomString_1", required = false)
    private String roadNameText;

    /**
    * 路线编号.
    */
    @Schema(description= "路线编号", name = "roadCode", example = "RandomString_1", required = false)
    private String roadCodeText;

    /**
    * 门架名称.
    */
    @Schema(description= "门架名称", name = "gntName", example = "RandomString_1", required = false)
    private String gntNameText;

    /**
    * 门架编号.
    */
    @Schema(description= "门架编号", name = "gntNum", example = "RandomString_1", required = false)
    private String gntNumText;

    /**
    * 门架桩号字符串.
    */
    @Schema(description= "门架桩号字符串", name = "gntMileageStr", example = "RandomString_1", required = false)
    private String gntMileageStrText;

    /**
    * 道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...).
    */
    @Schema(description= "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", example = "5", required = false)
    private String roadClfText;


    /**
    * 定义门架类型.
    */
    @Schema(description= "定义门架类型", name = "dgtId", example = "RandomString_1", required = false)
    private String dgtIdText;

    /**
    * 门架是否启用(0:启用、1:停用).
    */
    @Schema(description= "门架是否启用(0:启用、1:停用)", name = "gntEnabled", example = "5", required = false)
    private String gntEnabledText;


    /**
    * 观测点编号.
    */
    @Schema(description= "观测点编号", name = "obsPointNumber", example = "RandomString_1", required = false)
    private String obsPointNumberText;

    /**
    * 厂家名称.
    */
    @Schema(description= "厂家名称", name = "mfrName", example = "RandomString_1", required = false)
    private String mfrNameText;

    /**
    * 查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型).
    */
    @Schema(description= "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", example = "5", required = false)
    private String queryContentText;


    /**
    * 车道数.
    */
    @Schema(description= "车道数", name = "numOfLanes", example = "5", required = false)
    private String numOfLanesText;


    /**
    * 备注.
    */
    @Schema(description= "备注", name = "remarks", example = "RandomString_1", required = false)
    private String remarksText;

    /**
    * 建设年限.
    */
    @Schema(description= "建设年限", name = "constYear", example = "RandomString_1", required = false)
    private String constYearText;

    /**
    * 建设单位.
    */
    @Schema(description= "建设单位", name = "constCompany", example = "RandomString_1", required = false)
    private String constCompanyText;

    /**
    * 管养单位.
    */
    @Schema(description= "管养单位", name = "mgmtCompany", example = "RandomString_1", required = false)
    private String mgmtCompanyText;
    /**
    * 创建时间.
    */
    @Schema(description= "创建时间", name = "dataCreateTime", example = "2023-12-09", required = false)
    private String dataCreateTimeText;
    /**
    * 最后修改时间.
    */
    @Schema(description= "最后修改时间", name = "dataUpdateTime", example = "2023-12-09", required = false)
    private String dataUpdateTimeText;

    /**
    * 0：代表正常，1：代表删除.
    */
    @Schema(description= "0：代表正常，1：代表删除", name = "dataDelFlag", example = "5", required = false)
    private String dataDelFlagText;


    /**
    * 版本标记.
    */
    @Schema(description= "版本标记", name = "version", example = "5", required = false)
    private String versionText;

}
