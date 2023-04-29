/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillOneFightFail
/*    */   extends AbstractSkillResultMeetTimes
/*    */ {
/*    */   protected Map<Integer, Integer> getSkillResultCountMap(SkillResult skillResultData)
/*    */   {
/* 22 */     return skillResultData.getSkillfailedcountinfight();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 5128;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */