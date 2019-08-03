public class DecodeWays {
    public int numDecodings(String s) {
        int dp [] = new int[s.length()];
        if(s.charAt(0)!='0')
            dp[0]=1;
        for(int i=1;i<s.length();i++)
        {
            int ch = Integer.parseInt((s.charAt(i-1)+""+s.charAt(i)+""));
            if(s.charAt(i)!='0')
                dp[i]=dp[i-1];
            else
                dp[i]=0;
            if(i>1 && ch>=10 && ch<=26)
                dp[i]+=dp[i-2];
            else if(i==1 && ch>=10&&ch<=26)
                dp[i]+=dp[i-1];
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("1111"));
    }
}

