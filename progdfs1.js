function solution(numbers, target) {
    var answer = 0;
    var len=numbers.length;
    var result=0;
    function dfs(num,idx){
        if(idx==len) {
            if(num==target) answer++;
            return ;
        }
        dfs(num-numbers[idx],idx+1);
        dfs(num+numbers[idx],idx+1);
    }
    dfs(numbers[0],1);
    dfs(0-numbers[0],1);
    console.log(answer);
    return answer;
}
var n=[1, 1, 1, 1, 1];
var a=3;
solution(n,a)