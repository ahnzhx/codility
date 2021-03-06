package programmers.bruteForce;

import java.util.Scanner;

public class Q1182 {
    public static int go(int []a, int m, int i, int sum){
        if(i == a.length){
            if(sum == m) return 1;
            else return 0;
        }
        return go(a, m, i+1, sum+a[i])+go(a, m, i+1, sum);
    }

    /**
     * 비트 연산자를 활용한 부분집합의 합 구하기*/
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s= sc.nextInt();
        int[] a= new int[n];
        for(int i =0; i<n; i++)
            a[i] = sc.nextInt();

        int ans = 0;
        for(int i=1; i< (1<<n); i++){
            int sum =0;
            for(int k =0; k<n; k++){
                if((i&(1<<k)) != 0)
                    sum+=a[k];
            }
            if(sum ==s ) ans +=1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a= new int[n];
        for(int i =0; i<n; i++)
            a[i] = sc.nextInt();

        int ans = go(a, m, 0, 0);
        if(m ==0) ans -=1;
        System.out.println(ans);
    }
}
