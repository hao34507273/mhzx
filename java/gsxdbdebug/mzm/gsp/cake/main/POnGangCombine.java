/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangCombineArg;
/*    */ import mzm.gsp.gang.event.GangCombineProcedure;
/*    */ import xtable.Factioncake;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangCombine
/*    */   extends GangCombineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     Factioncake.remove(Long.valueOf(((GangCombineArg)this.arg).viceGangid));
/*    */     
/* 19 */     FactionOvenCacheManager.getInstance().removeAllFactionData(((GangCombineArg)this.arg).viceGangid);
/*    */     
/* 21 */     CreateSceneFactionCache.getInstance().removeFactionId(((GangCombineArg)this.arg).viceGangid);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\POnGangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */