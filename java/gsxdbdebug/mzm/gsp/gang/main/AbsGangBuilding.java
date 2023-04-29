/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.gang.SSyncBuildingLevelUpDonate;
/*     */ import mzm.gsp.gang.SSyncBuildingLevelUpSuccess;
/*     */ import mzm.gsp.gang.SSyncBuildingStartLevelUp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.Gang;
/*     */ import xbean.JinKu;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsGangBuilding
/*     */ {
/*     */   protected long gangId;
/*     */   protected Gang xGang;
/*     */   protected int buildingType;
/*  25 */   private static Map<Long, Map<Integer, GangBuildingLevelUpObserver>> observerMap = new ConcurrentHashMap();
/*     */   
/*     */   public AbsGangBuilding(long gangId, int buildingType, Gang xGang) {
/*  28 */     this.gangId = gangId;
/*  29 */     this.xGang = xGang;
/*  30 */     this.buildingType = buildingType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void init()
/*     */   {
/*  37 */     long endTime = getLevelUpEndTime();
/*  38 */     if (endTime > 0L) {
/*  39 */       GangBuildingLevelUpObserver observer = new GangBuildingLevelUpObserver(endTime, this.gangId, this.buildingType);
/*  40 */       setObserver(observer); } }
/*     */   
/*     */   public abstract long getLevelUpEndTime();
/*     */   
/*     */   public abstract int getLevelUpNeedMoney();
/*     */   
/*     */   public abstract int getMaintainMoney();
/*     */   
/*     */   abstract void onGanglevelDown();
/*     */   public abstract int getLevel();
/*     */   public abstract boolean isMaxLv();
/*  51 */   protected boolean canLevelUp() { return true; }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   final boolean startLevelUp(long roleId)
/*     */   {
/*  60 */     if (!canLevelUp()) {
/*  61 */       return false;
/*     */     }
/*  63 */     int needMoney = getLevelUpNeedMoney();
/*  64 */     int removeMoney = this.xGang.getJinku().getGangmoney() - needMoney;
/*  65 */     if (removeMoney < 0) {
/*  66 */       return false;
/*     */     }
/*  68 */     this.xGang.getJinku().setGangmoney(removeMoney);
/*  69 */     long endTime = DateTimeUtils.getCurrTimeInMillis() + TimeUnit.MINUTES.toMillis(getLevelUpNeedTimeMInCfg());
/*  70 */     GangBuildingLevelUpObserver observer = new GangBuildingLevelUpObserver(endTime, this.gangId, this.buildingType);
/*  71 */     setObserver(observer);
/*  72 */     setLevelupendtime(endTime);
/*  73 */     brocadcastStartLevelUp(roleId, removeMoney);
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   void setObserver(GangBuildingLevelUpObserver observer) {
/*  78 */     Map<Integer, GangBuildingLevelUpObserver> map = (Map)observerMap.get(Long.valueOf(this.gangId));
/*  79 */     if (map == null) {
/*  80 */       map = new ConcurrentHashMap();
/*  81 */       observerMap.put(Long.valueOf(this.gangId), map);
/*     */     }
/*  83 */     map.put(Integer.valueOf(this.buildingType), observer);
/*     */   }
/*     */   
/*     */   void stopObserver() {
/*  87 */     Map<Integer, GangBuildingLevelUpObserver> map = (Map)observerMap.get(Long.valueOf(this.gangId));
/*  88 */     if (map == null) {
/*  89 */       return;
/*     */     }
/*  91 */     GangBuildingLevelUpObserver observer = (GangBuildingLevelUpObserver)map.remove(Integer.valueOf(this.buildingType));
/*  92 */     if (observer == null) {
/*  93 */       return;
/*     */     }
/*  95 */     observer.stopTimer();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   final boolean donate(long roleId, int donateLv)
/*     */   {
/* 105 */     long removeMinute = GangManager.donateForBuilding(donateLv, roleId);
/* 106 */     if (removeMinute < 0L) {
/* 107 */       return false;
/*     */     }
/* 109 */     stopObserver();
/* 110 */     long newEndTime = getLevelUpEndTime() - TimeUnit.MINUTES.toMillis(removeMinute);
/* 111 */     setLevelupendtime(newEndTime);
/* 112 */     setObserver(new GangBuildingLevelUpObserver(newEndTime, this.gangId, this.buildingType));
/* 113 */     brocadcastDonate(roleId, donateLv);
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   final boolean levelUpAction() {
/* 118 */     setLevelupendtime(0L);
/* 119 */     setLevel(getLevel() + 1);
/* 120 */     brocadcastLevelUp();
/* 121 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   abstract int getLevelUpNeedTimeMInCfg();
/*     */   
/*     */ 
/*     */ 
/*     */   abstract void setLevelupendtime(long paramLong);
/*     */   
/*     */ 
/*     */ 
/*     */   abstract void setLevel(int paramInt);
/*     */   
/*     */ 
/*     */   final void brocadcastStartLevelUp(long roleId, int curMoney)
/*     */   {
/* 139 */     SSyncBuildingStartLevelUp sSyncBuildingStartLevelUp = new SSyncBuildingStartLevelUp();
/* 140 */     sSyncBuildingStartLevelUp.buildingtype = this.buildingType;
/* 141 */     sSyncBuildingStartLevelUp.roleid = roleId;
/* 142 */     sSyncBuildingStartLevelUp.endtime = ((int)TimeUnit.MILLISECONDS.toSeconds(getLevelUpEndTime()));
/* 143 */     sSyncBuildingStartLevelUp.gangmoney = curMoney;
/* 144 */     OnlineManager.getInstance().sendMulti(sSyncBuildingStartLevelUp, GangManager.getMembers(this.xGang));
/*     */   }
/*     */   
/*     */   final void brocadcastDonate(long roleId, int lv) {
/* 148 */     SSyncBuildingLevelUpDonate sSyncBuildingLevelUpDonate = new SSyncBuildingLevelUpDonate();
/* 149 */     sSyncBuildingLevelUpDonate.buildingtype = this.buildingType;
/* 150 */     sSyncBuildingLevelUpDonate.roleid = roleId;
/* 151 */     sSyncBuildingLevelUpDonate.donatelv = lv;
/* 152 */     sSyncBuildingLevelUpDonate.endtime = ((int)TimeUnit.MILLISECONDS.toSeconds(getLevelUpEndTime()));
/* 153 */     OnlineManager.getInstance().sendMulti(sSyncBuildingLevelUpDonate, GangManager.getMembers(this.xGang));
/*     */   }
/*     */   
/*     */   final void brocadcastLevelUp() {
/* 157 */     SSyncBuildingLevelUpSuccess sSyncBuildingLevelUpSuccess = new SSyncBuildingLevelUpSuccess();
/* 158 */     sSyncBuildingLevelUpSuccess.buildingtype = this.buildingType;
/* 159 */     sSyncBuildingLevelUpSuccess.level = getLevel();
/* 160 */     OnlineManager.getInstance().sendMulti(sSyncBuildingLevelUpSuccess, GangManager.getMembers(this.xGang));
/*     */     
/* 162 */     if (this.buildingType == 4) {
/* 163 */       if (null == this.xGang) {
/* 164 */         return;
/*     */       }
/*     */       
/* 167 */       long bangzhuid = this.xGang.getBangzhuid();
/* 168 */       int gangLevel = this.xGang.getLevel();
/* 169 */       long gangid = this.gangId;
/* 170 */       long gangDisplayId = this.xGang.getDisplayid();
/*     */       
/* 172 */       Procedure.execute(new PGangLevelUpTlog(gangid, bangzhuid, gangLevel, gangDisplayId));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\AbsGangBuilding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */