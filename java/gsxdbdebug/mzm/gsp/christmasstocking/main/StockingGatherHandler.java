/*     */ package mzm.gsp.christmasstocking.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.christmasstocking.SGetStockingHidingAwardFail;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.confbean.SMapItemCfg;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapItemGatherHandler;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Role2ChristmasStockingInfo;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class StockingGatherHandler implements MapItemGatherHandler
/*     */ {
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  30 */     Set<Lockey> lockeys = new HashSet();
/*  31 */     lockeys.add(Lockeys.get(User.getTable(), userid));
/*  32 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*  33 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean gatherCheck(String userId, long roleId, long worldId, int mapCfgId, int mapItemCfgId, MapItemGatherContext context)
/*     */   {
/*  41 */     if (!ChristmasStockingManager.isChristmasStockingHidingOpen(roleId))
/*     */     {
/*  43 */       onCheckFail(roleId, -1);
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/*  49 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId).isCanJoin())
/*     */     {
/*  51 */       onCheckFail(roleId, -1);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     long homelandWorldId = HomelandInterface.getHomeWorldIdByRoleId(roleId, true);
/*  57 */     if ((homelandWorldId != worldId) || (!HomelandInterface.isAtHome(roleId, true)))
/*     */     {
/*  59 */       onCheckFail(roleId, -2);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     Role2ChristmasStockingInfo xRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(roleId);
/*  65 */     if (!ChristmasStockingManager.canGetStockingHidingAward(xRole2StockingInfo))
/*     */     {
/*  67 */       onCheckFail(roleId, -3);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     int awardPoolId = SMapItemCfg.get(mapItemCfgId).awardPoolId;
/*  73 */     Map<Integer, Integer> bagId2NeedGridNum = AwardPoolInterface.getBagId2MaxNeedGridNum(awardPoolId);
/*  74 */     if (AwardPoolInterface.checkGridNum(roleId, bagId2NeedGridNum, true, true) > 0)
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onCheckFail(long roleId, int errorCode)
/*     */   {
/*  85 */     SGetStockingHidingAwardFail proto = new SGetStockingHidingAwardFail();
/*  86 */     proto.error_code = errorCode;
/*  87 */     OnlineManager.getInstance().sendAtOnce(roleId, proto);
/*     */     
/*     */ 
/*  90 */     String logstr = String.format("[christmasstocking]StockingGatherHandler.onCheckFail@StockingGatherHandler gatherCheck failed|roleId=%d,reason=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/*  93 */     GameServer.logger().info(logstr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onGather(String userid, long roleId, long worldid, int mapCfgid, int mapItemCfgid, int awardItemCfgid, int awardItemNum, MapItemGatherContext context)
/*     */   {
/* 101 */     Role2ChristmasStockingInfo xRole2StockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(roleId);
/* 102 */     int oldNum = xRole2StockingInfo.getGetstockinghidingawardnum();
/* 103 */     int newNum = oldNum + 1;
/* 104 */     xRole2StockingInfo.setGetstockinghidingawardnum(newNum);
/*     */     
/*     */ 
/* 107 */     SMapItemCfg mapItemCfg = SMapItemCfg.get(mapItemCfgid);
/* 108 */     addPetMarkAddTLog(roleId, mapItemCfg.awardPoolId, newNum);
/*     */     
/*     */ 
/* 111 */     ChristmasStockingManager.sendAwardBulletin(roleId, awardItemCfgid, awardItemNum);
/*     */     
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   private void addPetMarkAddTLog(long roleId, int awardPoolTypeId, int newGetAwardNum)
/*     */   {
/* 118 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 119 */     String userid = RoleInterface.getUserId(roleId);
/* 120 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 121 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(awardPoolTypeId), Integer.valueOf(newGetAwardNum) });
/*     */     
/* 123 */     TLogManager.getInstance().addLog(roleId, "ChristmasStockingHidingGetAward", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\StockingGatherHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */