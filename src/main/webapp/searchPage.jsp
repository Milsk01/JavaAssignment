<%@ page import="java.util.List" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="com.example.javaassignment.entity.*" %>
<%@ page import="java.awt.geom.Area" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Search Page</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <style>
        /*table {*/
        /*    border-collapse: collapse;*/
        /*    border: 1px solid black;*/
        /*}*/

        /*th, td {*/
        /*    border: 1px solid black;*/
        /*    padding: 5px;*/
        /*}*/

        #header_row,
        .result_row {
            display: none;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="resources/js/main.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<section style="padding-top: 31px; "></section>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="container">
                        <div class="row d-xl-flex justify-content-xl-center">
                            <div class="col-xl-8" style="padding-top: 0px;">
                                <h1 style="margin-top: 50px;margin-bottom: 21px;">Search Tool</h1>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-check"><input name="viewOption" class="form-check-input"
                                                                       type="radio"
                                                                       id="formCheck-2" value="all"><label
                                                class="form-check-label"
                                                for="formCheck-2">View
                                            all participants</label></div>
                                        <div class="form-check"><input name="viewOption" class="form-check-input"
                                                                       type="radio"
                                                                       id="formCheck-1" value="student"><label
                                                class="form-check-label"
                                                for="formCheck-1">View
                                            student participants</label></div>
                                        <div class="form-check"><input name="viewOption" class="form-check-input"
                                                                       type="radio"
                                                                       id="formCheck-3" value="normal"><label
                                                class="form-check-label"
                                                for="formCheck-3">View
                                            Normal participants</label></div>
                                        <button class="btn btn-primary" type="button"
                                                style="margin-top: 23px;margin-bottom: 15px;"
                                                id="viewButton">View
                                        </button>
                                    </div>
                                </div>
                                <div class="row d-flex flex-column">
                                    <div class="col-sm-6 col-xl-4 d-sm-flex d-xl-flex flex-column flex-grow-0 flex-shrink-0 align-items-sm-start">
                                        <label class="form-label">Insert Registered Participant Name</label>
                                        <input type="text" id="searchName"
                                               style="margin-right: 0px;padding-right: 0px;">
                                    </div>
                                    <div class="col-sm-6 col-xl-4 d-sm-flex d-xl-flex justify-content-between"
                                         style="padding-top: 0px;margin-top: 30px;">
                                        <button class="btn btn-primary text-start" type="button" id="searchButton">
                                            Search
                                        </button>
                                        <button class="btn btn-danger delete-btn" type="button" id="deleteButton">
                                            Delete
                                        </button>
                                    </div>
                                    <div class="col-sm-6 col-xl-4 text-end"
                                         style="padding-top: 0px;margin-top: 36px;margin-bottom: -6px;">
                                        <button class="btn btn-primary" type="button" onclick="history.back()">Back
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h3 style="margin-bottom: 43px;" id="noRecord"></h3>
                    <div class="table-responsive col-lg-8" style="padding-bottom: 0px;margin-bottom: 43px;">
                        <table class="table">
                            <thead>
                            <tr id="header_row">
                                <th style="margin-right: -5px;">Full Name</th>
                                <th>Area</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Phone Number</th>
                                <th>is First Time</th>
                                <th>Events Attended</th>
                                <th>T-Shirt Size</th>
                                <th>is Student</th>
                                <th>Number of Papers</th>
                                <th>Registration Fees (RM)</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
                                EntityManager em = emf.createEntityManager();
                                String query = "SELECT a FROM Registrations a";
                                List<Registrations> registrationsList = em.createQuery(query, Registrations.class).getResultList();
                            %>
                            <% for (Registrations registration : registrationsList) {
                                Participants participant = registration.getParticipantsByParticipantId();
                                Addresses address = participant.getAddressesById();
                                Areas area = participant.getAreasById();
                                Countries country = address.getCountryById();
                                Collection<Events> events = registration.getEventsById();
                                Iterator<Events> iter = events.iterator();

                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                                String eventString = "";
                                String eventDate = "";
                                for (; iter.hasNext(); ) {
                                    Events event = iter.next();
                                    eventString = eventString + event.getEventName() + '(' + dateFormat.format(event.getEventDate()).toString() + "）";
                                }

                            %>
                            <tr class="result_row" data-is-student="<%= registration.getIsStudent() %>"
                                data-name="<%= participant.getFirstName() %> <%= participant.getLastName() %>"
                                data-id="<%= participant.getId() %>">
                                <td><%= participant.getFirstName() %> <%= participant.getLastName() %>
                                </td>
                                <td><%= area.getAreaName()%>
                                </td>
                                <td><%=address.getFirstLine()%>, <%=address.getSecondLine()%>
                                    , <%= address.getPostalCode() %> <%=address.getCity()%>, <%= address.getState() %>
                                    , <%= country.getCountryName() %>
                                </td>
                                <td><%= participant.getEmail() %>
                                </td>
                                <td><%= participant.getPhoneNumber() %>
                                </td>
                                <td><%= registration.getIsFirstTime() == 1 ? "Yes" : "No" %>
                                </td>

                                <td><%= eventString%> <%=eventDate %>
                                </td>
                                </td>
                                <td><%= registration.getTshirtSize() %>
                                </td>
                                <td><%= registration.getIsStudent() == 1 ? "Yes" : "No" %>
                                </td>
                                <td><%= registration.getNumberOfPaper() %>
                                </td>
                                <td><%= registration.getRegistrationFees() %>
                                </td>
                            </tr>
                            <% } %>

                            <%
                                em.close();
                                emf.close();
                            %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<section style="padding-bottom: 31px; "></section>
</body>

</html>
