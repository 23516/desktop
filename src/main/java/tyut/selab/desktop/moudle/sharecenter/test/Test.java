package tyut.selab.desktop.moudle.sharecenter.test;

import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.BugTypeDao;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.ShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        user.setStudentNumber(123);
        BugMessage bugMessage = new BugMessage(22,"tyu","solve",new Date(),user,"java");

        ShareCenterController controller = new ShareCenterController(bugMessage.getUserVo());
        controller.showBugInfo();
        controller.ShowBugInfo(bugMessage.getUserVo());
        controller.queryAllType();
        controller.insertBugInfo(null);
        controller.getUi().init();


//        BugVo bugVo = new BugVo("bug1","solve",new Date(),bugMessage.getUserVo()
//                ,"java");
//        bugVo.addBugType("html");
//        BugVo newBugVo = new BugVo("bug2","soooo",new Date(),bugMessage.getUserVo()
//                ,"");
//        controller.insertBugInfo(bugVo);
//        controller.deleteBugInfo(bugVo);
//        controller.updateBugInfo(newBugVo,bugVo);

    }
}