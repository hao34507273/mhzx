/*    */ package mzm.gsp.breakegg.main;
/*    */ 
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BreakEggInterface
/*    */ {
/*    */   public static boolean isInBreakEgg(long roleid)
/*    */   {
/* 21 */     return BreakEggManager.isInBreakEgg(roleid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void startBreakEgg(int activityCfgId, List<Long> memberIds)
/*    */   {
/* 32 */     BreakEggManager.startBreakEgg(activityCfgId, memberIds);
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
/*    */ 
/*    */ 
/*    */   static int addRoleCounterTimes(long roleId, int index, int changeTimes)
/*    */   {
/* 48 */     return BreakEggManager.addRoleCounterTimes(roleId, index, changeTimes);
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
/*    */ 
/*    */ 
/*    */   static int getRoleCounter(long roleId, int index, boolean retainLock)
/*    */   {
/* 64 */     return BreakEggManager.getRoleCounter(roleId, index, retainLock);
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
/*    */ 
/*    */ 
/*    */   static void clearRoleCounterTimes(long roleId, int index)
/*    */   {
/* 80 */     BreakEggManager.clearRoleCounterTimes(roleId, index);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\BreakEggInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */