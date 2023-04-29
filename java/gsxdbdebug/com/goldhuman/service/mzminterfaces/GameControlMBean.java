package com.goldhuman.service.mzminterfaces;

import java.util.Map;

public abstract interface GameControlMBean
{
  public abstract void shutdownGs(Integer paramInteger);
  
  public abstract void sendNotice(String paramString);
  
  public abstract void mailCompensate(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract long getRoleidByName(String paramString);
  
  public abstract String getRoleName(long paramLong);
  
  public abstract int changeRoleName(long paramLong, String paramString);
  
  public abstract void initserverlevelinfo(long paramLong, String paramString);
  
  public abstract long directBufferSize();
  
  public abstract void setPetPoint(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
  
  public abstract long outputDirectAllocation();
  
  public abstract int noneRealTimeTaskNumber();
  
  public abstract void wrnmmpkbdlb1(int paramInt);
  
  public abstract void wrnmmpkbdlb11(int paramInt);
  
  public abstract long getPetId(long paramLong);
  
  public abstract void addPetSkill(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void mailItemAward(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void mailItemAward(long paramLong, String paramString1, String paramString2, Map<Integer, Integer> paramMap);
  
  public abstract void loginThreshold(int paramInt);
  
  public abstract void maxOnline(int paramInt);
  
  public abstract void accountLimit(boolean paramBoolean);
  
  public abstract void GmAddGoldIngot(long paramLong, int paramInt);
  
  public abstract void GmAddyb(long paramLong1, long paramLong2);
  
  public abstract String GMsetzs(long paramLong, String paramString);
  
  public abstract void maxAccount(int paramInt);
  
  public abstract void reLoadAllXml();
  
  public abstract void reLoadAllBny();
  
  public abstract void maxTaskPerRole(int paramInt);
  
  public abstract void setRankDBTimer(int paramInt);
  
  public abstract int getMapMsgQueueSize();
  
  public abstract int getMapProtocolSendQueueSize();
  
  public abstract int getExcuteLoginQueueSize();
  
  public abstract void clearExcuteLoginQueue();
  
  public abstract void setOpenActivityGm(int paramInt, long paramLong);
  
  public abstract void GmAddExp(long paramLong, int paramInt);
  
  public abstract void GmAddGold(long paramLong, int paramInt);
  
  public abstract void GmAddSilver(long paramLong, int paramInt);
  
  public abstract void Gmsetlevel(long paramLong, int paramInt);
  
  public abstract void Gmcutexp(long paramLong, int paramInt);
  
  public abstract void addchengwei(long paramLong, int paramInt);
  
  public abstract void rmallpartner(long paramLong);
  
  public abstract void setbaoshidu(long paramLong, int paramInt);
  
  public abstract void atitle(long paramLong, int paramInt);
  
  public abstract void Divorce(long paramLong);
  
  public abstract void setganglevel(long paramLong, int paramInt);
  
  public abstract void setyinbi(long paramLong1, long paramLong2);
  
  public abstract void clearbag(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void AddGeniusPoint(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void closeRoleFight(long paramLong, boolean paramBoolean);
  
  public abstract void ClearHatchDays(long paramLong1, long paramLong2);
  
  public abstract void bidtalk(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract void winglevelto(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void AddEquip(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract void AddSkillNumPet(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void GmSetYuanshen(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void GmJail(long paramLong1, long paramLong2);
  
  public abstract void GmUnJail(long paramLong1, long paramLong2);
  
  public abstract void AddChildren(long paramLong, int paramInt);
  
  public abstract void Apartner(long paramLong, int paramInt);
  
  public abstract void addpoint(long paramLong, int paramInt);
  
  public abstract void setfightvalue(long paramLong, int paramInt);
  
  public abstract void resetmultioccupcd(long paramLong1, long paramLong2);
  
  public abstract void addgangmoney(long paramLong, int paramInt);
  
  public abstract void addgangvit(long paramLong, int paramInt);
  
  public abstract void addganggongxun(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void setsedata(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void Equipqilin(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void AddChildHealth(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void ResetPKTimes(long paramLong1, long paramLong2);
  
  public abstract void ClearChildTired(long paramLong1, long paramLong2);
  
  public abstract void cleardailycourse(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void FullCourse(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void GmSetBlessLevel(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void GetActivityState(long paramLong, int paramInt);
  
  public abstract void Lottery(long paramLong, int paramInt);
  
  public abstract void SetServerLevel(int paramInt, String paramString);
  
  public abstract void SetFeiSheng(long paramLong1, long paramLong2, int paramInt);
  
  public abstract void SetServerDate(String paramString, long paramLong);
  
  public abstract void KickOutUser(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void ResetMultiOccup(long paramLong1, long paramLong2);
  
  public abstract void ForbidRole(long paramLong, int paramInt, String paramString);
  
  public abstract void forbiduser(long paramLong, int paramInt, String paramString);
  
  public abstract void unforbiduser(long paramLong1, long paramLong2);
  
  public abstract void UnforbidRole(long paramLong1, long paramLong2);
  
  public abstract void unbidtalk(long paramLong1, long paramLong2);
  
  public abstract long getLevel(long paramLong);
  
  public abstract long getMoney(long paramLong);
  
  public abstract void CostBuyYuanBao(long paramLong1, long paramLong2);
  
  public abstract void setOnlineTime(int paramInt);
  
  public abstract void setOnlineItem(int paramInt1, int paramInt2);
  
  public abstract void setOnlineYuanbao(int paramInt);
  
  public abstract void deleteItem(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\com\goldhuman\service\mzminterfaces\GameControlMBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */