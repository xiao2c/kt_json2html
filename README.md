# Project
Java util to generate survey questions for kind types with Amazon Mechanical Turk.  
Freemarker template engine is used.  

# Requirement
Java version 1.8+ (e.g. java version "1.8.0_201")
Apache Maven 3.6+

# RUN
```
mvn exec:java -Dexec.args="/yourpath/updated_json_template_f.json"
```

# Result
Copy Html code between
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