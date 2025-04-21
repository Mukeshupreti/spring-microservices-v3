
#JAVASCRIPT online UI apps

1 . code Pen ==>  https://codepen.io/
2 . jsbin ==>  https://jsbin.com/giluzir/edit?js,console
3 . plunker ==> https://plnkr.co/edit/?preview

## ES6 and javascript

## variable declaration

var is scope is global

var score=100;

let scope is local only

let score =100

const scope variable value you can't change but if const are refering to array than you can change value inside array
but can't change its reference.

const CARS=['BMW']
console.log(CARS);
CARS.push('NANO');
console.log(CARS);
CARS=['Test']  //error
console.log(CARS);

## Function Declaration

function firstVersion(){
console.log("Hello");
}

firstVersion();


var secondVersion= ()=> {
console.log("testme");
}

secondVersion();

var thirdVersion= (score,addvalue)=>{
return score+addvalue;
}


console.log(thirdVersion(100,89));

###Fourth version work for single liner return.
var fourthVersion= (score,addvalue)=>
score+addvalue;


console.log(fourthVersion(110,89));


## this keyword

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <button id="hello"> test </button>
</body>
</html>

function crazy(){

console.log(this);
}



crazy();

var button=document.getElementById("hello");
button.addEventListener('click',crazy);  // print window this.


## Function default value

var getData = (temp,cold=7) => {

console.log( " temp : " + temp);
console.log(" cold : " + cold);

if (temp<cold) {
console.log("its cold here");
}else {
console.log("its not cold");
}

}


console.log (getData(12,10));

//first paramenter 12 and second will be
//default

console.log (getData(12));


## Something about Object

#1

let obj = {

score : 60

}

//print whole object
console.log(obj);

#2 

let score=100

let obj = {

score

}


//Dont define score inside object take bigger scope score value
console.log(obj.score);

#3

let obj = {

score :60 ,
highscore () {
console.log('your score is :' + this.score);
}

}


// call define function in object
console.log(obj.highscore());

# 4  
###define variable name outside and using its value from object using []
let wrath="angry";

let obj = {

score :60 ,
angry : 200,
highscore () {
console.log('your score is :' + this.score);
}

}


// define variable name outside and using its value from object using []
console.log(obj[wrath]);


# FOR  'of' loop



let cars = ['BMW', 'NANO','CITY','MARUTI'];

// print each element of array
for(let car of cars){

console.log(car);
console.log(car.toLowerCase());
}

let word = "HELLO";

// print each character using 'of'
for (let t of word) {

console.log(t);
}

# SUPER dots (...) in ES6

function deposit (...money){
// three dots convert into array
console.log(money);
let balance=0;
for (let i=0; i<money.length; i++){
balance += money[i];
}
return balance;
}

console.log(deposit(10,20,30));

let addMoney =[24,66,24];

// loop to each value
console.log(...addMoney);

// so this will loop and return min value
console.log(Math.min(...addMoney));


## importing variable in other file 

Example Link : https://plnkr.co/edit/6Im4z8x1TX7ithjG?preview   ==>(demo project)

Step 1 :
include below script from CDN in head sricpt

<script src="https://google.github.io/traceur-compiler/bin/traceur.js"></script>
    <script src="https://google.github.io/traceur-compiler/bin/BrowserSystem.js"></script>
    <script src="https://google.github.io/traceur-compiler/src/bootstrap.js"></script>
    <script src="https://jspm.io/system.js"></script>

include below line in index.html

 <script>
    System.import('./lib/script.js')
     </script>


myscipt.js 
-----------

export let score = 1000;  // export is used to export variable to other file.  //1
export function cardFee() {   //2

console.log("card fee was charged");



## Notes :  instead of line //1 and //2 you can use  " export {score,cardFee}; " to export

script.js
----------

import {score} from './myscript.js';
console.log(score);
cardFee();


## importing concept

#1
import name ,{score,cardFee} from './myscript.js';   
=====// name is default scope (i.e  export default name) only one
variable in default scope is allowed.



#2
import * as Superman from './myscript.js';  /
// here bulk import  and superman is alias

now you can refer  

console.log(Superman.score);
{Superman.cardFee()};
{Superman}  ===> will print all the exported variable in that alias here superman


# default scope 

import name from './myscript.js';

access default scope.
console.log(name);


## working with Maps


let piku = {
name : "I am piku",
power : "piku power"

};

let chiku = {
name : "I am chiku",
power : "chiku power"

};

let tiku = {
name : "I am tiku",
power : "tiku power"

};


let map = new Map();  //define map 
map.set("piku", piku);  ///set key value
map.set("chiku", chiku);
map.set("tiku", tiku);

console.log(map.size); // return 3
console.log(map);  // return map of object

console.log(map.get('pinku')); // return first value
console.log(map.values()); : return all the values()

for ( val of map.values()) {
console.log(val);  // print all the values
}

for ( val of map.keys()) {
console.log(val);  // print all the keys.
}


#working with set


















