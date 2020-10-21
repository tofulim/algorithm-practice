function solution(p) {
    var answer = '';
    cycle(p);
    return answer;
}
function cycle(s){
    if(s=="") return ""; //0
    else { //1번 u,v 쪼개기
        var st=[]; //stack 
        var v,u;
        let idx=0;
        s=s.split('').map((item)=> item=item=='('?1:-1);
        console.log(s);
        var cnt=Number(0);
        s.every( a=>{
            if(cnt+=Number(a)!=0) return a;
            else idx++; 
        });
        console.log(s+idx);
        u=s.join('').slice(0,idx);
        v=s.join('').slice(idx);
        console.log(u+":"+v);
    }
}
var p = "()))((()";
solution(p);