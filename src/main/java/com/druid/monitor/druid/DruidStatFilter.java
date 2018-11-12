package com.druid.monitor.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author mengdexuan on 2018/11/11 21:03.
 */
@WebFilter(filterName="druidWebStatFilter",
		urlPatterns="/*",
		initParams={
				@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
		})
public class DruidStatFilter extends WebStatFilter {

}
