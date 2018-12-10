package com.springmvc.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.springmvc.domain.Testuser;


public class MyBatisTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		Testuser user = new Testuser("admin","female",23);
		session.insert("com.springmvc.mapper.TestuserMapper.save", user);
		session.commit();
		session.close();
	}

}
