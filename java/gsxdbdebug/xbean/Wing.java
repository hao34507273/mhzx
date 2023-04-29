package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Wing
  extends Bean
{
  public abstract Wing copy();
  
  public abstract Wing toData();
  
  public abstract Wing toBean();
  
  public abstract Wing toDataIf();
  
  public abstract Wing toBeanIf();
  
  public abstract List<WingInfo> getWinglist();
  
  public abstract List<WingInfo> getWinglistAsData();
  
  public abstract int getCurindex();
  
  public abstract boolean getIsshowwing();
  
  public abstract void setCurindex(int paramInt);
  
  public abstract void setIsshowwing(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Wing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */