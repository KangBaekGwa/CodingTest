import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = null;
        temp = sc.next();

        while (!temp.equals("end")) {
            boolean flag = true;
            int ahdmaCnt=0, wkdmaCnt=0;

            if (temp.contains("a") == false && temp.contains("e") == false && temp.contains("i") == false && temp.contains("o") == false && temp.contains("u") == false)
                flag = false;

            for(int index=0; index<temp.length(); index++){
                if(temp.charAt(index) == 'a' ||
                        temp.charAt(index) == 'e' ||
                        temp.charAt(index) == 'i' ||
                        temp.charAt(index) == 'o' ||
                        temp.charAt(index) == 'u'){
                    ahdmaCnt++;
                    wkdmaCnt = 0;
                }
                else{
                    ahdmaCnt = 0;
                    wkdmaCnt++;
                }

                //연속단어 체크.
                if(index != 0 && temp.charAt(index) == temp.charAt(index-1)){
                    if(temp.charAt(index) == 'e' || temp.charAt(index) == 'o'){
                        if(index+1 >= temp.length()) flag = true;
                        else if(temp.charAt(index) == temp.charAt(index+1)) flag = false;
                    }
                    else{
                        flag = false;
                    }
                }

                if(ahdmaCnt == 3 || wkdmaCnt == 3) flag = false;
            }

            if(flag == false){
                System.out.println("<" + temp + "> is not acceptable.");
            }
            else{
                System.out.println("<" + temp + "> is acceptable.");
            }

            temp = sc.next();
        }
    }
}