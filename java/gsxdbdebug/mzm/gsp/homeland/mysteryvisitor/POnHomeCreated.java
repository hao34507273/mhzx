/*    */ package mzm.gsp.homeland.mysteryvisitor;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*    */ import mzm.gsp.homeland.event.CreateHomeArg;
/*    */ import mzm.gsp.homeland.event.CreateHomeEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnHomeCreated
/*    */   extends CreateHomeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if ((MysteryVisitorManager.isMysteryVisitorSwitchOpen()) && (ActivityInterface.isActivityOpen(MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID)))
/*    */     {
/*    */ 
/* 19 */       MysteryVisitorTaskOneByOne.getInstance().add(new PTrySetMysteryVisitor(((CreateHomeArg)this.arg).ownerRoleId));
/* 20 */       if (((CreateHomeArg)this.arg).partnerRoleId > 0L)
/*    */       {
/* 22 */         MysteryVisitorTaskOneByOne.getInstance().add(new PTrySetMysteryVisitor(((CreateHomeArg)this.arg).partnerRoleId));
/*    */       }
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\POnHomeCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */