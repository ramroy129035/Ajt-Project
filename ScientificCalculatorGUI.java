import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ================== MAIN GUI CLASS ==================
public class ScientificCalculatorGUI extends JFrame {

    private JTextField input1, input2, result;
    private JButton addBtn, subBtn, mulBtn, divBtn;
    private JButton powBtn, sqrtBtn, logBtn, sinBtn, cosBtn, tanBtn, factBtn;

    public ScientificCalculatorGUI() {
        setTitle("Scientific Calculator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));

        // Input Fields
        input1 = new JTextField();
        input2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        // Basic Operation Buttons
        addBtn = new JButton("Add");
        subBtn = new JButton("Subtract");
        mulBtn = new JButton("Multiply");
        divBtn = new JButton("Divide");

        // Scientific Operation Buttons
        powBtn = new JButton("Power (x^y)");
        sqrtBtn = new JButton("Square Root");
        logBtn = new JButton("Log");
        sinBtn = new JButton("Sin");
        cosBtn = new JButton("Cos");
        tanBtn = new JButton("Tan");
        factBtn = new JButton("Factorial");

        // ==== ADD COMPONENTS TO FRAME ====
        add(new JLabel("Enter Number 1:"));
        add(input1);
        add(new JLabel("Enter Number 2:"));
        add(input2);
        add(new JLabel("Result:"));
        add(result);

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);
        add(powBtn);
        add(sqrtBtn);
        add(logBtn);
        add(sinBtn);
        add(cosBtn);
        add(tanBtn);
        add(factBtn);

        // ==== ACTION LISTENERS ====
        addBtn.addActionListener(e -> performOperation("+"));
        subBtn.addActionListener(e -> performOperation("-"));
        mulBtn.addActionListener(e -> performOperation("*"));
        divBtn.addActionListener(e -> performOperation("/"));

        powBtn.addActionListener(e -> performSciOperation("pow"));
        sqrtBtn.addActionListener(e -> performSciOperation("sqrt"));
        logBtn.addActionListener(e -> performSciOperation("log"));
        sinBtn.addActionListener(e -> performSciOperation("sin"));
        cosBtn.addActionListener(e -> performSciOperation("cos"));
        tanBtn.addActionListener(e -> performSciOperation("tan"));
        factBtn.addActionListener(e -> performSciOperation("fact"));
    }

    // ========== BASIC OPERATIONS ==========
    private void performOperation(String operator) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());

            ScientificOperation calc = new ScientificOperation(num1, num2, 0, 0);
            double res = 0;

            switch (operator) {
                case "+": res = calc.add(); break;
                case "-": res = calc.subtract(); break;
                case "*": res = calc.multiply(); break;
                case "/": res = calc.divide(); break;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            result.setText("Invalid Input!");
        } catch (Exception e) {
            result.setText("Error!");
        }
    }

    // ========== SCIENTIFIC OPERATIONS ==========
    private void performSciOperation(String op) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = input2.getText().isEmpty() ? 0 : Double.parseDouble(input2.getText());
            ScientificOperation calc = new ScientificOperation(num1, num2, 0, 0);

            double res = 0;

            switch (op) {
                case "pow": res = calc.power(); break;
                case "sqrt": res = calc.squareRoot(); break;
                case "log": res = calc.log(); break;
                case "sin": res = calc.sin(); break;
                case "cos": res = calc.cos(); break;
                case "tan": res = calc.tan(); break;
                case "fact":
                    long fact = calc.factorial();
                    result.setText(String.valueOf(fact));
                    return;
            }

            result.setText(String.valueOf(res));

        } catch (NumberFormatException e) {
            result.setText("Invalid Input!");
        } catch (Exception e) {
            result.setText("Error!");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculatorGUI().setVisible(true);
    }
}

// ================== PARENT CALCULATOR CLASS ==================
class Calculator {
    protected double num1, num2, num3, num4;

    public Calculator(double num1, double num2, double num3, double num4) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }
}

// ================== SCIENTIFIC OPERATION CLASS ==================
class ScientificOperation extends Calculator {

    public ScientificOperation(double num1, double num2, double num3, double num4) {
        super(num1, num2, num3, num4);
    }

    // Basic operations
    public double add() { return num1 + num2; }
    public double subtract() { return num1 - num2; }
    public double multiply() { return num1 * num2; }
    public double divide() { return (num2 != 0) ? num1 / num2 : Double.NaN; }

    // Scientific operations
    public double power() { return Math.pow(num1, num2); }
    public double squareRoot() { return Math.sqrt(num1); }
    public double log() { return Math.log(num1); }
    public double sin() { return Math.sin(Math.toRadians(num1)); }
    public double cos() { return Math.cos(Math.toRadians(num1)); }
    public double tan() { return Math.tan(Math.toRadians(num1)); }

    // Factorial
    public long factorial() {
        if (num1 < 0) return -1;
        long fact = 1;
        for (int i = 1; i <= (int)num1; i++) {
            fact *= i;
        }
        return fact;
    }
}

