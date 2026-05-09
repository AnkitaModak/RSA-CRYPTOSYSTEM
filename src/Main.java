import java.util.*;
class RSA{
    private int p,q,n,e,d;
    private String original;
    public RSA(int p ,int q){
        this.p = p;
        this.q = q;
        n = p*q;
    }
    public int calculatePhi(){
        return(p-1)*(q-1);
    }
    public int calculateD(){
        int phi = calculatePhi();

        for(int i = 1; i < phi; i++) {

            if((e * i) % phi == 1) {

                d = i;
                return d;
            }
        }

        return -1;
    }
    public static boolean gcdCheck(int a, int b){
        int gcd = 1;
        for(int i = 1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        if(gcd == 1){
            return true;
        }
        return false;
    }
    public int generateE(){
        for(int i = 1;i<=n;i++){
            if(gcdCheck(i,calculatePhi())){
                e = i;
                return e;
            }
        }
        return -1;
    }
    public int[] intToArr(String s){
        original = s;
        int len = s.length();
        int[] arr = new int[len];
        for(int i = 0; i < s.length(); i++){
            int n = (int)s.charAt(i);
            arr[i] = n;
        }
        return arr;
    }
    public int[] encrypt(String s){
        e = generateE();
        int[] original = intToArr(s);
        int len = s.length();
        int[] encrypted= new int[len];
        for(int i = 0;i<intToArr(s).length;i++){
            encrypted[i]= (int)(Math.pow(original[i],e)) % n;

        }
        return encrypted;
    }
    public String decrypt(int[] arr){
        d = calculateD();
        int[] encrypted = arr;
        int [] decrypted = new int[encrypted.length];
        for(int i = 0;i< encrypted.length;i++){
            decrypted[i] = (int)(Math.pow(encrypted[i],d)) %n;
        }
        String s= "";
        for(int i = 0 ;i< decrypted.length;i++){
            s+=(char)decrypted[i];
        }
        return s;
    }


}
class primeNo{
    public boolean primeCheck(int num){
        if(num <= 1) return false;
        for(int j = 2;j<=Math.sqrt(num);j++){
            if(num % j ==0){
                return false;
            }
        }
        return true;
    }
    public int generate(int lwr,int upr){
        for(int i = upr; i>= lwr;i--){
            if(primeCheck(i)){

                return i;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter lower bound:");
        int lwr = Integer.valueOf(sc.nextLine());

        System.out.println("Enter upper bound:");
        int upr = Integer.valueOf(sc.nextLine());

        primeNo obj1 = new primeNo();

        int p = obj1.generate(lwr, upr);

        upr = p - 1;

        int q = obj1.generate(lwr, upr);

        RSA obj2 = new RSA(p, q);

        int[] encrypted = null;

        String decrypted = "";

        int choice;

        do {

            System.out.println("HERE'S ALL YOUR OPTIONS:");

            System.out.println("1. Encrypt Message");
            System.out.println("2. Decrypt Message");
            System.out.println("3. Show Encrypted Message");
            System.out.println("4. Show Decrypted Message");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            choice = Integer.valueOf(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("Enter message:");

                    String s = sc.nextLine();

                    encrypted = obj2.encrypt(s);

                    System.out.println("Message Encrypted!");

                    break;

                case 2:

                    if (encrypted == null) {

                        System.out.println(
                                "No encrypted message found!");
                    } else {

                        decrypted =
                                obj2.decrypt(encrypted);

                        System.out.println(
                                "Message Decrypted!");
                    }

                    break;

                case 3:

                    if (encrypted == null) {

                        System.out.println(
                                "No encrypted message!");
                    } else {

                        System.out.println(
                                Arrays.toString(encrypted));
                    }

                    break;

                case 4:

                    if (decrypted.equals("")) {

                        System.out.println(
                                "No decrypted message!");
                    } else {

                        System.out.println(decrypted);
                    }

                    break;

                case 5:

                    System.out.println("Program Ended");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
}
