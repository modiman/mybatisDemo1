package com.hello.pojo;
//如果遇到报错 Mapped Statements collection does not contain value for ShowTables
/* 1.检查TableMapper的namespace
   2.检查mybatis的resources是否添加TableMapper.xml
 */
//查询数据库中的表名,对应tables表
//即实现show tables 操作

public class Table {
    //四个成员变量与表tables 中的四个属性一一对应
    private String name;
    private int id;
    private String describ;
    private int attrib_num;

    public void setName(String name){name = this.name;}
    public String getName(){return name;}

    public void setId(int id){id = this.id;}
    public int getId(){return id;}

    public void setDescrib(String describ){describ = this.describ;}
    public String getDescrib(){return  describ;}

    public void setAttrib_num(int attrib_num){attrib_num = this.attrib_num;}
    public int getAttrib_num(){return attrib_num;}


}
