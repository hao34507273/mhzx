/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossCompete;
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
/*    */ public class CrossCompeteInterface
/*    */ {
/*    */   public static boolean hasSignedUp(long factionid)
/*    */   {
/* 19 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 20 */     if (xCompete == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     return xCompete.getSignup_factions().containsKey(Long.valueOf(factionid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */