/*     */ package mzm.gsp.xiulian.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.XiuLianSkillConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.xiulian.SSyncCommonInfo;
/*     */ import mzm.gsp.xiulian.SSyncSkillExpChange;
/*     */ import mzm.gsp.xiulian.SSyncSkillInfo;
/*     */ import xbean.RoleXiuLian;
/*     */ 
/*     */ public class PCStudySkillReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int skillBagId;
/*     */   private final int studyCount;
/*     */   private static final int STUDY_ONCE_COUNT = 1;
/*     */   private static final int STUDY_TEN_COUNT = 10;
/*     */   private static final int STUDY_HUNDRED_COUNT = 100;
/*     */   
/*     */   public PCStudySkillReq(long roleId, int skillBagId, int studyCount)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.skillBagId = skillBagId;
/*  28 */     this.studyCount = studyCount;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */   {
/*  33 */     if (!XiuLianSkillManager.isXiuLianSwitchOpenForRole(this.roleId))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     RoleXiuLian xRoleXiuLian = xtable.Role2xiulianskill.get(Long.valueOf(this.roleId));
/*  38 */     if (null == xRoleXiuLian)
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xRoleXiuLian.getSkillmap().get(Integer.valueOf(this.skillBagId));
/*  43 */     if (null == xXiuLianSkill)
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!checkStudyCount(xXiuLianSkill.getLevel(), this.studyCount))
/*     */     {
/*  49 */       GameServer.logger().info(String.format("[xiulian]PCStudySkillReq.processImp@studyCount invalid|roleId=%d, studyCount=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.studyCount) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     XiuLianSkill xiuLianSkill = new XiuLianSkill(this.roleId, this.skillBagId, xXiuLianSkill);
/*  55 */     if (xiuLianSkill.isMaxLevel())
/*     */     {
/*  57 */       SSyncCommonInfo sSyncCommonInfo = new SSyncCommonInfo();
/*  58 */       sSyncCommonInfo.res = 1;
/*  59 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSyncCommonInfo);
/*  60 */       return false;
/*     */     }
/*  62 */     int needSilver = XiuLianSkillConsts.getInstance().XIULIAN_LEARN_NEED_SILVER;
/*  63 */     int singleAddExp = XiuLianSkillConsts.getInstance().XIULIAN_LEARN_ADD_EXP;
/*  64 */     int oldLevel = xXiuLianSkill.getLevel();
/*  65 */     long userTotalSilver = RoleInterface.getSilver(this.roleId);
/*  66 */     int count = 0;
/*  67 */     while (userTotalSilver >= needSilver)
/*     */     {
/*  69 */       userTotalSilver -= needSilver;
/*  70 */       count++;
/*  71 */       xiuLianSkill.justAddExp(singleAddExp);
/*  72 */       if (!xiuLianSkill.isMaxLevel())
/*     */       {
/*     */ 
/*     */ 
/*  76 */         if (count >= this.studyCount) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*  81 */     if (count == 0)
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     if (!RoleInterface.cutSilver(this.roleId, needSilver * count, new TLogArg(LogReason.XIULIAN_SKILL_STUDY_REM, count)))
/*     */     {
/*  87 */       return false;
/*     */     }
/*  89 */     int totalExp = singleAddExp * count;
/*     */     
/*  91 */     SSyncSkillExpChange sSyncSkillExpChange = new SSyncSkillExpChange();
/*  92 */     sSyncSkillExpChange.exp = totalExp;
/*  93 */     sSyncSkillExpChange.skillbagid = this.skillBagId;
/*  94 */     sSyncSkillExpChange.usesilver = (needSilver * count);
/*  95 */     OnlineManager.getInstance().send(this.roleId, sSyncSkillExpChange);
/*     */     
/*  97 */     SSyncSkillInfo sSyncSkillLevelUp = new SSyncSkillInfo();
/*  98 */     sSyncSkillLevelUp.skillbag.skillbagid = this.skillBagId;
/*  99 */     sSyncSkillLevelUp.skillbag.skilllevel = xXiuLianSkill.getLevel();
/* 100 */     sSyncSkillLevelUp.skillbag.exp = xXiuLianSkill.getExp();
/* 101 */     OnlineManager.getInstance().send(this.roleId, sSyncSkillLevelUp);
/*     */     
/*     */ 
/* 104 */     xiuLianSkill.addLevelUpTLog(oldLevel, xXiuLianSkill.getLevel());
/* 105 */     xiuLianSkill.addExpChangeTLog(oldLevel, xXiuLianSkill.getLevel(), totalExp, new TLogArg(LogReason.XIULIAN_SKILL_STUDY_REM, needSilver));
/*     */     
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkStudyCount(int currentXiulianLevel, int studyCount)
/*     */   {
/* 119 */     switch (studyCount)
/*     */     {
/*     */     case 1: 
/* 122 */       return true;
/*     */     case 10: 
/* 124 */       return true;
/*     */     case 100: 
/* 126 */       if (currentXiulianLevel >= XiuLianSkillConsts.getInstance().STUDY_HUNDRED_OPEN_LEVEL)
/*     */       {
/* 128 */         return true; }
/*     */       break;
/*     */     }
/* 131 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\PCStudySkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */