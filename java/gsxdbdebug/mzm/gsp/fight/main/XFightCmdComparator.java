/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SFightOperateCfg;
/*     */ import mzm.gsp.fight.fighter.selector.ExistedFighterSelector;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCmd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class XFightCmdComparator
/*     */   implements Comparator<FightCmd>
/*     */ {
/*  22 */   private Map<Integer, OperateorSort> fighter2Oper = new HashMap();
/*     */   
/*     */   private int round;
/*     */   private static final int DEFAULT_ERROR_VALUE = -1;
/*     */   
/*     */   XFightCmdComparator(Fight fight)
/*     */   {
/*  29 */     this.round = fight.getRound();
/*  30 */     for (Fighter fighter : fight.getSelectedFighters(new ExistedFighterSelector())) {
/*  31 */       FightCmd xCmd = fight.getFightCmd(fighter.fighterid);
/*  32 */       if (xCmd == null) {
/*  33 */         GameServer.logger().info(String.format("[Fight].XFightCmdComparator.XFightCmdComparator@cmd is null|fightUuid=%d|fighterid=%d", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(fighter.fighterid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  38 */         this.fighter2Oper.put(Integer.valueOf(fighter.fighterid), new OperateorSort(-1, -1));
/*     */       }
/*     */       else {
/*  41 */         int opType = xCmd.getOp_type();
/*  42 */         SFightOperateCfg fightOperateCfg = FightConfigManager.getInstance().getFightOperateCfgByOperateType(opType);
/*  43 */         if (fightOperateCfg == null) {
/*  44 */           GameServer.logger().error(String.format("[Fight].XFightCmdComparator.XFightCmdComparator@fightOperateCfg is null|fightUuid=%d|fighterid=%d", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(fighter.fighterid) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  49 */           this.fighter2Oper.put(Integer.valueOf(fighter.fighterid), new OperateorSort(-1, -1));
/*     */         }
/*     */         else {
/*  52 */           int compareSpeed = -1;
/*  53 */           int compareOperType = -1;
/*  54 */           switch (opType) {
/*     */           case 2: 
/*  56 */             Integer captrueSpeed = Integer.valueOf(fighter.getExtra(FighterExtra.CAPTURE_SPEED));
/*  57 */             if (captrueSpeed == null) {
/*  58 */               GameServer.logger().error(String.format("[Fight].XFightCmdComparator.XFightCmdComparator@captrueSpeed is null|fightUuid=%d|fighterid=%d", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(fighter.fighterid) }));
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/*  64 */               compareSpeed = captrueSpeed.intValue();
/*     */             }
/*  66 */             compareOperType = opType;
/*  67 */             break;
/*     */           case 0: 
/*  69 */             Op_UseSkill opUseSkill = new Op_UseSkill();
/*  70 */             xCmd.getContent(opUseSkill);
/*  71 */             if (opUseSkill.skill == SFightConsts.getInstance().DEFENCE_SKILL) {
/*  72 */               compareSpeed = fighter.getSpeed();
/*  73 */               compareOperType = 8;
/*  74 */             } else if (fighter.isHouFa()) {
/*  75 */               compareSpeed = fighter.getSpeed();
/*  76 */               compareOperType = 9;
/*     */             } else {
/*  78 */               int skillid = opUseSkill.skill;
/*  79 */               SSkillCfg skillCfg = SSkillCfg.get(skillid);
/*  80 */               if (skillCfg != null) {
/*  81 */                 compareSpeed = (int)(fighter.getSpeed() * (1.0D + skillCfg.speedModify * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */               }
/*     */               else {
/*  84 */                 GameServer.logger().error(String.format("[Fight].XFightCmdComparator.XFightCmdComparator@skillCfg is null|fightUuid=%d|fighterid=%d|skillid=%d", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(fighter.fighterid), Integer.valueOf(opUseSkill.skill) }));
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/*  90 */               compareOperType = 0;
/*     */             }
/*  92 */             break;
/*     */           
/*     */           default: 
/*  95 */             compareSpeed = fighter.getSpeed();
/*  96 */             compareOperType = opType;
/*     */           }
/*     */           
/*  99 */           this.fighter2Oper.put(Integer.valueOf(fighter.fighterid), new OperateorSort(compareOperType, compareSpeed));
/* 100 */           if (GameServer.logger().isDebugEnabled()) {
/*     */             try {
/* 102 */               GameServer.logger().debug(String.format("[FightSpeedLogDump]XFightCmdComparator@fighter compare|fighterid=%d|fightUuid=%d|compareType=%d|compareSpeed=%d", new Object[] { Integer.valueOf(fighter.fighterid), Long.valueOf(fight.fightid), Integer.valueOf(compareOperType), Integer.valueOf(compareSpeed) }));
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 107 */               if (fighter.isRole()) {
/* 108 */                 GameServer.logger().debug(String.format("[FightSpeedLogDump]XFightCmdComparator|name=%s|value=%d|round=%d|fighterid=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(compareSpeed), Integer.valueOf(this.round), Integer.valueOf(fighter.fighterid), Long.valueOf(fight.fightid) }));
/*     */               }
/*     */             }
/*     */             catch (Exception e) {}
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int compare(FightCmd xCmd1, FightCmd xCmd2)
/*     */   {
/* 124 */     int fighter1 = xCmd1.getFighterid();
/* 125 */     int fighter2 = xCmd2.getFighterid();
/* 126 */     OperateorSort operateorSort1 = (OperateorSort)this.fighter2Oper.get(Integer.valueOf(fighter1));
/* 127 */     OperateorSort operateorSort2 = (OperateorSort)this.fighter2Oper.get(Integer.valueOf(fighter2));
/* 128 */     if (operateorSort1 == null) {
/* 129 */       return 1;
/*     */     }
/* 131 */     if (operateorSort2 == null) {
/* 132 */       return -1;
/*     */     }
/*     */     
/* 135 */     SFightOperateCfg fightOperateCfg1 = FightConfigManager.getInstance().getFightOperateCfgByOperateType(operateorSort1.sortOperator);
/*     */     
/* 137 */     SFightOperateCfg fightOperateCfg2 = FightConfigManager.getInstance().getFightOperateCfgByOperateType(operateorSort2.sortOperator);
/*     */     
/* 139 */     if (fightOperateCfg1 == null) {
/* 140 */       return 1;
/*     */     }
/* 142 */     if (fightOperateCfg2 == null) {
/* 143 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 147 */     if (fightOperateCfg1.priority != fightOperateCfg2.priority) {
/* 148 */       return fightOperateCfg2.priority - fightOperateCfg1.priority;
/*     */     }
/* 150 */     if (operateorSort2.sortSpeed == operateorSort1.sortSpeed) {
/* 151 */       return xCmd2.getFighterid() - xCmd1.getFighterid();
/*     */     }
/*     */     
/* 154 */     return operateorSort2.sortSpeed - operateorSort1.sortSpeed;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\XFightCmdComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */