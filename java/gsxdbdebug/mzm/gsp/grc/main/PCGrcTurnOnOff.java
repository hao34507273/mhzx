/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCGrcTurnOnOff
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int giftType;
/*    */   private final boolean onOff;
/*    */   
/*    */   public PCGrcTurnOnOff(long roleid, int giftType, boolean onOff)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.giftType = giftType;
/* 16 */     this.onOff = onOff;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!GrcManager.canDoAction(this.roleid, 301))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     return GrcManager.turnOnOffGiftRcv(this.roleid, this.giftType, this.onOff);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\PCGrcTurnOnOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */