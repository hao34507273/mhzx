package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface EveryDayQuestionAnswerInfo
  extends Bean
{
  public abstract EveryDayQuestionAnswerInfo copy();
  
  public abstract EveryDayQuestionAnswerInfo toData();
  
  public abstract EveryDayQuestionAnswerInfo toBean();
  
  public abstract EveryDayQuestionAnswerInfo toDataIf();
  
  public abstract EveryDayQuestionAnswerInfo toBeanIf();
  
  public abstract List<Integer> getQuestionlist();
  
  public abstract List<Integer> getQuestionlistAsData();
  
  public abstract int getCurrentquestionidx();
  
  public abstract int getCurrentanswerpageidx();
  
  public abstract int getUsehelpnum();
  
  public abstract long getAwardmoney();
  
  public abstract int getAwardexp();
  
  public abstract int getRightnum();
  
  public abstract void setCurrentquestionidx(int paramInt);
  
  public abstract void setCurrentanswerpageidx(int paramInt);
  
  public abstract void setUsehelpnum(int paramInt);
  
  public abstract void setAwardmoney(long paramLong);
  
  public abstract void setAwardexp(int paramInt);
  
  public abstract void setRightnum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\EveryDayQuestionAnswerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */