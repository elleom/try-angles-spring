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
/*
const onLoadHandler = () => {
    //document.getElementById('draw-btn').addEventListener('click', getUserInput)
    console.log('loaded')
}
*/



