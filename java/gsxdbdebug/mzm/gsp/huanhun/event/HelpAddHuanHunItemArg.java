/*    */ package mzm.gsp.huanhun.event;
/*    */ 
/*    */ public class HelpAddHuanHunItemArg
/*    */ {
/*    */   private final long roleId;
/*    */   private final long beHelpedRoleId;
/*    */   private final int boxIndex;
/*    */   
/*    */   public HelpAddHuanHunItemArg(long roleId, long beHelpedRoleId, int boxIndex)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.beHelpedRoleId = beHelpedRoleId;
/* 13 */     this.boxIndex = boxIndex;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 23 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getBeHelpedRoleId()
/*    */   {
/* 33 */     return this.beHelpedRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getBoxIndex()
/*    */   {
/* 43 */     return this.boxIndex;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\event\HelpAddHuanHunItemArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */