package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Bless
  extends Bean
{
  public abstract Bless copy();
  
  public abstract Bless toData();
  
  public abstract Bless toBean();
  
  public abstract Bless toDataIf();
  
  public abstract Bless toBeanIf();
  
  public abstract Map<Integer, BlessInfo> getBless_infos();
  
  public abstract Map<Integer, BlessInfo> getBless_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Bless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */