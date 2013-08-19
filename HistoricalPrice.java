import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@SuppressWarnings("deprecation")
public class HistoricalPrice {
	private String stockNname;
	private SortedMap<Date,Price> price = new TreeMap<Date,Price>();
	
	
	public HistoricalPrice(String stockNname){
		this.stockNname=stockNname;
	}
	
	public void add(Price records){
		price.put(records.getDate(),records);
	}
	
	public void maxOfYear(){
		System.out.println(stockNname + "\nMAX Price of the Year: " );
		double max;
		int yearLoop = price.firstKey().getYear();
		while(price.lastKey().getYear() >= yearLoop){
			max = 0;
			SortedMap<Date, Price> submap = price.subMap(new Date(yearLoop,1,1), new Date(++yearLoop,1,1));
			for(Map.Entry<Date,Price> entry : submap.entrySet()){
				if(0 == max){
					max = entry.getValue().getRecord();
				}else if(max < entry.getValue().getRecord()){ 
					max = entry.getValue().getRecord();
				}	
			}
			System.out.println((yearLoop-1+1900) + "  " + max);
		}	
		System.out.println();
	}

	public void minOfYear(){
		System.out.println(stockNname + "\nMIN Price of the Year: ");
		double min;
		int yearLoop = price.firstKey().getYear();
		while(price.lastKey().getYear() >= yearLoop){
			min = 0;
			SortedMap<Date, Price> submap = price.subMap(new Date(yearLoop,1,1), new Date(++yearLoop,1,1));
			for(Map.Entry<Date,Price> entry : submap.entrySet()){
				if(0 == min){
					min = entry.getValue().getRecord();
				}else if(min > entry.getValue().getRecord()){ 
					min = entry.getValue().getRecord();
				}	
			}
			System.out.println((yearLoop-1+1900) + "  " + min);
		}
		System.out.println();
	}
	
	public void printMap(){
		for(Map.Entry<Date,Price> entry : price.entrySet()){
			System.out.println(entry.getKey().getYear() +"/"+
								entry.getKey().getMonth() +"/"+ 
								entry.getKey().getDate() +"   "+ 
								entry.getValue().getRecord());
		}
	}
	
	
}
