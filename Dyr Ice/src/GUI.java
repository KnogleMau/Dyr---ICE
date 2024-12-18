import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JFrame noUserFrame;
    private JFrame searchCatsFrame;
    private JFrame searchDogsFrame;
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField input1 = new JTextField();
    private JTextField input2 = new JTextField();
    private JTextField inputDogs = new JTextField();
    private JTextField inputDogs2 = new JTextField();
    private JTextField criteriaChoiceGui = new JTextField();
    public JTextField criteriaNumberChoice1 = new JTextField();
    public JTextField criteriaNumberChoice2 = new JTextField();
    public JTextField criteriaNumberChoice3 = new JTextField();
    int inp1;
    int inp2;
    int inp3 =0;
    int inp4 =0;
    int inp5=0;

  //  int criteriaNumberChoice1;

  //  int criteriaNumberChoice2;

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
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Add welcome label
        JLabel loginLabel = new JLabel("If you want to enter the site, you have to login now!");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginLabel, gbc);

        // Add username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(usernameField, gbc);

        // Add password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(passwordField, gbc);


        // Add login button
        JButton loginButton = new JButton("Login!");
        loginButton.addActionListener(this);
        loginButton.setActionCommand("successfulLogin");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        // Add go-back button
        JButton goBackButton = new JButton("Go back to Fanimals startmenu");
        goBackButton.addActionListener(this);
        goBackButton.setActionCommand("cancelLogin");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(goBackButton, gbc);

        // Configure the frame
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("Login to Fanimals");
        loginFrame.setVisible(true);
    }

    private void GUInoUser(){
        noUserFrame = new JFrame();
        JPanel noUserPanel = new JPanel();
        noUserPanel.setLayout(new GridBagLayout());
        noUserPanel.setBorder(BorderFactory.createEmptyBorder(30,30,40,30 ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10 ,10 ,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel noUserLabel = new JLabel("This user is not existing! Please close this window, and try again");
        noUserPanel.add(noUserLabel, gbc);

        noUserFrame.setSize(400,300);
        noUserFrame.setTitle("ERROR!");
        noUserFrame.add(noUserPanel);
        noUserFrame.setVisible(true);

    }

    private void GUIcreateProfile() {
        createProfileFrame = new JFrame();
        JPanel createProfilePanel = new JPanel();
        createProfilePanel.setLayout(new GridBagLayout());
        createProfilePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add welcome label
        JLabel createProfileLabel = new JLabel("Please make your new user-profile!");
        createProfileLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        createProfilePanel.add(createProfileLabel, gbc);

        // Add username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        createProfilePanel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        createProfilePanel.add(usernameField, gbc);

        // Add password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        createProfilePanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        createProfilePanel.add(passwordField, gbc);


        // Add login button
        JButton createProfileButton = new JButton("Make my new profile and take me back to login!");
        createProfileButton.addActionListener(this);
        createProfileButton.setActionCommand("successfulCreate");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        createProfilePanel.add(createProfileButton, gbc);

        // Add go-back button
        JButton goBackButton = new JButton("Go back to Fanimals startmenu");
        goBackButton.addActionListener(this);
        goBackButton.setActionCommand("cancelCreate");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        createProfilePanel.add(goBackButton, gbc);

        // Configure the frame
        createProfileFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        JButton searchCats = new JButton("Search for Cats");
        searchCats.addActionListener(this);
        searchCats.setActionCommand("goToSearchCats");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(searchCats, gbc);

        JLabel searchCatsDescription = new JLabel("<---- This menu, gives you the option to search in Cats");
        searchCatsDescription.setFont(new Font("Ariel", Font.ITALIC, 16));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        homeMenu1Panel.add(searchCatsDescription, gbc);

        JButton searchDogs = new JButton("Search for Dogs");
        searchDogs.addActionListener(this);
        searchDogs.setActionCommand("goToSearchDogs");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(searchDogs, gbc);

        JLabel searchDogsDescription = new JLabel("<---- This menu, gives you the option to search in Dogs");
        searchDogsDescription.setFont(new Font("Ariel", Font.ITALIC, 16));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        homeMenu1Panel.add(searchDogsDescription, gbc);

        JButton makeNames = new JButton("Generate A Dog Name");
        makeNames.addActionListener(this);
        makeNames.setActionCommand("goToMakeNames");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        homeMenu1Panel.add(makeNames, gbc);

        JLabel makeNamesInfo = new JLabel("<---- Try out our new name-generator for animals");
        makeNamesInfo.setFont(new Font("Ariel", Font.ITALIC, 16));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        homeMenu1Panel.add(makeNamesInfo, gbc);

        JButton logOut = new JButton("Log out and go back to the startmenu");
        logOut.addActionListener(this);
        logOut.setActionCommand("homeMenuLogout");
        gbc.gridx = 0;
        gbc.gridy = 5;
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

    private void GUIsearchCats(){
        searchCatsFrame = new JFrame();
        JPanel searchCatsPanel = new JPanel();
        searchCatsPanel.setLayout(new GridBagLayout());
        searchCatsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        searchCatsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        searchCatsFrame.add(searchCatsPanel, BorderLayout.CENTER);
        searchCatsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchCatsFrame.setVisible(true);
        searchCatsFrame.setTitle("Animals search menu");
    }

    private void GUIsearchDogs(){
        searchDogsFrame = new JFrame();
        JPanel searchDogsPanel = new JPanel();
        searchDogsPanel.setLayout(new GridBagLayout());
        searchDogsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        JTextField inputDogs = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        searchDogsPanel.add(inputDogs, gbc);
        searchDogsPanel.add(inputDogs, gbc);

        JLabel labelDogs = new JLabel("species |  lifespan | temper | allergyfriendly");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        searchDogsPanel.add(labelDogs, gbc);
        searchDogsPanel.add(labelDogs, gbc);


        JLabel labelDogs2 = new JLabel("Type in they keyword you want to search with: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        searchDogsPanel.add(labelDogs2, gbc);
        searchDogsPanel.add(labelDogs2, gbc);

        JLabel labelDogs3 = new JLabel("Ex: Poodle | 10 | Loyal | Yes");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        searchDogsPanel.add(labelDogs3, gbc);
        searchDogsPanel.add(labelDogs3, gbc);

        JTextField inputDogs2 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        searchDogsPanel.add(inputDogs2, gbc);
        searchDogsPanel.add(inputDogs2, gbc);

        JButton searchDogSubmit = new JButton("Search!");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        searchDogSubmit.addActionListener(this);
        searchDogSubmit.setActionCommand("sdSubmit");
        searchDogsPanel.add(searchDogSubmit, gbc);

        JButton searchDogSubmit2 = new JButton("Search!");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        searchDogSubmit2.addActionListener(this);
        searchDogSubmit2.setActionCommand("sdSubmit2");
        searchDogsPanel.add(searchDogSubmit2, gbc);

        searchDogsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        searchDogsFrame.add(searchDogsPanel, BorderLayout.CENTER);
        searchDogsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchDogsFrame.setVisible(true);
        searchDogsFrame.setTitle("Search Menu For Dogs");
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

        JLabel input1Label = new JLabel("Type in the sex of the animal(1/2): ");
        input1Label.setFont(new Font("Arial",Font.ITALIC, 16));
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

        JLabel input11Label = new JLabel("1 = Female | 2 = Male");
        input11Label.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input11Label, gbc);

        JLabel input2Label = new JLabel("Type in size of animal(1/2): ");
        input2Label.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input2Label, gbc);


        JLabel input22Label = new JLabel("1 = Large | 2 = Small");
        input22Label.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input22Label, gbc);

        JTextField input2 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(input2, gbc);

        JLabel input3Label = new JLabel("Chose your prefered combination(1/2/3): ");
        input3Label.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input3Label, gbc);

        JLabel input32Label = new JLabel("1 = Appearance + Genre | 2 = Genre + Personality | 3 = Appearance + personality");
        input32Label.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(input32Label, gbc);

        JTextField input3 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(input3, gbc);

        JLabel genreLabel = new JLabel("Chose your prefered Genre(1/2/3/4/5/6/7): ");
        genreLabel.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(genreLabel, gbc);

        JLabel genreLabel2 = new JLabel("1 = Royal | 2 = Predator | 3 = Fantasy | 4 Sport | 5 = Farm | 6 = Agillity | 7 = Family");
        genreLabel2.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(genreLabel2, gbc);

        JTextField genreTextfield = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(genreTextfield, gbc);

        JLabel PersonalityLabel = new JLabel("Chose your prefered Genre(1/2/3/4: ");
        PersonalityLabel.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(PersonalityLabel, gbc);

        JLabel PersonalityLabel2 = new JLabel("1 = Extrovert | 2 = Calm | 3 = Sneaky | 4 = Clumpsy");
        PersonalityLabel2.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(PersonalityLabel2, gbc);

        JTextField PersonalityTextfield = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(PersonalityTextfield, gbc);

        JLabel AppearanceLabel = new JLabel("Chose your prefered Appearance (1/2/3/4/5/6): ");
        AppearanceLabel.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(AppearanceLabel, gbc);

        JLabel AppearanceLabel2 = new JLabel("1 = Cool | 2 = Muscular | 3 = Confused | 4 = Black | 5 = White | 6 = Furry");
        AppearanceLabel2.setFont(new Font("Arial",Font.ITALIC, 16));
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        nameGeneratorPanel.add(AppearanceLabel2, gbc);

        JTextField AppearanceTextfield = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        nameGeneratorPanel.add(AppearanceTextfield, gbc);

        JButton inputFinal = new JButton("Generate my name!");
        inputFinal.addActionListener(this);
        inputFinal.setActionCommand("finalSubmit");
        gbc.gridx = 1;
        gbc.gridy = 7;
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
        HomeMenu h = new HomeMenu();

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
            if(login.loginOption(text, new String(password))) {
                loginFrame.dispose();
                GUIHomeMenu1();
            }
            else {
                GUInoUser();
            }


        }else if ("homeMenuLogout".equals(action)) {
            HomeMenu1.dispose();
            GUIstartMenu();
        }else if("goToJobs".equals(action)){
            HomeMenu1.dispose();
            GUIJobs();
        }else if("goToSearchCats".equals(action)){

            HomeMenu1.dispose();
            GUIsearchCats();
        }else if("goToSearchDogs".equals(action)){
            HomeMenu1.dispose();
            GUIsearchDogs();
        }else if("sdSubmit".equals(action)){
            String choice = inputDogs.getText();
            String text = inputDogs2.getText();

            String result = h.displaySearchMenu(choice, text);

// Hvis du ønsker at vise resultatet i en JTextArea eller lignende komponent




        }else if("goToMakeNames".equals(action)){
            HomeMenu1.dispose();
            GUInameGenerator();
        }else if("finaleSubmit".equals(action)){

            int text1 = Integer.parseInt(input1.getText());
            int text2 = Integer.parseInt(input2.getText());
            int criteriaNumberChoice1 = Integer.parseInt(criteriaChoiceGui.getText());
            int criteriaNumberChoice2 = Integer.parseInt(criteriaChoiceGui.getText());
            int criteriaNumberChoice3 = Integer.parseInt(criteriaChoiceGui.getText());

            CreateName createName = new CreateName();
             inp1 = text1;
             inp2 = text2;
             inp3 = criteriaNumberChoice1;
             inp4 = criteriaNumberChoice2;
             inp5 = criteriaNumberChoice3;
           // createName.createDogName(inp1, inp2 );

            //System.out.println(createName.result);


        }//ends if-statement
    }

}
