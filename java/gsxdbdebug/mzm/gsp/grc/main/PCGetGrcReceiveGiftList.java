/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGetGrcReceiveGiftList
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int pageIndex;
/*    */   
/*    */   public PCGetGrcReceiveGiftList(long roleId, int pageIndex)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.pageIndex = pageIndex;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!GrcManager.canDoAction(this.roleId, 293))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     return GrcManager.getReceiveGiftList(this.roleId, this.pageIndex);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGetGrcReceiveGiftList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */