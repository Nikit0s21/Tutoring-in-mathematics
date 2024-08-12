<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List students</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css"/>
</head>
<body>
<h1>Students</h1>
<h3>Add student to list</h3>
<form action="/add" method="post">
    <table border="1px">
        <tr>
            <td>
                <label>Fcs</label>
                <input type="text" name="fcs">
            </td>
            <td>
                <label>Description</label>
                <input type="date" name="birthdate">
            </td>

            <td>
                <input type="submit" value="add student">
            </td>

        </tr>

    </table>
</form>
<br>
<h2>Student list(student count : ${studentSize})</h2>
<table border="1px">
    <tr>
        <td>Student id</td>
        <td>FCs</td>
        <td>Birthdate</td>
        <td>Delete from list</td>
        <td>Set from list</td>
    </tr>
    <#list studentList as student>
    <tr>
        <td>${student.student_id}</td>
        <td>${student.fcs}</td>
        <td>${student.birthdate}</td>
        <td><a href="${'/delete/'+student.student_id}">Delete</a></td>
        <td><a href="${'/update/'+student.student_id}">Update</a></td>
    </tr>
    </#list>
</table>
</body>
</html>