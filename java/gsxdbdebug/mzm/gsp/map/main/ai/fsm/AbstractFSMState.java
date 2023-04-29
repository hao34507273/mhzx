/*    */ package mzm.gsp.map.main.ai.fsm;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ 
/*    */ public abstract class AbstractFSMState
/*    */   implements IFSMState
/*    */ {
/*    */   protected IFSMState _nextState;
/*    */   protected AIManager machine;
/*    */   
/*    */   public AbstractFSMState(AIManager machine)
/*    */   {
/* 13 */     this.machine = machine;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onBegin() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onEnd() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public final void update(long time)
/*    */   {
/* 29 */     IMapAIObject owner = this.machine.getOwner();
/* 30 */     update(owner, time);
/*    */   }
/*    */   
/*    */   public abstract void update(IMapAIObject paramIMapAIObject, long paramLong);
/*    */   
/*    */   public void setNextState(IFSMState _nextState)
/*    */   {
/* 37 */     this._nextState = _nextState;
/*    */   }
/*    */   
/*    */ 
/*    */   public IFSMState nextState()
/*    */   {
/* 43 */     IFSMState state = this._nextState;
/* 44 */     this._nextState = null;
/* 45 */     return state;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\AbstractFSMState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */