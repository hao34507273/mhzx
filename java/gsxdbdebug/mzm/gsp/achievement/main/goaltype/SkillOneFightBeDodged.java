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
/*    */ public class SkillOneFightBeDodged
/*    */   extends AbstractSkillResultMeetTimes
/*    */ {
/*    */   protected Map<Integer, Integer> getSkillResultCountMap(SkillResult skillResultData)
/*    */   {
/* 17 */     return skillResultData.getSkillbedodgecountinfight();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 23 */     return 5125;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOneFightBeDodged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */