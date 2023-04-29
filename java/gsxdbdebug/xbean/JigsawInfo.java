package xbean;

import java.util.List;
import mzm.gsp.paraselene.event.JigsawContext;
import xdb.Bean;

public abstract interface JigsawInfo
  extends Bean
{
  public abstract JigsawInfo copy();
  
  public abstract JigsawInfo toData();
  
  public abstract JigsawInfo toBean();
  
  public abstract JigsawInfo toDataIf();
  
  public abstract JigsawInfo toBeanIf();
  
  public abstract JigsawContext getContext();
  
  public abstract long getEndtime();
  
  public abstract int getCfgid();
  
  public abstract List<Long> getAllroleids();
  
  public abstract List<Long> getAllroleidsAsData();
  
  public abstract List<Long> getSucroleids();
  
  public abstract List<Long> getSucroleidsAsData();
  
  public abstract List<Long> getFailroleids();
  
  public abstract List<Long> getFailroleidsAsData();
  
  public abstract void setContext(JigsawContext paramJigsawContext);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setCfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JigsawInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */