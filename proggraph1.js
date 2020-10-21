function solution(n, edge) {
    var answer = 0;
    var list=new Array(n+1);
    for (var i=1;i<n+1;i++){
        list[i]=new Array;
    }
    for(var i=0;i<edge.length;i++){
        var first=edge[i][0];
        var second=edge[i][1];
        list[first].push(second);
        list[second].push(first);
    }
    
    var distance=new Array(n+1);
    distance[1]=0;
    var bfs_queue=[];
    var visit=new Array(n+1).fill(false);
    console.log(visit);
    bfs_queue.push(1); //초기값 1 넣기
    visit[1]=true;
    while(bfs_queue.length!=0){
        var outcome=bfs_queue.shift();
        for(var item of list[outcome]){
            if(visit[item]==false){
                bfs_queue.push(item);
                visit[item]=true;
                distance[item]=distance[outcome]+1;
            }
        }
    }
    answer=distance.sort((a,b)=> b-a).reduce((acc,cur,idx)=> { //distance 배열에서 acc를 answer로 이용해 찾는 과정
        if(cur==distance[0]) return acc+1;   
        else return acc;
    },0);   
    console.log(answer);
    return answer;
}

var dd=[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]];

solution(6,dd);