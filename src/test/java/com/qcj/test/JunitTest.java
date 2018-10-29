package com.qcj.test;

import com.qcj.mapper.UserInfosMapper;
import com.qcj.pojo.UserInfos;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class JunitTest {
    /**
     * 测试 mybatis搭建是否完成
     *      如果成功：只用mybatis就搭建成功了
     */
    @Test
    public void testMybatis() throws IOException {
        //加载配置mysql文件
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = ssf.openSession(true);
        UserInfosMapper mapper = session.getMapper(UserInfosMapper.class);
        List<UserInfos> list = mapper.queryAll();
        for (UserInfos u:list) {
            System.out.println(u.getUname());
        }
        session.close();
    }
}
