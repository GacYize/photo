package com.alice.photo.config.mybatis;

import com.github.abel533.sql.SqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnClass({SqlMapper.class})
public class SqlMapperConfiguration {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public SqlMapperConfiguration(){
	}

	@Bean
	@ConditionalOnMissingBean
	public SqlMapper sqlMapper(){
		return new SqlMapper(sqlSessionFactory.openSession());
	}
}
