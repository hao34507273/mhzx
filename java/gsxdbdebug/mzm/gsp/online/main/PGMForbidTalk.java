/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMForbidTalk
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private int periodSec;
/*    */   private boolean isClear;
/*    */   
/*    */   public PGMForbidTalk(long gmRoleId, long roleId, int periodSec, int isClear)
/*    */   {
/* 20 */     this.gmRoleId = gmRoleId;
/* 21 */     this.roleId = roleId;
/* 22 */     this.periodSec = periodSec;
/* 23 */     this.isClear = (isClear == 1);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (this.periodSec <= 0)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "时间无效");
/* 32 */       return false;
/*    */     }
/* 34 */     ForbidInfoManager.forbidTalk(this.roleId, this.periodSec, "GM");
/* 35 */     if (this.isClear)
/*    */     {
/* 37 */       IdipManager.sendClearSayToAll(this.roleId);
/*    */     }
/* 39 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "禁言成功");
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGMForbidTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */