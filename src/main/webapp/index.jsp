
<%--
  Created by IntelliJ IDEA.
  User: keon2
  Date: 4/4/2023
  Time: 2:35 pm
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Registration Page</title>
    <link rel="stylesheet" href="resources/assets/bootstrap/css/bootstrap.min.css">
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
                        <form method="post">
                            <div class="row justify-content-evenly">
                                <div class="col-md-12 col-lg-12 col-xl-5 col-xxl-5 offset-lg-0 offset-xxl-0" style="margin-right: 15px;">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong class="form-label">Full Name</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="text" name="firstName"><small class="form-text text-muted">First Name</small></div>
                                            <div class="col"><input class="form-control" type="text" name=""><small class="text-muted form-text" name="lastName">Last Name</small></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col-xxl-12" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><label class="col-form-label" style="font-weight: bold;">Area</label></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><select class="form-select" name="area">
                                                <optgroup label="This is a group">
                                                    <option value="12" selected="">Please Select </option>
                                                    <option value="13">This is item 2</option>
                                                    <option value="14">This is item 3</option>
                                                </optgroup>
                                            </select></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>Address</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="text" style="margin-bottom: 0px;" name="addressLine1"><small class="form-text">Street Address Line 1</small><input class="form-control" type="text" style="padding-top: 6px;margin-top: 15px;margin-bottom: 0px;" name="addressLine2"><small class="form-text">Street Address Line 2</small></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="text" style="margin-top: 15px;" name="city"><small class="form-text">City</small></div>
                                            <div class="col"><input class="form-control" type="text" style="margin-top: 15px;" name="state"><small class="form-text">State/Province</small></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="text" style="margin-top: 15px;" name="postalCode"><small class="form-text">Postal/Zip Code</small></div>
                                            <div class="col"><input class="form-control" type="search" style="margin-top: 15px;" name="country"><small class="form-text">Country</small></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;padding-bottom: 0px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>Email</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="email" style="margin-bottom: 0px;" name="email"><small class="form-text">example@example.com</small></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;margin-bottom: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>Phone Number</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col"><input class="form-control" type="tel" placeholder="(000) 000-0000" name="phone"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 col-lg-12 col-xl-6 col-xxl-6" style="margin-left: 0px;">
                                    <div>
                                        <div class="row">
                                            <div class="col-lg-11" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>First time to attend this conference ?</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-12">
                                                <div class="form-check" name="isFirstTime" value="1"><input class="form-check-input" type="radio" id="formCheck-1"><label class="form-check-label" for="formCheck-1">Yes</label></div>
                                                <div class="form-check" name="isFirstTime" value="0"><input class="form-check-input" type="radio" id="formCheck-2"><label class="form-check-label" for="formCheck-2">No</label></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>I will attend :</strong></div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-12">
                                                <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-3"><label class="form-check-label" for="formCheck-3">Event 1</label></div>
                                                <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-4"><label class="form-check-label" for="formCheck-4">Event 2</label></div>
                                                <div class="form-check"><input class="form-check-input" type="checkbox" id="formCheck-5"><label class="form-check-label" for="formCheck-5">Event 3</label></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col-lg-7" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>What's your T-Shirt size?</strong><select class="form-select">
                                                <optgroup label="This is a group">
                                                    <option value="12" selected="">This is item 1</option>
                                                    <option value="13">This is item 2</option>
                                                    <option value="14">This is item 3</option>
                                                </optgroup>
                                            </select></div>
                                        </div>
                                    </div>
                                    <div style="padding-top: 0px;margin-top: 30px;">
                                        <div class="row">
                                            <div class="col" style="padding-bottom: 0px;padding-top: 0px;padding-left: 16px;margin-bottom: 11px;"><strong>Registration Fee</strong></div>
                                        </div>
                                        <div class="row" style="margin-bottom: 22px;">
                                            <div class="col-lg-10 col-xl-9 col-xxl-9">
                                                <div class="row">
                                                    <div class="col-xl-11">
                                                        <div class="row">
                                                            <div class="col-xl-11 col-xxl-10">
                                                                <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-6"><label class="form-check-label" for="formCheck-6" style="font-weight: bold;">Conference Registration Fee ( Normal Participant )</label></div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-10 col-xl-7 col-xxl-6 my-auto"><span># of papers</span></div>
                                                            <div class="col-lg-2 col-xl-5 col-xxl-3"><select class="form-select">
                                                                <optgroup label="This is a group">
                                                                    <option value="12" selected="">1</option>
                                                                    <option value="2">This is item 2</option>
                                                                    <option value="14">3</option>
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
                                                                <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-7"><label class="form-check-label" for="formCheck-7" style="font-weight: bold;">Conference Registration Fee ( Student Participant )</label></div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-10 col-xl-7 col-xxl-6 my-auto"><span># of papers</span></div>
                                                            <div class="col-lg-2 col-xl-5 col-xxl-3"><select class="form-select">
                                                                <optgroup label="This is a group">
                                                                    <option value="12" selected="">1</option>
                                                                    <option value="2">This is item 2</option>
                                                                    <option value="14">3</option>
                                                                </optgroup>
                                                            </select></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-2 col-xl-3 col-xxl-2" style="text-align: justify;"><span style="text-align: right;margin-left: auto;">500.00 RM</span></div>
                                        </div>
                                    </div>
                                    <hr>
                                    <div>
                                        <div class="row" style="margin-bottom: 24px;">
                                            <div class="col-12 d-sm-flex d-md-flex d-lg-flex d-xl-flex justify-content-between align-items-xl-center"><button class="btn btn-primary d-flex" type="button">Check The Total Amount</button><span>Total&nbsp; 0.00 RM</span></div>
                                        </div>
                                        <div class="row">
                                            <div class="col d-lg-flex justify-content-between align-items-lg-center" style="display: inline-flex;"><button class="btn btn-primary" type="button">Search Tool</button><input class="btn btn-success" type="submit"><button class="btn btn-secondary" type="button">Reset</button></div>
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
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>