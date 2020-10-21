function solution(numbers) {
    var answer = [];
    var twosum=0;
    return answer =
    numbers.reduce((acc,item,idx)=>{
        for(var i=idx+1;i<numbers.length;i++){
            twosum=item+numbers[i];
            if(!acc.includes(twosum)) acc.push(twosum); 
        }
        return acc;
    },[]).sort((a,b)=> a-b);

    // answer =
    // numbers.reduce((acc,item,idx)=>{
    //     for(var i=idx+1;i<numbers.length;i++){
    //         twosum=item+numbers[i];
    //         if(!acc.includes(twosum)) acc.push(twosum); 
    //     }
    //     return acc;
    // },[]).sort((a,b)=> a-b);
    // console.log(answer);
    // return answer;
}
var number=[5,0,2,7];
solution(number);