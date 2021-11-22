package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseTest {
    public static void main(String[] args) {

        class JdbcUtils {

            private static String driver = null;
            private static String url = null;
            private static String username = null;
            private static String password = null;

            static {
                try {
                    InputStream in = new FileInputStream("src/database/db.properties");
                    Properties prop = new Properties();
                    prop.load(in);

                    driver = prop.getProperty("driver");
                    url = prop.getProperty("url");
                    username = prop.getProperty("username");
                    password = prop.getProperty("password");

                    Class.forName(driver);

                } catch (Exception e) {
                    throw new ExceptionInInitializerError(e);
                }
            }

            public static Connection getConnection() throws SQLException {
                return DriverManager.getConnection(url, username, password);
            }

            public static void release(Connection conn, Statement st, ResultSet rs) {

                if (rs != null) {
                    try {
                        rs.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    rs = null;

                }
                if (st != null) {
                    try {
                        st.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        class JdbcQuery {

            final class LoginRes {
                public static final int ERROR = 0;
                public static final int OK = 1;
                public static final int USER_NOT_EXIST = 2;
                public static final int PASSWORD_FAILED = 3;
            }

            public static int getAdmin(String name, String password){
                String sql1 = "select * from library_system.users where name = ?";
                String sql2 = "select * from library_system.users where name = ? and password = ?";
                int res;
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try{
                    conn = JdbcUtils.getConnection();
                    st = conn.prepareStatement(sql1);
                    st.setString(1, name);
                    rs = st.executeQuery();
                    if(rs.next()){
                        st = conn.prepareStatement(sql2);
                        st.setString(1, name);
                        st.setString(2, password);
                        rs = st.executeQuery();
                        if (rs.next()){
                            System.out.println("登录成功");
                            res = LoginRes.OK;
                        }
                        else {
                            System.out.println("密码错误");
                            res = LoginRes.PASSWORD_FAILED;
                        }
                    }
                    else{
                        System.out.println("用户不存在");
                        res = LoginRes.USER_NOT_EXIST;
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    res = LoginRes.ERROR;
                }
                finally{
                    JdbcUtils.release(conn, st, rs);
                }
                return res;
            }

            public static int getStudent(int id, String password){
                String sql1 = "select * from library_system.student_info where id = ?";
                String sql2 = "select * from library_system.student_info where id = ? and password = ?";
                int res;
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try{
                    conn = JdbcUtils.getConnection();
                    st = conn.prepareStatement(sql1);
                    st.setInt(1, id);
                    rs = st.executeQuery();
                    if(rs.next()){
                        st = conn.prepareStatement(sql2);
                        st.setInt(1, id);
                        st.setString(2, password);
                        rs = st.executeQuery();
                        if (rs.next()){
                            System.out.println("登录成功");
                            res = LoginRes.OK;
                        }
                        else {
                            System.out.println("密码错误");
                            res = LoginRes.PASSWORD_FAILED;
                        }
                    }
                    else{
                        System.out.println("用户不存在");
                        res = LoginRes.USER_NOT_EXIST;
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    res = LoginRes.ERROR;
                }
                finally{
                    JdbcUtils.release(conn, st, rs);
                }
                return res;
            }

        }

//        JdbcQuery.getAdmin("admin", "12345678");
        JdbcQuery.getStudent(1001, "12345678");
    }
}
