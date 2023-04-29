package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface CorpsHistory
  extends Bean
{
  public abstract CorpsHistory copy();
  
  public abstract CorpsHistory toData();
  
  public abstract CorpsHistory toBean();
  
  public abstract CorpsHistory toDataIf();
  
  public abstract CorpsHistory toBeanIf();
  
  public abstract int getRecordtime();
  
  public abstract int getHistorytype();
  
  public abstract List<String> getParameters();
  
  public abstract List<String> getParametersAsData();
  
  public abstract int getHistoryid();
  
  public abstract void setRecordtime(int paramInt);
  
  public abstract void setHistorytype(int paramInt);
  
  public abstract void setHistoryid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CorpsHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */