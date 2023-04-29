/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangRenameArg;
/*    */ import mzm.gsp.gang.event.GangRenameProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGangRename
/*    */   extends GangRenameProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     WorshipManager.setFactionMasterNpc(((GangRenameArg)this.arg).gangId);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnGangRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */