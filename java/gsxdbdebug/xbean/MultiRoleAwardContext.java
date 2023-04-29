package xbean;

import mzm.gsp.award.main.MultiRoleSelectAwardContext;
import xdb.Bean;

public abstract interface MultiRoleAwardContext
  extends Bean
{
  public abstract MultiRoleAwardContext copy();
  
  public abstract MultiRoleAwardContext toData();
  
  public abstract MultiRoleAwardContext toBean();
  
  public abstract MultiRoleAwardContext toDataIf();
  
  public abstract MultiRoleAwardContext toBeanIf();
  
  public abstract MultiRoleSelectAwardContext getContext();
  
  public abstract void setContext(MultiRoleSelectAwardContext paramMultiRoleSelectAwardContext);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiRoleAwardContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */