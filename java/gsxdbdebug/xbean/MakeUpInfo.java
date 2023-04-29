package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MakeUpInfo
  extends Bean
{
  public abstract MakeUpInfo copy();
  
  public abstract MakeUpInfo toData();
  
  public abstract MakeUpInfo toBean();
  
  public abstract MakeUpInfo toDataIf();
  
  public abstract MakeUpInfo toBeanIf();
  
  public abstract Map<Integer, MakeUpRecord> getActivityid2record();
  
  public abstract Map<Integer, MakeUpRecord> getActivityid2recordAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MakeUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */