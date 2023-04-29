/*    */ package mzm.gsp.map.main.ai.fsm;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ import mzm.gsp.map.main.ai.path.MoveController;
/*    */ 
/*    */ public class MoveState extends AbstractFSMState
/*    */ {
/*    */   private MoveController moveController;
/*    */   
/*    */   public MoveState(AIManager machine, MoveController controller)
/*    */   {
/* 12 */     super(machine);
/* 13 */     this.moveController = controller;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onBegin()
/*    */   {
/* 19 */     this.moveController.startMove();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onEnd() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void update(IMapAIObject owner, long time)
/*    */   {
/* 30 */     if (this.moveController.isEnd())
/*    */     {
/* 32 */       this._nextState = this.machine.getNormal();
/*    */     }
/* 34 */     this.moveController.update(time);
/* 35 */     if (this.moveController.getDelayTime() > 0L)
/*    */     {
/* 37 */       owner.stay(this.moveController.getDelayTime());
/* 38 */       this._nextState = this.machine.getNormal();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\MoveState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */