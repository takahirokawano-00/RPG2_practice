package application;
public class Robber extends Character implements Movable{
	Robber(String name, int hp, int mp, int sp){
		super(name, hp, mp, sp);
	}

	@Override
	public String introduce() {
		return "私は強盗の"+this.name+"だ！"+" HP："+this.hp+" MP："+this.mp+" SP："+this.sp;
	}

	@Override
	public String attack(Character character) {
		return rob(character.name);
		return character.damage(this.sp);
	}

	@Override
	public String move(Character target) {
		return attack(target);
	}

	public String rob(String name) {
		return "「"+name+"のものは私のもの、私のものは私のものだ！」";
		return this.name+"は"+name+"を馬乗りで攻撃し、現金を奪った！";
	}
}
