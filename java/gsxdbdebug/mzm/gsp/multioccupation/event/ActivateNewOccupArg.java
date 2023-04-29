/*    */ package mzm.gsp.multioccupation.event;
/*    */ 
/*    */ 
/*    */ public class ActivateNewOccupArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */   public final int newOccup;
/*    */   
/*    */   public final int oldOccup;
/*    */   
/*    */ 
/*    */   public ActivateNewOccupArg(long roleid, int newOccup, int oldOccup)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.newOccup = newOccup;
/* 17 */     this.oldOccup = oldOccup;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\event\ActivateNewOccupArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */