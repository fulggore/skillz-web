<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Oregano&display=swap" rel="stylesheet">
    <title>Login Page</title>
    <style>
		body {
            background-color: #511c29;
        }
	</style>
</head>
<body>

<div class="container mt-5">
	
		<%
	    
	    String mensagem = (String)request.getAttribute("msg");
	    
	    if (mensagem != null && !mensagem.isEmpty()) {
		%>
				
				<div class="alert alert-primary" role="alert">
					<%= mensagem %>
				</div>
		<%
			}
		%>
	
	<div class="row justify-content-center "><h1 style="color:white;font-size:100px;font-family:Oregano">Skillz</h1></div>
    <div class="row d-flex  justify-content-center ">
        <div class="col-md-4 bg-white" style="border-radius: 15px;">
            <br>
            <h3>Área do Candidato</h3>
			<form class="login-form" action="Authentication" method="post">
				<div class="form-group">
					<label for="username">Login:</label>
					<input type="hidden" id="tipo" name="tipo" value="candidatoLogin">
					<input class="form-control" type="text" id="username" name="username" required>
				</div>
				<div class="form-group">
					<label for="password">Senha:</label>
					<input class="form-control" type="password" id="password" name="password" required>
				</div>
				<button type="submit" class="btn" style="background-color: #56494E;color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg> Login</button>
				&nbsp;&nbsp;&nbsp;
				<a href="registerCandidato.jsp" class="btn" style="background-color: #56494E;color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664z"/>
</svg> Registrar-se</a>
			</form>
        <br>
        </div>
        &nbsp;&nbsp;&nbsp;
        <div class="col-md-4 bg-white" style="border-radius: 15px;">
            <br>
            <h3>Área do Recrutador</h3>
			<form class="login-form" action="home.html" method="post">
				<div class="form-group">
					<label for="username">Login:</label>
					<input type="hidden" id="tipo" name="tipo" value="candidatoLogin">
					<input class="form-control" type="text" id="username" name="username" required>
				</div>
				<div class="form-group">
					<label for="password">Senha:</label>
					<input class="form-control" type="password" id="password" name="password" required>
				</div>
				<button type="submit" class="btn" style="background-color: #56494E;color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0z"/>
  <path fill-rule="evenodd" d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg> Login</button>
				&nbsp;&nbsp;&nbsp;
				<a href="registerRecrutador.jsp" class="btn" style="background-color: #56494E;color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664z"/>
</svg> Registrar-se</a>
        <br>
        </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>