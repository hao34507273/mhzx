/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.ForbidInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMUnforbidTalk extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGMUnforbidTalk(long gmRoleId, long roleId)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     ForbidInfoManager.unforbidTalk(this.roleId);
/* 22 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "解除禁言成功");
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMUnforbidTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */