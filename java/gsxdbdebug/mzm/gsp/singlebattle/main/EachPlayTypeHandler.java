package mzm.gsp.singlebattle.main;

public abstract interface EachPlayTypeHandler
{
  public abstract void onBattleStart(long paramLong, int paramInt);
  
  public abstract void onRoleJoinBattle(long paramLong1, int paramInt, long paramLong2);
  
  public abstract void onMatchStart(long paramLong, int paramInt);
  
  public abstract int getPoint(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean);
  
  public abstract void onMatchEnd(long paramLong, int paramInt);
  
  public abstract void onStartClean(long paramLong, int paramInt);
  
  public abstract void onBattleEnd(long paramLong, int paramInt);
  
  public abstract void onRoleQuitBattle(long paramLong1, int paramInt, long paramLong2, SingleBattleInterface.LeaveBattleReason paramLeaveBattleReason);
  
  public abstract boolean canFight(long paramLong1, int paramInt, long paramLong2, long paramLong3);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\EachPlayTypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */