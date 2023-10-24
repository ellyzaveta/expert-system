# 👩‍⚕️ Expert system for the identification of respiratory tract disease based on symptoms

## 🪄 To run the app:
* Make sure Node.js and npm are installed on your computer.
* From the command line in the './frontend' folder, run the command 'npm install' to install all necessary dependencies.
* After installing the dependencies, build the project by running 'npm run build'.
* After launching the Spring Boot application, open a browser and go to the address 'http://localhost:8080' (or another port on which Spring Boot works by default).

<br />

![image](https://drive.google.com/uc?export=view&id=1DXsUJAFv7PFORPaRL9v9bugEZ5UrMHyC)
![image](https://drive.google.com/uc?export=view&id=1C46KW3a6E6G5DZoTHr6xXa4VVHoDx9SE)

<br />

## Decision tree

Based on the collected data, a decision tree of the expert system for diagnosing diseases of the respiratory tract was formed. Its structure is based on a hierarchical set of questions and answers, which ultimately leads the user to several possible diagnoses.

![image](https://drive.google.com/uc?export=view&id=1sdLKPyEVoJ10saxqqY8WR3UcFnu9btu3)

<br />

At the lowest level of the hierarchy are the leaf nodes of the tree (red hexagons), which indicate a specific diagnosis, for example: "Cold", "Sinusitis", "Viral infections", etc.

<br />

Each question node (blue rectangle) contains the text of the question and links to a set of corresponding answer nodes (yellow ovals), and each answer node, in turn, links to the next question.

<br />

There are also transitions to other branches on the branches of the tree (gray circles with the letter of the next question).

## Decision making algorithm

The system is designed to adapt to user responses in real time, offering more targeted questions.
The developed tree, in turn, ensures the placement of diagnoses with similar symptoms in one subtree. This approach allows you to present the final result as several diagnoses with different confidence coefficients.

<br />

When providing an answer to each question, all diagnoses located on the leaf nodes of the corresponding subtree with the root - the selected answer - receive 1 point.

<br />

For example, let the answer to the question M "Is there a pain in the throat" - No. The subtree with the root node as the answer "No" contains 3 leaf nodes - the diagnoses "Cold", "Sinusitis" and "Viral infections". For all three diseases there is no inherent pain in the throat and they receive 1 point each.

<br />

Thus, as a result, a table with diagnoses and points is formed, 3 diagnoses with the highest number of points are selected and the final result is formed, representing 3 diagnoses with different confidence coefficients.
