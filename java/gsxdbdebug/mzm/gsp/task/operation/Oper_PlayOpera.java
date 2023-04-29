/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STaskOperplayOpera;
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
/*    */ public class Oper_PlayOpera
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_PlayOpera(int operId, STaskOperplayOpera playOpera, int taskId)
/*    */   {
/* 21 */     super(operId, playOpera.operType, playOpera.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperplayOpera getSTaskOperplayOpera()
/*    */   {
/* 26 */     return STaskOperplayOpera.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_PlayOpera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */