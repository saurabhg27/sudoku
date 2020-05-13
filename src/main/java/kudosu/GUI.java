package kudosu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

    private static final long serialVersionUID = 0;
	private static GUI instance = new GUI();
    private JTextField f[][]= new JTextField[9][9] ;
    private JPanel p[][]= new JPanel [3][3];

    Font font1 = new Font("SansSerif", Font.BOLD, 30);
   
    
    public static GUI getInstance() {
    	return instance ;
    }
    
    public static void showw() {
    	instance.setPreferredSize(new Dimension(400, 400));
    	instance.pack();
    	instance.setVisible(true);
	
    }
    
    public static void showNumberBoard(int[][] board) {
    	for(int i = 0;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			//System.out.println("f[i][j] "+instance.f[i][j].getText());
    			instance.f[i][j].setText(String.valueOf(board[i][j]));
    		}
    	}
    	
    }
    
    public static void updateNumber(int row,int col,int num) {
    	JTextField txtF = instance.f[col][row];
    	txtF.setText(String.valueOf(num));
    	txtF.setForeground(Color.BLUE);
    	//Util.silentSleep(1);
    	txtF.setForeground(Color.BLACK);
    }
    
    private GUI(){
        super("KuDoSu Board");
        
        for(int x=0; x<=8; x++){
            for(int y=0; y<=8; y++){
                f[x][y]=new JTextField(1);
                f[x][y].setFont(font1);
                f[x][y].setHorizontalAlignment(JTextField.CENTER);
                f[x][y].setText("0");
            }
        }

        for(int x=0; x<=2; x++){
            for(int y=0; y<=2; y++){
                p[x][y]=new JPanel(new GridLayout(3,3));
            }
        }

        setLayout(new GridLayout(3,3,5,5));

        for(int u=0; u<=2; u++){
            for(int i=0; i<=2; i++){    
                for(int x=0; x<=2; x++ ){
                    for(int y=0; y<=2; y++){
                        p[u][i].add(f[y+u*3][x+i*3]);
                    }
                }
            add(p[u][i]);
            }
        }
    }
    
}
