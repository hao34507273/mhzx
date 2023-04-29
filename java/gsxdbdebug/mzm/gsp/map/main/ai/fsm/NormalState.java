/*    */ package mzm.gsp.map.main.ai.fsm;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NormalState
/*    */   extends AbstractFSMState
/*    */ {
/*    */   public NormalState(AIManager machine)
/*    */   {
/* 16 */     super(machine);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onBegin() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onEnd() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void update(IMapAIObject owner, long time)
/*    */   {
/* 41 */     long stayTime = owner.getStayTime();
/* 42 */     if ((stayTime == -1L) || (stayTime > time))
/*    */     {
/* 44 */       return;
/*    */     }
/*    */     
/* 47 */     this._nextState = this.machine.getMove();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\NormalState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */