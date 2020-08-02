package io;

import com.mybatis.config.MybatisUtils;
import com.mybatis.io.dao.BilDao;
import com.mybatis.io.dao.UserDao;
import com.mybatis.io.entities.Bill;
import com.mybatis.io.entities.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillDaoTest {

    static Logger logger = Logger.getLogger(BillDaoTest.class);

    @Test
    public void getBillList(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            // 1.执行 getmapper
            BilDao dao = sqlSession.getMapper(BilDao.class);
            List<Bill> userList = dao.getBillList();
            for(Bill b: userList){
                System.out.println(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            sqlSession.close();
        }
    }


}
