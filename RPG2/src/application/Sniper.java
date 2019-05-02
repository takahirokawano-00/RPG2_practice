package application;
public class Sniper extends Character {
	Sniper(String name, int hp, int mp, int sp){
		super(name, hp, mp, sp);
	}

	@Override
	public String introduce() {
		return "私は狙撃兵の"+this.name+"だ！"+" HP："+this.hp+" MP："+this.mp+" SP："+this.sp;
	}

	@Override
	public String attack(Character character) {
		shot(character.name);
		character.damage(this.sp);
	}

	@Override
	public String move(Character target) {
		return attack(target);
	}

	public String shot(String name) {
		return "「"+name+"このやろう-！」";
		return this.name+"は"+name+"を撃った！";
	}
}
