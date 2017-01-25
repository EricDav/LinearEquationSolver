 import java.util.Scanner;
import java.util.Stack;
public class LinearEquationSolver
{
    
    public static String reverse(String s){   
    String l = "";
    for(int i= 0; i < s.length(); i++){
        if(s.charAt(i)!=(' '))
        l = l + s.charAt(i);
    }
        String rev = "";
        for(int i = l.length() -1; i >= 0; i--){
            rev +=l.charAt(i);
        }
        return rev;
    }
    public static String[] SplitEquation(String equation){
    String l = "";
    for(int i= 0; i < equation.length(); i++){
        if(equation.charAt(i)!=(' '))
        l = l + equation.charAt(i);
    }
    if (l.length() == 1){
         String[] arr = {l};
         return arr;
        }
    Stack<String> S_eq = new Stack<String>();
    String stor = "";
    Stack<String> S = new Stack<String>();
    for(int i = 0; i < l.length()-1; i++){
        char ch = l.charAt(i);
        if (Character.isDigit(l.charAt(i))){
            stor +=l.charAt(i);
            if(Character.isLetter(l.charAt(i+1)))S_eq.push(stor + l.charAt(i+1));
            else if(l.charAt(i+1) == '+' || l.charAt(i+1) == '-'  || l.charAt(i+1) == '=') S_eq.push(stor);
            else if(i == l.length() - 2) S_eq.push(stor + l.charAt(i+1));
        }
         else if(Character.isLetter(l.charAt(i))){
             if(i == 0) S_eq.push("" + l.charAt(i));
             else if(l.charAt(i-1) == '+' || l.charAt(i-1) == '-'  || l.charAt(i-1) == '=')S_eq.push("" +l.charAt(i));
            }
         else if(l.charAt(i) == '+' || l.charAt(i) == '-'  || l.charAt(i) == '=')S_eq.push("" +l.charAt(i));
         if(Character.isLetter(l.charAt(i)) || l.charAt(i) == '+' || l.charAt(i) == '-'  || l.charAt(i) == '=') stor = "";
    

}
if(l.charAt(l.length() -2) == '+' || l.charAt(l.length() -2) == '-'  || l.charAt(l.length() -2) == '=')S_eq.push("" + l.charAt(l.length() -1));
int j = 0;
while(S_eq.isEmpty() == false){
j+=1;
S.push(S_eq.pop());
}
String[] Arr = new String[j];
for(int k =0; k < j; k++){
    Arr[k] = S.pop();
}
return Arr;
}
public static String CollectionOfVariable(String equation){
    int check = 0;
    int check1 = 0;
    int check2 = 0;
    String variables = "";
    String[] l = SplitEquation(equation);
    String a = "=";
    //"3x + 67= 79x -54x +5"
    for(int i = 0; i < l.length; i++){
        if(l[i].equals(a)) check = 1;
        if(l[i].length() > 1){
            for(int j = 0; j < l[i].length(); j++){
                if(Character.isLetter(l[i].charAt(j)))check1 = 1;
            }
        }
        else{
            if(Character.isLetter(l[i].charAt(0))) check2 = 1;
        }
    
        if(check1 == 1 || check2 == 1){
            if(i == 0)variables = " " + l[i] + " ";
            else if(i > 0 && check == 0)variables = variables + " " + l[i-1] + " " + l[i];// System.out.println(a);}
            else if(i > 0 && check == 1){ 
                if(l[i-1].equals("+") || l[i-1].equals("="))variables = variables + " " + "-" + " " + l[i];
                else if(l[i-1].equals("-")) variables = variables + " " + "+" + " " + l[i];
                //System.out.print(a);
            }
        }
        check1 = 0;
        check2 = 0;
       }
       return variables;
    }
public static String CollectionOfConstants(String equation){
    int check = 0; String[] L = SplitEquation(equation); int check1 = L.length; String constants = "";
    for(int i = 0; i < L.length; i++){
        if(L[i].equals("="))check1 = 0;
        if(L[i].length() > 1){
            for(int j = 0; j < L[i].length(); j++){
                if(Character.isLetter(L[i].charAt(j)))check = 1;
        }
    }
        if(Character.isLetter(L[i].charAt(L[i].length() - 1)) == false && L[i].equals("+")== false && L[i].equals("-")==false && L[i].equals("=")==false && check ==0){ 
            if(check1 < i){
               if(L[i-1].equals("="))constants = constants + " " + "+" + " " + L[i];
               else constants = constants + " " + L[i-1] + " " + L[i]; 
            }
            if(check1 > i){
                if(i == 0)constants = constants + " " + "-" + " " + L[i];
                else if(L[i-1].equals("+"))constants = constants + " " + "-" + " " + L[i];
                else if(L[i-1].equals("-"))constants = constants + " " + "+" + " " + L[i];
            }
        }
        check = 0;
        //System.out.print(c
    }
        String var = "";
        if(constants.length() >=2){
        if(constants.charAt(1) == '+'){
            for(int y = 0; y < constants.length(); y++){
                if(y != 1){
                    var = var + constants.charAt(y);
                }
                
            }
            return var;
        }
    }

    if (constants.equals("")) return "0";
    return constants;
}
public static String AddVariables(String variables){
    String l = "";
     //removing trailing spaces in variables
    for(int k= 0; k < variables.length(); k++){
        if(variables.charAt(k)!=(' '))
        l = l + variables.charAt(k);  
    }
   //this variable sum up the coefficients of all the variables
   int Sum = 0;
   //this variables holds the current coeffient of a variable in string
   String st = "";
   char variable = ' ';
   for(int i = 0; i < l.length(); i++){
       if(Character.isLetter(l.charAt(i))){
            variable = l.charAt(i); break;
        }
    }
    for(int j = 0; j < l.length(); j++){
        if(l.charAt(j) == variable){
            if(j == 0)Sum+=1;
            else if(l.charAt(j-1) == '-') Sum -=1;
            else if(l.charAt(j-1) == '+' ) Sum +=1;
            else{
                int w = j-1;
               
                while(Character.isDigit(l.charAt(w))){
                    st +=l.charAt(w);
                    w -=1;
                    if(w < 0)break;
                }
                if(w < 0 )Sum +=Integer.parseInt(reverse(st));
                else if(l.charAt(w) == '+' )Sum +=Integer.parseInt(reverse(st));
                else Sum -=Integer.parseInt(reverse(st));
                
            
        }
       
            st = "";
        }
    }
    if(Sum == 1)return "" + variable;
    else if(Sum == -1) return "-" + variable;
    else return Integer.toString(Sum) + variable;
    
}
public static String Expand(String equation){
    //this variable holds final result after expanding the bracket
    String FinA = "";
    String Fin = "";
    String cent = "";
    String sign = "";
    int cheker = 0; 
    //this variable check if the next number is not in num
    int check1 = 0;
    String[] a ={"k"};
    String main = "";
    String hold = "";
    
     String l = "";
     //removing trailing spaces in equation
    for(int i= 0; i < equation.length(); i++){
        if(equation.charAt(i)!=(' '))
        l = l + equation.charAt(i);
    }
    String num = " ";
    
    for(int i = 0, v = l.length(); i < v; i++){
         num = " ";
        //check1= 0;
        String inb = "";
        
        if(l.charAt(i) == '-' || l.charAt(i) == '+' || l.charAt(i) == '=' || Character.isDigit(l.charAt(i))){
   
            for(int m = i+1; m < l.length(); m++){
                //System.out.println(m);
                if (l.charAt(m) == '('){
                    check1 = 1;
                    //System.out.println(check1);
                    break;
                }
                else if(l.charAt(m) == '+' || l.charAt(m) == '-' || l.charAt(m) == '=')break;
            }
        }
        //int j = 0;
        //checking if it has gotten to the open bracket
        if(l.charAt(i) == '('){
            check1= 0;
            // making the variable hold empty after each passing
            hold = "";
            //check = 1;
            // the variable j tells if the open bracket is the first element in the string and also try to get the first number in num.
             int j = i-1;
             
             int k = i+1;
             //trying to get the number that is used to multily everything in the bracket and assign it to the variable num
            if(j>= 0){
            while(Character.isDigit(l.charAt(j))){
                num = num + l.charAt(j);
                j -=1; 
                if (j < 0) break;
            }
        }
        
        if(num == " ")num = "1";
        num = reverse(num);
        String fnum = num;
          //trying to get the sign of the factorize number(num)
        if(j < 0 || l.charAt(j) == '+' || l.charAt(j) == '=') num = "+" + num;
        else num = "-" + num;
        //concatinating all variables and signs inside the bracket and initialize it to hold
        while (l.charAt(k) != ')'){
            hold = hold + l.charAt(k); 
            k +=1;
        }
        
        // spliting hold and initialize it in an array hold
          String[] shold  = SplitEquation(hold);
          //len = shold.length;
          //System.out.print(num);
           cent = "";
        
         //looping through the array that contains the variable string
        for(int m = 0; m < shold.length; m++){
            //picking the variables alone without the sign
            if(shold[m].equals("+") == false && shold[m].equals("-") == false && shold[m].equals('=') == false){
                //checking if the string is a digit(constant)..if yes pick the sign along and concatinate with cent
                if (Character.isDigit(shold[m].charAt(shold[m].length()-1))){
                     if( m == 0 && num.charAt(0) == '+')sign = "+"; 
                     else if( m == 0 && num.charAt(0) == '-')sign = "-";
                     else if (shold[m-1].equals("+") && num.charAt(0) == '+')sign = "+";
                    else if (shold[m-1].equals("-") && num.charAt(0) == '+')sign = "-";
                    else if (shold[m-1].equals("+")  && num.charAt(0) == '-')sign = "-";
                    else if (shold[m-1].equals("-") && num.charAt(0) == '-')sign = "+"; 
                    
                    int t = Integer.parseInt(fnum) * Integer.parseInt(shold[m]);
                    
                    cent = cent + sign + Integer.toString(t);
                   
                }
                //checking if the string is a variable meaning it contains a letter...if yes pick the sign along and concatinate with cent
                else if(Character.isLetter(shold[m].charAt(shold[m].length()-1))){
                   
                    String cr = "";
                    //initialising the coeffient of each variable to be 1, if the length of the vriable is one. 
                     if(shold[m].length() == 1)cr = "1";
                     //getting the coefficient of each variable 
                     else{
                    for(int r = 0; r < shold[m].length()-1; r++){
                        cr +=shold[m].charAt(r); 
                        }
                        }
                        //System.out.print(cr);
                       //getting the signs
                     if( m == 0 && num.charAt(0) == '+')sign = "+"; 
                     else if( m == 0 && num.charAt(0) == '-')sign = "-";
                     else if (shold[m-1].equals("+") && num.charAt(0) == '+')sign = "+";
                    else if (shold[m-1].equals("-") && num.charAt(0) == '+')sign = "-";
                    else if (shold[m-1].equals("+")  && num.charAt(0) == '-')sign = "-";
                    else if (shold[m-1].equals("-") && num.charAt(0) == '-')sign = "+"; 
                    
                    int u = Integer.parseInt(fnum) * Integer.parseInt(cr);
                    cent = cent + sign + Integer.toString(u) + shold[m].charAt(shold[m].length()-1);
                   // System.out.print(shold[m].charAt(shold[m].length()-1));
                    
                        }
                       
                   }
                  
              
            }
         cheker = k+1;
         
         Fin = Fin + cent;
         
         
        }
        
        
        else{
           if(l.charAt(i) == '='){
               if(l.charAt(i+1) == '(')check1 = 0;
            
            }
        
            if(i == cheker && check1 == 0){
            Fin = Fin  + l.charAt(i);
            cheker +=1;
        }
        else if (l.charAt(i) == '=' && Character.isDigit(l.charAt(i+1))){
            Fin = Fin   +  l.charAt(i);
        }
        }
        
        }
        return Fin;
    }
    public static String AddConstants(String constants){
        int s_count = 0;
        String l = "";
        int Sum = 0;
        String Add = "";
        int count = 0;
     //removing trailing spaces in variables
    for(int k= 0; k < constants.length(); k++){
        if(constants.charAt(k)!=(' '))
        l = l + constants.charAt(k);
    }
    for(int i = 0; i < l.length(); i++){
        if(l.charAt(i) == '+' || l.charAt(i) == '-')s_count +=1;
    }
    if(s_count == 0)return l;
    else if(s_count == 1 && l.charAt(0) == '-')return l;
    for(int m = 0; m < l.length(); m++){
        //System.out.println(l);
        if(l.length() == 1)return l;
      //  else if(l.length() == 2) return "-" + l.charAt(1);
        if(Character.isDigit(l.charAt(m))){
            Add +=l.charAt(m);
            count +=1;
    }
    if((Character.isDigit(l.charAt(m)) == false && m!=0) || m == l.length()-1){
          //System.out.println(count);
           // System.out.println(Add);
     if(count - m == 0) Sum +=Integer.parseInt(Add);
     else if(l.charAt(m-count-1) == '+') Sum +=Integer.parseInt(Add);
       else if(l.charAt(m-count-1) == '-')Sum -=Integer.parseInt(Add);
       else if(m == l.length()-1 && l.charAt(m-count) == '+') Sum +=Integer.parseInt(Add);
         else if(m == l.length()-1 && l.charAt(m-count) == '-') Sum -=Integer.parseInt(Add);
        Add = "";
      
       count = 0;
         //System.out.println(Sum);
    }
    }
   return Integer.toString(Sum);
}
public static String getCoefficient(String AddVar){
    String sign = "";
    String sum = "";
    if(AddVar.length() == 1) return "1";
    else if(AddVar.length() == 2 && AddVar.charAt(0) == '-') return "-1"; 
    
    for(int i = 0; i < AddVar.length(); i++){
        if(Character.isDigit(AddVar.charAt(i)))sum+=AddVar.charAt(i);
    }
    if(AddVar.charAt(0) == '-')return "-" + sum;
    return sum;
}
public static boolean InputValidation(String equation){
    String l = "";
    //this store the sign
    String sign = "";
    int ovar = 0;
    //int cvar = 0;
    //this hold the variable
    char var = ' ';
    //this variabble 'count' count the number of equality sign (=) in the equation
    int count = 0;
    //validating for empty equation
    String num = "";
     for(int i= 0; i < equation.length(); i++){
        if(equation.charAt(i)!=(' '))
        l = l + equation.charAt(i);
    }
    equation = l;
    if(equation.length() == 0){
        System.out.println("You didnt input anything!");
        return true;
    }
    //Validating for valid variable
    for(int i = 0; i < equation.length(); i++){
        
        if (Character.isLetter(equation.charAt(i)) == false && Character.isDigit(equation.charAt(i))== false && equation.charAt(i) != '+' && equation.charAt(i) != '-' && equation.charAt(i) != '='  && equation.charAt(i)!= '(' && equation.charAt(i)!= ')'){
            System.out.println("Invalid equation! You are not expected to use the sign  " + equation.charAt(i) + " in your equation");
            return true;
        }
        if(equation.charAt(i) == '=')count +=1;
        if(Character.isLetter(equation.charAt(i))) var = equation.charAt(i);
    }
    if (count == 0){
        System.out.println("Invalid equation! There is no equality sign in your equation");
        return true;
    }
    else if (count > 1){
        System.out.print("Oosh! This is serious you imputed " + Integer.toString(count) + " equality sign(=) in your eqution. You are expected to write one equality in your equation");
        return true;
   
}
//Checking if there is more than one variable in the equation
for(int j = 0; j < equation.length(); j++){
    if(Character.isLetter(equation.charAt(j)) && equation.charAt(j) != var){
        System.out.println("Come on this is a linear equation solver you cant have more than one variable!");
        return true;
    }
}
if(equation.charAt(equation.length()-1) == '='){
    System.out.println("Invalid equation! You did not input anything after the equality sign(=)");
    return true;

}
else if(equation.charAt(0) == '='){
    System.out.println("Invalid equation! You did not input anything before the equality sign(=)");
    return true;
} 
//checking if the equation ends with either + or - Or two or more signs come together
for(int k = 0; k < equation.length(); k++){
    if((equation.charAt(0) == '+' && equation.charAt(1) == '=') || (equation.charAt(0) == '-' && equation.charAt(1) == '=')){
        System.out.println("Invalid equation! It is wrong to have only " + equation.charAt(0) + " in the left hand side of the equation");
        return true;
    }
    if (equation.charAt(k) == '-' || equation.charAt(k) == '+'){
        sign = "" + equation.charAt(k);
        if(k == equation.length() -1){
            System.out.println("Invalid equation! You can not end an equation with " + sign);
            return true;
        }
        else if(equation.charAt(k+1) == '+' || equation.charAt(k+1) == '-'){
            
            System.out.print("Invalid equation! Two or more signs(e.g +, -) can not be together ");
            return true;
        }
    }
    if(Character.isLetter(equation.charAt(k))){
        if(k != equation.length() -1){
        
        if(Character.isLetter(equation.charAt(k+1))){
            System.out.println("Invalid equation! Two or more  variables can not be together. ");
            return true;
        }
    }
    }
    if(k != equation.length() -1){
    if(Character.isLetter(equation.charAt(k)) && Character.isDigit(equation.charAt(k+1)))
        {
            System.out.println("Invalid equation! You are expected to input either \"+\" or \"-\"  sign after " +  equation.charAt(k) + " but you input " + equation.charAt(k+1) + " which is a number");
            return true; 
        }
    }
    if(equation.charAt(k) == '(' || equation.charAt(k) == ')'){
        sign = "" + equation.charAt(k);
        if(k != equation.length() -1){
        if(equation.charAt(k+1) == '(' || equation.charAt(k+1) == ')'){
            System.out.println("Invalid equation! You cant have two or more " + sign + " together");
            return true;
        }
    }
    }
}
for(int n = 0; n < equation.length(); n++){
    if(equation.charAt(n) == ')' || equation.charAt(n) == '('){
        if(equation.charAt(n) == ')'){
        System.out.println("Invalid equation! You cant start with a close bracket.");
        return true;
    }
    else break;
    }
}
for(int m = 0; m < equation.length(); m++){
    if(equation.charAt(m) == '(' )ovar += 1;
    else if(equation.charAt(m) ==  ')')ovar -= 1;
    if(ovar > 1){
        System.out.println("Invalid equation! You are expected to put a close bracket \")\" after " + equation.charAt(m-1) + " not an open bracket \"(\" ");
        return true;
    }
    else if (ovar < 0){
        System.out.println("Invalid equation! You are expected to put a open bracket \"(\" after " + equation.charAt(m-1) + " not a close bracket \") \" ");
        return true;
    }
    
}
if(ovar == 1){
    System.out.println("Invalid equation! You didnt close a bracket you opened.");
    return true;
}
String hold = "";
//making sure that the factorize number has nno variable;
for(int i = 0; i < equation.length(); i++){
    
   if(l.charAt(i) == '('){
           // check1= 0;
            // making the variable hold empty after each passing
            hold = "";
            // the variable j tells if the open bracket is the first element in the string and also try to get the first number in num.
             int j = i-1;
             
             int k = i+1;
             //trying to get the number that is used to multily everything in the bracket and assign it to the variable num
            if(j>= 0){
            while(Character.isDigit(l.charAt(j)) || Character.isLetter(l.charAt(j))){
                num = num + l.charAt(j);
                j -=1; 
                if (j < 0) break;
            }
        }
        
        while (l.charAt(k) != ')'){
            hold = hold + l.charAt(k); 
            k +=1;
        }
        for(int q = 0; q  < num.length(); q++){
    if(Character.isLetter(num.charAt(q))){
        System.out.println("Invalid equation! You are not allowed to open a bracket with a variable");
        return true;
    }
}
for(int q = 0; q  < hold.length(); q++){
    if(hold.charAt(q) == '='){
        System.out.println("Invalid equation! It does not make sense to have an equality sign inside a bracket");
        return true;
    }
    if(hold.length() == 1 ){
        if(hold.charAt(q) == '+' || hold.charAt(q) == '-'){
            System.out.println("Invalid equation! It is wrong to have only " + hold.charAt(q) + " in a bracket"); 
            return true;
        }
    }
}
num = "";
hold = "";
}
}
return false;
} 
public static void LinearEquation(){
    String eq = "";
    boolean a = true;
    Scanner mak = new Scanner(System.in);
    while(a){
        System.out.print("Kindly enter the equation you want me to solve: ");
        eq = mak.nextLine();
        a = InputValidation(eq);
    }
    int nb = 1;
    boolean check = false;
    for(int i = 0; i < eq.length(); i++){
        if(eq.charAt(i) == '(')check = true;
    }
     String l = "";
     //removing trailing spaces in equation
    for(int b= 0; b < eq.length(); b++){
        if(eq.charAt(b)!=(' '))
        l = l + eq.charAt(b);
    }
     int rev = 0;
//     for(int f = 0; f < l.length(); f++){
    System.out.println("Step1: Write down the equation ");
    System.out.println(eq);
    
    if(check){
        nb +=1;
        System.out.println("Step" + Integer.toString(nb) + ": Open the bracket ");
        eq = Expand(eq);
        System.out.println(eq);
    }
        
        nb +=1;
        System.out.println("Step" + Integer.toString(nb) + ": Collect like terms ");
        String var = CollectionOfVariable(eq);
        String con = CollectionOfConstants(eq);
        System.out.println(var + " = " + con);
        nb +=1;
        System.out.println("Step" + Integer.toString(nb) + ": Simplify both sides of the equation");
        String avar = AddVariables(var);
        String v =  "" + avar.charAt(avar.length() -1);
        String acon = AddConstants(con);
        System.out.println(avar + " = " + acon);
        String cof = getCoefficient(avar);
        if(cof.equals("1")){
            System.out.println("Therefore " +  avar + " = " + acon); 
        }
        else if(cof.equals("-1")){
            nb +=1;
            System.out.println("Step" + Integer.toString(nb) + ": Multiply through by -1");
            int ans = -1 * Integer.parseInt(acon);
            String t = Integer.toString(ans);
            System.out.println("Therefore " + v + " = "  + t);
            
        }
        else if(cof.equals("0")){
           nb +=1;
        System.out.println("Step" + Integer.toString(nb) + ": Divide both side of the equation by " + cof);
           System.out.println(avar + "/" + cof + " = " + acon + "/" + cof);
           System.out.println("Therefore " + v + " = Infinity or NAN(Not a number)" );
        }
       
        else if(Integer.parseInt(acon)%Integer.parseInt(cof) == 0){
        nb +=1;
        System.out.println("Step" + Integer.toString(nb) + ": Divide both side of the equation by " + cof);
        System.out.println(avar + "/" + cof + " = " + acon + "/" + cof);
         int div = Integer.parseInt(acon)/Integer.parseInt(cof);
         System.out.println("Therefore " + v + " = " + Integer.toString(div));
        }
        else if(Integer.parseInt(acon)%Integer.parseInt(cof) != 0){
        nb +=1;
        System.out.println("Step" + Integer.toString(nb) + ": Divide both side of the equation by " + cof);
        System.out.println(avar + "/" + cof + " = " + acon + "/" + cof);
        
        if(Integer.parseInt(acon) < 0 && Integer.parseInt(cof) < 0){
            acon = Integer.toString(-1*Integer.parseInt(acon));
            cof = Integer.toString(-1*Integer.parseInt(cof));
        }
            int rem  = Math.abs(Integer.parseInt(acon)%Integer.parseInt(cof));
            int quo =Math.abs(Integer.parseInt(acon)/Integer.parseInt(cof));
            if(Integer.parseInt(acon) < 0 && Integer.parseInt(cof) > 0 || Integer.parseInt(acon) > 0 && Integer.parseInt(cof) < 0){
                if(quo == 0)rem = -1 * rem;
                else quo = -1 * quo;
            }
            if (quo == 0) System.out.println("Therefore " + v + " = "  +  Integer.toString(rem) + "/" + cof);
            else System.out.println("Therefore " + v + " = " + Integer.toString(quo) + "(" + Integer.toString(rem) + "/" + Integer.toString(Math.abs(Integer.parseInt(cof))) + ")");
        }
        
}
}
