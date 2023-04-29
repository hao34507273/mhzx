package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface HanhunInfo
  extends Bean
{
  public abstract HanhunInfo copy();
  
  public abstract HanhunInfo toData();
  
  public abstract HanhunInfo toBean();
  
  public abstract HanhunInfo toDataIf();
  
  public abstract HanhunInfo toBeanIf();
  
  public abstract Map<Integer, ItemInfo> getIteminfos();
  
  public abstract Map<Integer, ItemInfo> getIteminfosAsData();
  
  public abstract int getStatus();
  
  public abstract int getSeekhelpleftcount();
  
  public abstract int getHelpotherleftcount();
  
  public abstract List<Long> getGuyshelpyou();
  
  public abstract List<Long> getGuyshelpyouAsData();
  
  public abstract long getTimeout();
  
  public abstract Map<Integer, ItemInfo> getIteminfosnext();
  
  public abstract Map<Integer, ItemInfo> getIteminfosnextAsData();
  
  public abstract boolean getAlreadygettask();
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setSeekhelpleftcount(int paramInt);
  
  public abstract void setHelpotherleftcount(int paramInt);
  
  public abstract void setTimeout(long paramLong);
  
  public abstract void setAlreadygettask(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HanhunInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */