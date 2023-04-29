package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MassWeddingBless
  extends Bean
{
  public abstract MassWeddingBless copy();
  
  public abstract MassWeddingBless toData();
  
  public abstract MassWeddingBless toBean();
  
  public abstract MassWeddingBless toDataIf();
  
  public abstract MassWeddingBless toBeanIf();
  
  public abstract Map<Long, BlessRoles> getBlessmap();
  
  public abstract Map<Long, BlessRoles> getBlessmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingBless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */