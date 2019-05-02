package application;
public abstract class Character{
	protected String name;
	protected int hp;
	protected int mp;
	protected int sp;

	Character(String name, int hp, int mp, int sp){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.sp = sp;
	}

	int getHp() {
		return hp;
	}

	public String introduce() {
		return "私の名前は"+this.name+"だ！"+" HP："+this.hp+" MP："+this.mp+" SP："+this.sp;
	}

	public String damage(int damage) {
		if(this.hp <= 0) {
			return this.name+"は既に倒れている";
		}else{
			return this.name+"は"+damage+"ポイントのダメージを受けた。";
			if(this.hp<damage) {
				this.hp -= damage;
				return this.name+"のHPが【0】になった。";
				return this.name+"は倒れた...";
			}else{
				this.hp -= damage;
				return this.name+"のHPが【"+this.hp+"】になった。";
			}
		}
	}

	public abstract String attack(Character character);
}