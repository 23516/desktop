package tyut.selab.desktop.moudle.sharecenter.dao.impl;

import tyut.selab.desktop.moudle.sharecenter.dao.IBugTypeDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BugTypeDao extends BaseDao implements IBugTypeDao {
    @Override
    public List<BugType> queryAllType() throws Exception {
        String sql = "select * from bug_type;";
        ArrayList<BugType> list = query(BugType.class, sql);
        return list;
    }

    @Override
    public int insertBugType(BugType bugType) throws SQLException {
        String sql = "insert into bug_type values(null,?);";
        return executeUpdate(sql,bugType.getBugType());
    }

    @Override
    public int updateBugType(BugType newBugType, BugType oldBugType) throws SQLException {
        String sql = "update bug_type set type = ? where type = ?;";
        return executeUpdate(sql,newBugType.getBugType(),oldBugType.getBugType());
    }

    @Override
    public int delete(BugType bugType) throws SQLException {
        String sql = "delete from bug_type where type_id = ?";
        return executeUpdate(sql,bugType.getBugTypeId());
    }
}
