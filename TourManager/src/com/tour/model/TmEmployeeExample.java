package com.tour.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TmEmployeeExample {
   
    /**
     * This field was generated by Apache iBATIS ibator. This field corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    protected String orderByClause;
    /**
     * This field was generated by Apache iBATIS ibator. This field corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public TmEmployeeExample() {
        oredCriteria = new ArrayList();
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    protected TmEmployeeExample( TmEmployeeExample example ) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public void setOrderByClause( String orderByClause ) {
        this.orderByClause = orderByClause;
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public List getOredCriteria() {
        return oredCriteria;
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public void or( Criteria criteria ) {
        oredCriteria.add( criteria );
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add( criteria );
        }
        return criteria;
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }


    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
    }


    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table tm_employee
     * @ibatorgenerated  Thu May 14 09:05:10 CST 2015
     */
    public static class Criteria {
        
        protected List criteriaWithoutValue;
        protected List criteriaWithSingleValue;
        protected List criteriaWithListValue;
        protected List criteriaWithBetweenValue;
        
        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }
        
        public boolean isValid() {
            return criteriaWithoutValue.size() > 0 || criteriaWithSingleValue.size() > 0
                    || criteriaWithListValue.size() > 0 || criteriaWithBetweenValue.size() > 0;
        }
        
        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }
        
        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }
        
        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }
        
        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }
        
        protected void addCriterion( String condition ) {
            if (condition == null) {
                throw new RuntimeException( "Value for condition cannot be null" );
            }
            criteriaWithoutValue.add( condition );
        }
        
        protected void addCriterion( String condition, Object value, String property ) {
            if (value == null) {
                throw new RuntimeException( "Value for " + property + " cannot be null" );
            }
            Map map = new HashMap();
            map.put( "condition", condition );
            map.put( "value", value );
            criteriaWithSingleValue.add( map );
        }
        
        protected void addCriterion( String condition, List values, String property ) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException( "Value list for " + property
                        + " cannot be null or empty" );
            }
            Map map = new HashMap();
            map.put( "condition", condition );
            map.put( "values", values );
            criteriaWithListValue.add( map );
        }
        
        protected void addCriterion( String condition, Object value1, Object value2, String property ) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException( "Between values for " + property + " cannot be null" );
            }
            List list = new ArrayList();
            list.add( value1 );
            list.add( value2 );
            Map map = new HashMap();
            map.put( "condition", condition );
            map.put( "values", list );
            criteriaWithBetweenValue.add( map );
        }
        
        public Criteria andIdIsNull() {
            addCriterion( "id is null" );
            return this;
        }
        
        public Criteria andIdIsNotNull() {
            addCriterion( "id is not null" );
            return this;
        }
        
        public Criteria andIdEqualTo( Integer value ) {
            addCriterion( "id =", value, "id" );
            return this;
        }
        
        public Criteria andIdNotEqualTo( Integer value ) {
            addCriterion( "id <>", value, "id" );
            return this;
        }
        
        public Criteria andIdGreaterThan( Integer value ) {
            addCriterion( "id >", value, "id" );
            return this;
        }
        
        public Criteria andIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "id >=", value, "id" );
            return this;
        }
        
        public Criteria andIdLessThan( Integer value ) {
            addCriterion( "id <", value, "id" );
            return this;
        }
        
        public Criteria andIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "id <=", value, "id" );
            return this;
        }
        
        public Criteria andIdIn( List values ) {
            addCriterion( "id in", values, "id" );
            return this;
        }
        
        public Criteria andIdNotIn( List values ) {
            addCriterion( "id not in", values, "id" );
            return this;
        }
        
        public Criteria andIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "id between", value1, value2, "id" );
            return this;
        }
        
        public Criteria andIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "id not between", value1, value2, "id" );
            return this;
        }
        
        public Criteria andEmployeeNumIsNull() {
            addCriterion( "employee_num is null" );
            return this;
        }
        
        public Criteria andEmployeeNumIsNotNull() {
            addCriterion( "employee_num is not null" );
            return this;
        }
        
        public Criteria andEmployeeNumEqualTo( String value ) {
            addCriterion( "employee_num =", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumNotEqualTo( String value ) {
            addCriterion( "employee_num <>", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumGreaterThan( String value ) {
            addCriterion( "employee_num >", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumGreaterThanOrEqualTo( String value ) {
            addCriterion( "employee_num >=", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumLessThan( String value ) {
            addCriterion( "employee_num <", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumLessThanOrEqualTo( String value ) {
            addCriterion( "employee_num <=", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumLike( String value ) {
            addCriterion( "employee_num like", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumNotLike( String value ) {
            addCriterion( "employee_num not like", value, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumIn( List values ) {
            addCriterion( "employee_num in", values, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumNotIn( List values ) {
            addCriterion( "employee_num not in", values, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumBetween( String value1, String value2 ) {
            addCriterion( "employee_num between", value1, value2, "employeeNum" );
            return this;
        }
        
        public Criteria andEmployeeNumNotBetween( String value1, String value2 ) {
            addCriterion( "employee_num not between", value1, value2, "employeeNum" );
            return this;
        }
        
        public Criteria andRealNameIsNull() {
            addCriterion( "real_name is null" );
            return this;
        }
        
        public Criteria andRealNameIsNotNull() {
            addCriterion( "real_name is not null" );
            return this;
        }
        
        public Criteria andRealNameEqualTo( String value ) {
            addCriterion( "real_name =", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameNotEqualTo( String value ) {
            addCriterion( "real_name <>", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameGreaterThan( String value ) {
            addCriterion( "real_name >", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameGreaterThanOrEqualTo( String value ) {
            addCriterion( "real_name >=", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameLessThan( String value ) {
            addCriterion( "real_name <", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameLessThanOrEqualTo( String value ) {
            addCriterion( "real_name <=", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameLike( String value ) {
            addCriterion( "real_name like", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameNotLike( String value ) {
            addCriterion( "real_name not like", value, "realName" );
            return this;
        }
        
        public Criteria andRealNameIn( List values ) {
            addCriterion( "real_name in", values, "realName" );
            return this;
        }
        
        public Criteria andRealNameNotIn( List values ) {
            addCriterion( "real_name not in", values, "realName" );
            return this;
        }
        
        public Criteria andRealNameBetween( String value1, String value2 ) {
            addCriterion( "real_name between", value1, value2, "realName" );
            return this;
        }
        
        public Criteria andRealNameNotBetween( String value1, String value2 ) {
            addCriterion( "real_name not between", value1, value2, "realName" );
            return this;
        }
        
        public Criteria andTelIsNull() {
            addCriterion( "tel is null" );
            return this;
        }
        
        public Criteria andTelIsNotNull() {
            addCriterion( "tel is not null" );
            return this;
        }
        
        public Criteria andTelEqualTo( String value ) {
            addCriterion( "tel =", value, "tel" );
            return this;
        }
        
        public Criteria andTelNotEqualTo( String value ) {
            addCriterion( "tel <>", value, "tel" );
            return this;
        }
        
        public Criteria andTelGreaterThan( String value ) {
            addCriterion( "tel >", value, "tel" );
            return this;
        }
        
        public Criteria andTelGreaterThanOrEqualTo( String value ) {
            addCriterion( "tel >=", value, "tel" );
            return this;
        }
        
        public Criteria andTelLessThan( String value ) {
            addCriterion( "tel <", value, "tel" );
            return this;
        }
        
        public Criteria andTelLessThanOrEqualTo( String value ) {
            addCriterion( "tel <=", value, "tel" );
            return this;
        }
        
        public Criteria andTelLike( String value ) {
            addCriterion( "tel like", value, "tel" );
            return this;
        }
        
        public Criteria andTelNotLike( String value ) {
            addCriterion( "tel not like", value, "tel" );
            return this;
        }
        
        public Criteria andTelIn( List values ) {
            addCriterion( "tel in", values, "tel" );
            return this;
        }
        
        public Criteria andTelNotIn( List values ) {
            addCriterion( "tel not in", values, "tel" );
            return this;
        }
        
        public Criteria andTelBetween( String value1, String value2 ) {
            addCriterion( "tel between", value1, value2, "tel" );
            return this;
        }
        
        public Criteria andTelNotBetween( String value1, String value2 ) {
            addCriterion( "tel not between", value1, value2, "tel" );
            return this;
        }
        
        public Criteria andDeptIdIsNull() {
            addCriterion( "dept_id is null" );
            return this;
        }
        
        public Criteria andDeptIdIsNotNull() {
            addCriterion( "dept_id is not null" );
            return this;
        }
        
        public Criteria andDeptIdEqualTo( Integer value ) {
            addCriterion( "dept_id =", value, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdNotEqualTo( Integer value ) {
            addCriterion( "dept_id <>", value, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdGreaterThan( Integer value ) {
            addCriterion( "dept_id >", value, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "dept_id >=", value, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdLessThan( Integer value ) {
            addCriterion( "dept_id <", value, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "dept_id <=", value, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdIn( List values ) {
            addCriterion( "dept_id in", values, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdNotIn( List values ) {
            addCriterion( "dept_id not in", values, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "dept_id between", value1, value2, "deptId" );
            return this;
        }
        
        public Criteria andDeptIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "dept_id not between", value1, value2, "deptId" );
            return this;
        }
        
        public Criteria andUserIdIsNull() {
            addCriterion( "user_id is null" );
            return this;
        }
        
        public Criteria andUserIdIsNotNull() {
            addCriterion( "user_id is not null" );
            return this;
        }
        
        public Criteria andUserIdEqualTo( Integer value ) {
            addCriterion( "user_id =", value, "userId" );
            return this;
        }
        
        public Criteria andUserIdNotEqualTo( Integer value ) {
            addCriterion( "user_id <>", value, "userId" );
            return this;
        }
        
        public Criteria andUserIdGreaterThan( Integer value ) {
            addCriterion( "user_id >", value, "userId" );
            return this;
        }
        
        public Criteria andUserIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "user_id >=", value, "userId" );
            return this;
        }
        
        public Criteria andUserIdLessThan( Integer value ) {
            addCriterion( "user_id <", value, "userId" );
            return this;
        }
        
        public Criteria andUserIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "user_id <=", value, "userId" );
            return this;
        }
        
        public Criteria andUserIdIn( List values ) {
            addCriterion( "user_id in", values, "userId" );
            return this;
        }
        
        public Criteria andUserIdNotIn( List values ) {
            addCriterion( "user_id not in", values, "userId" );
            return this;
        }
        
        public Criteria andUserIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "user_id between", value1, value2, "userId" );
            return this;
        }
        
        public Criteria andUserIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "user_id not between", value1, value2, "userId" );
            return this;
        }
        
        public Criteria andSexIsNull() {
            addCriterion( "sex is null" );
            return this;
        }
        
        public Criteria andSexIsNotNull() {
            addCriterion( "sex is not null" );
            return this;
        }
        
        public Criteria andSexEqualTo( Integer value ) {
            addCriterion( "sex =", value, "sex" );
            return this;
        }
        
        public Criteria andSexNotEqualTo( Integer value ) {
            addCriterion( "sex <>", value, "sex" );
            return this;
        }
        
        public Criteria andSexGreaterThan( Integer value ) {
            addCriterion( "sex >", value, "sex" );
            return this;
        }
        
        public Criteria andSexGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "sex >=", value, "sex" );
            return this;
        }
        
        public Criteria andSexLessThan( Integer value ) {
            addCriterion( "sex <", value, "sex" );
            return this;
        }
        
        public Criteria andSexLessThanOrEqualTo( Integer value ) {
            addCriterion( "sex <=", value, "sex" );
            return this;
        }
        
        public Criteria andSexIn( List values ) {
            addCriterion( "sex in", values, "sex" );
            return this;
        }
        
        public Criteria andSexNotIn( List values ) {
            addCriterion( "sex not in", values, "sex" );
            return this;
        }
        
        public Criteria andSexBetween( Integer value1, Integer value2 ) {
            addCriterion( "sex between", value1, value2, "sex" );
            return this;
        }
        
        public Criteria andSexNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "sex not between", value1, value2, "sex" );
            return this;
        }
        
        public Criteria andIsGuiderIsNull() {
            addCriterion( "is_guider is null" );
            return this;
        }
        
        public Criteria andIsGuiderIsNotNull() {
            addCriterion( "is_guider is not null" );
            return this;
        }
        
        public Criteria andIsGuiderEqualTo( Integer value ) {
            addCriterion( "is_guider =", value, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderNotEqualTo( Integer value ) {
            addCriterion( "is_guider <>", value, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderGreaterThan( Integer value ) {
            addCriterion( "is_guider >", value, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "is_guider >=", value, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderLessThan( Integer value ) {
            addCriterion( "is_guider <", value, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderLessThanOrEqualTo( Integer value ) {
            addCriterion( "is_guider <=", value, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderIn( List values ) {
            addCriterion( "is_guider in", values, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderNotIn( List values ) {
            addCriterion( "is_guider not in", values, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderBetween( Integer value1, Integer value2 ) {
            addCriterion( "is_guider between", value1, value2, "isGuider" );
            return this;
        }
        
        public Criteria andIsGuiderNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "is_guider not between", value1, value2, "isGuider" );
            return this;
        }
        
        public Criteria andIsDelIsNull() {
            addCriterion( "is_del is null" );
            return this;
        }
        
        public Criteria andIsDelIsNotNull() {
            addCriterion( "is_del is not null" );
            return this;
        }
        
        public Criteria andIsDelEqualTo( String value ) {
            addCriterion( "is_del =", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotEqualTo( String value ) {
            addCriterion( "is_del <>", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelGreaterThan( String value ) {
            addCriterion( "is_del >", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelGreaterThanOrEqualTo( String value ) {
            addCriterion( "is_del >=", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelLessThan( String value ) {
            addCriterion( "is_del <", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelLessThanOrEqualTo( String value ) {
            addCriterion( "is_del <=", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelLike( String value ) {
            addCriterion( "is_del like", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotLike( String value ) {
            addCriterion( "is_del not like", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelIn( List values ) {
            addCriterion( "is_del in", values, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotIn( List values ) {
            addCriterion( "is_del not in", values, "isDel" );
            return this;
        }
        
        public Criteria andIsDelBetween( String value1, String value2 ) {
            addCriterion( "is_del between", value1, value2, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotBetween( String value1, String value2 ) {
            addCriterion( "is_del not between", value1, value2, "isDel" );
            return this;
        }
        
        public Criteria andHeadIsNull() {
            addCriterion( "head is null" );
            return this;
        }
        
        public Criteria andHeadIsNotNull() {
            addCriterion( "head is not null" );
            return this;
        }
        
        public Criteria andHeadEqualTo( String value ) {
            addCriterion( "head =", value, "head" );
            return this;
        }
        
        public Criteria andHeadNotEqualTo( String value ) {
            addCriterion( "head <>", value, "head" );
            return this;
        }
        
        public Criteria andHeadGreaterThan( String value ) {
            addCriterion( "head >", value, "head" );
            return this;
        }
        
        public Criteria andHeadGreaterThanOrEqualTo( String value ) {
            addCriterion( "head >=", value, "head" );
            return this;
        }
        
        public Criteria andHeadLessThan( String value ) {
            addCriterion( "head <", value, "head" );
            return this;
        }
        
        public Criteria andHeadLessThanOrEqualTo( String value ) {
            addCriterion( "head <=", value, "head" );
            return this;
        }
        
        public Criteria andHeadLike( String value ) {
            addCriterion( "head like", value, "head" );
            return this;
        }
        
        public Criteria andHeadNotLike( String value ) {
            addCriterion( "head not like", value, "head" );
            return this;
        }
        
        public Criteria andHeadIn( List values ) {
            addCriterion( "head in", values, "head" );
            return this;
        }
        
        public Criteria andHeadNotIn( List values ) {
            addCriterion( "head not in", values, "head" );
            return this;
        }
        
        public Criteria andHeadBetween( String value1, String value2 ) {
            addCriterion( "head between", value1, value2, "head" );
            return this;
        }
        
        public Criteria andHeadNotBetween( String value1, String value2 ) {
            addCriterion( "head not between", value1, value2, "head" );
            return this;
        }
    }


    protected int limitStart = 0;
    protected int limitEnd = 20;
    
    public int getLimitStart() {
        return limitStart;
    }

    
    public void setLimitStart( int limitStart ) {
        this.limitStart = limitStart;
    }

    
    public int getLimitEnd() {
        return limitEnd;
    }

    
    public void setLimitEnd( int limitEnd ) {
        this.limitEnd = limitEnd;
    }
}