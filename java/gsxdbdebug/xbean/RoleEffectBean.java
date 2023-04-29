package xbean;

import java.util.Set;
import mzm.gsp.effect.main.OutFightEffect;
import xdb.Bean;

public abstract interface RoleEffectBean
  extends Bean
{
  public abstract RoleEffectBean copy();
  
  public abstract RoleEffectBean toData();
  
  public abstract RoleEffectBean toBean();
  
  public abstract RoleEffectBean toDataIf();
  
  public abstract RoleEffectBean toBeanIf();
  
  public abstract Set<OutFightEffect> getEffectset();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleEffectBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */