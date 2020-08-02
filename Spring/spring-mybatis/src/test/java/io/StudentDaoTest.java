package io;

import com.mybatis.config.MybatisUtils;
import com.mybatis.io.dao.BilDao;
import com.mybatis.io.dao.StudentDao;
import com.mybatis.io.entities.Bill;
import com.mybatis.io.entities.Student;
import com.mybatis.io.entities.Teacher;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

@Log4j
public class StudentDaoTest {


    // 多对一  association的使用
    @Test
    public void getBillList(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            StudentDao dao = sqlSession.getMapper(StudentDao.class);
            List<Student> userList = dao.getStudentList();
            for(Student s: userList){
                System.out.println(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }


    // 一对多  collection的使用
    @Test
    public void getTeacherbyTid(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            StudentDao dao = sqlSession.getMapper(StudentDao.class);
            int i = 1;
            Teacher list = dao.getTeacherbyTid(i);
            System.out.println(list);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
        //随机生成字符串
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(s);
    }

}
