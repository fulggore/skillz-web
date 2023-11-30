<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Skillz</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Oregano&display=swap" rel="stylesheet">
<style>
        body {
            
            background-color: #A29C9B;
            
        }
        .navbar {
		    background-color: #511C29; 
		}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light " >
	  <a class="navbar-brand " href="#" style="color: white;font-family:Oregano;font-size:30px">Skillz</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <form class="form-inline my-2 my-lg-0 ml-auto">

	    </form>
	  </div>
	</nav>
	
    
    
    <div class="container mt-5">
    <h1 style="color: white;">Candidato</h1>
        <form action="Authentication" method="post">
            <div class="form-group">
	            <div class="row">
	    			<div class="col-md-6">
	    				<input type="hidden"  id="tipo" name="tipo" value="candidato">
	    				<input type="hidden"  id="id" name="id">
	                	<label for="nome">Nome:</label>
	                	<input type="text" class="form-control" id="nome" name="nome" placeholder="Digite seu nome" required>
	                </div>
	                <div class="col-md-3">
	                	<label for="email">Email:</label>
	                	<input type="email" class="form-control" id="email"  name="email" placeholder="Digite seu email" required>
	                </div>
	                <div class="col-md-3">
	                	<label for="cpf">CPF:</label>
	                	<input type="text" class="form-control" id="cpf" name="cpf" placeholder="Digite seu CPF" required>
	                </div>
	             </div>
	             
	              <div class="row">
	    			<div class="col-md-8">
	                	<label for="senha">Senha:</label>
                		<input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha" required>
	                </div>
	                <div class="col-md-4">
	                	<label for="celular">Celular:</label>
		                <div class="input-group">
		                    <div class="input-group-prepend">
		                        <span class="input-group-text">+55</span>
		                    </div>
		                    <input type="text" class="form-control" id="celular" name="celular" placeholder="Digite seu número de celular" required>
		                </div>
	                </div>
	                
	             </div>
                
     
            </div>
            
            
            
            
            <button type="submit" class="btn " style="background-color: #511C29; color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
  <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
</svg> Enviar</button>
            
           
            
            
        </form>
</div>
    <!-- Adicione o link para o Bootstrap JS e o jQuery (necessários para alguns recursos do Bootstrap) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>