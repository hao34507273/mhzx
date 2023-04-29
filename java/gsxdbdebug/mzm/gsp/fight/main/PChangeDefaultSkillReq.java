/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xtable.Rolefightcache;
/*     */ 
/*     */ public class PChangeDefaultSkillReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   private int skillid;
/*     */   private int fighterType;
/*     */   
/*     */   public PChangeDefaultSkillReq(long roleid, long uuid, int skillid, int fighterType)
/*     */   {
/*  24 */     this.roleid = roleid;
/*  25 */     this.uuid = uuid;
/*  26 */     this.skillid = skillid;
/*  27 */     this.fighterType = fighterType;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/*  33 */     if (skillCfg == null) {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!skillCfg.canAuto) {
/*  37 */       return false;
/*     */     }
/*  39 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/*  40 */     if (fight != null) {
/*  41 */       lock(xtable.Role2fight.getTable(), fight.getLockRoles());
/*     */     }
/*  43 */     FightCache fightCache = Rolefightcache.get(Long.valueOf(this.roleid));
/*  44 */     if (fightCache == null) {
/*  45 */       fightCache = xbean.Pod.newFightCache();
/*  46 */       Rolefightcache.insert(Long.valueOf(this.roleid), fightCache);
/*     */     }
/*  48 */     switch (this.fighterType) {
/*     */     case 4: 
/*  50 */       mzm.gsp.pet.main.Pet pet = PetInterface.getPetByPetId(this.roleid, this.uuid, true);
/*  51 */       if (pet == null) {
/*  52 */         return false;
/*     */       }
/*  54 */       if (fight != null) {
/*  55 */         Set<Fighter> fighters = fight.getSelectedFighters(null);
/*  56 */         for (Fighter fighter : fighters) {
/*  57 */           if ((fighter.isPet()) && 
/*     */           
/*     */ 
/*  60 */             ((fighter instanceof FighterPet)))
/*     */           {
/*     */ 
/*  63 */             FighterPet fighterPet = (FighterPet)fighter;
/*  64 */             if (fighterPet.getUuid() == this.uuid)
/*     */             {
/*     */ 
/*  67 */               if (!fighterPet.hasSkill(this.skillid))
/*  68 */                 return false;
/*     */             }
/*     */           }
/*     */         }
/*  72 */       } else if ((!PetInterface.getPetSkillList(this.roleid, this.uuid).contains(Integer.valueOf(this.skillid))) && 
/*  73 */         (!FightManager.isCommonSkill(this.skillid, -1))) {
/*  74 */         return false;
/*     */       }
/*     */       
/*  77 */       fightCache.getPet_default_skills().put(Long.valueOf(this.uuid), Integer.valueOf(this.skillid));
/*  78 */       break;
/*     */     case 1: 
/*  80 */       List<Skill> skills = mzm.gsp.skill.main.SkillInterface.getRoleSKills(this.roleid, true);
/*  81 */       boolean isHasSKill = false;
/*  82 */       for (Skill skill : skills) {
/*  83 */         if (skill.getID() == this.skillid)
/*     */         {
/*     */ 
/*  86 */           isHasSKill = true;
/*     */         }
/*     */       }
/*  89 */       if ((!isHasSKill) && 
/*  90 */         (!FightManager.isCommonSkill(this.skillid, mzm.gsp.role.main.RoleInterface.getOccupationId(this.roleid)))) {
/*  91 */         return false;
/*     */       }
/*  93 */       fightCache.setRole_default_skill(this.skillid);
/*  94 */       break;
/*     */     case 16: 
/*  96 */       if (!ChildrenInterface.canJoinFight(this.roleid, this.uuid, false)) {
/*  97 */         GameServer.logger().info(String.format("[Fight]PChangeDefaultSkillReq.processImp@can not operator child|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid) }));
/*     */         
/*     */ 
/*     */ 
/* 101 */         return false;
/*     */       }
/* 103 */       if (fight != null) {
/* 104 */         Set<Fighter> fighters = fight.getSelectedFighters(null);
/* 105 */         for (Fighter fighter : fighters) {
/* 106 */           if ((fighter.isChild()) && 
/*     */           
/*     */ 
/* 109 */             ((fighter instanceof FighterChild)))
/*     */           {
/*     */ 
/* 112 */             FighterChild child = (FighterChild)fighter;
/* 113 */             if (child.getUuid() == this.uuid)
/*     */             {
/*     */ 
/* 116 */               if (!child.hasSkill(this.skillid))
/* 117 */                 return false; }
/*     */           }
/*     */         }
/*     */       } else {
/* 121 */         Set<Integer> fightSkills = ChildrenInterface.getChildFightSkills(this.uuid, false);
/* 122 */         boolean hasSkill = fightSkills.contains(Integer.valueOf(this.skillid));
/* 123 */         if ((!hasSkill) && 
/* 124 */           (!FightManager.isCommonSkill(this.skillid, ChildrenInterface.getChildrenOccupation(this.uuid, false)))) {
/* 125 */           GameServer.logger().info(String.format("[Fight]PChangeDefaultSkillReq.processImp@do not has this fight skill|roleid=%d|childid=%d|skills=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), fightSkills }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 130 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 135 */       fightCache.getChild_default_skills().put(Long.valueOf(this.uuid), Integer.valueOf(this.skillid));
/* 136 */       break;
/*     */     
/*     */     default: 
/* 139 */       if (GameServer.logger().isDebugEnabled()) {
/* 140 */         GameServer.logger().error(getClass().getName() + ":不存在的战斗对象类型 fightType:" + this.fighterType);
/*     */       }
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     Fighter.sendDefalutSkillChangeRes(this.roleid, this.skillid, this.uuid, this.fighterType);
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PChangeDefaultSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */