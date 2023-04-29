/*    */ package mzm.gsp.gangskill.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangSkillInterface
/*    */ {
/*    */   public static Map<Integer, Integer> getGangSkillid2Level(long roleid)
/*    */   {
/* 15 */     return GangSkillManager.getGangSkillid2Level(roleid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getGangSkillLevel(long roleid, int skill)
/*    */   {
/* 28 */     Map<Integer, Integer> skills = GangSkillManager.getGangSkillid2Level(roleid);
/* 29 */     Integer level = (Integer)skills.get(Integer.valueOf(skill));
/* 30 */     if (level == null)
/*    */     {
/* 32 */       return 0;
/*    */     }
/* 34 */     return level.intValue();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getGangSkillScore(long roleid, boolean holdLock)
/*    */   {
/* 46 */     return GangSkillManager.getGangSkillScore(roleid, holdLock);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\GangSkillInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */