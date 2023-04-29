/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.SEnterFightBrd;
/*     */ import mzm.gsp.fight.SEnterFightOperFighters;
/*     */ import mzm.gsp.fight.SFighterOnlineBrd;
/*     */ import mzm.gsp.fight.SSynRoleChildSkillInfo;
/*     */ import mzm.gsp.fight.SSynRolePetSkillInfo;
/*     */ import mzm.gsp.fight.SSynRoleSkillInfo;
/*     */ import mzm.gsp.fight.SynCommandInfos;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.FightCommand;
/*     */ import xbean.FightCommandInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2fight;
/*     */ import xtable.Role2fightcmd;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     FightInterface.syncAutoState(((Long)this.arg).longValue());
/*     */     
/*  32 */     FightCommand xFightCommand = Role2fightcmd.select((Long)this.arg);
/*  33 */     if (xFightCommand != null) {
/*  34 */       SynCommandInfos synCommandInfos = new SynCommandInfos();
/*  35 */       for (FightCommandInfo commandInfo : xFightCommand.getCommandenermylist()) {
/*  36 */         synCommandInfos.commandenermyinfos.add(commandInfo.getContent());
/*     */       }
/*  38 */       for (FightCommandInfo commandInfo : xFightCommand.getCommandfriendlist()) {
/*  39 */         synCommandInfos.commandfriendinfos.add(commandInfo.getContent());
/*     */       }
/*  41 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), synCommandInfos);
/*     */     }
/*     */     
/*     */ 
/*  45 */     Fight fight = FightManager.getFightByRoleid(((Long)this.arg).longValue());
/*  46 */     if (fight != null) {
/*  47 */       Set<Long> lockRoleSet = fight.getLockRoles();
/*  48 */       lockRoleSet.addAll(fight.getDisObservers());
/*     */       
/*  50 */       lock(Basic.getTable(), lockRoleSet);
/*     */       
/*     */ 
/*  53 */       Set<Fighter> fighters = new HashSet();
/*  54 */       fighters.addAll(fight.getActiveTeam().getFighters());
/*  55 */       fighters.addAll(fight.getPassiveTeam().getFighters());
/*     */       
/*  57 */       SEnterFightOperFighters enterFightOperFighters = new SEnterFightOperFighters();
/*  58 */       enterFightOperFighters.fight_uuid = fight.fightid;
/*  59 */       enterFightOperFighters.round = fight.getRound();
/*     */       
/*  61 */       for (Fighter fighter : fighters)
/*     */       {
/*  63 */         if ((fighter.isRole()) && ((fighter instanceof FighterRole))) {
/*  64 */           FighterRole fighterRole = (FighterRole)fighter;
/*  65 */           if (fighterRole.getRoleid() == ((Long)this.arg).longValue()) {
/*  66 */             SSynRoleSkillInfo synRoleSkillInfo = new SSynRoleSkillInfo();
/*  67 */             synRoleSkillInfo.fight_uuid = fight.fightid;
/*  68 */             synRoleSkillInfo.skillmap.putAll(fighterRole.getActiveSkillMap());
/*  69 */             OnlineManager.getInstance().send(((Long)this.arg).longValue(), synRoleSkillInfo);
/*     */             
/*     */ 
/*  72 */             if (fight.hasFightCmd(fighterRole.fighterid)) {
/*  73 */               enterFightOperFighters.operuuids.add(Integer.valueOf(fighterRole.fighterid));
/*     */             }
/*     */           }
/*     */         }
/*  77 */         else if ((fighter.isPet()) && ((fighter instanceof FighterPet))) {
/*  78 */           FighterPet fighterPet = (FighterPet)fighter;
/*  79 */           if (fighterPet.getOwnerid() == ((Long)this.arg).longValue()) {
/*  80 */             PetInterface.setPetInFightFlag(((Long)this.arg).longValue(), fighterPet.getUuid());
/*     */             
/*  82 */             SSynRolePetSkillInfo synRolePetSkillInfo = new SSynRolePetSkillInfo();
/*  83 */             synRolePetSkillInfo.fight_uuid = fight.fightid;
/*  84 */             synRolePetSkillInfo.petuuid = fighterPet.getUuid();
/*  85 */             synRolePetSkillInfo.skillmap.putAll(fighterPet.getActiveSkillMap());
/*  86 */             OnlineManager.getInstance().send(((Long)this.arg).longValue(), synRolePetSkillInfo);
/*     */             
/*     */ 
/*  89 */             if (fight.hasFightCmd(fighterPet.fighterid)) {
/*  90 */               enterFightOperFighters.operuuids.add(Integer.valueOf(fighterPet.fighterid));
/*     */             }
/*     */           }
/*  93 */         } else if ((fighter.isChild()) && ((fighter instanceof FighterChild))) {
/*  94 */           FighterChild fighterChild = (FighterChild)fighter;
/*  95 */           long childid = fighterChild.getUuid();
/*  96 */           if (fighterChild.getOwnerid() == ((Long)this.arg).longValue()) {
/*  97 */             ChildrenTaskOneByOneManager.asyncChildInFight(((Long)this.arg).longValue(), childid);
/*     */             
/*  99 */             SSynRoleChildSkillInfo synRoleChildSkillInfo = new SSynRoleChildSkillInfo();
/* 100 */             synRoleChildSkillInfo.childrenuuid = childid;
/* 101 */             synRoleChildSkillInfo.fight_uuid = fight.fightid;
/* 102 */             synRoleChildSkillInfo.skillmap.putAll(fighterChild.getActiveSkillMap());
/* 103 */             OnlineManager.getInstance().send(((Long)this.arg).longValue(), synRoleChildSkillInfo);
/*     */             
/* 105 */             if (fight.hasFightCmd(fighterChild.fighterid)) {
/* 106 */               enterFightOperFighters.operuuids.add(Integer.valueOf(fighterChild.fighterid));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 112 */       if (enterFightOperFighters.operuuids.size() > 0)
/*     */       {
/* 114 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), enterFightOperFighters);
/*     */       }
/*     */       
/* 117 */       SEnterFightBrd sEnterFightBrd = new SEnterFightBrd();
/* 118 */       fight.fillFightBean(sEnterFightBrd.fight);
/* 119 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), sEnterFightBrd);
/*     */       
/* 121 */       FightGroupRole fightGroupRole = fight.getActiveTeam().getGroupRole(((Long)this.arg).longValue());
/* 122 */       if (fightGroupRole == null) {
/* 123 */         fightGroupRole = fight.getPassiveTeam().getGroupRole(((Long)this.arg).longValue());
/*     */       }
/* 125 */       if (fightGroupRole != null) {
/* 126 */         int fighterid = fightGroupRole.getRoleFighterId(((Long)this.arg).longValue());
/* 127 */         if (fighterid > 0) {
/* 128 */           SFighterOnlineBrd sFighterOnlineBrd = new SFighterOnlineBrd();
/* 129 */           sFighterOnlineBrd.fighterid = fighterid;
/* 130 */           sFighterOnlineBrd.status = 1;
/* 131 */           fightGroupRole.fightTeam.broadcast(sFighterOnlineBrd);
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 136 */       Long fightid = Role2fight.select((Long)this.arg);
/* 137 */       if (fightid != null) {
/* 138 */         Integer nextId = xtable.Fight.selectNextid(fightid);
/* 139 */         if (nextId == null)
/*     */         {
/*     */ 
/*     */ 
/* 143 */           Long tempFightId = Role2fight.get((Long)this.arg);
/* 144 */           if ((tempFightId != null) && (tempFightId == fightid)) {
/* 145 */             Role2fight.remove((Long)this.arg);
/* 146 */             RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 0);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */