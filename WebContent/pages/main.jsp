<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="models.Contact"%>
<%@ page import="java.util.List"%>
<%@page import="models.Company" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">

<script
			  src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			  integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
			  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/se-2.2.13/jq-3.2.1/dt-1.10.16/datatables.min.css"/>

<script type="text/javascript" src="https://cdn.datatables.net/v/se-2.2.13/jq-3.2.1/dt-1.10.16/datatables.min.js"></script>




<title><bean:message key="title"/></title>
</head>
<body>
<div class="ui large menu">
  <a href="/Contact" class="item"><bean:message key="home"/></a>
  <a href="Home.do" class="active item"><bean:message key="contacts"/></a>
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
	<div class="ui grid">
	  <div class="four column row">
	    <div class="left floated column">
	    	<a style="margin-bottom: 2%;" class="ui labeled icon button" href="ContactCreation.do">
			  <i class="plus icon"></i>
			  <bean:message key="form.contact.add.new"/>
			</a>
	    </div>
	    <div class="right floated column">
		    <a style="margin-bottom: 2%;" class="ui labeled icon button" href="Populate.do">
			  Hello darkness my old friend, i came to populate you again
			  <i class="plus icon"></i>
			</a>
	    </div>
	  </div>
	</div>	
	<table id="contactTable" class="ui celled padded table">
		<thead>
			<tr>
				<th><bean:message key="form.contact.lastName.label"/></th>
				<th><bean:message key="form.contact.firstName.label"/></th>
				<th><bean:message key="form.contact.email.label"/></th>
				<th><bean:message key="form.contact.type.label"/></th>
				<th><bean:message key="main.actions"/></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="contacts" id="contact">
		        <tr>
		            <td><bean:write name="contact" property="lastName"/></td>
		            <td><bean:write name="contact" property="firstName"/></td>
		            <td><bean:write name="contact" property="email"/></td>
		            <td>
		            	<% if (Company.class.isInstance(contact)) { %>
		            		<i class="building outline icon"></i> Entreprise
		            	<% } else { %>
		            		<i class="user outline icon"></i> Personne
		            	<% } %>
		            </td>
		            <td><i style="cursor: pointer;" id="plus-<bean:write name="contact" property="id"/>" class="plus icon"></i><a href="ContactEdition.do?cid=<bean:write name="contact" property="id"/>"><i class="write icon"></i></a> <a href="ContactSuppression.do?id=<bean:write name="contact" property="id"/>"><i class="trash outline icon"></i></a></td>
		        </tr>
	        </logic:iterate>
		</tbody>
	</table>
	
	<logic:iterate name="contacts" id="contact">
		<div class="ui modal" id="modal-<bean:write name="contact" property="id"/>">
			<i class="close icon"></i>
	  		<div class="header"><bean:message key="main.contact.detail"/></div>
	  		<div class="scrolling content">
				<div class="ui grid">
					<div class="sixteen wide column">
						<h4 class="ui dividing header"><bean:message key="form.contact"/></h4>
					</div>
					<div class="eight wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.lastName.label"/></span>: <bean:write name="contact" property="lastName"/></p>
					</div>
					<div class="eight wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.firstName.label"/></span>: <bean:write name="contact" property="firstName"/></p>
					</div>
					<div class="sixteen wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.email.label"/></span>: <bean:write name="contact" property="email"/></p>
					</div>
					<div class="sixteen wide column">
						<h4 class="ui dividing header"><bean:message key="form.contact.adress"/></h4>
						<bean:define id="adresse" name="contact" property="adresse"/>
					</div>
					<div class="eight wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.country.label"/></span>: <bean:write name="adresse" property="country"/></p>
					</div>
					<div class="eight wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.city.label"/></span>: <bean:write name="adresse" property="city"/></p>
					</div>
					<div class="three wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.zip.label"/></span>: <bean:write name="adresse" property="zip"/></p>
					</div>
					<div class="thirteen wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.street.label"/></span>: <bean:write name="adresse" property="street"/></p>
					</div>
					<div class="sixteen wide column">
						<h4 class="ui dividing header"><bean:message key="form.contact.phone"/></h4>
					</div>
					<bean:define id="phoneNumbers" name="contact" property="phoneNumbers"/>
					<logic:iterate name="phoneNumbers" id="phoneNumber">
						<div class="eight wide column">
							<p><span style="font-weight: bold;"><bean:message key="form.contact.phoneKind.label"/></span>: <bean:write name="phoneNumber" property="phoneKind"/></p>
						</div>
						<div class="eight wide column">
							<p><span style="font-weight: bold;"><bean:message key="form.contact.phoneNumber.label"/></span>: <bean:write name="phoneNumber" property="phoneNumber"/></p>
						</div>
					</logic:iterate>
					<% if (Company.class.isInstance(contact)) { %>
					<div class="sixteen wide column">
						<h4 class="ui dividing header"><bean:message key="form.contact.entreprise"/></h4>
					</div>
					<div class="eight wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.numSiret.label"/></span>: <bean:write name="contact" property="numSiret"/></p>
					</div>
					<div class="eight wide column">
						<p><span style="font-weight: bold;"><bean:message key="form.contact.companyName.label"/></span>: <bean:write name="contact" property="name"/></p>
					</div>
					<% } %>
				</div>
	  		</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function()
			{
				var id = "<bean:write name="contact" property="id"/>";
				$("#plus-" + id).click(function ()
				{
					$("#modal-" + id).modal("show");
				});
			});
		</script>
	</logic:iterate>
</div>

<script type="text/javascript">
$(document).ready(function() {	
	$('.ui.dropdown')
	  .dropdown()
	;
	$('.ui.modal')
	  .modal({
			closable: true
		});
	;
    var langMap = {
               'en' : 'English',
               'fr' : 'French'
               //etc, the languages you want to support
        }
    function getLanguage() {
        var lang = navigator.language || navigator.userLanguage; 
        return '//cdn.datatables.net/plug-ins/1.10.7/i18n/'+langMap[lang]+'.json'
    }

    var table = $('#contactTable').DataTable({
        language : {
            url: getLanguage(),
            "bSort": false
        }
    });
} );

</script>

</body>
</html>