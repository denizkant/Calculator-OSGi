<<<<<<< HEAD
//CalculatorUI.java
package serviceuser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
=======
// CalculatorUI.java
package serviceuser;

>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import conversionservice.ConversionService;
import conversionservice.Language;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.math.BigInteger;
=======
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
import java.util.Locale;
import java.util.ResourceBundle;


public class CalculatorUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private ConversionService conversionService;
    private Calculator calculator;
    private JComboBox<String> selectLanguageCombo;
    private ResourceBundle messages;
<<<<<<< HEAD
   
    public CalculatorUI(ConversionService service) {
    	messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("tr").build());
        setAlwaysOnTop(true);
        setTitle("Four Operations Calculator");
=======
    

    public CalculatorUI(ConversionService service) {
    	messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("tr").build());
        setAlwaysOnTop(true);
        setTitle("Dört İşlem Hesap Makinesi");
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        setSize(400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(6, 2));

        conversionService = service;
        calculator = new CalculatorImp();

<<<<<<< HEAD
        // First number input field
=======
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
        add(new JLabel(messages.getString("number1Label")));
        firstNumberField = new JTextField();
        add(firstNumberField);

<<<<<<< HEAD
        // Second number input field
=======
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
        add(new JLabel(messages.getString("number2Label")));
        secondNumberField = new JTextField();
        add(secondNumberField);

<<<<<<< HEAD
        
=======
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
        add(new JLabel(messages.getString("resultLabel")));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        
        addButton = new JButton(messages.getString("addButtonLabel"));
        subtractButton = new JButton(messages.getString("subtractButtonLabel"));
        multiplyButton = new JButton(messages.getString("multiplyButtonLabel"));
        divideButton = new JButton(messages.getString("divideButtonLabel"));

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        
        selectLanguageCombo = new JComboBox<>(new String[]{"Türkçe", "English"});
        selectLanguageCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String language = (String) selectLanguageCombo.getSelectedItem();
                if (language.equals("Türkçe")) {
                    messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("tr").build());
                } else {
                    messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("en").build());
                }
                changeLanguage();
            }
        });
        add(new JLabel(messages.getString("languageLabel")));
        add(selectLanguageCombo);
        
        setVisible(true);
    }
    
    private void changeLanguage() {
        String language = (String) selectLanguageCombo.getSelectedItem();
        
        if (language.equals("Türkçe")) {
            messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("tr").build());
            selectLanguageCombo.removeAllItems();
            selectLanguageCombo.addItem("Türkçe");
            selectLanguageCombo.addItem("English");
            conversionService.setLanguage(Language.Turkish);
        } else {
            messages = ResourceBundle.getBundle("messages", new Locale.Builder().setLanguage("en").build());
            selectLanguageCombo.removeAllItems();
            selectLanguageCombo.addItem("English");
            selectLanguageCombo.addItem("Türkçe");
            conversionService.setLanguage(Language.English);
<<<<<<< HEAD
=======
            setTitle("Four Operations Calculator");
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
        }

        JLabel number1Label = (JLabel) getContentPane().getComponent(0);
        number1Label.setText(messages.getString("number1Label"));
        
        JLabel number2Label = (JLabel) getContentPane().getComponent(2);
        number2Label.setText(messages.getString("number2Label"));
        
        JLabel resultLabel = (JLabel) getContentPane().getComponent(4);
        resultLabel.setText(messages.getString("resultLabel"));
        
        JButton addButtonLabel = (JButton) getContentPane().getComponent(6);
        addButtonLabel.setText(messages.getString("addButtonLabel"));
        
        JButton subtractButtonLabel = (JButton) getContentPane().getComponent(7);
        subtractButtonLabel.setText(messages.getString("subtractButtonLabel"));
        
        JButton multiplyButtonLabel = (JButton) getContentPane().getComponent(8);
        multiplyButtonLabel.setText(messages.getString("multiplyButtonLabel"));
        
        JButton divideButtonLabel = (JButton) getContentPane().getComponent(9);
        divideButtonLabel.setText(messages.getString("divideButtonLabel"));
                
        JLabel languageLabel = (JLabel) getContentPane().getComponent(10);
        languageLabel.setText(messages.getString("languageLabel"));
        
<<<<<<< HEAD
        JOptionPane zeroErrorMessage = (JOptionPane) getContentPane().getComponent(DISPOSE_ON_CLOSE);
        zeroErrorMessage.setToolTipText(messages.getString("zeroErrorMessage"));
=======

>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5

    }

    public void actionPerformed(ActionEvent e) {
        try {
            String num1 = firstNumberField.getText();
            String num2 = secondNumberField.getText();
<<<<<<< HEAD
            BigInteger result = BigInteger.ZERO;
            
            BigInteger n1 = conversionService.textToNumber(num1); 
            BigInteger n2 = conversionService.textToNumber(num2);
            
            if (e.getSource() == divideButton && n2.equals(BigInteger.ZERO)) {
                resultField.setText(messages.getString("zeroErrorMessage"));
                return;
            }
            
            
            if (e.getSource() == addButton) {        	
                result = calculator.add(n1, n2);
                System.out.println(result);
=======
            int result = 0;
            
            int n1 = conversionService.textToNumber(num1); 
            int n2 = conversionService.textToNumber(num2);
            
            if (e.getSource() == divideButton && n2 == 0) {
                resultField.setText(messages.getString("divisionByZeroError"));
                return;
            }
            
            if (e.getSource() == addButton) {            	
                result = calculator.add(n1, n2);
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
            } else if (e.getSource() == subtractButton) {
                result = calculator.subtract(n1, n2);
            } else if (e.getSource() == multiplyButton) {
                result = calculator.multiply(n1, n2);
            } else if (e.getSource() == divideButton) {
<<<<<<< HEAD
                result = calculator.divide(n1, n2);
            }
            System.out.println(result);
            System.out.println(conversionService.numberToText(result));
            resultField.setText(conversionService.numberToText(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,messages.getString("errorMessage"));
        }
=======
                result = calculator.divide(n1, n2);        	
            }

            resultField.setText(conversionService.numberToText(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, messages.getString("errorMessage"));
        } 
>>>>>>> 3a5ac9e4f6619d7532ee7b8419bdaced2c4e27a5
    }
}
