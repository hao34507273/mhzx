/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.children.confbean.SChildrenConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetChildWelfareMaxSize
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int maxChildSize;
/*    */   
/*    */   public PGM_SetChildWelfareMaxSize(long roleId, int maxChildSize)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.maxChildSize = maxChildSize;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     SChildrenConsts.getInstance().discard_child_num_limit = this.maxChildSize;
/*    */     
/* 24 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前福利院最大上限是 " + this.maxChildSize);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_SetChildWelfareMaxSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */