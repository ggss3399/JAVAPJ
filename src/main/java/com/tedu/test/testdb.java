package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

public class testdb {
	
	Door door;
		@Test
		public void mydb() throws Exception {
			InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
			SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
			SqlSession session = fac.openSession();
			DoorMapper dao = session.getMapper(DoorMapper.class);
			List<Door> list = dao.findAll();
			for (Door door : list) {
				System.out.println(door);
			}
		}
}
