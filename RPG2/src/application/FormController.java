package application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class FormController {
	@FXML private Button topButton;
	@FXML private Label topLabel;
	@FXML private TextField topTextField;
	@FXML private TextArea topTextArea;

	@FXML public void onClick(){
		topLabel.setText("押されました！");
	}

	int x;
	int teamAHp;
	int teamBHp;
	boolean isEnded;

	Movable[] teamA;
	Movable[] teamB;

	public FormController() {
		teamA = new Movable[4];
		teamA[0] = new Robber("ドラえもん", 2800, 600, 400);
		teamA[1] = new Sniper("のび太", 1600, 430, 800);
		teamA[2] = new Robber("しずか", 600, 250, 200);
		teamA[3] = new Currypanman();

		teamB = new Movable[4];
		teamB[0] = new Robber("ジャイアン", 4500, 1000, 620);
		teamB[1] = new Sniper("スネ夫", 1200, 400, 300);
		teamB[2] = new Sniper("出木杉", 2600, 580, 700);
		teamB[3] = new Dokinchan();

		isEnded = false;

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(isEnded)return;
				String message = "";
				x++;
				int i = x%teamA.length;
				int j = (x/teamA.length)%2;

				topLabel.setText("");
				if(j==0) {
					message = ((Character)teamA[i]).introduce();
					topLabel.setText(topLabel.getText()+message);

					message = ((Character)teamA[i]).move((Character)teamB[(int)(Math.random()*teamB.length)]);
					topLabel.setText(topLabel.getText()+message);

					teamAHp += ((Character)teamA[i]).getHp();
				}else {
					message = ((Character)teamB[i]).introduce();
					topLabel.setText(topLabel.getText()+message);

					message = ((Character)teamB[i]).move((Character)teamA[(int)(Math.random()*teamA.length)]);
					topLabel.setText(topLabel.getText()+message);

					teamBHp += ((Character)teamB[i]).getHp();
				}
				teamAHp = 0;
				teamBHp = 0;
				for(int k=0; k<teamA.length; k++) {
					teamAHp += ((Character)teamA[k]).getHp();
				}
				for(int k=0; k<teamB.length; k++) {
					teamBHp += ((Character)teamB[k]).getHp();
				}
				if(teamAHp<=0) {
					topLabel.setText(topLabel.getText()+"teamBの勝利！");
					isEnded = true;
				}
				if(teamBHp<=0) {
					topLabel.setText(topLabel.getText()+"teamAの勝利！");
					isEnded = true;
				}
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
}

//		while(true) {
//			teamAHp=0;
//			for(int i=0; i<teamA.length; i++) {
//				if(teamA[i] instanceof Character) {
//					((Character)teamA[i]).introduce();
//					teamAHp+=((Character)teamA[i]).getHp();
//				}
//				int targetId;
//				do {
//					targetId = (int)(Math.random()*teamB.length);
//				}while(!(teamB[targetId] instanceof Character));
//				teamA[i].move((Character)teamB[targetId]);
//				System.out.println("--------------------------------------------");
//			}
//			if(teamAHp<=0) {
//				System.out.println("teamBの勝利！");
//				break;
//			}
//			teamBHp=0;
//			for(int i=0; i<teamB.length; i++) {
//				if(teamB[i] instanceof Character) {
//					((Character)teamB[i]).introduce();
//					teamBHp+=((Character)teamB[i]).getHp();
//				}
//				int targetId;
//				do {
//					targetId = (int)(Math.random()*teamA.length);
//				}while(!(teamA[targetId] instanceof Character));
//				teamB[i].move((Character)teamA[targetId]);
//				System.out.println("--------------------------------------------");
//			}
//			if(teamBHp<=0) {
//				System.out.println("teamAの勝利！");
//				break;
//			}
//		}
//	}
//}
