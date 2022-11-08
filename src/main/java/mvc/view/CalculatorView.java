package mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    // Declararea campurilor folosite
    private JTextField firstTextField;
    private JTextField secondTextField;
    private JTextField rezultatTextField;
    private JTextField restTextField;

    private JLabel titlteLabel;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel rezultatLabel;
    private JLabel restLabel;

    private JButton adunareButton;
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton impartireButton;
    private JButton derivareButton;
    private JButton integrareButton;

    // Constructorul clasei CalculatorView
    public CalculatorView() {

        // Marginile ferestrei interfetei
        this.setBounds(100, 100, 608, 648);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Etichetele din interfata
        titlteLabel = new JLabel("Calculator de polinoame");
        titlteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titlteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlteLabel.setBounds(105, 10, 405, 49);
        this.getContentPane().add(titlteLabel);

        firstLabel = new JLabel("Primul polinom");
        firstLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        firstLabel.setBounds(34, 98, 161, 51);
        this.getContentPane().add(firstLabel);

        secondLabel = new JLabel("Al doilea polinom");
        secondLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        secondLabel.setBounds(34, 189, 172, 51);
        this.getContentPane().add(secondLabel);

        rezultatLabel = new JLabel("Rezultat");
        rezultatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rezultatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rezultatLabel.setBounds(34, 282, 172, 49);
        this.getContentPane().add(rezultatLabel);

        restLabel = new JLabel("Rest");
        restLabel.setHorizontalAlignment(SwingConstants.CENTER);
        restLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        restLabel.setBounds(34, 362, 172, 51);
        this.getContentPane().add(restLabel);

        // Casetele text in care se vor introduce cele doua polinoame, respectiv unde se va afisa rezultatul
        firstTextField = new JTextField();
        firstTextField.setBounds(230, 101, 266, 49);
        this.getContentPane().add(firstTextField);
        firstTextField.setColumns(10);

        secondTextField = new JTextField();
        secondTextField.setColumns(10);
        secondTextField.setBounds(230, 189, 266, 49);
        this.getContentPane().add(secondTextField);

        rezultatTextField = new JTextField();
        rezultatTextField.setColumns(10);
        rezultatTextField.setBounds(230, 282, 266, 49);
        this.getContentPane().add(rezultatTextField);

        restTextField = new JTextField();
        restTextField.setColumns(10);
        restTextField.setBounds(230, 362, 266, 49);
        this.getContentPane().add(restTextField);

        // Butoanele corespunzatoare operatiilor de pe interfata
        adunareButton = new JButton("Adunare");
        adunareButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        adunareButton.setBounds(48, 472, 172, 49);
        this.getContentPane().add(adunareButton);

        scadereButton = new JButton("Scadere");
        scadereButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        scadereButton.setBounds(48, 538, 172, 49);
        this.getContentPane().add(scadereButton);

        inmultireButton = new JButton("Inmultire");
        inmultireButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        inmultireButton.setBounds(230, 472, 172, 49);
        this.getContentPane().add(inmultireButton);

        impartireButton = new JButton("Impartire");
        impartireButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        impartireButton.setBounds(230, 538, 172, 49);
        this.getContentPane().add(impartireButton);

        derivareButton = new JButton("Derivare");
        derivareButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        derivareButton.setBounds(412, 472, 172, 49);
        this.getContentPane().add(derivareButton);

        integrareButton = new JButton("Integrare");
        integrareButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        integrareButton.setBounds(412, 538, 172, 49);
        this.getContentPane().add(integrareButton);

        // Afisare fereastra actuala
        this.setVisible(true);
    }

    // Getters si setters
    public String getFirstTextField() {
        return firstTextField.getText();
    }

    public String getSecondTextField() {
        return secondTextField.getText();
    }

    public JTextField getRezultatTextField() {
        return rezultatTextField;
    }

    public JTextField getRestTextField() {

        return this.restTextField;
    }

    public void addAdunareListener(ActionListener actionListener) {

        this.adunareButton.addActionListener(actionListener);
    }

    public void addScadereListener(ActionListener actionListener) {

        this.scadereButton.addActionListener(actionListener);
    }

    public void addInmultireListener(ActionListener actionListener) {

        this.inmultireButton.addActionListener(actionListener);
    }

    public void addImpartireListener(ActionListener actionListener) {

        this.impartireButton.addActionListener(actionListener);
    }

    public void addDerivareListener(ActionListener actionListener) {

        this.derivareButton.addActionListener(actionListener);
    }

    public void addIntegrareListener(ActionListener actionListener) {

        this.integrareButton.addActionListener(actionListener);
    }

    // Metoda pentru input necorespunzator
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
