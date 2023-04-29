/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import xbean.Bag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleStorageBag
/*    */   extends RoleItemBag
/*    */ {
/*    */   private final int storageId;
/*    */   
/*    */   RoleStorageBag(Bag bag, int storageId)
/*    */   {
/* 17 */     super(bag);
/* 18 */     this.storageId = storageId;
/*    */   }
/*    */   
/*    */   public int getStorageCfgId()
/*    */   {
/* 23 */     return this.storageId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleStorageBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */