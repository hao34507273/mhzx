package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MagicMarkSys
  extends Bean
{
  public abstract MagicMarkSys copy();
  
  public abstract MagicMarkSys toData();
  
  public abstract MagicMarkSys toBean();
  
  public abstract MagicMarkSys toDataIf();
  
  public abstract MagicMarkSys toBeanIf();
  
  public abstract int getEuqipedmagicmarktype();
  
  public abstract int getPropmagicmarktype();
  
  public abstract Map<Integer, MagicMarkInfo> getMagicmarkinfos();
  
  public abstract Map<Integer, MagicMarkInfo> getMagicmarkinfosAsData();
  
  public abstract void setEuqipedmagicmarktype(int paramInt);
  
  public abstract void setPropmagicmarktype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MagicMarkSys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */