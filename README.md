# mybatis-first

基于spring boot运行的mybatis 增删改查

## start

+ 启动项目：右键Application，然后点击Run 'Application.main()'

+ 测试：在postman上 执行增删改查的操作

|操作|请求方法|url|参数|
|----|----|----|----|
|分页查询|GET|http://localhost:8080/users?pageNo=1&pageSize=2||
|查询一条|GET|http://localhost:8080/users/1||
|新增|POST|http://localhost:8080/users|{"name":"大彪","age":20,"email":"dabiao@baomidou.com"}|
|修改|PUT|http://localhost:8080/user/1|{"name":"Jone8"}|
|删除|DELETE|http://localhost:8080/user/2||
|批量插入或更新|POST|http://localhost:8080/users/batch|[{"id":1,"name":"虎子","age":20,"email":"huzi@baomidou.com"},{"name":"呆狗","age":20,"email":"daigou@baomidou.com"}]|

## 引用

https://github.com/baomidou/mybatis-plus-samples