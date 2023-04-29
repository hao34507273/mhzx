/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ public class FabaoLevelUpArg {
/*    */   private final long roleId;
/*    */   private final int fabaoCfgId;
/*    */   private final int oldLevel;
/*    */   private final int curLevel;
/*    */   
/*    */   public FabaoLevelUpArg(long _roleId, int _fabaoCfgId, int _oldLevel, int _curLevel) {
/* 10 */     this.roleId = _roleId;
/* 11 */     this.fabaoCfgId = _fabaoCfgId;
/* 12 */     this.oldLevel = _oldLevel;
/* 13 */     this.curLevel = _curLevel;
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
/*    */   public int getOldLevel() {
/* 25 */     return this.oldLevel;
/*    */   }
/*    */   
/*    */   public int getCurLevel() {
/* 29 */     return this.curLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoLevelUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */