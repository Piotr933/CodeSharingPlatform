<html lang="en">
  <head>
    <title>Latest</title>
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
    pre {
          border: 2px solid gray;
          background-color: #f0e0df;
         }
</style>
  <body>
    <table>
      <#list codes as code>
        <span id="load_date"> ${code.date} </span>
        <pre id="code_snippet"> <code> ${code.content} </code> </pre>
      </#list>
    </table>
  </body>
</html>




