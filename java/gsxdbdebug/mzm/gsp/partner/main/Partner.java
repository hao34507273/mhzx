/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.confbean.PartnerConstants;
/*     */ import mzm.gsp.partner.confbean.SPartnerLoveDataCfg;
/*     */ import mzm.gsp.partner.confbean.SPartnerSkillCfg;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import xbean.Property;
/*     */ 
/*     */ public class Partner
/*     */ {
/*     */   protected final long roleId;
/*     */   protected final Property xProperty;
/*     */   private PartnerCfg partnerCfg;
/*     */   static final int SUB_LEVEL_UP__SUC = 0;
/*     */   static final int SUB_LEVEL_UP__PARAM_ERR = -1;
/*     */   static final int SUB_LEVEL_UP__LEVEL_UP_FORBID = -2;
/*     */   
/*     */   Partner(long roleId, Property xProperty)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.xProperty = xProperty;
/*  30 */     this.partnerCfg = PartnerInitManager.getInstance().getPartnerCfg(xProperty.getPartnercfgid());
/*     */   }
/*     */   
/*     */   public int getId()
/*     */   {
/*  35 */     return this.xProperty.getPartnercfgid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getOccupation()
/*     */   {
/*  45 */     return mzm.gsp.partner.confbean.SPartnerCfg.get(getId()).faction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getPartnerLevel()
/*     */   {
/*  55 */     return mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/*     */   }
/*     */   
/*     */   public void getModel(mzm.gsp.pubdata.ModelInfo modelInfo)
/*     */   {
/*  60 */     modelInfo.modelid = this.partnerCfg.getModelId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void modSkill(int skillId, int lv)
/*     */   {
/*  71 */     this.xProperty.getOwnskills().put(Integer.valueOf(skillId), Integer.valueOf(lv));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getLoveList()
/*     */   {
/*  81 */     List<Integer> loveList = new ArrayList();
/*  82 */     for (Iterator i$ = this.xProperty.getLoves().iterator(); i$.hasNext();) { int loveId = ((Integer)i$.next()).intValue();
/*     */       
/*  84 */       SPartnerLoveDataCfg cfg = SPartnerLoveDataCfg.get(loveId);
/*  85 */       if ((cfg != null) && 
/*     */       
/*     */ 
/*     */ 
/*  89 */         (cfg.loveEffectId > 0))
/*     */       {
/*     */ 
/*     */ 
/*  93 */         loveList.add(Integer.valueOf(loveId)); }
/*     */     }
/*  95 */     return loveList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getHP()
/*     */   {
/* 105 */     return this.xProperty.getHp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMP()
/*     */   {
/* 115 */     return this.xProperty.getMp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHP(int hp)
/*     */   {
/* 125 */     this.xProperty.setHp(hp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMP(int mp)
/*     */   {
/* 135 */     this.xProperty.setMp(mp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getModelId()
/*     */   {
/* 145 */     return this.partnerCfg.getModelId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setFightScore()
/*     */   {
/* 155 */     this.xProperty.setFightvalue(getFightScore());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   PartnerCfg getPartnerCfg()
/*     */   {
/* 166 */     return this.partnerCfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getYuanLevel()
/*     */   {
/* 176 */     return this.xProperty.getYuanlv();
/*     */   }
/*     */   
/*     */   void setYuanLv(int lv)
/*     */   {
/* 181 */     this.xProperty.setYuanlv(lv);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getSubYuanLevel()
/*     */   {
/* 191 */     return this.xProperty.getSubyuanlv();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getSPartnerkills()
/*     */   {
/* 201 */     return this.xProperty.getOwnskills();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getSPartnerRealkills()
/*     */   {
/* 211 */     Map<Integer, Integer> skills = new HashMap();
/* 212 */     Map<Integer, Integer> sPSkills = getSPartnerkills();
/* 213 */     if ((sPSkills == null) || (sPSkills.size() == 0))
/*     */     {
/* 215 */       return skills;
/*     */     }
/* 217 */     Iterator<Map.Entry<Integer, Integer>> it = sPSkills.entrySet().iterator();
/* 218 */     while (it.hasNext())
/*     */     {
/* 220 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 221 */       int realSkillId = PartnerInitManager.getInstance().getRealSkillId(((Integer)entry.getKey()).intValue());
/* 222 */       if (realSkillId > 0)
/*     */       {
/*     */ 
/*     */ 
/* 226 */         skills.put(Integer.valueOf(realSkillId), entry.getValue()); }
/*     */     }
/* 228 */     return skills;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int setSubYuanLevel(int index, int toLevel)
/*     */   {
/* 246 */     if ((index < 1) || (index > getPartnerCfg().getSubYuanSize()))
/*     */     {
/* 248 */       return -1;
/*     */     }
/*     */     
/* 251 */     index--;int modIndex = index;
/*     */     
/* 253 */     List<Integer> subLv = getSubYuanLevel();
/* 254 */     initSubLv();
/*     */     
/* 256 */     if (!checkSubLv(toLevel, modIndex, subLv))
/*     */     {
/* 258 */       return -2;
/*     */     }
/* 260 */     subLv.set(modIndex, Integer.valueOf(toLevel));
/* 261 */     setYuanLevel(toLevel, modIndex);
/*     */     
/* 263 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setYuanLevel(int level, int modIndex)
/*     */   {
/* 274 */     if (modIndex != getPartnerCfg().getSubYuanSize() - 1)
/*     */     {
/* 276 */       return;
/*     */     }
/* 278 */     this.xProperty.setYuanlv(level);
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
/*     */   private boolean checkSubLv(int level, int modIndex, List<Integer> subLv)
/*     */   {
/* 291 */     for (int i = 0; i < getPartnerCfg().getSubYuanSize(); i++)
/*     */     {
/* 293 */       int levelTmp = ((Integer)subLv.get(i)).intValue();
/* 294 */       if (i < modIndex)
/*     */       {
/* 296 */         if (levelTmp != level)
/*     */         {
/* 298 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 303 */       else if (levelTmp != level - 1)
/*     */       {
/* 305 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void initSubLv()
/*     */   {
/* 319 */     List<Integer> subLv = getSubYuanLevel();
/* 320 */     if (subLv.size() != 0)
/*     */     {
/* 322 */       return;
/*     */     }
/* 324 */     for (int i = 0; i < getPartnerCfg().getSubYuanSize(); i++)
/*     */     {
/* 326 */       subLv.add(Integer.valueOf(1));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void clearYuanLv()
/*     */   {
/* 335 */     this.xProperty.setYuanlv(1);
/* 336 */     List<Integer> subLvs = this.xProperty.getSubyuanlv();
/* 337 */     for (int i = 0; i < getPartnerCfg().getSubYuanSize(); i++)
/*     */     {
/* 339 */       subLvs.set(i, Integer.valueOf(1));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean onYuanLevelChange(boolean needSend)
/*     */   {
/* 350 */     return handSkills(needSend);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handSkills(boolean needSend)
/*     */   {
/* 362 */     int lastYuanLv = getYuanLevel();
/* 363 */     boolean needSynSkill = false;
/* 364 */     for (Iterator i$ = getPartnerCfg().getCfgSkills().iterator(); i$.hasNext();) { int sPSkillId = ((Integer)i$.next()).intValue();
/*     */       
/* 366 */       SPartnerSkillCfg cfg = SPartnerSkillCfg.get(sPSkillId);
/* 367 */       if (cfg == null)
/*     */       {
/* 369 */         GameServer.logger().warn(String.format("[partner]Partner.handSkills@ skill not exist!|partnerId=%d|skillId=%d", new Object[] { Integer.valueOf(getId()), Integer.valueOf(sPSkillId) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 375 */       else if (lastYuanLv >= cfg.unLockYuanLevel)
/*     */       {
/*     */ 
/*     */ 
/* 379 */         Map<Integer, Integer> sPartnerSkills = getSPartnerkills();
/* 380 */         Integer skillLevel = (Integer)sPartnerSkills.get(Integer.valueOf(sPSkillId));
/* 381 */         if (skillLevel == null)
/*     */         {
/*     */ 
/* 384 */           skillLevel = Integer.valueOf(0);
/* 385 */           sPartnerSkills.put(Integer.valueOf(sPSkillId), Integer.valueOf(0));
/* 386 */           needSynSkill = true;
/*     */         }
/* 388 */         int level = getSkillLevel(lastYuanLv, cfg.unLockYuanLevel, cfg.improveYuanLevel);
/* 389 */         if (level < 0)
/*     */         {
/* 391 */           GameServer.logger().error(String.format("[partner]Partner.handSkills@ set new lv err!|roleId=%d|partnerId=%d|lastYuanLv=%d|unLockLv=%d|needYuanLv=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(getId()), Integer.valueOf(lastYuanLv), Integer.valueOf(cfg.unLockYuanLevel), Integer.valueOf(cfg.improveYuanLevel) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 397 */           if (level <= cfg.upLimit)
/*     */           {
/* 399 */             sPartnerSkills.put(Integer.valueOf(sPSkillId), Integer.valueOf(level));
/*     */           }
/* 401 */           if (level != skillLevel.intValue())
/*     */           {
/* 403 */             needSynSkill = true; }
/*     */         }
/*     */       } }
/* 406 */     if (needSynSkill)
/*     */     {
/* 408 */       if (needSend)
/*     */       {
/* 410 */         PartnerManager.synPartnerLvs(this.roleId, this);
/*     */       }
/*     */     }
/*     */     
/* 414 */     return needSynSkill;
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
/*     */   int getSkillLevel(int yuanLv, int unLockLv, int needYunLv)
/*     */   {
/* 427 */     if (yuanLv < unLockLv)
/*     */     {
/* 429 */       return -1;
/*     */     }
/* 431 */     return (yuanLv - unLockLv) / needYunLv + 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getSubYuanCfgSkills()
/*     */   {
/* 441 */     return getPartnerCfg().getYuanPasSkills();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<PassiveSkill> getSubYuanPasSkills()
/*     */   {
/* 451 */     List<PassiveSkill> passiveSkills = new ArrayList();
/* 452 */     Map<Integer, Integer> xSubYuanSkills = getSubYuanSkillInfo();
/* 453 */     if ((xSubYuanSkills == null) || (xSubYuanSkills.size() == 0))
/*     */     {
/* 455 */       return passiveSkills;
/*     */     }
/* 457 */     Iterator<Map.Entry<Integer, Integer>> it = xSubYuanSkills.entrySet().iterator();
/* 458 */     while (it.hasNext())
/*     */     {
/* 460 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 461 */       PassiveSkill passiveSkill = mzm.gsp.skill.main.SkillInterface.getPassiveSkillById2Lv(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/* 462 */       if (passiveSkill != null)
/*     */       {
/*     */ 
/*     */ 
/* 466 */         passiveSkills.add(passiveSkill); }
/*     */     }
/* 468 */     return passiveSkills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getSubYuanSkillInfo()
/*     */   {
/* 478 */     Map<Integer, Integer> skill2lv = new HashMap();
/* 479 */     List<Integer> subYuanlvs = getSubYuanLevel();
/* 480 */     List<Integer> cfgSkills = getSubYuanCfgSkills();
/* 481 */     if (!isSkillNumOk(subYuanlvs, cfgSkills))
/*     */     {
/* 483 */       return skill2lv;
/*     */     }
/* 485 */     for (int i = 0; i < getPartnerCfg().getSubYuanSize(); i++)
/*     */     {
/* 487 */       int skillId = ((Integer)cfgSkills.get(i)).intValue();
/* 488 */       int lv = ((Integer)subYuanlvs.get(i)).intValue();
/* 489 */       skill2lv.put(Integer.valueOf(skillId), Integer.valueOf(lv));
/*     */     }
/* 491 */     return skill2lv;
/*     */   }
/*     */   
/*     */   boolean isSkillNumOk(List<Integer> subYuanlvs, List<Integer> cfgSkills)
/*     */   {
/* 496 */     if ((subYuanlvs == null) || (subYuanlvs.size() != getPartnerCfg().getSubYuanSize()))
/*     */     {
/* 498 */       return false;
/*     */     }
/* 500 */     if ((cfgSkills == null) || (cfgSkills.size() != getPartnerCfg().getSubYuanSize()))
/*     */     {
/* 502 */       return false;
/*     */     }
/* 504 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFightScore()
/*     */   {
/* 514 */     int yuanLv = getYuanLevel();
/* 515 */     int level = getPartnerLevel();
/*     */     
/* 517 */     double partnerLvRet = PartnerConstants.getInstance().PARTNER_LV_RET;
/* 518 */     double yuanLvRet = PartnerConstants.getInstance().YUAN_LV_RET;
/* 519 */     double rankValue = getPartnerCfg().getRankValue(yuanLv);
/*     */     
/* 521 */     int score = (int)(level * partnerLvRet + level * yuanLv * yuanLvRet * rankValue);
/*     */     
/* 523 */     return score;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFightScoreFromDb()
/*     */   {
/* 533 */     return this.xProperty.getFightvalue();
/*     */   }
/*     */   
/*     */   int getClassType()
/*     */   {
/* 538 */     return getPartnerCfg().getClassType();
/*     */   }
/*     */   
/*     */   int getClassLevel()
/*     */   {
/* 543 */     return getPartnerCfg().getClassLevel();
/*     */   }
/*     */   
/*     */   String getName()
/*     */   {
/* 548 */     return getPartnerCfg().getName();
/*     */   }
/*     */   
/*     */   int getSex()
/*     */   {
/* 553 */     return getPartnerCfg().getSex();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\Partner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */