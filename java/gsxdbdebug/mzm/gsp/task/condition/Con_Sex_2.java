/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.confbean.STaskConsex;
/*    */ import xbean.ConBean;
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
/*    */ public class Con_Sex_2
/*    */   extends AbsCondition
/*    */ {
/*    */   public Con_Sex_2(int conId, int conType, int sTaskId)
/*    */   {
/* 22 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskConsex getConsex()
/*    */   {
/* 27 */     return STaskConsex.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 33 */     STaskConsex conSex = getConsex();
/* 34 */     if (RoleInterface.getGender(roleId) == conSex.sex)
/*    */     {
/* 36 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 40 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 48 */     return 2;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Sex_2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */