var answer;
var answer2;
var check;
var tnum=1;
function solution(tickets) {
    check= new Array(tickets.length).fill(true);
    answer=[];
    answer2=[];
    for( var i in tickets){
        if(tickets[i][0]!='ICN') continue;
        answer2.push(tickets[i][0]);
        answer2.push(tickets[i][1]);
        check[i]=false;
        tnum=0;
        dfs(tickets[i],tickets, check);
        check[i]=true;
    }
    console.log(answer);
    return answer;
}
function dfs(departure, tickets, check){
    tnum++;
    console.log(tnum);
    var num=check.length+1;
    console.log(answer2);
    if(!check.includes(true) && answer2.length==num || tnum==tickets.length) {
        if(answer.length==0) {
            answer=answer2;       
        }
        else {
            answer=answer.join('')>answer2.join('')?answer2:answer.join('')<answer2.join('')?answer:answer;
        }        
        return;
    }
    else if(answer2.length>check.length+1) return;
    if(!check.includes(true)) return;
    for(var i in tickets){
        if(tickets[i]==departure) continue;
        if(check[i] && departure[1]==tickets[i][0]){
            check[i]=false;
            answer2.push(tickets[i][1]);
            dfs(tickets[i],tickets,check);
            check[i]=true;
        }
    }
    answer2=[];
}

var c=[["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]];
solution(c);