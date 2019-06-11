Feature: Get book by ISBN
  Scenario: User calls web service to get a book by its ISBN
Given a book exists with an isbn of 9781451648546
When a user retrieves the book by isbn
Then the status code is 200
And The Response body contains an object in JSON format
