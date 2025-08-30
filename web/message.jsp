<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flash Message</title>
    </head>
    <body>
        <%
            String msg = (String) session.getAttribute("msg");
            String error = (String) session.getAttribute("error");
            if(msg != null){ 
        %>
            <p id="flashMsg" style="color:green; text-align:center;"><%= msg %></p>
        <%
                session.removeAttribute("msg");
            } else if(error != null){
        %>
            <p id="flashMsg" style="color:red; text-align:center;"><%= error %></p>
        <%
                session.removeAttribute("error");
            }
        %>

        <script>
            setTimeout(function(){
                var flash = document.getElementById("flashMsg");
                if(flash){
                    flash.style.display = "none";
                }
            }, 3000);
        </script>
    </body>
</html>
