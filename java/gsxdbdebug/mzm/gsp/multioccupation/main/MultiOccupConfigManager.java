/*    */ package mzm.gsp.multioccupation.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.multioccupation.confbean.SMultiOccupConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MultiOccupConfigManager
/*    */ {
/*    */   static long getActivateIntervalMillis()
/*    */   {
/* 14 */     return TimeUnit.HOURS.toMillis(SMultiOccupConsts.getInstance().ActiveCoolDownHours);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static long getSwitchIntervalMillis()
/*    */   {
/* 23 */     return TimeUnit.HOURS.toMillis(SMultiOccupConsts.getInstance().SwitchCoolDownHours);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\MultiOccupConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */