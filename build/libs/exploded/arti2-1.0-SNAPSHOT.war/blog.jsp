<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="style.css" style="background-color: lightgray">

<head>
    <title>Blog</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<html>
<body style="background-image: url(http://www.ohphoto.com.au/gallery/original/Grey-gradient_3.jpg)">

<ul class="nav nav-tabs" style="background-color: #272125; text-decoration-color: whitesmoke">
    <li class="nav-item ">
        <a class="nav-link active" href="#">BLOG</a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="modal" href="#" data-target="#exampleModalCenter" role="button"
           aria-haspopup="true" aria-expanded="false">Search </a>
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalCenterTitle">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <h2>Event name</h2>
                        <input type="text" class="form-control" name="name_find" placeholder="input name">
                    </div>
                    <div class="modal-footer">
                        <button type="button " style="width: 50px" class="btn btn-secondary" data-dismiss="modal">Back</button>
                      <a href="${pageContext.request.contextPath}/search?name_find=${name_find}">find</a>
                    </div>
                </div>
            </div>
        </div>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/addEvent">Add event</a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">LogOut</a>
    </li>
</ul>
<form action="${pageContext.request.contextPath}/blog" method="post" class="mx-auto" style="width: 600px; ">
    <div class="card" style="max-width: 1200px;   margin: auto">

        <c:forEach items="${events}" var="event">
            <div class="row" style="width: 600px">
              <div></div>
                <div class="card" style="width: 5200px;  background-color: dimgray">
                    <img class="card-img-top" src="im.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${event.name}<br>${event.date}</h5>
                        <p class="card-text">${event.description}</p>
                        <p>${event.category}</p>
                        <c:forEach items="${event.tags}" var = "tag">
                        ${tag.name}</c:forEach>
                        <a href=${pageContext.request.contextPath}/editEvent?id=${event.id}
                           class="btn btn-primary">Edit</a>
                        <a href="${pageContext.request.contextPath}/delete?id=${event.id}" class="btn btn-primary">Delete</a>
                    </div>
                </div>
            </div>
        </c:forEach></div>
    <!--add new event-->
    <div class="card" style="width: 26rem;">

    </div>
    </div>
    </div>
    </div>
</form>

</body>
</html>
