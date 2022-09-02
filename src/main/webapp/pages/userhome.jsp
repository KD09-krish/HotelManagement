<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<div align="right"><table><tr><td>
<sping:url var="fetchUrl" value="/secure/logout"/>
<a href="${fetchUrl}">Logout</a>
                                                        </td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div> 


<div align="center">Welcome to user home

<p />User : <c:out value="${sessionScope.user.username}"/>
<p />Select a menu to continue
<p />
<ul>
	<li> 
	<spring:url var="fetchUrl" value="/general/getAvailableRooms"/>
			<a href="${fetchUrl}">Check Room Availablity</a>
    </li>

	<li>  
	<spring:url var="fetchUrl" value="/secure/getAvailableRooms"/>
			<a href="${fetchUrl}">Available Rooms</a>
	
	 </li>

	<li>    
	<spring:url var="fetchUrl" value="/secure/getOccupiedRooms"/>
			<a href="${fetchUrl}">Occupied Rooms</a>
	
	    </li>
	
</ul>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>