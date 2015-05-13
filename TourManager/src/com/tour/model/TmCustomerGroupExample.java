package com.tour.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TmCustomerGroupExample {
    
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
    
    /**
     * This field was generated by Apache iBATIS ibator. This field corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    protected String orderByClause;
    /**
     * This field was generated by Apache iBATIS ibator. This field corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public TmCustomerGroupExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    protected TmCustomerGroupExample( TmCustomerGroupExample example ) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public void setOrderByClause( String orderByClause ) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public void or( Criteria criteria ) {
        oredCriteria.add( criteria );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add( criteria );
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table tm_customer_group
     * @ibatorgenerated  Wed May 13 15:02:13 CST 2015
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
        
        public Criteria andCustomerIdIsNull() {
            addCriterion( "customer_id is null" );
            return this;
        }
        
        public Criteria andCustomerIdIsNotNull() {
            addCriterion( "customer_id is not null" );
            return this;
        }
        
        public Criteria andCustomerIdEqualTo( Integer value ) {
            addCriterion( "customer_id =", value, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdNotEqualTo( Integer value ) {
            addCriterion( "customer_id <>", value, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdGreaterThan( Integer value ) {
            addCriterion( "customer_id >", value, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "customer_id >=", value, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdLessThan( Integer value ) {
            addCriterion( "customer_id <", value, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "customer_id <=", value, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdIn( List values ) {
            addCriterion( "customer_id in", values, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdNotIn( List values ) {
            addCriterion( "customer_id not in", values, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "customer_id between", value1, value2, "customerId" );
            return this;
        }
        
        public Criteria andCustomerIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "customer_id not between", value1, value2, "customerId" );
            return this;
        }
        
        public Criteria andGroupIdIsNull() {
            addCriterion( "group_id is null" );
            return this;
        }
        
        public Criteria andGroupIdIsNotNull() {
            addCriterion( "group_id is not null" );
            return this;
        }
        
        public Criteria andGroupIdEqualTo( Integer value ) {
            addCriterion( "group_id =", value, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdNotEqualTo( Integer value ) {
            addCriterion( "group_id <>", value, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdGreaterThan( Integer value ) {
            addCriterion( "group_id >", value, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "group_id >=", value, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdLessThan( Integer value ) {
            addCriterion( "group_id <", value, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "group_id <=", value, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdIn( List values ) {
            addCriterion( "group_id in", values, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdNotIn( List values ) {
            addCriterion( "group_id not in", values, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "group_id between", value1, value2, "groupId" );
            return this;
        }
        
        public Criteria andGroupIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "group_id not between", value1, value2, "groupId" );
            return this;
        }
        
        public Criteria andEnterTimeIsNull() {
            addCriterion( "enter_time is null" );
            return this;
        }
        
        public Criteria andEnterTimeIsNotNull() {
            addCriterion( "enter_time is not null" );
            return this;
        }
        
        public Criteria andEnterTimeEqualTo( Integer value ) {
            addCriterion( "enter_time =", value, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeNotEqualTo( Integer value ) {
            addCriterion( "enter_time <>", value, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeGreaterThan( Integer value ) {
            addCriterion( "enter_time >", value, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "enter_time >=", value, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeLessThan( Integer value ) {
            addCriterion( "enter_time <", value, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeLessThanOrEqualTo( Integer value ) {
            addCriterion( "enter_time <=", value, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeIn( List values ) {
            addCriterion( "enter_time in", values, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeNotIn( List values ) {
            addCriterion( "enter_time not in", values, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeBetween( Integer value1, Integer value2 ) {
            addCriterion( "enter_time between", value1, value2, "enterTime" );
            return this;
        }
        
        public Criteria andEnterTimeNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "enter_time not between", value1, value2, "enterTime" );
            return this;
        }
        
        public Criteria andOperIdIsNull() {
            addCriterion( "oper_id is null" );
            return this;
        }
        
        public Criteria andOperIdIsNotNull() {
            addCriterion( "oper_id is not null" );
            return this;
        }
        
        public Criteria andOperIdEqualTo( Integer value ) {
            addCriterion( "oper_id =", value, "operId" );
            return this;
        }
        
        public Criteria andOperIdNotEqualTo( Integer value ) {
            addCriterion( "oper_id <>", value, "operId" );
            return this;
        }
        
        public Criteria andOperIdGreaterThan( Integer value ) {
            addCriterion( "oper_id >", value, "operId" );
            return this;
        }
        
        public Criteria andOperIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "oper_id >=", value, "operId" );
            return this;
        }
        
        public Criteria andOperIdLessThan( Integer value ) {
            addCriterion( "oper_id <", value, "operId" );
            return this;
        }
        
        public Criteria andOperIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "oper_id <=", value, "operId" );
            return this;
        }
        
        public Criteria andOperIdIn( List values ) {
            addCriterion( "oper_id in", values, "operId" );
            return this;
        }
        
        public Criteria andOperIdNotIn( List values ) {
            addCriterion( "oper_id not in", values, "operId" );
            return this;
        }
        
        public Criteria andOperIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "oper_id between", value1, value2, "operId" );
            return this;
        }
        
        public Criteria andOperIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "oper_id not between", value1, value2, "operId" );
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
    }
}