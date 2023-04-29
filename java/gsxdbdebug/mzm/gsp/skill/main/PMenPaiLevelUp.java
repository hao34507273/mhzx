/*     */ package mzm.gsp.skill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.SMenPaiLevelUpRes;
/*     */ import mzm.gsp.skill.confbean.SSkillBagMenPaiCfg;
/*     */ import mzm.gsp.skill.confbean.STMenPaiSkillBagLevelUpCfgInfo;
/*     */ import mzm.gsp.skill.confbean.SkillConsts;
/*     */ import mzm.gsp.skill.event.RoleSkillArg;
/*     */ import mzm.gsp.skill.event.RoleSkillLevelUp;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleSkillBags;
/*     */ import xtable.Role2skillbag;
/*     */ 
/*     */ public class PMenPaiLevelUp extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int skillBagId;
/*     */   
/*     */   public PMenPaiLevelUp(long roleId, int skillBagId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.skillBagId = skillBagId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!SkillManager.isSkillSwitchOpenForRole(this.roleId)) {
/*  39 */       return false;
/*     */     }
/*  41 */     Role role = RoleInterface.getRole(this.roleId, true);
/*     */     
/*  43 */     if (role.getLevel() < SkillConsts.getInstance().OPENLEVEL) {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     RoleSkillBags xSkillBagInfo = Role2skillbag.get(Long.valueOf(this.roleId));
/*  48 */     if (xSkillBagInfo == null) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     Integer level = (Integer)xSkillBagInfo.getMenpai().get(Integer.valueOf(this.skillBagId));
/*  53 */     if (level == null) {
/*  54 */       return false;
/*     */     }
/*  56 */     SSkillBagMenPaiCfg cfg = MenPaiSkillBagManager.getInstance().getMenPaiSkillBagCfg(role.getOccupationId());
/*  57 */     int mainSkillId = ((Integer)cfg.bag.get(0)).intValue();
/*  58 */     Integer mainLevel = (Integer)xSkillBagInfo.getMenpai().get(Integer.valueOf(mainSkillId));
/*  59 */     if ((level.intValue() >= mainLevel.intValue()) && (mainSkillId != this.skillBagId)) {
/*  60 */       return false;
/*     */     }
/*  62 */     STMenPaiSkillBagLevelUpCfgInfo stMenPaiSkillBagLevelUpCfgInfo = MenPaiSkillBagManager.getInstance().getMenPaiLevelCfgInfo(this.skillBagId, level.intValue() + 1);
/*     */     
/*  64 */     if (stMenPaiSkillBagLevelUpCfgInfo == null) {
/*  65 */       return false;
/*     */     }
/*  67 */     if (role.getLevel() < stMenPaiSkillBagLevelUpCfgInfo.needRoleLevel) {
/*  68 */       return false;
/*     */     }
/*  70 */     if (!RoleInterface.cutSilver(this.roleId, stMenPaiSkillBagLevelUpCfgInfo.needSilver, new TLogArg(LogReason.MENPAI_SKILL_LEVEL_UP_REM))) {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     level = Integer.valueOf(level.intValue() + 1);
/*  75 */     xSkillBagInfo.getMenpai().put(Integer.valueOf(this.skillBagId), level);
/*  76 */     SMenPaiLevelUpRes res = new SMenPaiLevelUpRes();
/*  77 */     res.skillbaginfo.level = level.intValue();
/*  78 */     res.skillbaginfo.skillbagid = this.skillBagId;
/*  79 */     res.usesilver = stMenPaiSkillBagLevelUpCfgInfo.needSilver;
/*  80 */     OnlineManager.getInstance().send(this.roleId, res);
/*  81 */     RoleSkillLevelUp roleSkillLevelUp = new RoleSkillLevelUp();
/*  82 */     RoleSkillArg arg = new RoleSkillArg();
/*  83 */     arg.skillType = 1;
/*  84 */     arg.oldLevelMap.put(Integer.valueOf(this.skillBagId), Integer.valueOf(level.intValue() - 1));
/*  85 */     arg.newLevelMap.put(Integer.valueOf(this.skillBagId), level);
/*  86 */     arg.roleId = this.roleId;
/*  87 */     arg.skillBagList.add(Integer.valueOf(this.skillBagId));
/*  88 */     TriggerEventsManger.getInstance().triggerEvent(roleSkillLevelUp, arg);
/*     */     
/*  90 */     TLogManager.getInstance().addLog(this.roleId, "SkillLevelUp", SkillManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), SkillLogType.MENPAI_SKILL, Integer.valueOf(level.intValue() - 1), level }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\PMenPaiLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */