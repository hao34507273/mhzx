/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.event.NoneRealTimeRoleMFVChange;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRankRoleMFV
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private int mfv;
/*    */   
/*    */   public PRankRoleMFV(long roleId, int mfv)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.mfv = mfv;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.mfv < 0)
/*    */     {
/* 31 */       GameServer.logger().error(String.format("[MFV]PRankRoleMFV.processImp@ multiFightValue is illegal!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 33 */       this.mfv = MultiRankManager.getRoleMFValue(this.roleId);
/*    */     }
/*    */     
/* 36 */     triggerRoleChartMfvChangeEvent();
/*    */     
/* 38 */     MultiFightValueRankManager.getInstance().rank(new RoleMultiFightValueChart(this.roleId, this.mfv));
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private void triggerRoleChartMfvChangeEvent()
/*    */   {
/* 44 */     int orgMFV = MultiFightValueRankManager.getInstance().getRankMFV(this.roleId);
/* 45 */     if (orgMFV == this.mfv)
/*    */     {
/*    */ 
/* 48 */       return;
/*    */     }
/* 50 */     TriggerEventsManger.getInstance().triggerEvent(new NoneRealTimeRoleMFVChange(), new RoleChartMfvChangeArg(this.roleId, orgMFV, this.mfv));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PRankRoleMFV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */