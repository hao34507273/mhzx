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
/*    */ 
/*    */ public class PAddNewChangePlan
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int changeId;
/*    */   
/*    */   public PAddNewChangePlan(long roleId, int changeId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.changeId = changeId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     RoleChangeInfo roleChangeInfo = new RoleChangeInfo(this.roleId, true);
/* 29 */     int oldChangeId = roleChangeInfo.getNeedShowChangeId();
/* 30 */     RoleChangeInfo.AddRes res = roleChangeInfo.addChangeId(this.changeId);
/* 31 */     if (!checkSuc(roleChangeInfo, res))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!roleChangeInfo.needNoticeOthersChange(this.changeId))
/*    */     {
/* 37 */       return true;
/*    */     }
/*    */     
/* 40 */     RoleChangeModelManager.notice2OtherAfterChange(this.roleId, oldChangeId, this.changeId);
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean checkSuc(RoleChangeInfo roleChangeInfo, RoleChangeInfo.AddRes res)
/*    */   {
/* 53 */     if (res == RoleChangeInfo.AddRes.SUC)
/*    */     {
/* 55 */       return true;
/*    */     }
/* 57 */     switch (res)
/*    */     {
/*    */     case CONTAINS: 
/* 60 */       GameServer.logger().error(String.format("[change]PAddNewChangePlan.checkSuc@already contains this changeId|roleId=%d|changeId=%d|ownChangeIds=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.changeId), roleChangeInfo.getRoleChangeIds().toString() }));
/*    */       
/*    */ 
/*    */ 
/* 64 */       break;
/*    */     
/*    */     case NO_ID: 
/* 67 */       GameServer.logger().error(String.format("[change]PAddNewChangePlan.checkSuc@no changeId cfg|roleId=%d|changeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.changeId) }));
/*    */       
/*    */ 
/* 70 */       break;
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 75 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\PAddNewChangePlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */