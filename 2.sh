
<!DOCTYPE html>
<html>
<head>
<title>Our Polytechnic</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<form>
<h2><p><center>Our Polytechnic</p></center></h2>
<div class="dropdown" ><a>Home</a>
<div class="dropdown-content">
<a href="link1.html">Link 1</a>
<a href="#">Link 2</a>
</div>
<a href="#Admissions">Admissions</a>
<a href="#events">Events</a>
<a href="#contact">Contact</a> 
 </div>
<table align="center">
<tr> <td>
<img src= "./assets/college.jpg" width="1025" height="300" alt="homepage">

</td>
<td><center>
 Username: <input type = "text"><br><br>
 Password: <input type = "password"><br><br>
<center><button type= "submit" value="Submit">Submit </button>
<button type="reset" value="Reset" >Reset</button ><br><br>
</center>
</td>
</tr>
 </table>
<h3><b>About Us</b></h3>
<blockquote> Government Polytechnic, Ramanagara was started in 2007-2008. The organization is currently working on the newly constructed building of the Government Engineering College on a 4.15-acre campus in Ramanagar. The institute is a government agency of AICCT and comes under the Directorate of Technical Education, Karnataka.</blockquote>
<blockquote>Provide quality technical education based on values, and is supported by industry links to create a career for the rural youth.
Encouraging entrepreneurship by providing skills-based technical education.
Develop leadership, teamwork and communication skills through extracurricular activities.</blockquote>
</form>
<footer>
<marquee><a	href="#">Designed	&	Maintained	by M.E(WT),Centenary batch</a></marquee>
</footer>
</body>
</html> 


<!----css--->
.dropdown {
	
    display: block;background-color:pink;
    
    }
    .dropdown a{
        
    padding:0px 20px
    
    }
    .dropdown-content { display: none; position: absolute;
    background-color:yellow; min-width: 100px;
    
    }
    
    .dropdown-content a { color: black; padding: 12px 16px;
    text-decoration: none; display: block;
    text-align: left;
    }
    
    .dropdown-content a:hover 
    {background-color:blue}
    
    .dropdown:hover .dropdown-content 
    { display: block;
    }



