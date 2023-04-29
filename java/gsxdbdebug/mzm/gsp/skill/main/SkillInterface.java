/*      */ package mzm.gsp.skill.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.effect.main.OutFightEffect;
/*      */ import mzm.gsp.effect.outfight.AddFanShengBianYiRateEffect;
/*      */ import mzm.gsp.effect.outfight.AddHuaShengRateEffect;
/*      */ import mzm.gsp.effect.outfight.AddQiLingRateEffect;
/*      */ import mzm.gsp.effect.outfight.EquipmentDurable;
/*      */ import mzm.gsp.effect.outfight.EquipmentLevelVary;
/*      */ import mzm.gsp.effect.outfight.EquipmentPropertiesRate;
/*      */ import mzm.gsp.fabao.main.FabaoInterface;
/*      */ import mzm.gsp.fabaolingqi.main.FabaoArtifactInterface;
/*      */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*      */ import mzm.gsp.gangskill.main.GangSkillInterface;
/*      */ import mzm.gsp.genius.main.GeniusInterface;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.magicmark.main.MagicMarkInterface;
/*      */ import mzm.gsp.marriage.main.MarriageInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.skill.SSyncTempSkillListAdd;
/*      */ import mzm.gsp.skill.SSyncTempSkillListRemove;
/*      */ import mzm.gsp.skill.confbean.MarrySkillCfg;
/*      */ import mzm.gsp.skill.confbean.MonsterSkill2Prob;
/*      */ import mzm.gsp.skill.confbean.SMonsterSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SPassiveSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillBagCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillBagMenPaiCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*      */ import mzm.gsp.skill.confbean.SkillBagSkill2NeedLevel;
/*      */ import mzm.gsp.skill.formula.fighter.SkillFormula;
/*      */ import mzm.gsp.skill.formula.fighter.SkillFormulaFactory;
/*      */ import mzm.gsp.wing.main2.WingInterface;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*      */ import xbean.Pod;
/*      */ import xbean.RoleSkillBags;
/*      */ import xbean.RoleTempSkillList;
/*      */ import xtable.Role2skillbag;
/*      */ import xtable.Role2tempskill;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SkillInterface
/*      */ {
/*      */   public static List<Integer> getMonsterRandomSkill(int monsterskillid, int skillnum)
/*      */   {
/*   65 */     return SkillConfigManager.getInstance().getMonsterSkills(monsterskillid, skillnum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getAllMonsterRandomSkill(int monsterSkillId)
/*      */   {
/*   76 */     List<Integer> list = new ArrayList();
/*   77 */     SMonsterSkillCfg sMonsterSkillCfg = SMonsterSkillCfg.get(monsterSkillId);
/*   78 */     if (sMonsterSkillCfg == null)
/*      */     {
/*   80 */       return list;
/*      */     }
/*   82 */     for (MonsterSkill2Prob m2p : sMonsterSkillCfg.monsterSkill2Prob)
/*      */     {
/*   84 */       list.add(Integer.valueOf(m2p.skillid));
/*      */     }
/*   86 */     return list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Integer> getMonsterRandomSkill(int monsterskillid, Set<Integer> skills, int skillnum)
/*      */   {
/*  102 */     return SkillConfigManager.getInstance().getMonsterSkills(monsterskillid, skills, skillnum);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getMonsterRandomSkill(int monsterSkillId)
/*      */   {
/*  113 */     return SkillConfigManager.getInstance().getMonsterSkills(monsterSkillId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Skill> getRoleSKills(long roleId, boolean retainRoleLock)
/*      */   {
/*  129 */     List<Skill> skillList = new ArrayList();
/*  130 */     RoleSkillBags xSkillBags; RoleSkillBags xSkillBags; if (retainRoleLock)
/*      */     {
/*  132 */       xSkillBags = Role2skillbag.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  136 */       xSkillBags = Role2skillbag.select(Long.valueOf(roleId));
/*      */     }
/*  138 */     if (xSkillBags == null)
/*      */     {
/*  140 */       return skillList;
/*      */     }
/*      */     
/*  143 */     SSkillBagMenPaiCfg menPaiSkillBagCfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(RoleInterface.getOccupationId(roleId));
/*      */     
/*  145 */     for (Iterator i$ = menPaiSkillBagCfg.bag.iterator(); i$.hasNext();) { int skillBagId = ((Integer)i$.next()).intValue();
/*      */       
/*  147 */       Integer skillBagLv = (Integer)xSkillBags.getMenpai().get(Integer.valueOf(skillBagId));
/*  148 */       if (skillBagLv != null)
/*      */       {
/*  150 */         for (Skill skill : MenPaiSkillBagManager.getInstance().getSkillBagSkills(skillBagId, skillBagLv.intValue()))
/*      */         {
/*  152 */           skillList.add(skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  157 */     RoleTempSkillList xRoleTempSkillList = Role2tempskill.get(Long.valueOf(roleId));
/*  158 */     if (xRoleTempSkillList != null)
/*      */     {
/*  160 */       for (Map.Entry<Integer, Integer> entry : xRoleTempSkillList.getSkilllist().entrySet())
/*      */       {
/*  162 */         Skill skill = SkillManager.getSkill(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*  163 */         if (skill != null)
/*      */         {
/*  165 */           skillList.add(skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  171 */     skillList.addAll(FabaoInterface.getFaBaoSysSkills(roleId, retainRoleLock));
/*      */     
/*      */ 
/*      */ 
/*  175 */     Collection<Integer> skills = FabaoArtifactInterface.getArtifactSkills(roleId, retainRoleLock);
/*  176 */     for (Iterator i$ = skills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  178 */       Skill skill = SkillManager.getSkill(skillId, 1);
/*  179 */       if (skill != null)
/*      */       {
/*  181 */         skillList.add(skill);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  188 */     List<Integer> skillIdList = new ArrayList(WingInterface.getCurWingPlanSkills(roleId, retainRoleLock).keySet());
/*      */     
/*  190 */     for (Iterator i$ = skillIdList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  192 */       Skill skill = SkillManager.getSkill(skillId, 1);
/*  193 */       if (skill != null)
/*      */       {
/*  195 */         skillList.add(skill);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  201 */     Map<Integer, Integer> gangSkillIdList = GangSkillInterface.getGangSkillid2Level(roleId);
/*  202 */     for (Iterator i$ = gangSkillIdList.keySet().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  204 */       int level = ((Integer)gangSkillIdList.get(Integer.valueOf(skillId))).intValue();
/*  205 */       if (level > 0)
/*      */       {
/*  207 */         Skill skill = SkillManager.getSkill(skillId, ((Integer)gangSkillIdList.get(Integer.valueOf(skillId))).intValue());
/*  208 */         if (skill != null)
/*      */         {
/*  210 */           skillList.add(skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  216 */     Map<Integer, Integer> marrySkills = MarriageInterface.getMarrySkills(roleId, false);
/*  217 */     for (Map.Entry<Integer, Integer> skillEntry : marrySkills.entrySet())
/*      */     {
/*  219 */       if (((Integer)skillEntry.getValue()).intValue() > 0)
/*      */       {
/*  221 */         Skill skill = SkillManager.getSkill(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue());
/*  222 */         if (skill != null)
/*      */         {
/*  224 */           skillList.add(skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  233 */     Map<Integer, Integer> sourceReplaces = GeniusInterface.getActiveSkills(roleId, retainRoleLock);
/*  234 */     for (Map.Entry<Integer, Integer> entry : sourceReplaces.entrySet())
/*      */     {
/*  236 */       SkillManager.replaceSkill(skillList, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*      */     }
/*      */     
/*      */ 
/*  240 */     return skillList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<PassiveSkill> getRolePassiveSKills(long roleId, boolean retainRoleLock)
/*      */   {
/*  255 */     List<PassiveSkill> skillList = new ArrayList();
/*  256 */     RoleSkillBags xSkillBags; RoleSkillBags xSkillBags; if (retainRoleLock)
/*      */     {
/*  258 */       xSkillBags = Role2skillbag.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  262 */       xSkillBags = Role2skillbag.select(Long.valueOf(roleId));
/*      */     }
/*  264 */     if (xSkillBags == null)
/*      */     {
/*  266 */       return skillList;
/*      */     }
/*      */     
/*  269 */     for (Map.Entry<Integer, Integer> menPaiSkillEntry : xSkillBags.getMenpai().entrySet())
/*      */     {
/*  271 */       for (PassiveSkill skill : MenPaiSkillBagManager.getInstance().getSkillBagPassiveSkills(((Integer)menPaiSkillEntry.getKey()).intValue(), ((Integer)menPaiSkillEntry.getValue()).intValue()))
/*      */       {
/*      */ 
/*  274 */         skillList.add(skill);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  280 */     List<Integer> wingSkillList = new ArrayList(WingInterface.getCurWingPlanSkills(roleId, retainRoleLock).keySet());
/*      */     
/*  282 */     for (Iterator i$ = wingSkillList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */       
/*  284 */       PassiveSkill skill = SkillManager.getPassiveSkill(id, 1);
/*  285 */       if (skill != null)
/*      */       {
/*  287 */         skillList.add(skill);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  294 */     Map<Integer, Integer> gangSkillIdList = GangSkillInterface.getGangSkillid2Level(roleId);
/*  295 */     for (Iterator i$ = gangSkillIdList.keySet().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  297 */       int level = ((Integer)gangSkillIdList.get(Integer.valueOf(skillId))).intValue();
/*  298 */       if (level > 0)
/*      */       {
/*  300 */         PassiveSkill skill = SkillManager.getPassiveSkill(skillId, ((Integer)gangSkillIdList.get(Integer.valueOf(skillId))).intValue());
/*  301 */         if (skill != null)
/*      */         {
/*  303 */           skillList.add(skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  309 */     Map<Integer, Integer> marrySkills = MarriageInterface.getMarrySkills(roleId, false);
/*  310 */     for (Map.Entry<Integer, Integer> skillEntry : marrySkills.entrySet())
/*      */     {
/*  312 */       PassiveSkill passiveSkill = getPassiveSkillById2Lv(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue());
/*  313 */       if (passiveSkill != null)
/*      */       {
/*  315 */         skillList.add(passiveSkill);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  320 */     Map<Integer, Integer> magicSkills = MagicMarkInterface.getMagicMarkPassiveSkillMap(roleId, false);
/*  321 */     for (Map.Entry<Integer, Integer> magicSkillEntry : magicSkills.entrySet())
/*      */     {
/*  323 */       PassiveSkill passiveSkill = getPassiveSkillById2Lv(((Integer)magicSkillEntry.getKey()).intValue(), ((Integer)magicSkillEntry.getValue()).intValue());
/*  324 */       if (passiveSkill != null)
/*      */       {
/*  326 */         skillList.add(passiveSkill);
/*      */       }
/*      */     }
/*      */     
/*  330 */     return skillList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Skill getSkill(int skillid, int skillLv)
/*      */   {
/*  341 */     return SkillManager.getSkill(skillid, skillLv);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Integer, Integer> getOccupationSkillLevel(long roleId, boolean retainLock)
/*      */   {
/*  355 */     Map<Integer, Integer> skillPackageId2Level = new HashMap();
/*  356 */     RoleSkillBags xSkillBags; RoleSkillBags xSkillBags; if (retainLock)
/*      */     {
/*  358 */       xSkillBags = Role2skillbag.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/*  362 */       xSkillBags = Role2skillbag.select(Long.valueOf(roleId));
/*      */     }
/*  364 */     if (xSkillBags == null)
/*      */     {
/*  366 */       return skillPackageId2Level;
/*      */     }
/*      */     
/*  369 */     SSkillBagMenPaiCfg menPaiSkillBagCfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(RoleInterface.getOccupationId(roleId));
/*      */     
/*  371 */     for (Iterator i$ = menPaiSkillBagCfg.bag.iterator(); i$.hasNext();) { int skillBagId = ((Integer)i$.next()).intValue();
/*      */       
/*  373 */       Integer skillBagLv = (Integer)xSkillBags.getMenpai().get(Integer.valueOf(skillBagId));
/*  374 */       if (null != skillBagLv)
/*      */       {
/*  376 */         skillPackageId2Level.put(Integer.valueOf(skillBagId), skillBagLv);
/*      */       }
/*      */     }
/*  379 */     return skillPackageId2Level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isActiveSkill(int skillId)
/*      */   {
/*  390 */     return SSkillCfg.get(skillId) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPassiveSkill(int skillId)
/*      */   {
/*  401 */     return SPassiveSkillCfg.get(skillId) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillExist(int skillId)
/*      */   {
/*  412 */     return (SSkillCfg.get(skillId) != null) || (SPassiveSkillCfg.get(skillId) != null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isHighSkill(int skillId)
/*      */   {
/*  423 */     return SkillConfigManager.getInstance().isHightSkill(skillId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isLowSkill(int skillId)
/*      */   {
/*  434 */     return SkillConfigManager.getInstance().isLowSkill(skillId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSuperSkill(int skillId)
/*      */   {
/*  445 */     return SkillConfigManager.getInstance().isSuperSkill(skillId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SSkillEffectGroupCfg getEffectGroupCfg(int effectgroupid)
/*      */   {
/*  456 */     SSkillEffectGroupCfg effectGroupCfg = SSkillEffectGroupCfg.get(effectgroupid);
/*  457 */     if (effectGroupCfg == null)
/*      */     {
/*  459 */       return null;
/*      */     }
/*  461 */     return effectGroupCfg;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SkillFormula getSkillFormula(int formulaid)
/*      */   {
/*  472 */     return SkillFormulaFactory.getFormula(formulaid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static PassiveSkill getPassiveSkill(int skillId, int skillLv)
/*      */   {
/*  484 */     return SkillManager.getPassiveSkill(skillId, skillLv);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<PassiveSkill> getPassiveSkill(long roleId)
/*      */   {
/*  495 */     List<PassiveSkill> list = new ArrayList();
/*      */     
/*      */ 
/*  498 */     list.addAll(MenPaiSkillBagManager.getInstance().getPassiveSkillList(roleId));
/*      */     
/*  500 */     Map<Integer, Integer> gangSkillIdList = GangSkillInterface.getGangSkillid2Level(roleId);
/*  501 */     for (Iterator i$ = gangSkillIdList.keySet().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  503 */       int level = ((Integer)gangSkillIdList.get(Integer.valueOf(skillId))).intValue();
/*  504 */       if (level > 0)
/*      */       {
/*  506 */         PassiveSkill skill = SkillManager.getPassiveSkill(skillId, ((Integer)gangSkillIdList.get(Integer.valueOf(skillId))).intValue());
/*  507 */         if (skill != null)
/*      */         {
/*  509 */           list.add(skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  514 */     addPassiveSkills(list, ItemInterface.getEquipPassiveSkills(roleId, true));
/*      */     
/*  516 */     addPassiveSkills(list, XiuLianSkillInterface.getXiuLianPassiveSkills(roleId, 1, true));
/*      */     
/*  518 */     addPassiveSkills(list, FashionDressInterface.getFashionDressPassiveSkillList(roleId, true));
/*      */     
/*  520 */     addPassiveSkills(roleId, list, new ArrayList(WingInterface.getCurWingPlanSkills(roleId, true).keySet()));
/*      */     
/*  522 */     addPassiveSkills(roleId, list, MarriageInterface.getMarrySkills(roleId, true));
/*      */     
/*  524 */     addPassiveSkills(roleId, list, MagicMarkInterface.getMagicMarkPassiveSkillMap(roleId, true));
/*      */     
/*  526 */     addPassiveSkills(roleId, list, GeniusInterface.getPassiveSkillMap(roleId, true));
/*      */     
/*  528 */     return list;
/*      */   }
/*      */   
/*      */   private static void addPassiveSkills(List<PassiveSkill> totalSkilllist, List<PassiveSkill> addSkills)
/*      */   {
/*  533 */     if ((addSkills == null) || (addSkills.size() == 0))
/*      */     {
/*  535 */       return;
/*      */     }
/*  537 */     if (totalSkilllist == null)
/*      */     {
/*  539 */       return;
/*      */     }
/*  541 */     totalSkilllist.addAll(addSkills);
/*      */   }
/*      */   
/*      */   private static void addPassiveSkills(long roleId, List<PassiveSkill> totalSkilllist, List<Integer> addSkillList)
/*      */   {
/*  546 */     if ((addSkillList == null) || (addSkillList.size() == 0))
/*      */     {
/*  548 */       return;
/*      */     }
/*  550 */     if (totalSkilllist == null)
/*      */     {
/*  552 */       return;
/*      */     }
/*  554 */     for (Iterator i$ = addSkillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*      */       
/*  556 */       PassiveSkill passiveSkill = getPassiveSkillById2Lv(skillId, 1);
/*  557 */       if (passiveSkill != null)
/*      */       {
/*  559 */         totalSkilllist.add(passiveSkill);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static void addPassiveSkills(long roleId, List<PassiveSkill> totalSkilllist, Map<Integer, Integer> addSkillMap)
/*      */   {
/*  566 */     if ((addSkillMap == null) || (addSkillMap.size() == 0))
/*      */     {
/*  568 */       return;
/*      */     }
/*  570 */     if (totalSkilllist == null)
/*      */     {
/*  572 */       return;
/*      */     }
/*  574 */     for (Map.Entry<Integer, Integer> entry : addSkillMap.entrySet())
/*      */     {
/*  576 */       PassiveSkill passiveSkill = getPassiveSkillById2Lv(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*  577 */       if (passiveSkill != null)
/*      */       {
/*  579 */         totalSkilllist.add(passiveSkill);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static PassiveSkill getPassiveSkillById2Lv(int skill, int lv)
/*      */   {
/*  586 */     return SkillManager.getPassiveSkill(skill, lv);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getHigherSkillId(int skill)
/*      */   {
/*  597 */     return SkillConfigManager.getInstance().getHigherSkill(skill);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Integer> removeMutexSkill(Set<Integer> skillList)
/*      */   {
/*  608 */     return SkillConfigManager.getInstance().removeMutexSkill(skillList);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeMutexSkill(Map<Integer, Integer> skill2Lv)
/*      */   {
/*  619 */     SkillConfigManager.getInstance().removeMutexSkill(skill2Lv);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSameSKill(int skillid, Set<Integer> skillList)
/*      */   {
/*  630 */     return SkillConfigManager.getInstance().isSameSKill(skillid, skillList);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static EnchantSkill getEnchantSkill(long roleId, int skillBagId, int skillid)
/*      */   {
/*  643 */     RoleSkillBags xRoleSkillBags = Role2skillbag.get(Long.valueOf(roleId));
/*  644 */     Integer lv = (Integer)xRoleSkillBags.getMenpai().get(Integer.valueOf(skillBagId));
/*  645 */     if (lv == null)
/*      */     {
/*  647 */       return null;
/*      */     }
/*  649 */     if (!SkillManager.isSkillInBag(skillBagId, skillid))
/*      */     {
/*  651 */       return null;
/*      */     }
/*      */     
/*  654 */     EnchantSkill skill = SkillManager.getEnchantSkill(skillid, lv.intValue());
/*  655 */     return skill;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getExchangeSkill(int skillid, int energy)
/*      */   {
/*  667 */     return SkillConfigManager.getInstance().getExchangeSkill(skillid, energy);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isCanStudy(int occupationid, int skillId)
/*      */   {
/*  679 */     SSkillBagMenPaiCfg menPaiCfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(occupationid);
/*  680 */     for (Iterator i$ = menPaiCfg.bag.iterator(); i$.hasNext();) { int skillBagId = ((Integer)i$.next()).intValue();
/*      */       
/*  682 */       SSkillBagCfg skillBagCfg = SSkillBagCfg.get(skillBagId);
/*  683 */       for (SkillBagSkill2NeedLevel skillIdbean : skillBagCfg.skillid2NeedLevel)
/*      */       {
/*  685 */         if (skillIdbean.skillid == skillId)
/*      */         {
/*  687 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*  691 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addTempSkillList(long roleId, Map<Integer, Integer> skill2LvMap)
/*      */   {
/*  702 */     RoleTempSkillList xTempSkillList = Role2tempskill.get(Long.valueOf(roleId));
/*  703 */     if (xTempSkillList == null)
/*      */     {
/*  705 */       xTempSkillList = Pod.newRoleTempSkillList();
/*  706 */       Role2tempskill.add(Long.valueOf(roleId), xTempSkillList);
/*      */     }
/*  708 */     SSyncTempSkillListAdd sSyncTempSkillListAdd = new SSyncTempSkillListAdd();
/*  709 */     for (Map.Entry<Integer, Integer> skillEntry : skill2LvMap.entrySet())
/*      */     {
/*  711 */       xTempSkillList.getSkilllist().put(skillEntry.getKey(), skillEntry.getValue());
/*  712 */       sSyncTempSkillListAdd.skillmap.put(skillEntry.getKey(), skillEntry.getValue());
/*      */     }
/*  714 */     OnlineManager.getInstance().sendAtOnce(roleId, sSyncTempSkillListAdd);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void removeTempSkillList(long roleId, List<Integer> skillList)
/*      */   {
/*  725 */     RoleTempSkillList xTempSkillList = Role2tempskill.get(Long.valueOf(roleId));
/*  726 */     if (xTempSkillList == null)
/*      */     {
/*  728 */       return;
/*      */     }
/*  730 */     SSyncTempSkillListRemove sSyncTempSkillListRemove = new SSyncTempSkillListRemove();
/*  731 */     for (Integer id : skillList)
/*      */     {
/*  733 */       if (xTempSkillList.getSkilllist().remove(id) != null)
/*      */       {
/*  735 */         sSyncTempSkillListRemove.skillid.add(id);
/*      */       }
/*      */     }
/*  738 */     OnlineManager.getInstance().sendAtOnce(roleId, sSyncTempSkillListRemove);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillEffectType(int skillid, int skillEffectType)
/*      */   {
/*  751 */     return SkillManager.isSkillEffectType(skillid, skillEffectType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getAllRoleSkillConfig(int menpai)
/*      */   {
/*  763 */     List<Integer> skillList = new ArrayList();
/*  764 */     for (SSkillBagMenPaiCfg cfg : SSkillBagMenPaiCfg.getAll().values())
/*      */     {
/*  766 */       if (cfg.menpaiid == menpai)
/*      */       {
/*  768 */         skillList.addAll(cfg.bag);
/*  769 */         break;
/*      */       }
/*      */     }
/*  772 */     return skillList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isMarrySkill(int skillId)
/*      */   {
/*  783 */     for (MarrySkillCfg cfg : MarrySkillCfg.getAll().values())
/*      */     {
/*  785 */       if (skillId == cfg.skillid)
/*      */       {
/*  787 */         return true;
/*      */       }
/*      */     }
/*  790 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getQiLingAddRateWithSkills(Map<Integer, Integer> skills)
/*      */   {
/*  803 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/*  805 */       return 0;
/*      */     }
/*  807 */     int totalRate = 0;
/*  808 */     for (Map.Entry<Integer, Integer> skillEntry : skills.entrySet())
/*      */     {
/*  810 */       List<OutFightEffect> addEffects = SkillManager.getPassiveSkillOutFihgtEffectList(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue(), AddQiLingRateEffect.class.getName());
/*      */       
/*  812 */       for (OutFightEffect addEffect : addEffects)
/*      */       {
/*  814 */         if ((addEffect instanceof AddQiLingRateEffect))
/*      */         {
/*  816 */           totalRate += ((AddQiLingRateEffect)addEffect).getAddQiLingRate();
/*      */         }
/*      */       }
/*      */     }
/*  820 */     return totalRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getBianYiAddRateWithSkills(Map<Integer, Integer> skills)
/*      */   {
/*  833 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/*  835 */       return 0;
/*      */     }
/*  837 */     int totalRate = 0;
/*  838 */     for (Map.Entry<Integer, Integer> skillEntry : skills.entrySet())
/*      */     {
/*  840 */       List<OutFightEffect> addEffects = SkillManager.getPassiveSkillOutFihgtEffectList(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue(), AddFanShengBianYiRateEffect.class.getName());
/*      */       
/*  842 */       for (OutFightEffect addEffect : addEffects)
/*      */       {
/*  844 */         if ((addEffect instanceof AddFanShengBianYiRateEffect))
/*      */         {
/*  846 */           totalRate += ((AddFanShengBianYiRateEffect)addEffect).getAddFanShengBianYiRate();
/*      */         }
/*      */       }
/*      */     }
/*  850 */     return totalRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getHuaShengAddRateWithSkills(Map<Integer, Integer> skills)
/*      */   {
/*  863 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/*  865 */       return 0;
/*      */     }
/*  867 */     int totalRate = 0;
/*  868 */     for (Map.Entry<Integer, Integer> skillEntry : skills.entrySet())
/*      */     {
/*  870 */       List<OutFightEffect> addEffects = SkillManager.getPassiveSkillOutFihgtEffectList(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue(), AddHuaShengRateEffect.class.getName());
/*      */       
/*  872 */       for (OutFightEffect addEffect : addEffects)
/*      */       {
/*  874 */         if ((addEffect instanceof AddFanShengBianYiRateEffect))
/*      */         {
/*  876 */           totalRate += ((AddHuaShengRateEffect)addEffect).getAddHuaShengRate();
/*      */         }
/*      */       }
/*      */     }
/*  880 */     return totalRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Integer, Integer> getEquipAddRateWithSkills(Map<Integer, Integer> skills)
/*      */   {
/*  893 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/*  895 */       return new HashMap();
/*      */     }
/*  897 */     Map<Integer, Integer> totalRate = new HashMap();
/*  898 */     for (Map.Entry<Integer, Integer> skillEntry : skills.entrySet())
/*      */     {
/*  900 */       List<OutFightEffect> addEffects = SkillManager.getPassiveSkillOutFihgtEffectList(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue(), EquipmentPropertiesRate.class.getName());
/*      */       
/*  902 */       for (OutFightEffect addEffect : addEffects)
/*      */       {
/*  904 */         if ((addEffect instanceof EquipmentPropertiesRate))
/*      */         {
/*  906 */           Integer typeValue = Integer.valueOf(((EquipmentPropertiesRate)addEffect).getAddType());
/*  907 */           if (typeValue == null)
/*      */           {
/*  909 */             totalRate.put(Integer.valueOf(((EquipmentPropertiesRate)addEffect).getAddType()), Integer.valueOf(((EquipmentPropertiesRate)addEffect).getAddValue()));
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  914 */             totalRate.put(Integer.valueOf(((EquipmentPropertiesRate)addEffect).getAddType()), Integer.valueOf(((EquipmentPropertiesRate)addEffect).getAddValue() + typeValue.intValue()));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  920 */     return totalRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getEquipLevelChangeWithSkills(Map<Integer, Integer> skills)
/*      */   {
/*  933 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/*  935 */       return 0;
/*      */     }
/*  937 */     int totalRate = 0;
/*  938 */     for (Map.Entry<Integer, Integer> skillEntry : skills.entrySet())
/*      */     {
/*  940 */       List<OutFightEffect> addEffects = SkillManager.getPassiveSkillOutFihgtEffectList(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue(), EquipmentLevelVary.class.getName());
/*      */       
/*  942 */       for (OutFightEffect addEffect : addEffects)
/*      */       {
/*  944 */         if ((addEffect instanceof EquipmentLevelVary))
/*      */         {
/*  946 */           totalRate += ((EquipmentLevelVary)addEffect).getVaryLevel();
/*      */         }
/*      */       }
/*      */     }
/*  950 */     return totalRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getEquipmentDurableSkills(Map<Integer, Integer> skills)
/*      */   {
/*  963 */     if ((skills == null) || (skills.size() == 0))
/*      */     {
/*  965 */       return false;
/*      */     }
/*  967 */     for (Map.Entry<Integer, Integer> skillEntry : skills.entrySet())
/*      */     {
/*  969 */       List<OutFightEffect> addEffects = SkillManager.getPassiveSkillOutFihgtEffectList(((Integer)skillEntry.getKey()).intValue(), ((Integer)skillEntry.getValue()).intValue(), EquipmentDurable.class.getName());
/*      */       
/*  971 */       for (OutFightEffect addEffect : addEffects)
/*      */       {
/*  973 */         if ((addEffect instanceof EquipmentDurable))
/*      */         {
/*  975 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*  979 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean getEquipmentDurableSkills(Set<Integer> skillSet)
/*      */   {
/*  992 */     if ((skillSet == null) || (skillSet.size() == 0))
/*      */     {
/*  994 */       return false;
/*      */     }
/*  996 */     Map<Integer, Integer> skillMap = skillSetExchangeToMap(skillSet);
/*  997 */     return getEquipmentDurableSkills(skillMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Integer, Integer> getEquipAddRateWithSkills(Set<Integer> skillSet)
/*      */   {
/* 1009 */     if ((skillSet == null) || (skillSet.size() == 0))
/*      */     {
/* 1011 */       return new HashMap();
/*      */     }
/* 1013 */     Map<Integer, Integer> skillMap = skillSetExchangeToMap(skillSet);
/* 1014 */     return getEquipAddRateWithSkills(skillMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getEquipLevelChangeWithSkills(Set<Integer> skillSet)
/*      */   {
/* 1026 */     if ((skillSet == null) || (skillSet.size() == 0))
/*      */     {
/* 1028 */       return 0;
/*      */     }
/* 1030 */     Map<Integer, Integer> skillMap = skillSetExchangeToMap(skillSet);
/* 1031 */     return getEquipLevelChangeWithSkills(skillMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Integer, Integer> skillSetExchangeToMap(Set<Integer> skillSet)
/*      */   {
/* 1042 */     Map<Integer, Integer> skillMap = new HashMap();
/* 1043 */     if (skillSet == null)
/*      */     {
/* 1045 */       return skillMap;
/*      */     }
/* 1047 */     for (Integer skillId : skillSet)
/*      */     {
/* 1049 */       skillMap.put(skillId, Integer.valueOf(1));
/*      */     }
/* 1051 */     return skillMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Integer findMatchSkill(int sourceSkillCfgid, Collection<Integer> skills)
/*      */   {
/* 1063 */     return SkillManager.findMatchSkill(sourceSkillCfgid, skills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Integer> findMatchSkills(int sourceSkillCfgid, Collection<Integer> skills)
/*      */   {
/* 1075 */     return SkillManager.findMatchSkills(sourceSkillCfgid, skills);
/*      */   }
/*      */   
/*      */   public static int getRealSkillCfgid(long roleid, int defaultSkillCfgid, boolean retainRoleLock)
/*      */   {
/* 1080 */     return SkillManager.getRealSkillCfgid(roleid, defaultSkillCfgid, retainRoleLock);
/*      */   }
/*      */   
/*      */   public static int getRealSkillCfgid(Set<Integer> skillCfgids, int defaultSkillCfgid)
/*      */   {
/* 1085 */     return SkillManager.getRealSkillCfgid(skillCfgids, defaultSkillCfgid);
/*      */   }
/*      */   
/*      */   public static int getSourceSkillCfgid(int defaultSkillCfgid)
/*      */   {
/* 1090 */     return SkillManager.getSourceSkillCfgid(defaultSkillCfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMenPaiSkillBagLevel(long roleid, int skillBagCfgid, boolean holdLock)
/*      */   {
/* 1103 */     return SkillManager.getMenPaiSkillBagLevel(roleid, skillBagCfgid, holdLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isUltimateSkill(int skillId)
/*      */   {
/* 1115 */     SSkillCfg cfg = SSkillCfg.get(skillId);
/* 1116 */     if (cfg == null)
/*      */     {
/* 1118 */       return false;
/*      */     }
/* 1120 */     return cfg.isUltimateSkill;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isMenpaiSkill(int skillId)
/*      */   {
/* 1132 */     SSkillCfg cfg = SSkillCfg.get(skillId);
/* 1133 */     if (cfg == null)
/*      */     {
/* 1135 */       return false;
/*      */     }
/* 1137 */     return cfg.isMenPaiSkill;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\SkillInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */