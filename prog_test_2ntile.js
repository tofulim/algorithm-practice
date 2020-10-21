function solution(n) {
    var dp=new Array(n+1);
    dp[1]=1; dp[2]=2;
    if(n==1||n==2) return dp[n];
    for(var i=3;i<=n;i++){
        dp[i]=(dp[i-1]+dp[i-2])%1000000007;
    }
    return dp[n];
}