/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTransferScene
/*    */   extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if ((!HomelandManager.isHomelandMap(((MapTransferArg)this.arg).newMapCfgId)) && (HomelandManager.isHomelandMap(((MapTransferArg)this.arg).oldMapCfgId)))
/*    */     {
/* 20 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/* 22 */       RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 34);
/*    */ 
/*    */ 
/*    */     }
/* 26 */     else if ((HomelandManager.isHomelandMap(((MapTransferArg)this.arg).newMapCfgId)) && (!HomelandManager.isHomelandMap(((MapTransferArg)this.arg).oldMapCfgId)))
/*    */     {
/* 28 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/* 29 */       RoleStatusInterface.setStatus(((MapTransferArg)this.arg).roleList, 34, false);
/*    */     }
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */