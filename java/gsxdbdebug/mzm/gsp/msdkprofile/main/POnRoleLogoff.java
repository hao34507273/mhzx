/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.Pair;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 15 */     Role role = RoleInterface.getRole(roleId, true);
/*    */     
/* 17 */     long lastLogin = role.getLastLoginTime();
/* 18 */     long lastCalcuate = role.getLastCalcuateTime();
/*    */     
/*    */ 
/* 21 */     if (lastCalcuate < lastLogin)
/*    */     {
/* 23 */       lastCalcuate = 0L;
/*    */     }
/*    */     
/*    */ 
/* 27 */     Pair<Boolean, Integer> result = null;
/* 28 */     if (lastCalcuate == 0L)
/*    */     {
/*    */ 
/* 31 */       result = calcuteOnlineSeconds(lastLogin);
/*    */     }
/*    */     else
/*    */     {
/* 35 */       result = calcuteOnlineSeconds(lastCalcuate);
/*    */     }
/*    */     
/*    */ 
/* 39 */     int seconds = 0;
/* 40 */     if (((Boolean)result.first).booleanValue())
/*    */     {
/*    */ 
/* 43 */       seconds = role.getDayOnlineSeconds() + ((Integer)result.second).intValue();
/* 44 */       role.setDayOnlineSeconds(seconds);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 49 */       seconds = ((Integer)result.second).intValue();
/* 50 */       role.setDayOnlineSeconds(((Integer)result.second).intValue());
/*    */     }
/* 52 */     role.setLastCalcuateTime(0L);
/*    */     
/*    */ 
/* 55 */     role.setOnlineSeconds(role.getOnlineSeconds() + ((Integer)result.second).intValue());
/*    */     
/*    */ 
/* 58 */     MSDKProfileManager.reportRoleOnlineSecondsAsync(roleId, seconds);
/*    */     
/* 60 */     return true;
/*    */   }
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
/*    */   private Pair<Boolean, Integer> calcuteOnlineSeconds(long beginTime)
/*    */   {
/* 74 */     Pair<Boolean, Integer> result = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
/* 75 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 76 */     if (DateTimeUtils.isInSameDay(beginTime, now))
/*    */     {
/* 78 */       int second = (int)(now - beginTime) / 1000;
/* 79 */       result.first = Boolean.valueOf(true);
/* 80 */       result.second = Integer.valueOf(second);
/*    */     }
/*    */     else
/*    */     {
/* 84 */       long todayBeginTime = DateTimeUtils.getBeginTimeOfCurrDay(now);
/* 85 */       int second = (int)(now - todayBeginTime) / 1000;
/* 86 */       result.first = Boolean.valueOf(false);
/* 87 */       result.second = Integer.valueOf(second);
/*    */     }
/* 89 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */