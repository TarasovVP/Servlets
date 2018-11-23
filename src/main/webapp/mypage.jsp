<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sakila admin</title>
    <style><%@include file="/base.css"%></style>
</head>
<body>
<div>
    <form>
        <fieldset>
            <p>Введите нового актера: </p>
            <div id="div2">
                <p id="p1"><label for="name">Имя: </label><input type="text" id="name"></p>
                <p id="p2"><label for="surname">Фамилия: </label><input type="email" id="surname"></p>
            </div>
            <p><input type="submit" value="Сохранить" class = "bttn"></p>
        </fieldset>
    </form>
</div>

</body>
</html>