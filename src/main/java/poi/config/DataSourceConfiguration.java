package poi.config;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.GreedyCacheSqlFileRepository;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Component;

@Component
public class DataSourceConfiguration implements Config  {
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	private DataSource dataSource;

	private Dialect dialect;

	private SqlFileRepository sqlFileRepository;

	private int queryTimeout;

	public DataSourceConfiguration() {
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = new TransactionAwareDataSourceProxy(dataSource);
	}

	@Autowired
	public void setDialect(@Value("${doma.dialect}") String domaDialect)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		this.dialect = (Dialect) Class.forName(domaDialect).newInstance();
	}

	@Autowired
	public void setSqlFileRepository(@Value("${spring.profiles.active}") String springProfilesActive) {
		if (!StringUtils.equals(springProfilesActive, "product")) {
			this.sqlFileRepository = new NoCacheSqlFileRepository();
		} else {
			this.sqlFileRepository = new GreedyCacheSqlFileRepository();
		}
	}

	@Autowired
	public void setQueryTimeout(@Value("${doma.queryTimeout}") int queryTimeout) {
		this.queryTimeout = queryTimeout;
	}

	@Override
	public DataSource getDataSource() {
		return this.dataSource;
	}

	@Override
	public Dialect getDialect() {
		return this.dialect;
	}

	@Override
	public SqlFileRepository getSqlFileRepository() {
		return this.sqlFileRepository;
	}

	@Override
	public int getQueryTimeout() {
		return this.queryTimeout;
	}
}