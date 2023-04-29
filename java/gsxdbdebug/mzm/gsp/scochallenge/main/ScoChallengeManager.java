/*     */ package mzm.gsp.scochallenge.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*     */ import mzm.gsp.activity.confbean.SSchoolChallengeModifyCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.SchoolChallenge;
/*     */ import xtable.Role2schoolchallenge;
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScoChallengeManager
/*     */ {
/*  21 */   static final Logger logger = Logger.getLogger("ScoChallengeManager");
/*     */   
/*     */   static void init()
/*     */   {
/*     */     try
/*     */     {
/*  27 */       ActivityInterface.registerActivityByLogicType(15, new ScoChallengeActivityInit());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  31 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getModifyId(int ringcount)
/*     */   {
/*  44 */     SSchoolChallengeModifyCfg s = SSchoolChallengeModifyCfg.get(ringcount);
/*  45 */     if (s == null)
/*     */     {
/*  47 */       return -1;
/*     */     }
/*  49 */     return s.modifyId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCircleRewardId(int c)
/*     */   {
/*  61 */     if (c >= SSchoolChallengeCfgConsts.getInstance().circleRewardids.size())
/*     */     {
/*  63 */       return -1;
/*     */     }
/*  65 */     return ((Integer)SSchoolChallengeCfgConsts.getInstance().circleRewardids.get(c)).intValue();
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
/*     */   static boolean addScoRingTask(long roleid, int taskid)
/*     */   {
/*  78 */     SchoolChallenge sco = Role2schoolchallenge.get(Long.valueOf(roleid));
/*  79 */     if (sco == null)
/*     */     {
/*  81 */       sco = Pod.newSchoolChallenge();
/*  82 */       Role2schoolchallenge.insert(Long.valueOf(roleid), sco);
/*     */     }
/*     */     
/*  85 */     return sco.getTaskids().add(Integer.valueOf(taskid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addAwardCircleCount(long roleid)
/*     */   {
/*  95 */     SchoolChallenge sco = Role2schoolchallenge.get(Long.valueOf(roleid));
/*  96 */     if (sco == null)
/*     */     {
/*  98 */       sco = Pod.newSchoolChallenge();
/*  99 */       sco.setAwardcirclecount(0);
/* 100 */       Role2schoolchallenge.insert(Long.valueOf(roleid), sco);
/*     */     }
/* 102 */     sco.setAwardcirclecount(sco.getAwardcirclecount() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAwardCircleCount(long roleid)
/*     */   {
/* 114 */     SchoolChallenge sco = Role2schoolchallenge.get(Long.valueOf(roleid));
/* 115 */     if (sco == null)
/*     */     {
/* 117 */       return 0;
/*     */     }
/*     */     
/* 120 */     return sco.getAwardcirclecount();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getTaskids(long roleid)
/*     */   {
/* 131 */     SchoolChallenge sco = Role2schoolchallenge.get(Long.valueOf(roleid));
/* 132 */     if (sco == null)
/*     */     {
/* 134 */       return new ArrayList();
/*     */     }
/*     */     
/* 137 */     return sco.getTaskids();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean clearScoRingTask(long roleid)
/*     */   {
/* 148 */     SchoolChallenge sco = Role2schoolchallenge.get(Long.valueOf(roleid));
/* 149 */     if (sco == null)
/*     */     {
/* 151 */       return true;
/*     */     }
/* 153 */     sco.getTaskids().clear();
/* 154 */     return true;
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
/*     */   static boolean moveScoChallenage(long roleid, long newRoleId)
/*     */   {
/* 167 */     SchoolChallenge sco = Role2schoolchallenge.select(Long.valueOf(roleid));
/* 168 */     if (sco == null)
/*     */     {
/* 170 */       return false;
/*     */     }
/* 172 */     SchoolChallenge newSco = Role2schoolchallenge.get(Long.valueOf(newRoleId));
/* 173 */     if (newSco == null)
/*     */     {
/* 175 */       newSco = Pod.newSchoolChallenge();
/* 176 */       Role2schoolchallenge.insert(Long.valueOf(newRoleId), newSco);
/*     */     }
/*     */     
/* 179 */     newSco.getTaskids().clear();
/* 180 */     newSco.getTaskids().addAll(sco.getTaskids());
/* 181 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSocSwitchOpenForRole(long leaderRoleid, List<Long> roleids)
/*     */   {
/* 206 */     if (!OpenInterface.getOpenStatus(10))
/*     */     {
/* 208 */       OpenInterface.sendCloseProtocol(leaderRoleid, 10, null);
/*     */       
/* 210 */       return false;
/*     */     }
/* 212 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 214 */       if (OpenInterface.isBanPlay(roleid, 10))
/*     */       {
/*     */ 
/* 217 */         OpenInterface.sendBanPlayMsg(leaderRoleid, roleid, RoleInterface.getName(roleid), 10);
/*     */         
/*     */ 
/* 220 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 224 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSocSwitchOpenForRole(long roleid)
/*     */   {
/* 236 */     return isSocSwitchOpenForRole(roleid, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSocSwitchOpenForRole(long roleid, boolean isSendTip)
/*     */   {
/* 248 */     if (!OpenInterface.getOpenStatus(10))
/*     */     {
/* 250 */       if (isSendTip)
/*     */       {
/* 252 */         OpenInterface.sendCloseProtocol(roleid, 10, null);
/*     */       }
/* 254 */       return false;
/*     */     }
/*     */     
/* 257 */     if (OpenInterface.isBanPlay(roleid, 10))
/*     */     {
/* 259 */       if (isSendTip)
/*     */       {
/* 261 */         OpenInterface.sendBanPlayMsg(roleid, 10);
/*     */       }
/* 263 */       return false;
/*     */     }
/*     */     
/* 266 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanJoinScoActivity(List<Long> roleids)
/*     */   {
/* 278 */     return RoleStatusInterface.checkCansetStatus(roleids, 135, true);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\ScoChallengeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */