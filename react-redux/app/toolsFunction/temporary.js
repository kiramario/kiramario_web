/**** 遍历对象 ES6写法，比for in 简单多了 ****/
// M1
let jane = { first: 'Jane', last: 'Doe' };
function* objectEntries(obj){
	let Keys = Reflect.ownKeys(obj);
	
	for(let key of Keys){	
		yield [key,obj[key]];
	}
}

for(let [key,value] of objectEntries(jane)){	//objectEntries(jane)要是一个生成器指针
	console.log(`${key}: ${value}`);
}


// M2
let jane = { first: 'Jane', last: 'Doe' };

jane[Symbol.iterator] = function* (){
	let keys = Object.keys(this);
	for (let key of keys){
		yield [key,this[key]]
	}
}

for(let [key,value] of jane){	//objectEntries(jane)要是一个生成器指针
	console.log(`${key}: ${value}`);
}


