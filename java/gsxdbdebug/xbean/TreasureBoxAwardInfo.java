package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface TreasureBoxAwardInfo
  extends Bean
{
  public abstract TreasureBoxAwardInfo copy();
  
  public abstract TreasureBoxAwardInfo toData();
  
  public abstract TreasureBoxAwardInfo toBean();
  
  public abstract TreasureBoxAwardInfo toDataIf();
  
  public abstract TreasureBoxAwardInfo toBeanIf();
  
  public abstract Set<Long> getRoleidset();
  
  public abstract Set<Long> getRoleidsetAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TreasureBoxAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */