package cn.microvideo.framework3.db.ags.services.bus.dbm.entity;

import cn.microvideo.framework3.core.initialization.page.MicrovideoPage;
import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 感动科技.
 * 企业信息表-数据库处理工具类.
 * @author microvideo
 * @since Thu Aug 08 14:46:23 CST 2024
 */
@Data
public class GntInfoExample {

    /**
    *排序条件.
    */
    protected String orderByClause;

    /**
    *去重条件.
    */
    protected boolean distinct;

    /**
    *查询条件.
    */
    protected List<Criteria> oredCriteria;

    /**
    * 分页条件.
    */
    protected MicrovideoPage page;

    /**
    * t_gnt_info.
    */
    public GntInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
    * t_gnt_info.
    * @return Criteria
    */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
    * t_gnt_info.
    * @return Criteria
    */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
    * t_gnt_info.
    * @return Criteria
    */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
    * t_gnt_info.
    */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 南京感动科技有限公司.
     * @author microvideo
     * @since Thu Aug 08 14:46:23 CST 2024
     *
     * 
     */
    protected abstract static class AbstractGeneratedCriteria {

        /**
        * 查询条件.
        */
        protected List<Criterion> criteria = new ArrayList<Criterion>();

        protected AbstractGeneratedCriteria() {
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        protected void addCriterion(final String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(final String condition, final Object value, final String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(final String condition, final Object value1, final Object value2, final String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("f_vc_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("f_vc_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(final String value) {
            addCriterion("f_vc_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(final String value) {
            addCriterion("f_vc_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(final String value) {
            addCriterion("f_vc_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(final String value) {
            addCriterion("f_vc_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(final String value) {
            addCriterion("f_vc_id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(final String value) {
            addCriterion("f_vc_id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(final List<String> values) {
            addCriterion("f_vc_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(final List<String> values) {
            addCriterion("f_vc_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(final String value1, final String value2) {
            addCriterion("f_vc_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoadNameIsNull() {
            addCriterion("f_vc_road_name is null");
            return (Criteria) this;
        }

        public Criteria andRoadNameIsNotNull() {
            addCriterion("f_vc_road_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoadNameEqualTo(final String value) {
            addCriterion("f_vc_road_name =", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotEqualTo(final String value) {
            addCriterion("f_vc_road_name <>", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameGreaterThan(final String value) {
            addCriterion("f_vc_road_name >", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_road_name >=", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameLessThan(final String value) {
            addCriterion("f_vc_road_name <", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_road_name <=", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameLike(final String value) {
            addCriterion("f_vc_road_name like", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotLike(final String value) {
            addCriterion("f_vc_road_name not like", value, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameIn(final List<String> values) {
            addCriterion("f_vc_road_name in", values, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotIn(final List<String> values) {
            addCriterion("f_vc_road_name not in", values, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameBetween(final String value1, final String value2) {
            addCriterion("f_vc_road_name between", value1, value2, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadNameNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_road_name not between", value1, value2, "roadName");
            return (Criteria) this;
        }

        public Criteria andRoadCodeIsNull() {
            addCriterion("f_vc_road_code is null");
            return (Criteria) this;
        }

        public Criteria andRoadCodeIsNotNull() {
            addCriterion("f_vc_road_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoadCodeEqualTo(final String value) {
            addCriterion("f_vc_road_code =", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeNotEqualTo(final String value) {
            addCriterion("f_vc_road_code <>", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeGreaterThan(final String value) {
            addCriterion("f_vc_road_code >", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_road_code >=", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeLessThan(final String value) {
            addCriterion("f_vc_road_code <", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_road_code <=", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeLike(final String value) {
            addCriterion("f_vc_road_code like", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeNotLike(final String value) {
            addCriterion("f_vc_road_code not like", value, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeIn(final List<String> values) {
            addCriterion("f_vc_road_code in", values, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeNotIn(final List<String> values) {
            addCriterion("f_vc_road_code not in", values, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeBetween(final String value1, final String value2) {
            addCriterion("f_vc_road_code between", value1, value2, "roadCode");
            return (Criteria) this;
        }

        public Criteria andRoadCodeNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_road_code not between", value1, value2, "roadCode");
            return (Criteria) this;
        }

        public Criteria andGntNameIsNull() {
            addCriterion("f_vc_gnt_name is null");
            return (Criteria) this;
        }

        public Criteria andGntNameIsNotNull() {
            addCriterion("f_vc_gnt_name is not null");
            return (Criteria) this;
        }

        public Criteria andGntNameEqualTo(final String value) {
            addCriterion("f_vc_gnt_name =", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameNotEqualTo(final String value) {
            addCriterion("f_vc_gnt_name <>", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameGreaterThan(final String value) {
            addCriterion("f_vc_gnt_name >", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_gnt_name >=", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameLessThan(final String value) {
            addCriterion("f_vc_gnt_name <", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_gnt_name <=", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameLike(final String value) {
            addCriterion("f_vc_gnt_name like", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameNotLike(final String value) {
            addCriterion("f_vc_gnt_name not like", value, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameIn(final List<String> values) {
            addCriterion("f_vc_gnt_name in", values, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameNotIn(final List<String> values) {
            addCriterion("f_vc_gnt_name not in", values, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameBetween(final String value1, final String value2) {
            addCriterion("f_vc_gnt_name between", value1, value2, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNameNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_gnt_name not between", value1, value2, "gntName");
            return (Criteria) this;
        }

        public Criteria andGntNumIsNull() {
            addCriterion("f_vc_gnt_num is null");
            return (Criteria) this;
        }

        public Criteria andGntNumIsNotNull() {
            addCriterion("f_vc_gnt_num is not null");
            return (Criteria) this;
        }

        public Criteria andGntNumEqualTo(final String value) {
            addCriterion("f_vc_gnt_num =", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumNotEqualTo(final String value) {
            addCriterion("f_vc_gnt_num <>", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumGreaterThan(final String value) {
            addCriterion("f_vc_gnt_num >", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_gnt_num >=", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumLessThan(final String value) {
            addCriterion("f_vc_gnt_num <", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_gnt_num <=", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumLike(final String value) {
            addCriterion("f_vc_gnt_num like", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumNotLike(final String value) {
            addCriterion("f_vc_gnt_num not like", value, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumIn(final List<String> values) {
            addCriterion("f_vc_gnt_num in", values, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumNotIn(final List<String> values) {
            addCriterion("f_vc_gnt_num not in", values, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumBetween(final String value1, final String value2) {
            addCriterion("f_vc_gnt_num between", value1, value2, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntNumNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_gnt_num not between", value1, value2, "gntNum");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrIsNull() {
            addCriterion("f_vc_gnt_mileage_str is null");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrIsNotNull() {
            addCriterion("f_vc_gnt_mileage_str is not null");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrEqualTo(final String value) {
            addCriterion("f_vc_gnt_mileage_str =", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrNotEqualTo(final String value) {
            addCriterion("f_vc_gnt_mileage_str <>", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrGreaterThan(final String value) {
            addCriterion("f_vc_gnt_mileage_str >", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_gnt_mileage_str >=", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrLessThan(final String value) {
            addCriterion("f_vc_gnt_mileage_str <", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_gnt_mileage_str <=", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrLike(final String value) {
            addCriterion("f_vc_gnt_mileage_str like", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrNotLike(final String value) {
            addCriterion("f_vc_gnt_mileage_str not like", value, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrIn(final List<String> values) {
            addCriterion("f_vc_gnt_mileage_str in", values, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrNotIn(final List<String> values) {
            addCriterion("f_vc_gnt_mileage_str not in", values, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrBetween(final String value1, final String value2) {
            addCriterion("f_vc_gnt_mileage_str between", value1, value2, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageStrNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_gnt_mileage_str not between", value1, value2, "gntMileageStr");
            return (Criteria) this;
        }

        public Criteria andGntMileageIsNull() {
            addCriterion("f_nb_gnt_mileage is null");
            return (Criteria) this;
        }

        public Criteria andGntMileageIsNotNull() {
            addCriterion("f_nb_gnt_mileage is not null");
            return (Criteria) this;
        }

        public Criteria andGntMileageEqualTo(final BigDecimal value) {
            addCriterion("f_nb_gnt_mileage =", value, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageNotEqualTo(final BigDecimal value) {
            addCriterion("f_nb_gnt_mileage <>", value, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageGreaterThan(final BigDecimal value) {
            addCriterion("f_nb_gnt_mileage >", value, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageGreaterThanOrEqualTo(final BigDecimal value) {
            addCriterion("f_nb_gnt_mileage >=", value, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageLessThan(final BigDecimal value) {
            addCriterion("f_nb_gnt_mileage <", value, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageLessThanOrEqualTo(final BigDecimal value) {
            addCriterion("f_nb_gnt_mileage <=", value, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageIn(final List<BigDecimal> values) {
            addCriterion("f_nb_gnt_mileage in", values, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageNotIn(final List<BigDecimal> values) {
            addCriterion("f_nb_gnt_mileage not in", values, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("f_nb_gnt_mileage between", value1, value2, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andGntMileageNotBetween(final BigDecimal value1, final BigDecimal value2) {
            addCriterion("f_nb_gnt_mileage not between", value1, value2, "gntMileage");
            return (Criteria) this;
        }

        public Criteria andRoadClfIsNull() {
            addCriterion("f_int_road_clf is null");
            return (Criteria) this;
        }

        public Criteria andRoadClfIsNotNull() {
            addCriterion("f_int_road_clf is not null");
            return (Criteria) this;
        }

        public Criteria andRoadClfEqualTo(final Integer value) {
            addCriterion("f_int_road_clf =", value, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfNotEqualTo(final Integer value) {
            addCriterion("f_int_road_clf <>", value, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfGreaterThan(final Integer value) {
            addCriterion("f_int_road_clf >", value, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfGreaterThanOrEqualTo(final Integer value) {
            addCriterion("f_int_road_clf >=", value, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfLessThan(final Integer value) {
            addCriterion("f_int_road_clf <", value, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfLessThanOrEqualTo(final Integer value) {
            addCriterion("f_int_road_clf <=", value, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfIn(final List<Integer> values) {
            addCriterion("f_int_road_clf in", values, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfNotIn(final List<Integer> values) {
            addCriterion("f_int_road_clf not in", values, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_road_clf between", value1, value2, "roadClf");
            return (Criteria) this;
        }

        public Criteria andRoadClfNotBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_road_clf not between", value1, value2, "roadClf");
            return (Criteria) this;
        }

        public Criteria andDgtIdIsNull() {
            addCriterion("f_vc_dgt_id is null");
            return (Criteria) this;
        }

        public Criteria andDgtIdIsNotNull() {
            addCriterion("f_vc_dgt_id is not null");
            return (Criteria) this;
        }

        public Criteria andDgtIdEqualTo(final String value) {
            addCriterion("f_vc_dgt_id =", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdNotEqualTo(final String value) {
            addCriterion("f_vc_dgt_id <>", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdGreaterThan(final String value) {
            addCriterion("f_vc_dgt_id >", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_dgt_id >=", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdLessThan(final String value) {
            addCriterion("f_vc_dgt_id <", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_dgt_id <=", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdLike(final String value) {
            addCriterion("f_vc_dgt_id like", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdNotLike(final String value) {
            addCriterion("f_vc_dgt_id not like", value, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdIn(final List<String> values) {
            addCriterion("f_vc_dgt_id in", values, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdNotIn(final List<String> values) {
            addCriterion("f_vc_dgt_id not in", values, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdBetween(final String value1, final String value2) {
            addCriterion("f_vc_dgt_id between", value1, value2, "dgtId");
            return (Criteria) this;
        }

        public Criteria andDgtIdNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_dgt_id not between", value1, value2, "dgtId");
            return (Criteria) this;
        }

        public Criteria andGntEnabledIsNull() {
            addCriterion("f_int_gnt_enabled is null");
            return (Criteria) this;
        }

        public Criteria andGntEnabledIsNotNull() {
            addCriterion("f_int_gnt_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andGntEnabledEqualTo(final Integer value) {
            addCriterion("f_int_gnt_enabled =", value, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledNotEqualTo(final Integer value) {
            addCriterion("f_int_gnt_enabled <>", value, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledGreaterThan(final Integer value) {
            addCriterion("f_int_gnt_enabled >", value, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledGreaterThanOrEqualTo(final Integer value) {
            addCriterion("f_int_gnt_enabled >=", value, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledLessThan(final Integer value) {
            addCriterion("f_int_gnt_enabled <", value, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledLessThanOrEqualTo(final Integer value) {
            addCriterion("f_int_gnt_enabled <=", value, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledIn(final List<Integer> values) {
            addCriterion("f_int_gnt_enabled in", values, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledNotIn(final List<Integer> values) {
            addCriterion("f_int_gnt_enabled not in", values, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_gnt_enabled between", value1, value2, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andGntEnabledNotBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_gnt_enabled not between", value1, value2, "gntEnabled");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberIsNull() {
            addCriterion("f_vc_obs_point_number is null");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberIsNotNull() {
            addCriterion("f_vc_obs_point_number is not null");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberEqualTo(final String value) {
            addCriterion("f_vc_obs_point_number =", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberNotEqualTo(final String value) {
            addCriterion("f_vc_obs_point_number <>", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberGreaterThan(final String value) {
            addCriterion("f_vc_obs_point_number >", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_obs_point_number >=", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberLessThan(final String value) {
            addCriterion("f_vc_obs_point_number <", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_obs_point_number <=", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberLike(final String value) {
            addCriterion("f_vc_obs_point_number like", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberNotLike(final String value) {
            addCriterion("f_vc_obs_point_number not like", value, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberIn(final List<String> values) {
            addCriterion("f_vc_obs_point_number in", values, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberNotIn(final List<String> values) {
            addCriterion("f_vc_obs_point_number not in", values, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberBetween(final String value1, final String value2) {
            addCriterion("f_vc_obs_point_number between", value1, value2, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andObsPointNumberNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_obs_point_number not between", value1, value2, "obsPointNumber");
            return (Criteria) this;
        }

        public Criteria andMfrNameIsNull() {
            addCriterion("f_vc_mfr_name is null");
            return (Criteria) this;
        }

        public Criteria andMfrNameIsNotNull() {
            addCriterion("f_vc_mfr_name is not null");
            return (Criteria) this;
        }

        public Criteria andMfrNameEqualTo(final String value) {
            addCriterion("f_vc_mfr_name =", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameNotEqualTo(final String value) {
            addCriterion("f_vc_mfr_name <>", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameGreaterThan(final String value) {
            addCriterion("f_vc_mfr_name >", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_mfr_name >=", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameLessThan(final String value) {
            addCriterion("f_vc_mfr_name <", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_mfr_name <=", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameLike(final String value) {
            addCriterion("f_vc_mfr_name like", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameNotLike(final String value) {
            addCriterion("f_vc_mfr_name not like", value, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameIn(final List<String> values) {
            addCriterion("f_vc_mfr_name in", values, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameNotIn(final List<String> values) {
            addCriterion("f_vc_mfr_name not in", values, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameBetween(final String value1, final String value2) {
            addCriterion("f_vc_mfr_name between", value1, value2, "mfrName");
            return (Criteria) this;
        }

        public Criteria andMfrNameNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_mfr_name not between", value1, value2, "mfrName");
            return (Criteria) this;
        }

        public Criteria andQueryContentIsNull() {
            addCriterion("f_vc_query_content is null");
            return (Criteria) this;
        }

        public Criteria andQueryContentIsNotNull() {
            addCriterion("f_vc_query_content is not null");
            return (Criteria) this;
        }

        public Criteria andQueryContentEqualTo(final Integer value) {
            addCriterion("f_vc_query_content =", value, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentNotEqualTo(final Integer value) {
            addCriterion("f_vc_query_content <>", value, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentGreaterThan(final Integer value) {
            addCriterion("f_vc_query_content >", value, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentGreaterThanOrEqualTo(final Integer value) {
            addCriterion("f_vc_query_content >=", value, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentLessThan(final Integer value) {
            addCriterion("f_vc_query_content <", value, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentLessThanOrEqualTo(final Integer value) {
            addCriterion("f_vc_query_content <=", value, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentIn(final List<Integer> values) {
            addCriterion("f_vc_query_content in", values, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentNotIn(final List<Integer> values) {
            addCriterion("f_vc_query_content not in", values, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentBetween(final Integer value1, final Integer value2) {
            addCriterion("f_vc_query_content between", value1, value2, "queryContent");
            return (Criteria) this;
        }

        public Criteria andQueryContentNotBetween(final Integer value1, final Integer value2) {
            addCriterion("f_vc_query_content not between", value1, value2, "queryContent");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesIsNull() {
            addCriterion("f_vc_num_of_lanes is null");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesIsNotNull() {
            addCriterion("f_vc_num_of_lanes is not null");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesEqualTo(final Integer value) {
            addCriterion("f_vc_num_of_lanes =", value, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesNotEqualTo(final Integer value) {
            addCriterion("f_vc_num_of_lanes <>", value, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesGreaterThan(final Integer value) {
            addCriterion("f_vc_num_of_lanes >", value, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesGreaterThanOrEqualTo(final Integer value) {
            addCriterion("f_vc_num_of_lanes >=", value, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesLessThan(final Integer value) {
            addCriterion("f_vc_num_of_lanes <", value, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesLessThanOrEqualTo(final Integer value) {
            addCriterion("f_vc_num_of_lanes <=", value, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesIn(final List<Integer> values) {
            addCriterion("f_vc_num_of_lanes in", values, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesNotIn(final List<Integer> values) {
            addCriterion("f_vc_num_of_lanes not in", values, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesBetween(final Integer value1, final Integer value2) {
            addCriterion("f_vc_num_of_lanes between", value1, value2, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andNumOfLanesNotBetween(final Integer value1, final Integer value2) {
            addCriterion("f_vc_num_of_lanes not between", value1, value2, "numOfLanes");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("f_vc_remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("f_vc_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(final String value) {
            addCriterion("f_vc_remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(final String value) {
            addCriterion("f_vc_remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(final String value) {
            addCriterion("f_vc_remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(final String value) {
            addCriterion("f_vc_remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(final String value) {
            addCriterion("f_vc_remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(final String value) {
            addCriterion("f_vc_remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(final List<String> values) {
            addCriterion("f_vc_remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(final List<String> values) {
            addCriterion("f_vc_remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(final String value1, final String value2) {
            addCriterion("f_vc_remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andConstYearIsNull() {
            addCriterion("f_vc_const_year is null");
            return (Criteria) this;
        }

        public Criteria andConstYearIsNotNull() {
            addCriterion("f_vc_const_year is not null");
            return (Criteria) this;
        }

        public Criteria andConstYearEqualTo(final String value) {
            addCriterion("f_vc_const_year =", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearNotEqualTo(final String value) {
            addCriterion("f_vc_const_year <>", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearGreaterThan(final String value) {
            addCriterion("f_vc_const_year >", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_const_year >=", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearLessThan(final String value) {
            addCriterion("f_vc_const_year <", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_const_year <=", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearLike(final String value) {
            addCriterion("f_vc_const_year like", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearNotLike(final String value) {
            addCriterion("f_vc_const_year not like", value, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearIn(final List<String> values) {
            addCriterion("f_vc_const_year in", values, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearNotIn(final List<String> values) {
            addCriterion("f_vc_const_year not in", values, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearBetween(final String value1, final String value2) {
            addCriterion("f_vc_const_year between", value1, value2, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstYearNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_const_year not between", value1, value2, "constYear");
            return (Criteria) this;
        }

        public Criteria andConstCompanyIsNull() {
            addCriterion("f_vc_const_company is null");
            return (Criteria) this;
        }

        public Criteria andConstCompanyIsNotNull() {
            addCriterion("f_vc_const_company is not null");
            return (Criteria) this;
        }

        public Criteria andConstCompanyEqualTo(final String value) {
            addCriterion("f_vc_const_company =", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyNotEqualTo(final String value) {
            addCriterion("f_vc_const_company <>", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyGreaterThan(final String value) {
            addCriterion("f_vc_const_company >", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_const_company >=", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyLessThan(final String value) {
            addCriterion("f_vc_const_company <", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_const_company <=", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyLike(final String value) {
            addCriterion("f_vc_const_company like", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyNotLike(final String value) {
            addCriterion("f_vc_const_company not like", value, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyIn(final List<String> values) {
            addCriterion("f_vc_const_company in", values, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyNotIn(final List<String> values) {
            addCriterion("f_vc_const_company not in", values, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyBetween(final String value1, final String value2) {
            addCriterion("f_vc_const_company between", value1, value2, "constCompany");
            return (Criteria) this;
        }

        public Criteria andConstCompanyNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_const_company not between", value1, value2, "constCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyIsNull() {
            addCriterion("f_vc_mgmt_company is null");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyIsNotNull() {
            addCriterion("f_vc_mgmt_company is not null");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyEqualTo(final String value) {
            addCriterion("f_vc_mgmt_company =", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyNotEqualTo(final String value) {
            addCriterion("f_vc_mgmt_company <>", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyGreaterThan(final String value) {
            addCriterion("f_vc_mgmt_company >", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyGreaterThanOrEqualTo(final String value) {
            addCriterion("f_vc_mgmt_company >=", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyLessThan(final String value) {
            addCriterion("f_vc_mgmt_company <", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyLessThanOrEqualTo(final String value) {
            addCriterion("f_vc_mgmt_company <=", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyLike(final String value) {
            addCriterion("f_vc_mgmt_company like", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyNotLike(final String value) {
            addCriterion("f_vc_mgmt_company not like", value, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyIn(final List<String> values) {
            addCriterion("f_vc_mgmt_company in", values, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyNotIn(final List<String> values) {
            addCriterion("f_vc_mgmt_company not in", values, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyBetween(final String value1, final String value2) {
            addCriterion("f_vc_mgmt_company between", value1, value2, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andMgmtCompanyNotBetween(final String value1, final String value2) {
            addCriterion("f_vc_mgmt_company not between", value1, value2, "mgmtCompany");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeIsNull() {
            addCriterion("f_dt_data_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeIsNotNull() {
            addCriterion("f_dt_data_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeEqualTo(final String value) {
            addCriterion("f_dt_data_create_time =", value, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeNotEqualTo(final String value) {
            addCriterion("f_dt_data_create_time <>", value, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeGreaterThan(final String value) {
            addCriterion("f_dt_data_create_time >", value, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeGreaterThanOrEqualTo(final String value) {
            addCriterion("f_dt_data_create_time >=", value, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeLessThan(final String value) {
            addCriterion("f_dt_data_create_time <", value, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeLessThanOrEqualTo(final String value) {
            addCriterion("f_dt_data_create_time <=", value, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeIn(final List<String> values) {
            addCriterion("f_dt_data_create_time in", values, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeNotIn(final List<String> values) {
            addCriterion("f_dt_data_create_time not in", values, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeBetween(final String value1, final String value2) {
            addCriterion("f_dt_data_create_time between", value1, value2, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataCreateTimeNotBetween(final String value1, final String value2) {
            addCriterion("f_dt_data_create_time not between", value1, value2, "dataCreateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeIsNull() {
            addCriterion("f_dt_data_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeIsNotNull() {
            addCriterion("f_dt_data_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeEqualTo(final String value) {
            addCriterion("f_dt_data_update_time =", value, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeNotEqualTo(final String value) {
            addCriterion("f_dt_data_update_time <>", value, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeGreaterThan(final String value) {
            addCriterion("f_dt_data_update_time >", value, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeGreaterThanOrEqualTo(final String value) {
            addCriterion("f_dt_data_update_time >=", value, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeLessThan(final String value) {
            addCriterion("f_dt_data_update_time <", value, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeLessThanOrEqualTo(final String value) {
            addCriterion("f_dt_data_update_time <=", value, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeIn(final List<String> values) {
            addCriterion("f_dt_data_update_time in", values, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeNotIn(final List<String> values) {
            addCriterion("f_dt_data_update_time not in", values, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeBetween(final String value1, final String value2) {
            addCriterion("f_dt_data_update_time between", value1, value2, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataUpdateTimeNotBetween(final String value1, final String value2) {
            addCriterion("f_dt_data_update_time not between", value1, value2, "dataUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagIsNull() {
            addCriterion("f_int_data_del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagIsNotNull() {
            addCriterion("f_int_data_del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagEqualTo(final Integer value) {
            addCriterion("f_int_data_del_flag =", value, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagNotEqualTo(final Integer value) {
            addCriterion("f_int_data_del_flag <>", value, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagGreaterThan(final Integer value) {
            addCriterion("f_int_data_del_flag >", value, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagGreaterThanOrEqualTo(final Integer value) {
            addCriterion("f_int_data_del_flag >=", value, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagLessThan(final Integer value) {
            addCriterion("f_int_data_del_flag <", value, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagLessThanOrEqualTo(final Integer value) {
            addCriterion("f_int_data_del_flag <=", value, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagIn(final List<Integer> values) {
            addCriterion("f_int_data_del_flag in", values, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagNotIn(final List<Integer> values) {
            addCriterion("f_int_data_del_flag not in", values, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_data_del_flag between", value1, value2, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andDataDelFlagNotBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_data_del_flag not between", value1, value2, "dataDelFlag");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("f_int_version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("f_int_version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(final Integer value) {
            addCriterion("f_int_version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(final Integer value) {
            addCriterion("f_int_version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(final Integer value) {
            addCriterion("f_int_version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(final Integer value) {
            addCriterion("f_int_version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(final Integer value) {
            addCriterion("f_int_version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(final Integer value) {
            addCriterion("f_int_version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(final List<Integer> values) {
            addCriterion("f_int_version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(final List<Integer> values) {
            addCriterion("f_int_version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(final Integer value1, final Integer value2) {
            addCriterion("f_int_version not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_gnt_info
     *
     *  do_not_delete_during_merge
     */
    public static class Criteria extends AbstractGeneratedCriteria {

    }

    /**
     * 南京感动科技有限公司.
     * @author microvideo
     * @since Thu Aug 08 14:46:23 CST 2024
     *
     * 
     */
    public static class Criterion {

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(final String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(final String condition, final Object value, final String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(final String condition, final Object value) {
            this(condition, value, null);
        }

        protected Criterion(final String condition, final Object value, final Object secondValue, final String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(final String condition, final Object value, final Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}

