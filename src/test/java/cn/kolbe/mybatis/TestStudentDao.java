package cn.kolbe.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

public class TestStudentDao {

    @Test
    public void testGetStudent() throws Exception {
        // 1. 加载MyBatis的配置文件：mybatis.xml（它也加载关联的映射文件，也就是mappers结点下的映射文件）
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("cn/kolbe/mybatis/mybatis.xml");
        // 2. SqlSessionFactoryBuidler实例将通过输入流调用build方法来构建 SqlSession 工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 3. 通过工厂获取 SqlSession 实例，SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。
        SqlSession session = sqlSessionFactory.openSession();
        // 4. 准备基本信息
        // 4.1) statement: 用来定位映射文件（StudentMapper.xml）中的语句（通过namespace id + select id)
        String statement = "cn.kolbe.mybatis.mapper.StudentMapper.getStudent";
        // 4.2) paramter: 传进去的参数，也就是需要获取students表中主键值为1的记录
        int parameter = 1;
        // 5. SqlSession 实例来直接执行已映射的 SQL 语句，selectOne表示获取的是一条记录
        Student student = session.selectOne(statement, parameter);
        System.out.println(student);

        // 6. 关闭输入流和SqlSession实例
        in.close();
        session.close();
    }
}
