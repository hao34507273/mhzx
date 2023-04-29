/*     */ package mzm.gsp.xiulian.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.STXiuLianSkillBagLevelUpCfgInfo;
/*     */ import mzm.gsp.skill.confbean.SXiuLianSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SXiuLianSkillScoreCfg;
/*     */ import mzm.gsp.skill.confbean.XiuLianSkillConsts;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.skill.main.SkillLogType;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.xiulian.SSyncCommonInfo;
/*     */ import mzm.gsp.xiulian.SSyncSkillExpChange;
/*     */ import mzm.gsp.xiulian.SSyncSkillInfo;
/*     */ import mzm.gsp.xiulian.SkillBagInfo;
/*     */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*     */ import mzm.gsp.xiulian.event.XiuLianSkillLevelUp;
/*     */ 
/*     */ public class XiuLianSkill
/*     */ {
/*     */   private int skillId;
/*     */   private long roleId;
/*     */   private xbean.XiuLianSkill xXiuLianSkill;
/*     */   private STXiuLianSkillBagLevelUpCfgInfo levelUpCfg;
/*     */   
/*     */   XiuLianSkill(long roleId, int skillId, xbean.XiuLianSkill xXiuLianSkill)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.skillId = skillId;
/*  36 */     this.xXiuLianSkill = xXiuLianSkill;
/*  37 */     SXiuLianSkillCfg skillBagCfg = SXiuLianSkillCfg.get(skillId);
/*  38 */     this.levelUpCfg = XiuLianSkillManager.getLevelUpCfg(skillBagCfg.levelcfgid, xXiuLianSkill.getLevel() + 1);
/*     */   }
/*     */   
/*     */   int getLevelUpNeedRoleLevel() {
/*  42 */     if (this.levelUpCfg != null) {
/*  43 */       return this.levelUpCfg.needRoleLevel;
/*     */     }
/*  45 */     return -1;
/*     */   }
/*     */   
/*     */   int getLevelUpNeedExp() {
/*  49 */     if (this.levelUpCfg != null) {
/*  50 */       return this.levelUpCfg.needExp;
/*     */     }
/*  52 */     return -1;
/*     */   }
/*     */   
/*     */   boolean isMaxLevel() {
/*  56 */     if (this.levelUpCfg == null) {
/*  57 */       return true;
/*     */     }
/*  59 */     SXiuLianSkillCfg skillBagCfg = SXiuLianSkillCfg.get(this.skillId);
/*  60 */     STXiuLianSkillBagLevelUpCfgInfo tempLevelupCfg = XiuLianSkillManager.getLevelUpCfg(skillBagCfg.levelcfgid, this.xXiuLianSkill.getLevel() + 1);
/*  61 */     if (tempLevelupCfg == null) {
/*  62 */       return true;
/*     */     }
/*  64 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  65 */     return (roleLevel < tempLevelupCfg.needRoleLevel) || (this.xXiuLianSkill.getLevel() >= XiuLianSkillConsts.getInstance().SKILL_BAG_MAX_LEVEL);
/*     */   }
/*     */   
/*     */   void addExpAndSend(int exp, int needSilver, TLogArg logArg) {
/*  69 */     SSyncSkillExpChange sSyncSkillExpChange = new SSyncSkillExpChange();
/*  70 */     sSyncSkillExpChange.skillbagid = this.skillId;
/*  71 */     sSyncSkillExpChange.exp = exp;
/*  72 */     sSyncSkillExpChange.usesilver = needSilver;
/*  73 */     OnlineManager.getInstance().send(this.roleId, sSyncSkillExpChange);
/*  74 */     int oldExp = this.xXiuLianSkill.getExp();
/*  75 */     int oldLv = this.xXiuLianSkill.getLevel();
/*  76 */     addExp(exp, logArg);
/*  77 */     int newExp = this.xXiuLianSkill.getExp();
/*  78 */     int newLv = this.xXiuLianSkill.getLevel();
/*  79 */     if ((oldExp == newExp) && (oldLv == newLv)) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void justAddExp(int exp)
/*     */   {
/*  91 */     if ((this.levelUpCfg == null) || (this.levelUpCfg.needRoleLevel > RoleInterface.getLevel(this.roleId))) {
/*  92 */       SSyncCommonInfo sSyncCommonInfo = new SSyncCommonInfo();
/*  93 */       sSyncCommonInfo.res = 1;
/*  94 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSyncCommonInfo);
/*  95 */       return;
/*     */     }
/*  97 */     int newExp = this.xXiuLianSkill.getExp() + exp;
/*  98 */     int needExp = this.levelUpCfg.needExp;
/*  99 */     int tmpLv = this.xXiuLianSkill.getLevel();
/* 100 */     int oldLv = tmpLv;
/* 101 */     int roleLv = RoleInterface.getLevel(this.roleId);
/* 102 */     SXiuLianSkillCfg skillBagCfg = SXiuLianSkillCfg.get(this.skillId);
/* 103 */     STXiuLianSkillBagLevelUpCfgInfo tempLevelupCfg = this.levelUpCfg;
/* 104 */     while (newExp >= needExp) {
/* 105 */       newExp -= needExp;
/* 106 */       tmpLv++;
/* 107 */       tempLevelupCfg = XiuLianSkillManager.getLevelUpCfg(skillBagCfg.levelcfgid, tmpLv + 1);
/* 108 */       if (tempLevelupCfg == null) {
/*     */         break;
/*     */       }
/* 111 */       if (roleLv < tempLevelupCfg.needRoleLevel) {
/*     */         break;
/*     */       }
/* 114 */       needExp = tempLevelupCfg.needExp;
/*     */     }
/*     */     
/* 117 */     if (tempLevelupCfg == null) {
/* 118 */       this.xXiuLianSkill.setExp(0);
/*     */     } else {
/* 120 */       this.xXiuLianSkill.setExp(newExp);
/*     */     }
/* 122 */     if (tmpLv != this.xXiuLianSkill.getLevel()) {
/* 123 */       XiuLianSkillArg arg = new XiuLianSkillArg();
/* 124 */       arg.roleId = this.roleId;
/* 125 */       arg.skillId = this.skillId;
/* 126 */       arg.newLevel = tmpLv;
/* 127 */       arg.oldLevel = oldLv;
/* 128 */       TriggerEventsManger.getInstance().triggerEvent(new XiuLianSkillLevelUp(), arg);
/*     */     }
/* 130 */     this.xXiuLianSkill.setLevel(tmpLv);
/*     */   }
/*     */   
/*     */   void addExp(int exp, TLogArg logArg) {
/* 134 */     if ((this.levelUpCfg == null) || (this.levelUpCfg.needRoleLevel > RoleInterface.getLevel(this.roleId))) {
/* 135 */       if (this.levelUpCfg != null) {
/* 136 */         this.xXiuLianSkill.setExp(this.xXiuLianSkill.getExp() + exp);
/* 137 */         SSyncSkillInfo sSyncSkillLevelUp = new SSyncSkillInfo();
/* 138 */         SkillBagInfo skillBagInfo = sSyncSkillLevelUp.skillbag;
/* 139 */         skillBagInfo.skillbagid = this.skillId;
/* 140 */         skillBagInfo.exp = this.xXiuLianSkill.getExp();
/* 141 */         skillBagInfo.skilllevel = this.xXiuLianSkill.getLevel();
/* 142 */         OnlineManager.getInstance().send(this.roleId, sSyncSkillLevelUp);
/*     */       }
/* 144 */       SSyncCommonInfo sSyncCommonInfo = new SSyncCommonInfo();
/* 145 */       sSyncCommonInfo.res = 1;
/* 146 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSyncCommonInfo);
/* 147 */       return;
/*     */     }
/* 149 */     int newExp = this.xXiuLianSkill.getExp() + exp;
/* 150 */     int needExp = this.levelUpCfg.needExp;
/* 151 */     int tmpLv = this.xXiuLianSkill.getLevel();
/* 152 */     int oldLv = tmpLv;
/* 153 */     int roleLv = RoleInterface.getLevel(this.roleId);
/* 154 */     SXiuLianSkillCfg skillBagCfg = SXiuLianSkillCfg.get(this.skillId);
/* 155 */     STXiuLianSkillBagLevelUpCfgInfo tempLevelupCfg = this.levelUpCfg;
/* 156 */     while (newExp >= needExp) {
/* 157 */       newExp -= needExp;
/* 158 */       tmpLv++;
/* 159 */       tempLevelupCfg = XiuLianSkillManager.getLevelUpCfg(skillBagCfg.levelcfgid, tmpLv + 1);
/* 160 */       if (tempLevelupCfg == null) {
/*     */         break;
/*     */       }
/* 163 */       if (roleLv < tempLevelupCfg.needRoleLevel) {
/*     */         break;
/*     */       }
/* 166 */       needExp = tempLevelupCfg.needExp;
/*     */     }
/*     */     
/* 169 */     if (tempLevelupCfg == null) {
/* 170 */       this.xXiuLianSkill.setExp(0);
/*     */     } else {
/* 172 */       this.xXiuLianSkill.setExp(newExp);
/*     */     }
/* 174 */     if (tmpLv != this.xXiuLianSkill.getLevel()) {
/* 175 */       XiuLianSkillArg arg = new XiuLianSkillArg();
/* 176 */       arg.roleId = this.roleId;
/* 177 */       arg.skillId = this.skillId;
/* 178 */       arg.oldLevel = oldLv;
/* 179 */       arg.newLevel = tmpLv;
/* 180 */       TriggerEventsManger.getInstance().triggerEvent(new XiuLianSkillLevelUp(), arg);
/*     */       
/* 182 */       addLevelUpTLog(oldLv, tmpLv);
/*     */     }
/*     */     
/* 185 */     this.xXiuLianSkill.setLevel(tmpLv);
/* 186 */     SSyncSkillInfo sSyncSkillLevelUp = new SSyncSkillInfo();
/* 187 */     SkillBagInfo skillBagInfo = sSyncSkillLevelUp.skillbag;
/* 188 */     skillBagInfo.skillbagid = this.skillId;
/* 189 */     skillBagInfo.exp = this.xXiuLianSkill.getExp();
/* 190 */     skillBagInfo.skilllevel = this.xXiuLianSkill.getLevel();
/* 191 */     OnlineManager.getInstance().send(this.roleId, sSyncSkillLevelUp);
/*     */     
/* 193 */     addExpChangeTLog(oldLv, tmpLv, exp, logArg);
/*     */   }
/*     */   
/*     */   public PassiveSkill getPassiveSkill() {
/* 197 */     SXiuLianSkillCfg sXiuLianSkillCfg = SXiuLianSkillCfg.get(this.skillId);
/* 198 */     return SkillInterface.getPassiveSkillById2Lv(sXiuLianSkillCfg.skillId, this.xXiuLianSkill.getLevel());
/*     */   }
/*     */   
/*     */   public int getScore() {
/* 202 */     int lv = this.xXiuLianSkill.getLevel();
/* 203 */     for (SXiuLianSkillScoreCfg cfg : SXiuLianSkillScoreCfg.getAll().values()) {
/* 204 */       if ((cfg.xiuLianSkillId == this.skillId) && (cfg.skillLevel == lv)) {
/* 205 */         return cfg.score;
/*     */       }
/*     */     }
/* 208 */     return 0;
/*     */   }
/*     */   
/* 211 */   public int getSkillLevel() { return this.xXiuLianSkill.getLevel(); }
/*     */   
/*     */   void autoLevelUp()
/*     */   {
/* 215 */     if ((this.levelUpCfg == null) || (this.levelUpCfg.needRoleLevel > RoleInterface.getLevel(this.roleId))) {
/* 216 */       return;
/*     */     }
/* 218 */     int newExp = this.xXiuLianSkill.getExp();
/* 219 */     int needExp = this.levelUpCfg.needExp;
/* 220 */     int tmpLv = this.xXiuLianSkill.getLevel();
/* 221 */     int oldLv = tmpLv;
/* 222 */     int roleLv = RoleInterface.getLevel(this.roleId);
/* 223 */     SXiuLianSkillCfg skillBagCfg = SXiuLianSkillCfg.get(this.skillId);
/* 224 */     STXiuLianSkillBagLevelUpCfgInfo tempLevelupCfg = this.levelUpCfg;
/* 225 */     while (newExp >= needExp) {
/* 226 */       newExp -= needExp;
/* 227 */       tmpLv++;
/* 228 */       tempLevelupCfg = XiuLianSkillManager.getLevelUpCfg(skillBagCfg.levelcfgid, tmpLv + 1);
/* 229 */       if (tempLevelupCfg == null) {
/*     */         break;
/*     */       }
/* 232 */       if (roleLv < tempLevelupCfg.needRoleLevel) {
/*     */         break;
/*     */       }
/* 235 */       needExp = tempLevelupCfg.needExp;
/*     */     }
/*     */     
/* 238 */     if (tempLevelupCfg == null) {
/* 239 */       this.xXiuLianSkill.setExp(0);
/*     */     } else {
/* 241 */       this.xXiuLianSkill.setExp(newExp);
/*     */     }
/* 243 */     if (tmpLv != this.xXiuLianSkill.getLevel()) {
/* 244 */       this.xXiuLianSkill.setLevel(tmpLv);
/* 245 */       XiuLianSkillArg arg = new XiuLianSkillArg();
/* 246 */       arg.roleId = this.roleId;
/* 247 */       arg.skillId = this.skillId;
/* 248 */       arg.newLevel = tmpLv;
/* 249 */       arg.oldLevel = oldLv;
/* 250 */       TriggerEventsManger.getInstance().triggerEvent(new XiuLianSkillLevelUp(), arg);
/*     */       
/* 252 */       addLevelUpTLog(oldLv, tmpLv);
/*     */       
/* 254 */       SSyncSkillInfo sSyncSkillLevelUp = new SSyncSkillInfo();
/* 255 */       SkillBagInfo skillBagInfo = sSyncSkillLevelUp.skillbag;
/* 256 */       skillBagInfo.skillbagid = this.skillId;
/* 257 */       skillBagInfo.exp = this.xXiuLianSkill.getExp();
/* 258 */       skillBagInfo.skilllevel = this.xXiuLianSkill.getLevel();
/* 259 */       OnlineManager.getInstance().send(this.roleId, sSyncSkillLevelUp);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addLevelUpTLog(int oldLevel, int newLevel)
/*     */   {
/* 271 */     if (oldLevel == newLevel)
/*     */     {
/* 273 */       return;
/*     */     }
/* 275 */     TLogManager.getInstance().addLog(this.roleId, "SkillLevelUp", XiuLianSkillManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(this.skillId), SkillLogType.XIULIAN_SKILL, Integer.valueOf(oldLevel), Integer.valueOf(newLevel) }));
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
/*     */   void addExpChangeTLog(int oldLevel, int newLevel, int exp, TLogArg logArg)
/*     */   {
/* 291 */     TLogManager.getInstance().addLog(this.roleId, "XiuLianSkillExpChange", XiuLianSkillManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Integer.valueOf(this.skillId), Integer.valueOf(oldLevel), Integer.valueOf(newLevel), Integer.valueOf(exp), Integer.valueOf(logArg.logReason.value) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\XiuLianSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */