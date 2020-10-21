function solution(numbers) {
    var answer=0;
    var n =numbers.split('').sort().reverse().join('');
    var numbers_arr =numbers.split('');
    const arr = [];

    for (let i = 0; i < n + 1; i += 1) {
        arr.push(true);
    }
    for (let i = 2; i * i <= n; i += 1) {
        if (arr[i]) {
            for (let j = i * i; j <= n; j += i) {
                arr[j] = false;
            }
        }
    }
    
    arr.splice(0, 2, false, false);
    for(var k=0;k<=n;k++){
        if(arr[k])
        {
            var newn=n.split('');
            var sosu_arr=String(k).split('');
            var flag;
            for(var i in sosu_arr){
                flag=true;
                for(var j in newn){
                    if(sosu_arr[i]==newn[j]){
                        newn[j]=-1;
                        flag=false;
                        break;
                    }
                }
                if(flag) break;
            }
            if(!flag) {
                answer++;
            }
        }
    }

    return answer;
}

var n="17";
solution(n);