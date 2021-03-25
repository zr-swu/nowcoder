import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Playfair密码加密
 *
 * @author zr
 * @create 2021-03-25-19:27
 */
public class playfair {



    /**
     * 根据密钥构造矩阵
     * @param array
     * @param pair
     * @return
     */
    public static char constructArray(char[][] array, String pair) {

        HashMap<Character, Integer> map = new HashMap<>();

        ArrayList<Character> list =new ArrayList<>();
        for (char i = 'a'; i <='z'; i++) {
            list.add(i);
        }

        int repeatTimes = 0;
        for (int i = 0; i < pair.length(); i++) {
            if(map.get(pair.charAt(i))!=null){
                System.out.println(pair.charAt(i)+"已经放过");
                repeatTimes++;
                continue;
            }
            map.put(pair.charAt(i),map.get(pair.charAt(i))==null?1:map.get(pair.charAt(i))+1);//记录已经放过的字母
            list.remove((Character)pair.charAt(i));
            System.out.println(i);
            array[i/5][i%5]=pair.charAt(i);//从上到下从左到右填入pair
        }

        //剩余的填上字母表里没用过的
        for (int i = 0, j = pair.length()-repeatTimes; i < list.size()-1&&j<25; i++,j++) {
            System.out.println(j);
            array[j/5][j%5]= list.get(i);
        }

        return list.get(list.size()-1);
    }

    public static String passwordAfterChange(char[][] array,String password,char unUsedch) {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < password.length(); i+=2) {
            if(i+1<password.length()){
                if(password.charAt(i)==unUsedch||password.charAt(i+1)==unUsedch){//如果一对字母中有一个字母不在正方形中"如z"，则不变换，直接放入加密串中
                    sb.append(password.charAt(i));
                    sb.append(password.charAt(i+1));
                }else if (password.charAt(i)==password.charAt(i+1)) {//如果一对字母中的两个字母相同，则不变换，直接放入加密串中
                    sb.append(password.charAt(i));
                    sb.append(password.charAt(i+1));
                }else {
                    //记录两个点的下标
                    int ch1i=0,ch1j=0,ch2i=0,ch2j = 0;
                    for (int j = 0; j < array.length; j++) {
                        for (int j2 = 0; j2 < array.length; j2++) {
                            if(array[j][j2]==password.charAt(i)){
                                ch1i=j;ch1j=j2;
                            }else if(array[j][j2]==password.charAt(i+1)){
                                ch2i=j;ch2j=j2;
                            }
                        }
                    }
                    if(ch1i==ch2i||ch1j==ch2j){//如果字母对出现在方阵中的同一行或同一列，如df或hi，则只需简单对调这两个字母，即变换为fd或ih
                        sb.append(password.charAt(i+1));
                        sb.append(password.charAt(i));
                    }else {
                        sb.append(array[ch1i][ch2j]);
                        sb.append(array[ch2i][ch1j]);
                    }

                }
            }else {//一对一对取字母，如果最后只剩下一个字母，则不变换，直接放入加密串中
                sb.append(password.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        char array[][]=new char[5][5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密钥:");
//        String pair = scanner.nextLine();
        String pair = "PLAYFAIR IS A DIGRAM CIPHER".replace(" ", "");
        System.out.println("请输入明文:");
//        String password = scanner.nextLine();
        String password = "playfair cipher".replace(" ", "");
        System.out.println(password);
        char unUsedch = constructArray(array, pair);
        System.out.println(passwordAfterChange(array, password, unUsedch));


        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }


}
