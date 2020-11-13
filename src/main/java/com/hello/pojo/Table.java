package com.hello.pojo;
//如果遇到报错 Mapped Statements collection does not contain value for ShowTables
/* 1.检查TableMapper的namespace
   2.检查mybatis的resources是否添加TableMapper.xml
 */
//查询数据库中的表名,对应tables表
//即实现show tables 操作

import java.util.HashMap;

public class Table {
    //四个成员变量与表tables 中的四个属性一一对应
    private String t_name;
    private int t_id;
    private String t_describ;
    private int t_attrib_num;

    public void setName(String t_name){t_name = this.t_name;}
    public String getName(){return t_name;}

    public void setId(int t_id){t_id = this.t_id;}
    public int getId(){return t_id;}

    public void setDescrib(String t_describ){t_describ = this.t_describ;}
    public String getDescrib(){return  t_describ;}

    public void setAttrib_num(int t_attrib_num){t_attrib_num = this.t_attrib_num;}
    public int getAttrib_num(){return t_attrib_num;}

    public HashMap<String,String> traver(Table table)
    {
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("t_name",table.getName());
        map.put("t_id","t"+table.getId());
        map.put("t_describ",table.getDescrib());
        map.put("t_attrib_num","t"+table.getAttrib_num());
        return map;
    }

}
