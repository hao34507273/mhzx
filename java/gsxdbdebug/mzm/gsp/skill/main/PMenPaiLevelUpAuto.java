/*     */ package mzm.gsp.skill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.SMenPaiSkillAutoLevelUpRes;
/*     */ import mzm.gsp.skill.confbean.SSkillBagMenPaiCfg;
/*     */ import mzm.gsp.skill.confbean.STMenPaiSkillBagLevelUpCfgInfo;
/*     */ import mzm.gsp.skill.event.RoleSkillArg;
/*     */ import mzm.gsp.skill.event.RoleSkillLevelUp;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleSkillBags;
/*     */ import xtable.Role2skillbag;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PMenPaiLevelUpAuto
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PMenPaiLevelUpAuto(long roleid)
/*     */   {
/*  32 */     this.roleId = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!SkillManager.isSkillSwitchOpenForRole(this.roleId)) {
/*  39 */       return false;
/*     */     }
/*  41 */     RoleSkillBags xRoleSkillBags = Role2skillbag.get(Long.valueOf(this.roleId));
/*  42 */     SSkillBagMenPaiCfg menPaiCfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(RoleInterface.getOccupationId(this.roleId));
/*  43 */     if (menPaiCfg == null) {
/*  44 */       throw new RuntimeException("can not find men pai skill bag config , men pai id = " + RoleInterface.getOccupationId(this.roleId));
/*     */     }
/*  46 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  47 */     long silver = RoleInterface.getSilver(this.roleId);
/*  48 */     long silverCopy = silver;
/*  49 */     Integer mainSkillLevel = (Integer)xRoleSkillBags.getMenpai().get(menPaiCfg.bag.get(0));
/*     */     
/*  51 */     RoleSkillArg arg = new RoleSkillArg();
/*  52 */     arg.skillType = 1;
/*  53 */     SMenPaiSkillAutoLevelUpRes sMenPaiSkillAutoLevelUpRes = new SMenPaiSkillAutoLevelUpRes();
/*  54 */     Map<Integer, Integer> skill2levelMap = sMenPaiSkillAutoLevelUpRes.skillmap;
/*  55 */     for (Integer id : menPaiCfg.bag) {
/*  56 */       int level = ((Integer)xRoleSkillBags.getMenpai().get(id)).intValue();
/*  57 */       int oldLevel = level;
/*     */       for (;;) {
/*  59 */         STMenPaiSkillBagLevelUpCfgInfo stMenPaiSkillBagLevelUpCfgInfo = MenPaiSkillBagManager.getInstance().getMenPaiLevelCfgInfo(id.intValue(), level + 1);
/*  60 */         if (stMenPaiSkillBagLevelUpCfgInfo == null) {
/*     */           break;
/*     */         }
/*     */         
/*  64 */         if (roleLevel < stMenPaiSkillBagLevelUpCfgInfo.needRoleLevel) {
/*     */           break;
/*     */         }
/*  67 */         if (silver < stMenPaiSkillBagLevelUpCfgInfo.needSilver) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  73 */         silver -= stMenPaiSkillBagLevelUpCfgInfo.needSilver;
/*     */         
/*  75 */         if (menPaiCfg.bag.get(0) == id) {
/*  76 */           mainSkillLevel = Integer.valueOf(level);
/*     */         } else {
/*  78 */           if (level > mainSkillLevel.intValue()) {
/*     */             break;
/*     */           }
/*     */         }
/*     */         
/*  83 */         level++;
/*     */         
/*  85 */         arg.skillBagList.add(id);
/*     */       }
/*  87 */       if (oldLevel != level) {
/*  88 */         xRoleSkillBags.getMenpai().put(id, Integer.valueOf(level));
/*  89 */         skill2levelMap.put(id, Integer.valueOf(level));
/*  90 */         arg.newLevelMap.put(id, Integer.valueOf(level));
/*  91 */         arg.oldLevelMap.put(id, Integer.valueOf(oldLevel));
/*     */       }
/*     */     }
/*     */     
/*  95 */     long costSilver = silverCopy - silver;
/*  96 */     if (!RoleInterface.cutSilver(this.roleId, costSilver, new TLogArg(LogReason.MENPAI_SKILL_LEVEL_UP_REM))) {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     sMenPaiSkillAutoLevelUpRes.usesilver = ((int)costSilver);
/*     */     
/* 102 */     if (costSilver > 0L) {
/* 103 */       OnlineManager.getInstance().send(this.roleId, sMenPaiSkillAutoLevelUpRes);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */     if (costSilver == 0L) {
/* 113 */       return true;
/*     */     }
/*     */     
/* 116 */     RoleSkillLevelUp roleSkillLevelUp = new RoleSkillLevelUp();
/*     */     
/* 118 */     arg.roleId = this.roleId;
/* 119 */     TriggerEventsManger.getInstance().triggerEvent(roleSkillLevelUp, arg);
/*     */     
/* 121 */     for (Map.Entry<Integer, Integer> entry : arg.newLevelMap.entrySet()) {
/* 122 */       int oldLevel = ((Integer)arg.oldLevelMap.get(entry.getKey())).intValue();
/* 123 */       TLogManager.getInstance().addLog(this.roleId, "SkillLevelUp", SkillManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), entry.getKey(), SkillLogType.MENPAI_SKILL, entry.getValue(), Integer.valueOf(oldLevel) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\PMenPaiLevelUpAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */