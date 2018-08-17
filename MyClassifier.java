
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


class values{
	private float val1;
	private float val2;
	private float val3;
	private float val4;
	private float val5;
	private float val6;
	private float val7;
	private float val8;
	private String val9;

	public values(ArrayList<String> values, int size){
		if(size%9==0 && size!=0){
			this.setVal1(Float.parseFloat(values.get(0)));
			this.setVal2(Float.parseFloat(values.get(1)));
			this.setVal3(Float.parseFloat(values.get(2)));
			this.setVal4(Float.parseFloat(values.get(3)));
			this.setVal5(Float.parseFloat(values.get(4)));
			this.setVal6(Float.parseFloat(values.get(5)));
			this.setVal7(Float.parseFloat(values.get(6)));
			this.setVal8(Float.parseFloat(values.get(7)));
			this.setVal9(values.get(8));
		}
		else if(size%8==0 && size!=0){
			this.setVal1(Float.parseFloat(values.get(0)));
			this.setVal2(Float.parseFloat(values.get(1)));
			this.setVal3(Float.parseFloat(values.get(2)));
			this.setVal4(Float.parseFloat(values.get(3)));
			this.setVal5(Float.parseFloat(values.get(4)));
			this.setVal6(Float.parseFloat(values.get(5)));
			this.setVal7(Float.parseFloat(values.get(6)));
			this.setVal8(Float.parseFloat(values.get(7)));
			this.setVal9(null);
		}
	}

	public float getVal1() {
		return val1;
	}

	public void setVal1(float val1) {
		this.val1 = val1;
	}

	public float getVal2() {
		return val2;
	}

	public void setVal2(float val2) {
		this.val2 = val2;
	}

	public float getVal3() {
		return val3;
	}

	public void setVal3(float val3) {
		this.val3 = val3;
	}

	public float getVal4() {
		return val4;
	}

	public void setVal4(float val4) {
		this.val4 = val4;
	}

	public float getVal5() {
		return val5;
	}

	public void setVal5(float val5) {
		this.val5 = val5;
	}

	public float getVal6() {
		return val6;
	}

	public void setVal6(float val6) {
		this.val6 = val6;
	}

	public float getVal7() {
		return val7;
	}

	public void setVal7(float val7) {
		this.val7 = val7;
	}

	public float getVal8() {
		return val8;
	}

	public void setVal8(float val8) {
		this.val8 = val8;
	}

	public String getVal9() {
		return val9;
	}

	public void setVal9(String val9) {
		this.val9 = val9;
	}
}

class Knearest {
	public ArrayList<String> minDistance(ArrayList<values> learning, ArrayList<values> testing, int k){

		ArrayList<values> Oobjects = new ArrayList<values>();

		ArrayList<String> oputList = new ArrayList<String>(testing.size());

		ArrayList<Double> distances = new ArrayList<Double>();


		for(int j=0; j<testing.size();j++){

			for(int i=0; i<learning.size(); i++){


				double d1=0, d2=0, d3=0, d4=0, d5=0, d6=0, d7=0, d8=0, distance = 0;;

				d1 =  Math.pow(learning.get(i).getVal1() - testing.get(j).getVal1(),2);
				d2 =  Math.pow(learning.get(i).getVal2() - testing.get(j).getVal2(),2);
				d3 =  Math.pow(learning.get(i).getVal3() - testing.get(j).getVal3(),2);
				d4 =  Math.pow(learning.get(i).getVal4() - testing.get(j).getVal4(),2);
				d5 =  Math.pow(learning.get(i).getVal5() - testing.get(j).getVal5(),2);
				d6 =  Math.pow(learning.get(i).getVal6() - testing.get(j).getVal6(),2);
				d7 =  Math.pow(learning.get(i).getVal7() - testing.get(j).getVal7(),2);
				d8 =  Math.pow(learning.get(i).getVal8() - testing.get(j).getVal8(),2);

				distance = Math.sqrt(d1+d2+d3+d4+d5+d6+d7+d8);

				distances.add(distance);

			}
			if(k==1){
				int index = minIndex(distances, k);

				if(index==-1)
					oputList.add("yes");

				else
					oputList.add(learning.get(index).getVal9());
			}

			else{

				for(int p=0; p<k; p++){

						int index = minIndex(distances, k);

						Oobjects.add(learning.get(index));

						distances.set(index, Double.MAX_VALUE);

					}

					int cyes=0, cno=0;

					for(int p=0; p<Oobjects.size(); p++){
						if(Oobjects.get(p).getVal9().equals("no"))
							cno++;
						else
							cyes++;
					}

					if(cno>cyes)
						oputList.add("no");

					else
						oputList.add("yes");

			}

			Oobjects.clear();
			distances.clear();
		}
		return oputList;
	}

	private static int minIndex(ArrayList<Double> dist, int k){
		int min=0;

		for(int i=0; i<dist.size(); i++){

			if(dist.get(min)>dist.get(i))
				min=i;
		}
		if(k==1){
			for(int i=0; i<dist.size(); i++){

				if(dist.get(min)==dist.get(i) && min!=i)
					return -1;
			}
		}
		return min;
	}
}


public class MyClassifier{

	public static ArrayList<String> readFile(String location) throws Exception{

		// Reading File and returning numbers after separating them as strings

		FileReader file = new FileReader(location);

		BufferedReader reader = new BufferedReader(file);

		String text = "";

		String read = reader.readLine();

		while(read!= null){

			text += read+",";

			read = reader.readLine();
		}

		// converting numbers of a string to array list

		ArrayList<String> list = new ArrayList<String>(Arrays.asList(text.split(",")));

		// completed taking input

		return list;

	}

	public static ArrayList<values> makeList(ArrayList<String> fileValues){
		ArrayList<values> valObjs = new ArrayList<values>();


		ArrayList<String> tmp = new ArrayList<String>();

		if(fileValues.size()%9==0){

			for(int i=0; i<fileValues.size();i++){

				tmp.add(fileValues.get(i));

				if(tmp.size()==9){

					valObjs.add(new values(tmp, fileValues.size()));

					tmp.clear();

				}
			}
		}
		else if(fileValues.size()%8==0){

			for(int i=0; i<fileValues.size();i++){

				tmp.add(fileValues.get(i));

				if(tmp.size()==8){

					valObjs.add(new values(tmp, fileValues.size()));

					tmp.clear();

				}
			}

		}

		return valObjs;

	}


	public static void main(String[] args) throws Exception{

		String location = args[0];

		ArrayList<String> inputCheck = readFile(location);

		ArrayList<values> learning = makeList(inputCheck);

		location = args[1];

		inputCheck = readFile(location);

		ArrayList<values> testing = makeList(inputCheck);

		String action = args[2]; // can be knn or nb


			if(action.compareTo("NB")==0){
			System.out.println("This is going to be naive bayes!");
		}
		else {

			Knearest working = new Knearest();

			// created a new k nearest class object to use its functions. Only one object is necessary.
			ArrayList<String> index = working.minDistance(learning, testing, Integer.parseInt(String.valueOf(args[2].charAt(0))));


			for(int i=0; i<index.size(); i++){

				System.out.println(index.get(i));

			}

		}
	}
}
