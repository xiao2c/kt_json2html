# kt_json2html
Java util to generate survey questions for kind types with Amazon Mechanical Turk.  
Freemarker template engine is used.  
  
# RUN
```
mvn exec:java -Dexec.args="/path/updated_json_template_f.json"
```

# Result
Copy Html between
```
"==== HTML Start ====" and "==== HTML End ====". 
```
Paste to HIT.html replace code between
```
"<!-- Start java generated html -->" and "<!-- End java generated html -->"
```
Copy json data
```
const allKindTypes =

[ ... ]
```
Paste to HIT.html replace json data for
```
const allKindTypes = [...];
```