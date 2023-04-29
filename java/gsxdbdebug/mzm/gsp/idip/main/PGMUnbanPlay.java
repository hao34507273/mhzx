/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMUnbanPlay
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   
/*    */   public PGMUnbanPlay(long gmRoleId, long roleId, int type)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.roleId = roleId;
/* 17 */     this.type = type;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if ((this.type < 0) || (this.type > 592))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "玩法类型错误");
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     boolean result = new IdipManager.PRemoveBanPlay(this.roleId, this.type).call();
/* 30 */     if (result)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "解除角色玩法成功");
/*    */     }
/*    */     else
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "解除角色玩法失败");
/*    */     }
/* 38 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMUnbanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */