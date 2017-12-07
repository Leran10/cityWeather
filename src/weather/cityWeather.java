package weather;

import javafx.application.Application;
//import javafx.application.ActionEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
//import javafx.geometry.Hpos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class cityWeather extends Application {
	//Scene scene,scene1;
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Weather Checking");

		GridPane pane = new GridPane();

		Button button1 = new Button();
		button1.setText("New Haven");

		Button button2 = new Button();
		button2.setText("Baltimore");

		Button button3 = new Button();
		button3.setText("San Fransisco");

		Button button4 = new Button();
		button4.setText("Washington DC");

		Button button5 = new Button();
		button5.setText("Chicago");

		Button button6 = new Button();
		button6.setText("St.Louis");

		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5.5, 5.5, 5.5, 5.5));
		pane.setHgap(10);
		pane.setVgap(10);

		
		//event action
		Button bt1 = new Button("Go Back");
		Button bt2 = new Button("Cancel");
		
		pane.add(button1, 0, 0);
		
		button1.setOnAction(e -> {
			
			Label label1 = null;
			try {
				label1 = new Label(getTemp("newhaven"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			VBox pane1 = new VBox(20);
			pane1.setAlignment(Pos.CENTER);
			//bt1 = new Button("going back");
			//bt2 = new Button("cancell");
			pane1.getChildren().addAll(label1,bt1,bt2);
			Scene scene1 = new Scene(pane1,400,300);
			primaryStage.setScene(scene1);
		
			});
		

		
		pane.add(button2, 0, 1);
		
		button2.setOnAction(e -> {
		Label label1 = null;
		try {
			label1 = new Label(getTemp("baltimore"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		VBox pane1 = new VBox(20);
		pane1.setAlignment(Pos.CENTER);
		//bt1 = new Button("going back");
		//bt2 = new Button("cancell");
		pane1.getChildren().addAll(label1,bt1,bt2);
		Scene scene1 = new Scene(pane1,400,300);
		primaryStage.setScene(scene1);
		});
		
		pane.add(button3, 0, 2);
		button3.setOnAction(e -> {
			Label label1 = null;
			try {
				label1 = new Label(getTemp("sanfransisco"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			VBox pane1 = new VBox(20);
			pane1.setAlignment(Pos.CENTER);
			//bt1 = new Button("going back");
			//bt2 = new Button("cancell");
			pane1.getChildren().addAll(label1,bt1,bt2);
			Scene scene1 = new Scene(pane1,400,300);
			primaryStage.setScene(scene1);
			});

		pane.add(button4, 1, 0);
		button4.setOnAction(e -> {
			Label label1 = null;
			try {
				label1 = new Label(getTemp("washingtonDC"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			VBox pane1 = new VBox(20);
			pane1.setAlignment(Pos.CENTER);
			//bt1 = new Button("going back");
			//bt2 = new Button("cancell");
			pane1.getChildren().addAll(label1,bt1,bt2);
			Scene scene1 = new Scene(pane1,400,300);
			primaryStage.setScene(scene1);
			});

		pane.add(button5, 1, 1);
		button5.setOnAction(e -> {
			Label label1 = null;
			try {
				label1 = new Label(getTemp("chicago"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			VBox pane1 = new VBox(20);
			pane1.setAlignment(Pos.CENTER);
			//bt1 = new Button("going back");
			//bt2 = new Button("cancell");
			pane1.getChildren().addAll(label1,bt1,bt2);
			Scene scene1 = new Scene(pane1,400,300);
			primaryStage.setScene(scene1);
			});

		pane.add(button6, 1, 2);
		button6.setOnAction(e -> {
			Label label1 = null;
			try {
				label1 = new Label(getTemp("st.louis"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			VBox pane1 = new VBox(20);
			pane1.setAlignment(Pos.CENTER);
			//bt1 = new Button("going back");
			//bt2 = new Button("cancell");
			pane1.getChildren().addAll(label1,bt1,bt2);
			Scene scene1 = new Scene(pane1,400,300);
			primaryStage.setScene(scene1);
			});

		Scene scene = new Scene(pane, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bt1.setOnAction(e -> primaryStage.setScene(scene));
		bt2.setOnAction(e -> System.exit(1));

    
	}

	public static String getTemp(String city) throws IOException {
	String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=87f3204777e25418828dc7d3dc473d21";
		
	java.net.URL myurl = new java.net.URL(url);
	Scanner input = new Scanner(myurl.openStream());
	
	String s = input.nextLine();

	String [] list = s.split(",");
	
	String [] list1 = list[7].split(":");
	
	double tem = Double.parseDouble(list1[2]);
	double temprature = Math.round(tem - 273.15);
	
	return "the temperature of " + city + " is " + temprature + " Culciuse degree";
	
	
	}
	
}
