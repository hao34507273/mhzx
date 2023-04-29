/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ public class WingLevelUpArg {
/*    */   public long roleid;
/*    */   public int index;
/*    */   public int oldlevel;
/*    */   public int newlevel;
/*    */   
/*  9 */   public WingLevelUpArg(long roleid, int index, int oldlevel, int newlevel) { this.roleid = roleid;
/* 10 */     this.index = index;
/* 11 */     this.oldlevel = oldlevel;
/* 12 */     this.newlevel = newlevel;
/*    */   }
/*    */   
/* 15 */   public long getRoleid() { return this.roleid; }
/*    */   
/*    */   public void setRoleid(long roleid) {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/* 21 */   public int getIndex() { return this.index; }
/*    */   
/*    */   public void setIndex(int index) {
/* 24 */     this.index = index;
/*    */   }
/*    */   
/* 27 */   public int getOldlevel() { return this.oldlevel; }
/*    */   
/*    */   public void setOldlevel(int oldlevel) {
/* 30 */     this.oldlevel = oldlevel;
/*    */   }
/*    */   
/* 33 */   public int getNewlevel() { return this.newlevel; }
/*    */   
/*    */   public void setNewlevel(int newlevel) {
/* 36 */     this.newlevel = newlevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingLevelUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */