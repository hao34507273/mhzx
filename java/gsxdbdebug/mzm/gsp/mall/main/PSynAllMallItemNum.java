/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PSynAllMallItemNum
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PSynAllMallItemNum(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     MallManager.synAllMallItemNum(this.roleid);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\PSynAllMallItemNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */