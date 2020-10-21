var numbers = [3, 30, 34, 5, 9];
function solution(numbers) {
    var answer = '';
    answer=numbers.sort((a,b)=>{
        return (String(b)+String(a))-(String(a)+String(b));
    }).join('');
    if(answer[0]===0) return "0";
    return answer;
}
solution(numbers);
