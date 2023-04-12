package com.example.javaassignment;

import com.example.javaassignment.entity.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import com.example.javaassignment.repository.RegistrationRepository;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class RegistrationServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // return a status code to ajax
        response.setContentType("text/html");

        // Participant fields
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String area = request.getParameter("area");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Address fields
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");

        // Registration fields
        String isFirstTime = request.getParameter("isFirstTime");
        String tShirtSize = request.getParameter("tShirtSize");
        String[] events = request.getParameterValues("events");
        String isStudent = request.getParameter("isStudent");


        // Create a new address using setters
        Addresses address = new Addresses();
        address.setFirstLine(addressLine1);
        address.setSecondLine(addressLine2);
        address.setCity(city);
        address.setState(state);
        address.setCountryId(Integer.parseInt(country));
        address.setPostalCode(postalCode);

        // Create a new participant using setters
        Participants participant = new Participants();
        participant.setFirstName(firstName);
        participant.setLastName(lastName);
        participant.setEmail(email);
        participant.setPhoneNumber(phone);
        participant.setAreaId(Integer.parseInt(area));
        participant.setAddressesByAddressId(address);

        // Registration
        Registrations registration = new Registrations();
        registration.setIsFirstTime(Byte.parseByte(isFirstTime));
        registration.setTshirtSize(tShirtSize);
        registration.setIsStudent(Byte.parseByte(isStudent));
        registration.setNumberOfPaper(getNumberOfPapers(request,Boolean.parseBoolean(isStudent)));
        registration.setRegistrationFees(calculateRegistrationFees(registration.getNumberOfPaper(),Boolean.parseBoolean(isStudent)));
        registration.setEventsById(createEvents(events));
        registration.setParticipantsByParticipantId(participant);

        // use repository to persist registration
        RegistrationRepository registrationRepository = new RegistrationRepository();
        registrationRepository.save(registration);

/*        DEBUGGING
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Area: " + area + "</p>");
        out.println("<p>Address Line 1: " + addressLine1 + "</p>");
        out.println("<p>Address Line 2: " + addressLine2 + "</p>");
        out.println("<p>City: " + city + "</p>");
        out.println("<p>State: " + state + "</p>");
        out.println("<p>Country: " + country + "</p>");
        out.println("<p>Postal Code: " + postalCode + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        out.println("<p>First Time: " + isFirstTime + "</p>");
        out.println("<p>T-Shirt Size: " + tShirtSize + "</p>");
        out.println("<p>First Time: " + registration.getIsFirstTime() + "</p>");
        out.println("<p>Student Status: " + isStudent + "</p>");
        out.println("<p>Number of Papers: " + registration.getNumberOfPaper() + "</p>");
        out.println("<p>Registration Fees: " + registration.getRegistrationFees() + "</p>");
        out.println("<p>Events: " + events + "</p>");
        out.println("</body></html>");*/

        response.setStatus(HttpServletResponse.SC_OK);


    }

    private String getNumberOfPapers(HttpServletRequest request, boolean isStudent) {
        String parameterName = isStudent ? "numberOfPapersFromStudent" : "numberOfPapersFromNormal";
        return request.getParameter(parameterName);
    }

    private String calculateRegistrationFees(String numberOfPapers, boolean isStudent) {
        int numberOfPapersInt = Integer.parseInt(numberOfPapers);
        int pricePerPaper = isStudent ? 300 : 500;
        return String.valueOf(numberOfPapersInt * pricePerPaper);

    }

    private Collection createEvents(String[] events){
        Collection<Events> eventCollection = new ArrayList<Events>();

        for(int i =0; i<events.length; i++){
            Events event = new Events();
            // set the event id
            event.setId(Integer.parseInt(events[i]));
            eventCollection.add(event);

        }
        return eventCollection;
    }



    public void destroy() {
    }
}