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
    
        <form action="AddPersonDetail" method="post">
                     
      
           
            <h1 style="color: white;">Cadastrar Curriculo</h1>
            <div class="form-group">
           		 <div class="row">
	    			<div class="col-md-6">
	                	<label for="nomeCurriculo">Nome:</label>
	                	<input type="hidden"  id="id" name="id" value=""/>
	                	<input type="hidden" id="cpf" name="cpf" value="<%= request.getAttribute("cpf") %>"  >
                		<input type="text" class="form-control" id="nomeCurriculo" name="nomeCurriculo" placeholder="Digite seu nome" required>
	                </div>
	                <div class="col-md-6">
	                	<label for="profissao">Profissão:</label>
                		<input type="text" class="form-control" id="profissao" name="profissao" placeholder="Digite sua profissão" required>
	                </div>
	                
	             </div>
	             
	             <div class="row">
	    			<div class="col-md-6">
	                	<label for="experiencia">Experiência:</label>
                		<textarea class="form-control" id="experiencia" rows="3" name="experiencia" placeholder="Digite sua experiência" required></textarea>
	                </div>
	                <div class="col-md-6">
	                	<label for="educacao">Educação:</label>
                		<textarea class="form-control" id="educacao" rows="3"  name="educacao" placeholder="Digite sua educação" required></textarea>
	                </div>
	                
	             </div>
	             
	             <div class="row">
	    			<div class="col-md-6">
	                	<label for="extra">Informações Extras:</label>
                		<textarea class="form-control" id="extra" rows="3"  name="extra" placeholder="Digite informações extras" required></textarea>
	                </div>
	                <div class="col-md-6">
	                	<label for="chave">Palavras Chave:</label>
                		<textarea class="form-control" id="chave" rows="3" name="chave" placeholder="Digite Palavras Chave" required></textarea>
	                </div>
	                
	             </div>
                
            </div>
            
            
            <button type="submit" class="btn "style="background-color: #511C29; color: white" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
  <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
</svg> Enviar</button>
            
            <br>
            <br>
            <br>
            <br>
            <h1 style="color: white;">Meus Curriculos</h1>
            <table class="table bg-white " style="border-radius: 15px;">
		        <thead>
		        <tr>
		            <th>Nome Currículo</th>
		            <th>Profissão</th>
		            <th>Palavras Chave</th>
		            <th>Editar</th>
		            <th>Deletar</th>
		        </tr>
		        </thead>
		        <tbody>
		        <c:forEach items="${persons}" var="person">
		            <tr>
		                
		                <td><c:out value="${person.nomeCurriculo}"></c:out></td>
		                <td><c:out value="${person.profissao}"></c:out></td>
		                <td><c:out value="${person.chave}"></c:out></td>
		                <td><a class="btn btn-primary" href="GetPersonDetails?action=edit&id=<c:out value='${person.id}'/>"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16"><path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/></svg> Editar</a></td>
		                <td><a class="btn btn-danger" href="GetPersonDetails?action=delete&id=<c:out value='${person.id}'/>"><span aria-hidden="true">&times;</span> Deletar</a></td>
		            </tr>
		        </c:forEach>
		        </tbody>
		    </table>
            
        </form>
    </div>

    <!-- Adicione o link para o Bootstrap JS e o jQuery (necessários para alguns recursos do Bootstrap) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>