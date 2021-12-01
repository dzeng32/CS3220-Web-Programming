
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driving Test</title>
</head>
<body>
${questions[index].description} <br>
1.${questions[index].answerA} <br>
2.${questions[index].answerB} <br>
3.${questions[index].answerC} <br>
Correct Answer: ${questions[index].correctAnswer} <br>
<a href="DrivingTestBrowser?index=${index+1}">Next</a>
</body>
</html>