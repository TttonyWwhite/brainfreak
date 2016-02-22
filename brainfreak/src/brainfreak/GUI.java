package brainfreak;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class GUI extends JFrame {
    
	private static final long serialVersionUID = 1783527103493287966L;
	
	private JTextArea codeArea;
    private JTextArea inputArea;
    private JTextArea resultArea;
    private JButton runButton;
    private JButton cheatSheetButton;
    
    public GUI() {
    	createAndShowGui();
    }
    
    private void createAndShowGui() {
		//TODO: Add unit testing
    	//TODO: maybe make a string pool for localization, probably not necessary
    	//TODO: future testing here ->  http://www.hevanet.com/cristofd/brainfuck/tests.b
    	//TODO: add ability to resize frame, enums for various preset lengths
    	
		JFrame frame = new JFrame();
		
		JPanel rightPanel = new JPanel();
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel comboPanel = new JPanel();
	    
		JLabel codeLabel = new JLabel("Please enter your code below:");
		JLabel inputLabel = new JLabel("Enter standard input (if any):");
		JLabel resultLabel = new JLabel("Result:");
		JLabel sampleProgramsLabel = new JLabel("Sample programs:");
		
		runButton = new JButton("Run");
		//**JButton haltButton = new JButton("Halt");
		
		codeArea = new JTextArea(20,50);
		inputArea = new JTextArea(2,50);
		resultArea = new JTextArea(4,50);
		
		resultArea.setEditable(false);
		codeArea.setAutoscrolls(true);

		JScrollPane codeAreaScrollPane = new JScrollPane(codeArea);
		JScrollPane inputAreaScrollPane = new JScrollPane(inputArea);
		JScrollPane resultAreaScrollPane = new JScrollPane(resultArea);
    	
    	centerPanel.add(codeLabel);
    	centerPanel.add(codeAreaScrollPane);
        centerPanel.add(inputLabel);
        centerPanel.add(inputAreaScrollPane);
        centerPanel.add(resultLabel);
        centerPanel.add(resultAreaScrollPane);
        
        ExampleList el = new ExampleList(this);
        JComboBox<String> sampleProgramsComboBox = el.createComboBox();
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.add(runButton);
        //**rightButtonPanel.add(haltButton);
        
        cheatSheetButton = new JButton("ASCII Table");
        
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setPreferredSize(new Dimension(300,800));
        rightPanel.setBorder(BorderFactory.createEtchedBorder());
        rightPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), new EtchedBorder()));
        rightPanel.add(rightButtonPanel);
        
        comboPanel.setPreferredSize(new Dimension(100,100));
        comboPanel.setBorder(BorderFactory.createEtchedBorder());
        comboPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), new EtchedBorder()));
        
        comboPanel.add(sampleProgramsLabel);
        comboPanel.add(sampleProgramsComboBox);
        comboPanel.add(cheatSheetButton);
        rightPanel.add(comboPanel);
        
        frame.getContentPane().add(BorderLayout.EAST, rightPanel);
        frame.getContentPane().add(BorderLayout.WEST, Box.createRigidArea(new Dimension(50,0)));
        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
        //frame.setSize(1280, 720);
        frame.setSize(960, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Brainfreak Interpreter");
    }

    public String getInputAreaText() {
		return inputArea.getText();
	}
    
    public void setCodeText(String text) {
    	codeArea.setText(text);
    }
    
    public String getCodeText() {
    	return codeArea.getText();
    }
    
    public void setResultAreaText(String text) {
    	resultArea.setText(text);
    }
    
    public void addRunButtonListener(ActionListener actionListener) {
    	runButton.addActionListener(actionListener);
    }
    
    public void addReturnKeyListener(KeyListener keyListener) {
    	codeArea.addKeyListener(keyListener);
    }
    
    public void addCheatSheetButtonActionListener(ActionListener actionListener) {
    	cheatSheetButton.addActionListener(actionListener);
    }
    
}