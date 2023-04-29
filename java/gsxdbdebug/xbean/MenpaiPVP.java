package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface MenpaiPVP
  extends Bean
{
  public abstract MenpaiPVP copy();
  
  public abstract MenpaiPVP toData();
  
  public abstract MenpaiPVP toBean();
  
  public abstract MenpaiPVP toDataIf();
  
  public abstract MenpaiPVP toBeanIf();
  
  public abstract Map<Integer, Long> getMenpai2world();
  
  public abstract Map<Integer, Long> getMenpai2worldAsData();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
  
  public abstract boolean getIsfinished();
  
  public abstract void setIsfinished(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenpaiPVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */