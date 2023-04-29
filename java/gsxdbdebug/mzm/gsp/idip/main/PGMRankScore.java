/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.arena.main.ArenaInterface;
/*    */ import mzm.gsp.bigboss.main.BigbossInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.main.ItemGiveManager;
/*    */ import mzm.gsp.jingji.main.JingjiInterface;
/*    */ import mzm.gsp.paraselene.main.ParaseleneInterface;
/*    */ import mzm.gsp.qmhw.main.QMHWInterface;
/*    */ import mzm.gsp.question.main.QuestionInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMRankScore
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   private final int score;
/*    */   
/*    */   public PGMRankScore(long gmRoleId, long roleId, int type, int score)
/*    */   {
/* 23 */     this.gmRoleId = gmRoleId;
/* 24 */     this.roleId = roleId;
/* 25 */     this.type = type;
/* 26 */     this.score = score;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (this.score <= 0) {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "分数无效");
/* 34 */       return false;
/*    */     }
/* 36 */     boolean success = true;
/* 37 */     switch (this.type)
/*    */     {
/*    */     case 0: 
/*    */     case 1: 
/*    */     case 2: 
/*    */     case 12: 
/*    */     case 13: 
/* 44 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "不支持该排行榜类型设置分数");
/* 45 */       success = false;
/* 46 */       break;
/*    */     
/*    */ 
/*    */ 
/*    */     case 9: 
/* 51 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "不支持该排行榜类型设置分数");
/* 52 */       success = false;
/* 53 */       break;
/*    */     
/*    */     case 11: 
/* 56 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "不支持该排行榜类型设置分数");
/* 57 */       success = false;
/* 58 */       break;
/*    */     case 3: 
/* 60 */       JingjiInterface.insertIntoRankForIdip(this.roleId, this.score);
/* 61 */       break;
/*    */     case 4: 
/* 63 */       QuestionInterface.insertIntoRankForIdip(this.roleId, this.score);
/* 64 */       break;
/*    */     case 7: 
/* 66 */       success = ArenaInterface.setScore(this.roleId, this.score);
/* 67 */       break;
/*    */     case 8: 
/* 69 */       BigbossInterface.insertIntoRankForIdip(this.roleId, this.score);
/* 70 */       break;
/*    */     case 10: 
/* 72 */       ParaseleneInterface.insertIntoRankForIdip(this.roleId, this.score);
/* 73 */       break;
/*    */     case 6: 
/* 75 */       ItemGiveManager.insertIntoRankForIdip(this.roleId, this.score, -1);
/* 76 */       break;
/*    */     case 5: 
/* 78 */       ItemGiveManager.insertIntoRankForIdip(this.roleId, -1, this.score);
/* 79 */       break;
/*    */     case 14: 
/* 81 */       QMHWInterface.setScoreForIDIP(this.roleId, this.score);
/* 82 */       break;
/*    */     default: 
/* 84 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "排行榜类型错误");
/* 85 */       success = false;
/*    */     }
/*    */     
/* 88 */     if (success)
/*    */     {
/* 90 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置排行榜分数完成");
/*    */     }
/* 92 */     return success;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMRankScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */