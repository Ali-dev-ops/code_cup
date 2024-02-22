import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfJoice = input.nextInt();
        double capacity = input.nextInt();
        double[][] joices = new double[3][numberOfJoice];
        double h;
        double v;

        for (int i = 0; i < numberOfJoice; i++) {
            h = input.nextDouble();
            v = input.nextDouble();
            joices[0][i] = h;
            joices[1][i] = v;
            joices[2][i] = h/v;
        }

        int indexOfMax = 0;
        double max = 0.0;
        double temp;
        for (int i = numberOfJoice - 1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                if (joices[2][i] > max) {
                    max = joices[2][i];
                    indexOfMax = i;
                }
            }
            temp = joices[2][indexOfMax];
            joices[2][indexOfMax] = joices[2][i];
            joices[2][i] = temp;
            max = 0.0;
            indexOfMax = 0;
        }
        double maxOfEarnedH = 0;
        for (int i = numberOfJoice - 1; i >= 0; i--) {
            if (joices[1][i] < capacity){
                capacity = capacity - joices[1][i];
                maxOfEarnedH += joices[0][i];
            } else {
                maxOfEarnedH += (capacity/joices[1][i])*joices[0][i];
                break;
            }
        }

        System.out.printf("%.1f",maxOfEarnedH);
    }
}
