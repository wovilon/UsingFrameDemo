import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class TextInputFrame implements ActionListener{
           private JFrame frame;
           JLabel enter;
           JTextField tf;
           JButton btYes,btNo;
           private String name;
           TextInputFrame(String msg){
           int width=300, height=150;
           frame=new JFrame(" Окно для ввода имени");
           frame.setBounds(400,300,width,height);
           frame.setLayout(null);
           enter=new JLabel(msg,JLabel.LEFT);
           enter.setBounds(10,10,width-20,height/6);
           tf=new JTextField(frame.getWidth()-20);
           tf.setBounds(10,enter.getHeight()+5,enter.getWidth(),height/6);
           btYes=new JButton("Подтверждаю");
           btYes.setBounds(10,height/2+10,(width-30)/2,height/6);
           btYes.setFocusPainted(false);
           btNo=new JButton("Завершить");
           btNo.setBounds((width-30)/2+18,height/2+10,(width-30)/2,height/6);
           
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.add(enter);
           frame.add(tf);
           frame.add(btYes);
           frame.add(btNo);
           frame.setResizable(false);
           btYes.addActionListener(this);
           btNo.addActionListener(this);
           frame.setVisible(true);
       }
         public void actionPerformed(ActionEvent ae)  {
             String btName=ae.getActionCommand();
             if (btName.equalsIgnoreCase(btYes.getText())){
                 name=tf.getText();
                 frame.setVisible(false);
                 IntInputFrame.show("Сколько вам лет? Укажите возраст (лет): ",name);}
             else System.exit(0);
         }
           static void show(String txt) {
               new TextInputFrame(txt);
           }
    }
class IntInputFrame implements ActionListener,KeyListener{
    private JFrame frame;
    private JLabel enter;
    private JButton btYes,btNo;
    private JTextField tf;
    private String name;
    private int age;
    IntInputFrame(String msg, String name){
        this.name=new String(name);
        int width=300,height=150;
        frame=new JFrame(" Окно для ввода числа (возраста)");
        frame.setBounds(400,300,width,height);
        frame.setLayout(null);
        enter=new JLabel(msg,JLabel.LEFT);
        enter.setBounds(10,10,width-20,height/6);
        tf=new JTextField(frame.getWidth()-20);
        tf.setBounds(10,enter.getHeight()+5,enter.getWidth(),height/6);
        tf.addKeyListener(this);
        btYes=new JButton("Подтверждаю");
        btYes.setBounds(10,height/2+10,(width-30)/2,height/6);
        btYes.setEnabled(false);
        btYes.setFocusPainted(false);
        btNo=new JButton("Завершить");
        btNo.setBounds((width-10)/2+18, height/2+10,(width-30)/2,height/6);
        btNo.setFocusPainted(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(enter);
        frame.add(tf);
        frame.add(btYes);
        frame.add(btNo);
        frame.setResizable(false);
        btYes.addActionListener(this);
        btNo.addActionListener(this);
        frame.setVisible(true); 
    }
    public void keyReleased(KeyEvent ke){
        try{
            Integer.parseInt(tf.getText());
            btYes.setEnabled(true);
        }catch (Exception e){JOptionPane.showMessageDialog(null,"Необходимо ввести число!");
            btYes.setEnabled(false);}
    }
    public void KeyPressed(KeyEvent ke){}
    public void keyTyped(KeyEvent ke){}
    public void actionPerformed(ActionEvent ae){
        String btName=ae.getActionCommand();
        if(btName.equalsIgnoreCase(btYes.getText())){
            age=Integer.parseInt(tf.getText());
            frame.setVisible(false);
            String msg="Добрый день, "+name+"!\n";
            msg+="Ваш возраст - "+age+"лет!";
            MessageFrame.show(msg); 
        }
        else System.exit(0);
    }
    static void show(String txt,String name){
        new IntInputFrame(txt,name);
    }   

    @Override
    public void keyPressed(KeyEvent e) {}
}
class MessageFrame implements ActionListener{
    private JFrame frame;
    JLabel i1;
    JLabel message;
    JButton button;
    MessageFrame(String msg){
        int width=350,height=150;
        ImageIcon img=new ImageIcon("F:/My works/Programming&MathCad/Java/Programs/53 UsingFrameDemo/"
                + "UsingFrameDemo/UsingFrameDemo/pict1.gif");
        frame=new JFrame("Сообщение");
        frame.setBounds(400,300,width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Image icon=frame.getToolkit().getImage("F:/My works/Programming&MathCad/Java/Programs/53 UsingFrameDemo/"
                + "UsingFrameDemo/UsingFrameDemo/java_logo.jpg");// пиктограмма в строке названия окна
        i1=new JLabel(img);
        int w=img.getIconWidth();
        int h=img.getIconHeight()-30;
        i1.setBounds(10,10,w,h);
        message=new JLabel("<html>"+msg.replace("\n","<br>")+"</html>",JLabel.LEFT);
        message.setBounds(w+20,10,width-30-w,height/2-10);
        frame.add(i1);
        frame.add(message);
        button=new JButton("Прочитано!");
        button.setBounds(width/4,3*height/5,width/2,height/6);
        button.setFocusPainted(false);
        button.addActionListener(this);
        frame.add(button);
        frame.setResizable(false);
        frame.setIconImage(icon);
        frame.setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae){
        System.exit(0);
    }
    static void show(String txt){
        new MessageFrame(txt);
    }
}



public class UsingFrameDemo {
    public static void main(String[] args) {
    TextInputFrame.show("Как вас зовут? Введите имя:");  
    
}}
