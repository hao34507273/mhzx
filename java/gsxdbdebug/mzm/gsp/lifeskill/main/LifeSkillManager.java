/*     */ package mzm.gsp.lifeskill.main;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.lifeskill.SSyncLifeSkillBagInfo;
/*     */ import mzm.gsp.lifeskill.SkillBagInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.LifeSkillConsts;
/*     */ import mzm.gsp.skill.confbean.SLifeSkillBagCfg;
/*     */ import mzm.gsp.skill.confbean.STCookDrugQualityCfg;
/*     */ import mzm.gsp.skill.confbean.STLifeSkillBagLevelUpCfg;
/*     */ import mzm.gsp.skill.confbean.STLifeSkillBagLevelUpCfgInfo;
/*     */ import mzm.gsp.skill.confbean.STWuQiFuLifeSkillBag;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleLifeSkill;
/*     */ import xtable.Role2lifeskill;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LifeSkillManager
/*     */ {
/*     */   public static final String TLOG_NAME = "SkillLevelUp";
/*     */   public static final String TLOG_LIFESKILL_LEVEL_RESET = "LifeSkillLevelReset";
/*     */   
/*     */   private static void openFunction(long roleId)
/*     */   {
/*  36 */     RoleLifeSkill xRoleLifeSkill = Role2lifeskill.get(Long.valueOf(roleId));
/*  37 */     if (xRoleLifeSkill == null) {
/*  38 */       xRoleLifeSkill = Pod.newRoleLifeSkill();
/*  39 */       Role2lifeskill.add(Long.valueOf(roleId), xRoleLifeSkill);
/*     */     }
/*  41 */     if (!xRoleLifeSkill.getLifeskillbagmap().isEmpty()) {
/*  42 */       return;
/*     */     }
/*  44 */     for (SLifeSkillBagCfg cfg : SLifeSkillBagCfg.getAll().values())
/*     */     {
/*  46 */       if (cfg.skillBagType != 3)
/*     */       {
/*     */ 
/*     */ 
/*  50 */         xRoleLifeSkill.getLifeskillbagmap().put(Integer.valueOf(cfg.id), Integer.valueOf(LifeSkillConsts.getInstance().SKILLBAG_ORGINAL_LEVEL));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void syncRoleLifeSkillList(long roleId)
/*     */   {
/*  59 */     int level = RoleInterface.getLevel(roleId);
/*  60 */     if (level < LifeSkillConsts.getInstance().OPEN_LEVEL) {
/*  61 */       return;
/*     */     }
/*  63 */     RoleLifeSkill xRoleLifeSkill = Role2lifeskill.get(Long.valueOf(roleId));
/*  64 */     if (xRoleLifeSkill == null) {
/*  65 */       openFunction(roleId);
/*  66 */       xRoleLifeSkill = Role2lifeskill.get(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  69 */     SSyncLifeSkillBagInfo sSyncLifeSkillBagInfo = new SSyncLifeSkillBagInfo();
/*  70 */     for (Map.Entry<Integer, Integer> skillId2Lv : xRoleLifeSkill.getLifeskillbagmap().entrySet()) {
/*  71 */       int id = ((Integer)skillId2Lv.getKey()).intValue();
/*  72 */       int lv = ((Integer)skillId2Lv.getValue()).intValue();
/*  73 */       SkillBagInfo skillBagInfo = new SkillBagInfo();
/*  74 */       skillBagInfo.skillbagid = id;
/*  75 */       skillBagInfo.skilllevel = lv;
/*  76 */       sSyncLifeSkillBagInfo.skillbaglist.add(skillBagInfo);
/*     */     }
/*  78 */     OnlineManager.getInstance().send(roleId, sSyncLifeSkillBagInfo);
/*     */   }
/*     */   
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */   static int getQuality(int itemId)
/*     */   {
/*  86 */     STCookDrugQualityCfg stCookDrugQualityCfg = STCookDrugQualityCfg.get(itemId);
/*  87 */     if (stCookDrugQualityCfg == null) {
/*  88 */       return 0;
/*     */     }
/*  90 */     Integer q = Integer.valueOf(stCookDrugQualityCfg.itemMaxQuality);
/*  91 */     if (q == null) q = Integer.valueOf(0);
/*  92 */     return q.intValue();
/*     */   }
/*     */   
/*  95 */   static Integer getLevelUpCfgId(int typeId, int level) { STLifeSkillBagLevelUpCfg stLifeSkillBagLevelUpCfg = STLifeSkillBagLevelUpCfg.get(typeId);
/*  96 */     if (stLifeSkillBagLevelUpCfg == null) {
/*  97 */       return null;
/*     */     }
/*  99 */     STLifeSkillBagLevelUpCfgInfo stLifeSkillBagLevelUpCfgInfo = (STLifeSkillBagLevelUpCfgInfo)STLifeSkillBagLevelUpCfg.get(typeId).level2skillinfo.get(Integer.valueOf(level));
/* 100 */     if (stLifeSkillBagLevelUpCfgInfo == null) {
/* 101 */       return null;
/*     */     }
/* 103 */     return Integer.valueOf(stLifeSkillBagLevelUpCfgInfo.id);
/*     */   }
/*     */   
/*     */   static Integer getSkillIdByItemId(int itemId) {
/* 107 */     STWuQiFuLifeSkillBag stWuQiFuLifeSkillBag = STWuQiFuLifeSkillBag.get(itemId);
/* 108 */     if (stWuQiFuLifeSkillBag == null) {
/* 109 */       return null;
/*     */     }
/* 111 */     Integer skillId = Integer.valueOf(stWuQiFuLifeSkillBag.skillid);
/* 112 */     return skillId;
/*     */   }
/*     */   
/*     */   static String createTLog(Object... objects) {
/* 116 */     StringBuilder stringBuilder = new StringBuilder();
/* 117 */     for (int i = 0; i < objects.length; i++) {
/* 118 */       Object o = objects[i];
/* 119 */       stringBuilder.append(o);
/* 120 */       if (i != objects.length - 1) {
/* 121 */         stringBuilder.append("|");
/*     */       }
/*     */     }
/* 124 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isLifeSkillSwitchOpenForRole(long roleid)
/*     */   {
/* 134 */     if (!OpenInterface.getOpenStatus(105))
/*     */     {
/* 136 */       OpenInterface.sendCloseProtocol(roleid, 105, null);
/*     */       
/* 138 */       return false;
/*     */     }
/* 140 */     if (OpenInterface.isBanPlay(roleid, 105))
/*     */     {
/* 142 */       OpenInterface.sendBanPlayMsg(roleid, 105);
/* 143 */       return false;
/*     */     }
/* 145 */     if (!checkRoleKuaFuStateCanUseFun(roleid))
/*     */     {
/* 147 */       return false;
/*     */     }
/* 149 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkRoleKuaFuStateCanUseFun(long roleid)
/*     */   {
/* 158 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 191, true)) {
/* 159 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleid);
/* 160 */       GameServer.logger().error(String.format("[LifeSkill]LifeSkillManager.checkRoleKuaFuStateCanUseFun@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleid), statusSet }));
/*     */       
/*     */ 
/* 163 */       return false;
/*     */     }
/* 165 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isSkillInBag(int skillBagCfgid, int subSkillBagCfgid)
/*     */   {
/* 170 */     SLifeSkillBagCfg skillBagCfg = SLifeSkillBagCfg.get(skillBagCfgid);
/* 171 */     if (skillBagCfg == null)
/*     */     {
/* 173 */       return false;
/*     */     }
/*     */     
/* 176 */     for (Integer skillid : skillBagCfg.skillBagList)
/*     */     {
/* 178 */       if (skillid.intValue() == subSkillBagCfgid)
/*     */       {
/* 180 */         return true;
/*     */       }
/*     */     }
/* 183 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isLifeSkillResetFunOpen(long roleid)
/*     */   {
/* 194 */     if (!OpenInterface.getOpenStatus(560))
/*     */     {
/* 196 */       GameServer.logger().error("[LifeSkill]LifeSkillManager.isLifeSkillResetFunOpen@fun not open");
/* 197 */       return false;
/*     */     }
/* 199 */     if (OpenInterface.isBanPlay(roleid, 560))
/*     */     {
/* 201 */       GameServer.logger().error(String.format("[LifeSkill]LifeSkillManager.isLifeSkillResetFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 202 */       OpenInterface.sendBanPlayMsg(roleid, 560);
/* 203 */       return false;
/*     */     }
/* 205 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LifeSkillManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */