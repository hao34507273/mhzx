/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossbattle.knockout.KnockOutRoamRoleDataSuccessArg;
/*    */ import mzm.gsp.crossserver.event.LadderRoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.event.PointRaceRoamRoleDataSucceedArg;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataSucceedProcedure;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldRoamRoleDataSucceedArg;
/*    */ 
/*    */ public class POnRoamRoleDataSucceed extends RoamRoleDataSucceedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     switch (((mzm.gsp.crossserver.event.RoamRoleDataSucceedArg)this.arg).getRoamType())
/*    */     {
/*    */     case LADDER: 
/* 16 */       LadderRoamRoleDataSucceedArg ladderRoamRoleDataSucceedArg = (LadderRoamRoleDataSucceedArg)this.arg;
/* 17 */       CrossServerManager.removeMatchContext(ladderRoamRoleDataSucceedArg.getContextid());
/*    */       
/* 19 */       break;
/*    */     
/*    */     case CROSS_BATTLE_POINT: 
/* 22 */       PointRaceRoamRoleDataSucceedArg pointRaceRoamRoleDataSucceedArg = (PointRaceRoamRoleDataSucceedArg)this.arg;
/* 23 */       CrossServerManager.removePointRaceContext(pointRaceRoamRoleDataSucceedArg.getContextid());
/* 24 */       break;
/*    */     
/*    */     case CROSS_BATTLE_SELECTION_FINAL: 
/* 27 */       KnockOutRoamRoleDataSuccessArg selectionFinalRoamRoleDataSuccessArg = (KnockOutRoamRoleDataSuccessArg)this.arg;
/* 28 */       CrossServerManager.removeSelectionFinalContext(selectionFinalRoamRoleDataSuccessArg.getContextid());
/* 29 */       break;
/*    */     
/*    */     case SINGLE_CROSS_FIELD: 
/* 32 */       SingleCrossFieldRoamRoleDataSucceedArg singleCrossFieldRoamRoleDataSucceedArg = (SingleCrossFieldRoamRoleDataSucceedArg)this.arg;
/* 33 */       CrossServerManager.removeSingleCrossFieldContext(singleCrossFieldRoamRoleDataSucceedArg.getContext().getContextid());
/* 34 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnRoamRoleDataSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */