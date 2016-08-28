import edu.duke.*;
/**
 * Write a description of BreakCaecerCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakCaecerCipher {
    public int[] countLetter(String message){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alph = alphabet.toLowerCase();
    int[] counts=new int[26];
    for(int k=0;k<message.length();k++){
      char ch=Character.toLowerCase(message.charAt(k));
      int dex=alph.indexOf(ch);
      if(dex !=-1){
           counts[dex]+=1;
        }    
    }
     return counts;
    } 
    public int maxIndex(int[] values){
      	int max=values[0];
      	int id=0;
      	for(int k=0; k < values.length; k++){
          	if(values[k]>max){
              	max=values[k];
            	}
        	}
        for(int k=0;k < values.length; k++){
            if(values[k]==max){
            id=k;
        }
        }
      	return id;
	}
    public String decrypt(String encrypted){
      CaesarCipher cc=new CaesarCipher();
      int[] freqs=countLetter(encrypted);
      int maxDex=maxIndex(freqs);
      int dkey=maxDex-4;
      if (maxDex < 4){
         dkey=26-(4-maxDex);  
      }
      System.out.println(dkey);
      return cc.encrypt(encrypted,26-dkey);
    }
    public String halfOfString(String message,int start){
     int length=message.length();
     int half=0;
     
     if(length%2==0){
       half=length/2;
     }
     else if(length%2==1){
        if(start==0){
          half=(length+1)/2;
        }
        else if(start==1){
          half=(length-1)/2;
        }
        }
     StringBuilder split=new StringBuilder(half);
     for(int i=start;i<half;i=i+2){
         split.append(message.charAt(i));
        }
     return split.toString();
    
    }
    public String decryptTwoKey(String encrypted){
    String x1=halfOfString(encrypted,0);
    String x2=halfOfString(encrypted,1);
    String d1=decrypt(x1);
    String d2=decrypt(x2);
    int length1=d1.length();
    int length2=d2.length();
    int totallength=length1+length2;
    StringBuilder decrypted=new StringBuilder(totallength);
    for (int i=0;i<totallength;i++){
      if(i%2==0){
        decrypted.append(d1.charAt(i/2));
        }
      else if(i%2==1){
        decrypted.append(d2.charAt((i-1)/2));
        }
    }
    return decrypted.toString();
    }
    public void test(){
      FileResource fr=new FileResource();
      String encrypted=fr.asString();
      String half1=halfOfString(encrypted,0);
      String half2=halfOfString(encrypted,1);
      System.out.println("this is a new try");
      System.out.println(half1 +"and "+  half2);
      String d1=decrypt(half1);
      String d2=decrypt(half2);
      System.out.println(d1 + "and"+ d2);
      String x=decryptTwoKey(encrypted);
      System.out.println(x);
    
    
    }
}
