package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FlowerParadeHistory
  extends Bean
{
  public abstract FlowerParadeHistory copy();
  
  public abstract FlowerParadeHistory toData();
  
  public abstract FlowerParadeHistory toBean();
  
  public abstract FlowerParadeHistory toDataIf();
  
  public abstract FlowerParadeHistory toBeanIf();
  
  public abstract List<Long> getHistoryroles();
  
  public abstract List<Long> getHistoryrolesAsData();
  
  public abstract List<Integer> getHistoryocpids();
  
  public abstract List<Integer> getHistoryocpidsAsData();
  
  public abstract List<Integer> getHistorymapids();
  
  public abstract List<Integer> getHistorymapidsAsData();
  
  public abstract long getParadeindex();
  
  public abstract void setParadeindex(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FlowerParadeHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */