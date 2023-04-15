
<%--
  Created by IntelliJ IDEA.
  User: keon2
  Date: 4/4/2023
  Time: 2:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "com.example.javaassignment.entity.Events" %>
<%@ page import = "com.example.javaassignment.repository.EventRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.javaassignment.repository.CountryRepository" %>
<%@ page import="com.example.javaassignment.repository.AreaRepository" %>

<%
    List events = EventRepository.getValidEvents();
    List countries = CountryRepository.getCountries();
    List areas = AreaRepository.getAreas();

    request.setAttribute("eventList", events );
    request.setAttribute("countries", countries);
    request.setAttribute("areas", areas);



%>

<!DOCTYPE html>


<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Registration Page</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="resources/js/main.js"></script>

</head>

<body>
<section class="py-4 py-xl-5">
    <div class="container">
        <div class="row g-0 d-flex justify-content-evenly">
            <div class="col-md-10 col-lg-10 col-xl-8 col-xxl-10">
                <div class="card mb-5">
                    <div class="card-body p-sm-5">
                        <div>
                            <h2 class="text-center mb-4">Conference Registration Form</h2>
                            <p class="text-center mb-4">Please fill the form below. We'll contact you as soon as possible.</p>
                        </div>
                        <form method="post" id="registrationForm">
                            <div class="row justify-content-evenly">
                                <div class="col-md-12 col-lg-12 col-xl-5 col-xxl-5 offset-lg-0 offset-xxl-0" style="margin-right: 15px;">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="form-label required">Full Name</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="text" name="firstName" id="validationDefault01" required/><small class="form-text text-muted">First Name</small></div>
                                            <div class="col"><input required class="form-control " type="text" name="lastName" required /><small class="text-muted form-text" >Last Name</small></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col-xxl-12" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><label class="col-form-label required" style="font-weight: bold;">Area</label></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><select required class="form-select" name="area">
                                                <optgroup label="Please select an area">
                                                    <c:forEach var = "area" items="${areas}">
                                                        <option value= <c:out value="${area.getId()}"/>><c:out value="${area.getAreaName()}"/></option>
                                                    </c:forEach>

                                                </optgroup>
                                            </select></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required">Address</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <input required class="form-control" type="text" style="margin-bottom: 0px;" name="addressLine1"><small class="form-text">Street Address Line 1</small>
                                                <input required class="form-control" type="text" style="padding-top: 6px;margin-top: 15px;margin-bottom: 0px;" name="addressLine2"><small class="form-text">Street Address Line 2</small></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input required class="form-control" type="text" style="margin-top: 15px;" name="city"><small class="form-text">City</small></div>
                                            <div class="col"><input required class="form-control" type="text" style="margin-top: 15px;" name="state"><small class="form-text">State/Province</small></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input required class="form-control" type="text" style="margin-top: 15px;" name="postalCode"><small class="form-text">Postal/Zip Code</small></div>
                                            <div class="col">
                                                <select class="form-select" name="country" style="margin-top: 15px;">
                                                    <optgroup label="Please Select a country">
                                                        <c:forEach var = "country" items="${countries}">
                                                            <option value= <c:out value="${country.getId()}"/>><c:out value="${country.getCountryName()}"/></option>
                                                        </c:forEach>
                                                    </optgroup>
                                                </select>
                                                <small class="form-text">Country</small>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;padding-bottom: 0px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required">Email</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input required class="form-control" type="email" style="margin-bottom: 0px;" name="email"><small class="form-text">example@example.com</small></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;margin-bottom: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required">Phone Number</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input required class="form-control" type="tel" placeholder="(000) 000-0000" name="phone"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 col-lg-12 col-xl-6 col-xxl-6" style="margin-left: 0px;">
                                    <div>
                                        <div class="row">
                                            <div class="col-lg-11" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required">First time to attend this conference ?</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-12">
                                                <div class="form-check"><input required class="form-check-input"  name="isFirstTime" type="radio" id="formCheck-1" value="1"><label class="form-check-label" for="formCheck-1">Yes</label></div>
                                                <div class="form-check"><input required class="form-check-input" name="isFirstTime" type="radio" id="formCheck-2" value="0"><label class="form-check-label" for="formCheck-2">No</label></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required" >I will attend :</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-12">

                                                <c:forEach var = "event" items="${eventList}">
                                                    <div class="form-check">
                                                        <input class="form-check-input" name="events" type="checkbox"
                                                               id=<c:out value="${event.getId()}"/>
                                                                value=<c:out value="${event.getId()}"/>
                                                        />
                                                        <label class="form-check-label"
                                                               for=<c:out value="${event.getId()}"/>
                                                        >
                                                            <c:out value = "${event.getEventName()} - ${event.getEventDate()} "/></label></div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col-lg-7" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required">What's your T-Shirt size?</strong><select class="form-select" name="tShirtSize">
                                                <optgroup label="T-Shirt Size">
                                                    <option value="XS" selected="">XS</option>
                                                    <option value="S">S</option>
                                                    <option value="M">M</option>
                                                    <option value="L">l</option>
                                                    <option value="XL">Xl</option>
                                                </optgroup>
                                            </select></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="required">Registration Fee</strong></div>
                                        </div>
                                        <div class="row" style="margin-bottom: 22px;">
                                            <div class="col-lg-10 col-xl-9 col-xxl-9">
                                                <div class="row">
                                                    <div class="col-xl-11">
                                                        <div class="row">
                                                            <div class="col-xl-11 col-xxl-10">
                                                                <div class="form-check"><input required class="form-check-input" name="isStudent" type="radio" id="formCheck-6" value ="0"><label class="form-check-label" for="formCheck-6" style="font-weight: bold;">Conference Registration Fee ( Normal Participant )</label></div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-10 col-xl-7 col-xxl-6 my-auto"><span># of papers</span></div>
                                                            <div class="col-lg-2 col-xl-5 col-xxl-3"><select class="form-select" id="numberOfPapersFromNormal" name="numberOfPapersFromNormal">
                                                                <optgroup label="Number of papers" >
                                                                    <option value="1" selected="">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                </optgroup>
                                                            </select></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-2 col-xl-3 col-xxl-2" style="text-align: justify;"><span style="text-align: right;margin-left: auto;">500.00 RM</span></div>
                                        </div>
                                        <div class="row" style="margin-bottom: 22px;">
                                            <div class="col-lg-10 col-xl-9 col-xxl-9">
                                                <div class="row">
                                                    <div class="col-xl-11">
                                                        <div class="row">
                                                            <div class="col-xl-11 col-xxl-10">
                                                                <div class="form-check"><input class="form-check-input" name="isStudent" type="radio" id="formCheck-7" value ="1"><label class="form-check-label"  for="formCheck-7" style="font-weight: bold;">Conference Registration Fee ( Student Participant )</label></div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-10 col-xl-7 col-xxl-6 my-auto"><span># of papers</span></div>
                                                            <div class="col-lg-2 col-xl-5 col-xxl-3"><select class="form-select" id="numberOfPapersFromStudent" name="numberOfPapersFromStudent">
                                                                <optgroup label="Number of papers" >
                                                                    <option value="1" selected="">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                </optgroup>
                                                            </select></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-2 col-xl-3 col-xxl-2" style="text-align: justify;"><span style="text-align: right;margin-left: auto;">300.00 RM</span></div>
                                        </div>
                                    </div>
                                    <hr>
                                    <div>
                                        <div class="row" style="margin-bottom: 24px;">
                                            <div class="col-12 d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-between align-items-xl-center"><button class="btn btn-primary d-flex" type="button" id="checkButton">Check The Total Amount</button><span id="totalAmount">Total&nbsp; 0.00 RM</span></div>
                                        </div>
                                        <div class="row">
                                            <div class="col d-lg-flex justify-content-between align-items-lg-center" style="display: inline-flex;">
                                                <a href="searchPage.jsp"><button class="btn btn-primary" type="button" >Search Tool</button></a>
                                                <input class="btn btn-success" type="submit">
                                                <input class="btn btn-secondary" type="reset">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

</html>