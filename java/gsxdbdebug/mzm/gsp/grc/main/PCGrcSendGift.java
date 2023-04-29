/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PCGrcSendGift
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int giftType;
/*    */   private final Octets to;
/*    */   
/*    */   public PCGrcSendGift(long roleId, int giftType, Octets to)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.giftType = giftType;
/* 18 */     this.to = to;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!GrcManager.canDoAction(this.roleId, 300))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     return GrcManager.sendGift(this.giftType, this.roleId, this.to);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGrcSendGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */