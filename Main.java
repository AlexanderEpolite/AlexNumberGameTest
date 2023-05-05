package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        
        numbers[0] = random(0, 9);
        numbers[1] = random(0, 9);
        numbers[2] = random(0, 9);
        
        if(true) {
            numbers[0] = 2;
            numbers[1] = 9;
            numbers[2] = 7;
        }
        
        int[][] orders = {
                {0, 1, 2},
                {0, 2, 1},
                {1, 2, 0},
                {2, 1, 0},
                {1, 0, 2},
                {2, 0, 1},
        };
        
        int attempts = 0;
        
        while(true) {
            
            attempts++;
            
            //numbers[0] != 0 && numbers[1] != 0 && numbers[2] != 0
            if(numbers[0] == 0) {
                if(numbers[1] == 0) {
                    if(numbers[2] == 0) {
                        break;
                    }
                }
            }
            
            int[] order = orders[random(0, 5)];
            
            numbers[order[0]] -= 3;
            numbers[order[1]] -= 2;
            numbers[order[2]] -= 1;
            
            numbers[0] = check(numbers[0]);
            numbers[1] = check(numbers[1]);
            numbers[2] = check(numbers[2]);
            
//            System.out.printf("%d %d %d\n", numbers[0], numbers[1], numbers[2]);
            
            if(attempts > 10000000) {
                System.out.printf("Exceeded maximum attempts: %d", attempts);
                System.exit(0);
            }
        }
        
        System.out.printf("1: %d, 2: %d, 3: %d\n", numbers[0], numbers[1], numbers[2]);
        System.out.printf("Took %d attempts\n", attempts);
    }
    
    private static int check(int number) {
        if(number == -1) return 9;
        if(number == -2) return 8;
        if(number == -3) return 7;
        
        if(number == 10) return 0;
        if(number == 11) return 1;
        if(number == 12) return 2;
        
        return number;
    }
    
    private static int random(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
