/*
 Problem : Given a number, determine if the number is prime or not.
 */

 public class PrimeNumber {

   private static boolean isPrimeSlow(int number){
     if(number <= 1) return false;
     if(number % 2 == 0) return false;
     for(int i = 3; i < number; i++){
       if(number % i == 0) return false;
     }
     return true;
   }

   private static boolean isPrimeFast(int number) {
     if(number <= 1) return false;
     if(number % 2 == 0) return false;

     for(int i = 3; i < Math.sqrt(number) + 1; i += 2){
       if(number % i == 0) return false;
     }
     return true;
   }

   private static void primeFactors(int number){
     while(number % 2 == 0) {
       System.out.print(2 + " ");
       number /= 2;
     }
     for(int i = 3; i <= Math.sqrt(number); i += 2){
       while(number % i == 0) {
         System.out.print(i + " ");
         number /= i;
       }
     }

     if(number > 2)
      System.out.print(number);
   }

   public static void main(String[] args) {
     //primeFactors(12);
     primeFactors(214748364);
   }
 }
