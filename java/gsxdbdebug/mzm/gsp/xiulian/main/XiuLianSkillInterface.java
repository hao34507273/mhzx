/*     */ package mzm.gsp.xiulian.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.skill.confbean.SXiuLianSkillCfg;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.RoleXiuLian;
/*     */ import xtable.Role2xiulianskill;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XiuLianSkillInterface
/*     */ {
/*     */   public static void addXiuLianExp(long roleId, int addExp, TLogArg logArg)
/*     */   {
/*  25 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*  26 */     if (xRoleXiuLian == null) {
/*  27 */       return;
/*     */     }
/*  29 */     xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xRoleXiuLian.getSkillmap().get(Integer.valueOf(xRoleXiuLian.getDefaultskillid()));
/*  30 */     if (xXiuLianSkill == null) {
/*  31 */       return;
/*     */     }
/*  33 */     XiuLianSkill xiuLianSkill = new XiuLianSkill(roleId, xRoleXiuLian.getDefaultskillid(), xXiuLianSkill);
/*  34 */     xiuLianSkill.addExpAndSend(addExp, 0, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addXiuLianExp(long roleId, int skillBagId, int addExp, TLogArg logArg)
/*     */   {
/*  45 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*  46 */     if (xRoleXiuLian == null) {
/*  47 */       return;
/*     */     }
/*  49 */     xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xRoleXiuLian.getSkillmap().get(Integer.valueOf(skillBagId));
/*  50 */     if (xXiuLianSkill == null) {
/*  51 */       return;
/*     */     }
/*  53 */     XiuLianSkill xiuLianSkill = new XiuLianSkill(roleId, skillBagId, xXiuLianSkill);
/*  54 */     xiuLianSkill.addExpAndSend(addExp, 0, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addXiuLianExpNotSyncClient(long roleId, int addExp, TLogArg logArg)
/*     */   {
/*  64 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*  65 */     if (xRoleXiuLian == null) {
/*  66 */       return;
/*     */     }
/*  68 */     xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xRoleXiuLian.getSkillmap().get(Integer.valueOf(xRoleXiuLian.getDefaultskillid()));
/*  69 */     if (xXiuLianSkill == null) {
/*  70 */       return;
/*     */     }
/*  72 */     XiuLianSkill xiuLianSkill = new XiuLianSkill(roleId, xRoleXiuLian.getDefaultskillid(), xXiuLianSkill);
/*  73 */     xiuLianSkill.addExp(addExp, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getXiuLianSkillLevel(long roleId, int skillId)
/*     */   {
/*  85 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*  86 */     if (xRoleXiuLian == null) {
/*  87 */       return -1;
/*     */     }
/*  89 */     xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xRoleXiuLian.getSkillmap().get(Integer.valueOf(skillId));
/*  90 */     if (xXiuLianSkill == null) {
/*  91 */       return -1;
/*     */     }
/*  93 */     return xXiuLianSkill.getLevel();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<XiuLianSkill> getXiuLianSkill(long roleId, int target, boolean retainLock)
/*     */   {
/* 104 */     List<XiuLianSkill> skills = new ArrayList();
/*     */     RoleXiuLian xRoleXiuLian;
/* 106 */     RoleXiuLian xRoleXiuLian; if (retainLock) {
/* 107 */       xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(roleId));
/*     */     } else {
/* 109 */       xRoleXiuLian = Role2xiulianskill.select(Long.valueOf(roleId));
/*     */     }
/* 111 */     if (xRoleXiuLian != null)
/* 112 */       for (Map.Entry<Integer, xbean.XiuLianSkill> xXiuLianSkillEntry : xRoleXiuLian.getSkillmap().entrySet()) {
/* 113 */         xbean.XiuLianSkill xXiuLianSkill = (xbean.XiuLianSkill)xXiuLianSkillEntry.getValue();
/* 114 */         if (xXiuLianSkill.getLevel() != 0)
/*     */         {
/*     */ 
/* 117 */           SXiuLianSkillCfg sXiuLianSkillCfg = SXiuLianSkillCfg.get(((Integer)xXiuLianSkillEntry.getKey()).intValue());
/* 118 */           if (((sXiuLianSkillCfg.target & target) != 0) || (target == -1))
/*     */           {
/*     */ 
/* 121 */             XiuLianSkill xiuLianSkill = new XiuLianSkill(roleId, ((Integer)xXiuLianSkillEntry.getKey()).intValue(), xXiuLianSkill);
/* 122 */             skills.add(xiuLianSkill);
/*     */           }
/*     */         } }
/* 125 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<PassiveSkill> getXiuLianPassiveSkills(long roleId, int target, boolean remainRoleLock)
/*     */   {
/* 137 */     List<PassiveSkill> passiveSkills = new ArrayList();
/* 138 */     List<XiuLianSkill> xiuLianSkills = getXiuLianSkill(roleId, target, remainRoleLock);
/* 139 */     for (XiuLianSkill skill : xiuLianSkills) {
/* 140 */       PassiveSkill passiveSkill = skill.getPassiveSkill();
/* 141 */       if (passiveSkill != null)
/*     */       {
/*     */ 
/* 144 */         passiveSkills.add(passiveSkill); }
/*     */     }
/* 146 */     return passiveSkills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getXiuLianSkillEffectTarget(int skillId)
/*     */   {
/* 158 */     SXiuLianSkillCfg sXiuLianSkillCfg = SXiuLianSkillCfg.get(skillId);
/* 159 */     return sXiuLianSkillCfg.target;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getXiuLianSkill(long roleId)
/*     */   {
/* 169 */     Map<Integer, Integer> xiuLianSkillMap = new TreeMap();
/* 170 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.select(Long.valueOf(roleId));
/* 171 */     if (xRoleXiuLian != null) {
/* 172 */       for (Map.Entry<Integer, xbean.XiuLianSkill> xXiuLianSkillEntry : xRoleXiuLian.getSkillmap().entrySet()) {
/* 173 */         xiuLianSkillMap.put(xXiuLianSkillEntry.getKey(), Integer.valueOf(((xbean.XiuLianSkill)xXiuLianSkillEntry.getValue()).getLevel()));
/*     */       }
/*     */     }
/* 176 */     return xiuLianSkillMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\XiuLianSkillInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */