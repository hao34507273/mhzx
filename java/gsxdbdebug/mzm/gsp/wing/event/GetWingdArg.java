/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetWingdArg
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */ 
/*    */   private int newWing;
/*    */   
/*    */ 
/*    */ 
/*    */   public GetWingdArg(long roleid, int index, boolean isenable)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public GetWingdArg(long roleId, int newWing)
/*    */   {
/* 21 */     this.roleid = roleId;
/* 22 */     this.newWing = newWing;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 31 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getNewWing()
/*    */   {
/* 40 */     return this.newWing;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\GetWingdArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */