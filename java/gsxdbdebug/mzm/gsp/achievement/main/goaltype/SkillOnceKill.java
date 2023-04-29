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
/*    */ public class SkillOnceKill
/*    */   extends AbstractSkillResultMeetTimes
/*    */ {
/*    */   protected Map<Integer, Integer> getSkillResultCountMap(SkillResult skillResultData)
/*    */   {
/* 17 */     return skillResultData.getSkillkillcountinround();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 23 */     return 5122;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\SkillOnceKill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */