/*    */ package mzm.gsp.homeland.mysteryvisitor;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*    */ import mzm.gsp.marriage.event.DivorceArg;
/*    */ import mzm.gsp.marriage.event.DivorceEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnDivorce
/*    */   extends DivorceEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if ((MysteryVisitorManager.isMysteryVisitorSwitchOpen()) && (ActivityInterface.isActivityOpen(MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID)))
/*    */     {
/*    */ 
/* 19 */       MysteryVisitorTaskOneByOne.getInstance().add(new PTryClearMysteryVisitor(((DivorceArg)this.arg).roleidA));
/* 20 */       MysteryVisitorTaskOneByOne.getInstance().add(new PTryClearMysteryVisitor(((DivorceArg)this.arg).roleidB));
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\POnDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */