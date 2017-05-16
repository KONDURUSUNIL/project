<!DOCTYPE html>
<html>
<head>
<style>
.container {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
}

.container a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.container a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>
<img src="../images/banner.jpg" width="500" height="150">
<div class="container">
  
  <div class="dropdown">
    <button class="dropbtn">Location</button>
    <div class="dropdown-content">
      <a href="locReg">Register</a>
      <a href="viewAllLocs">All Records</a>
    </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Vendor</button>
    <div class="dropdown-content">
      <a href="venReg">Register</a>
      <a href="viewAllVen">All Records</a>
    </div>
  </div> 
  
   <div class="dropdown">
    <button class="dropbtn">Customer</button>
    <div class="dropdown-content">
      <a href="custReg">Register</a>
      <a href="viewAllCust">All Records</a>
    </div>
  </div> 
  
   <div class="dropdown">
    <button class="dropbtn">Documents</button>
    <div class="dropdown-content">
      <a href="fileReg">Register</a>
      <a href="fileReg">All Documents</a>
    </div>
  </div> 

	<div class="dropdown">
    <button class="dropbtn">Report</button>
    <div class="dropdown-content">
      <a href="locReport">Location</a>
      <a href="#">Vendor</a>
    </div>
 </div>   
</div>
</body></html>
