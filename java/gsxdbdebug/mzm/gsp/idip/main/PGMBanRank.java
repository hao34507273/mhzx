/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.RankInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGMBanRank
/*    */   extends LogicProcedure
/*    */ {
/*    */   private static final String reason = "GM";
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   private final int seconds;
/*    */   private final boolean isClear;
/*    */   
/*    */   public PGMBanRank(long gmRoleId, long roleId, int type, int seconds, int isClear)
/*    */   {
/* 20 */     this.gmRoleId = gmRoleId;
/* 21 */     this.roleId = roleId;
/* 22 */     this.type = type;
/* 23 */     this.seconds = seconds;
/* 24 */     this.isClear = (isClear == 1);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if ((this.type < 0) || (this.type > 14))
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "排行榜类型错误");
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (this.seconds <= 0)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "无效时长");
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     IdipManager.addBanRank(this.roleId, this.type, this.seconds, "GM");
/* 43 */     boolean result = RankInterface.removeRoleidInRankForIDIP(this.roleId, this.type, this.isClear);
/* 44 */     if (result)
/*    */     {
/* 46 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "禁止排行榜成功");
/*    */     }
/*    */     else
/*    */     {
/* 50 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "禁止排行榜完成，玩家未上榜");
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMBanRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */