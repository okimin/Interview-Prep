package DSA.Happy-Number;

public class happy_number {
    public boolean isHappy(int n) {
        
        //Set<Integer> sumSet = new HashSet<>();
        int slowSum = summationSqu(n);
        int fastSum = summationSqu(summationSqu(n));

        if(n == 1 || slowSum == 1 || fastSum == 1){
            return true;
        }


        while(slowSum != fastSum){
            //sumSet.add(sum);
            slowSum = summationSqu(slowSum);
            fastSum = summationSqu(summationSqu(fastSum));
            if(slowSum == 1 || fastSum == 1)
                return true;
        }

        return false;
    
    }

    public int summationSqu(int n){
        int sum = 0;
        while(n >= 1){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
