/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_closeFight extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private boolean isWin;
/*    */   
/*    */   public PGM_closeFight(long roleid, boolean isWin) {
/* 11 */     this.roleid = roleid;
/* 12 */     this.isWin = isWin;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     FightManager.closeFight(this.roleid, this.isWin);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_closeFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */