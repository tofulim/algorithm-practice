
function solution(triangle) {    
    return Math.max(...triangle.reduce((cost, line) => {        
        console.log(cost);
        return line.map((v, index) => {        
            return v + Math.max((index < cost.length ? cost[index] : 0), (index > 0 ? cost[index-1] : 0));
        });
    }, []));    
}

var t=[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]];
solution(t);
