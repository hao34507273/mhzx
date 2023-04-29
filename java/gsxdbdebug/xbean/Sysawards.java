package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Sysawards
  extends Bean
{
  public abstract Sysawards copy();
  
  public abstract Sysawards toData();
  
  public abstract Sysawards toBean();
  
  public abstract Sysawards toDataIf();
  
  public abstract Sysawards toBeanIf();
  
  public abstract List<Long> getAwardids();
  
  public abstract List<Long> getAwardidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Sysawards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */