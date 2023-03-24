package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.math.RoundingMode;
import java.math.BigDecimal;
public class BMI_Project extends Application{
	private TextField t1=new TextField();
	private TextField t2=new TextField();
	private TextField t3=new TextField();
	String s;
	private double num,num1,bmi;

	private String op="";
	private boolean start=true;
	private boolean next=false;
	
	private Button createButtonForNumber(String ch) {
		Button B=new Button(ch);
		B.setFont(Font.font(20));
		B.setPrefSize(50, 50);
		B.setOnAction(this::processNumbers);
		return B;
	}
    private Button createButtonForOperater(String ch) {
    	Button B=new Button(ch);
    	B.setFont(Font.font(20));
		B.setPrefSize(70, 50);
		B.setOnAction(this::processOperater);
		return B;
	}
	
    private Button createButtonForClear(String ch) {
    	Button n=new Button(ch);
    	n.setFont(Font.font(20));
		n.setPrefSize(70, 50);
		n.setOnAction(e->{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			op="";
			start=true;
			next=false;
		});
		return n;
	}  
    private void  processNumbers(ActionEvent e) {
    	String value=((Button)e.getSource()).getText();
    	if(value.equals("->")) 
    		next=true;
    	if(next) {
    	
    		String value1=((Button)e.getSource()).getText();
    		if(value1.equals("->"))
    			s=value1;
    		else
    		t2.setText(t2.getText()+value1);}
    	else {
    		
    	t1.setText(t1.getText()+value);
    	}
    }
    private void  processOperater(ActionEvent e) {
    		num=Double.parseDouble(t1.getText());
    		num1=Double.parseDouble(t2.getText());
        	double bmi=num/(num1*num1);
        	BigDecimal bd =new BigDecimal(bmi).setScale(2,RoundingMode.HALF_UP);
        	double newbmi=bd.doubleValue();
        	t3.setText(String.valueOf(newbmi));
    		start=true;
    		op="";
    }
    
    private Text createText(String g) {
		Text t=new Text(g);
		t.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC,20));
		BorderPane.setAlignment(t, Pos.BOTTOM_LEFT);
		t.setFill(Color.RED);
		t.setStroke(Color.BLACK);
		t.setStrokeWidth(0.5);
		return t;
	} 
	@Override
	public void start(Stage stg) throws Exception {
		// TODO Auto-generated method stub
		// result text field
		t1.setFont(Font.font(16));
		t1.setPrefSize(100, 10);
		t1.setAlignment(Pos.CENTER_LEFT);
		t1.setEditable(false);
		t1.setPromptText("Weight(kg)");
		
		t2.setFont(Font.font(16));
		t2.setPrefSize(100, 10);
		t2.setAlignment(Pos.CENTER);
		t2.setEditable(false);
		t2.setPromptText("Hight(m)");
		
		t3.setFont(Font.font(20));
		t3.setPrefSize(100, 10);
		t3.setAlignment(Pos.CENTER_RIGHT);
		t3.setEditable(false);
		t3.setPromptText("BMI");
		HBox sp=new HBox();
		sp.setPadding(new Insets(10));
		sp.getChildren().addAll(t1,t2,t3);
		sp.setSpacing(10);

		TilePane tp=new  TilePane();
		tp.setHgap(10);
		tp.setVgap(10);
		tp.setAlignment(Pos.TOP_CENTER);
		tp.getChildren().addAll(
				createButtonForNumber("7"),
				createButtonForNumber("8"),
				createButtonForNumber("9"),
				createButtonForClear("AC"),
				
				createButtonForNumber("4"),
				createButtonForNumber("5"),
				createButtonForNumber("6"),
				createButtonForOperater("GO"),
				
				createButtonForNumber("1"),
				createButtonForNumber("2"),
				createButtonForNumber("3"),
				createButtonForNumber("0"),
				createButtonForNumber("->"),
				createButtonForNumber(".")
				);
		Text t1=createText(" #     UnderWeight  16.0 to  18.5\n       Normal  18.5 to 25.0\n       OverWeight 25.0 to 40.0");
		
		BorderPane root=new BorderPane();
		root.setTop(sp);
		root.setCenter(tp);
		root.setBottom(t1);
		
		Scene  s=new  Scene(root,350,400);
		stg.setScene(s);
		stg.setTitle("BMI CALCULATER");
		stg.setResizable(false);
		stg.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
launch(args);
	}
}
