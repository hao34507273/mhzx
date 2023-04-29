/*   */ package mzm.gsp.children.main;
/*   */ 
/*   */ import mzm.gsp.children.event.ChildRatingChangeArg;
/*   */ 
/*   */ public class POnChildRatingChange extends mzm.gsp.children.event.ChildRatingChangeProcedure
/*   */ {
/*   */   protected boolean processImp() {
/* 8 */     ChildrenManager.onRoleRatingChange(((ChildRatingChangeArg)this.arg).roleId, ((ChildRatingChangeArg)this.arg).childId, ((ChildRatingChangeArg)this.arg).byDelete);
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnChildRatingChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */