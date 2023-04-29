/*     */ package mzm.gsp.skill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.skill.confbean.SSkillBagCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillBagMenPaiCfg;
/*     */ import mzm.gsp.skill.confbean.STMenPaiSkillBagLevelUpCfg;
/*     */ import mzm.gsp.skill.confbean.SkillBagSkill2NeedLevel;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSkillBags;
/*     */ import xtable.Role2skillbag;
/*     */ 
/*     */ class MenPaiSkillBagManager
/*     */ {
/*  18 */   private static final Logger logger = Logger.getLogger(MenPaiSkillBagManager.class);
/*     */   
/*  20 */   private static MenPaiSkillBagManager instance = new MenPaiSkillBagManager();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static MenPaiSkillBagManager getInstance()
/*     */   {
/*  31 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void syncBagInfo(RoleSkillBags xSkillBagInfo, long roleid)
/*     */   {
/*  45 */     if (xSkillBagInfo.getMenpai().isEmpty()) {
/*  46 */       return;
/*     */     }
/*  48 */     mzm.gsp.skill.SSyncMenPaiSkillBagInfo menpaiBagInfo = new mzm.gsp.skill.SSyncMenPaiSkillBagInfo();
/*  49 */     for (Map.Entry<Integer, Integer> entry : xSkillBagInfo.getMenpai().entrySet()) {
/*  50 */       mzm.gsp.skill.MenPaiSkillBagInfo one = new mzm.gsp.skill.MenPaiSkillBagInfo();
/*  51 */       one.skillbagid = ((Integer)entry.getKey()).intValue();
/*  52 */       one.level = ((Integer)entry.getValue()).intValue();
/*  53 */       menpaiBagInfo.skillbags.add(one);
/*     */     }
/*  55 */     mzm.gsp.online.main.OnlineManager.getInstance().send(roleid, menpaiBagInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   java.util.Collection<? extends Skill> getSkillBagSkills(int bagid, int bagLevel)
/*     */   {
/*  66 */     List<Skill> skills = new ArrayList();
/*  67 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(bagid);
/*  68 */     if (skillBagCfg == null) {
/*  69 */       GameServer.logger().error("配置的技能包不存在!bagid:" + bagid);
/*  70 */       return skills;
/*     */     }
/*  72 */     for (SkillBagSkill2NeedLevel skill2NeedLevel : skillBagCfg.skillid2NeedLevel) {
/*  73 */       if (skill2NeedLevel.needlevel <= bagLevel) {
/*  74 */         Skill skill = SkillManager.getSkill(skill2NeedLevel.skillid, bagLevel);
/*  75 */         if (skill != null) {
/*  76 */           skills.add(skill);
/*     */         }
/*     */       }
/*     */     }
/*  80 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   java.util.Collection<? extends PassiveSkill> getSkillBagPassiveSkills(int bagid, int bagLevel)
/*     */   {
/*  91 */     List<PassiveSkill> skills = new ArrayList();
/*  92 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(bagid);
/*  93 */     if (skillBagCfg == null) {
/*  94 */       GameServer.logger().error("配置的技能包不存在!bagid:" + bagid);
/*  95 */       return skills;
/*     */     }
/*  97 */     for (SkillBagSkill2NeedLevel skill2NeedLevel : skillBagCfg.skillid2NeedLevel) {
/*  98 */       if (skill2NeedLevel.needlevel <= bagLevel) {
/*  99 */         PassiveSkill skill = SkillManager.getPassiveSkill(skill2NeedLevel.skillid, bagLevel);
/* 100 */         if (skill != null) {
/* 101 */           skills.add(skill);
/*     */         }
/*     */       }
/*     */     }
/* 105 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   java.util.Collection<? extends EnchantSkill> getSkillBagEnchantSkills(int bagid, int bagLevel)
/*     */   {
/* 116 */     List<EnchantSkill> skills = new ArrayList();
/* 117 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(bagid);
/* 118 */     if (skillBagCfg == null) {
/* 119 */       GameServer.logger().error("配置的技能包不存在!bagid:" + bagid);
/* 120 */       return skills;
/*     */     }
/* 122 */     for (SkillBagSkill2NeedLevel skill2NeedLevel : skillBagCfg.skillid2NeedLevel) {
/* 123 */       if (skill2NeedLevel.needlevel <= bagLevel) {
/* 124 */         EnchantSkill skill = SkillManager.getEnchantSkill(skill2NeedLevel.skillid, bagLevel);
/* 125 */         if (skill != null) {
/* 126 */           skills.add(skill);
/*     */         }
/*     */       }
/*     */     }
/* 130 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean cheSkillBagHasSkill(int bagid, int skillid)
/*     */   {
/* 142 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(bagid);
/* 143 */     if (skillBagCfg == null) {
/* 144 */       GameServer.logger().error("配置的技能包不存在!bagid:" + bagid);
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     for (SkillBagSkill2NeedLevel skill2NeedLevel : skillBagCfg.skillid2NeedLevel) {
/* 149 */       if (skill2NeedLevel.skillid == skillid) {
/* 150 */         return true;
/*     */       }
/*     */     }
/* 153 */     return false;
/*     */   }
/*     */   
/*     */   mzm.gsp.skill.confbean.STMenPaiSkillBagLevelUpCfgInfo getMenPaiLevelCfgInfo(int skillBagId, int level) {
/* 157 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(skillBagId);
/* 158 */     if (skillBagCfg == null) {
/* 159 */       return null;
/*     */     }
/* 161 */     STMenPaiSkillBagLevelUpCfg stMenPaiSkillBagLevelUpCfg = STMenPaiSkillBagLevelUpCfg.get(skillBagCfg.levelcfgid);
/* 162 */     if ((stMenPaiSkillBagLevelUpCfg == null) || (stMenPaiSkillBagLevelUpCfg.level2skillinfo == null)) {
/* 163 */       return null;
/*     */     }
/* 165 */     mzm.gsp.skill.confbean.STMenPaiSkillBagLevelUpCfgInfo stMenPaiSkillBagLevelUpCfgInfo = (mzm.gsp.skill.confbean.STMenPaiSkillBagLevelUpCfgInfo)stMenPaiSkillBagLevelUpCfg.level2skillinfo.get(Integer.valueOf(level));
/*     */     
/* 167 */     if (stMenPaiSkillBagLevelUpCfgInfo == null) {
/* 168 */       return null;
/*     */     }
/* 170 */     return stMenPaiSkillBagLevelUpCfgInfo;
/*     */   }
/*     */   
/*     */   void openFunction(long roleId) {
/* 174 */     RoleSkillBags xRoleSkillBag = Role2skillbag.get(Long.valueOf(roleId));
/* 175 */     if (xRoleSkillBag == null) {
/* 176 */       xRoleSkillBag = xbean.Pod.newRoleSkillBags();
/* 177 */       Role2skillbag.add(Long.valueOf(roleId), xRoleSkillBag);
/*     */     }
/* 179 */     if (!xRoleSkillBag.getMenpai().isEmpty()) {
/* 180 */       return;
/*     */     }
/* 182 */     int ocpId = mzm.gsp.role.main.RoleInterface.getOccupationId(roleId);
/* 183 */     SSkillBagMenPaiCfg menPaiCfg = getMenPaiSkillBagCfg(ocpId);
/*     */     
/* 185 */     if (menPaiCfg == null) {
/* 186 */       logger.error("can not find menPai skill bag config, menPai id = " + ocpId);
/* 187 */       return;
/*     */     }
/* 189 */     Map<Integer, Integer> menPaiMap = xRoleSkillBag.getMenpai();
/* 190 */     for (Integer bagCfgId : menPaiCfg.bag) {
/* 191 */       SSkillBagCfg bagCfg = SSkillBagCfg.get(bagCfgId.intValue());
/* 192 */       menPaiMap.put(Integer.valueOf(bagCfg.id), Integer.valueOf(bagCfg.initlevel));
/*     */     }
/*     */     
/* 195 */     syncBagInfo(xRoleSkillBag, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   SSkillBagMenPaiCfg getMenPaiSkillBagCfg(int menPai)
/*     */   {
/* 204 */     for (SSkillBagMenPaiCfg cfg : SSkillBagMenPaiCfg.getAll().values()) {
/* 205 */       if (cfg.menpaiid == menPai) {
/* 206 */         return cfg;
/*     */       }
/*     */     }
/* 209 */     return null;
/*     */   }
/*     */   
/*     */   List<PassiveSkill> getPassiveSkillList(int bagId, int level) {
/* 213 */     List<PassiveSkill> skills = new ArrayList();
/* 214 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(bagId);
/* 215 */     if (skillBagCfg == null) {
/* 216 */       GameServer.logger().error("配置的技能包不存在!bagid:" + bagId);
/* 217 */       return skills;
/*     */     }
/* 219 */     for (SkillBagSkill2NeedLevel skill2NeedLevel : skillBagCfg.skillid2NeedLevel) {
/* 220 */       if (skill2NeedLevel.needlevel <= level) {
/* 221 */         PassiveSkill skill = SkillManager.getPassiveSkill(skill2NeedLevel.skillid, level);
/* 222 */         if (skill != null) {
/* 223 */           skills.add(skill);
/*     */         }
/*     */       }
/*     */     }
/* 227 */     return skills;
/*     */   }
/*     */   
/*     */   List<PassiveSkill> getPassiveSkillList(long roleId) {
/* 231 */     RoleSkillBags xRoleSkillBags = Role2skillbag.get(Long.valueOf(roleId));
/* 232 */     List<PassiveSkill> skillList = new ArrayList();
/* 233 */     if (xRoleSkillBags == null) {
/* 234 */       return skillList;
/*     */     }
/* 236 */     Map<Integer, Integer> menPaiSkillBags = xRoleSkillBags.getMenpai();
/* 237 */     for (Map.Entry<Integer, Integer> entry : menPaiSkillBags.entrySet()) {
/* 238 */       skillList.addAll(getPassiveSkillList(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()));
/*     */     }
/* 240 */     return skillList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\MenPaiSkillBagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */