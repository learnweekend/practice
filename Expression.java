/*
 Problem :  Evaluate Simple Expression with operators + and -
 */
 public class Expression {
   public static void main(String[] args) {
       System.out.println(evaluate("6+9-12-10")); // -7
		   System.out.println(evaluate("-6+9-12-10")); // -19
		   System.out.println(evaluate("-6-9-12-10")); // -37
		   System.out.println(evaluate("6+9-12-1")); // 2
		   System.out.println(evaluate("6+0-12-1")); // -7
   }

   public static int evaluate(String expression){
     if(expression == null || expression.length() == 0) return 0;
     boolean isNegative = expression.charAt(0) == '-' ? true : false;
     int index = 0;
     int result = 0;
     if(isNegative) index++;

     StringBuilder sb = new StringBuilder();
     while(index < expression.length() && expression.charAt(index) >= '0' && expression.charAt(index) <= '9')
        sb.append(expression.charAt(index++));
     int value = Integer.parseInt(sb.toString());
     result = isNegative == true ? -value : value;

     while(index < expression.length()) {
       char operator = expression.charAt(index);
       index++;
       sb = new StringBuilder();
       while(index < expression.length() && expression.charAt(index) >= '0' && expression.charAt(index) <= '9')
          sb.append(expression.charAt(index++));
       value = Integer.parseInt(sb.toString());

       if(operator == '+') result += value;
       else if(operator == '-') result -= value;
     }
     return result;
   }
 }
