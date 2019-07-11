window.onload = function(){
    document.getElementById("executeFunctions").addEventListener("click",function(){
        num = document.getElementById("num").value;
        f = document.getElementById("f").value;
        n = document.getElementById("n").value;
        array = document.getElementById("array").value;
        reps = document.getElementById("reps").value;
        bracketString = document.getElementById("bracketString").value;
        fibonacci(num);
        sort(f);
        factorial(n);
        rotateLeft(array,reps);
        balancedBrackets(bracketString);
    });

    function fibonacci(num){
        if(n===0){
            return 1;
        }
        else if(n===1){
            return 1;
        }
        else{
            return fibonacci(num-1) + fibonacci(num-2);
        }
    }  
    function sort(f){
        for(let i = 0; i < f.length; i++){
            for(let j =0; j < f.length -i; j++){
                    if(f[i]< f[j]){
                    let temp = f[i];
                    f[i] = f[j];
                    f[j] = temp;
                }
            }
        }  
    }
    function factorial(n){
        if(n===1){
            return 1;
        }
        else{
            return n * factorial(n);
        }
    } 
    function rotateLeft(array,reps){
        for(let i = 0; i < reps; i++){
            for(let j = 0;j < array.length; j++){
                let temp = array[0];
                if(j === 0){
                    continue;
                }
                else if(j===array.length){
                    array[array.length] = temp;
                }
                else{
                    array[j-1] = array[j];
                
                }
            }
        } 
    }
    function balancedBrackets(bracketString){
        let opp;

		if (bracketString.length() == 0 || bracketString.length() == 1) {
			return false;
		}

		if (bracketString.charAt(0) == '[') {
			opp = ']';
        } 
        else if (bracketString.charAt(0) == '{') {
			opp = '{';
        } 
        else if (bracketString.charAt(0) == '(') {
			opp = ')';
		}
		let a = opp === string.charAt(string.length() - 1);
		return a || oppRecursion(string.substring(1, string.length() - 1));
    }
}
