<%@page contentType="text/html" pageEncoding="UTF-8"
    import="java.util.*"
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Resultado</title>
</head>
<body>
    <h1>Com base no seu peso: ${param.peso} seu imc foi calculado</h1>
    <%
        String resultado;
        double peso = Double.parseDouble(request.getParameter("peso"));
        double altura = Double.parseDouble(request.getParameter("altura"));
        double imc = peso / (altura * altura);
        if (imc < 18.5) {
            resultado = "Abaixo do Peso";
        }
        else if (imc < 25){
            resultado = "Peso Ideal";
        }
        else if (imc < 30){
            resultado = "Levemente acima do peso";
        }
        else if (imc < 35){
            resultado = "Obesidade grau I";
        }
        else if (imc < 40){
            resultado = "Obesidade grau II";
        }
        else{
            resultado = "Obesidade grau III";
        }

    %>
    <h2>Valor do imc = <%=imc%> </h2>
    <h2>Resultado = <%=resultado%> </h2>

</body>
</html>