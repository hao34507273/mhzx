/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ public class PartnerPositionChangeEventArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final PositionChangeTye changeTye;
/*    */   
/*    */   public static enum PositionChangeTye
/*    */   {
/* 10 */     CHANGE_DEFAULT_LINEUP, 
/* 11 */     ADD_PARTNER, 
/* 12 */     RM_PARTNER, 
/* 13 */     CHANGE_ZHAN_WEI;
/*    */     
/*    */     private PositionChangeTye() {}
/*    */   }
/*    */   
/* 18 */   public PartnerPositionChangeEventArg(long roleId, PositionChangeTye changeTye) { this.roleId = roleId;
/* 19 */     this.changeTye = changeTye;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerPositionChangeEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */