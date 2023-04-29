/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*     */ import mzm.gsp.partner.confbean.SPartnerLoveDataCfg;
/*     */ import mzm.gsp.partner.main.PartnerInterface;
/*     */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FighterFellow
/*     */   extends Fighter
/*     */ {
/*     */   FighterFellow(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  28 */     super(fighterid, xFighter, fightGroup);
/*     */   }
/*     */   
/*     */   void init(PartnerOutFightObj partnerOutFightObj, int pos)
/*     */   {
/*  33 */     setPos(pos);
/*     */     
/*     */ 
/*  36 */     setHp(partnerOutFightObj.getHP());
/*  37 */     setMp(partnerOutFightObj.getMP());
/*  38 */     setAnger(0.0D);
/*  39 */     setGender(partnerOutFightObj);
/*  40 */     setOccupation(partnerOutFightObj.getOccupationId());
/*     */     
/*  42 */     if (OpenInterface.getOpenStatus(239)) {
/*  43 */       partnerOutFightObj.fillFinalPropertyMap(getAttrsMap());
/*     */     } else {
/*  45 */       partnerOutFightObj.fillSelfFixFightProperty(getAttrsMap());
/*  46 */       partnerOutFightObj.fillOtherFightProperty(getExa_AttrsMap());
/*     */     }
/*  48 */     int partnerid = partnerOutFightObj.getId();
/*  49 */     setPartnerid(partnerid);
/*  50 */     if (PartnerInterface.isAssistPartner(partnerid)) {
/*  51 */       this.fightGroup.fightTeam.setTeamAssistFellowNum(this.fightGroup.fightTeam.getTeamAssistFellowNum() + 1);
/*     */     }
/*     */     
/*  54 */     if (this.fightGroup.getGroupAI() == null) {
/*  55 */       setAi(new AI(PartnerInterface.getSPartnerCfgById(partnerOutFightObj.getId()).partnerAI).getAi());
/*     */     }
/*     */     
/*     */ 
/*  59 */     Map<Integer, Integer> skillMap = PartnerInterface.getPartnerSkillData(getOwnerid(), getPartnerid(), true);
/*  60 */     addAllSkill(skillMap);
/*     */     
/*  62 */     List<PassiveSkill> passiveSkills = partnerOutFightObj.getPassiveSkills();
/*     */     
/*  64 */     installPassiveSkills(passiveSkills);
/*     */     
/*  66 */     List<Integer> loveList = partnerOutFightObj.getLoveList();
/*  67 */     for (Iterator i$ = loveList.iterator(); i$.hasNext();) { int loveid = ((Integer)i$.next()).intValue();
/*  68 */       SPartnerLoveDataCfg partnerLoveDataCfg = PartnerInterface.getPartnerLoveDataCfg(loveid);
/*  69 */       if (partnerLoveDataCfg == null) {
/*  70 */         GameServer.logger().error("伙伴情缘配置不存在 id: " + loveid);
/*     */ 
/*     */       }
/*  73 */       else if (partnerLoveDataCfg.loveEffectId <= 0) {
/*  74 */         GameServer.logger().warn("伙伴情缘配置的效果不存在,petloveid:" + partnerLoveDataCfg.id);
/*     */       }
/*     */       else {
/*  77 */         FighterEffect fighterEffect = EffectInterface.getFighterEffectInstance(partnerLoveDataCfg.loveEffectId, partnerLoveDataCfg.args);
/*     */         
/*  79 */         addPassiveEffect(fighterEffect);
/*     */       } }
/*  81 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.fightTeam.fight.getCfgType());
/*     */     
/*  83 */     if (fightTypeCfg.pveFellowOutFightEffectGroupid > 0) {
/*  84 */       SOutFightEffectGroup outFightEffectGroup = SOutFightEffectGroup.get(fightTypeCfg.pveFellowOutFightEffectGroupid);
/*     */       
/*  86 */       FighterEffect fighterEffect = getPassiveEffect(outFightEffectGroup.effectId, outFightEffectGroup.formulaList, getLevel());
/*     */       
/*  88 */       addPassiveEffect(fighterEffect);
/*     */     }
/*  90 */     initOutFightCommon(partnerOutFightObj);
/*     */   }
/*     */   
/*     */   protected final long getUuid() {
/*  94 */     return getExtra(FighterExtra.FELLOW_ID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final long getOwnerid()
/*     */   {
/* 103 */     return this.fightGroup.getRoleid();
/*     */   }
/*     */   
/*     */   public int getPartnerid() {
/* 107 */     return getExtra(FighterExtra.FELLOW_ID);
/*     */   }
/*     */   
/*     */   protected void setPartnerid(int partnerid) {
/* 111 */     setExtra(FighterExtra.FELLOW_ID, partnerid);
/*     */   }
/*     */   
/*     */   protected boolean canPlayerOperate()
/*     */   {
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isAuto()
/*     */   {
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   protected int getAutoSkill()
/*     */   {
/* 126 */     return getNormalSkill();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void setAuto() {}
/*     */   
/*     */ 
/*     */   protected void onFightEnd()
/*     */   {
/* 135 */     this.fightGroup.addLeaveFightFighter(this);
/* 136 */     this.fightGroup.removeFighter(this.fighterid);
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
/*     */   protected IOutFightObject getOutFightObj()
/*     */   {
/* 152 */     return PartnerInterface.getPartnerOutFightObjById(getOwnerid(), getPartnerid());
/*     */   }
/*     */   
/*     */ 
/*     */   void broadCastSelectOperInTeam() {}
/*     */   
/*     */ 
/*     */   protected void onDead()
/*     */   {
/* 161 */     setFakeDead();
/* 162 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */   protected void setDead()
/*     */   {
/* 167 */     super.setFakeDead();
/*     */   }
/*     */   
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 172 */     if ((fighter instanceof FighterRole)) {
/* 173 */       FighterRole fighterRole = (FighterRole)fighter;
/* 174 */       return getOwnerid() == fighterRole.getRoleid();
/*     */     }
/* 176 */     if ((fighter instanceof CloneFighterRole)) {
/* 177 */       CloneFighterRole cloneFighterRole = (CloneFighterRole)fighter;
/* 178 */       return getOwnerid() == cloneFighterRole.getRoleid();
/*     */     }
/* 180 */     return false;
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
/*     */   void initChangeModelCard()
/*     */   {
/* 198 */     IOutFightObject outFight = getOutFightObj();
/* 199 */     if (outFight == null) {
/* 200 */       return;
/*     */     }
/* 202 */     PartnerOutFightObj fellowOutFight = (PartnerOutFightObj)outFight;
/* 203 */     initChangeModelCard(fellowOutFight.getClassType(), fellowOutFight.getClassLevel());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterFellow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */