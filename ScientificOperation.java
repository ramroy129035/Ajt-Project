
  public class ScientificOperation extends Calculator {
   

    public ScientificOperation(double num1, double num2, double num3, double num4) {
        super(num1, num2, num3, num4);
    }

    public double add() { return num1 + num2; }
    public double subtract() { return num1 - num2; }
    public double multiply() { return num1 * num2; }
    public double divide() { return (num2 != 0) ? num1 / num2 : Double.NaN; }
    
   // साइंटिफिक ऑपरेशन्स
    public double power() { return Math.pow(num1, num2); }
    public double squareRoot() { return Math.sqrt(num1); }
    public double log() { return Math.log(num1); }
    public double sin() { return Math.sin(Math.toRadians(num1)); }
    public double cos() { return Math.cos(Math.toRadians(num1)); }
    public double tan() { return Math.tan(Math.toRadians(num1)); }
    
    // फैक्टोरियल निकालने का मेथड
    public long factorial() {
        if (num1 < 0) return -1; // नकारात्मक संख्याओं के लिए फैक्टोरियल परिभाषित नहीं है
        long fact = 1;
        for (int i = 1; i <= num1; i++) {
            fact *= i;
        }
        return fact;
    }
}