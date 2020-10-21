function solution(genres, plays) {
    var answer = [];
    var song=[];
    for(var i in plays){
        var insist=song.findIndex(a=> a.genre==genres[i]);
        if(insist==-1){ //없는 경우
            song.push({"genre":genres[i], "sum":plays[i],"f":plays[i],"fidx":i,"s":-1,"sidx":-1});
        }
        else { //이미 존재하는 장르의 경우
            song[insist].sum+=plays[i];
            if(plays[i]>song[insist].f){
                song[insist].s=song[insist].f;
                song[insist].sidx=song[insist].fidx;
                song[insist].f=plays[i];
                song[insist].fidx=i;
            }
            else if(plays[i]<song[insist].f && plays[i]>song[insist].s){
                song[insist].s=plays[i];
                song[insist].sidx=i;
            }
            else if(plays[i]==song[insist].f && plays[i]>song[insist].s){
                song[insist].s=plays[i];
                song[insist].sidx=i;
            }         
        }
    }
    song.sort(function(a,b){
        return b.sum-a.sum;
    });
    answer=song.reduce((arr,a)=>{
        if(a.s!=-1) return [...arr,a.fidx,a.sidx];
        else return [...arr,a.fidx];
    },[]);
    console.log(answer.map(Number));
    return answer.map(Number);
}
var g=["classic", "pop", "classic", "classic", "pop"];
var p=[500, 600, 500, 500, 2500];
solution(g,p);