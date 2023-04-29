/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ 
/*    */ class RCheckCancelSignUpByVitality
/*    */   extends LogicRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 17 */     if (CrossCompeteManager.simplified) {
/* 18 */       return;
/*    */     }
/*    */     
/*    */ 
/* 22 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 23 */     if (xCompete == null) {
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     for (Iterator i$ = xCompete.getSignup_factions().keySet().iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/*    */       
/* 29 */       Gang faction = GangInterface.getGang(factionid, false);
/* 30 */       if (faction != null)
/*    */       {
/*    */ 
/*    */ 
/* 34 */         new PCheckCancelSignUpByVitality(factionid, faction.getVitality()).call();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\RCheckCancelSignUpByVitality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */