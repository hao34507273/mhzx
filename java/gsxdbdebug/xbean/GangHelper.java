package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GangHelper
  extends Bean
{
  public abstract GangHelper copy();
  
  public abstract GangHelper toData();
  
  public abstract GangHelper toBean();
  
  public abstract GangHelper toDataIf();
  
  public abstract GangHelper toBeanIf();
  
  public abstract long getUid();
  
  public abstract long getRoleid();
  
  public abstract int getHelpertype();
  
  public abstract Map<Integer, Integer> getIntmap();
  
  public abstract Map<Integer, Integer> getIntmapAsData();
  
  public abstract void setUid(long paramLong);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setHelpertype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */