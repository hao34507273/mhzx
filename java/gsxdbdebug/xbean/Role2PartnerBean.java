package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2PartnerBean
  extends Bean
{
  public abstract Role2PartnerBean copy();
  
  public abstract Role2PartnerBean toData();
  
  public abstract Role2PartnerBean toBean();
  
  public abstract Role2PartnerBean toDataIf();
  
  public abstract Role2PartnerBean toBeanIf();
  
  public abstract Map<Integer, PartnerOutFightBean> getBeanmap();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2PartnerBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */