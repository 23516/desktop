package tyut.selab.desktop.moudle.sharecenter.dao.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.student.domain.Role;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.utils.MysqlConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShareCenterDao extends BaseDao implements IShareCenterDao {
    @Override
    public List<BugMessage> queryAllBugInfo() throws Exception {
        BugMessage bugMessage = null;
        User user = null;
        Role role = null;

        String sql = "SELECT a.bug_id,a.bug_titile,a.bug_solve,a.release_time,d.*,e.duty,c.type\n" +
                "from user_bug_message as a \n" +
                "join user_bug_type as b\n" +
                "on a.bug_id = b.bug_id \n" +
                "join bug_type c\n" +
                "on b.bug_type_id = c.type_id\n" +
                "join user as d\n" +
                "on a.user_student_number = d.student_number\n" +
                "join user_role as e\n" +
                "on d.role_id = e.role_id\n" +
                ";";

        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //无占位符，不用赋值

        ResultSet resultSet = ps.executeQuery();
        ArrayList<BugMessage> list = new ArrayList<>();

        while(resultSet.next()){
            //封装对象
            bugMessage = new BugMessage();
            bugMessage.setBugId(resultSet.getInt("bug_id"));
            bugMessage.setBugTitle(resultSet.getString("bug_titile"));
            bugMessage.setBugSolve(resultSet.getString("bug_solve"));
            bugMessage.setReleaseTime(resultSet.getDate("release_time"));
            {
                user = new User();
                user.setAccountNumber(resultSet.getString("account_number"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setStudentNumber(resultSet.getInt("student_number"));
                user.setGender(resultSet.getInt("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setPost(resultSet.getString("post"));
                user.setRegisterTime(resultSet.getDate("register_time"));
                user.setLoginStatus(resultSet.getInt("login_status"));
                {
                    role = new Role(resultSet.getString("duty"));
                }
                user.setRole(role);
            }
            bugMessage.setUser(user);
            bugMessage.setBugType(resultSet.getString("type"));

            // 添加集合
            list.add(bugMessage);
        }

        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.free();
        }
        return list;
    }

    @Override
    public List<BugMessage> queryBugInfoByType(List<String> bugType) throws SQLException {
        BugMessage bugMessage = null;
        User user = null;
        Role role = null;

        StringBuffer sql = new StringBuffer("SELECT a.bug_id,a.bug_titile,a.bug_solve,a.release_time,d.*,e.duty,c.type\n" +
                "from user_bug_message as a \n" +
                "join user_bug_type as b\n" +
                "on a.bug_id = b.bug_id \n" +
                "join bug_type as c\n" +
                "on b.bug_type_id = c.type_id\n" +
                "join user as d\n" +
                "on a.user_student_number = d.student_number\n" +
                "join user_role as e\n" +
                "on d.role_id = e.role_id\n" +
                "where c.type = ? ");
        for (int i = 1; i < bugType.size(); i++) {
            sql.append("or c.type = ? ");
        }
        sql.append(";");

        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(String.valueOf(sql));
        //占位符赋值
        for (int i = 1; i <= bugType.size(); i++) {
            ps.setObject(i,bugType.get(i-1));
        }

        ResultSet resultSet = ps.executeQuery();
        ArrayList<BugMessage> list = new ArrayList<>();

        while(resultSet.next()){
            //封装对象
            bugMessage = new BugMessage();
            bugMessage.setBugId(resultSet.getInt("bug_id"));
            bugMessage.setBugTitle(resultSet.getString("bug_titile"));
            bugMessage.setBugSolve(resultSet.getString("bug_solve"));
            bugMessage.setReleaseTime(resultSet.getDate("release_time"));
            {
                user = new User();
                user.setAccountNumber(resultSet.getString("account_number"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setStudentNumber(resultSet.getInt("student_number"));
                user.setGender(resultSet.getInt("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setPost(resultSet.getString("post"));
                user.setRegisterTime(resultSet.getDate("register_time"));
                user.setLoginStatus(resultSet.getInt("login_status"));
                {
                    role = new Role(resultSet.getString("duty"));
                }
                user.setRole(role);
            }
            bugMessage.setUser(user);
            bugMessage.setBugType(resultSet.getString("type"));

            // 添加集合
            list.add(bugMessage);
        }

        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.free();
        }
        return list;
    }

    @Override
    public List<BugMessage> ShowBugInfo(User user) throws Exception {
        BugMessage bugMessage = null;

        String sql = "SELECT a.bug_id,a.bug_titile,a.bug_solve,a.release_time,c.type\n" +
                "from user_bug_message as a \n" +
                "join user_bug_type as b\n" +
                "on a.bug_id = b.bug_id \n" +
                "join bug_type c\n" +
                "on b.bug_type_id = c.type_id\n" +
                "where a.user_student_number = ?\n"+
                ";";

        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //占位符赋值
        ps.setObject(1,user.getStudentNumber());

        ResultSet resultSet = ps.executeQuery();
        ArrayList<BugMessage> list = new ArrayList<>();

        while(resultSet.next()){
            //封装对象
            bugMessage = new BugMessage();
            bugMessage.setBugId(resultSet.getInt("bug_id"));
            bugMessage.setBugTitle(resultSet.getString("bug_titile"));
            bugMessage.setBugSolve(resultSet.getString("bug_solve"));
            bugMessage.setReleaseTime(resultSet.getDate("release_time"));
            bugMessage.setUser(user);
            bugMessage.setBugType(resultSet.getString("type"));

            // 添加集合
            list.add(bugMessage);
        }

        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.free();
        }
        return list;
    }

    // TODO
    @Override
    public int insertBugInfo(BugMessage bugMessage) throws Exception {
        // 插入 user_bug_message 表数据
        String sql1 = "insert into user_bug_message values(null,?,?,?,?);";
        int i = executeUpdate(sql1, bugMessage.getBugTitle(), bugMessage.getBugSolve(),
                bugMessage.getReleaseTime(), bugMessage.getUser().getStudentNumber());
        // 查到 bug_type 对应的 id
        int bugTypeId = queryBugTypeId(bugMessage.getBugType());
        // 查到 bug 对应的 id
        // todo
        // 插入 user_bug_type 表数据
        String sql4 = "insert into user_bug_type values(?,?);";
        int j = executeUpdate(sql4, bugTypeId, );
        return i+j;
    }

    // TODO
    @Override
    public int updateBugInfo(BugMessage newBugMessage, BugMessage oldBugMessage) throws SQLException {
        String sql = "update bug_type set  = ? where  = ?;";
        executeUpdate(sql);
        return 0;
    }

    @Override
    public int deleteBugInfo(BugMessage bugMessage) throws SQLException {
        // 删 user_bug_message 表数据
        String sql1 = "DELETE FROM user_bug_message WHERE bug_id = ?;" ;
        int i = executeUpdate(sql1, (int) bugMessage.getBugId());
        // 删 user_bug_type 表数据
        String sql2 = "DELETE FROM user_bug_type WHERE bug_id = ?;" ;
        int j = executeUpdate(sql2, (int) bugMessage.getBugId());
        return i+j;
    }
    private int queryBugTypeId(String bugType) throws SQLException {
        String sql = "SELECT * FROM bug_type WHERE type = ?;";
        //获取连接
        Connection connection = MysqlConnect.getConnection();
        //创建PreparedStatement对象，对sql预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //占位符赋值
        ps.setObject(1,bugType);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            int bug_type_id = resultSet.getInt("type_id");
            return bug_type_id;
        }
        resultSet.close();
        ps.close();
        //这里检查下是否开启事务,开启不关闭连接,业务方法关闭!
        //没有开启事务的话,直接回收关闭即可!
        if (connection.getAutoCommit()) {
            //回收
            MysqlConnect.free();
        }
        return 0;
    }
}
