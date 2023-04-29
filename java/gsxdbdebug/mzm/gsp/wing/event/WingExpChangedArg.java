/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ 
/*    */ public class WingExpChangedArg
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   private int oldLv;
/*    */   private int newLv;
/*    */   private int addExp;
/*    */   
/*    */   public WingExpChangedArg(long roleid, int index, boolean isenable, int oldexp, int newexp) {}
/*    */   
/*    */   public WingExpChangedArg(long roleId, int oldLv, int newLv, int addExp)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.oldLv = oldLv;
/* 18 */     this.newLv = newLv;
/* 19 */     this.addExp = addExp;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 24 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getOldLv()
/*    */   {
/* 29 */     return this.oldLv;
/*    */   }
/*    */   
/*    */   public int getNewLv()
/*    */   {
/* 34 */     return this.newLv;
/*    */   }
/*    */   
/*    */   public int getAddExp()
/*    */   {
/* 39 */     return this.addExp;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean lvUp()
/*    */   {
/* 48 */     return this.newLv > this.oldLv;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingExpChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */