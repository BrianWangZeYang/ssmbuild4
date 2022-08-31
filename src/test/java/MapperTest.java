import com.kuang.dao.BooksMapper;
import com.kuang.pojo.Books;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * @author xxx
 * @version 1.0
 * @Description
 * @date 2022/8/30 20:52
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    /**
     * 测试DepartmentMapper
     */
    @Autowired
    BooksMapper booksMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){
       /* //1、创建SpringIoc容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、从容器中获取mapper
        BooksMapper bean = ioc.getBean(BooksMapper.class);*/
        //测试是否可以拿到Mapper
        //System.out.println(booksMapper);
        //测试调用增删改查方法
        //booksMapper.insertSelective(new Books(null,"三国演义2",100,"东汉末年，天下大乱"));
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        //3、测试  批量插入员工；使用可以执行批量操作的sqlSession，在spring容器中注入一个可以执行批量操作德sqlSession对象
        for(int i =0;i<200;i++){
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Books(null,uid,i,"测试数据"));
        }
        System.out.println("批量完成");


    }
}
