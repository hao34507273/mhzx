/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveProcedure;
/*    */ import xtable.Factioncake;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangDissolve
/*    */   extends GangDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Factioncake.remove(Long.valueOf(((GangArg)this.arg).gangId));
/*    */     
/* 20 */     FactionOvenCacheManager.getInstance().removeAllFactionData(((GangArg)this.arg).gangId);
/*    */     
/* 22 */     CreateSceneFactionCache.getInstance().removeFactionId(((GangArg)this.arg).gangId);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POnGangDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */