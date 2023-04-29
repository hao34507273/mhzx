/*    */ package mzm.gsp.role.changemodel;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRmChangePlan
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int rmChangeId;
/*    */   
/*    */   public PRmChangePlan(long roleId, int rmChangeId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.rmChangeId = rmChangeId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     RoleChangeInfo roleChangeInfo = new RoleChangeInfo(this.roleId, true);
/* 28 */     int oldChangeId = roleChangeInfo.getNeedShowChangeId();
/* 29 */     if (!roleChangeInfo.rmChangeId(this.rmChangeId))
/*    */     {
/* 31 */       GameServer.logger().error(String.format("[change]PRmChangePlan.processImp@rm changeId fail!|roleId=%d|rmChangeId=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.rmChangeId) }));
/*    */       
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     int newChangeId = roleChangeInfo.getNeedShowChangeId();
/* 37 */     if (oldChangeId == newChangeId)
/*    */     {
/* 39 */       return true;
/*    */     }
/*    */     
/* 42 */     RoleChangeModelManager.notice2OtherAfterChange(this.roleId, oldChangeId, newChangeId);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\PRmChangePlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */