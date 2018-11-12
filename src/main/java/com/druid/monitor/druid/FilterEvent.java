package com.druid.monitor.druid;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.ResultSetProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.druid.monitor.util.HelpMe;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * @author mengdexuan on 2018/11/11 21:56.
 */
@Slf4j
public class FilterEvent extends FilterEventAdapter {


	@Override
	public ResultSetProxy preparedStatement_executeQuery(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
		ResultSetProxy resultSetProxy = super.preparedStatement_executeQuery(chain, statement);

		String sql = statement.getSql();
		String tableName = HelpMe.extractTableNameFromSql(sql);

		log.info("tableName:{}",tableName);

		return resultSetProxy;
	}


	@Override
	public ResultSetProxy statement_executeQuery(FilterChain chain, StatementProxy statement, String sql) throws SQLException {
		String tableName = HelpMe.extractTableNameFromSql(sql);

		log.info("tableName:{}",tableName);

		return super.statement_executeQuery(chain, statement, sql);
	}



	@Override
	public int preparedStatement_executeUpdate(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
		//insert update delete
		int result = super.preparedStatement_executeUpdate(chain, statement);

		String tableName = HelpMe.extractTableNameFromSql(statement.getSql());

		log.info("tableName:{}",tableName);

		return result;
	}

	@Override
	public int statement_executeUpdate(FilterChain chain, StatementProxy statement, String sql) throws SQLException {
		//insert update delete
		int result = super.statement_executeUpdate(chain, statement, sql);

		String tableName = HelpMe.extractTableNameFromSql(sql);

		log.info("tableName:{}",tableName);

		return result;
	}






}
