package io;

import com.mybatis.config.MybatisUtils;
import com.mybatis.io.dao.StudentDao;
import com.mybatis.io.dao.TeacherDao;
import com.mybatis.io.entities.Student;
import com.mybatis.io.entities.Teacher;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

@Log4j
public class TeacherDaoTest {


    // 二级缓存
    @Test

    public void getTeacher(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        TeacherDao dao = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacher = dao.getTeacher();
        System.out.println("第一次查");
        for(Teacher s: teacher){
            System.out.println(s);
        }
        //关闭
        sqlSession.close();

        TeacherDao dao2 = sqlSession2.getMapper(TeacherDao.class);
        List<Teacher> teacher2 = dao2.getTeacher();
        System.out.println("第二次查");
        for(Teacher s: teacher2){
            System.out.println(s);
        }


        sqlSession2.close();
    }




}
