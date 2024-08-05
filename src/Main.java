import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    static JFrame frame ;
    char opperator;
    double num1,num2,result;
    static JButton[] button = new JButton[10];
    static JButton[] number=new JButton[10];
    static JTextField field ;
    Main(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());



        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        field = new JTextField(16);
        frame.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.ORANGE);

        field.setPreferredSize(new Dimension(300,60));

        field.setFont(new Font("SansSerif", Font.BOLD, 20));


        field.setEditable(false);
        topPanel.add(field);
        topPanel.setPreferredSize(new Dimension(300,60));




        topPanel.setBackground(Color.GRAY);
        frame.add(topPanel, BorderLayout.NORTH);






        centerPanel.setLayout(new GridLayout(5,4,4,4));




        button[0] = new JButton("+");
        button[1] = new JButton("-");
        button[2] = new JButton("*");
        button[3] = new JButton("/");
        button[4] = new JButton("=");
        button[5] = new JButton("C");
        button[6] = new JButton(".");
        button[7] = new JButton("p");
        button[8] = new JButton("%");
        button[9] = new JButton("CE");

        for (int i = 0; i < 10; i++) {
            number[i] = new JButton(String.valueOf(i));
            number[i].setFont(new Font("SansSerif", Font.BOLD, 20));
            number[i].setFocusable(false);
            button[i].setFocusable(false);
            button[i].setFont(new Font("SansSerif", Font.BOLD, 20));

            number[i].addActionListener(this);
            button[i].addActionListener(this);
        }



        centerPanel.add(button[5]);
        centerPanel.add(button[9]);
        centerPanel.add(button[2]);
        centerPanel.add(button[3]);

        centerPanel.add(number[7]);
        centerPanel.add(number[8]);
        centerPanel.add(number[9]);

        centerPanel.add(button[1]);

        centerPanel.add(number[4]);
        centerPanel.add(number[5]);
        centerPanel.add(number[6]);
        centerPanel.add(button[0]);

        centerPanel.add(number[1]);
        centerPanel.add(number[2]);
        centerPanel.add(number[3]);
        centerPanel.add(button[7]);



        centerPanel.add(button[6]);
        centerPanel.add(number[0]);
        centerPanel.add(button[8]);
        centerPanel.add(button[4]);



        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }





    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0;i<10;i++) {
            if(e.getSource()==number[i]) {
                field.setText(field.getText()+number[i].getText());
            }

        }

        if (e.getSource()==button[0]){
//            + button
            num1=Double.parseDouble(field.getText());
            opperator='+';
            field.setText("");


        }
        if (e.getSource()==button[1]){
            //- button
            num1=Double.parseDouble(field.getText());
            opperator='-';
            field.setText("");
        }
        if (e.getSource()==button[2]){
            //* button
            num1=Double.parseDouble(field.getText());
            opperator='*';
            field.setText("");
        }
        if (e.getSource()==button[3]){
            // / button
            num1=Double.parseDouble(field.getText());
            opperator='/';
            field.setText("");
        }
        if (e.getSource()==button[5]){
            // C button
            field.setText("");
        }
        if (e.getSource()==button[6]){
            //. button
            field.setText(field.getText()+".");
        }
        if (e.getSource()==button[7]){
//
            System.exit(0);
        }
        if (e.getSource()==button[8]){
            // % button
            num1=Double.parseDouble(field.getText());
            opperator='%';
            field.setText("");
        }
        if (e.getSource()==button[9]){
            // CE button
            field.setText("");
        }


        if (e.getSource()==button[4]){
            num2=Double.parseDouble(field.getText());
            switch (opperator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    if(num2==0){
                        JOptionPane.showMessageDialog(frame, "Cannot divide by zero!");
                        return;
                    }
                    result=num1/num2;
                    break;
                case '%':

                    result=num1*(num2/100);
                    break;



            }
            field.setText(Double.toString(result));
        }


    }
}