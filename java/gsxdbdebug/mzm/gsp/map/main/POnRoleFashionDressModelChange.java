/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.event.FashionDressModelArg;
/*    */ import mzm.gsp.fashiondress.event.FashionDressModelChangeProcedure;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleFashionDressModelChange;
/*    */ import mzm.gsp.roledye.main.RoleDyeInterface;
/*    */ 
/*    */ public class POnRoleFashionDressModelChange extends FashionDressModelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (((FashionDressModelArg)this.arg).changeReason == mzm.gsp.fashiondress.main.FashionDressChangeReasonEnum.CHANGE_OCCUPATION)
/*    */     {
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     long roleid = ((FashionDressModelArg)this.arg).roleId;
/* 18 */     mzm.gsp.roledye.ColorIds colorIds = RoleDyeInterface.getRoleCurClothesNoLock(roleid);
/* 19 */     if (colorIds == null)
/*    */     {
/* 21 */       return true;
/*    */     }
/*    */     
/* 24 */     new MMH_OnRoleFashionDressModelChange(roleid, colorIds).execute();
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleFashionDressModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */