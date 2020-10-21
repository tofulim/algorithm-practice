class Truck{
    contructor(weight,time){
      this.weight=weight;
      this.time=time;
    }
    getWeight(){
        return this.weight;
    }
}
  
function solution(bridge_length, weight, truck_weights) {
    var waiting=[];
    var bridge=[];
    for(var i in truck_weights){
        var tmpTruck=new Truck(truck_weights[i],0);
        waiting.push(tmpTruck);
    }
    console.log(waiting[0]);
    var time=0;
    var nw=0;
    while(waiting.length!=0 || bridge.length!=0){
        time++;
        if(bridge.length!=0){
            var t=bridge[0];
            if(time-t.time>=bridge_length){
                nw-=t.weight;
                bridge.shift();
            }
        }
        if(waiting.length!=0){
            var t=waiting[0];
            if(nw+t.weight<=weight){
                nw+=t.weight;
                bridge.push(new Truck(t.weight,time));
                waiting.shitft();
            }
        }
    }
        
    return time;
}
var a=2;
var b=10;
var c=[7,4,5,6];
solution(a,b,c);