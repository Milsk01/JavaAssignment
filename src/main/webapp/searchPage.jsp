<%--
  Created by IntelliJ IDEA.
  User: keon2
  Date: 9/4/2023
  Time: 5:00 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>searchPage</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
</head>

<body>
<h1></h1>
<div class="container">
    <div class="row d-xl-flex justify-content-xl-center">
        <div class="col-xl-8" style="padding-top: 0px;">
            <h1 style="margin-top: 50px;margin-bottom: 21px;">Search Tool</h1>
            <div class="row">
                <div class="col">
                    <div class="form-check"><input name="viewOption" class="form-check-input" type="radio" id="formCheck-2"><label class="form-check-label" for="formCheck-2">View all participants</label></div>
                    <div class="form-check"><input name="viewOption" class="form-check-input" type="radio" id="formCheck-1"><label class="form-check-label" for="formCheck-1">View student participants</label></div>
                    <div class="form-check"><input name="viewOption" class="form-check-input" type="radio" id="formCheck-3"><label class="form-check-label" for="formCheck-3">View Normal participants</label></div><button class="btn btn-primary" type="button" style="margin-top: 23px;margin-bottom: 15px;">View</button>
                </div>
            </div>
            <div class="row d-flex flex-column">
                <div class="col-sm-6 col-xl-4 d-sm-flex d-xl-flex flex-column flex-grow-0 flex-shrink-0 align-items-sm-start"><label class="form-label">Insert Registered Participant Name</label><input type="text" style="margin-right: 0px;padding-right: 0px;"></div>
                <div class="col-sm-6 col-xl-4 d-sm-flex d-xl-flex justify-content-between" style="padding-top: 0px;margin-top: 30px;"><button class="btn btn-primary text-start" type="button">Search</button><button class="btn btn-danger" type="button">Delete</button></div>
                <div class="col-sm-6 col-xl-4 text-end" style="padding-top: 0px;margin-top: 36px;margin-bottom: -6px;"><button class="btn btn-primary" type="button" onclick="history.back()" >Back</button></div>
            </div>
        </div>
    </div>
</div>
<script src="resources/js/bootstrap.min.js"></script>
</body>

</html>
