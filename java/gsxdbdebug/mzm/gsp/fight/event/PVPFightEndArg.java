/*     */ package mzm.gsp.fight.event;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.main.FightContext;
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
/*     */ public class PVPFightEndArg
/*     */   extends FightEndArg
/*     */ {
/*     */   public final long fightid;
/*     */   public final FightContext context;
/*     */   public final boolean isActiveWin;
/*     */   public final int timeMills;
/*     */   public final int fightReason;
/*     */   public final int fightCfgType;
/*     */   public final int activeDeadTimes;
/*     */   public final int passiveDeadTimes;
/*     */   public final int round;
/*     */   public final long startTime;
/*     */   public final int fightEndReason;
/*     */   public final int actionTotalCount;
/*     */   public final int actionMaxCountRound;
/*  38 */   public final Set<Long> activeAlivedRoles = new HashSet();
/*  39 */   public final Set<Long> activeDeadRoles = new HashSet();
/*  40 */   public final Set<Long> activeEscapedRoles = new HashSet();
/*  41 */   public final List<Long> activeRoleList = new ArrayList();
/*     */   
/*  43 */   public final Set<Long> passiveAlivedRoles = new HashSet();
/*  44 */   public final Set<Long> passiveDeadRoles = new HashSet();
/*  45 */   public final Set<Long> passiveEscapedRoles = new HashSet();
/*  46 */   public final List<Long> passiveRoleList = new ArrayList();
/*     */   
/*     */ 
/*  49 */   public final Map<Long, List<Integer>> fellowers = new HashMap();
/*     */   
/*  51 */   public final Map<Long, List<Long>> rolePetMap = new HashMap();
/*     */   
/*  53 */   public final Map<Long, List<Long>> roleChildrenMap = new HashMap();
/*     */   
/*  55 */   public final Set<Long> deadChildrens = new HashSet();
/*     */   
/*     */ 
/*     */   public final boolean isForceEnd;
/*     */   
/*     */ 
/*     */   public final long recordid;
/*     */   
/*     */ 
/*     */   public PVPFightEndArg(long fightid, int fightCfgType, int fightReason, FightContext context, boolean isActiveWin, int timeMills, int activeDeadTimes, int passiveDeadTimes, int round, long startTime, int fightEndReason, int actionTotalCount, int actionMaxCountRound, boolean isForceEnd, long recordid)
/*     */   {
/*  66 */     this.fightid = fightid;
/*  67 */     this.context = context;
/*  68 */     this.isActiveWin = isActiveWin;
/*  69 */     this.timeMills = timeMills;
/*  70 */     this.fightCfgType = fightCfgType;
/*  71 */     this.fightReason = fightReason;
/*  72 */     this.activeDeadTimes = activeDeadTimes;
/*  73 */     this.passiveDeadTimes = passiveDeadTimes;
/*  74 */     this.round = round;
/*  75 */     this.startTime = startTime;
/*  76 */     this.fightEndReason = fightEndReason;
/*  77 */     this.actionTotalCount = actionTotalCount;
/*  78 */     this.actionMaxCountRound = actionMaxCountRound;
/*  79 */     this.isForceEnd = isForceEnd;
/*  80 */     this.recordid = recordid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getAllRoles()
/*     */   {
/*  89 */     Set<Long> roles = new HashSet();
/*  90 */     roles.addAll(this.activeRoleList);
/*  91 */     roles.addAll(this.passiveRoleList);
/*  92 */     return roles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getWinnerList()
/*     */   {
/* 101 */     if (this.isActiveWin) {
/* 102 */       return this.activeRoleList;
/*     */     }
/* 104 */     return this.passiveRoleList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getLoserList()
/*     */   {
/* 114 */     if (this.isActiveWin) {
/* 115 */       return this.passiveRoleList;
/*     */     }
/* 117 */     return this.activeRoleList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getWinnerNotEscapeSet()
/*     */   {
/* 127 */     if (this.isActiveWin) {
/* 128 */       return getActiveNotEscapeSet();
/*     */     }
/* 130 */     return getPassiveNotEscapeSet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getWinnerNotEscapeList()
/*     */   {
/* 140 */     if (this.isActiveWin) {
/* 141 */       return getActiveNotEscapeList();
/*     */     }
/* 143 */     return getPassiveNotEscapeList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getLoserNotEscapeSet()
/*     */   {
/* 153 */     if (this.isActiveWin) {
/* 154 */       return getPassiveNotEscapeSet();
/*     */     }
/* 156 */     return getActiveNotEscapeSet();
/*     */   }
/*     */   
/*     */   public List<Long> getLoserNotEscapeList()
/*     */   {
/* 161 */     if (this.isActiveWin) {
/* 162 */       return getPassiveNotEscapeList();
/*     */     }
/* 164 */     return getActiveNotEscapeList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getActiveNotEscapeSet()
/*     */   {
/* 174 */     Set<Long> notEscapeSet = new HashSet();
/* 175 */     for (Iterator i$ = this.activeRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 176 */       if (!this.activeEscapedRoles.contains(Long.valueOf(roleid)))
/*     */       {
/*     */ 
/* 179 */         notEscapeSet.add(Long.valueOf(roleid)); }
/*     */     }
/* 181 */     return notEscapeSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getActiveNotEscapeList()
/*     */   {
/* 190 */     List<Long> notEscapeList = new ArrayList();
/* 191 */     for (Iterator i$ = this.activeRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 192 */       if (!this.activeEscapedRoles.contains(Long.valueOf(roleid)))
/*     */       {
/*     */ 
/* 195 */         notEscapeList.add(Long.valueOf(roleid)); }
/*     */     }
/* 197 */     return notEscapeList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Long> getPassiveNotEscapeSet()
/*     */   {
/* 206 */     Set<Long> notEscapeSet = new HashSet();
/* 207 */     for (Iterator i$ = this.passiveRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 208 */       if (!this.passiveEscapedRoles.contains(Long.valueOf(roleid)))
/*     */       {
/*     */ 
/* 211 */         notEscapeSet.add(Long.valueOf(roleid)); }
/*     */     }
/* 213 */     return notEscapeSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getPassiveNotEscapeList()
/*     */   {
/* 222 */     List<Long> notEscapeList = new ArrayList();
/* 223 */     for (Iterator i$ = this.passiveRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 224 */       if (!this.passiveEscapedRoles.contains(Long.valueOf(roleid)))
/*     */       {
/*     */ 
/* 227 */         notEscapeList.add(Long.valueOf(roleid)); }
/*     */     }
/* 229 */     return notEscapeList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVPFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */