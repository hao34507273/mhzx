package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TreasureBoxExpInfo
  extends Bean
{
  public abstract TreasureBoxExpInfo copy();
  
  public abstract TreasureBoxExpInfo toData();
  
  public abstract TreasureBoxExpInfo toBean();
  
  public abstract TreasureBoxExpInfo toDataIf();
  
  public abstract TreasureBoxExpInfo toBeanIf();
  
  public abstract Map<Long, Long> getRoleid2getexptime();
  
  public abstract Map<Long, Long> getRoleid2getexptimeAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TreasureBoxExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */