/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ 
/*    */ public class GiveBirthTimerEventArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long intervalMillSeconds;
/*    */   public final long marriedId;
/*    */   public final long partnerRoleId;
/*    */   public final long giveBirthScoreEnoughTime;
/*    */   
/*    */   public GiveBirthTimerEventArg(long roleId, long intervalMillSeconds, long marriedId, long partnerRoleId, long giveBirthScoreEnoughTime)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.intervalMillSeconds = intervalMillSeconds;
/* 16 */     this.marriedId = marriedId;
/* 17 */     this.partnerRoleId = partnerRoleId;
/* 18 */     this.giveBirthScoreEnoughTime = giveBirthScoreEnoughTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\GiveBirthTimerEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */