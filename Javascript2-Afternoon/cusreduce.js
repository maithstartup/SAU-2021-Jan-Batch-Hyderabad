let intArr = [5, 10, 15, 20, 25];
function cusreduce(arr, init, fn){
    let last=0;
    for(let i=0; i<arr.length; i++) {        
        last = fn(last,arr[i]);    
    }
    return last;
}    
let sum = cusreduce(intArr,0,(acc,cur)=> acc + cur);
console.log(sum)

