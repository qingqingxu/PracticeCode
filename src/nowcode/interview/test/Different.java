package nowcode.interview.test;

public class Different {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkDifferent("BarackObama"));
	}
	public static boolean checkDifferent(String iniString) {
        // write code here
		if(iniString==null||iniString.isEmpty()){
            return true;
        }
 
        for(int i=0; i< iniString.length(); i++){
            for(int j = i+1; j < iniString.length(); j++){
                if(iniString.charAt(i)==iniString.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
