/*    */ package mzm.gsp.crossbattle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.knockout.POnCrossBattleKnockOutStageStart;
/*    */ import mzm.gsp.timeflow.event.StepActivateArg;
/*    */ import mzm.gsp.timeflow.event.StepActivateProcedure;
/*    */ import mzm.gsp.timeflow.main.TimeFlowType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnStepActivate
/*    */   extends StepActivateProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if ((((StepActivateArg)this.arg).type != TimeFlowType.ACTIVITY) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(((StepActivateArg)this.arg).subType))))
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     switch (((StepActivateArg)this.arg).step)
/*    */     {
/*    */     case 1: 
/*    */     case 2: 
/* 27 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(((StepActivateArg)this.arg).subType), new mzm.gsp.crossbattle.own.POnActivtyStageStart(((StepActivateArg)this.arg).subType, ((StepActivateArg)this.arg).step, ((StepActivateArg)this.arg).activateAgain));
/*    */       
/*    */ 
/*    */ 
/* 31 */       break;
/*    */     
/*    */     case 3: 
/*    */     case 4: 
/* 35 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(((StepActivateArg)this.arg).subType), new mzm.gsp.crossbattle.point.POnActivtyStageStart(((StepActivateArg)this.arg).subType, ((StepActivateArg)this.arg).step, ((StepActivateArg)this.arg).activateAgain));
/*    */       
/*    */ 
/*    */ 
/* 39 */       break;
/*    */     
/*    */ 
/*    */     case 5: 
/* 43 */       new POnCrossBattleKnockOutStageStart(((StepActivateArg)this.arg).subType, 1).execute();
/* 44 */       break;
/*    */     
/*    */     case 6: 
/* 47 */       new POnCrossBattleKnockOutStageStart(((StepActivateArg)this.arg).subType, 2).execute();
/* 48 */       break;
/*    */     }
/*    */     
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\main\POnStepActivate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */