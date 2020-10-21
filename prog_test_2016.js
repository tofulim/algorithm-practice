function solution(a, b) {
    var answer = '';
    var month=[31,29,31,30,31,30,31,31,30,31,30,31];
    var day=["THU","FRI","SAT","SUN","MON","TUE","WED"];
    var num=b;
    for(var i=0;i<a-1;i++){
        num+=month[i];
    }
    console.log(day[num%7]);
    return answer;
}
var a=5;
var b=24;
solution(a,b);