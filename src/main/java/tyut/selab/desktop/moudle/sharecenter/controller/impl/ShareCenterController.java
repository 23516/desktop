package tyut.selab.desktop.moudle.sharecenter.controller.impl;

import tyut.selab.desktop.moudle.sharecenter.controller.IShareCenterController;
import tyut.selab.desktop.moudle.sharecenter.domain.BugType;
import tyut.selab.desktop.moudle.sharecenter.domain.vo.BugVo;
import tyut.selab.desktop.moudle.sharecenter.service.IShareCenterService;
import tyut.selab.desktop.moudle.sharecenter.service.impl.ShareCenterService;
import tyut.selab.desktop.moudle.student.domain.vo.UserVo;
import tyut.selab.desktop.ui.sharecenter.boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class ShareCenterController implements IShareCenterController {

    private IShareCenterService shareCenterService;
    private boundary ui = new boundary();

    /**
     * 通过userVo是管理员还是用户来区分界面功能(菜单栏)
     * @param userVo
     */
    public ShareCenterController(UserVo userVo) {
        if("用户".equals(userVo.getDuty())){
            ui.getFrame().setJMenuBar(ui.getjMenuBar());
            ui.getjMenuBar().add(ui.getjMenu());
            ui.getjMenu().add(ui.getjMenuItem1());
            ui.getjMenu().addSeparator();
            ui.getjMenu().add(ui.getjMenuItem2());
            ui.getjMenu().addSeparator();
            ui.getjMenu().add(ui.getjMenuItem3());
            ui.getjMenu().addSeparator();
            ui.getjMenu().add(ui.getjMenuItem4());
        }
        if("管理员".equals(userVo.getDuty())){
            ui.getFrame().setJMenuBar(ui.getjMenuBar());
            ui.getjMenuBar().add(ui.getjMenu());
            ui.getjMenu().add(ui.getjMenu2());
            ui.getjMenu2().add(ui.getjMenuItem6());
            ui.getjMenu2().addSeparator();
            ui.getjMenu2().add(ui.getjMenuItem7());
            ui.getjMenu().addSeparator();
            ui.getjMenu().add(ui.getjMenuItem5());
            ui.getjMenu().addSeparator();
            ui.getjMenu().add(ui.getjMenuItem4());

        }
    }

    public boundary getUi() {
        return ui;
    }

    @Override
    public List<BugType> queryAllType() {
        //service层应给的bugType
        Vector<String> bugType = new Vector<>();
        bugType.add("javascript");
        bugType.add("java");
        bugType.add("python");
        bugType.add("php");
        int[] bugTypeIds = new int[]{1,2,3,4};
        List<BugType> bugTypes = new Vector<>();
        for (int i = 0; i < bugTypeIds.length; i++) {
            BugType bugType1 = new BugType(bugTypeIds[i],bugType.get(i));
            bugTypes.add(bugType1);
        }
       ShowBugInfo(bugType);


        ui.getStackCheck().add(ui.getOptions(),BorderLayout.NORTH);
        ui.getStackCheck().add(ui.getButtons(),BorderLayout.CENTER);
        ui.getStackCheck().setBounds(100,100,100,100);
  
        
//        ui.getOptions().removeAll();
        for(int i = 0;i < bugType.size();i++) {
            JCheckBox jCheckBox = new JCheckBox(bugType.get(i));
            ui.getCheckBoxes()[i] = jCheckBox;
            ui.getOptions().add(jCheckBox);
        }

        ui.getStackCheck().pack();
        ui.getStackCheck().setVisible(false);
        //居中
        ui.getStackCheck().setLocationRelativeTo(null);
        //不可改变大小
        ui.getStackCheck().setResizable(false);


        return null;
    }

    @Override
    public List<BugVo> showBugInfo() {
        /**
         * 传入list集合替代bugVos即可。
         */
        List<String> bugType = new Vector<>();
        bugType.add("java");
        bugType.add("javaweb");
        List<BugVo> bugVos = new Vector<>();
        BugVo bugVo1 = new BugVo(boundary.errorLineFeed("定义用于将 JAR 文件转换为压缩包200 文件的工具 并将打包文件转换为 JAR 文件，包括 pack200 和 unpack200 工具。"), boundary.saveLineFeed("The server responded with an error while attempting to authenticate (404)"), new Date(), new UserVo("WZY"), bugType);
        BugVo bugVo2 = new BugVo(boundary.errorLineFeed("义用于将 JAR 文件转换为压缩包200 文件的工具 并将打包文件转换为 JAR 文件，包括 pack200 和 unpack200 工具。"), boundary.saveLineFeed("The server responded with an error while attempting to authenticate (404)"), new Date(), new UserVo("WZY"), bugType);
        BugVo bugVo3 = new BugVo(boundary.errorLineFeed("用于将 JAR 文件转换为压缩包200 文件的工具 并将打包文件转换为 JAR 文件，包括 pack200 和 unpack200 工具。"), boundary.saveLineFeed("The server responded with an error while attempting to authenticate (404)"), new Date(), new UserVo("WZY"), bugType);
        BugVo bugVo4 = new BugVo(boundary.errorLineFeed("于将 JAR 文件转换为压缩包200 文件的工具 并将打包文件转换为 JAR 文件，包括 pack200 和 unpack200 工具。"), boundary.saveLineFeed("The server responded with an error while attempting to authenticate (404)"), new Date(), new UserVo("WZY"), bugType);
        BugVo bugVo5 = new BugVo(boundary.errorLineFeed("将 JAR 文件转换为压缩包200 文件的工具 并将打包文件转换为 JAR 文件，包括 pack200 和 unpack200 工具。"), boundary.saveLineFeed("The server responded with an error while attempting to authenticate (404)"), new Date(), new UserVo("WZY"), bugType);
        BugVo bugVo6 = new BugVo(boundary.errorLineFeed(" JAR 文件转换为压缩包200 文件的工具 并将打包文件转换为 JAR 文件，包括 pack200 和 unpack200 工具。"), boundary.saveLineFeed("The server responded with an error while attempting to authenticate (404)"), new Date(), new UserVo("WZY"), bugType);
        bugVos.add(bugVo1);
        bugVos.add(bugVo2);
        bugVos.add(bugVo3);
        bugVos.add(bugVo4);
        bugVos.add(bugVo5);
        bugVos.add(bugVo6);
//        new ShareCenterService().showBugInfo()

        ui.getDefaultListModel().addAll(bugVos);
        ui.setDefaultJlist(bugVos);
        ui.setList(bugVos);
        ui.getjMenuItem4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.getDefaultListModel().clear();
                ui.getDefaultListModel().addAll(bugVos);
                ui.setDefaultJlist(bugVos);
                ui.setList(bugVos);

            }
        });
        return null;
    }

    /**
     * 用户和管理员对技术栈的筛选（一样的功能）
     * @param bugType
     * @param jMenuItem
     */
    public void showBugInfo(List<String> bugType,JMenuItem jMenuItem) {
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ui.getStackCheck().setVisible(true);
                ui.getButtons().removeAll();
                ui.getButtons().add(ui.getSureJButton());
                ui.getStackCheck().pack();
                
                /**
                 * bugType存的是用户勾选的技术栈，需传给service层。
                 */
                ui.getSureJButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<String> bugType = new Vector<>();
                        for(int i = 0;i<ui.getCheckBoxes().length;i++){
                            if(ui.getCheckBoxes()[1].isSelected()) {
                                bugType.add(ui.getCheckBoxes()[i].getText());
                                ui.getCheckBoxes()[i].setSelected(false);
                            }
                        }
                        ui.getStackCheck().setVisible(false);
                        /**
                         * 将bugType传给service，获取到对应技术栈的报错信息，然后显示
                         */
                    }
                });
            }
        });
    }

    @Override
    public List<BugVo> ShowBugInfo(List<String> bugType) {
        /**
         * 用户筛选
         */
        showBugInfo(bugType,ui.getjMenuItem1());

        /**
         * 管理员筛选
         */
        showBugInfo(bugType,ui.getjMenuItem7());

        /**
         * 管理员管理技术栈
         */
        ui.getjMenuItem5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.getButtons().removeAll();
                ui.getButtons().add(ui.getInsertJButton());
                ui.getButtons().add(ui.getUpdateJButton());
                ui.getButtons().add(ui.getDeleteJButton());
                ui.getStackCheck().setVisible(true);
                ui.getStackCheck().pack();
                //居中
                ui.getStackCheck().setLocationRelativeTo(null);
                //不可改变大小
                ui.getStackCheck().setResizable(false);

                insertBugType(null);
                delete(null);

            }
        });

        return null;
    }

    @Override
    public List<BugVo> ShowBugInfo(UserVo userVo) {
        /**
         * 用户的<我的>功能
         */
                ui.getjMenuItem3().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String username = userVo.getName();
                        List<BugVo> vos = new ShareCenterService().showBugInfo();
                        ui.setDefaultJlist(vos);
                        ui.setList(vos);

                    }
                });

        /**
         * 管理员<按用户选择>功能
         */
                ui.getjMenuItem6().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String searchInput = JOptionPane.showInputDialog(ui.getFrame(), "请输入你想搜索用户的用户名", "search message", JOptionPane.INFORMATION_MESSAGE);
                        if("123".equals(searchInput)){

                            List<String> bugType = new Vector<>();
                            bugType.add("js");
                            List<BugVo> vos = new Vector<>();

                            vos.add(new BugVo("(404)", " with an error while attempting to authenticate (404)", new Date(), new UserVo("555"), bugType));
                            vos.add(new BugVo("12345334(404)", " with an error while attempting to authenticate (404)", new Date(), new UserVo("WZY"), bugType));
                            vos.add(new BugVo("12345334(404)", " with an error while attempting to authenticate (404)", new Date(), new UserVo("WZY"), bugType));
                            ui.getDefaultListModel().removeAllElements();

                            ui.getDefaultListModel().addAll(vos);
                            ui.setDefaultJlist(vos);
                            ui.setList(vos);

                        }

                    }
                });
        return null;
    }

    @Override
    public int insertBugInfo(BugVo bugVo) {
        ui.getjMenuItem2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加功能
                String addInput1 = JOptionPane.showInputDialog(ui.getFrame(), "请输入你想提交的技术栈", "stack message", JOptionPane.INFORMATION_MESSAGE);
                if(addInput1.length()>0){

                }else{
                    JOptionPane.showMessageDialog(ui.getFrame(), "技术栈不能为空", "消息对话框", JOptionPane.WARNING_MESSAGE);
                   return;
                }
                String addInput2 = JOptionPane.showInputDialog(ui.getFrame(), "请输入你想提交的错误信息", "error message", JOptionPane.INFORMATION_MESSAGE);
                if(addInput2.length()>0){

                }else{
                    JOptionPane.showMessageDialog(ui.getFrame(), "错误信息不能为空", "消息对话框", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String addInput3 = JOptionPane.showInputDialog(ui.getFrame(), "请输入解决方案(可以选择不提交)", "solution", JOptionPane.INFORMATION_MESSAGE);
                if(addInput3.length()>0){

                }else{

                }
            }
        });
        return 0;
    }

    @Override
    public int updateBugInfo(BugVo newBugVo, BugVo oldBugVo) {
        return 0;
    }

    @Override
    public int deleteBugInfo(BugVo bugVo) {
        return 0;
    }

    @Override
    public int insertBugType(BugType bugType) {
        /**
         * 处理增
         */
        ui.getInsertJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insertInput = JOptionPane.showInputDialog(ui.getStackCheck(), "请输入你想添加的技术栈", "insert stack", JOptionPane.INFORMATION_MESSAGE);
                if(insertInput.length() > 0) {
                    JCheckBox insertJCheckBox = new JCheckBox(insertInput);
                    ui.getOptions().add(insertJCheckBox);

                    ui.getStackCheck().pack();
                    //居中
                    ui.getStackCheck().setLocationRelativeTo(null);
                }


                /**
                 * 还需将新添加的技术栈通过service保存
                 */
            }
        });
        return 0;
    }

    @Override
    public int updateBugType(BugType newBugType, BugType oldBugType) {
        return 0;
    }

    @Override
    public int delete(BugType bugType) {
        ui.getDeleteJButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List deleteList = new ArrayList();
                System.out.println(ui.getCheckBoxes().length);
                for(int i = 0;i<ui.getCheckBoxes().length-1;i++){
                    if(ui.getCheckBoxes()[i].isSelected()) {
                        deleteList.add(i);
                    }
                }
                for(int i = 0;i<deleteList.size();i++){
                    ui.getOptions().remove(ui.getCheckBoxes()[(int) deleteList.get(i)]);
                    ui.getStackCheck().pack();
                }
            }
        });
        return 0;
    }
}
