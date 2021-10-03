# Assumptions:
  * All names are assumed to be unique and Single word and case sensitive. 
  * If person is not married ADD_CHILD will fail with the message "PERSON_NOT_MARRIED"
  * If mother is not present in tree ADD_CHILD will fail with the message "PERSON_NOT_FOUND"
  * If person is not present, GET_RELATIONSHIP will fail with the message "PERSON_NOT_FOUND"
  * If relationship is not present GET_RELATIONSHIP will display "NONE"


# How to Run:
  * From FamilyTree/target folder, run "java -jar geektrust.jar <InputFile>
  * Name of input file can be relative to FamilyTree/target or absolute.
  * Sample input file is found in src/test/resources/Input.txt
  * Initial tree is built once program runs. The src/main/resources/InitialTree.txt is the file.
  * To build jar file, run "mvn assembly:single test" from FamilyTree folder.

# Improvements to code by applying OOPS and design patterns to make it extensible:
  * Used command pattern and factory pattern for commands
  * Instead of printing everywhere, returned a string and print in single place.
  * Removed unnecessary male and female classes
  * Unit tests to ensure quality code. Made use of parameterized unit tests to avoid duplication of code.



