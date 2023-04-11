
//TODO Create button handler

function checkTotalAmount(){
    let totalAmount = 0;
    let registrationFees = 0;

    const isStudent = $("input[type='radio'][name='isStudent']:checked")
    if (isStudent.length > 0) {
        registrationFees = parseInt(isStudent[0].value);
    }

    if(registrationFees == 500){

        const numberOfPapers = parseInt($("#numberOfPapersFromNormal").val());

        totalAmount = registrationFees * numberOfPapers

    }else if(registrationFees == 300){
        const numberOfPapers = parseInt($("#numberOfPapersFromStudent").val());
        totalAmount = registrationFees * numberOfPapers

    }

    return totalAmount;

}

//TODO Simple Validation
$( document ).ready(function() {
    $("#checkButton").click(function(){
        let totalAmount = checkTotalAmount();
        let text = "Total " + totalAmount.toFixed(2) + " RM";
        $("#totalAmount").text(text)
    })
});