function solution(n, lost, reserve) {
    var answer = 0;
    var answer = n-lost.length;
    lost.sort();
    reserve.sort();
    for(var i=0;i<lost.length;i++) {
        for(var j=0;j<reserve.length;j++) {
            if(lost[i]==reserve[j]) {
                answer++;
                reserve.splice(j,1);
                lost.splice(i,1);
                console.log(lost.length+": "+reserve.length);
                i=i-1;
                break;
            }
        }
    }
    console.log(lost.length+": "+reserve.length);
    console.log(lost);
    console.log(reserve);
    var l=0;
    var r=0;
    while(r<reserve.length && l<lost.length) {
        if(Math.abs(lost[l]-reserve[r])==1) {
            r++;
            l++;
            answer++;
        }
        else if(lost[l]>reserve[r]) {
            r++;
        }
        else if(reserve[r]>lost[l]) {
            l++;
        }
    }
    console.log(answer);
    return answer;
}
var a=[2,3,5];
var b=[1];
solution(5,a,b);