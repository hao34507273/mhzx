package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossbattleDrawLots
  extends Bean
{
  public abstract CrossbattleDrawLots copy();
  
  public abstract CrossbattleDrawLots toData();
  
  public abstract CrossbattleDrawLots toBean();
  
  public abstract CrossbattleDrawLots toDataIf();
  
  public abstract CrossbattleDrawLots toBeanIf();
  
  public abstract boolean getReported();
  
  public abstract Map<Long, DrawLotsZoneInfo> getCorps();
  
  public abstract Map<Long, DrawLotsZoneInfo> getCorpsAsData();
  
  public abstract void setReported(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossbattleDrawLots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */