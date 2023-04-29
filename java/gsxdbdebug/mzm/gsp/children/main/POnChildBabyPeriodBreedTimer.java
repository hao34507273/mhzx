/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildBabyPeriodBreedTimerArg;
/*    */ import mzm.gsp.children.event.ChildBabyPeriodBreedTimerProcedure;
/*    */ 
/*    */ public class POnChildBabyPeriodBreedTimer extends ChildBabyPeriodBreedTimerProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long childId = ((ChildBabyPeriodBreedTimerArg)this.arg).childId;
/* 11 */     xbean.ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(childId));
/* 12 */     if (xChildInfo == null)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     BabyPeriodBreedObserver observer = new BabyPeriodBreedObserver(((ChildBabyPeriodBreedTimerArg)this.arg).intervalMillSeconds, ((ChildBabyPeriodBreedTimerArg)this.arg).roleId, childId, ((ChildBabyPeriodBreedTimerArg)this.arg).operator, ((ChildBabyPeriodBreedTimerArg)this.arg).babyPeriodOperatorStartTime);
/*    */     
/*    */ 
/*    */ 
/* 20 */     xbean.BreedObserver xBreedObserver = xtable.Breedobservers.get(Long.valueOf(childId));
/* 21 */     if (xBreedObserver == null)
/*    */     {
/* 23 */       xBreedObserver = xbean.Pod.newBreedObserver();
/* 24 */       xtable.Breedobservers.add(Long.valueOf(childId), xBreedObserver);
/*    */     }
/*    */     
/* 27 */     BabyPeriodBreedObserver oldObserver = xBreedObserver.getObserver();
/* 28 */     if (oldObserver != null)
/*    */     {
/* 30 */       oldObserver.stopTimer();
/*    */     }
/*    */     
/* 33 */     xBreedObserver.setObserver(observer);
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnChildBabyPeriodBreedTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */