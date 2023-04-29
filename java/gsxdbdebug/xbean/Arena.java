package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Arena
  extends Bean
{
  public abstract Arena copy();
  
  public abstract Arena toData();
  
  public abstract Arena toBean();
  
  public abstract Arena toDataIf();
  
  public abstract Arena toBeanIf();
  
  public abstract Map<Integer, Camp> getCamps();
  
  public abstract Map<Integer, Camp> getCampsAsData();
  
  public abstract boolean getFinished();
  
  public abstract void setFinished(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Arena.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */