import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private final HomeMenu HomeMenu;
    private final Login Login;
    private JFrame frame;
    private JFrame loginFrame;

    public GUI(){
        HomeMenu = new HomeMenu();
        Login = new Login();
        GUIstart();
    }

    private void GUIstart(){

        frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Welcome to the startmenu. You now have the 2 following options below:");

        JButton b1 = new JButton("Create new Profile");
        b1.addActionListener(this);
        b1.setActionCommand("createProfile");

        JButton b2 = new JButton("Login");
        b2.addActionListener(this);
        b2.setActionCommand("Login");

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));

        panel.add(label);
        panel.add(b1);
        panel.add(b2);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to the StartMenu");
        frame.pack();
        frame.setVisible(true);
    }


    private void GUIloginfailed(){

        loginFrame = new JFrame();
        JPanel loginPanel = new JPanel();
        JButton loginButton = new JButton("Click ME to go back to startmenu");
        JLabel loginLabel = new JLabel("This is not working(yet), click the button to return to startmenu");

        loginPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        loginPanel.setLayout(new GridLayout(0,1));

        loginButton.addActionListener(this);
        loginButton.setActionCommand("loginFailed");

        loginPanel.add(loginLabel);
        loginPanel.add(loginButton);

        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("Welcome to the StartMenu");
        loginFrame.pack();
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if("createProfile".equals(action)){
            HomeMenu.displayMenu();
            //Login.createUser();
        }else if("Login".equals(action)){
            //Login.login();
            //System.out.println("Loging function is under construction");
            frame.dispose();
            GUIloginfailed();
        }else if("loginFailed".equals(action)){
            loginFrame.dispose();
            GUIstart();
        }//ends if-statement
    }

}
