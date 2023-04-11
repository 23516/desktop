package tyut.selab.desktop.moudle.sharecenter.domain;

import tyut.selab.desktop.moudle.student.domain.User;

import java.util.Date;

public class BugMessage {
    private Integer bugId;
    private String bugTitle;  //bug标题
    private String bugSolve; //bug的解决方法
    private Date releaseTime; //发布时间
    private User user; //用户

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public User getUser() {
        //返回id？
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
