package Service;

public class StringHandle {
    public static String convertStringArraytoString(String []stringArray){
        if(stringArray==null||stringArray.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String a : stringArray) {
            sb.append(a);
            sb.append(",");
        }
        String str = sb.toString();
        
        return str.substring(0,str.length()-1);
    }
    
}
