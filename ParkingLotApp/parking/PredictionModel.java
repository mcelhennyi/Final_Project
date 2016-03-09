package parking;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Josh
 * @version 1.0
 * @created 19-Feb-2016 5:52:33 PM
 */
public class PredictionModel {

	private File historicalData;

	public PredictionModel(){

	}

	public void finalize() throws Throwable {

	}

	public void addToHistory() throws IOException{
		//Get string name of file to write too
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		String dateString = dateFormat.format(date)+".txt";

		//get time stamp to append to file
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		Date time = new Date();
		String timeString = timeFormat.format(time);

		//if exists then append file else create new file and write to it
		historicalData = new File(dateString);
		if(historicalData.exists() && !historicalData.isDirectory()) { 
			FileWriter fw = new FileWriter(historicalData, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			
			
			//here is where we need to format the input 
			//text to include an array from webcommunications.getParkingGrid()
			//after the time stamp
			out.println(timeString);
			out.close();
		}
		else{
			historicalData.createNewFile();
			FileWriter fw = new FileWriter(historicalData);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			//here is where we need to format the input text to include an array after the time stamp
			out.println(timeString);
			out.close();
		}
	}

	public double makePrediction(){
		return 0;
	}
}//end PredictionModel