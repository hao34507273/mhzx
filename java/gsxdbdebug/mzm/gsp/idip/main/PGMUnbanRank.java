/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMUnbanRank
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   
/*    */   public PGMUnbanRank(long gmRoleId, long roleId, int type)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.roleId = roleId;
/* 17 */     this.type = type;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if ((this.type < 0) || (this.type > 14))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "排行榜类型错误");
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     boolean result = new IdipManager.PRemoveBanRank(this.roleId, this.type).call();
/* 30 */     if (result)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "解除角色排行榜成功");
/*    */     }
/*    */     else
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "解除角色排行榜失败");
/*    */     }
/* 38 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMUnbanRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */