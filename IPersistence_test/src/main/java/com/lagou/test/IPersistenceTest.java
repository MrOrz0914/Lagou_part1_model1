package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class IPersistenceTest {

    private IUserDao userDao;

    @Before
    public void before() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);

    }


    /**
     * 新增用户
     */
    @Test
    public void insertUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("lisi");
        userDao.insertUser(user);
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("666");
        userDao.updateUser(user);
    }



    /**
     * 删除用户
     */
    @Test
    public void deleteUser() {

        userDao.deleteUser(3);
    }

    /**
     * 查询用户
     */
    @Test
    public void selectUser() throws Exception {
        User user = new User();
        user.setId(2);
        user.setUsername("tom");
        User ret = userDao.findByCondition(user);
        System.out.println(ret);
    }
}
