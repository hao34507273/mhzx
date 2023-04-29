/*    */ package mzm.gsp.paraselene.main;
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
/* 18 */     if ((!ParaseleneManager.isParaseleneMap(((MapTransferArg)this.arg).newMapCfgId)) && (ParaseleneManager.isParaseleneMap(((MapTransferArg)this.arg).oldMapCfgId)))
/*    */     {
/* 20 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/* 22 */       RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 12);
/*    */     }
/*    */     
/*    */ 
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */