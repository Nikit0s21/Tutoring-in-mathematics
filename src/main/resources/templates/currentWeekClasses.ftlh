<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Расписание занятий</title>
</head>
<body>
<h1>Расписание занятий на текущую неделю</h1>
<ul id="class-schedule">
    <#list classSchedule as class>
        <li>${class.topic} - ${class.startDate} - ${class.student.fcs} <a href="${'/class-schedule/current-week/'+class.classSchedule_id}">Update</a> </li>
    </#list>
</ul>
</body>
</html>
