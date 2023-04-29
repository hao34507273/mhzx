/*     */ package mzm.gsp.skill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.confbean.RoleEffectCfg;
/*     */ import mzm.gsp.effect.fighter.Interface.DisperseType;
/*     */ import mzm.gsp.effect.fighter.Interface.HealType;
/*     */ import mzm.gsp.effect.fighter.Interface.ReliveType;
/*     */ import mzm.gsp.effect.fighter.Interface.SealType;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.formula.fighter.EffectFormula;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import mzm.gsp.effect.outfight.OutFightEffectInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.skill.confbean.SEnchantSkill;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ import mzm.gsp.skill.confbean.SPassiveSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillBagCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillBagMenPaiCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupSubCfg;
/*     */ import mzm.gsp.skill.confbean.SSourceSkillsCfg;
/*     */ import mzm.gsp.skill.confbean.STargetToSourceSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SkillBagSkill2NeedLevel;
/*     */ import mzm.gsp.skill.formula.outfight.FormulaFunction;
/*     */ import mzm.gsp.skill.formula.outfight.FormulaFunctionFactory;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSkillBags;
/*     */ import xtable.Role2skillbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SkillManager
/*     */ {
/*     */   public static final String MENPAI_SKILL_LOG = "SkillLevelUp";
/*  54 */   static final Map<Integer, Set<Integer>> skillIdToSkillEffectTypes = new HashMap();
/*     */   
/*     */   static void init()
/*     */   {
/*  58 */     for (Iterator i$ = SSkillCfg.getAll().values().iterator(); i$.hasNext();) { skillCfg = (SSkillCfg)i$.next();
/*     */       
/*  60 */       if (!skillIdToSkillEffectTypes.containsKey(Integer.valueOf(skillCfg.id)))
/*     */       {
/*  62 */         skillIdToSkillEffectTypes.put(Integer.valueOf(skillCfg.id), new HashSet());
/*     */       }
/*  64 */       for (i$ = skillCfg.skillEffectGroupId.iterator(); i$.hasNext();) { int skillEffectGroupid = ((Integer)i$.next()).intValue();
/*     */         
/*  66 */         SSkillEffectGroupCfg skillEffectGroupCfg = SSkillEffectGroupCfg.get(skillEffectGroupid);
/*  67 */         for (i$ = skillEffectGroupCfg.effectgroupsub.iterator(); i$.hasNext();) { int effectGroupSubid = ((Integer)i$.next()).intValue();
/*     */           
/*  69 */           SSkillEffectGroupSubCfg skillEffectGroupSubCfg = SSkillEffectGroupSubCfg.get(effectGroupSubid);
/*  70 */           List<Integer> params = new ArrayList();
/*  71 */           for (Iterator i$ = skillEffectGroupSubCfg.effectformula.iterator(); i$.hasNext();) { int effectformula = ((Integer)i$.next()).intValue();
/*     */             
/*  73 */             EffectFormula formula = EffectInterface.getFighterEffectFormula(effectformula);
/*  74 */             if (formula == null)
/*     */             {
/*  76 */               GameServer.logger().error("效果子表中配置的公式不存在,效果子表id:" + skillEffectGroupSubCfg.id);
/*  77 */               break;
/*     */             }
/*  79 */             params.add(Integer.valueOf(formula.getParamConst()));
/*     */           }
/*  81 */           FighterEffect fighterEffect = EffectInterface.getFighterEffectInstance(skillEffectGroupSubCfg.effectid, params);
/*     */           
/*  83 */           if ((fighterEffect instanceof SealType))
/*     */           {
/*  85 */             ((Set)skillIdToSkillEffectTypes.get(Integer.valueOf(skillCfg.id))).add(Integer.valueOf(2));
/*     */           }
/*  87 */           else if ((fighterEffect instanceof ReliveType))
/*     */           {
/*  89 */             ((Set)skillIdToSkillEffectTypes.get(Integer.valueOf(skillCfg.id))).add(Integer.valueOf(1));
/*     */           }
/*  91 */           else if ((fighterEffect instanceof DisperseType))
/*     */           {
/*  93 */             ((Set)skillIdToSkillEffectTypes.get(Integer.valueOf(skillCfg.id))).addAll(((DisperseType)fighterEffect).getDisperseTypes());
/*     */           }
/*  95 */           else if ((fighterEffect instanceof HealType))
/*     */           {
/*  97 */             ((Set)skillIdToSkillEffectTypes.get(Integer.valueOf(skillCfg.id))).add(Integer.valueOf(7));
/*     */           }
/*     */           
/*     */ 
/* 101 */           if ((fighterEffect instanceof Validate))
/*     */           {
/* 103 */             boolean validate = ((Validate)fighterEffect).validate();
/* 104 */             if (!validate)
/*     */             {
/* 106 */               throw new RuntimeException("效果组配置的id校验不通过,效果组子表id:" + effectGroupSubid);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     SSkillCfg skillCfg;
/*     */     
/*     */     Iterator i$;
/*     */     
/*     */     Iterator i$;
/*     */   }
/*     */   
/*     */   static boolean isSkillEffectType(int skillid, int skillEffectType)
/*     */   {
/* 122 */     if (skillIdToSkillEffectTypes.containsKey(Integer.valueOf(skillid)))
/*     */     {
/* 124 */       return ((Set)skillIdToSkillEffectTypes.get(Integer.valueOf(skillid))).contains(Integer.valueOf(skillEffectType));
/*     */     }
/* 126 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Skill getSkill(int skillid, int skillLv)
/*     */   {
/* 137 */     SSkillCfg skillCfg = SSkillCfg.get(skillid);
/* 138 */     if (skillCfg == null)
/*     */     {
/* 140 */       return null;
/*     */     }
/* 142 */     return new Skill(skillCfg, skillLv);
/*     */   }
/*     */   
/*     */   static PassiveSkill getPassiveSkill(int skillId, int skillLv)
/*     */   {
/* 147 */     SPassiveSkillCfg skillCfg = SPassiveSkillCfg.get(skillId);
/* 148 */     if (skillCfg == null)
/*     */     {
/* 150 */       return null;
/*     */     }
/* 152 */     return new PassiveSkill(skillCfg, skillLv);
/*     */   }
/*     */   
/*     */   static EnchantSkill getEnchantSkill(int skillId, int skillLv)
/*     */   {
/* 157 */     SEnchantSkill skillCfg = SEnchantSkill.get(skillId);
/* 158 */     if (skillCfg == null)
/*     */     {
/* 160 */       return null;
/*     */     }
/* 162 */     return new EnchantSkill(skillCfg, skillLv);
/*     */   }
/*     */   
/*     */   static String createTLog(Object... objects)
/*     */   {
/* 167 */     StringBuilder stringBuilder = new StringBuilder();
/* 168 */     for (int i = 0; i < objects.length; i++)
/*     */     {
/* 170 */       Object o = objects[i];
/* 171 */       stringBuilder.append(o);
/* 172 */       if (i != objects.length - 1)
/*     */       {
/* 174 */         stringBuilder.append("|");
/*     */       }
/*     */     }
/* 177 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSkillSwitchOpenForRole(long roleid)
/*     */   {
/* 188 */     if (!OpenInterface.getOpenStatus(103))
/*     */     {
/* 190 */       OpenInterface.sendCloseProtocol(roleid, 103, null);
/*     */       
/* 192 */       return false;
/*     */     }
/* 194 */     if (OpenInterface.isBanPlay(roleid, 103))
/*     */     {
/* 196 */       OpenInterface.sendBanPlayMsg(roleid, 103);
/* 197 */       return false;
/*     */     }
/* 199 */     if (!checkRoleKuaFuStateCanUseFun(roleid))
/*     */     {
/* 201 */       return false;
/*     */     }
/* 203 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkRoleKuaFuStateCanUseFun(long roleid)
/*     */   {
/* 216 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 190, true))
/*     */     {
/* 218 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleid);
/* 219 */       GameServer.logger().error(String.format("[skill]SkillManager.checkRoleKuaFuStateCanUseFun@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleid), statusSet }));
/*     */       
/*     */ 
/*     */ 
/* 223 */       return false;
/*     */     }
/* 225 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<OutFightEffect> getPassiveSkillOutFihgtEffectList(int skillId, int skillLevel, String effectName)
/*     */   {
/* 234 */     List<OutFightEffect> outFightEffectList = new ArrayList();
/* 235 */     PassiveSkill passiveSkill = getPassiveSkill(skillId, skillLevel);
/* 236 */     if (passiveSkill == null)
/*     */     {
/* 238 */       return new ArrayList();
/*     */     }
/* 240 */     for (SOutFightEffectGroup outFightEffectGroup : passiveSkill.getOutFighterEffectList())
/*     */     {
/* 242 */       RoleEffectCfg roleEffectCfg = RoleEffectCfg.get(outFightEffectGroup.effectId);
/* 243 */       if ((roleEffectCfg != null) && (effectName.contains(roleEffectCfg.classname)))
/*     */       {
/*     */ 
/*     */ 
/* 247 */         List<Integer> paramList = new ArrayList();
/* 248 */         for (Integer funcId : outFightEffectGroup.formulaList)
/*     */         {
/* 250 */           FormulaFunction function = FormulaFunctionFactory.getFormula(funcId.intValue());
/* 251 */           if (null != function)
/*     */           {
/* 253 */             paramList.add(Integer.valueOf(function.calcWithParams(skillLevel, 1)));
/*     */           }
/*     */         }
/* 256 */         OutFightEffect effect = OutFightEffectInterface.createOutFightEffect(outFightEffectGroup.effectId, paramList);
/* 257 */         outFightEffectList.add(effect);
/* 258 */         return outFightEffectList;
/*     */       } }
/* 260 */     return outFightEffectList;
/*     */   }
/*     */   
/*     */   static boolean switchOccupation(long roleid, int oldOccupation, int newOccupation)
/*     */   {
/* 265 */     RoleSkillBags xSkillBagInfo = Role2skillbag.get(Long.valueOf(roleid));
/* 266 */     if (xSkillBagInfo == null)
/*     */     {
/* 268 */       GameServer.logger().error(String.format("[skill]SkillManager.switchOccupation@xbean is null|roleid=%d|old_occupation=%d|new_occupation=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 272 */       return false;
/*     */     }
/*     */     
/* 275 */     SSkillBagMenPaiCfg oldSkillBagMenPaiCfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(oldOccupation);
/* 276 */     if (oldSkillBagMenPaiCfg == null)
/*     */     {
/* 278 */       GameServer.logger().error(String.format("[skill]SkillManager.switchOccupation@old skill_bag_menpai_cfg is null|roleid=%d|old_occupation=%d|new_occupation=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     SSkillBagMenPaiCfg newSkillBagMenPaiCfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(newOccupation);
/* 286 */     if (newSkillBagMenPaiCfg == null)
/*     */     {
/* 288 */       GameServer.logger().error(String.format("[skill]SkillManager.switchOccupation@new skill_bag_menpai_cfg is null|roleid=%d|old_occupation=%d|new_occupation=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation) }));
/*     */       
/*     */ 
/*     */ 
/* 292 */       return false;
/*     */     }
/*     */     
/* 295 */     Map<Integer, Integer> xMenPai = xSkillBagInfo.getMenpai();
/* 296 */     ArrayList<Integer> oldSkills = oldSkillBagMenPaiCfg.bag;
/* 297 */     ArrayList<Integer> newSkills = newSkillBagMenPaiCfg.bag;
/* 298 */     int oldSize = oldSkills.size();
/* 299 */     int newSize = newSkills.size();
/*     */     
/* 301 */     if (oldSize != newSize)
/*     */     {
/* 303 */       GameServer.logger().error(String.format("[skill]SkillManager.switchOccupation@skill size not equal|roleid=%d|old_occupation=%d|new_occupation=%d|old_size=%d|new_size=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation), Integer.valueOf(oldSize), Integer.valueOf(newSize) }));
/*     */       
/*     */ 
/*     */ 
/* 307 */       return false;
/*     */     }
/*     */     
/* 310 */     for (int i = 0; i < oldSize; i++)
/*     */     {
/* 312 */       int skillBagCfgid = ((Integer)oldSkills.get(i)).intValue();
/* 313 */       Integer level = (Integer)xMenPai.remove(Integer.valueOf(skillBagCfgid));
/* 314 */       if (level == null)
/*     */       {
/* 316 */         GameServer.logger().error(String.format("[skill]SkillManager.switchOccupation@skill level is null|roleid=%d|old_occupation=%d|new_occupation=%d|size=%d|skill_bag_cfgid=%d|menpai_skill_info=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation), Integer.valueOf(xMenPai.size()), Integer.valueOf(skillBagCfgid), xMenPai.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 320 */         return false;
/*     */       }
/* 322 */       xMenPai.put(newSkills.get(i), level);
/*     */     }
/*     */     
/* 325 */     GameServer.logger().info(String.format("[skill]SkillManager.switchOccupation@switch occupation success|roleid=%d|old_occupation=%d|new_occupation=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(oldOccupation), Integer.valueOf(newOccupation) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 330 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isSkillInBag(int skillBagCfgid, int skillid)
/*     */   {
/* 335 */     SSkillBagCfg skillBagCfg = SSkillBagCfg.get(skillBagCfgid);
/* 336 */     if (skillBagCfg == null)
/*     */     {
/* 338 */       return false;
/*     */     }
/*     */     
/* 341 */     for (SkillBagSkill2NeedLevel skill2NeedLevel : skillBagCfg.skillid2NeedLevel)
/*     */     {
/* 343 */       if (skill2NeedLevel.skillid == skillid)
/*     */       {
/* 345 */         return true;
/*     */       }
/*     */     }
/* 348 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Integer findMatchSkill(int sourceSkillCfgid, Collection<Integer> skills)
/*     */   {
/* 360 */     SSourceSkillsCfg sourceSkillsCfg = SSourceSkillsCfg.get(sourceSkillCfgid);
/* 361 */     if (sourceSkillsCfg == null)
/*     */     {
/* 363 */       return null;
/*     */     }
/*     */     
/* 366 */     for (Integer skillCfgid : sourceSkillsCfg.skills)
/*     */     {
/* 368 */       if (skills.contains(skillCfgid))
/*     */       {
/* 370 */         return skillCfgid;
/*     */       }
/*     */     }
/* 373 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> findMatchSkills(int sourceSkillCfgid, Collection<Integer> skills)
/*     */   {
/* 385 */     SSourceSkillsCfg sourceSkillsCfg = SSourceSkillsCfg.get(sourceSkillCfgid);
/* 386 */     if (sourceSkillsCfg == null)
/*     */     {
/* 388 */       return Collections.emptySet();
/*     */     }
/*     */     
/* 391 */     Set<Integer> result = new HashSet();
/* 392 */     for (Integer skillCfgid : sourceSkillsCfg.skills)
/*     */     {
/* 394 */       if (skills.contains(skillCfgid))
/*     */       {
/* 396 */         result.add(skillCfgid);
/*     */       }
/*     */     }
/* 399 */     return result;
/*     */   }
/*     */   
/*     */   static void replaceSkill(List<Skill> skillList, int sourceSkillCfgid, int replaceSkillCfgid)
/*     */   {
/* 404 */     Iterator<Skill> it = skillList.iterator();
/* 405 */     Skill tmp = null;
/* 406 */     while (it.hasNext())
/*     */     {
/* 408 */       Skill skill = (Skill)it.next();
/* 409 */       if (skill.getID() == sourceSkillCfgid)
/*     */       {
/* 411 */         tmp = skill;
/* 412 */         it.remove();
/* 413 */         break;
/*     */       }
/*     */     }
/*     */     
/* 417 */     if (tmp == null)
/*     */     {
/* 419 */       return;
/*     */     }
/*     */     
/* 422 */     Skill skill = getSkill(replaceSkillCfgid, tmp.getLevel());
/* 423 */     if (skill != null)
/*     */     {
/* 425 */       skillList.add(skill);
/*     */     }
/*     */   }
/*     */   
/*     */   static int getRealSkillCfgid(long roleid, int defaultSkillCfgid, boolean retainRoleLock)
/*     */   {
/* 431 */     int sourceCfgid = 0;
/* 432 */     SSourceSkillsCfg sourceSkillsCfg = null;
/* 433 */     STargetToSourceSkillCfg targetToSourceSkillCfg = STargetToSourceSkillCfg.get(defaultSkillCfgid);
/* 434 */     if (targetToSourceSkillCfg == null)
/*     */     {
/* 436 */       sourceCfgid = defaultSkillCfgid;
/* 437 */       sourceSkillsCfg = SSourceSkillsCfg.get(sourceCfgid);
/* 438 */       if (sourceSkillsCfg == null)
/*     */       {
/* 440 */         return defaultSkillCfgid;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 445 */       sourceCfgid = targetToSourceSkillCfg.sourceSkillCfgid;
/* 446 */       sourceSkillsCfg = SSourceSkillsCfg.get(sourceCfgid);
/*     */     }
/*     */     
/* 449 */     List<Skill> skills = SkillInterface.getRoleSKills(roleid, retainRoleLock);
/* 450 */     for (Skill skill : skills)
/*     */     {
/* 452 */       int skillCfgid = skill.getID();
/* 453 */       if (sourceSkillsCfg.skills.contains(Integer.valueOf(skillCfgid)))
/*     */       {
/* 455 */         return skillCfgid;
/*     */       }
/*     */     }
/* 458 */     return sourceCfgid;
/*     */   }
/*     */   
/*     */   static int getRealSkillCfgid(Set<Integer> skillCfgids, int defaultSkillCfgid)
/*     */   {
/* 463 */     int sourceCfgid = 0;
/* 464 */     SSourceSkillsCfg sourceSkillsCfg = null;
/* 465 */     STargetToSourceSkillCfg targetToSourceSkillCfg = STargetToSourceSkillCfg.get(defaultSkillCfgid);
/* 466 */     if (targetToSourceSkillCfg == null)
/*     */     {
/* 468 */       sourceCfgid = defaultSkillCfgid;
/* 469 */       sourceSkillsCfg = SSourceSkillsCfg.get(sourceCfgid);
/* 470 */       if (sourceSkillsCfg == null)
/*     */       {
/* 472 */         return defaultSkillCfgid;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 477 */       sourceCfgid = targetToSourceSkillCfg.sourceSkillCfgid;
/* 478 */       sourceSkillsCfg = SSourceSkillsCfg.get(sourceCfgid);
/*     */     }
/*     */     
/* 481 */     if (skillCfgids.contains(Integer.valueOf(sourceCfgid)))
/*     */     {
/* 483 */       return sourceCfgid;
/*     */     }
/*     */     
/* 486 */     for (Integer skillCfgid : skillCfgids)
/*     */     {
/* 488 */       if (sourceSkillsCfg.skills.contains(skillCfgid))
/*     */       {
/* 490 */         return skillCfgid.intValue();
/*     */       }
/*     */     }
/* 493 */     return sourceCfgid;
/*     */   }
/*     */   
/*     */   static int getSourceSkillCfgid(int targetSkillCfgid)
/*     */   {
/* 498 */     STargetToSourceSkillCfg targetToSourceSkillCfg = STargetToSourceSkillCfg.get(targetSkillCfgid);
/* 499 */     if (targetToSourceSkillCfg == null)
/*     */     {
/* 501 */       return targetSkillCfgid;
/*     */     }
/* 503 */     return targetToSourceSkillCfg.sourceSkillCfgid;
/*     */   }
/*     */   
/*     */   static int getMenPaiSkillBagLevel(long roleid, int skillBagCfgid, boolean holdLock)
/*     */   {
/* 508 */     RoleSkillBags xRoleSkillBags = null;
/* 509 */     if (holdLock)
/*     */     {
/* 511 */       xRoleSkillBags = Role2skillbag.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 515 */       xRoleSkillBags = Role2skillbag.select(Long.valueOf(roleid));
/*     */     }
/*     */     
/* 518 */     if (xRoleSkillBags == null)
/*     */     {
/* 520 */       return 0;
/*     */     }
/*     */     
/* 523 */     Integer level = (Integer)xRoleSkillBags.getMenpai().get(Integer.valueOf(skillBagCfgid));
/* 524 */     if (level == null)
/*     */     {
/* 526 */       return 0;
/*     */     }
/* 528 */     return level.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\SkillManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */