/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ public enum SwornOperateEnum {
/*  4 */   JOIN(1), 
/*  5 */   LEAVE(2), 
/*  6 */   CREATE(3), 
/*  7 */   DISSOLVE(4), 
/*  8 */   CHANGENAME(5), 
/*  9 */   CHANGETITLE(6);
/*    */   
/*    */   public final int value;
/*    */   
/*    */   private SwornOperateEnum(int value) {
/* 14 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\SwornOperateEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */