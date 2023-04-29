/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.BigBoss;
/*    */ 
/*    */ public class Pgm_SetBigbosscount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int value;
/*    */   
/*    */   public Pgm_SetBigbosscount(long roleid, int value)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     BigBoss bigBoss = BigbossManager.getBigboss(this.roleid, true);
/* 21 */     if (bigBoss == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     int ocp = RoleInterface.getOccupationId(this.roleid);
/* 26 */     bigBoss.setChallengecount(this.value);
/* 27 */     int roleRank = BigbossChartManager.getInstance().getRank(ocp, this.roleid);
/* 28 */     BigbossManager.synBigbossActivityDataChanged(this.roleid, 0, ocp, bigBoss, roleRank);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\Pgm_SetBigbosscount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */