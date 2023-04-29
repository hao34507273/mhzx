/*    */ package mzm.gsp.map.main.ai.fsm;
/*    */ 
/*    */ public class AITrigger
/*    */ {
/*    */   private ConditionData cdata;
/*    */   private AITriggerExecutor action;
/*    */   
/*    */   public AITrigger(ConditionData cdata, AITriggerExecutor action)
/*    */   {
/* 10 */     this.cdata = cdata;
/* 11 */     this.action = action;
/*    */   }
/*    */   
/*    */   public boolean isMatch()
/*    */   {
/* 16 */     return this.cdata.isMatch();
/*    */   }
/*    */   
/*    */   public void execute()
/*    */   {
/* 21 */     this.action.executeAction();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\AITrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */