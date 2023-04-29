/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.ForbidInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMUnforbidUser extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGMUnforbidUser(long gmRoleId, long roleId)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userId = RoleInterface.getUserId(this.roleId);
/* 23 */     if (userId == null)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "帐号不存在");
/* 26 */       return false;
/*    */     }
/* 28 */     ForbidInfoManager.unforbidUser(userId);
/* 29 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "解封帐号成功");
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMUnforbidUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */