/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGrcReceiveGift
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int giftType;
/*    */   private final long serialid;
/*    */   
/*    */   public PCGrcReceiveGift(long roleId, int giftType, long serialid)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.serialid = serialid;
/* 16 */     this.giftType = giftType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!GrcManager.canDoAction(this.roleId, 299))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     return GrcManager.receiveGift(this.roleId, this.giftType, this.serialid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGrcReceiveGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */