<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>






<div align="right"><table><tr><td>     
<sping:url var="fetchUrl" value="/secure/logout"/>
<a href="${fetchUrl}">Logout</a>
             </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


<div align="center">
<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">
<tr><td>Room has been allocated</td></tr>
<tr><td> <spring:url var="fetchUrl" value="/secure/home"/>
          <a href="${fetchUrl}">Home</a>			</td></tr>
</TABLE>