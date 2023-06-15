<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div style="margin:100px;">
<h2>Add Student</h2>
<form action="addStudent" method="post">
  <div class="form-group">
    <label for="name">Student name</label>
    <input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="Enter name">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
   <label for="email">Student Email</label>
    <input type="email" class="form-control" name="email" placeholder="Enter email">
  </div>
  
  
  <div class="form-group">
   <label for="email">Student Phone Number</label>
    <input type="text" class="form-control" name="phone_no" placeholder="Enter Phone Number">
  </div>
  
  <div class="form-group">
   <label for="dob">Student Date Of Birth</label>
    <input type="date" class="form-control" name="dob" placeholder="Enter Date Of Birth">
  </div>
  <div class="form-group">
   <label for="education">Student education</label>
    <input type="text" class="form-control" name="education" placeholder="Enter Student's education">
  </div>
  
  <button type="submit" class="btn btn-primary">Add</button>
</form>
</div>
</body>
</html>