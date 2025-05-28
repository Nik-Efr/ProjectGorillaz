<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="parts/header.jsp" %>
<div class="container">
    <section class="position-relative py-4 py-xl-5">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-md-6 col-xl-4">
                    <div class="card mb-5">
                        <div class="card-body d-flex flex-column align-items-center">
                            <h2>Edit User</h2>
                            <form class="text-center" method="post" action="edit-user" enctype="multipart/form-data">
                                <input type="hidden" name="id" value="${user.id}">
                                <p class="text-muted">Нажмите для загрузки фото</p>

                                <div class="form-group">
                                    <label for="image">
                                        <img id="previewId" src="images/${user.image}" width="250px"
                                             alt="images/${user.image}">
                                    </label>
                                    <input onchange="PreviewImage('image','previewId');" id="image" name="image"
                                           style="visibility:hidden;"
                                           class="input-file" type="file">
                                </div>
                                <p class="w-lg-50">Укажите данные для обновления</p>
                                <div class="mb-3"><input class="form-control" type="text" name="login" placeholder="Login" value="${requestScope.user.login}"></div>
                                <div class="mb-3"><input class="form-control" type="password" name="password" placeholder="Password" value="${requestScope.user.password}"></div>
                                <div class="mb-3">
                                    <select class="form-control" name="role">
                                        <option value="USER" ${requestScope.user.role == 'USER' ? 'selected' : ''}>User</option>
                                        <option value="ADMIN" ${requestScope.user.role == 'ADMIN' ? 'selected' : ''}>Admin</option>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <button class="btn btn-primary d-block w-100" type="submit" name="update">Update</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<script type="text/javascript">
    function PreviewImage(inputFileId, imageId) {
        let oFReader = new FileReader();
        oFReader.readAsDataURL(document.getElementById(inputFileId).files[0]);
        oFReader.onload = function (oFREvent) {
            document.getElementById(imageId).src = oFREvent.target.result;
        };
    }
</script>

<%@include file="parts/footer.jsp" %>