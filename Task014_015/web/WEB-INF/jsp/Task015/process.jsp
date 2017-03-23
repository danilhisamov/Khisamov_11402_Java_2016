<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.03.2016
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Process</title>
</head>
<body>
<form action="/process" method="POST">
    <p><b>Enter text</b></p>
    <p><textarea rows="10" cols="45" name="text"></textarea></p>
    <br><select name='choice'>
        <option selected disabled>Choose operation</option>
        <option value='count_char'>Count char's</option>
        <option value='count_word'>Count words</option>
        <option value='count_sent'>Count sentences</option>
        <option value='count_par'>Count paragraphs</option>
    </select>
    <input type='submit' value='Process'/>
</form>
</body>
</html>
