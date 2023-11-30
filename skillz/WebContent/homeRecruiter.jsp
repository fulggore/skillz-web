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
		table, th, td {
	        border: none !important;
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
	      <a href="index.jsp" class="btn my-2 my-sm-0" style="background-color: #56494E;color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-power" viewBox="0 0 16 16">
  <path d="M7.5 1v7h1V1z"/>
  <path d="M3 8.812a4.999 4.999 0 0 1 2.578-4.375l-.485-.874A6 6 0 1 0 11 3.616l-.501.865A5 5 0 1 1 3 8.812"/>
</svg> Logout</a>
	    </form>
	  </div>
	</nav>
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
    <h1 style="color:white">Candidatos</h1>
         	<form action="GetPersonDetails" method="post">
        	<div class="form-group">
	            <div class="row">
	    			<div class="col-md-10">
	    					<label for="nome">Busca por palavras Chave:</label>
	                </div>
	              </div>
	               <div class="row">
		               <div class="col-md-10">
		                	<input type="text" class="form-control" id="busca" name="busca" placeholder="Digite a palavra chave" required>
		                </div>
	                <div class="col-md-2">
	    				
	    				<button type="submit" class="btn" style="background-color: #511C29; color: white"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
</svg> Buscar</button>
	                </div>
	              </div>
            </div>
            </form>
        	
            <table class="table bg-white " style="border-radius: 15px;">
		        <thead>
		        <tr>
		            <th>Nome Currículo</th>
		            <th>Profissão</th>
		            <th>Palavras Chave</th>
		            <th>Visualizar</th>

		        </tr>
		        </thead>
		        <tbody>
		        <c:forEach items="${persons}" var="person">
		            <tr>
		                
		                <td><c:out value="${person.nomeCurriculo}"></c:out></td>
		                <td><c:out value="${person.profissao}"></c:out></td>
		                <td><c:out value="${person.chave}"></c:out></td>
		                <td><a class="btn " style="background-color: #511C29; color: white" href="GetPersonDetails?action=editR&id=<c:out value='${person.id}'/>"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
  <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
  <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"/>
</svg> Ver Currículo</a></td>

		            </tr>
		        </c:forEach>
		        </tbody>
		    </table>
		    <br>
		    <hr>
		    <br>
		    <h1 style="color:white">Curriculos Favoritados</h1>
		    <table class="table bg-white " style="border-radius: 15px;">
		        <thead>
		        <tr>
		            <th>Nome Currículo</th>
		            <th>Profissão</th>
		            <th>Palavras Chave</th>
		            <th>Visualizar</th>
		        </tr>
		        </thead>
		        <tbody>
		        <c:forEach items="${persons}" var="person">
		            <c:if test="${person.favorito == 1}">
		            <tr>
		                
		                <td style="border-top:none"><c:out value="${person.nomeCurriculo}"></c:out></td>
		                <td style="border-top:none"><c:out value="${person.profissao}"></c:out></td>
		                <td style="border-top:none"><c:out value="${person.chave}"></c:out></td>
		                <td style="border-top:none"><a class="btn "  style="background-color: #511C29; color: white" href="GetPersonDetails?action=editR&id=<c:out value='${person.id}'/>"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
  <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
  <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"/>
</svg> Ver Currículo</a></td>

		            </tr>
		            </c:if>
		        </c:forEach>
		        </tbody>
		    </table>
            
    </div>

    <!-- Adicione o link para o Bootstrap JS e o jQuery (necessários para alguns recursos do Bootstrap) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>