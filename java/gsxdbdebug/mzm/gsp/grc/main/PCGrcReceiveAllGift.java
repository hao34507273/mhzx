/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGrcReceiveAllGift
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGrcReceiveAllGift(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!GrcManager.canDoAction(this.roleid, 298))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     return GrcManager.receiveAllGift(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGrcReceiveAllGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */