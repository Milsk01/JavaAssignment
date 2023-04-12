
function checkTotalAmount(){
    let totalAmount = 0;
    let registrationFees = 0;

    const isStudent = $("input[type='radio'][name='isStudent']:checked")
    if (isStudent.length > 0) {

        // parse the value to a boolean datatype
        isStudentVal = parseInt(isStudent[0].value);

        registrationFees = isStudentVal ? 300 : 500;
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



    $("#registrationForm").submit(function(e) {

        e.preventDefault(); // avoid to execute the actual submit of the form.

        var form = $(this);
        var actionUrl = "/JavaAssignment-1.0-SNAPSHOT/hello-servlet"

        $.ajax({
            type: "POST",
            url: actionUrl,
            data: form.serialize(),
            success: function(data)
            {
                alert("Successfully added");

                // clear the form
                $("#registrationForm")[0].reset();
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert("Error");
            }
        });

    });

});