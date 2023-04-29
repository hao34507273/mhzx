/*     */ package mzm.gsp.gangskill.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gangskill.GangSkillBagInfo;
/*     */ import mzm.gsp.gangskill.SGangSkillError;
/*     */ import mzm.gsp.gangskill.SSyncGangSkillBagInfo;
/*     */ import mzm.gsp.gangskill.event.GangSkillArg;
/*     */ import mzm.gsp.gangskill.event.GangSkillChanged;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.SGangSkillBag;
/*     */ import mzm.gsp.skill.confbean.SGangSkillBagLevelUpCfg;
/*     */ import mzm.gsp.skill.confbean.SGangSkillScoreCfg;
/*     */ import mzm.gsp.skill.confbean.STypeid2Gangskilllevelupid;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGangSkill;
/*     */ import xtable.Role2gangskill;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GangSkillManager
/*     */ {
/*     */   static void init() {}
/*     */   
/*     */   static SGangSkillBagLevelUpCfg getLevelUpcfgBySkillLevel(int skillid, int skillLevel)
/*     */   {
/*  38 */     SGangSkillBag gangSkillBag = SGangSkillBag.get(skillid);
/*  39 */     if (gangSkillBag == null)
/*     */     {
/*  41 */       return null;
/*     */     }
/*  43 */     STypeid2Gangskilllevelupid s = STypeid2Gangskilllevelupid.get(gangSkillBag.typeId);
/*  44 */     if (s == null)
/*     */     {
/*  46 */       return null;
/*     */     }
/*  48 */     for (Iterator i$ = s.levelupids.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */       
/*  50 */       SGangSkillBagLevelUpCfg cfg = SGangSkillBagLevelUpCfg.get(id);
/*  51 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/*  55 */         if (cfg.skilllevel == skillLevel)
/*     */         {
/*  57 */           return cfg;
/*     */         }
/*     */       }
/*     */     }
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   static int getSkillLevel(long roleid, int skillid)
/*     */   {
/*  66 */     RoleGangSkill gangSkill = Role2gangskill.select(Long.valueOf(roleid));
/*  67 */     if (gangSkill == null)
/*     */     {
/*  69 */       return -1;
/*     */     }
/*  71 */     Integer level = (Integer)gangSkill.getGangskillbagmap().get(Integer.valueOf(skillid));
/*  72 */     if (level == null)
/*     */     {
/*  74 */       return -1;
/*     */     }
/*  76 */     return level.intValue();
/*     */   }
/*     */   
/*     */   static Set<Integer> getAllSkillids()
/*     */   {
/*  81 */     return new HashSet(SGangSkillBag.getAll().keySet());
/*     */   }
/*     */   
/*     */   static void synGangSkill(long roleid)
/*     */   {
/*  86 */     SSyncGangSkillBagInfo s = new SSyncGangSkillBagInfo();
/*     */     
/*  88 */     RoleGangSkill gangSkill = Role2gangskill.select(Long.valueOf(roleid));
/*  89 */     Iterator i$; if (gangSkill != null)
/*     */     {
/*  91 */       for (i$ = gangSkill.getGangskillbagmap().keySet().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */         
/*  93 */         GangSkillBagInfo g = new GangSkillBagInfo();
/*  94 */         g.skillid = skillid;
/*  95 */         g.level = ((Integer)gangSkill.getGangskillbagmap().get(Integer.valueOf(skillid))).intValue();
/*  96 */         s.skills.add(g);
/*     */       }
/*     */     }
/*  99 */     OnlineManager.getInstance().send(roleid, s);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean addGangSkill(long roleid, int skillid, int level)
/*     */   {
/* 105 */     RoleGangSkill gangSkill = Role2gangskill.get(Long.valueOf(roleid));
/* 106 */     if (gangSkill == null)
/*     */     {
/* 108 */       gangSkill = Pod.newRoleGangSkill();
/* 109 */       Role2gangskill.insert(Long.valueOf(roleid), gangSkill);
/*     */     }
/* 111 */     if (gangSkill.getGangskillbagmap().containsKey(Integer.valueOf(skillid)))
/*     */     {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     gangSkill.getGangskillbagmap().put(Integer.valueOf(skillid), Integer.valueOf(level));
/* 117 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean hasGangSkill(long roleid)
/*     */   {
/* 123 */     RoleGangSkill gangSkill = Role2gangskill.get(Long.valueOf(roleid));
/* 124 */     if (gangSkill == null)
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     return gangSkill.getGangskillbagmap().size() > 0;
/*     */   }
/*     */   
/*     */   static boolean setGangSkillLevel(long roleid, int skillid, int level)
/*     */   {
/* 133 */     RoleGangSkill gangSkill = Role2gangskill.get(Long.valueOf(roleid));
/* 134 */     if (gangSkill == null)
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     if (!gangSkill.getGangskillbagmap().containsKey(Integer.valueOf(skillid)))
/*     */     {
/* 140 */       return false;
/*     */     }
/* 142 */     gangSkill.getGangskillbagmap().put(Integer.valueOf(skillid), Integer.valueOf(level));
/* 143 */     return true;
/*     */   }
/*     */   
/*     */   static Set<Integer> getGangSkillids(long roleid)
/*     */   {
/* 148 */     RoleGangSkill gangSkill = Role2gangskill.select(Long.valueOf(roleid));
/* 149 */     if (gangSkill == null)
/*     */     {
/* 151 */       return new HashSet();
/*     */     }
/*     */     
/* 154 */     return gangSkill.getGangskillbagmap().keySet();
/*     */   }
/*     */   
/*     */ 
/*     */   static Map<Integer, Integer> getGangSkillid2Level(long roleid)
/*     */   {
/* 160 */     RoleGangSkill gangSkill = Role2gangskill.select(Long.valueOf(roleid));
/* 161 */     if (gangSkill == null)
/*     */     {
/* 163 */       return new HashMap();
/*     */     }
/*     */     
/* 166 */     return gangSkill.getGangskillbagmap();
/*     */   }
/*     */   
/*     */ 
/*     */   static void sendErrorInfo(long roleid, int errorcode)
/*     */   {
/* 172 */     SGangSkillError error = new SGangSkillError(errorcode);
/* 173 */     OnlineManager.getInstance().sendAtOnce(roleid, error);
/*     */   }
/*     */   
/*     */ 
/*     */   static void triggerGankSkillChangedEvent(long roleid)
/*     */   {
/* 179 */     TriggerEventsManger.getInstance().triggerEvent(new GangSkillChanged(), new GangSkillArg(roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void tlogGangSkillLevelUp(long roleid, int skillid, int beforelevel, int afterlevel)
/*     */   {
/* 186 */     String logname = "Mentallevelup";
/*     */     
/* 188 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 189 */     String userid = RoleInterface.getUserId(roleid);
/* 190 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 192 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(skillid), Integer.valueOf(beforelevel), Integer.valueOf(afterlevel) });
/*     */     
/*     */ 
/* 195 */     TLogManager.getInstance().addLog(roleid, logname, logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isGangSkillSwitchOpenForRole(long roleid)
/*     */   {
/* 207 */     if (!OpenInterface.getOpenStatus(28))
/*     */     {
/* 209 */       return false;
/*     */     }
/* 211 */     if (OpenInterface.isBanPlay(roleid, 28))
/*     */     {
/* 213 */       OpenInterface.sendBanPlayMsg(roleid, 28);
/* 214 */       return false;
/*     */     }
/* 216 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanOperateGangSkill(long roleid)
/*     */   {
/* 228 */     return RoleStatusInterface.checkCanSetStatus(roleid, 142, true);
/*     */   }
/*     */   
/*     */   static int getGangSkillScore(long roleid, boolean holdLock)
/*     */   {
/* 233 */     RoleGangSkill xGangSkill = null;
/* 234 */     if (holdLock)
/*     */     {
/* 236 */       xGangSkill = Role2gangskill.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 240 */       xGangSkill = Role2gangskill.select(Long.valueOf(roleid));
/*     */     }
/* 242 */     if (xGangSkill == null)
/*     */     {
/* 244 */       return 0;
/*     */     }
/*     */     
/* 247 */     int num = 0;
/* 248 */     for (Map.Entry<Integer, Integer> xEntry : xGangSkill.getGangskillbagmap().entrySet())
/*     */     {
/* 250 */       SGangSkillScoreCfg cfg = SGangSkillScoreCfg.get(((Integer)xEntry.getKey()).intValue());
/* 251 */       if (cfg != null)
/*     */       {
/*     */ 
/*     */ 
/* 255 */         Integer score = (Integer)cfg.skillLevelScore.get(xEntry.getValue());
/* 256 */         if (score != null)
/*     */         {
/*     */ 
/*     */ 
/* 260 */           num += score.intValue(); }
/*     */       } }
/* 262 */     return num;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\main\GangSkillManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */