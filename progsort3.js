function solution(citations) {
    var answer = 0;
    citations.sort();
    console.log(citations);
    for (var i=citations.length-1;i>=0;i--){
        console.log(citations[i]);
        if(citations[i]>answer) answer++;
        else break;
    }
    if(citations[citations.length-1]==0) return 0;
    console.log(answer);
    return answer;
}
var c=[0,5,5,5,5,0];
solution(c);