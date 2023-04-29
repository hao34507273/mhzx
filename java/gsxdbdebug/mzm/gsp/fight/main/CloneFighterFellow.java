/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*    */ import mzm.gsp.partner.confbean.SPartnerLoveDataCfg;
/*    */ import mzm.gsp.partner.main.PartnerInterface;
/*    */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*    */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Fighter;
/*    */ 
/*    */ class CloneFighterFellow extends FighterFellow implements CloneFighter
/*    */ {
/*    */   CloneFighterFellow(int fighterid, Fighter xFighter, FightGroup fightGroup)
/*    */   {
/* 20 */     super(fighterid, xFighter, fightGroup);
/* 21 */     setExtra(FighterExtra.CLONE_MINI_TYPE, 2);
/*    */   }
/*    */   
/*    */ 
/*    */   void init(PartnerOutFightObj partnerOutFightObj, int pos, Map<Integer, Integer> attrsMap, Map<Integer, Integer> exaAttrsMap)
/*    */   {
/* 27 */     setPos(pos);
/*    */     
/* 29 */     getAttrsMap().putAll(attrsMap);
/*    */     
/* 31 */     getExa_AttrsMap().putAll(exaAttrsMap);
/*    */     
/* 33 */     setHp((int)getMaxHp());
/* 34 */     setMp((int)getMaxMp());
/* 35 */     setAnger(0.0D);
/* 36 */     setGender(partnerOutFightObj);
/* 37 */     setOccupation(partnerOutFightObj.getOccupationId());
/* 38 */     int partnerid = partnerOutFightObj.getId();
/* 39 */     setPartnerid(partnerid);
/* 40 */     if (PartnerInterface.isAssistPartner(partnerid)) {
/* 41 */       this.fightGroup.fightTeam.setTeamAssistFellowNum(this.fightGroup.fightTeam.getTeamAssistFellowNum() + 1);
/*    */     }
/*    */     
/* 44 */     if (this.fightGroup.getGroupAI() == null) {
/* 45 */       setAi(new AI(PartnerInterface.getSPartnerCfgById(partnerOutFightObj.getId()).partnerAI).getAi());
/*    */     }
/*    */     
/*    */ 
/* 49 */     Map<Integer, Integer> skillMap = PartnerInterface.getPartnerSkillData(getOwnerid(), getPartnerid(), true);
/* 50 */     addAllSkill(skillMap);
/*    */     
/* 52 */     List<mzm.gsp.skill.main.PassiveSkill> passiveSkills = partnerOutFightObj.getPassiveSkills();
/*    */     
/*    */ 
/* 55 */     installPassiveSkills(passiveSkills);
/*    */     
/*    */ 
/* 58 */     List<Integer> loveList = partnerOutFightObj.getLoveList();
/* 59 */     for (Iterator i$ = loveList.iterator(); i$.hasNext();) { int loveid = ((Integer)i$.next()).intValue();
/* 60 */       SPartnerLoveDataCfg partnerLoveDataCfg = PartnerInterface.getPartnerLoveDataCfg(loveid);
/* 61 */       if (partnerLoveDataCfg == null) {
/* 62 */         GameServer.logger().error("伙伴情缘配置不存在 id: " + loveid);
/*    */ 
/*    */       }
/* 65 */       else if (partnerLoveDataCfg.loveEffectId <= 0) {
/* 66 */         GameServer.logger().warn("伙伴情缘配置的效果不存在,petloveid:" + partnerLoveDataCfg.id);
/*    */       }
/*    */       else {
/* 69 */         FighterEffect fighterEffect = mzm.gsp.effect.main.EffectInterface.getFighterEffectInstance(partnerLoveDataCfg.loveEffectId, partnerLoveDataCfg.args);
/*    */         
/* 71 */         addPassiveEffect(fighterEffect);
/*    */       }
/*    */     }
/* 74 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.fightTeam.fight.getCfgType());
/*    */     
/* 76 */     if (fightTypeCfg.pveFellowOutFightEffectGroupid > 0) {
/* 77 */       SOutFightEffectGroup outFightEffectGroup = SOutFightEffectGroup.get(fightTypeCfg.pveFellowOutFightEffectGroupid);
/*    */       
/* 79 */       FighterEffect fighterEffect = getPassiveEffect(outFightEffectGroup.effectId, outFightEffectGroup.formulaList, getLevel());
/*    */       
/* 81 */       addPassiveEffect(fighterEffect);
/*    */     }
/* 83 */     initOutFightCommon(partnerOutFightObj);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\CloneFighterFellow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */