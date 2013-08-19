import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileProcess {
	private String fileName;
	private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public FileProcess(String fileName){
		this.fileName = fileName;
	}
	
	private List<HistoricalPrice> objList =new ArrayList<HistoricalPrice>(); 
	public void process() {
		boolean title = true;

		try{
			File file = new File(fileName);
			BufferedReader in = new BufferedReader(
                     new FileReader(file));
			String line;
			
			while((line = in.readLine())!=null){
				
				String[] lineArray = line.split(",");
				if (lineArray.length > 0) {
					if (title){
						for (int i = 0; i < lineArray.length-1; i++){
							objList.add(new HistoricalPrice(lineArray[i+1]));
						}
						title = false;
					}else{
						Date date = format.parse(lineArray[0]);
						for(int i=0;i<lineArray.length-1;i++){
							objList.get(i).add(new Price(date,Double.valueOf(lineArray[i+1])));
						}	
					}
				}
			}
			for(int i=0;i<objList.size();i++){
				objList.get(i).maxOfYear();
				objList.get(i).minOfYear();
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void write(){
		try {
			PrintWriter output = new PrintWriter(".//price_of_the_year.txt");
			for(int i=0;i<objList.size();i++){
				objList.get(i).maxOfYear();
				objList.get(i).minOfYear();
			}
			output.close();
		}catch(IOException e){
			System.out.println(e);			
		}
			
	}
}
