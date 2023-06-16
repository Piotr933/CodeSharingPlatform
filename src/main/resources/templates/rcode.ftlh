<html lang="en">
  <head>
    <title>Code</title>
    <link rel="stylesheet"
           href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
  </head>
  <style>
    body {
         background-color:#3b2e2d;
      }
     #load_date {
              color: green;
             }
     #views_restriction, #time_restriction {
              font-family: Lucida Console;
              color: #DC3B3B;
             }
    pre {
          border: 2px solid gray;
          background-color: #f0e0df;
         }
  </style>
  <body>
    <span id="load_date"> ${code.date} </span><br>
    <span id="views_restriction"> ${code.views} more views allowed </span><br>
    <span id="time_restriction"> The code will be available for ${code.time} seconds </span>
    <pre id="code_snippet"><code> ${code.content} </code></pre>
  </body>
</html>