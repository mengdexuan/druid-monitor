package com.druid.monitor.druid;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mengdexuan on 2018/11/11 21:00.
 */
@Configuration
public class DataSourceConfig {

	@Bean("dataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {

		DruidDataSource druidDataSource = new DruidDataSource();

		List<Filter> filters = new ArrayList<>();
		filters.add(slf4jLogFilter());
		filters.add(filterEvent());

		druidDataSource.setProxyFilters(filters);

		return druidDataSource;
	}


	@Bean
	public Slf4jLogFilter slf4jLogFilter(){
		Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();

		slf4jLogFilter.setConnectionLogEnabled(false);
		slf4jLogFilter.setStatementLogEnabled(false);
		slf4jLogFilter.setResultSetLogEnabled(true);
		slf4jLogFilter.setStatementExecutableSqlLogEnable(true);

		return slf4jLogFilter;
	}

	@Bean
	public FilterEvent filterEvent(){

		return new FilterEvent();
	}
}
