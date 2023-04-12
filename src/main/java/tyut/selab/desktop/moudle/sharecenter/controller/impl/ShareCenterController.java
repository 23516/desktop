package tyut.selab.desktop.moudle.sharecenter.controller.impl;

import tyut.selab.desktop.moudle.sharecenter.controller.IShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.IShareCenterService;
import tyut.selab.desktop.moudle.sharecenter.service.impl.ShareCenterService;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.util.List;

public class ShareCenterController implements IShareCenterController {

    private IShareCenterService shareCenterService = new ShareCenterService();

    @Override
    public List<BugType> queryAllType() {
        return shareCenterService.queryAllType();
    }

    @Override
    public List<BugVo> showBugInfo() {
        return shareCenterService.showBugInfo();
    }

    @Override
    public List<BugVo> ShowBugInfo(List<String> bugType) {
        return shareCenterService.ShowBugInfo(bugType);
    }

    @Override
    public List<BugVo> ShowBugInfo(UserVo userVo) {
        return shareCenterService.ShowBugInfo(userVo);
    }

    @Override
    public int insertBugInfo(BugVo bugVo) {
        return shareCenterService.insertBugInfo(bugVo);
    }

    @Override
    public int updateBugInfo(BugVo newBugVo, BugVo oldBugVo) {
        return shareCenterService.updateBugInfo(newBugVo,oldBugVo);
    }

    @Override
    public int deleteBugInfo(BugVo bugVo) {
        return shareCenterService.deleteBugInfo(bugVo);
    }

    @Override
    public int insertBugType(BugType bugType) {
        return shareCenterService.insertBugType(bugType);
    }

    @Override
    public int updateBugType(BugType newBugType, BugType oldBugType) {
        return shareCenterService.updateBugType(newBugType, oldBugType);
    }

    @Override
    public int delete(BugType bugType) {
        return shareCenterService.delete(bugType);
    }
}
