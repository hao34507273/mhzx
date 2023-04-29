package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface GMInfo
  extends Bean
{
  public abstract GMInfo copy();
  
  public abstract GMInfo toData();
  
  public abstract GMInfo toBean();
  
  public abstract GMInfo toDataIf();
  
  public abstract GMInfo toBeanIf();
  
  public abstract Set<Integer> getSecurity();
  
  public abstract Set<Integer> getSecurityAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GMInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */