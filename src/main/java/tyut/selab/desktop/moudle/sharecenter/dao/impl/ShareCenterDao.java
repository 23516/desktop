package tyut.selab.desktop.moudle.sharecenter.dao.impl;

import tyut.selab.desktop.moudle.sharecenter.controller.IShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.dao.IShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.student.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShareCenterDao extends BaseDao implements IShareCenterDao {
    @Override
    public List<BugMessage> queryAllBugInfo() throws Exception {
        String sql = "select * from user_bug_message;";
        ArrayList<BugMessage> list = query(BugMessage.class, sql);
        return list;
    }

    /**
     * 还没写
     * @param bugType
     * @return null
     */
    @Override
    public List<BugMessage> queryBugInfoByType(List<String> bugType) {
        return null;
    }

    @Override
    public List<BugMessage> ShowBugInfo(User user) throws Exception {
        String sql = "select * from user_bug_message where user_student_number = ?;";
        ArrayList<BugMessage> list = query(BugMessage.class, sql,user.getStudentNumber());
        return list;
    }

    @Override
    public int insertBugInfo(BugMessage bugMessage) throws SQLException {
        String sql = "insert into user_bug_message values(null,?,?,?,?);";
        return executeUpdate(sql,bugMessage.getBugTitle(),bugMessage.getBugSolve(),bugMessage.getReleaseTime(),bugMessage.getReleaseTime());
    }

    /**
     *
     * 只更新解决方法 ？
     * @param newBugMessage
     * @param oldBugMessage
     * @return
     */
    @Override
    public int updateBugInfo(BugMessage newBugMessage, BugMessage oldBugMessage) {
        String sql = "update bug_type set  = ? where  = ?;";
        return executeUpdate(sql,);
    }

    @Override
    public int deleteBugInfo(BugMessage bugMessage) throws SQLException {
        String sql = "delete from bug_type where bug_id = ?";
        return executeUpdate(sql,bugMessage.getBugId());
    }
}
