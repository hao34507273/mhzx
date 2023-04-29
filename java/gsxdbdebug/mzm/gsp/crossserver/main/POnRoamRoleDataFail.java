/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossbattle.knockout.KnockOutRoamRoleDataFailArg;
/*    */ import mzm.gsp.crossserver.event.LadderRoamRoleDataFailArg;
/*    */ import mzm.gsp.crossserver.event.PointRaceRoamRoleDataFailArg;
/*    */ import mzm.gsp.crossserver.event.RoamRoleDataFailProcedure;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldRoamRoleDataFailArg;
/*    */ 
/*    */ public class POnRoamRoleDataFail extends RoamRoleDataFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     switch (((mzm.gsp.crossserver.event.RoamRoleDataFailArg)this.arg).getRoamType())
/*    */     {
/*    */     case LADDER: 
/* 16 */       LadderRoamRoleDataFailArg ladderRoamRoleDataFailArg = (LadderRoamRoleDataFailArg)this.arg;
/* 17 */       CrossServerManager.removeMatchContext(ladderRoamRoleDataFailArg.getContextid());
/*    */       
/* 19 */       break;
/*    */     
/*    */     case CROSS_BATTLE_POINT: 
/* 22 */       PointRaceRoamRoleDataFailArg pointRaceRoamRoleDataFailArg = (PointRaceRoamRoleDataFailArg)this.arg;
/* 23 */       CrossServerManager.removePointRaceContext(pointRaceRoamRoleDataFailArg.getContextid());
/* 24 */       break;
/*    */     
/*    */     case CROSS_BATTLE_SELECTION_FINAL: 
/* 27 */       KnockOutRoamRoleDataFailArg selectionFinalRoamRoleDataFailArg = (KnockOutRoamRoleDataFailArg)this.arg;
/* 28 */       KnockOutContextManager.getInstance().removeContext(selectionFinalRoamRoleDataFailArg.getContextid());
/* 29 */       break;
/*    */     
/*    */     case SINGLE_CROSS_FIELD: 
/* 32 */       SingleCrossFieldRoamRoleDataFailArg singleCrossFieldRoamRoleDataFailArg = (SingleCrossFieldRoamRoleDataFailArg)this.arg;
/* 33 */       CrossServerManager.removeSingleCrossFieldContext(singleCrossFieldRoamRoleDataFailArg.getContext().getContextid());
/* 34 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnRoamRoleDataFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */