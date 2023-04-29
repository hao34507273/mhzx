/*    */ package mzm.gsp.lifeskill.event;
/*    */ 
/*    */ 
/*    */ public class LifeSkillLevelUpArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int skillId;
/*    */   
/*    */   public final int lifeSkillType;
/*    */   
/*    */   public final int beforeSkillLevel;
/*    */   
/*    */   public final int afterSkillLevel;
/*    */   
/*    */   public final int unlockItemNum;
/*    */   
/*    */ 
/*    */   public LifeSkillLevelUpArg(long roleId, int skillId, int beforeSkillLevel, int afterSkillLevel, int lifeSkillType, int unlockItemNum)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.skillId = skillId;
/* 23 */     this.beforeSkillLevel = beforeSkillLevel;
/* 24 */     this.afterSkillLevel = afterSkillLevel;
/* 25 */     this.lifeSkillType = lifeSkillType;
/* 26 */     this.unlockItemNum = unlockItemNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\event\LifeSkillLevelUpArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */