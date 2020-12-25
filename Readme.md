# 如果遇到报错 Mapped Statements collection does not contain value for ShowTables
## 1.检查TableMapper的namespace
## 2.检查mybatis的resources是否添加TableMapper.xml

### 在mapper文件夹下，一个xml文件对应一个pojo文件（如User类 Table类）同时对应一个数据库表
### 在给数据库表设置属性名时，避免设置例如 name 之类的名称，以免产生歧义，使mybatis的查询结果为null
