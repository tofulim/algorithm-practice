function solution(brown, yellow) {
    var answer = [];
    if(Number.isInteger(Math.sqrt(yellow))){
        var ans=Math.sqrt(brown+yellow);
        return [ans,ans];
    }
    else{
        var height;
        for(var i=yellow;i>=1;i--){
            if(yellow%i==0 || i> yellow/i){
                height=yellow/i;
                if(brown==2*(height+i)+4) {
                    return [i+2,height+2] 
                }
            }
        }
    }
    return answer;
}

var y=9;
solution(24,24);