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
    public static void main(String[] args) {
//        // 插入Java技术栈
//        BugTypeDao bugTypeDao = new BugTypeDao();
//        try {
////            bugTypeDao.insertBugType(new BugType("java"));
//            bugTypeDao.queryAllType();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        ShareCenterDao shareCenterDao = new ShareCenterDao();
        User user = new User();
        user.setStudentNumber(123);
        BugMessage bugMessage = new BugMessage(22,"bug1","solve",new Date(),user,"java");
        try {
            System.out.println(shareCenterDao.insertBugInfo(bugMessage));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
