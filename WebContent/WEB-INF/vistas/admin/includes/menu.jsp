<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${usuario != null}">
	<ul class="menu">
	  <li><a href="admin/inicio"><i class="fas fa-home"></i></a></li>
	  <li><a class="config" href="admin/config"><i class="fas fa-cogs"></i></a><a class="logout" href="admin/logout">Logout</a></li>
	</ul>

</c:if>