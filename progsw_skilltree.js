function solution(skill, skill_trees) {
    var answer = 0;
    if(skill.length==1) return skill_trees.length;
    else {
        return skill_trees.reduce((acc,item)=>{
            var idx=item.indexOf(skill[0]);
            var check=idx>-1?0:1; //시작부터 업으면 쭉업어야하니까 미리 1체크
            for(var i=1; i<skill.length; i++){
                var next_idx=item.indexOf(skill[i]);
                if(next_idx==-1) check=1;
                else if(idx<next_idx && check!=1) { //다음 순서대로 찍었을 때
                    check=2;
                }
                else { //작을 때,답이 아니라는 flag 띄우기
                    check=0;
                    break;
                }
                idx=next_idx;
            }
            console.log(acc);
            return acc+=check>0?1:0;
        },0);
    }
}

var s = "CBD";
var s2=["BACDE", "CBADF", "AECB", "BDA"];
solution(s,s2);



function solution(skill, skill_trees) {
    const skills = skill.split(''); //skill을 배열로 만들고
    return 
    skill_trees.filter(tree =>  //트리원소 하나 꺼내서 확인 
        skill.indexOf(tree.split('').filter(s => // skill의 원소를 가지고있는지 확인, 
            skills.includes(s)).join('')) === 0)
            .length;
}