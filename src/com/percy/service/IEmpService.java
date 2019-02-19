package com.percy.service;

import com.percy.vo.Emp;

import java.util.List;

/**
 * @author percy
 * @create 2019-02-15  下午10:39
 * @descreption:
 **/
public interface IEmpService {
    /**
     * 查询emp表格的list
     * @return Emp对象的List集合
     */
    public List<Emp> list();

    /**
     * 添加记录
     * @param vo Emp对象
     * @return 影响的行数
     */
    public int insert(Emp vo);

    /**
     * 删除记录
     * @param id Emp的id
     * @return 影响的行数
     */
    public int delete(int id);

    /**
     * 更新记录
     * @param vo Emp对象
     * @return 影响的行数
     */
    public int update(Emp vo);

    /**
     * 根据Id查找
     * @param id id主键
     * @return Emp对象
     */
    public Emp findbyid(int id);
}
