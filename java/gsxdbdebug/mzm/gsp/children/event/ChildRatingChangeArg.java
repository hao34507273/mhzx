/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ public class ChildRatingChangeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long childId;
/*    */   public final boolean byDelete;
/*    */   
/*    */   public ChildRatingChangeArg(long roleId, long childId, boolean byDelete)
/*    */   {
/* 11 */     this.roleId = roleId;
/* 12 */     this.childId = childId;
/* 13 */     this.byDelete = byDelete;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildRatingChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */