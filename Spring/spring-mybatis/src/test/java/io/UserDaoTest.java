package io;

import com.mybatis.config.MybatisUtils;
import com.mybatis.io.dao.UserDao;
import com.mybatis.io.entities.User;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.junit.Test;

import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class UserDaoTest {

    //static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserList(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            for(User user: userList){
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    // 模糊查询
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.getUserLike("a");
        for(User user : list){
            System.out.println(user);
        }
    }

    // resultMap的映射使用
    @Test
    public void getUserListTestResultMap(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserListMap();
            System.out.println(userList);
            for(User user: userList){
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    //Log4j 使用
    @Test
    public void  testLog4j(){
//        logger.info("info:进入了testlog4j");
//        logger.debug("debug:进入了testlog4j");
//        logger.error("error:进入了testlog4j");

        //注解开发  @Log4j 在类上
        //log.info("info:进入了testlog4j");
        //log.debug("info:进入了testlog4j");
        //log.error("info:进入了testlog4j");
    }

    //分页查询
    @Test
    public void getUserPaging(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            //准备数据
            int currentPage = 2; //当前是第几页
            int pageSize = 3;   //页面大小,显示几条数据

            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("startIndex",(currentPage-1)*pageSize);
            map.put("pageSize",pageSize);
            List<User> userList = userDao.getUserPaging(map);
            System.out.println(userList);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    //动态sql if
    @Test
    public void getUserIf(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            Integer gender =  1;
            Integer userType = 2;
            List<User> userlist = userDao.getUserIf(gender, null);
            for(User user: userlist){
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

    //动态sql Choose
    @Test
    public void getUserChoose(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            Integer gender =  1;
            Integer userType = 2;
            User userO = new User();
            //userO.setGender(1);
            //userO.setUserType(2);
            //userO.setUsername("wangwu");
            List<User> userlist = userDao.getUserChoose(null);
            for(User user: userlist){
                System.out.println(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }


    //动态sql set 更新
    @Test
    public void setUser(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User u = new User();
        u.setId(12);
        //u.setUsername("2aaaa");
        u.setGender(2);
        u.setUserType(1);
        int i = userDao.setUser(u);
        System.out.println(i);
        // 提交
        sqlSession.commit();
        sqlSession.close();
    }

    //动态sql foreach 查询
    @Test
    public void getUserByIdList(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
            List<Integer> idss = new ArrayList();
            idss.add(1);
            idss.add(3);
            map.put("ids",idss);
            List<User> userList = userDao.getUserByIdList(map);
            System.out.println(userList);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }

}
