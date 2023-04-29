/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ActivityLogStatus
/*    */ {
/* 10 */   ATTEND(1), 
/* 11 */   FINISH(2);
/*    */   
/*    */ 
/*    */   public final int value;
/*    */   
/*    */   private ActivityLogStatus(int value)
/*    */   {
/* 18 */     this.value = value;
/*    */   }
/*    */   
/*    */   public static void checkActivityLogStatus() {
/* 22 */     Set<Integer> values = new HashSet();
/* 23 */     for (ActivityLogStatus type : values())
/*    */     {
/*    */ 
/* 26 */       if (!values.add(Integer.valueOf(type.value))) {
/* 27 */         throw new RuntimeException(String.format("ActivityLogStatus中定义的常量重复,name=%s,value=%d", new Object[] { type.name(), Integer.valueOf(type.value) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityLogStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */