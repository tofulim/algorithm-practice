function solution(answers) {
    var answer2 = [];
    var rank=[0,0,0];
    var p1=[1,2,3,4,5]
    var p2=[2,1,2,3,2,4,2,5];
    var p3=[3,3,1,1,2,2,4,4,5,5];
    for(var i in answers){
        if(answers[i]==p1[i%5]) rank[0]++;
        if(answers[i]==p2[i%8]) rank[1]++;
        if(answers[i]==p3[i%10]) rank[2]++;
    }
    // var tmp = JSON.parse(JSON.stringify(rank));
    // rank.sort();
    let max = rank.reduce((a, b) => {
        return Math.max(a, b);
    });
    for(var i=0;i<3;i++){
        console.log(tmp[i]+":"+rank[2]);
        // if(tmp[i]==rank[2]) answer2.push(Number(i+1));
        if(rank[i]==max) answer2.push(Number(i+1));
    }
    console.log(answer2);
    return answer2;
}

var k=[5];
solution(k);