/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ 
/*    */ public class SingleItemInfo
/*    */ {
/*    */   private int itemId;
/*    */   private int itemNum;
/*    */   private int itemIdType;
/*    */   
/*    */   public int getItemIdType()
/*    */   {
/* 12 */     return this.itemIdType;
/*    */   }
/*    */   
/*    */   public void setItemIdType(int itemIdType)
/*    */   {
/* 17 */     this.itemIdType = itemIdType;
/*    */   }
/*    */   
/*    */   public int getItemId()
/*    */   {
/* 22 */     return this.itemId;
/*    */   }
/*    */   
/*    */   public void setItemId(int itemId)
/*    */   {
/* 27 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */   public int getItemNum()
/*    */   {
/* 32 */     return this.itemNum;
/*    */   }
/*    */   
/*    */   public void setItemNum(int itemNum)
/*    */   {
/* 37 */     this.itemNum = itemNum;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 43 */     if (this == obj)
/*    */     {
/* 45 */       return true;
/*    */     }
/* 47 */     if ((obj instanceof SingleItemInfo))
/*    */     {
/* 49 */       SingleItemInfo et = (SingleItemInfo)obj;
/* 50 */       if ((et.itemId == this.itemId) && (et.itemNum == this.itemNum) && (et.itemIdType == this.itemIdType))
/*    */       {
/* 52 */         return true;
/*    */       }
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 61 */     int result = 17;
/* 62 */     result = 37 * result + this.itemId;
/* 63 */     result = 37 * result + this.itemNum;
/* 64 */     result = 37 * result + this.itemIdType;
/* 65 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\SingleItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */