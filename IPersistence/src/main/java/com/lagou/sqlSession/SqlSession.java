package com.lagou.sqlSession;

import java.util.List;

public interface SqlSession {

    //查询所有
    public <E> List<E> selectList(String statementid,Object... params) throws Exception;

    //根据条件查询单个
    public <T> T selectOne(String statementid,Object... params) throws Exception;


    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);

    /**
     * 新增
     * @param statementId
     * @param params
     * @return
     */
    int insert(String statementId, Object... params) throws Exception;

    /**
     * 更新
     * @param statementId
     * @param params
     * @return
     */
    int update(String statementId, Object... params) throws Exception;

    /**
     * 删除
     * @param statementId
     * @param params
     * @return
     */
    int delete(String statementId, Object... params) throws Exception;


}
