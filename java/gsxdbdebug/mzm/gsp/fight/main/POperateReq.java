/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.fight.OpCapture;
/*     */ import mzm.gsp.fight.OpItem;
/*     */ import mzm.gsp.fight.OpProtect;
/*     */ import mzm.gsp.fight.OpSkill;
/*     */ import mzm.gsp.fight.OpSummonChild;
/*     */ import mzm.gsp.fight.OpSummonPet;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class POperateReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int fighterid;
/*     */   private final int opType;
/*     */   private final Octets content;
/*     */   
/*     */   public POperateReq(long roleid, int fighterid, int opType, Octets content)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.fighterid = fighterid;
/*  25 */     this.opType = opType;
/*  26 */     this.content = content;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/*  32 */     if (fight == null) {
/*  33 */       FightManager.logger.info(String.format("[Fight]POperateReq.processImp@玩家已经不再战斗中了|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  34 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  38 */     lock(xtable.Basic.getTable(), fight.getLockRoles());
/*     */     
/*     */ 
/*  41 */     if ((!fight.isInPrepare1Flow()) && (!fight.isInPrepare2Flow())) {
/*  42 */       FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗没有在准备阶段，却收到操作协议|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     FightGroupRole groupRole = fight.getGroupRole(this.roleid);
/*  48 */     if (groupRole == null) {
/*  49 */       FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗中手动操作失败，战斗中找不到战斗组角色|fightid=%d|roleid=%d", new Object[] { Long.valueOf(fight.fightid), Long.valueOf(this.roleid) }));
/*     */       
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     Fighter fighter = groupRole.getFighter(this.fighterid);
/*  55 */     if (fighter == null) {
/*  56 */       FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗中手动操作失败，战斗中找不到战斗对象|fightid=%d|roleid=%d|fighterid=%d", new Object[] { Long.valueOf(fight.fightid), Long.valueOf(this.roleid), Integer.valueOf(this.fighterid) }));
/*     */       
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (!fighter.canPlayerOperate()) {
/*  64 */       FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗中手动操作失败，战斗对象不可操作|fightid=%d|fighterid=%d|fighterType=%d|roleid=%d|name=%s", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(this.fighterid), Integer.valueOf(fighter.getType()), Long.valueOf(this.roleid), fighter.getName() }));
/*     */       
/*     */ 
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (fight.hasFightCmd(this.fighterid)) {
/*  73 */       FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗中手动操作失败，战斗对象已经有操作指令|战斗id=%d|fighterid=%d|roleid=%d|fighterType=%d|name=%s", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(this.fighterid), Long.valueOf(this.roleid), Integer.valueOf(fighter.getType()), fighter.getName() }));
/*     */       
/*     */ 
/*     */ 
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     switch (this.opType) {
/*     */     case 0: 
/*  82 */       OpSkill opSkill = new OpSkill();
/*  83 */       opSkill.unmarshal(new OctetsStream(this.content));
/*     */       
/*     */ 
/*  86 */       Op_UseSkill opUseSkill = new Op_UseSkill();
/*  87 */       opUseSkill.main_target = opSkill.main_target;
/*  88 */       opUseSkill.skill = opSkill.skill;
/*  89 */       if (fighter.hasSkill(opSkill.skill)) {
/*  90 */         opUseSkill.skillLv = fighter.getSkillLevel(opSkill.skill);
/*     */       } else {
/*  92 */         FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗中手动操作失败，战斗对象没有该技能|战斗id=%d|fighterid=%d|skillid=%d|fightertype=%d|name=%s|roleid=%d", new Object[] { Long.valueOf(fight.fightid), Integer.valueOf(this.fighterid), Integer.valueOf(opSkill.skill), Integer.valueOf(fighter.getType()), fighter.getName(), Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  97 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 101 */       fight.addFightCmd(this.fighterid, this.opType, opUseSkill);
/* 102 */       fighter.setLastCanAutoSkill(opSkill.skill);
/* 103 */       if (groupRole.isAuto()) {
/* 104 */         FightInterface.syncAutoState(this.roleid);
/*     */       }
/*     */       break;
/*     */     case 1: 
/* 108 */       OpItem opItem = new OpItem();
/* 109 */       opItem.unmarshal(new OctetsStream(this.content));
/*     */       
/* 111 */       fight.addFightCmd(this.fighterid, this.opType, opItem);
/* 112 */       break;
/*     */     
/*     */     case 2: 
/* 115 */       OpCapture opCapture = new OpCapture();
/* 116 */       opCapture.unmarshal(new OctetsStream(this.content));
/* 117 */       fight.addFightCmd(this.fighterid, this.opType, opCapture);
/* 118 */       break;
/*     */     
/*     */ 
/*     */     case 4: 
/* 122 */       int fightCfgType = fight.getCfgType();
/* 123 */       SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(fightCfgType);
/* 124 */       if (!fightTypeCfg.canEscape) {
/* 125 */         FightManager.logger.info(String.format("[Fight]POperateReq.processImp@战斗中手动操作失败，战斗配置类型不允许逃跑|fightid=%d|roleid=%d|fightcfgtype=%d", new Object[] { Long.valueOf(fight.fightid), Long.valueOf(this.roleid), Integer.valueOf(fightCfgType) }));
/*     */         
/*     */ 
/* 128 */         return false;
/*     */       }
/* 130 */       fight.addFightCmd(this.fighterid, this.opType, null);
/* 131 */       break;
/*     */     
/*     */     case 3: 
/* 134 */       OpProtect opProtect = new OpProtect();
/* 135 */       opProtect.unmarshal(new OctetsStream(this.content));
/* 136 */       fight.addFightCmd(this.fighterid, this.opType, opProtect);
/* 137 */       break;
/*     */     
/*     */     case 5: 
/* 140 */       OpSummonPet opSummonPet = new OpSummonPet();
/* 141 */       opSummonPet.unmarshal(new OctetsStream(this.content));
/* 142 */       fight.addFightCmd(this.fighterid, this.opType, opSummonPet);
/* 143 */       break;
/*     */     case 6: 
/* 145 */       OpSummonChild opSummonChild = new OpSummonChild();
/* 146 */       opSummonChild.unmarshal(new OctetsStream(this.content));
/* 147 */       fight.addFightCmd(this.fighterid, this.opType, opSummonChild);
/* 148 */       break;
/*     */     default: 
/* 150 */       FightManager.logger.error(String.format("[Fight]POperateReq.processImp@未知的战斗操作类型|roleid=%d|opType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.opType) }));
/*     */       
/* 152 */       return false;
/*     */     }
/*     */     
/*     */     
/* 156 */     FightManager.notifyOperate(this.roleid, this.fighterid);
/* 157 */     fighter.broadCastSelectOperInTeam();
/*     */     
/*     */ 
/* 160 */     if ((fight.allHasCmdOrAuto()) && ((fight.isInPrepare1Flow()) || (fight.isInPrepare2Flow()))) {
/* 161 */       fight.cancelRoundPrapare2Session();
/* 162 */       fight.onPlayBefore();
/*     */     }
/*     */     
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POperateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */