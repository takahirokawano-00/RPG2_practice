package application;
interface Movable {
	default String introduce() {
		return "ごきげんよう、私だ。";
	}
	String move(Character target);
}
