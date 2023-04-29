/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.CreateGangProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnCreateGang
/*    */   extends CreateGangProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     WorshipManager.setFactionMasterNpc(((GangArg)this.arg).gangId);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnCreateGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */