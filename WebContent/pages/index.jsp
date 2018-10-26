<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script
			  src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			  integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
			  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.js"></script>
<title><bean:message key="title"/></title>
</head>
<body>

<div class="ui large menu">
  <a href="/Contact" class="active item"><bean:message key="home"/></a>
  <% if (session.getAttribute("user") != null) { %>
  	<a href="Home.do" class="item"><bean:message key="contacts"/></a>
  <% } %>
  <div class="right menu">
   	<div class="item">
   		<% if (session.getAttribute("user") != null) { %>
   			<div class="ui dropdown item"><%= session.getAttribute("user") %> <i class="dropdown icon"></i>
      		<div class="menu">
		        <a class="item" href="Logout.do"><bean:message key="link.logout"/></a>
	      	</div>
    	</div>
		<%} else {%>
			<div class="item">
	        	<a href="Connection.do" class="ui primary button"><bean:message key="link.signin"/></a>
	    	</div>
		<%} %>
   </div>
  </div>
</div>

<div class="ui container">
	<div style="margin-top: 5%;" class="ui piled segment">
  		<p><bean:message key="home.text"/></p>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function ()
{
	$('.ui.dropdown')
	  .dropdown()
	;
});
</script>

</body>
</html>