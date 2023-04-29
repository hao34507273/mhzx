/*    */ package mzm.gsp.item.main.sift.condition;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbsSiftCondition
/*    */   implements Comparable<AbsSiftCondition>
/*    */ {
/*    */   public abstract boolean equals(Object paramObject);
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 17 */     return getConditionParams().hashCode() * 31 + getConId();
/*    */   }
/*    */   
/*    */ 
/*    */   public abstract Object getConditionParams();
/*    */   
/*    */ 
/*    */   public abstract void sift(Set<Integer> paramSet);
/*    */   
/*    */ 
/*    */   public abstract boolean isTrue(int paramInt);
/*    */   
/*    */ 
/*    */   public abstract int getConId();
/*    */   
/*    */ 
/*    */   public int compareTo(AbsSiftCondition o)
/*    */   {
/* 35 */     return getConId() - o.getConId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\condition\AbsSiftCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */