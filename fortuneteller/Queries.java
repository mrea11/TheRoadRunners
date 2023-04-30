package fortuneteller;

public class Queries
{
   private String question;
   private String answer;
   
   public Queries(String question, String answer)
   {
      super();
      this.question = question;
      this.answer = answer;
   }   
      
      public String getQuestion()
      {
         return question;
      }
      
      public String getAnswer()
      {
         return answer;
      }
      
      public void setQuestion(String question)
      {
         this.question = question;
      }
      
      public void setAnswer(String answer)
      {
         this.answer = answer;
      }
}