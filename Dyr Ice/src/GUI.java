import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private final HomeMenu HomeMenu;
    private final Login Login;
    private final TextUI TextUI;
    private final DB db;
    private JFrame frame;
    private JFrame loginFrame;
    private JFrame HomeMenu1;
    private JFrame jobsFrame;
    private JFrame searchAnimalsFrame;
    private JFrame nameGeneratorFrame;
    private JFrame createProfileFrame;
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();


    public GUI(){
        HomeMenu = new HomeMenu();
        Login = new Login();
        TextUI = new TextUI();
        db = new DB();
        GUIstartMenu();
    }

    private void GUIstartMenu(){

        frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Welcome to the Fanimals. You now have the 2 following options below:");

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

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("StartMenu");
        //frame.pack();
        frame.setVisible(true);
    }

    public void GUIloginInput() {
        loginFrame = new JFrame();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 30)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch components horizontally

        // Add welcome label
        JLabel loginLabel = new JLabel("If you want to enter the site, you have to login now!");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Optional: Set font
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        loginPanel.add(loginLabel, gbc);

        // Add username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 1; // Reset column span
        gbc.anchor = GridBagConstraints.LINE_START; // Align to the left
        loginPanel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1; // Column 1
        gbc.gridy = 1; // Row 1
        loginPanel.add(usernameField, gbc);

        // Add password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 2; // Row 2
        loginPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1; // Column 1
        gbc.gridy = 2; // Row 2
        loginPanel.add(passwordField, gbc);


        // Add login button
        JButton loginButton = new JButton("Login!");
        loginButton.addActionListener(this);
        loginButton.setActionCommand("successfulLogin");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 3; // Row 3
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        loginPanel.add(loginButton, gbc);

        // Add go-back button
        JButton goBackButton = new JButton("Go back to Fanimals startmenu");
        goBackButton.addActionListener(this);
        goBackButton.setActionCommand("cancelLogin");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 6; // Row 3
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        loginPanel.add(goBackButton, gbc);

        // Configure the frame
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("Login to Fanimals");
        loginFrame.setVisible(true);
    }

    private void GUIcreateProfile() {
        createProfileFrame = new JFrame();
        JPanel createProfilePanel = new JPanel();
        createProfilePanel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        createProfilePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 30)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Stretch components horizontally

        // Add welcome label
        JLabel createProfileLabel = new JLabel("Please make your new user-profile!");
        createProfileLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Optional: Set font
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        createProfilePanel.add(createProfileLabel, gbc);

        // Add username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        gbc.gridwidth = 1; // Reset column span
        gbc.anchor = GridBagConstraints.LINE_START; // Align to the left
        createProfilePanel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1; // Column 1
        gbc.gridy = 1; // Row 1
        createProfilePanel.add(usernameField, gbc);

        // Add password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 2; // Row 2
        createProfilePanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1; // Column 1
        gbc.gridy = 2; // Row 2
        createProfilePanel.add(passwordField, gbc);


        // Add login button
        JButton createProfileButton = new JButton("Make my new profile and take me back to login!");
        createProfileButton.addActionListener(this);
        createProfileButton.setActionCommand("successfulCreate");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 3; // Row 3
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        createProfilePanel.add(createProfileButton, gbc);

        // Add go-back button
        JButton goBackButton = new JButton("Go back to Fanimals startmenu");
        goBackButton.addActionListener(this);
        goBackButton.setActionCommand("cancelCreate");
        gbc.gridx = 0; // Column 0
        gbc.gridy = 6; // Row 3
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align
        createProfilePanel.add(goBackButton, gbc);

        // Configure the frame
        createProfileFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        createProfileFrame.add(createProfilePanel, BorderLayout.CENTER);
        createProfileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createProfileFrame.setTitle("Create user-profile");
        createProfileFrame.setVisible(true);
    }

    private void GUIHomeMenu1(){
        HomeMenu1 = new JFrame();
        JPanel homeMenu1Panel = new JPanel();
        homeMenu1Panel.setLayout(new GridBagLayout());
        homeMenu1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel homeMenuLabel = new JLabel("Welcome to the homemenu!");
        homeMenuLabel.setFont(new Font("Arial",Font.BOLD, 26));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        homeMenu1Panel.add(homeMenuLabel, gbc);

        JButton Jobs = new JButton("Jobs");
        Jobs.addActionListener(this);
        Jobs.setActionCommand("goToJobs");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(Jobs, gbc);

        JLabel jobdescription = new JLabel("<---- Create or take a job");
        jobdescription.setFont(new Font("Ariel", Font.ITALIC, 16));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        homeMenu1Panel.add(jobdescription, gbc);

        JButton searchAnimals = new JButton("Search for Animals");
        searchAnimals.addActionListener(this);
        searchAnimals.setActionCommand("goToSearchAnimals");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(searchAnimals, gbc);

        JLabel searchDescription = new JLabel("<---- This menu, gives you the option to chose to search in animal database");
        searchDescription.setFont(new Font("Ariel", Font.ITALIC, 16));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        homeMenu1Panel.add(searchDescription, gbc);

        JButton makeNames = new JButton("Generate A Dog Name");
        makeNames.addActionListener(this);
        makeNames.setActionCommand("goToMakeNames");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(makeNames, gbc);

        JLabel makeNamesInfo = new JLabel("<---- Try out our new name-generator for animals");
        makeNamesInfo.setFont(new Font("Ariel", Font.ITALIC, 16));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        homeMenu1Panel.add(makeNamesInfo, gbc);

        JButton logOut = new JButton("Log out and go back to the startmenu");
        logOut.addActionListener(this);
        logOut.setActionCommand("homeMenuLogout");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(logOut, gbc);



        HomeMenu1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        HomeMenu1.add(homeMenu1Panel, BorderLayout.CENTER);
        HomeMenu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomeMenu1.setTitle("HomeMenu");
        HomeMenu1.setVisible(true);
    }

    private void GUIJobs(){
        jobsFrame = new JFrame();
        JPanel jobsPanel = new JPanel();
        jobsPanel.setLayout(new GridBagLayout());
        jobsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jobsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jobsFrame.add(jobsPanel, BorderLayout.CENTER);
        jobsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jobsFrame.setVisible(true);
        jobsFrame.setTitle("Jobs");

    }

    private void GUIsearchAnimals(){
        searchAnimalsFrame = new JFrame();
        JPanel searchAnimalsPanel = new JPanel();
        searchAnimalsPanel.setLayout(new GridBagLayout());
        searchAnimalsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchAnimalsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        searchAnimalsFrame.add(searchAnimalsPanel, BorderLayout.CENTER);
        searchAnimalsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchAnimalsFrame.setVisible(true);
        searchAnimalsFrame.setTitle("Animals search menu");
    }

    private void GUInameGenerator(){
        nameGeneratorFrame = new JFrame();
        JPanel nameGeneratorPanel = new JPanel();
        nameGeneratorPanel.setLayout(new GridBagLayout());
        nameGeneratorPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameGeneratorLabel = new JLabel("Try out our name-generator");
        nameGeneratorLabel.setFont(new Font("Arial",Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(nameGeneratorLabel, gbc);

        JLabel input1Label = new JLabel("Type in the sex of the animal(Male(2)/Female(1)): ");
        input1Label.setFont(new Font("Arial",Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input1Label, gbc);

        JTextField input1 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(input1, gbc);

        JLabel input2Label = new JLabel("Type in size(Large(1)/Small(2): ");
        input2Label.setFont(new Font("Arial",Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input2Label, gbc);

        JButton binput2 = new JButton("Submit!");
        binput2.addActionListener(this);
        binput2.setActionCommand("binput2Submit");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(binput2, gbc);

        JLabel input22Label = new JLabel("Ex: Sweet, Loyal, Bold, Clever.");
        input22Label.setFont(new Font("Arial",Font.ITALIC, 10));
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input22Label, gbc);

        JTextField input2 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(input2, gbc);

        JLabel input3Label = new JLabel("Chose your prefered combination: ");
        input3Label.setFont(new Font("Arial",Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input3Label, gbc);

        JButton binput3 = new JButton("Submit!");
        binput2.addActionListener(this);
        binput2.setActionCommand("binput3Submit");
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(binput3, gbc);

        JLabel input32Label = new JLabel("1: Apperance + Genre - 2: Genre + personality - 3: Apperance + personality");
        input22Label.setFont(new Font("Arial",Font.ITALIC, 10));
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input32Label, gbc);

        JTextField input3 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(input3, gbc);

        JButton inputFinal = new JButton("Generate my name!");
        binput2.addActionListener(this);
        binput2.setActionCommand("finalSubmit");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(inputFinal, gbc);


        nameGeneratorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        nameGeneratorFrame.add(nameGeneratorPanel, BorderLayout.CENTER);
        nameGeneratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nameGeneratorFrame.setVisible(true);
        nameGeneratorFrame.setTitle("Name Generator");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if ("createProfile".equals(action)) {
            frame.dispose();
            GUIcreateProfile();
            //Login.createUser();
        } else if ("Login".equals(action)) {
            //Login.loginOption();
            frame.dispose();
            GUIloginInput();
        } else if ("cancelLogin".equals(action)) {
            loginFrame.dispose();
            GUIstartMenu();
        } else if("cancelCreate".equals(action)){
            createProfileFrame.dispose();
            GUIstartMenu();
        }else if("successfulCreate".equals(action)){
            String text = usernameField.getText();
            char[] password = passwordField.getPassword();

            createProfileFrame.dispose();
            GUIloginInput();

            Login login = new Login();
            login.createUser(text, new String(password));

        }else if ("successfulLogin".equals(action)) {
            String text = usernameField.getText();
            char[] password = passwordField.getPassword();

            Login login = new Login();
            login.loginOption(text, new String(password));

            loginFrame.dispose();
            GUIHomeMenu1();
        }else if ("homeMenuLogout".equals(action)) {
            HomeMenu1.dispose();
            GUIstartMenu();
        }else if("goToJobs".equals(action)){
            HomeMenu1.dispose();
            GUIJobs();
        }else if("goToSearchAnimals".equals(action)){
            HomeMenu1.dispose();
            GUIsearchAnimals();
        }else if("goToMakeNames".equals(action)){
            HomeMenu1.dispose();
            GUInameGenerator();
        }//ends if-statement
    }

}
