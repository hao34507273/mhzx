/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ public class ItemLevelKey
/*    */ {
/*    */   public int levelLow;
/*    */   public int levelHigh;
/*    */   
/*    */   public ItemLevelKey(int levelLow, int levelHigh)
/*    */   {
/* 10 */     this.levelHigh = levelHigh;
/* 11 */     this.levelLow = levelLow;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isIncludeXLevel(int level)
/*    */   {
/* 22 */     return (level >= this.levelLow) && (level <= this.levelHigh);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 28 */     if (this == obj)
/*    */     {
/* 30 */       return true;
/*    */     }
/* 32 */     if ((obj instanceof ItemLevelKey))
/*    */     {
/* 34 */       ItemLevelKey et = (ItemLevelKey)obj;
/* 35 */       if ((et.levelHigh == this.levelHigh) && (et.levelLow == this.levelLow))
/*    */       {
/* 37 */         return true;
/*    */       }
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 46 */     int result = 17;
/* 47 */     result = 37 * result + this.levelHigh;
/* 48 */     result = 37 * result + this.levelLow;
/* 49 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\ItemLevelKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */