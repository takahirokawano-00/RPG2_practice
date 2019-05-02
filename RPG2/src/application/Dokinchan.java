package application;

public class Dokinchan implements Movable {
	public String introduce() {
		return "ドキンちゃんとは、私のことよ!";
	}
	@Override
	public String move(Character terget) {
		return "ドキンちゃんはしょくぱんまんを探している。";
	}
}
