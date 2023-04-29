package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RolePetFightFormation
  extends Bean
{
  public abstract RolePetFightFormation copy();
  
  public abstract RolePetFightFormation toData();
  
  public abstract RolePetFightFormation toBean();
  
  public abstract RolePetFightFormation toDataIf();
  
  public abstract RolePetFightFormation toBeanIf();
  
  public abstract Map<Integer, PetFightFormationInfo> getFormation_info();
  
  public abstract Map<Integer, PetFightFormationInfo> getFormation_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePetFightFormation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */