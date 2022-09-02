<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="/pages/include.jsp"/>


<c:if test="${sessionScope.user != null}">
<div align="right"><table><tr><td>
<spring:url var="fetchUrl" value="/secure/logout"/>
<a href = "${fetchUrl}">Logout</a>
</td></tr>
<tr><td><p><br/></p></td></tr>
<tr><td><p><br/></p></td></tr>
</table></div>

</c:if>

<div align="center">
<TABLE WIDTH=40% BORDER=1 BORDERCOLOR="#aabbcc">

<c:if test="${status == 'A'}">
  <caption>Available Rooms </caption>
</c:if>  

<tr>
<th>Room Number</th>
<th>Room Type</th>
</tr>
<c:if test="${not empty rooms}">
<c:forEach var="o" items="${rooms}">


            <tr>
            	
           <spring:url var="allocateUrl" value="/secure/allocateRoom">
           <spring:param name="roomNumber" value="${o.roomNumber}"/>
           </spring:url>
           
           <spring:url var="deallocateUrl" value="/secure/deallocateRoom">
           <spring:param name="roomNumber" value="${o.roomNumber}"/>
           </spring:url>
           
                <td>
				${o.roomNumber} 
				<c:choose>
				 <c:when test="${o.roomStatus == 'A'}">
				 <a href="${allocateUrl}">Allocate</a>
				 </c:when>
				 
				 <c:otherwise>
				 <a href = "${deallocateUrl}">Deallocate</a>
				 </c:otherwise>
			   </c:choose>	 
				</td>

                <td>
                 ${o.roomType}
                </td>
               
            </tr>
      </c:forEach>
     </c:if>  



<tr><td colspan="2" align="center">

     <spring:url var="fetchUrl" value="/back"/>
          <a href="${fetchUrl}">Back</a>	
			
			</td></tr>
</TABLE>
</div>
<P STYLE="margin-bottom: 0cm"><BR>
</P>



</body>
</html>