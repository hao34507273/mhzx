package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleConstellation
  extends Bean
{
  public abstract RoleConstellation copy();
  
  public abstract RoleConstellation toData();
  
  public abstract RoleConstellation toBean();
  
  public abstract RoleConstellation toDataIf();
  
  public abstract RoleConstellation toBeanIf();
  
  public abstract Map<Integer, Integer> getAward_constellations();
  
  public abstract Map<Integer, Integer> getAward_constellationsAsData();
  
  public abstract int getSet_times();
  
  public abstract int getConstellation();
  
  public abstract int getSum_exp();
  
  public abstract void setSet_times(int paramInt);
  
  public abstract void setConstellation(int paramInt);
  
  public abstract void setSum_exp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleConstellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */