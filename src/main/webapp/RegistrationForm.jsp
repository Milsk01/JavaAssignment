
<%--
  Created by IntelliJ IDEA.
  User: keon2
  Date: 4/4/2023
  Time: 2:35 pm
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Conference Online Registration</title>
    
    <link rel="stylesheet" href="resources/css/main.css"/>

</head>
<body>
    <h1>Conference Online Registration</h1>
    <label>Full Name</label>
    <input type="text" name="firstName"/>
    <input type="text" name="lastName"/>
    <label>Area</label>
    <select name="area">
        <option value="">Select state</option>
        <option value="01">Johor</option>
        <option value="02">Kedah</option>
        <option value="03">Kelantan</option>
        <option value="14">Kuala Lumpur</option>
        <option value="15">Labuan</option>
        <option value="04">Melaka</option>
        <option value="05">Negeri Sembilan</option>
        <option value="06">Pahang</option>
        <option value="07">Penang</option>
        <option value="08">Perak</option>
        <option value="09">Perlis</option>
        <option value="16">Putrajaya</option>
        <option value="12">Sabah</option>
        <option value="13">Sarawak</option>
        <option value="10">Selangor</option>
        <option value="11">Terengganu</option>
    </select>
    <label>Address</label>
    <input type="text" name="addressFirstLine"/>
    <input type="text" name="addressSecondLine"/>
    <input type="text" name="city"/>
    <input type="text" name="state"/>
</body>
</html>
