package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface HulaInfo
  extends Bean
{
  public abstract HulaInfo copy();
  
  public abstract HulaInfo toData();
  
  public abstract HulaInfo toBean();
  
  public abstract HulaInfo toDataIf();
  
  public abstract HulaInfo toBeanIf();
  
  public abstract int getPoint();
  
  public abstract Map<Integer, Integer> getDelete_type_2_count();
  
  public abstract Map<Integer, Integer> getDelete_type_2_countAsData();
  
  public abstract Map<Integer, Integer> getKill_monsterid_2_count();
  
  public abstract Map<Integer, Integer> getKill_monsterid_2_countAsData();
  
  public abstract long getWorldid();
  
  public abstract Map<Integer, Integer> getDelete_monsterid_2_count();
  
  public abstract Map<Integer, Integer> getDelete_monsterid_2_countAsData();
  
  public abstract int getTurnpoint();
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setWorldid(long paramLong);
  
  public abstract void setTurnpoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HulaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */