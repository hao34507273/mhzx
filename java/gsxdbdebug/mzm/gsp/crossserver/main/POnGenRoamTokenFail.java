/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.crossbattle.knockout.KnockOutGenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.event.GenRoamTokenFailProcedure;
/*    */ import mzm.gsp.crossserver.event.LadderGenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.event.PointRaceGenRoamTokenFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldGenRoamTokenFailArg;
/*    */ 
/*    */ public class POnGenRoamTokenFail extends GenRoamTokenFailProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     switch (((mzm.gsp.crossserver.event.GenRoamTokenFailArg)this.arg).getRoamType())
/*    */     {
/*    */     case LADDER: 
/* 16 */       LadderGenRoamTokenFailArg ladderGenRoamTokenFailArg = (LadderGenRoamTokenFailArg)this.arg;
/* 17 */       CrossServerManager.removeMatchContext(ladderGenRoamTokenFailArg.getContextid());
/*    */       
/* 19 */       break;
/*    */     case CROSS_BATTLE_POINT: 
/* 21 */       PointRaceGenRoamTokenFailArg pointRaceGenRoamTokenFailArg = (PointRaceGenRoamTokenFailArg)this.arg;
/* 22 */       CrossServerManager.removePointRaceContext(pointRaceGenRoamTokenFailArg.getContextid());
/* 23 */       break;
/*    */     case CROSS_BATTLE_SELECTION_FINAL: 
/* 25 */       KnockOutGenRoamTokenFailArg selectionFinalGenRoamTokenFailArg = (KnockOutGenRoamTokenFailArg)this.arg;
/* 26 */       CrossServerManager.removeSelectionFinalContext(selectionFinalGenRoamTokenFailArg.getContextid());
/* 27 */       break;
/*    */     case SINGLE_CROSS_FIELD: 
/* 29 */       SingleCrossFieldGenRoamTokenFailArg arg = (SingleCrossFieldGenRoamTokenFailArg)this.arg;
/* 30 */       CrossServerManager.removeSingleCrossFieldContext(arg.getContext().getContextid());
/* 31 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\POnGenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */