package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface GangGlobal
  extends Bean
{
  public abstract GangGlobal copy();
  
  public abstract GangGlobal toData();
  
  public abstract GangGlobal toBean();
  
  public abstract GangGlobal toDataIf();
  
  public abstract GangGlobal toBeanIf();
  
  public abstract Set<Long> getAllgangids();
  
  public abstract Set<Long> getAllgangidsAsData();
  
  public abstract Map<CombiningGangsKey, CombineGangsInfo> getCombine();
  
  public abstract Map<CombiningGangsKey, CombineGangsInfo> getCombineAsData();
  
  public abstract long getNextdisplayid();
  
  public abstract void setNextdisplayid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */