
//CalculatorUI.java
package serviceuser;


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

import java.math.BigInteger;


import java.util.Locale;
import java.util.ResourceBundle;


public class CalculatorUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;
    private ConversionService conversionService;
    private Calculator calculator;
    private ResourceBundle messages;

   

    

    public CalculatorUI(ConversionService service) {
    	Locale locale = Locale.getDefault(); 
        messages = ResourceBundle.getBundle("messages", locale);        
        setAlwaysOnTop(true);
        setTitle("Dört İşlem Hesap Makinesi");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setSize(800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(5, 2));

        conversionService = service;
        calculator = new CalculatorImp();


        add(new JLabel(messages.getString("number1Label")));
        firstNumberField = new JTextField();
        add(firstNumberField);


        add(new JLabel(messages.getString("number2Label")));
        secondNumberField = new JTextField();
        add(secondNumberField);


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
 
        setVisible(true);
    }
    
 

    public void actionPerformed(ActionEvent e) {
        try {
            String num1 = firstNumberField.getText();
            String num2 = secondNumberField.getText();

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

            } else if (e.getSource() == subtractButton) {
                result = calculator.subtract(n1, n2);
            } else if (e.getSource() == multiplyButton) {
                result = calculator.multiply(n1, n2);
            } else if (e.getSource() == divideButton) {
            	result = calculator.divide(n1, n2);        	
            }

            resultField.setText(conversionService.numberToText(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, messages.getString("errorMessage"));
        } 

    }
}
