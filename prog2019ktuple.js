function solution(s) {
    var answer = [];
    s=s.replace("{{",'');
    s=s.replace("}}",'');
    s=s.split("},{");
    console.log(s);
    s=s.map(a=> a.split(','));
    console.log(s);
    answer=s.sort((a,b)=>{
        return a.length-b.length;
    })
    .reduce((acc,item)=>{
        return acc.concat(item.filter( f=> !(acc.includes(f))));
    },[]);
    
    console.log(s);
    console.log(answer.map(Number));
    return answer.map(Number);
}
var s="{{4,2,3},{3},{2,3,4,1},{2,3}}";
solution(s);