/*    */ package mzm.gsp.afk.main;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AFKInterface
/*    */ {
/*    */   public static void startAFKDetect(long roleid, int cfgid)
/*    */   {
/* 26 */     AFKDetector.getInstance().addRole(roleid, cfgid);
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
/*    */   public static void resetAFKDetect(long roleid, int cfgid)
/*    */   {
/* 40 */     AFKDetector.getInstance().resetRole(roleid, cfgid, false);
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
/*    */   public static void stopAFKDetect(long roleid, int cfgid)
/*    */   {
/* 54 */     AFKDetector.getInstance().removeRole(roleid, cfgid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\main\AFKInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */