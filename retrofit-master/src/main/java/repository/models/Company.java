package repository.models;

public class Company{
	private String bs, catchPhrase, name;

	public void setBs(String bs){
		this.bs = bs;
	}

	public String getBs(){
		return bs;
	}

	public void setCatchPhrase(String catchPhrase){
		this.catchPhrase = catchPhrase;
	}

	public String getCatchPhrase(){
		return catchPhrase;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
