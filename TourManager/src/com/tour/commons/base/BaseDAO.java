package com.tour.commons.base;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class BaseDAO {

	/**
	 * Spring提供的SqlMapClientTemplate模板
	 */
	protected SqlMapClientTemplate sqlMapClientTemplate;

	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
}
