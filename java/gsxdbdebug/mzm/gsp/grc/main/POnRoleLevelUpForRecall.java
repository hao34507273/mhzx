/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class POnRoleLevelUpForRecall extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   POnRoleLevelUpForRecall(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     String userid = RoleInterface.getUserId(this.roleid);
/* 19 */     if (userid == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     return RecallFriendManager.reportRoleBasicInfo(userid, this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRoleLevelUpForRecall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */