package cn.microvideo.framework3.db.ags.services.bus.dbm.param;

import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfo;
import cn.microvideo.framework3.core.initialization.page.MicrovideoPage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

/**
 * 南京感动科技有限公司.
 * 企业信息表-查询参数
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
@Schema(name = "企业信息表", description = "企业信息表")
@Data
public class GntInfoQueryParam extends GntInfo {
    /**
     * 分页.
     */
    @Schema(description= "分页查询", name = "page", required = false)
    private MicrovideoPage page;


    /**
    * 查询条件-标签-道路门架唯一标识符.
    */
    @Schema(description= "道路门架唯一标识符", name = "id", example = "RandomString_1", required = false)
    private String idText;

    /**
    * 查询条件-开始-道路门架唯一标识符.
    */
    @Schema(description= "道路门架唯一标识符", name = "id", example = "RandomString_1", required = false)
    private String startId;

    /**
    * 查询条件-结束-道路门架唯一标识符.
    */
    @Schema(description= "道路门架唯一标识符", name = "id", example = "RandomString_1", required = false)
    private String endId;

    /**
    * 查询条件-集合-道路门架唯一标识符.
    */
    @Schema(description= "道路门架唯一标识符", name = "id", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listId;

    /**
    * 查询条件-标签-路线名称.
    */
    @Schema(description= "路线名称", name = "roadName", example = "RandomString_1", required = false)
    private String roadNameText;

    /**
    * 查询条件-开始-路线名称.
    */
    @Schema(description= "路线名称", name = "roadName", example = "RandomString_1", required = false)
    private String startRoadName;

    /**
    * 查询条件-结束-路线名称.
    */
    @Schema(description= "路线名称", name = "roadName", example = "RandomString_1", required = false)
    private String endRoadName;

    /**
    * 查询条件-集合-路线名称.
    */
    @Schema(description= "路线名称", name = "roadName", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listRoadName;

    /**
    * 查询条件-标签-路线编号.
    */
    @Schema(description= "路线编号", name = "roadCode", example = "RandomString_1", required = false)
    private String roadCodeText;

    /**
    * 查询条件-开始-路线编号.
    */
    @Schema(description= "路线编号", name = "roadCode", example = "RandomString_1", required = false)
    private String startRoadCode;

    /**
    * 查询条件-结束-路线编号.
    */
    @Schema(description= "路线编号", name = "roadCode", example = "RandomString_1", required = false)
    private String endRoadCode;

    /**
    * 查询条件-集合-路线编号.
    */
    @Schema(description= "路线编号", name = "roadCode", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listRoadCode;

    /**
    * 查询条件-标签-门架名称.
    */
    @Schema(description= "门架名称", name = "gntName", example = "RandomString_1", required = false)
    private String gntNameText;

    /**
    * 查询条件-开始-门架名称.
    */
    @Schema(description= "门架名称", name = "gntName", example = "RandomString_1", required = false)
    private String startGntName;

    /**
    * 查询条件-结束-门架名称.
    */
    @Schema(description= "门架名称", name = "gntName", example = "RandomString_1", required = false)
    private String endGntName;

    /**
    * 查询条件-集合-门架名称.
    */
    @Schema(description= "门架名称", name = "gntName", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listGntName;

    /**
    * 查询条件-标签-门架编号.
    */
    @Schema(description= "门架编号", name = "gntNum", example = "RandomString_1", required = false)
    private String gntNumText;

    /**
    * 查询条件-开始-门架编号.
    */
    @Schema(description= "门架编号", name = "gntNum", example = "RandomString_1", required = false)
    private String startGntNum;

    /**
    * 查询条件-结束-门架编号.
    */
    @Schema(description= "门架编号", name = "gntNum", example = "RandomString_1", required = false)
    private String endGntNum;

    /**
    * 查询条件-集合-门架编号.
    */
    @Schema(description= "门架编号", name = "gntNum", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listGntNum;

    /**
    * 查询条件-标签-门架桩号字符串.
    */
    @Schema(description= "门架桩号字符串", name = "gntMileageStr", example = "RandomString_1", required = false)
    private String gntMileageStrText;

    /**
    * 查询条件-开始-门架桩号字符串.
    */
    @Schema(description= "门架桩号字符串", name = "gntMileageStr", example = "RandomString_1", required = false)
    private String startGntMileageStr;

    /**
    * 查询条件-结束-门架桩号字符串.
    */
    @Schema(description= "门架桩号字符串", name = "gntMileageStr", example = "RandomString_1", required = false)
    private String endGntMileageStr;

    /**
    * 查询条件-集合-门架桩号字符串.
    */
    @Schema(description= "门架桩号字符串", name = "gntMileageStr", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listGntMileageStr;

    /**
    * 查询条件-标签-道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...).
    */
    @Schema(description= "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", example = "5", required = false)
    private String roadClfText;

    /**
    * 查询条件-开始-道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...).
    */
    @Schema(description= "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", example = "5", required = false)
    private Integer startRoadClf;

    /**
    * 查询条件-结束-道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...).
    */
    @Schema(description= "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", example = "7", required = false)
    private Integer endRoadClf;

    /**
    * 查询条件-集合-道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...).
    */
    @Schema(description= "道路分类(0:国道、1:省道、2:县道、3:村道、4:专项道路...)", name = "roadClf", type="List", example = "[5, 6, 7]", required = false)
    private List<Integer> listRoadClf;

    /**
    * 查询条件-标签-定义门架类型.
    */
    @Schema(description= "定义门架类型", name = "dgtId", example = "RandomString_1", required = false)
    private String dgtIdText;

    /**
    * 查询条件-开始-定义门架类型.
    */
    @Schema(description= "定义门架类型", name = "dgtId", example = "RandomString_1", required = false)
    private String startDgtId;

    /**
    * 查询条件-结束-定义门架类型.
    */
    @Schema(description= "定义门架类型", name = "dgtId", example = "RandomString_1", required = false)
    private String endDgtId;

    /**
    * 查询条件-集合-定义门架类型.
    */
    @Schema(description= "定义门架类型", name = "dgtId", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listDgtId;

    /**
    * 查询条件-标签-门架是否启用(0:启用、1:停用).
    */
    @Schema(description= "门架是否启用(0:启用、1:停用)", name = "gntEnabled", example = "5", required = false)
    private String gntEnabledText;

    /**
    * 查询条件-开始-门架是否启用(0:启用、1:停用).
    */
    @Schema(description= "门架是否启用(0:启用、1:停用)", name = "gntEnabled", example = "5", required = false)
    private Integer startGntEnabled;

    /**
    * 查询条件-结束-门架是否启用(0:启用、1:停用).
    */
    @Schema(description= "门架是否启用(0:启用、1:停用)", name = "gntEnabled", example = "7", required = false)
    private Integer endGntEnabled;

    /**
    * 查询条件-集合-门架是否启用(0:启用、1:停用).
    */
    @Schema(description= "门架是否启用(0:启用、1:停用)", name = "gntEnabled", type="List", example = "[5, 6, 7]", required = false)
    private List<Integer> listGntEnabled;

    /**
    * 查询条件-标签-观测点编号.
    */
    @Schema(description= "观测点编号", name = "obsPointNumber", example = "RandomString_1", required = false)
    private String obsPointNumberText;

    /**
    * 查询条件-开始-观测点编号.
    */
    @Schema(description= "观测点编号", name = "obsPointNumber", example = "RandomString_1", required = false)
    private String startObsPointNumber;

    /**
    * 查询条件-结束-观测点编号.
    */
    @Schema(description= "观测点编号", name = "obsPointNumber", example = "RandomString_1", required = false)
    private String endObsPointNumber;

    /**
    * 查询条件-集合-观测点编号.
    */
    @Schema(description= "观测点编号", name = "obsPointNumber", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listObsPointNumber;

    /**
    * 查询条件-标签-厂家名称.
    */
    @Schema(description= "厂家名称", name = "mfrName", example = "RandomString_1", required = false)
    private String mfrNameText;

    /**
    * 查询条件-开始-厂家名称.
    */
    @Schema(description= "厂家名称", name = "mfrName", example = "RandomString_1", required = false)
    private String startMfrName;

    /**
    * 查询条件-结束-厂家名称.
    */
    @Schema(description= "厂家名称", name = "mfrName", example = "RandomString_1", required = false)
    private String endMfrName;

    /**
    * 查询条件-集合-厂家名称.
    */
    @Schema(description= "厂家名称", name = "mfrName", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listMfrName;

    /**
    * 查询条件-标签-查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型).
    */
    @Schema(description= "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", example = "5", required = false)
    private String queryContentText;

    /**
    * 查询条件-开始-查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型).
    */
    @Schema(description= "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", example = "5", required = false)
    private Integer startQueryContent;

    /**
    * 查询条件-结束-查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型).
    */
    @Schema(description= "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", example = "7", required = false)
    private Integer endQueryContent;

    /**
    * 查询条件-集合-查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型).
    */
    @Schema(description= "查询内容(1：流量 2：速度 4：车型 3：流量+速度 5：流量+车型 6：速度+车型 7：流量+速度+车型)", name = "queryContent", type="List", example = "[5, 6, 7]", required = false)
    private List<Integer> listQueryContent;

    /**
    * 查询条件-标签-车道数.
    */
    @Schema(description= "车道数", name = "numOfLanes", example = "5", required = false)
    private String numOfLanesText;

    /**
    * 查询条件-开始-车道数.
    */
    @Schema(description= "车道数", name = "numOfLanes", example = "5", required = false)
    private Integer startNumOfLanes;

    /**
    * 查询条件-结束-车道数.
    */
    @Schema(description= "车道数", name = "numOfLanes", example = "7", required = false)
    private Integer endNumOfLanes;

    /**
    * 查询条件-集合-车道数.
    */
    @Schema(description= "车道数", name = "numOfLanes", type="List", example = "[5, 6, 7]", required = false)
    private List<Integer> listNumOfLanes;

    /**
    * 查询条件-标签-备注.
    */
    @Schema(description= "备注", name = "remarks", example = "RandomString_1", required = false)
    private String remarksText;

    /**
    * 查询条件-开始-备注.
    */
    @Schema(description= "备注", name = "remarks", example = "RandomString_1", required = false)
    private String startRemarks;

    /**
    * 查询条件-结束-备注.
    */
    @Schema(description= "备注", name = "remarks", example = "RandomString_1", required = false)
    private String endRemarks;

    /**
    * 查询条件-集合-备注.
    */
    @Schema(description= "备注", name = "remarks", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listRemarks;

    /**
    * 查询条件-标签-建设年限.
    */
    @Schema(description= "建设年限", name = "constYear", example = "RandomString_1", required = false)
    private String constYearText;

    /**
    * 查询条件-开始-建设年限.
    */
    @Schema(description= "建设年限", name = "constYear", example = "RandomString_1", required = false)
    private String startConstYear;

    /**
    * 查询条件-结束-建设年限.
    */
    @Schema(description= "建设年限", name = "constYear", example = "RandomString_1", required = false)
    private String endConstYear;

    /**
    * 查询条件-集合-建设年限.
    */
    @Schema(description= "建设年限", name = "constYear", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listConstYear;

    /**
    * 查询条件-标签-建设单位.
    */
    @Schema(description= "建设单位", name = "constCompany", example = "RandomString_1", required = false)
    private String constCompanyText;

    /**
    * 查询条件-开始-建设单位.
    */
    @Schema(description= "建设单位", name = "constCompany", example = "RandomString_1", required = false)
    private String startConstCompany;

    /**
    * 查询条件-结束-建设单位.
    */
    @Schema(description= "建设单位", name = "constCompany", example = "RandomString_1", required = false)
    private String endConstCompany;

    /**
    * 查询条件-集合-建设单位.
    */
    @Schema(description= "建设单位", name = "constCompany", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listConstCompany;

    /**
    * 查询条件-标签-管养单位.
    */
    @Schema(description= "管养单位", name = "mgmtCompany", example = "RandomString_1", required = false)
    private String mgmtCompanyText;

    /**
    * 查询条件-开始-管养单位.
    */
    @Schema(description= "管养单位", name = "mgmtCompany", example = "RandomString_1", required = false)
    private String startMgmtCompany;

    /**
    * 查询条件-结束-管养单位.
    */
    @Schema(description= "管养单位", name = "mgmtCompany", example = "RandomString_1", required = false)
    private String endMgmtCompany;

    /**
    * 查询条件-集合-管养单位.
    */
    @Schema(description= "管养单位", name = "mgmtCompany", type="List", example = "[RandomString_1, RandomString_2]", required = false)
    private List<String> listMgmtCompany;
    /**
    * 查询条件-标签-创建时间.
    */
    @Schema(description= "创建时间", name = "dataCreateTime", example = "2023-12-09", required = false)
    private String dataCreateTimeText;

    /**
    * 查询条件-开始-创建时间.
    */
    @Schema(description= "创建时间", name = "dataCreateTime", example = "2023-12-09", required = false)
    private String startDataCreateTime;

    /**
    * 查询条件-结束-创建时间.
    */
    @Schema(description= "创建时间", name = "dataCreateTime", example = "2023-12-09", required = false)
    private String endDataCreateTime;

    /**
    * 查询条件-集合-创建时间.
    */
    @Schema(description= "创建时间", name = "dataCreateTime", type="List", example = "[2023-12-09, 2023-12-09, 2023-12-09]", required = false)
    private List<String> listDataCreateTime;
    /**
    * 查询条件-标签-最后修改时间.
    */
    @Schema(description= "最后修改时间", name = "dataUpdateTime", example = "2023-12-09", required = false)
    private String dataUpdateTimeText;

    /**
    * 查询条件-开始-最后修改时间.
    */
    @Schema(description= "最后修改时间", name = "dataUpdateTime", example = "2023-12-09", required = false)
    private String startDataUpdateTime;

    /**
    * 查询条件-结束-最后修改时间.
    */
    @Schema(description= "最后修改时间", name = "dataUpdateTime", example = "2023-12-09", required = false)
    private String endDataUpdateTime;

    /**
    * 查询条件-集合-最后修改时间.
    */
    @Schema(description= "最后修改时间", name = "dataUpdateTime", type="List", example = "[2023-12-09, 2023-12-09, 2023-12-09]", required = false)
    private List<String> listDataUpdateTime;

    /**
    * 查询条件-标签-0：代表正常，1：代表删除.
    */
    @Schema(description= "0：代表正常，1：代表删除", name = "dataDelFlag", example = "5", required = false)
    private String dataDelFlagText;

    /**
    * 查询条件-开始-0：代表正常，1：代表删除.
    */
    @Schema(description= "0：代表正常，1：代表删除", name = "dataDelFlag", example = "5", required = false)
    private Integer startDataDelFlag;

    /**
    * 查询条件-结束-0：代表正常，1：代表删除.
    */
    @Schema(description= "0：代表正常，1：代表删除", name = "dataDelFlag", example = "7", required = false)
    private Integer endDataDelFlag;

    /**
    * 查询条件-集合-0：代表正常，1：代表删除.
    */
    @Schema(description= "0：代表正常，1：代表删除", name = "dataDelFlag", type="List", example = "[5, 6, 7]", required = false)
    private List<Integer> listDataDelFlag;

    /**
    * 查询条件-标签-版本标记.
    */
    @Schema(description= "版本标记", name = "version", example = "5", required = false)
    private String versionText;

    /**
    * 查询条件-开始-版本标记.
    */
    @Schema(description= "版本标记", name = "version", example = "5", required = false)
    private Integer startVersion;

    /**
    * 查询条件-结束-版本标记.
    */
    @Schema(description= "版本标记", name = "version", example = "7", required = false)
    private Integer endVersion;

    /**
    * 查询条件-集合-版本标记.
    */
    @Schema(description= "版本标记", name = "version", type="List", example = "[5, 6, 7]", required = false)
    private List<Integer> listVersion;

    @Override
    public boolean equals(final Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
