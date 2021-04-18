const drawAxis = () => {

    let canvas = document.querySelector("#canvasX");
    let contextAxisX = canvas.getContext('2d');
    contextAxisX.moveTo(0, 50);
    contextAxisX.lineTo(1000, 50);
    contextAxisX.stroke();
    contextAxisX.font = '24px Arial'

    contextAxisX.fillText("x", 980, 35);

    contextAxisX.font = '14px Arial'
    for (let x = 50; x < 1000; x += 50) {

        contextAxisX.moveTo(x, 42);
        contextAxisX.lineTo(x, 50);
        contextAxisX.stroke();
        contextAxisX.fillText(x.toString(), x+50, 40);
    }

    canvas = document.querySelector("#canvasY");
    let contextAxisY = canvas.getContext('2d');

    contextAxisY.moveTo(50, 0);
    contextAxisY.lineTo(50, 570);
    contextAxisY.stroke();
    contextAxisY.font = '14px Arial'
    contextAxisY.fillText("y", 1, 590);

    contextAxisX.font = '14px Arial'
    for (let y = 50; y <= 550; y += 50) {

        contextAxisY.moveTo(40, y);
        contextAxisY.lineTo(50, y);
        contextAxisY.stroke();
        contextAxisY.fillText(y.toString(), 25, y - 5);
    }
}

const getUserInput = () => {

    let userInput = [];
    let inputs = document.getElementsByTagName('input');

    for (let i = 0; i < inputs.length; i++){
        if (inputs[i].value == ""){
            alert('Complete all fields!')
            return;
        }
        userInput[i] = inputs[i].value;
    }

    let x = parseInt(userInput[0])
    let y = parseInt(userInput[1])
    let z = parseInt(userInput[2])

    checkTriangle(x, y, z)

}

const isTriangle = (x, y, z) => {

    if  (x +y <= z) {
        return false;
    }
    if( x+z <= y){
        return false;
    }
    if (y +z <= x) {
       return false;
    }
    return true;

}

const isEquilateral = (x,y,z) => {
    if((x === y) && (y === z)) {
        return true;
    }
    return false;
}

const isIsosceles = (x, y, z) => {
    let isIsosceles = ((x === y) || (y === z) || (x === z)) ? this.check = true : this.check = false;
    return isIsosceles;

}

const checkTriangle = (x, y, z) => {
    console.log('started check')
    let calcBtn = document.getElementById('calc-btn');
    let  restartBtn = document.getElementById('restart-btn');
    let resultText = document.getElementById('result');

    calcBtn.hidden = true;
    restartBtn.hidden = false;

    let image = document.getElementById('result-image');

    let xyBox = document.getElementById('xy');
    let xzBox = document.getElementById('xz');
    let yzBox = document.getElementById('yz');

    if (isTriangle(x, y, z)){
        image.src = '/images/OK.png';

    }
    else {
        image.src = '/images/NOT.png';
        let answer = 'It is not a triangle. \n'
        if ((x + y) <= z){
            xyBox.innerText = 'A: '+x + '+ B: ' + y + ' =< C: ' + z;
            xyBox.hidden = false;
        }
        if ((x + z) <= y){
            xzBox.innerText = 'A: '+x + '+ C: ' + z + ' =< B: ' + y;
            xzBox.hidden = false;
        }
        if ((z + y) <= x){
            yzBox.innerText = 'C: '+z + '+ B: ' + y + ' =< A: ' + x;
            yzBox.hidden = false;
        }
        resultText.innerText = answer
        return;

    };

    if (isEquilateral(x,y,z)) {
        resultText.innerText = 'It is an equilateral triangle'
        xyBox.innerText = 'A: '+x + ', B: ' + y + ' and C: ' + z + 'are equal length';
        return;
    }
    else if (isIsosceles(x,y,z)){
        resultText.innerText = 'It is an isosceles triangle, 2 sides are equal length';
    }
    else {
        resultText.innerText = 'It is an scalene triangle, all sides are different length.';
    }
    xyBox.innerText = 'A: '+x;
    xzBox.innerText = 'B: '+y;
    yzBox.innerText = 'C: '+z;
    xyBox.hidden = false;
    xzBox.hidden = false;
    yzBox.hidden = false;
}

const onClickReload = () => {
    let inputs = document.getElementsByTagName('input');
    for (let i = 0; i <inputs.length; i++){
        inputs[i].value = '0';
    }
    let image = document.getElementById('result-image');
    image.src = '/images/question.png'

    let calcBtn = document.getElementById('calc-btn');
    let  restartBtn = document.getElementById('restart-btn');
    calcBtn.hidden = false;
    restartBtn.hidden = true;
    let resultText = document.getElementById('result');
    resultText.innerText = 'What would it be?'

    let xyBox = document.getElementById('xy').hidden = true;
    let xzBox = document.getElementById('xz').hidden = true;
    let yzBox = document.getElementById('yz').hidden = true;

}

const onLoadHandler = () => {
    //sets a listener on the page
    document.getElementById('calc-btn').addEventListener('click', getUserInput);
    document.getElementById('restart-btn').addEventListener('click', onClickReload);
    console.log('loaded');

}






