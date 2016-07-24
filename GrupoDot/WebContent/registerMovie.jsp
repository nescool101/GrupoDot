<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateMovie">
  <s:push value="movie">
    <s:hidden name="id" />
    <s:textfield name="name" label="Nombre de la Pelicula"  />
    <s:textfield name="code" label="Codigo de la Pelicula" />
    <s:textfield name="desc" label="Descripcion de la Pelicula" />
    <s:textarea name="aboutYou" label="About You" />
    <s:checkbox name="mailingList"
      label="Would you like to join our mailing list?" />
    <s:submit />
  </s:push>
</s:form>

<s:if test="movieList.size() > 0">
  <div class="content">
  <table class="movieTable" cellpadding="5px">
    <tr class="even">
      <th>Name</th>
      <th>Gender</th>
      <th>Country</th>
      <th>About You</th>
      <th>Mailing List</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
    <s:iterator value="movieList" status="movieStatus">
      <tr
        class="<s:if test="#movieStatus.odd == true ">odd</s:if><s:else>even</s:else>">
        <td><s:property value="name" /></td>
        <td><s:property value="code" /></td>
        <td><s:property value="desc" /></td>
        <td><s:property value="aboutYou" /></td>
        <td><s:property value="mailingList" /></td>
        <td><s:url id="editURL" action="editMovie">
          <s:param name="id" value="%{id}"></s:param>
        </s:url> <s:a href="%{editURL}">Edit</s:a></td>
        <td><s:url id="deleteURL" action="deleteMovie">
          <s:param name="id" value="%{id}"></s:param>
        </s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
      </tr>
    </s:iterator>
  </table>
  </div>
</s:if>
</body>
</html>