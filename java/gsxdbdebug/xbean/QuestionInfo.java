package xbean;

import xdb.Bean;

public abstract interface QuestionInfo
  extends Bean
{
  public abstract QuestionInfo copy();
  
  public abstract QuestionInfo toData();
  
  public abstract QuestionInfo toBean();
  
  public abstract QuestionInfo toDataIf();
  
  public abstract QuestionInfo toBeanIf();
  
  public abstract EveryDayQuestionAnswerInfo getEverydayinfo();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */