/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import xbean.RoleQMHWScore;
/*    */ 
/*    */ public class PGM_AddQMHWScore extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int score;
/*    */   
/*    */   public PGM_AddQMHWScore(long roleId, int score) {
/* 11 */     this.roleid = roleId;
/* 12 */     this.score = score;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     RoleQMHWScore xRoleQMHWScore = xtable.Role2qmhw.get(Long.valueOf(this.roleid));
/* 18 */     if (xRoleQMHWScore == null) {
/* 19 */       xRoleQMHWScore = xbean.Pod.newRoleQMHWScore();
/* 20 */       xtable.Role2qmhw.insert(Long.valueOf(this.roleid), xRoleQMHWScore);
/*    */     }
/* 22 */     xRoleQMHWScore.setScore(this.score + xRoleQMHWScore.getScore());
/* 23 */     QMHWManager.sendQMHWRoleInfo(this.roleid, xRoleQMHWScore);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PGM_AddQMHWScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */