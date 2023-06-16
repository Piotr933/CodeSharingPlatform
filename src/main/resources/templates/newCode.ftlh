 <!DOCTYPE html>
<html>
  <head>
    <title> Create </title>
     <style>
       body {
           background-color:#3b2e2d;
       }
       p {
           color: red;
         }
       textarea {
                  border: 2px solid gray;  
                   background-color: #f0e0df;
       }  
     </style>
     <script>
       function send() {
       let object = {
        "code": document.getElementById("code_snippet").value,
        "time": parseInt(document.getElementById("time_restriction").value),
        "views": parseInt(document.getElementById("views_restriction").value)
        };
    
        let json = JSON.stringify(object);
    
        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);
    
        if (xhr.status == 200) {
        alert("Success!");
        }
}
     </script>
  </head>
  <body>
     <textarea id="code_snippet"> //write your code here... </textarea> <br><br>
     <p>Time restriction <input id="time_restriction" type="text"/> </p><br>
     <p>Views restriction <input id="views_restriction" type="text"/></p>
     <button id="send_snippet" type="submit" onclick="send()">Submit</button>.
  </body>
</html>
