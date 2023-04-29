package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FactionMakeUpRecord
  extends Bean
{
  public abstract FactionMakeUpRecord copy();
  
  public abstract FactionMakeUpRecord toData();
  
  public abstract FactionMakeUpRecord toBean();
  
  public abstract FactionMakeUpRecord toDataIf();
  
  public abstract FactionMakeUpRecord toBeanIf();
  
  public abstract int getRightnum();
  
  public abstract List<Long> getJoinroleids();
  
  public abstract List<Long> getJoinroleidsAsData();
  
  public abstract int getQuestionid();
  
  public abstract int getCurturn();
  
  public abstract List<Integer> getHistoryquestions();
  
  public abstract List<Integer> getHistoryquestionsAsData();
  
  public abstract List<Integer> getOptionids();
  
  public abstract List<Integer> getOptionidsAsData();
  
  public abstract long getStarttime();
  
  public abstract void setRightnum(int paramInt);
  
  public abstract void setQuestionid(int paramInt);
  
  public abstract void setCurturn(int paramInt);
  
  public abstract void setStarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionMakeUpRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */