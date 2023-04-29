package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Role2ChristmasStockingInfo
  extends Bean
{
  public abstract Role2ChristmasStockingInfo copy();
  
  public abstract Role2ChristmasStockingInfo toData();
  
  public abstract Role2ChristmasStockingInfo toBean();
  
  public abstract Role2ChristmasStockingInfo toDataIf();
  
  public abstract Role2ChristmasStockingInfo toBeanIf();
  
  public abstract Map<Integer, ChristmasTreePositionInfo> getChristmastreepositionindex2info();
  
  public abstract Map<Integer, ChristmasTreePositionInfo> getChristmastreepositionindex2infoAsData();
  
  public abstract Map<Long, Integer> getTargetroleid2selfhangnum();
  
  public abstract Map<Long, Integer> getTargetroleid2selfhangnumAsData();
  
  public abstract List<HangStockingHistoryInfo> getHangstockinghistoryinfos();
  
  public abstract List<HangStockingHistoryInfo> getHangstockinghistoryinfosAsData();
  
  public abstract int getGetstockinghidingawardnum();
  
  public abstract boolean getHasgotstockinghidingmail();
  
  public abstract void setGetstockinghidingawardnum(int paramInt);
  
  public abstract void setHasgotstockinghidingmail(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2ChristmasStockingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */