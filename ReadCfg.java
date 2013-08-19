

public class ReadCfg {

	public static void main(String[] args) throws MyException{
		if(args.length != 0){
			new FileProcess(args[0]).process();
		}else
			throw new MyException();
	}

}
