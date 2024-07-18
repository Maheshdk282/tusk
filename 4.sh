<!DOCTYPE html>
<html>
<head>
<title>calendarprogram</title>
<script language="javascript">

//<!--
function day_title(day_name){
document.write("<TD ALIGN=center WIDTH=35>"+day_name+"</TD>")
}
function fill_table(month,month_length) { day=1
document.write("<TABLE BORDER=3 CELLSPACING=3 CELLPADDING=%3><TR>")
document.write("<TD COLSPAN=7 ALIGN=center><B>"+month+" "+year+"</B><TR>") 
day_title("Sun")
day_title("Mon") 
day_title("Tue") 
day_title("Wed") 
day_title("Thu") 
day_title("Fri") 
day_title("Sat") 
document.write("</TR><TR>") 
for (var i=1;i<start_day;i++) { 
document.write("<TD>")
}
for (var i=start_day;i<8;i++) {
document.write("<TD ALIGN=center>"+day+"</TD>") 
day++}
document.write("<TR>") 
while (day <= month_length) 
{
for (var i=1;i<=7 && day<=month_length;i++) 
{ 
document.write("<TD ALIGN=center>"+day+"</TD>") 
day++
}
document.write("</TR><TR>") 
start_day=i
}
document.write("</TR></TABLE><BR>")
}
// End -->
</script>
</head>
<body>
<script language="javascript"> 
year=prompt("enter 4 digit year") 
today= new Date("January 1, "+year) 
start_day = today.getDay() + 1 
fill_table("January",31)
if (year%4==0) 
fill_table("February",29) 
else 
fill_table("February",28)
fill_table("March",31) 
fill_table("April",30) 
fill_table("May",31) 
fill_table("June",30) 
fill_table("July",31) 
fill_table("August",31) 
fill_table("September",30) 
fill_table("October",31) 
fill_table("November",30) 
fill_table("December",31)
</script>
</body>
</html>