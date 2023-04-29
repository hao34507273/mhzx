package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FactionMakeUpInfo
  extends Bean
{
  public abstract FactionMakeUpInfo copy();
  
  public abstract FactionMakeUpInfo toData();
  
  public abstract FactionMakeUpInfo toBean();
  
  public abstract FactionMakeUpInfo toDataIf();
  
  public abstract FactionMakeUpInfo toBeanIf();
  
  public abstract Map<Integer, FactionMakeUpRecord> getActivityid2record();
  
  public abstract Map<Integer, FactionMakeUpRecord> getActivityid2recordAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionMakeUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */