/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.friend.event.FriendPointChangeArg;
/*    */ import mzm.gsp.marriage.event.MarrySkillChangeArg;
/*    */ import xbean.MarriageSkill;
/*    */ import xtable.Role2marriageskill;
/*    */ 
/*    */ public class POnFriendPointChange extends mzm.gsp.friend.event.FriendPointChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     lock(Role2marriageskill.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(((FriendPointChangeArg)this.arg).roleid1), Long.valueOf(((FriendPointChangeArg)this.arg).roleid2) }));
/* 16 */     MarriageSkill xMarriageSkill1 = Role2marriageskill.get(Long.valueOf(((FriendPointChangeArg)this.arg).roleid1));
/* 17 */     if (xMarriageSkill1 == null) {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     MarriageSkill xMarriageSkill2 = Role2marriageskill.get(Long.valueOf(((FriendPointChangeArg)this.arg).roleid2));
/* 22 */     if (xMarriageSkill2 == null) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     Map<Integer, Integer> skillMap = new java.util.HashMap();
/*    */     
/* 28 */     int friendValue = ((FriendPointChangeArg)this.arg).totalPoint;
/* 29 */     MarriageManager.getMarriageSkill(skillMap, friendValue);
/* 30 */     boolean changed = false;
/* 31 */     for (Map.Entry<Integer, Integer> skillEntry : skillMap.entrySet()) {
/* 32 */       Integer skillLv = (Integer)xMarriageSkill1.getSkills().get(skillEntry.getKey());
/* 33 */       if ((skillLv == null) || (skillLv != skillEntry.getValue())) {
/* 34 */         changed = true;
/* 35 */         break;
/*    */       }
/*    */     }
/* 38 */     if (!changed) {
/* 39 */       return false;
/*    */     }
/* 41 */     xMarriageSkill1.getSkills().clear();
/* 42 */     xMarriageSkill1.getSkills().putAll(skillMap);
/* 43 */     xMarriageSkill2.getSkills().clear();
/* 44 */     xMarriageSkill2.getSkills().putAll(skillMap);
/*    */     
/*    */ 
/* 47 */     MarrySkillChangeArg marrySkillChangeArg1 = new MarrySkillChangeArg(((FriendPointChangeArg)this.arg).roleid1);
/* 48 */     marrySkillChangeArg1.skill2Lv.putAll(skillMap);
/* 49 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.marriage.event.MarrySkillChange(), marrySkillChangeArg1);
/*    */     
/* 51 */     MarrySkillChangeArg marrySkillChangeArg2 = new MarrySkillChangeArg(((FriendPointChangeArg)this.arg).roleid1);
/* 52 */     marrySkillChangeArg2.skill2Lv.putAll(skillMap);
/* 53 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.marriage.event.MarrySkillChange(), marrySkillChangeArg2);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnFriendPointChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */