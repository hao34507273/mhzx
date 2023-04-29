package xbean;

import java.util.List;
import java.util.Set;
import xdb.Bean;

public abstract interface QYXTQuestionInfo
  extends Bean
{
  public abstract QYXTQuestionInfo copy();
  
  public abstract QYXTQuestionInfo toData();
  
  public abstract QYXTQuestionInfo toBean();
  
  public abstract QYXTQuestionInfo toDataIf();
  
  public abstract QYXTQuestionInfo toBeanIf();
  
  public abstract int getRightnum();
  
  public abstract Set<Integer> getSeek_help_questions();
  
  public abstract Set<Integer> getSeek_help_questionsAsData();
  
  public abstract Set<Long> getCurrent_help_roleids();
  
  public abstract Set<Long> getCurrent_help_roleidsAsData();
  
  public abstract List<Integer> getQuestions();
  
  public abstract List<Integer> getQuestionsAsData();
  
  public abstract int getCurrent_force_answer_index();
  
  public abstract void setRightnum(int paramInt);
  
  public abstract void setCurrent_force_answer_index(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QYXTQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */