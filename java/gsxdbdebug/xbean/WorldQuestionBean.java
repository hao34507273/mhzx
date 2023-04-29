package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface WorldQuestionBean
  extends Bean
{
  public abstract WorldQuestionBean copy();
  
  public abstract WorldQuestionBean toData();
  
  public abstract WorldQuestionBean toBean();
  
  public abstract WorldQuestionBean toDataIf();
  
  public abstract WorldQuestionBean toBeanIf();
  
  public abstract List<WAwardBean> getRoleawarddata();
  
  public abstract List<WAwardBean> getRoleawarddataAsData();
  
  public abstract boolean getGoing();
  
  public abstract long getLasttime();
  
  public abstract long getNexttime();
  
  public abstract int getQuestionid();
  
  public abstract List<Integer> getOldquestionids();
  
  public abstract List<Integer> getOldquestionidsAsData();
  
  public abstract void setGoing(boolean paramBoolean);
  
  public abstract void setLasttime(long paramLong);
  
  public abstract void setNexttime(long paramLong);
  
  public abstract void setQuestionid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldQuestionBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */