package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFabaoSysInfo
  extends Bean
{
  public abstract RoleFabaoSysInfo copy();
  
  public abstract RoleFabaoSysInfo toData();
  
  public abstract RoleFabaoSysInfo toBean();
  
  public abstract RoleFabaoSysInfo toDataIf();
  
  public abstract RoleFabaoSysInfo toBeanIf();
  
  public abstract Map<Integer, Item> getFabaomap();
  
  public abstract Map<Integer, Item> getFabaomapAsData();
  
  public abstract Map<Integer, LongJing> getLongjingmap();
  
  public abstract Map<Integer, LongJing> getLongjingmapAsData();
  
  public abstract int getDisfabaotype();
  
  public abstract int getTransfercount();
  
  public abstract void setDisfabaotype(int paramInt);
  
  public abstract void setTransfercount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFabaoSysInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */