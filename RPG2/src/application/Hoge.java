package application;

public class Hoge {
	public static void main(String[] args) {
		Movable teamA[] = new Movable[4];
		teamA[0] = new Robber("ドラえもん", 2800, 600, 400);
		teamA[1] = new Sniper("のび太", 1600, 430, 800);
		teamA[2] = new Robber("しずか", 600, 250, 200);
		teamA[3] = new Currypanman();

		Movable teamB[] = new Movable[4];
		teamB[0] = new Robber("ジャイアン", 4500, 1000, 620);
		teamB[1] = new Sniper("スネ夫", 1200, 400, 300);
		teamB[2] = new Sniper("出木杉", 2600, 580, 700);
		teamB[3] = new Dokinchan();

		int teamAHp;
		int teamBHp;
		while(true) {
			teamAHp=0;
			for(int i=0; i<teamA.length; i++) {
				if(teamA[i] instanceof Character) {
					((Character)teamA[i]).introduce();
					teamAHp+=((Character)teamA[i]).getHp();
				}
				int targetId;
				do {
					targetId = (int)(Math.random()*teamB.length);
				}while(!(teamB[targetId] instanceof Character));
				teamA[i].move((Character)teamB[targetId]);
				System.out.println("--------------------------------------------");
			}
			if(teamAHp<=0) {
				System.out.println("teamBの勝利！");
				break;
			}
			teamBHp=0;
			for(int i=0; i<teamB.length; i++) {
				if(teamB[i] instanceof Character) {
					((Character)teamB[i]).introduce();
					teamBHp+=((Character)teamB[i]).getHp();
				}
				int targetId;
				do {
					targetId = (int)(Math.random()*teamA.length);
				}while(!(teamA[targetId] instanceof Character));
				teamB[i].move((Character)teamA[targetId]);
				System.out.println("--------------------------------------------");
			}
			if(teamBHp<=0) {
				System.out.println("teamAの勝利！");
				break;
			}
		}
	}
}
