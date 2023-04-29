/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ 
/*    */ public class ChildBabyPeriodBreedTimerArg
/*    */ {
/*    */   public final long intervalMillSeconds;
/*    */   public final long roleId;
/*    */   public final long childId;
/*    */   public final int operator;
/*    */   public final long babyPeriodOperatorStartTime;
/*    */   
/*    */   public ChildBabyPeriodBreedTimerArg(long intervalMillSeconds, long roleId, long childId, int operator, long babyPeriodOperatorStartTime)
/*    */   {
/* 14 */     this.intervalMillSeconds = intervalMillSeconds;
/* 15 */     this.roleId = roleId;
/* 16 */     this.childId = childId;
/* 17 */     this.operator = operator;
/* 18 */     this.babyPeriodOperatorStartTime = babyPeriodOperatorStartTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildBabyPeriodBreedTimerArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */