package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface FlowerParade
  extends Bean
{
  public static final int ARRIVED_REST = 0;
  public static final int MOVING_TO = 1;
  
  public abstract FlowerParade copy();
  
  public abstract FlowerParade toData();
  
  public abstract FlowerParade toBean();
  
  public abstract FlowerParade toDataIf();
  
  public abstract FlowerParade toBeanIf();
  
  public abstract List<Long> getRoles();
  
  public abstract List<Long> getRolesAsData();
  
  public abstract int getOcpid();
  
  public abstract int getMapid();
  
  public abstract int getDanceindex();
  
  public abstract int getToposindex();
  
  public abstract Map<Long, Long> getFollowtimestart();
  
  public abstract Map<Long, Long> getFollowtimestartAsData();
  
  public abstract int getState();
  
  public abstract long getSessionidrest();
  
  public abstract long getSessionidcountdown();
  
  public abstract long getFlowerinstanceid();
  
  public abstract Set<Long> getFlowerroleiddoneset();
  
  public abstract Set<Long> getFlowerroleiddonesetAsData();
  
  public abstract long getStarttimeinsec();
  
  public abstract long getSessionidstopcountdown();
  
  public abstract long getParadeindex();
  
  public abstract void setOcpid(int paramInt);
  
  public abstract void setMapid(int paramInt);
  
  public abstract void setDanceindex(int paramInt);
  
  public abstract void setToposindex(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void setSessionidrest(long paramLong);
  
  public abstract void setSessionidcountdown(long paramLong);
  
  public abstract void setFlowerinstanceid(long paramLong);
  
  public abstract void setStarttimeinsec(long paramLong);
  
  public abstract void setSessionidstopcountdown(long paramLong);
  
  public abstract void setParadeindex(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FlowerParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */