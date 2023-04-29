package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MultiRoleAwards
  extends Bean
{
  public abstract MultiRoleAwards copy();
  
  public abstract MultiRoleAwards toData();
  
  public abstract MultiRoleAwards toBean();
  
  public abstract MultiRoleAwards toDataIf();
  
  public abstract MultiRoleAwards toBeanIf();
  
  public abstract List<Long> getAwards();
  
  public abstract List<Long> getAwardsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiRoleAwards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */