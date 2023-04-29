/*    */ package mzm.gsp.map.main.ai.fsm;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ 
/*    */ public class AIManager
/*    */ {
/*    */   private IMapAIObject _owner;
/*    */   private IFSMState _currentState;
/*    */   private IFSMState _attackState;
/*    */   private IFSMState _moveState;
/*    */   private IFSMState _normalState;
/*    */   
/*    */   public AIManager(IMapAIObject owner)
/*    */   {
/* 15 */     this._owner = owner;
/*    */   }
/*    */   
/*    */   IMapAIObject getOwner()
/*    */   {
/* 20 */     return this._owner;
/*    */   }
/*    */   
/*    */   public IFSMState getNormal()
/*    */   {
/* 25 */     return this._normalState;
/*    */   }
/*    */   
/*    */   public IFSMState getAttack()
/*    */   {
/* 30 */     return this._attackState;
/*    */   }
/*    */   
/*    */   public IFSMState getMove()
/*    */   {
/* 35 */     return this._moveState;
/*    */   }
/*    */   
/*    */   public void initialize(IFSMState normalState, IFSMState attackState, IFSMState moveState)
/*    */   {
/* 40 */     this._attackState = attackState;
/* 41 */     this._moveState = moveState;
/* 42 */     this._normalState = normalState;
/* 43 */     this._currentState = normalState;
/*    */   }
/*    */   
/*    */   public void updateAI(long time)
/*    */   {
/* 48 */     if (this._currentState != null)
/*    */     {
/* 50 */       this._currentState.update(time);
/*    */     }
/*    */     
/* 53 */     IFSMState nextState = this._currentState.nextState();
/*    */     
/* 55 */     switchState(nextState);
/*    */   }
/*    */   
/*    */   public void switchState(IFSMState nextState)
/*    */   {
/* 60 */     if ((nextState != null) && (nextState != this._currentState))
/*    */     {
/* 62 */       if (this._currentState != null)
/*    */       {
/* 64 */         this._currentState.onEnd();
/*    */       }
/* 66 */       this._currentState = nextState;
/* 67 */       this._currentState.onBegin();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\AIManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */