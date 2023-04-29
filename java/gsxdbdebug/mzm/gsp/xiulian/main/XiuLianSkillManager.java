/*     */ package mzm.gsp.xiulian.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.skill.confbean.STXiuLianSkillBagLevelUpCfg;
/*     */ import mzm.gsp.skill.confbean.STXiuLianSkillBagLevelUpCfgInfo;
/*     */ import mzm.gsp.skill.confbean.SXiuLianSkillCfg;
/*     */ import mzm.gsp.skill.confbean.XiuLianSkillConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.xiulian.SSyncXiuLainSkillBagInfo;
/*     */ import mzm.gsp.xiulian.SkillBagInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleXiuLian;
/*     */ import xbean.XiuLianSkill;
/*     */ import xtable.Role2xiulianskill;
/*     */ 
/*     */ 
/*     */ class XiuLianSkillManager
/*     */ {
/*     */   public static final String TLOG_XIULIAN_SKILL_LEVEL_UP = "SkillLevelUp";
/*     */   public static final String TLOG_XIULIAN_SKILL_EXP_CHANGE = "XiuLianSkillExpChange";
/*     */   
/*     */   public static void init() {}
/*     */   
/*     */   public static STXiuLianSkillBagLevelUpCfgInfo getLevelUpCfg(int typeId, int level)
/*     */   {
/*  34 */     STXiuLianSkillBagLevelUpCfg stXiuLianSkillBagLevelUpCfg = STXiuLianSkillBagLevelUpCfg.get(typeId);
/*  35 */     if (stXiuLianSkillBagLevelUpCfg == null) {
/*  36 */       return null;
/*     */     }
/*  38 */     STXiuLianSkillBagLevelUpCfgInfo stXiuLianSkillBagLevelUpCfgInfo = (STXiuLianSkillBagLevelUpCfgInfo)stXiuLianSkillBagLevelUpCfg.level2skillinfo.get(Integer.valueOf(level));
/*  39 */     if (stXiuLianSkillBagLevelUpCfgInfo == null) {
/*  40 */       return null;
/*     */     }
/*  42 */     return stXiuLianSkillBagLevelUpCfgInfo;
/*     */   }
/*     */   
/*     */   public static boolean tryOpenFunction(long roleId) {
/*  46 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*  47 */     if (xRoleXiuLian == null) {
/*  48 */       xRoleXiuLian = Pod.newRoleXiuLian();
/*  49 */       Role2xiulianskill.add(Long.valueOf(roleId), xRoleXiuLian);
/*     */     }
/*  51 */     boolean ret = false;
/*  52 */     if (xRoleXiuLian.getSkillmap().isEmpty()) {
/*  53 */       ret = true;
/*     */     }
/*  55 */     for (SXiuLianSkillCfg sSkillBagXiuLianCfg : SXiuLianSkillCfg.getAll().values())
/*  56 */       if (!xRoleXiuLian.getSkillmap().containsKey(Integer.valueOf(sSkillBagXiuLianCfg.id)))
/*     */       {
/*     */ 
/*  59 */         XiuLianSkill xXiuLianSkill = Pod.newXiuLianSkill();
/*  60 */         xXiuLianSkill.setLevel(XiuLianSkillConsts.getInstance().SKILL_BAG_ORGINAL_LEVEL);
/*  61 */         xXiuLianSkill.setExp(0);
/*  62 */         xRoleXiuLian.getSkillmap().put(Integer.valueOf(sSkillBagXiuLianCfg.id), xXiuLianSkill);
/*     */       }
/*  64 */     if (xRoleXiuLian.getDefaultskillid() == 0) {
/*  65 */       xRoleXiuLian.setDefaultskillid(XiuLianSkillConsts.getInstance().DEFAULT_XIULIAN_SKILL_CFG_ID);
/*     */     }
/*  67 */     return ret;
/*     */   }
/*     */   
/*     */   public static void syncXiuLianInfo(long roleId) {
/*  71 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*  72 */     if ((xRoleXiuLian == null) || (xRoleXiuLian.getSkillmap().isEmpty())) {
/*  73 */       return;
/*     */     }
/*  75 */     SSyncXiuLainSkillBagInfo sSyncXiuLainSkillBagInfo = new SSyncXiuLainSkillBagInfo();
/*  76 */     for (Map.Entry<Integer, XiuLianSkill> xiuLianSkillEntry : xRoleXiuLian.getSkillmap().entrySet()) {
/*  77 */       SkillBagInfo skillBagInfo = new SkillBagInfo();
/*  78 */       skillBagInfo.skillbagid = ((Integer)xiuLianSkillEntry.getKey()).intValue();
/*  79 */       skillBagInfo.skilllevel = ((XiuLianSkill)xiuLianSkillEntry.getValue()).getLevel();
/*  80 */       skillBagInfo.exp = ((XiuLianSkill)xiuLianSkillEntry.getValue()).getExp();
/*  81 */       sSyncXiuLainSkillBagInfo.skillbaglist.add(skillBagInfo);
/*     */     }
/*  83 */     sSyncXiuLainSkillBagInfo.defaultskill = xRoleXiuLian.getDefaultskillid();
/*  84 */     OnlineManager.getInstance().send(roleId, sSyncXiuLainSkillBagInfo);
/*     */   }
/*     */   
/*     */   static String createTLog(Object... objects) {
/*  88 */     StringBuilder stringBuilder = new StringBuilder();
/*  89 */     for (int i = 0; i < objects.length; i++) {
/*  90 */       Object o = objects[i];
/*  91 */       stringBuilder.append(o);
/*  92 */       if (i != objects.length - 1) {
/*  93 */         stringBuilder.append("|");
/*     */       }
/*     */     }
/*  96 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isXiuLianSwitchOpenForRole(long roleid)
/*     */   {
/* 106 */     if (!OpenInterface.getOpenStatus(104))
/*     */     {
/*     */ 
/* 109 */       return false;
/*     */     }
/* 111 */     if (OpenInterface.isBanPlay(roleid, 104))
/*     */     {
/* 113 */       OpenInterface.sendBanPlayMsg(roleid, 104);
/* 114 */       return false;
/*     */     }
/* 116 */     if (!checkRoleKuaFuStateCanUseFun(roleid))
/*     */     {
/* 118 */       return false;
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkRoleKuaFuStateCanUseFun(long roleid)
/*     */   {
/* 129 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 192, true)) {
/* 130 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleid);
/* 131 */       GameServer.logger().error(String.format("[XiuLianSkill]XiuLianSkillManager.checkRoleKuaFuStateCanUseFun@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleid), statusSet }));
/*     */       
/*     */ 
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\XiuLianSkillManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */