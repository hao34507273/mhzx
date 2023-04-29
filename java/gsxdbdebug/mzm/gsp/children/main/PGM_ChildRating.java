/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.ChildInfo;
/*    */ import xtable.Children;
/*    */ 
/*    */ public class PGM_ChildRating extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long childId;
/*    */   
/*    */   public PGM_ChildRating(long roleId, long childId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.childId = childId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */   {
/* 21 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "功能开关未打开");
/* 24 */       return false;
/*    */     }
/* 26 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childId));
/* 27 */     if (null == xChildInfo)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "孩子不存在");
/* 30 */       return false;
/*    */     }
/* 32 */     if (xChildInfo.getChild_period() != 2)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, "孩子不是长成期");
/* 35 */       return false;
/*    */     }
/* 37 */     int childRating = ChildrenManager.getChildRating(this.childId, true);
/* 38 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("孩子评分：%d", new Object[] { Integer.valueOf(childRating) }));
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_ChildRating.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */