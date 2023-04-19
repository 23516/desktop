package tyut.selab.desktop.moudle.sharecenter.domain;

public class BugType {
    private Integer bugTypeId;
    private String bugType;

    public BugType(Integer bugTypeId, String bugType) {
        this.bugTypeId = bugTypeId;
        this.bugType = bugType;
    }

    public Integer getBugTypeId() {
        return bugTypeId;
    }

    public void setBugTypeId(Integer bugTypeId) {
        this.bugTypeId = bugTypeId;
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }
}
