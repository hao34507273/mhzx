/*    */ package mzm.gsp.map.main.worldai.script;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExampleScript
/*    */   implements IAIScript
/*    */ {
/* 14 */   private final int ALERT_ID2 = 2;
/*    */   
/*    */ 
/*    */ 
/*    */   public void init(IAIContext context)
/*    */   {
/* 20 */     context.createTimer(2, 60, 1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void execute(IAIContext context)
/*    */   {
/* 28 */     if (context.isTimerTrigger(2))
/*    */     {
/*    */ 
/* 31 */       context.setControllerState(2, true);
/*    */     }
/*    */     
/*    */ 
/* 35 */     if ((context.getControllerState(2) == 1) && (context.getMonsterNumber(1) < 2))
/*    */     {
/*    */ 
/* 38 */       context.setControllerState(2, false);
/*    */       
/* 40 */       context.setControllerState(3, true);
/*    */       
/* 42 */       context.speek("oh, fresh meet!", 1);
/*    */     }
/*    */     
/* 45 */     if ((context.getControllerState(3) == 1) && (context.isMonsterExist(3)))
/*    */     {
/*    */ 
/* 48 */       context.finishScript();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\worldai\script\ExampleScript.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */