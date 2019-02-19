package com.percy.dao;

/**
 * @author percy
 * @create 2019-02-15  下午7:13
 * @descreption:
 **/

import java.util.List;

/**
 * 所有表格对象的顶层抽象接口
 * @param <T>   表的对象
 * @param <K>   表的主键
 */
public interface IDAO<T,K> {
    /**
     * 添加一条记录
     * @param vo 对象
     * @return 影响的行数
     */
    public int doCreate(T vo);

    /**
     * 根据id删除一条记录
     * @param id 表的主键
     * @return
     */
    public int doDelete(K id);

    /**
     * 更新一条记录
     * @param vo 对象
     * @return 影响的行数
     */
    public int doUpdata(T vo);

    /**
     * 查找所有记录
     * @return 返回记录的集合
     */
    public List<T> doFindAll();

    /**
     * 更具id查找一条记录
     * @param id  表的主键
     * @return 一条记录
     */
    public T doFindById(K id);
}
