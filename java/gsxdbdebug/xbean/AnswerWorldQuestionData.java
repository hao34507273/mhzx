package xbean;

import xdb.Bean;

public abstract interface AnswerWorldQuestionData
  extends Bean
{
  public abstract AnswerWorldQuestionData copy();
  
  public abstract AnswerWorldQuestionData toData();
  
  public abstract AnswerWorldQuestionData toBean();
  
  public abstract AnswerWorldQuestionData toDataIf();
  
  public abstract AnswerWorldQuestionData toBeanIf();
  
  public abstract int getGetnbawardnum();
  
  public abstract long getUpdatetime();
  
  public abstract void setGetnbawardnum(int paramInt);
  
  public abstract void setUpdatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AnswerWorldQuestionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */