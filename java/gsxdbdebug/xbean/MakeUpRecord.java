package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MakeUpRecord
  extends Bean
{
  public abstract MakeUpRecord copy();
  
  public abstract MakeUpRecord toData();
  
  public abstract MakeUpRecord toBean();
  
  public abstract MakeUpRecord toDataIf();
  
  public abstract MakeUpRecord toBeanIf();
  
  public abstract Map<Integer, Integer> getTurn2optionid();
  
  public abstract Map<Integer, Integer> getTurn2optionidAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MakeUpRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */