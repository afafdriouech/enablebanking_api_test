# EnableBanking Tilisy API
A Spring boot console application integrating the Tilisy API: https://enablebanking.com/docs/tilisy/latest/#tilisy-api  
   - To run the application, use this command: mvnw spring-boot:run  
   - A list of available banks will be displayed on the console  
   - Select a bank, an authorization URL will be returned. Use the link to authorize. After authorizing you will be redirected with an authentication code.
   - Enter the code on the command line. A summary of the user's bank transactions will be returned.  
![banks](banks.PNG)
![commands](commands.PNG)
