/*    */ package mzm.gsp.task.operation;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.task.confbean.STaskOperDelBuff;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Oper_DelBuff
/*    */   extends AbsOperation
/*    */ {
/*    */   public Oper_DelBuff(int operId, STaskOperDelBuff delBuff, int taskId)
/*    */   {
/* 19 */     super(operId, delBuff.operType, delBuff.teamType, taskId);
/*    */   }
/*    */   
/*    */   STaskOperDelBuff getSTaskOperDelBuff()
/*    */   {
/* 24 */     return STaskOperDelBuff.get(getOperId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*    */   {
/* 36 */     STaskOperDelBuff cfg = getSTaskOperDelBuff();
/* 37 */     if (cfg == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     BuffInterface.uninstallBuf(roleId, cfg.buffId);
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_DelBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */