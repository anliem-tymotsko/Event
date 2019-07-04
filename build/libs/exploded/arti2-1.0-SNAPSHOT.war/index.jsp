<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" href="style.css">
    <link  href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</head>
<script>
    $('.ui.fluid.search.dropdown')
        .dropdown({
            allowAdditions: true
        })
    ;
</script>
<form action="${pageContext.request.contextPath}/addEvent" method="post" style="width : 320px;">

    <h2>Event name</h2>
    <input type="text" class="form-control" name="name" placeholder="event...">
    </div>
    <div class="form-group">
        <h2>Date of event</h2>
        <input type="date" class="form-control" name="date">
    </div>
    <div class="form-group">
        <h2>contact number</h2>
        <input type="text" class="form-control" name="contact_number" placeholder="+ 38(097) - *** - *** - **">
    </div>
    <div class="form-group">
        <h2>category</h2>
        <select name="id_category">
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <div class="form-group">
            <h2>hashes</h2>
            <select required multiple class="form-control" name="hashes" style="height: 90px">
                <c:forEach items="${hashes}" var="hash">
                    <option class="form-control" style="width: 150px" value=${hash.id}>${hash.name}</option>
                </c:forEach>
            </select><br>
        </div>
        <h2>description</h2>
        <input type="text" class="form-control" name="description" placeholder="text">
    </div>
    <button type="submit">ok</button>
</form>
