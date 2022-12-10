Feature: Add New course

  Scenario Outline: As a User I need to add and publish a new course and validate that the course added successfully
    Given I login with "<email>" and "<password>"
    When Navigate to the courses Page
    And  Publish new course with basic info "<courseName>" , "<subject>" , "<gradeYearRange>" , "<teacherName>" , "<courseCompletionCriteria>"
    Then Validate That the "<courseName>" is displayed Successfully on the courses Page

    Examples:
      | email                | password   | courseName | subject | gradeYearRange | teacherName | courseCompletionCriteria |
      | testregister@aaa.com | Wakram_123 | Test1      | Others  | 1              | nada rehan  | Overall Assessments      |