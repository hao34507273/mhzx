/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ 
/*    */ public class ExtendBagArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int oldCapacity;
/*    */   
/*    */   public final int newCapacity;
/*    */   
/*    */   public ExtendBagArg(long roleId, int oldCapacity, int newCapacity)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.oldCapacity = oldCapacity;
/* 16 */     this.newCapacity = newCapacity;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\ExtendBagArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */