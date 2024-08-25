<!-- Gerado por ChatGPT -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AppMusico</title>
    <style>
        /* Importa a fonte Helvetica, com fallback para Arial e sans-serif */
        body {
            font-family: Helvetica, Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        /* Estilos para a barra preta */
        .navbar {
            background-color: black;
            color: white;
            padding: 10px;
            text-align: left;
            font-family: Helvetica, Arial, sans-serif;
        }
        .navbar a {
            color: gray;
            text-decoration: none;
            padding: 10px;
            font-family: Helvetica, Arial, sans-serif;
        }
        .navbar a:hover {
            background-color: #444;
        }

        .navbar #homeLink {
            color: white; /* Cor branca apenas para o item "AppMusico" */
        }

        /* Estilos para as etiquetas coloridas */
        .label {
            display: inline-block;
            padding: 10px;
            margin: 5px;
            font-weight: bold;
            color: white;
            border-radius: 5px;
            font-family: Helvetica, Arial, sans-serif;
        }
        .musico { background-color: red; }
        .instrumentos { background-color: green; }
        .corda { background-color: blue; }
        .sopro { background-color: orange; }
        
        #content {
            margin-top: 20px;
            font-family: Helvetica, Arial, sans-serif;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        ul {
            padding-left: 20px;
        }
        .instrument-list {
            margin-bottom: 20px;
        }
    </style>
    <script>
        function fetchContent(menuType) {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "/" + menuType + "/listar", true);
            xhr.onload = function() {
                if (xhr.status === 200) {
                    try {
                        var responseJson = JSON.parse(xhr.responseText);
                        var formattedContent = '<div>';
                        
                        // Verifica se a resposta é um array
                        if (Array.isArray(responseJson)) {
                            responseJson.forEach(function(item, index) {
                                formattedContent += '<h3>Item ' + (index + 1) + '</h3>';
                                formattedContent += '<ul>';
                                for (var key in item) {
                                    if (item.hasOwnProperty(key)) {
                                        if (Array.isArray(item[key])) {
                                            formattedContent += '<li><strong>' + key + ':</strong><div class="instrument-list">';
                                            item[key].forEach(function(subItem, subIndex) {
                                                formattedContent += '<h4>Instrumento ' + (subIndex + 1) + '</h4>';
                                                formattedContent += formatObject(subItem);
                                            });
                                            formattedContent += '</div></li>';
                                        } else {
                                            formattedContent += '<li><strong>' + key + ':</strong> ' + item[key] + '</li>';
                                        }
                                    }
                                }
                                formattedContent += '</ul>';
                            });
                            formattedContent += '</div>';
                        } else {
                            formattedContent = 'Resposta inesperada. Esperava um array de objetos.';
                        }
                        
                        document.getElementById("content").innerHTML = formattedContent;
                    } catch (e) {
                        document.getElementById("content").innerText = "Erro ao processar o JSON.";
                    }
                } else {
                    document.getElementById("content").innerText = "Erro ao carregar conteúdo.";
                }
            };
            xhr.send();
        }

        function formatObject(obj) {
            var formatted = '<ul>';
            for (var key in obj) {
                if (obj.hasOwnProperty(key)) {
                    formatted += '<li><strong>' + key + ':</strong> ' + (obj[key] !== null ? obj[key] : 'N/A') + '</li>';
                }
            }
            formatted += '</ul>';
            return formatted;
        }
    </script>
</head>
<body>
    <!-- Barra de navegação -->
    <div class="navbar">
        <a href="/" id="homeLink">AppMusico</a>
        <a href="#" onclick="fetchContent('musico')">Musico</a>
        <a href="#" onclick="fetchContent('instrumento')">Instrumentos</a>
        <a href="#" onclick="fetchContent('cordas')">Instrumentos de Corda</a>
        <a href="#" onclick="fetchContent('sopro')">Instrumentos de Sopro</a>
    </div>

    <!-- Etiquetas coloridas com quantidades dinâmicas -->
    <div>
        <span class="label musico">Musico: <span id="musicoValue"><c:out value="${qtdeMusico}" /></span></span>
        <span class="label instrumentos">Instrumentos: <span id="instrumentosValue"><c:out value="${qtdeInstrumento}" /></span></span>
        <span class="label corda">Instrumentos de Corda: <span id="cordaValue"><c:out value="${qtdeCordas}" /></span></span>
        <span class="label sopro">Instrumentos de Sopro: <span id="soproValue"><c:out value="${qtdeSopro}" /></span></span>
    </div>

    <!-- Conteúdo dinâmico -->
    <div id="content">
        Selecione uma opção no menu para exibir o conteúdo.
    </div>
</body>
</html>
