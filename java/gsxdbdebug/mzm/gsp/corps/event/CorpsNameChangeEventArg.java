/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CorpsNameChangeEventArg
/*    */ {
/*    */   private final long corpsId;
/*    */   
/*    */ 
/*    */   private final String oldName;
/*    */   
/*    */   private final String newName;
/*    */   
/*    */ 
/*    */   public CorpsNameChangeEventArg(long corpsId, String oldName, String newName)
/*    */   {
/* 17 */     this.corpsId = corpsId;
/* 18 */     this.oldName = oldName;
/* 19 */     this.newName = newName;
/*    */   }
/*    */   
/*    */   public long getCorpsId()
/*    */   {
/* 24 */     return this.corpsId;
/*    */   }
/*    */   
/*    */   public String getOldName()
/*    */   {
/* 29 */     return this.oldName;
/*    */   }
/*    */   
/*    */   public String getNewName()
/*    */   {
/* 34 */     return this.newName;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\CorpsNameChangeEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */