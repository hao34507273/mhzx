package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface SwornKickOut
  extends Bean
{
  public abstract SwornKickOut copy();
  
  public abstract SwornKickOut toData();
  
  public abstract SwornKickOut toBean();
  
  public abstract SwornKickOut toDataIf();
  
  public abstract SwornKickOut toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getKickoutid();
  
  public abstract long getVerifytime();
  
  public abstract List<Long> getVerifyids();
  
  public abstract List<Long> getVerifyidsAsData();
  
  public abstract List<Long> getAgreevoteids();
  
  public abstract List<Long> getAgreevoteidsAsData();
  
  public abstract List<Long> getNotagreevoteids();
  
  public abstract List<Long> getNotagreevoteidsAsData();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setKickoutid(long paramLong);
  
  public abstract void setVerifytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SwornKickOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */