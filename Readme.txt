Assumptions:
1. All names are assumed to be unique and Single word and case sensitive. 
2. If person is not married ADD_CHILD will fail with the message "PERSON_NOT_MARRIED"
3. If mother is not present in tree ADD_CHILD will fail with the message "PERSON_NOT_FOUND"
3. If person is not present, GET_RELATIONSHIP will fail with the message "PERSON_NOT_FOUND"
4. If relationship is not present GET_RELATIONSHIP will display "NONE"


How to Run:
1. From FamilyTree/target folder, run "java -jar geektrust.jar <InputFile>
2. Name of input file can be relative to FamilyTree/target or absolute.
3. Sample input file is found in src/test/resources/Input.txt
4. Initial tree is built once program runs. The src/main/resources/InitialTree.txt is the file.
5. To build jar file, run "mvn assembly:single test" from FamilyTree folder.

Improvements to code by applying OOPS and design patterns to make it extensible:
1. Used command pattern and factory pattern for commands
2. Instead of printing everywhere, returned a string and print in single place.
3. Removed unnecessary male and female classes
4. Unit tests to ensure quality code. Made use of parameterized unit tests to avoid duplication of code.
5.


