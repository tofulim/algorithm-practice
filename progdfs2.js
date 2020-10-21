function solution(n, computers) {
    var answer = 0;
    var check=new Array(n);
    check.fill(true);
    function dfs(idx){
        if(!check[idx]) return;
        check[idx]=false;
        for(var i=0;i<n;i++){
            if(i==idx) continue;
            else{
                if(computers[idx][i]&&check[i]) {
                    dfs(i);
                }
            }
        }
    }
    for(var i=0;i<n;i++){
        if(check[i]) {
            answer++;
            dfs(i);
        }
    }
    return answer;
}
var n=3;
var c=	[[1, 1, 0], [1, 1, 0], [0, 0, 1]];
solution(n,c);