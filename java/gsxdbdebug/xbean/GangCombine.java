package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface GangCombine
  extends Bean
{
  public abstract GangCombine copy();
  
  public abstract GangCombine toData();
  
  public abstract GangCombine toBean();
  
  public abstract GangCombine toDataIf();
  
  public abstract GangCombine toBeanIf();
  
  public abstract long getGangid();
  
  public abstract Set<Long> getApplicants();
  
  public abstract Set<Long> getApplicantsAsData();
  
  public abstract void setGangid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */