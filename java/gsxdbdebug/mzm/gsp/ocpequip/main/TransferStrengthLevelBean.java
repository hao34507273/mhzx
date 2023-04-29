/*    */ package mzm.gsp.ocpequip.main;
/*    */ 
/*    */ 
/*    */ public class TransferStrengthLevelBean
/*    */ {
/*  6 */   private int ocp = -1;
/*  7 */   private long uuid = -1L;
/*  8 */   private int strengthLevel = -1;
/*  9 */   private int itemId = -1;
/*    */   
/*    */   TransferStrengthLevelBean(int ocp, long uuid, int strengthLevel, int itemId)
/*    */   {
/* 13 */     this.ocp = ocp;
/* 14 */     this.uuid = uuid;
/* 15 */     this.strengthLevel = strengthLevel;
/* 16 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */   public int getOcp()
/*    */   {
/* 21 */     return this.ocp;
/*    */   }
/*    */   
/*    */   public long getUuid()
/*    */   {
/* 26 */     return this.uuid;
/*    */   }
/*    */   
/*    */   public int getStrengthLevel()
/*    */   {
/* 31 */     return this.strengthLevel;
/*    */   }
/*    */   
/*    */   public int getItemId()
/*    */   {
/* 36 */     return this.itemId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\TransferStrengthLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */