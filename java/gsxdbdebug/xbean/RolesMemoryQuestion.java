package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RolesMemoryQuestion
  extends Bean
{
  public abstract RolesMemoryQuestion copy();
  
  public abstract RolesMemoryQuestion toData();
  
  public abstract RolesMemoryQuestion toBean();
  
  public abstract RolesMemoryQuestion toDataIf();
  
  public abstract RolesMemoryQuestion toBeanIf();
  
  public abstract List<MemoryQuestion> getQuestion_list();
  
  public abstract List<MemoryQuestion> getQuestion_listAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolesMemoryQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */