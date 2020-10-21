function solution(triangle) {
    var answer = 0;
    var dp=new Array(triangle.length);
    for(var i=0;i<triangle.length;i++ ){
        dp[i]=new Array(i+1);
    }
    dp[0]=+triangle[0];
    dp[1][0]=+triangle[0]+triangle[1][0];
    dp[1][1]=+triangle[0]+triangle[1][1];
    for(var i=2;i<dp.length;i++){
        for(var j=0;j<dp[i].length;j++){
            if(j==0) dp[i][j]=+dp[i-1][j]+triangle[i][j];
            else if(j==dp[i].length-1) dp[i][j]= +dp[i-1][j-1]+triangle[i][j];
            else {
                dp[i][j]=+triangle[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
    }
    answer=Math.max(...dp[triangle.length-1]);
    console.log(dp);
    console.log(answer);
    return answer;
}
var d=[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]];
solution(d);

