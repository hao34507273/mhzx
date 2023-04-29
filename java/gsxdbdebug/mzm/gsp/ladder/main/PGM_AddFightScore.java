/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddFightScore extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_AddFightScore(long gmRoleid, long roleid, int num)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/* 16 */     this.num = num;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("战斗积分待实现|角色ID=%d|增加分数=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.num) }));
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_AddFightScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */