package application;
import Movable;

public class Currypanman implements Movable{
	public String introduce() {
		return "僕が噂のカレーパンマンだ！";
	}
	@Override
	public String move(Character target) {
		return "カレーパンマンはストレッチをしている。";
	}
}
