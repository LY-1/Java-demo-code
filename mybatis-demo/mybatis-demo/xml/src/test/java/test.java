import com.shu.mybatis.entity.Person;
import com.shu.mybatis.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        //注意此处路径不要写错
        String resource = "config/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。
     * 3、将sql映射文件注册在全局配置文件中
     * 4、写代码：
     * 1）、根据全局配置文件得到SqlSessionFactory；
     * 2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
     * 一个sqlSession就是代表和数据库的一次会话，用完关闭
     * 3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        //1、获取SqlSessionFactory实例
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2、打开一个会话
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象，会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            PersonMapper mapper = openSession.getMapper(PersonMapper.class);
//            Person person = mapper.getPersonById(1);
//            Person person = select(mapper);
//            System.out.println(person);
//            delete(mapper);
            update(mapper);
//            insert(mapper);
            openSession.commit();
        } finally {
            //4、使用完毕后关闭会话
            openSession.close();
        }
    }

    private Person select(PersonMapper mapper) {
        return mapper.getPersonById(1);
    }

    private void delete(PersonMapper mapper) {
        mapper.delPersonById(3);
    }

    private void update(PersonMapper mapper) {
        Person person = new Person();
        person.setId(1);
        person.setName("Tom");
        person.setAge(19);
        mapper.updatePerson(person);
    }

    private void insert(PersonMapper mapper) {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(19);
        person.setId(6);
        mapper.insertOnePerson(person);
    }
}
