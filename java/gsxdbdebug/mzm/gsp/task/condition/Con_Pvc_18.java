/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.task.confbean.STaskConkillNpc;
/*    */ import xbean.ConBean;
/*    */ 
/*    */ 
/*    */ public class Con_Pvc_18
/*    */   extends AbsCondition
/*    */ {
/*    */   public Con_Pvc_18(int conId, int conType, int sTaskId)
/*    */   {
/* 13 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskConkillNpc getConkillNpc()
/*    */   {
/* 18 */     return STaskConkillNpc.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 25 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Pvc_18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */