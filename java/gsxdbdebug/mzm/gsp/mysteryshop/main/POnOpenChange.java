/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((OpenChangeComplexArg)this.arg).getType() != 322)
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     if (!((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 30 */     return new UpdateMysteryResetTime(5, cur).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */