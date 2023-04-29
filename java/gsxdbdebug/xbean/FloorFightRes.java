package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FloorFightRes
  extends Bean
{
  public abstract FloorFightRes copy();
  
  public abstract FloorFightRes toData();
  
  public abstract FloorFightRes toBean();
  
  public abstract FloorFightRes toDataIf();
  
  public abstract FloorFightRes toBeanIf();
  
  public abstract List<String> getNames();
  
  public abstract List<String> getNamesAsData();
  
  public abstract int getKilltime();
  
  public abstract int getUsedtime();
  
  public abstract long getRadioid();
  
  public abstract void setKilltime(int paramInt);
  
  public abstract void setUsedtime(int paramInt);
  
  public abstract void setRadioid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FloorFightRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */