/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import xbean.Pod;
/*     */ import xbean.SkillBuffResult;
/*     */ import xbean.SkillBuffResultInfo;
/*     */ import xbean.SkillMirrorFighterInfo;
/*     */ import xbean.SkillReleaseRoundInfo;
/*     */ import xbean.SkillReleaseRoundInfos;
/*     */ import xbean.SkillResult;
/*     */ import xbean.SkillResultAttackTimes;
/*     */ import xbean.SkillResultAttackTimesRoundInfo;
/*     */ 
/*     */ public abstract class SkillResultHandle
/*     */ {
/*     */   protected final int skillTag;
/*     */   
/*     */   public SkillResultHandle(int skillTag)
/*     */   {
/*  25 */     this.skillTag = skillTag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void OnUseSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */   {
/*  36 */     if (!isSameSkill(releaser, op.skill, this.skillTag)) {
/*  37 */       return;
/*     */     }
/*  39 */     if (!isSameSkill(releaser, skill.getID(), this.skillTag)) {
/*  40 */       return;
/*     */     }
/*  42 */     handleSkillResult(releaser, skill, op);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void OnUseSkillEnd(Fighter releaser, Op_UseSkill op)
/*     */   {
/*  52 */     if (!isSameSkill(releaser, op.skill, this.skillTag)) {
/*  53 */       return;
/*     */     }
/*  55 */     handleSkillCmdEnd(releaser, op);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public abstract void handleSkillResult(Fighter paramFighter, Skill paramSkill, Op_UseSkill paramOp_UseSkill);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void handleSkillCmdEnd(Fighter releaser, Op_UseSkill op) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSkillTag(Fighter releaser, int skillCfgId)
/*     */   {
/*  85 */     if (releaser.isRole()) {
/*  86 */       return FighterRole.convertToSourceSkill(skillCfgId).intValue();
/*     */     }
/*  88 */     return skillCfgId;
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
/*     */   public boolean isSameSkill(Fighter releaser, int skillCfgId, int tag)
/*     */   {
/* 102 */     return (tag == 0) || (getSkillTag(releaser, skillCfgId) == tag);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillKillCountInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillKillCountInFight(int skillTag)
/*     */     {
/* 116 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 121 */       int count = skill.getKillCount();
/* 122 */       if (count <= 0) {
/* 123 */         return;
/*     */       }
/*     */       
/* 126 */       releaser.addSkillKillCountInFight(this.skillTag, count);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillKillMaxInRound
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillKillMaxInRound(int skillTag)
/*     */     {
/* 140 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 145 */       int count = skill.getKillCount();
/* 146 */       if (count <= 0) {
/* 147 */         return;
/*     */       }
/*     */       
/* 150 */       releaser.addSkillKillCountMaxInRound(this.skillTag, count);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillCriticalCountInRound
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillCriticalCountInRound(int skillTag)
/*     */     {
/* 165 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 170 */       int count = skill.getCriticalCount();
/* 171 */       if (count <= 0) {
/* 172 */         return;
/*     */       }
/*     */       
/* 175 */       releaser.addSkillCriticalCountMaxInRound(this.skillTag, count);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillBeDodgeCountInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillBeDodgeCountInFight(int skillTag)
/*     */     {
/* 190 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 195 */       int count = skill.getDodgeCount();
/* 196 */       if (count <= 0) {
/* 197 */         return;
/*     */       }
/*     */       
/* 200 */       releaser.addSkillBeDodgeCountInFight(this.skillTag, count);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillTargetHpLessCountInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     final int hpPercent;
/*     */     
/*     */ 
/*     */ 
/*     */     public LogSkillTargetHpLessCountInFight(int skillTag, int percent)
/*     */     {
/* 216 */       super();
/* 217 */       this.hpPercent = percent;
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 222 */       int count = skill.getTargetHpLeftLittlePercentCount(this.hpPercent, false);
/* 223 */       if (count <= 0) {
/* 224 */         return;
/*     */       }
/*     */       
/* 227 */       releaser.addSkillTargetHpLeftCountInFight(this.skillTag, count, this.hpPercent);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillKillRebornCountInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillKillRebornCountInFight(int skillTag)
/*     */     {
/* 242 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 247 */       int count = skill.getRebornCount();
/* 248 */       if (count <= 0) {
/* 249 */         return;
/*     */       }
/*     */       
/* 252 */       releaser.addSkillKillRebornCountInFight(this.skillTag, count);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillKillMonsterRoundInfoInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillKillMonsterRoundInfoInFight(int skillTag)
/*     */     {
/* 266 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 271 */       int round = releaser.getFight().getRound();
/* 272 */       List<Integer> monsters = skill.getKilledMonsters(releaser);
/* 273 */       releaser.addKilledMonster(monsters, round);
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
/*     */   public static class LogSkillReleaseInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillReleaseInFight(int skillTag)
/*     */     {
/* 289 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 294 */       int currentRound = releaser.getFight().getRound();
/* 295 */       SkillReleaseRoundInfos xInfos = (SkillReleaseRoundInfos)releaser.getSkillResult().getSkillreleaseroundsinfight().get(Integer.valueOf(this.skillTag));
/*     */       
/* 297 */       if (xInfos == null) {
/* 298 */         xInfos = Pod.newSkillReleaseRoundInfos();
/* 299 */         releaser.getSkillResult().getSkillreleaseroundsinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 301 */       SkillReleaseRoundInfo xCurrentRoundInfo = null;
/* 302 */       List<SkillReleaseRoundInfo> xInfoList = xInfos.getRoundinfo();
/* 303 */       for (SkillReleaseRoundInfo xInfo : xInfoList) {
/* 304 */         if (xInfo.getRoundnumber() == currentRound) {
/* 305 */           xCurrentRoundInfo = xInfo;
/* 306 */           mzm.gsp.GameServer.logger().info(String.format("[fight]LogSkillReleaseInFight.handleSkillResult@skill release ok but this should not happend", new Object[0]));
/*     */           
/*     */ 
/*     */ 
/* 310 */           break;
/*     */         }
/*     */       }
/* 313 */       if (xCurrentRoundInfo == null) {
/* 314 */         xCurrentRoundInfo = Pod.newSkillReleaseRoundInfo();
/* 315 */         xCurrentRoundInfo.setRoundnumber(currentRound);
/* 316 */         xInfoList.add(xCurrentRoundInfo);
/*     */       }
/* 318 */       mzm.gsp.GameServer.logger().info(String.format("[fight]LogSkillReleaseInFight.handleSkillResult@skill release ok|currentRound=%d|skillTag=%d|skillid=%d", new Object[] { Integer.valueOf(currentRound), Integer.valueOf(this.skillTag), Integer.valueOf(skill.getID()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 323 */       xCurrentRoundInfo.setIsok(true);
/*     */     }
/*     */     
/*     */     public void handleSkillCmdEnd(Fighter releaser, Op_UseSkill op)
/*     */     {
/* 328 */       super.handleSkillCmdEnd(releaser, op);
/*     */       
/* 330 */       int currentRound = releaser.getFight().getRound();
/* 331 */       SkillReleaseRoundInfos xInfos = (SkillReleaseRoundInfos)releaser.getSkillResult().getSkillreleaseroundsinfight().get(Integer.valueOf(this.skillTag));
/*     */       
/* 333 */       if (xInfos == null) {
/* 334 */         xInfos = Pod.newSkillReleaseRoundInfos();
/* 335 */         releaser.getSkillResult().getSkillreleaseroundsinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 337 */       SkillReleaseRoundInfo xCurrentRoundInfo = null;
/* 338 */       List<SkillReleaseRoundInfo> xInfoList = xInfos.getRoundinfo();
/* 339 */       for (SkillReleaseRoundInfo xInfo : xInfoList) {
/* 340 */         if (xInfo.getRoundnumber() == currentRound) {
/* 341 */           xCurrentRoundInfo = xInfo;
/* 342 */           break;
/*     */         }
/*     */       }
/* 345 */       if (xCurrentRoundInfo == null) {
/* 346 */         xCurrentRoundInfo = Pod.newSkillReleaseRoundInfo();
/* 347 */         xCurrentRoundInfo.setRoundnumber(currentRound);
/* 348 */         xCurrentRoundInfo.setIsok(false);
/* 349 */         xInfoList.add(xCurrentRoundInfo);
/* 350 */         releaser.addSkillFailedCountInFight(this.skillTag, 1);
/* 351 */         mzm.gsp.GameServer.logger().info(String.format("[fight]LogSkillReleaseInFight.handleSkillCmdEnd@skill release failed|currentRound=%d|skillTag=%d|skillid=%d", new Object[] { Integer.valueOf(currentRound), Integer.valueOf(this.skillTag), Integer.valueOf(op.skill) }));
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillAttackTimesInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillAttackTimesInFight(int skillTag)
/*     */     {
/* 371 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 376 */       int currentRound = releaser.getFight().getRound();
/* 377 */       SkillResultAttackTimes xInfos = (SkillResultAttackTimes)releaser.getSkillResult().getSkillattacktimesinfight().get(Integer.valueOf(this.skillTag));
/* 378 */       if (xInfos == null) {
/* 379 */         xInfos = Pod.newSkillResultAttackTimes();
/* 380 */         releaser.getSkillResult().getSkillattacktimesinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 382 */       SkillResultAttackTimesRoundInfo xCurrentRoundInfo = null;
/* 383 */       List<SkillResultAttackTimesRoundInfo> xInfoList = xInfos.getRoundinfo();
/* 384 */       for (SkillResultAttackTimesRoundInfo xInfo : xInfoList) {
/* 385 */         if (xInfo.getRoundnumber() == currentRound) {
/* 386 */           xCurrentRoundInfo = xInfo;
/* 387 */           mzm.gsp.GameServer.logger().info(String.format("[fight]LogSkillAttackTimesInFight.handleSkillResult@skill release ok but this should not happend", new Object[0]));
/*     */           
/*     */ 
/*     */ 
/* 391 */           break;
/*     */         }
/*     */       }
/* 394 */       if (xCurrentRoundInfo == null) {
/* 395 */         xCurrentRoundInfo = Pod.newSkillResultAttackTimesRoundInfo();
/* 396 */         xCurrentRoundInfo.setRoundnumber(currentRound);
/* 397 */         xInfoList.add(xCurrentRoundInfo);
/*     */       }
/* 399 */       mzm.gsp.GameServer.logger().info(String.format("[fight]LogSkillAttackTimesInFight.handleSkillResult@skill release ok|currentRound=%d|skillTag=%d|skillid=%d", new Object[] { Integer.valueOf(currentRound), Integer.valueOf(this.skillTag), Integer.valueOf(skill.getID()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 404 */       int times = skill.getSkillAttackTimes();
/* 405 */       xCurrentRoundInfo.setTimes(times);
/*     */     }
/*     */     
/*     */     public void handleSkillCmdEnd(Fighter releaser, Op_UseSkill op)
/*     */     {
/* 410 */       super.handleSkillCmdEnd(releaser, op);
/*     */       
/* 412 */       int currentRound = releaser.getFight().getRound();
/* 413 */       SkillResultAttackTimes xInfos = (SkillResultAttackTimes)releaser.getSkillResult().getSkillattacktimesinfight().get(Integer.valueOf(this.skillTag));
/* 414 */       if (xInfos == null) {
/* 415 */         xInfos = Pod.newSkillResultAttackTimes();
/* 416 */         releaser.getSkillResult().getSkillattacktimesinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 418 */       SkillResultAttackTimesRoundInfo xCurrentRoundInfo = null;
/* 419 */       List<SkillResultAttackTimesRoundInfo> xInfoList = xInfos.getRoundinfo();
/* 420 */       for (SkillResultAttackTimesRoundInfo xInfo : xInfoList) {
/* 421 */         if (xInfo.getRoundnumber() == currentRound) {
/* 422 */           xCurrentRoundInfo = xInfo;
/* 423 */           break;
/*     */         }
/*     */       }
/* 426 */       if (xCurrentRoundInfo == null) {
/* 427 */         xCurrentRoundInfo = Pod.newSkillResultAttackTimesRoundInfo();
/* 428 */         xCurrentRoundInfo.setRoundnumber(currentRound);
/* 429 */         xCurrentRoundInfo.setTimes(-1);
/* 430 */         xInfoList.add(xCurrentRoundInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillContinuousAddBuff
/*     */     extends SkillResultHandle
/*     */   {
/*     */     private final int buff;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public LogSkillContinuousAddBuff(int skillTag, int buff)
/*     */     {
/* 448 */       super();
/* 449 */       this.buff = buff;
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 454 */       int currentRound = releaser.getFight().getRound();
/* 455 */       SkillBuffResult xInfos = (SkillBuffResult)releaser.getSkillResult().getSkillbuffinfight().get(Integer.valueOf(this.skillTag));
/* 456 */       if (xInfos == null) {
/* 457 */         xInfos = Pod.newSkillBuffResult();
/* 458 */         releaser.getSkillResult().getSkillbuffinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 460 */       SkillBuffResultInfo xCurrentRoundInfo = null;
/* 461 */       List<SkillBuffResultInfo> xInfoList = xInfos.getRoundinfo();
/* 462 */       for (SkillBuffResultInfo xInfo : xInfoList) {
/* 463 */         if ((xInfo.getRoundnumber() == currentRound) && (xInfo.getBuff() == this.buff)) {
/* 464 */           xCurrentRoundInfo = xInfo;
/* 465 */           break;
/*     */         }
/*     */       }
/* 468 */       if (xCurrentRoundInfo == null) {
/* 469 */         xCurrentRoundInfo = Pod.newSkillBuffResultInfo();
/* 470 */         xCurrentRoundInfo.setRoundnumber(currentRound);
/* 471 */         xCurrentRoundInfo.setBuff(this.buff);
/* 472 */         xInfoList.add(xCurrentRoundInfo);
/*     */       }
/* 474 */       for (java.util.Map.Entry<Integer, AttackResult> entry : skill.getAttackResultMap().entrySet()) {
/* 475 */         for (AttackResultBean bean : ((AttackResult)entry.getValue()).attackresultbeans) {
/* 476 */           if ((bean.targetstatus.buff_status_set.contains(Integer.valueOf(this.buff))) && (
/* 477 */             (this.buff != 104) || (!bean.targetstatus.status_set.contains(Integer.valueOf(30)))))
/*     */           {
/*     */ 
/*     */ 
/* 481 */             xCurrentRoundInfo.setIsok(true);
/* 482 */             return;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 487 */       xCurrentRoundInfo.setIsok(false);
/*     */     }
/*     */     
/*     */     public void handleSkillCmdEnd(Fighter releaser, Op_UseSkill op)
/*     */     {
/* 492 */       super.handleSkillCmdEnd(releaser, op);
/* 493 */       int currentRound = releaser.getFight().getRound();
/* 494 */       SkillBuffResult xInfos = (SkillBuffResult)releaser.getSkillResult().getSkillbuffinfight().get(Integer.valueOf(this.skillTag));
/* 495 */       if (xInfos == null) {
/* 496 */         xInfos = Pod.newSkillBuffResult();
/* 497 */         releaser.getSkillResult().getSkillbuffinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 499 */       SkillBuffResultInfo xCurrentRoundInfo = null;
/* 500 */       List<SkillBuffResultInfo> xInfoList = xInfos.getRoundinfo();
/* 501 */       for (SkillBuffResultInfo xInfo : xInfoList) {
/* 502 */         if ((xInfo.getRoundnumber() == currentRound) && (xInfo.getBuff() == this.buff)) {
/* 503 */           xCurrentRoundInfo = xInfo;
/* 504 */           break;
/*     */         }
/*     */       }
/* 507 */       if (xCurrentRoundInfo == null) {
/* 508 */         xCurrentRoundInfo = Pod.newSkillBuffResultInfo();
/* 509 */         xCurrentRoundInfo.setRoundnumber(currentRound);
/* 510 */         xCurrentRoundInfo.setBuff(this.buff);
/* 511 */         xCurrentRoundInfo.setIsok(false);
/* 512 */         xInfoList.add(xCurrentRoundInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillMirrorInFight
/*     */     extends SkillResultHandle
/*     */   {
/*     */     public LogSkillMirrorInFight(int skillTag)
/*     */     {
/* 526 */       super();
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 531 */       Fighter mirroredFighter = releaser.getMirrorFighter();
/* 532 */       if (null == mirroredFighter) {
/* 533 */         return;
/*     */       }
/*     */       
/* 536 */       xbean.SkillMirrorInfo xInfos = (xbean.SkillMirrorInfo)releaser.getSkillResult().getSkillmirrorinfoinfight().get(Integer.valueOf(this.skillTag));
/* 537 */       if (xInfos == null) {
/* 538 */         xInfos = Pod.newSkillMirrorInfo();
/* 539 */         releaser.getSkillResult().getSkillmirrorinfoinfight().put(Integer.valueOf(this.skillTag), xInfos);
/*     */       }
/* 541 */       int mirroredFighterId = mirroredFighter.getid();
/* 542 */       Fighter mirroedFighter = releaser.getFighterFromAll(mirroredFighterId);
/* 543 */       boolean alreadyMirrored = false;
/* 544 */       java.util.Set<SkillMirrorFighterInfo> mirrorInfos = xInfos.getTargets();
/* 545 */       for (SkillMirrorFighterInfo xMirrorFighterInfo : mirrorInfos) {
/* 546 */         if (xMirrorFighterInfo.getFighterid() == mirroredFighterId) {
/* 547 */           alreadyMirrored = true;
/*     */         }
/*     */       }
/*     */       
/* 551 */       if (!alreadyMirrored) {
/* 552 */         SkillMirrorFighterInfo xMirrorFighterInfo = Pod.newSkillMirrorFighterInfo();
/* 553 */         xMirrorFighterInfo.setFighterid(mirroredFighterId);
/* 554 */         xMirrorFighterInfo.setOcp(mirroedFighter.getOccupation());
/* 555 */         mirrorInfos.add(xMirrorFighterInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LogSkillLifeLinkDoubleKill
/*     */     extends SkillResultHandle
/*     */   {
/*     */     private final int damageType;
/*     */     
/*     */ 
/*     */ 
/*     */     public LogSkillLifeLinkDoubleKill(int skillTag, int damageType)
/*     */     {
/* 572 */       super();
/* 573 */       this.damageType = damageType;
/*     */     }
/*     */     
/*     */     public void handleSkillResult(Fighter releaser, Skill skill, Op_UseSkill op)
/*     */     {
/* 578 */       for (java.util.Map.Entry<Integer, AttackResult> entry : skill.getAttackResultMap().entrySet())
/*     */       {
/* 580 */         lifelinkReleaserId = ((Integer)entry.getKey()).intValue();
/* 581 */         lifelinkReleaser = releaser.getFighterFromAll(lifelinkReleaserId);
/* 582 */         if ((lifelinkReleaser != null) && 
/*     */         
/*     */ 
/* 585 */           (lifelinkReleaser.isRole()))
/*     */         {
/*     */ 
/* 588 */           roleId = ((FighterRole)lifelinkReleaser).getRoleid();
/* 589 */           for (AttackResultBean bean : ((AttackResult)entry.getValue()).attackresultbeans)
/*     */           {
/* 591 */             if ((bean.targetstatus.curhp <= 0) && (bean.targetstatus.hpchange < 0)) {
/* 592 */               for (mzm.gsp.fight.ShareDamageRet ret : bean.sharedamagetargets) {
/* 593 */                 if ((ret.sharedamagestatus.curhp <= 0) && (ret.sharedamagestatus.hpchange < 0) && (ret.sharedamagestatus.status_set.contains(Integer.valueOf(this.damageType))))
/*     */                 {
/* 595 */                   xbean.SkillShareDamageKillInfo xkillInfo = Pod.newSkillShareDamageKillInfo();
/*     */                   
/* 597 */                   xkillInfo.setSharedamagefighterid(ret.targetid);
/* 598 */                   xkillInfo.setSharedamagetype(this.damageType);
/* 599 */                   xkillInfo.setSkillid(skill.getID());
/* 600 */                   xkillInfo.setFighterid(lifelinkReleaserId);
/* 601 */                   xkillInfo.setRoleid(roleId);
/* 602 */                   lifelinkReleaser.getSkillResult().getSkillandsharedamagekillinfight().add(xkillInfo);
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       int lifelinkReleaserId;
/*     */       Fighter lifelinkReleaser;
/*     */       long roleId;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\SkillResultHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */