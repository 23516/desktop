package tyut.selab.desktop.moudle.student.domain.vo;

public class UserVo {
    private Integer studentNumber;  //用户学号
    private String name; //用户姓名
    private String accountNumber; //用户账户
    private int gender; //用户性别
    private String phone; //用户电话
    private String post; //用户邮箱
    private String duty; //用户职责

    public UserVo(String name) {
        this.name = name;
    }

    public UserVo(String name,String duty) {
        this.name = name;
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public String getName() {
        return name;
    }
}
