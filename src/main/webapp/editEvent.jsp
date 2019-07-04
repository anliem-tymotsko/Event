<head>
    <link rel="stylesheet" href="style.css">
</head>
<form action="${pageContext.request.contextPath}/editEvent?id=${event.id}" method="post" style="width : 320px;">
    <input type = "hidden" name = "id" value="${id}">
    <div>
        <h2 >photo url:</h2>
        <input type="text" class="form-control" name="url_image" value="${event.urlImage}">
    </div>
    <div class="form-group">
        <h2 >Name of event :</h2>
        <input type="text" class="form-control" name="name" value="${event.name}">
    </div>
    <div class="form-group">
        <h2 >contact number</h2>
        <input type="text" class="form-control" name="contact_number"  value="${event.contactTelNum}">
    </div>
    <div class="form-group">
        <h2 > Date of event</h2>
        <input type="date" class="form-control" name="date" value="${event.date}">
    </div>
    <div class="form-group">
        <h2 > Category</h2>
        <input type="text" class="form-control" name="id_category">
    </div>
    <div class="form-group">
        <h2 >description</h2>
        <input type="text" class="form-control" name="description" value="${event.description}">
    </div>
    <button type="submit"><a href="${pageContext.request.contextPath}/blog"></a>save</button>
</form>