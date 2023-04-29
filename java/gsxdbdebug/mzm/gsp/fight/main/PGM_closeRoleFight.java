/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_closeRoleFight extends LogicProcedure {
/*    */   private long roleid;
/*    */   private boolean isWin;
/*    */   
/*    */   public PGM_closeRoleFight(long roleid, boolean isWin) {
/* 10 */     this.roleid = roleid;
/* 11 */     this.isWin = isWin;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     FightManager.closeFightWithRoleWin(this.roleid, this.isWin);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_closeRoleFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */