/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.wing.confbean.SWingCfg;
/*     */ import mzm.gsp.wing.confbean.SWingInfoCfg;
/*     */ import mzm.gsp.wing.confbean.SWingProCfg;
/*     */ import mzm.gsp.wing.confbean.SWingSkillGuaranteeTimesCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.WingContent;
/*     */ import xbean.WingPlan;
/*     */ 
/*     */ public class RoleWingPlan
/*     */ {
/*     */   private final long roleId;
/*     */   private final int planId;
/*     */   private WingPlan xWingPlan;
/*     */   
/*     */   public RoleWingPlan(long roleId, int planId, WingPlan xWingPlan)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.xWingPlan = xWingPlan;
/*  31 */     this.planId = planId;
/*     */   }
/*     */   
/*     */   long getRoleId()
/*     */   {
/*  36 */     return this.roleId;
/*     */   }
/*     */   
/*     */   int getPlanId()
/*     */   {
/*  41 */     return this.planId;
/*     */   }
/*     */   
/*     */   WingPlan getxWingPlan()
/*     */   {
/*  46 */     return this.xWingPlan;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean hasXWingPlan()
/*     */   {
/*  56 */     return this.xWingPlan != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getOwnWings()
/*     */   {
/*  66 */     return this.xWingPlan.getWings().keySet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean hasWing(int wingId)
/*     */   {
/*  77 */     return this.xWingPlan.getWings().containsKey(Integer.valueOf(wingId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   WingContent getWingData(int wingId)
/*     */   {
/*  88 */     return (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   WingContent createXWingData(int wingId)
/*     */   {
/*  99 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 100 */     if (xWingData != null)
/*     */     {
/* 102 */       return xWingData;
/*     */     }
/* 104 */     xWingData = xbean.Pod.newWingContent();
/* 105 */     xWingData.setCfgid(wingId);
/* 106 */     int colorId = getOrgColorId(wingId);
/* 107 */     if (colorId < 0)
/*     */     {
/* 109 */       GameServer.logger().error(String.format("[wing]RoleWingPlan.createXWingData@ colorId error!|wingId=%d", new Object[] { Integer.valueOf(wingId) }));
/* 110 */       return null;
/*     */     }
/* 112 */     xWingData.setColorid(getOrgColorId(wingId));
/* 113 */     this.xWingPlan.getWings().put(Integer.valueOf(wingId), xWingData);
/* 114 */     return xWingData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getOrgColorId(int wingId)
/*     */   {
/* 125 */     SWingInfoCfg cfg = SWingInfoCfg.get(wingId);
/*     */     
/*     */ 
/* 128 */     SWingCfg sWingCfg = SWingCfg.get(cfg.outlook);
/* 129 */     if (sWingCfg == null)
/*     */     {
/* 131 */       return -1;
/*     */     }
/* 133 */     return sWingCfg.dyeid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getSkills(int wingId)
/*     */   {
/* 145 */     WingContent xWingData = getWingData(wingId);
/* 146 */     if (xWingData == null)
/*     */     {
/* 148 */       return new HashSet();
/*     */     }
/* 150 */     return new HashSet(xWingData.getSkills());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getAllSkills()
/*     */   {
/* 160 */     Set<Integer> allSkills = new HashSet();
/* 161 */     for (Iterator i$ = getOwnWings().iterator(); i$.hasNext();) { int wingId = ((Integer)i$.next()).intValue();
/*     */       
/* 163 */       allSkills.addAll(getSkills(wingId));
/*     */     }
/* 165 */     return allSkills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getAllSkillsInfo()
/*     */   {
/* 175 */     int roleLv = RoleInterface.getLevel(getRoleId());
/* 176 */     Map<Integer, Integer> skills = new HashMap();
/* 177 */     for (Iterator i$ = getAllSkills().iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */       
/* 179 */       skills.put(Integer.valueOf(skillId), Integer.valueOf(roleLv));
/*     */     }
/* 181 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean addSkills(int wingId, Set<Integer> skills)
/*     */   {
/* 193 */     if ((skills == null) || (skills.size() == 0))
/*     */     {
/* 195 */       return true;
/*     */     }
/* 197 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 198 */     if (xWingData == null)
/*     */     {
/* 200 */       return false;
/*     */     }
/* 202 */     List<Integer> xSkills = xWingData.getSkills();
/* 203 */     for (Iterator i$ = skills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */       
/* 205 */       if (!xSkills.contains(Integer.valueOf(skillId)))
/*     */       {
/*     */ 
/*     */ 
/* 209 */         xSkills.add(Integer.valueOf(skillId)); }
/*     */     }
/* 211 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean rpResetSkills(int wingId, Set<Integer> skills)
/*     */   {
/* 223 */     if ((skills == null) || (skills.size() == 0))
/*     */     {
/* 225 */       return false;
/*     */     }
/* 227 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 228 */     if (xWingData == null)
/*     */     {
/* 230 */       return false;
/*     */     }
/* 232 */     xWingData.getReskillids().clear();
/* 233 */     xWingData.getReskillids().addAll(skills);
/* 234 */     return true;
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
/*     */   boolean rpSkills(int wingId, Set<Integer> skills)
/*     */   {
/* 249 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 250 */     if (xWingData == null)
/*     */     {
/* 252 */       return false;
/*     */     }
/* 254 */     return rpSkills(skills, xWingData);
/*     */   }
/*     */   
/*     */   boolean rpSkills(Set<Integer> skills, WingContent xWingData)
/*     */   {
/* 259 */     if ((skills == null) || (skills.size() == 0))
/*     */     {
/* 261 */       return false;
/*     */     }
/* 263 */     xWingData.getSkills().clear();
/* 264 */     xWingData.getSkills().addAll(skills);
/* 265 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void clearSkills(int wingId)
/*     */   {
/* 275 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 276 */     if (xWingData == null)
/*     */     {
/* 278 */       return;
/*     */     }
/* 280 */     xWingData.getSkills().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean rpByResetSkills(int wingId)
/*     */   {
/* 291 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 292 */     if (xWingData == null)
/*     */     {
/* 294 */       return false;
/*     */     }
/* 296 */     List<Integer> reSkills = xWingData.getReskillids();
/* 297 */     if ((reSkills == null) || (reSkills.size() == 0))
/*     */     {
/* 299 */       GameServer.logger().error(String.format("[wing]RoleWingPlan.rpByResetSkills@ no resSkills!|roleId=%d|wingId=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(wingId) }));
/*     */       
/* 301 */       return false;
/*     */     }
/*     */     
/* 304 */     Set<Integer> repeatedSkills = containsSkills(reSkills);
/* 305 */     if (repeatedSkills.size() > 0)
/*     */     {
/* 307 */       GameServer.logger().info(String.format("[wing]RoleWingPlan.rpByResetSkills@ repeated skills!|roleId=%d|wingId=%d|repeatedSkills=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(wingId), repeatedSkills.toString() }));
/*     */       
/*     */ 
/* 310 */       WingManager.sendWingNotice(this.roleId, 12, new String[0]);
/* 311 */       return false;
/*     */     }
/*     */     
/* 314 */     xWingData.getSkills().clear();
/* 315 */     xWingData.getSkills().addAll(reSkills);
/* 316 */     reSkills.clear();
/* 317 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> containsSkills(List<Integer> skills)
/*     */   {
/* 328 */     Set<Integer> repeatedSkills = new HashSet();
/* 329 */     Set<Integer> ownSkills = getAllSkills();
/* 330 */     for (Iterator i$ = skills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */       
/* 332 */       if (ownSkills.contains(Integer.valueOf(skillId)))
/*     */       {
/* 334 */         repeatedSkills.add(Integer.valueOf(skillId));
/*     */       }
/*     */     }
/* 337 */     return repeatedSkills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Integer> getResetSkills(int wingId)
/*     */   {
/* 348 */     Set<Integer> skills = new HashSet();
/* 349 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 350 */     if (xWingData == null)
/*     */     {
/* 352 */       return skills;
/*     */     }
/* 354 */     skills.addAll(xWingData.getReskillids());
/* 355 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Collection<Integer> getTargetSkills(int wingId)
/*     */   {
/* 366 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 367 */     if (xWingData == null)
/*     */     {
/* 369 */       return java.util.Collections.EMPTY_LIST;
/*     */     }
/* 371 */     return xWingData.getTarget_skills().values();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean setTargetSkill(int wingId, int index, int skill_id)
/*     */   {
/* 383 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 384 */     if (xWingData == null)
/*     */     {
/* 386 */       return false;
/*     */     }
/* 388 */     if (skill_id < 0) {
/* 389 */       xWingData.getTarget_skills().remove(Integer.valueOf(index));
/*     */     } else {
/* 391 */       xWingData.getTarget_skills().put(Integer.valueOf(index), Integer.valueOf(skill_id));
/*     */     }
/* 393 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkTargetSkills(List<Integer> exclude)
/*     */   {
/* 403 */     if ((exclude == null) || (exclude.size() <= 0)) {
/* 404 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 409 */     for (Map.Entry<Integer, WingContent> entryWing : this.xWingPlan.getWings().entrySet()) {
/* 410 */       WingContent xWingData = (WingContent)entryWing.getValue();
/* 411 */       if (xWingData == null)
/*     */       {
/* 413 */         return false;
/*     */       }
/* 415 */       Iterator<Map.Entry<Integer, Integer>> it = xWingData.getTarget_skills().entrySet().iterator();
/* 416 */       while (it.hasNext()) {
/* 417 */         Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 418 */         if (exclude.contains(entry.getValue())) {
/* 419 */           it.remove();
/*     */         }
/*     */       }
/*     */     }
/* 423 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void clearGuaranteeTimes(int wingId)
/*     */   {
/* 433 */     WingContent xWingData = getWingData(wingId);
/* 434 */     if (xWingData == null)
/*     */     {
/* 436 */       return;
/*     */     }
/* 438 */     xWingData.setGuarantee_times(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkGuarantee(int wingId, Set<Integer> resetIds)
/*     */   {
/* 450 */     Collection<Integer> targetSkills = getTargetSkills(wingId);
/*     */     
/* 452 */     if (targetSkills.size() <= 0)
/*     */     {
/* 454 */       return false;
/*     */     }
/* 456 */     SWingSkillGuaranteeTimesCfg cfg = SWingSkillGuaranteeTimesCfg.get(SWingInfoCfg.get(wingId).id);
/*     */     
/* 458 */     if (cfg == null)
/*     */     {
/* 460 */       return false;
/*     */     }
/* 462 */     resetIds.retainAll(targetSkills);
/*     */     
/* 464 */     if (resetIds.size() > 0)
/*     */     {
/* 466 */       clearGuaranteeTimes(wingId);
/* 467 */       return false;
/*     */     }
/* 469 */     WingContent xWingData = getWingData(wingId);
/*     */     
/* 471 */     if (xWingData.getGuarantee_times() + 1 >= cfg.guarantee_times)
/*     */     {
/* 473 */       clearGuaranteeTimes(wingId);
/* 474 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 478 */     xWingData.setGuarantee_times(xWingData.getGuarantee_times() + 1);
/* 479 */     return false;
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
/*     */   Set<Integer> getProIds(int wingId)
/*     */   {
/* 493 */     WingContent xWingData = getWingData(wingId);
/* 494 */     if (xWingData == null)
/*     */     {
/* 496 */       return new HashSet();
/*     */     }
/* 498 */     return new HashSet(xWingData.getProids());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getPros(int wingId)
/*     */   {
/* 509 */     Map<Integer, Integer> pros = new HashMap();
/* 510 */     Set<Integer> proIds = getProIds(wingId);
/* 511 */     if ((proIds == null) || (proIds.size() == 0))
/*     */     {
/* 513 */       return pros;
/*     */     }
/* 515 */     for (Iterator i$ = proIds.iterator(); i$.hasNext();) { int proId = ((Integer)i$.next()).intValue();
/*     */       
/* 517 */       SWingProCfg cfg = SWingProCfg.get(proId);
/* 518 */       if (cfg == null)
/*     */       {
/* 520 */         GameServer.logger().error(String.format("[wing]RoleWingPlan.getPros@ SWingProCfg not exist!|proId=%d", new Object[] { Integer.valueOf(proId) }));
/* 521 */         return new HashMap();
/*     */       }
/* 523 */       pros.put(Integer.valueOf(cfg.proType), Integer.valueOf(cfg.proValue));
/*     */     }
/* 525 */     return pros;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Integer, Integer> getAllWingsPros()
/*     */   {
/* 535 */     Map<Integer, Integer> pros = new HashMap();
/*     */     
/* 537 */     for (Iterator i$ = getOwnWings().iterator(); i$.hasNext();) { int wingId = ((Integer)i$.next()).intValue();
/*     */       
/* 539 */       Map<Integer, Integer> singlePros = getPros(wingId);
/* 540 */       if ((singlePros != null) && (singlePros.size() != 0))
/*     */       {
/*     */ 
/*     */ 
/* 544 */         Iterator<Map.Entry<Integer, Integer>> it = singlePros.entrySet().iterator();
/* 545 */         while (it.hasNext())
/*     */         {
/* 547 */           Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 548 */           addPro(pros, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */         }
/*     */       }
/*     */     }
/* 552 */     return pros;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean rpResetPros(int wingId, Set<Integer> pros)
/*     */   {
/* 564 */     if ((pros == null) || (pros.size() == 0))
/*     */     {
/* 566 */       return false;
/*     */     }
/* 568 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 569 */     if (xWingData == null)
/*     */     {
/* 571 */       return false;
/*     */     }
/* 573 */     xWingData.getReproids().clear();
/* 574 */     xWingData.getReproids().addAll(pros);
/* 575 */     return true;
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
/*     */   boolean rpPros(int wingId, Set<Integer> pros)
/*     */   {
/* 590 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 591 */     if (xWingData == null)
/*     */     {
/* 593 */       return false;
/*     */     }
/* 595 */     return rpPros(pros, xWingData);
/*     */   }
/*     */   
/*     */   boolean rpPros(Set<Integer> pros, WingContent xWingData)
/*     */   {
/* 600 */     if ((pros == null) || (pros.size() == 0))
/*     */     {
/* 602 */       return false;
/*     */     }
/* 604 */     xWingData.getProids().clear();
/* 605 */     xWingData.getProids().addAll(pros);
/* 606 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean rpByResetPros(int wingId)
/*     */   {
/* 617 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 618 */     if (xWingData == null)
/*     */     {
/* 620 */       return false;
/*     */     }
/* 622 */     List<Integer> resPros = xWingData.getReproids();
/* 623 */     if ((resPros == null) || (resPros.size() == 0))
/*     */     {
/* 625 */       GameServer.logger().error(String.format("[wing]RoleWingPlan.rpByResetPros@ no resPros!|roleId=%d|wingId=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(wingId) }));
/*     */       
/* 627 */       return false;
/*     */     }
/* 629 */     xWingData.getProids().clear();
/* 630 */     xWingData.getProids().addAll(resPros);
/* 631 */     resPros.clear();
/* 632 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, Integer> getWingPro()
/*     */   {
/* 642 */     Map<Integer, Integer> pros = new HashMap();
/*     */     
/* 644 */     Map<Integer, Integer> lvPros = WingCfgManager.getProMapBy(this.xWingPlan.getCurlv());
/* 645 */     if ((lvPros == null) || (lvPros.size() == 0))
/*     */     {
/* 647 */       GameServer.logger().error(String.format("[wing]RoleWingPlan.getWingPro@ get lv pro error!|roleId=%d|lv=%d", new Object[] { Long.valueOf(getRoleId()), Integer.valueOf(this.xWingPlan.getCurlv()) }));
/*     */       
/*     */ 
/* 650 */       return pros;
/*     */     }
/*     */     
/* 653 */     fillPros(pros, lvPros);
/* 654 */     fillPros(pros, getAllWingsPros());
/*     */     
/* 656 */     return pros;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fillPros(Map<Integer, Integer> pros, Map<Integer, Integer> subPros)
/*     */   {
/* 667 */     if (pros.size() == 0)
/*     */     {
/* 669 */       pros.putAll(subPros);
/* 670 */       return;
/*     */     }
/* 672 */     Iterator<Map.Entry<Integer, Integer>> it = subPros.entrySet().iterator();
/* 673 */     while (it.hasNext())
/*     */     {
/* 675 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 676 */       addPro(pros, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addPro(Map<Integer, Integer> pros, int type, int value)
/*     */   {
/* 689 */     Integer base = (Integer)pros.get(Integer.valueOf(type));
/* 690 */     if (base == null)
/*     */     {
/* 692 */       pros.put(Integer.valueOf(type), Integer.valueOf(value));
/* 693 */       return;
/*     */     }
/* 695 */     pros.put(Integer.valueOf(type), Integer.valueOf(base.intValue() + value));
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
/*     */   boolean rpColor(int wingId, int colorId)
/*     */   {
/* 710 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 711 */     if (xWingData == null)
/*     */     {
/* 713 */       return false;
/*     */     }
/* 715 */     xWingData.setColorid(colorId);
/* 716 */     return true;
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
/*     */   void rpOutLookWing(int wingId)
/*     */   {
/* 731 */     this.xWingPlan.setCurwing(wingId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getOutLookWing()
/*     */   {
/* 741 */     return this.xWingPlan.getCurwing();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getWingColorId(int wingId)
/*     */   {
/* 752 */     WingContent xWingData = (WingContent)this.xWingPlan.getWings().get(Integer.valueOf(wingId));
/* 753 */     if (xWingData == null)
/*     */     {
/* 755 */       return -1;
/*     */     }
/* 757 */     return xWingData.getColorid();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\RoleWingPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */