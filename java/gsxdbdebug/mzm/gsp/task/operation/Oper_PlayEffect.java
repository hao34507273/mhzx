/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STaskOperPlayEffect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Oper_PlayEffect
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_PlayEffect(int operId, STaskOperPlayEffect playEffect, int taskId)
/*    */   {
/* 21 */     super(operId, playEffect.operType, playEffect.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperPlayEffect getSTaskOperPlayEffect()
/*    */   {
/* 26 */     return STaskOperPlayEffect.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_PlayEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */