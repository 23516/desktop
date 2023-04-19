package tyut.selab.desktop.moudle.sharecenter.domain.vo;

import tyut.selab.desktop.moudle.student.domain.vo.UserVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BugVo {
    private String bugTitle; //bug标题
    private String bugSolve; //bug解决办法
    private Date releaseTime; //发布时间
    private UserVo userVo; //用户
    private List<String> bugType; //bug类型

    public BugVo(String bugTitle, String bugSolve, Date releaseTime, UserVo userVo, List<String> bugType) {
        this.bugTitle = bugTitle;
        this.bugSolve = bugSolve;
        this.releaseTime = releaseTime;
        this.userVo = userVo;
        this.bugType = bugType;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

    public String getBugSolve() {
        return bugSolve;
    }

    public void setBugSolve(String bugSolve) {
        this.bugSolve = bugSolve;
    }

    public String getReleaseTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String releaseStringTime = sdf.format(releaseTime);
        return releaseStringTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public List<String> getBugType() {
        return bugType;
    }

    public void setBugType(List<String> bugType) {
        this.bugType = bugType;
    }

    @Override
    public String toString() {
        return bugTitle;
    }
}
