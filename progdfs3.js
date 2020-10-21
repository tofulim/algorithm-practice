var check; 
var answer;
var t;
function solution(begin, target, words) {
    answer = words.length+1;
    t=target;
    check=new Array (words.length);
    check.fill(true);
    if(!words.includes(target)) return 0;
    dfs(begin,words,check,0);
    console.log(answer);
    return answer;
}
function dfs(nword,words,check,num){
    if(nword==t && num<answer) answer=num;
    for(var i in words){
        if(check[i]){
            var count=0;
            for(var j in nword){
                if(nword[j]==words[i][j]) count++;
            }
            if(count==nword.length-1){
                check[i]=false;
                dfs(words[i],words,check,num+1);
                check[i]=true;
            }
        }
    }
}
var b="hit";
var w="cog";
var t=["hot", "dot", "dog", "lot", "log"];
solution(b,w,t);