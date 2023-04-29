package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface BattleMountsInfo
  extends Bean
{
  public abstract BattleMountsInfo copy();
  
  public abstract BattleMountsInfo toData();
  
  public abstract BattleMountsInfo toBean();
  
  public abstract BattleMountsInfo toDataIf();
  
  public abstract BattleMountsInfo toBeanIf();
  
  public abstract long getMounts_id();
  
  public abstract List<Long> getProtect_pet_id_list();
  
  public abstract List<Long> getProtect_pet_id_listAsData();
  
  public abstract void setMounts_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BattleMountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */