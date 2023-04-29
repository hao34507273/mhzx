package xbean;

import java.util.Map;
import mzm.gsp.util.LogicProcedure;
import xdb.Bean;

public abstract interface Role2PetBean
  extends Bean
{
  public abstract Role2PetBean copy();
  
  public abstract Role2PetBean toData();
  
  public abstract Role2PetBean toBean();
  
  public abstract Role2PetBean toDataIf();
  
  public abstract Role2PetBean toBeanIf();
  
  public abstract Map<Long, PetOutFightBean> getBeanmap();
  
  public abstract LogicProcedure getAction();
  
  public abstract void setAction(LogicProcedure paramLogicProcedure);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2PetBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */