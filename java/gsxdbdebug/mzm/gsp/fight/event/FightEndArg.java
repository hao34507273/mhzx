/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.main.FighterRole;
/*    */ import xbean.SkillResult;
/*    */ 
/*    */ public class FightEndArg
/*    */ {
/* 10 */   public final Map<Long, Integer> roleUseSkillCountMap = new HashMap();
/* 11 */   public final Map<Long, Integer> roleUseProtectionCountMap = new HashMap();
/* 12 */   public final Map<Long, Integer> roleUseItemCountMap = new HashMap();
/* 13 */   public final Map<Long, Integer> roleDeadCountMap = new HashMap();
/*    */   
/* 15 */   public final Map<Long, SkillResult> roleSkillResult = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRoleCountInfo(FighterRole fighter)
/*    */   {
/* 25 */     this.roleUseSkillCountMap.put(Long.valueOf(fighter.getRoleid()), Integer.valueOf(fighter.getUseSkillCount()));
/* 26 */     this.roleUseProtectionCountMap.put(Long.valueOf(fighter.getRoleid()), Integer.valueOf(fighter.getUseProtectionCount()));
/* 27 */     this.roleUseItemCountMap.put(Long.valueOf(fighter.getRoleid()), Integer.valueOf(fighter.getUseItemCount()));
/* 28 */     this.roleDeadCountMap.put(Long.valueOf(fighter.getRoleid()), Integer.valueOf(fighter.getDeadCount()));
/*    */     
/* 30 */     this.roleSkillResult.put(Long.valueOf(fighter.getRoleid()), fighter.getSkillResult().copy());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\FightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */