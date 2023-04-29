/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.AwardTotalData;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2totaldata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AwardWatchDogManager
/*    */ {
/*    */   public static void addRoleTotalAward(long roleId, AwardModel awardModel)
/*    */   {
/* 24 */     if (!isRoleExpBarkOpen())
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     if ((awardModel == null) || (roleId <= 0L))
/*    */     {
/* 30 */       return;
/*    */     }
/* 32 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 34 */     AwardTotalData xTotalData = getXTotalDataIfAbsence(roleId);
/* 35 */     int rolelv = RoleInterface.getLevel(roleId);
/* 36 */     checkInit(xTotalData, curTime, rolelv);
/*    */     
/* 38 */     AbsAwardWatchDog watchDog = new RoleExpWatchDog(roleId, rolelv, xTotalData, awardModel);
/* 39 */     watchDog.addXValue();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isRoleExpBarkOpen()
/*    */   {
/* 49 */     return OpenInterface.getOpenStatus(152);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static AwardTotalData getXTotalDataIfAbsence(long roleId)
/*    */   {
/* 61 */     AwardTotalData xTotalData = Role2totaldata.get(Long.valueOf(roleId));
/* 62 */     if (xTotalData == null)
/*    */     {
/* 64 */       xTotalData = Pod.newAwardTotalData();
/* 65 */       Role2totaldata.insert(Long.valueOf(roleId), xTotalData);
/*    */     }
/* 67 */     return xTotalData;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void checkInit(AwardTotalData xTotalData, long curTime, int roleLv)
/*    */   {
/* 78 */     long startTime = xTotalData.getStarttime();
/* 79 */     if ((startTime <= 0L) || (!DateTimeUtils.isInSameDay(startTime, curTime)))
/*    */     {
/* 81 */       xTotalData.setStarttime(curTime);
/* 82 */       xTotalData.setRolestartlv(roleLv);
/* 83 */       xTotalData.setGold(0L);
/* 84 */       xTotalData.setSilver(0L);
/* 85 */       xTotalData.setYuanbao(0L);
/* 86 */       xTotalData.setGoldingot(0L);
/* 87 */       xTotalData.setRoleexp(0L);
/* 88 */       xTotalData.setPetexp(0L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\AwardWatchDogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */