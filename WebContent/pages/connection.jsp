<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
  <a href="/Contact" class="item"><bean:message key="home"/></a>
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

	<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui image header">
      <div class="content"><bean:message key="form.connection.connect"/></div>
    </h2>
    <html:form method="post" action="Connect.do" styleClass="ui large form error">
      <div class="ui stacked secondary  segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <html:text property="username" size="50" maxlength="50"/>
          </div>
          <div class="ui error message">
  				<p><html:errors property="username"/></p>
		  </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <html:password property="password" size="50" maxlength="50"/>
          </div>
          <div class="ui error message">
  				<p><html:errors property="password"/></p>
		  </div>
        </div>
        <html:submit styleClass="ui fluid large teal submit button"><bean:message key="form.connection.connect"/></html:submit>
      </div>

    </html:form> 
  </div>
</div>

<style>
	body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
</style>

<script>
$(document).ready(function ()
{
	var errors = $(".form .error");
	var count = 0;
	console.log(errors);
	$('.ui.dropdown')
	  .dropdown()
	;
	errors.each(function()
	{
		console.log(this);
		if ($(this).children("p").html() == "")
		{
			$(this).css("display", "none");
		}
		else
		{
			var count = 1;
		}
	})
	if (count == 1)
	{
		$(".form").addClass("error");
	}
});
</script>

</body>
</html>