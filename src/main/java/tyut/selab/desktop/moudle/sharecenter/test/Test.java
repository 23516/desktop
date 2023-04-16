package tyut.selab.desktop.moudle.sharecenter.test;

import tyut.selab.desktop.moudle.sharecenter.controller.impl.ShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.dao.impl.ShareCenterDao;
import tyut.selab.desktop.moudle.sharecenter.domain.BugMessage;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.student.domain.User;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        ShareCenterDao shareCenterDao = new ShareCenterDao();
//        ArrayList<String> bugType = new ArrayList<>();
//        bugType.add("java");
//        bugType.add("HTML");
//        try {
//            List<BugMessage> list = shareCenterDao.queryBugInfoByType(bugType);
//            System.out.println(list);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        ShareCenterController controller = new ShareCenterController();
        UserVo userVo = new UserVo();
        userVo.setStudentNumber(1233);
        List<BugVo> list = controller.ShowBugInfo(userVo);
        System.out.println(list);
    }
}
