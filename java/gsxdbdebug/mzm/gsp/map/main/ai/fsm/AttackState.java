/*    */ package mzm.gsp.map.main.ai.fsm;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.IMapAIObject;
/*    */ import mzm.gsp.map.main.scene.object.SceneObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttackState
/*    */   extends AbstractFSMState
/*    */ {
/*    */   private SceneObject target;
/*    */   
/*    */   public AttackState(AIManager machine)
/*    */   {
/* 19 */     super(machine);
/*    */   }
/*    */   
/*    */   public void setTarget(SceneObject target)
/*    */   {
/* 24 */     this.target = target;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onBegin()
/*    */   {
/* 30 */     super.onBegin();
/*    */   }
/*    */   
/*    */   public void update(IMapAIObject owner, long time) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\fsm\AttackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */