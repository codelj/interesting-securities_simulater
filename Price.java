import java.util.Date;

public class Price {
  	private double record;
	private Date date;
 
	Price(Date date,double record){
		this.record = record;
		this.date = date;		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getRecord() {
		return record;
	}

	public void setRecord(double record) {
		this.record = record;
	}

}
