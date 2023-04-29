/*    */ package mzm.gsp.timeflow.event;
/*    */ 
/*    */ import mzm.gsp.timeflow.main.TimeFlowType;
/*    */ 
/*    */ public class StepActivateArg
/*    */ {
/*    */   public final TimeFlowType type;
/*    */   public final int subType;
/*    */   public final int step;
/*    */   public final boolean activateAgain;
/*    */   
/*    */   public StepActivateArg(TimeFlowType type, int subType, int step, boolean activateAgain)
/*    */   {
/* 14 */     this.type = type;
/* 15 */     this.subType = subType;
/* 16 */     this.step = step;
/* 17 */     this.activateAgain = activateAgain;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\event\StepActivateArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */