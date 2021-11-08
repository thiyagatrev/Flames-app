import java.util.Scanner;

public class flames
    {

        public static void main(String[] args)
        {
            /*inputs from the user*/
            System.out.println("enter the first name:");
            Scanner in=new Scanner(System.in);
            String name1=in.nextLine();
            System.out.println("enter the second name:");
            String name2=in.nextLine();

            /*converting the string to char*/
            char[] name1char=name1.toCharArray();
            char[] name2char=name2.toCharArray();

            /*eliminating the common letters*/

            int a,b,c;
            a= name1.length();
            b= name2.length();
            c=a+b;


            System.out.println(a+" "+b+" "+c);

            for(int i=0;i<a;i++)
            {
                for(int j=0;j<b;j++)
                {
                    if(name1char[i] == name2char[j])
                    {
                        System.out.println(name1char[i]+" "+name2char[j]);
                        name1char[i]=' ';
                        name2char[j]=' ';
                        c=c-2;
                        break;
                    }

                }
            }
            System.out.println("c:"+c);



            /*elimination of letter in FLAMES*/


            String flames = "f";
            StringBuilder d = new StringBuilder(flames);

            char flameResult = 0;

            while(d.length()!=1)
            {
                int y = c %d.length();
                String temp;

                if(y!=0)
                {
                    temp = d.substring(y) + d.substring(0, y-1); // taking substring (counting purpose)

                }
                else
                {
                    temp = d.substring(0, d.length()-1); // taking substring (counting purpose)

                }
                d = new StringBuilder(temp);
                flameResult = d.charAt(0);

            }
            System.out.println(flameResult);

            /* results*/

            switch(flameResult)
            {
                case 'f':
                    System.out.println("Friends");
                    break;
                case 'l':
                    System.out.println("Love");
                    break;
                case 'a':
                    System.out.println("Affection");
                    break;
                case 'm':
                    System.out.println("Marriage");
                    break;
                case 'e':
                    System.out.println("Enemies");
                    break;
                case 's':
                    System.out.println("Sibling");
                    break;

            }
            System.out.println(flameResult);
        }



    }
