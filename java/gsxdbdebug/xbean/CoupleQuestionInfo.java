package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface CoupleQuestionInfo
  extends Bean
{
  public abstract CoupleQuestionInfo copy();
  
  public abstract CoupleQuestionInfo toData();
  
  public abstract CoupleQuestionInfo toBean();
  
  public abstract CoupleQuestionInfo toDataIf();
  
  public abstract CoupleQuestionInfo toBeanIf();
  
  public abstract List<Integer> getQuestionlist();
  
  public abstract List<Integer> getQuestionlistAsData();
  
  public abstract int getCurrentquestionidx();
  
  public abstract void setCurrentquestionidx(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CoupleQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */