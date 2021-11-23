package test;

import database.BookInfoPackage;

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

            enum LoginRes {
                ERROR,
                OK,
                USER_NOT_EXIST,
                PASSWORD_FAILED
            }

            public static LoginRes getAdmin(String name, String password){
                LoginRes res;
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try{
                    conn = JdbcUtils.getConnection();
                    st = conn.prepareStatement("select * from library_system.users where name = ?");
                    st.setString(1, name);
                    rs = st.executeQuery();
                    if(rs.next()){
                        st = conn.prepareStatement("select * from library_system.users where name = ? and password = ?");
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

            public static LoginRes getStudent(int id, String password){
                LoginRes res;
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;
                try{
                    conn = JdbcUtils.getConnection();
                    st = conn.prepareStatement("select * from library_system.student_info where id = ?");
                    st.setInt(1, id);
                    rs = st.executeQuery();
                    if(rs.next()){
                        st = conn.prepareStatement("select * from library_system.student_info where id = ? and password = ?");
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

        class JdbcAlter {

            enum AlterRes {
                ERROR,
                OK,
                BOOK_NOT_EXIST
            }

            public static AlterRes updateBookInfo(String id, BookInfoPackage pack){
                AlterRes res;
                Connection conn = null;
                PreparedStatement st = null;
                ResultSet rs = null;

                try{
                    conn = JdbcUtils.getConnection();
                    st = conn.prepareStatement("select * from library_system.books where id = ?");
                    st.setString(1, id);
                    rs = st.executeQuery();
                    if (rs.next()) {  // 找到这本书
                        String oldId = rs.getString("id");
                        if (pack.getId() != null) {
                            st = conn.prepareStatement("update library_system.books set id = ? where id = ?");
                            st.setString(1, pack.getId());
                            st.setString(2, oldId);
                            st.executeQuery();
                        }
                        if (pack.getAuthor() != null) {
                            st = conn.prepareStatement("update library_system.books set author = ? where id = ?");
                            st.setString(1, pack.getAuthor());
                            st.setString(2, oldId);
                            st.executeQuery();
                        }
                        if (pack.getName() != null) {
                            st = conn.prepareStatement("update library_system.books set name = ? where id = ?");
                            st.setString(1, pack.getName());
                            st.setString(2, oldId);
                            st.executeQuery();
                        }
                        if (pack.getPublisher() != null) {
                            st = conn.prepareStatement("update library_system.books set publisher = ? where id = ?");
                            st.setString(1, pack.getPublisher());
                            st.setString(2, oldId);
                            st.executeQuery();
                        }
                        if (pack.getFront() != null) {
                            st = conn.prepareStatement("update library_system.books set front = ? where id = ?");
                            st.setBinaryStream(1, pack.getFront());
                            st.setString(2, oldId);
                            st.executeQuery();
                        }
                        res = AlterRes.OK;
                    }
                    else {
                        res = AlterRes.BOOK_NOT_EXIST;
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    res = AlterRes.ERROR;
                }
                finally{
                    JdbcUtils.release(conn, st, rs);
                }
                return res;
            }

            public static void addBookInfo(){

            }

            public static void deleteBookInfo(){

            }

        }

//        JdbcQuery.getAdmin("admin", "12345678");
//        JdbcQuery.getStudent(1001, "12345678");
    }
}
