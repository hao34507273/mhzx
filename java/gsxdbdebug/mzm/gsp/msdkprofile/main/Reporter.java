package mzm.gsp.msdkprofile.main;

public abstract interface Reporter
{
  public abstract boolean reportScore(String paramString1, long paramLong, String paramString2);
  
  public abstract boolean reportRoleLevel(String paramString, long paramLong, int paramInt);
  
  public abstract boolean reportRoleCash(String paramString, long paramLong1, long paramLong2);
  
  public abstract boolean reportRoleRankScore(String paramString, long paramLong1, int paramInt, long paramLong2);
  
  public abstract boolean reportRoleLogin(String paramString, long paramLong);
  
  public abstract boolean reportRoleFightValue(String paramString, long paramLong, int paramInt);
  
  public abstract boolean reportRoleCreate(String paramString, long paramLong);
  
  public abstract boolean reportRoleName(String paramString, long paramLong);
  
  public abstract boolean reportRoleRecharge(String paramString, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract boolean reportRoleOnlineSeconds(String paramString, long paramLong, int paramInt);
  
  public abstract boolean reportGangName(String paramString1, long paramLong1, long paramLong2, String paramString2);
  
  public abstract boolean reportGangLevel(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract boolean reportGangCreate(String paramString, long paramLong1, long paramLong2);
  
  public abstract boolean reportGangDestory(String paramString, long paramLong1, long paramLong2);
  
  public abstract boolean reportGangMemberJoin(String paramString, long paramLong1, long paramLong2);
  
  public abstract boolean reportGangMemberExit(String paramString, long paramLong1, long paramLong2);
  
  public abstract boolean reportGangPositionChange(String paramString, long paramLong1, long paramLong2, int paramInt);
  
  public abstract boolean reportGangBindQQ(String paramString1, long paramLong1, long paramLong2, String paramString2);
  
  public abstract boolean reportGangMemberAbility(String paramString, long paramLong1, long paramLong2, int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\Reporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */