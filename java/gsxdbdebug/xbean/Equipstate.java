package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Equipstate
  extends Bean
{
  public abstract Equipstate copy();
  
  public abstract Equipstate toData();
  
  public abstract Equipstate toBean();
  
  public abstract Equipstate toDataIf();
  
  public abstract Equipstate toBeanIf();
  
  public abstract int getState();
  
  public abstract Map<Integer, Integer> getLevel2makecount();
  
  public abstract Map<Integer, Integer> getLevel2makecountAsData();
  
  public abstract Map<Integer, Integer> getEqpid2makecount();
  
  public abstract Map<Integer, Integer> getEqpid2makecountAsData();
  
  public abstract void setState(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Equipstate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */