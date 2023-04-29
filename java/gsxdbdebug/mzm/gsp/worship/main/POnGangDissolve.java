/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveProcedure;
/*    */ import xtable.Faction2worship;
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
/* 16 */     Faction2worship.remove(Long.valueOf(((GangArg)this.arg).gangId));
/*    */     
/* 18 */     WorshipManager.rmFactionMasterNpc(((GangArg)this.arg).gangId);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnGangDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */