function checkTotalAmount() {
    let totalAmount = 0;
    let registrationFees = 0;

    const isStudent = $("input[type='radio'][name='isStudent']:checked")
    if (isStudent.length > 0) {

        // parse the value to a boolean datatype
        isStudentVal = parseInt(isStudent[0].value);

        registrationFees = isStudentVal ? 300 : 500;
    }

    if (registrationFees == 500) {

        const numberOfPapers = parseInt($("#numberOfPapersFromNormal").val());

        totalAmount = registrationFees * numberOfPapers

    } else if (registrationFees == 300) {
        const numberOfPapers = parseInt($("#numberOfPapersFromStudent").val());
        totalAmount = registrationFees * numberOfPapers

    }

    return totalAmount;

}

//TODO Simple Validation
$(document).ready(function () {
    $("#checkButton").click(function () {
        let totalAmount = checkTotalAmount();
        let text = "Total " + totalAmount.toFixed(2) + " RM";
        $("#totalAmount").text(text)
    })

    $("#registrationForm").submit(function (e) {

        e.preventDefault(); // avoid to execute the actual submit of the form.

        var form = $(this);
        var actionUrl = "/JavaAssignment-1.0-SNAPSHOT/hello-servlet"

        $.ajax({
            type: "POST",
            url: actionUrl,
            data: form.serialize(),
            success: function (data) {
                alert("Successfully added");

                // clear the form
                $("#registrationForm")[0].reset();
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert("Error");
            }
        });

    });

    $("#viewButton").click(function () {
        const viewOption = $("input[type='radio'][name='viewOption']:checked");
        if (viewOption.length > 0) {
            const viewOptionVal = viewOption.val();

            if (viewOptionVal === "all") {
                $(".result_row").each(function () {
                    if ($(this).data("is-student") == 1 || $(this).data("is-student") == 0) {
                        $(this).show();
                    } else {
                        $(this).hide();
                    }
                });
            } else if (viewOptionVal === "student") {
                $(".result_row").each(function () {
                    if ($(this).data("is-student") == 1) {
                        $(this).show();
                    } else {
                        $(this).hide();
                    }
                });
            } else if (viewOptionVal === "normal") {
                $(".result_row").each(function () {
                    if ($(this).data("is-student") == 0) {
                        $(this).show();
                    } else {
                        $(this).hide();
                    }
                });
            }
            if ($(".result_row:visible").length === 0) {
                $("#noRecord").text("No Records Found");
                $("#header_row").hide();
            } else {
                $("#noRecord").text("");
                $("#header_row").show();
            }
        }
    });
    let searchResultCount = 0;
    let foundParticipantId;
    $("#searchButton").click(function () {
        const searchName = $("#searchName").val();
        if (!searchName) {
            alert("Please enter a search term.");
            return;
        }
        foundParticipantId = null;
        searchResultCount = 0;
        if (searchName.length > 0) {
            $(".result_row").each(function () {
                const name = $(this).data("name");
                if (name && name.toLowerCase().includes(searchName.toLowerCase())) {
                    $(this).show();
                    foundParticipantId = $(this).data("id");
                    searchResultCount++;
                } else {
                    $(this).hide();
                }
            });
            if (searchResultCount === 0) {
                $("#noRecord").text("No Records Found");
                $("#header_row").hide();
            } else {
                $("#noRecord").text("");
                $("#header_row").show();
            }
        }
    });

    $(document).on("click", ".delete-btn", function (e) {
        e.preventDefault();
        if (searchResultCount === 0) {
            alert("Please search for a participant before deleting.");
            return;
        } else if (searchResultCount > 1) {
            alert("Multiple participants found. Please refine your search before deleting.");
            return;
        }
        let id = foundParticipantId;
        $.ajax({
            url: "/JavaAssignment-1.0-SNAPSHOT/delete-servlet",
            type: "POST",
            data: {id: id},
            success: function () {
                alert("Participant deleted successfully");
                location.reload();
            },
            error: function () {
                alert("Error deleting participant");
            },
        });
    });
});