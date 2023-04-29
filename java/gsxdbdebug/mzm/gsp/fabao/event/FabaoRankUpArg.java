/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ public class FabaoRankUpArg {
/*    */   private final long roleId;
/*    */   private final int fabaoCfgId;
/*    */   private final int oldRank;
/*    */   private final int curRank;
/*    */   
/*    */   public FabaoRankUpArg(long _roleId, int _fabaoCfgId, int _oldRank, int _curRank) {
/* 10 */     this.roleId = _roleId;
/* 11 */     this.fabaoCfgId = _fabaoCfgId;
/* 12 */     this.oldRank = _oldRank;
/* 13 */     this.curRank = _curRank;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 17 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getFabaoCfgId() {
/* 21 */     return this.fabaoCfgId;
/*    */   }
/*    */   
/*    */   public int getOldRank() {
/* 25 */     return this.oldRank;
/*    */   }
/*    */   
/*    */   public int getCurRank() {
/* 29 */     return this.curRank;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoRankUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */