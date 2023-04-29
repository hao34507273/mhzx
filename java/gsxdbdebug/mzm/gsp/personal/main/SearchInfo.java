/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.personal.ConditionInfo;
/*    */ 
/*    */ 
/*    */ public class SearchInfo
/*    */ {
/*    */   public final int advertType;
/*    */   public final ConditionInfo conditionInfo;
/*    */   
/*    */   public SearchInfo(int advertType, ConditionInfo conditionInfo)
/*    */   {
/* 13 */     this.advertType = advertType;
/* 14 */     this.conditionInfo = conditionInfo;
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 20 */     int hashCode = 1;
/* 21 */     hashCode = 31 * hashCode + this.advertType;
/* 22 */     hashCode = 31 * hashCode + this.conditionInfo.hashCode();
/* 23 */     return hashCode;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 29 */     if (this == obj)
/*    */     {
/* 31 */       return true;
/*    */     }
/* 33 */     if ((obj instanceof SearchInfo))
/*    */     {
/* 35 */       SearchInfo tmp = (SearchInfo)obj;
/* 36 */       if (this.advertType != tmp.advertType)
/*    */       {
/* 38 */         return false;
/*    */       }
/* 40 */       return this.conditionInfo.equals(tmp.conditionInfo);
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     sb.append("[");
/* 50 */     sb.append(this.advertType).append(",");
/* 51 */     sb.append(this.conditionInfo.toString());
/* 52 */     sb.append("]");
/* 53 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\SearchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */