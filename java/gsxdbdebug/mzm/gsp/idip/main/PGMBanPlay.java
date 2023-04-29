/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGMBanPlay
/*    */   extends LogicProcedure
/*    */ {
/*    */   private static final String reason = "GM";
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   private final int seconds;
/*    */   
/*    */   public PGMBanPlay(long gmRoleId, long roleId, int type, int seconds)
/*    */   {
/* 18 */     this.gmRoleId = gmRoleId;
/* 19 */     this.roleId = roleId;
/* 20 */     this.type = type;
/* 21 */     this.seconds = seconds;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if ((this.type < 0) || (this.type > 592))
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "玩法类型错误");
/* 30 */       return false;
/*    */     }
/* 32 */     if (this.seconds <= 0)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "无效时长");
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     boolean result = IdipManager.addBanPlay(this.roleId, this.type, this.seconds, "GM");
/* 39 */     if (result)
/*    */     {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "禁止角色玩法成功");
/*    */     }
/*    */     else
/*    */     {
/* 45 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "禁止角色玩法失败");
/*    */     }
/* 47 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMBanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */