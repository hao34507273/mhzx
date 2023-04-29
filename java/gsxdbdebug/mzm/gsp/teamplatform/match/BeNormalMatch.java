/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.TeamPlatformConsts;
/*     */ import mzm.gsp.teamplatform.SChangeToNormalMatch;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MatchActivityCfg;
/*     */ import xbean.MatchQueue;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BeNormalMatch
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int type;
/*     */   
/*     */   public BeNormalMatch(long roleId, int type)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  36 */     MatchQueue matchQueue = TeamMatchMananger.getMatchQueue(true);
/*  37 */     if (matchQueue == null)
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     RoleMatchInfo matchInfo = new RoleMatchInfo(this.roleId, true);
/*  42 */     if (!matchInfo.inMatchQueue())
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!matchInfo.isMatchNewGuyIng())
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!tryMatchNormal(matchQueue, matchInfo))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     matchNormalNotice();
/*     */     
/*  59 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean tryMatchNormal(MatchQueue matchQueue, RoleMatchInfo matchInfo)
/*     */   {
/*  71 */     LevelArg levelArg = getLevelArg();
/*  72 */     if (levelArg == null)
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (!TeamQueueManager.onLeaderNeedLevelChange(this.roleId, levelArg.levelLow, levelArg.levelHigh, matchQueue, matchInfo.getXMatchInfo()))
/*     */     {
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!initNextExpand(matchInfo, levelArg))
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void matchNormalNotice()
/*     */   {
/*  95 */     switch (this.type)
/*     */     {
/*     */     case 1: 
/*  98 */       OnlineManager.getInstance().send(this.roleId, new SChangeToNormalMatch(1));
/*  99 */       break;
/*     */     case 2: 
/* 101 */       OnlineManager.getInstance().send(this.roleId, new SChangeToNormalMatch(2));
/* 102 */       break;
/*     */     }
/*     */     
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
/*     */   private boolean initNextExpand(RoleMatchInfo matchInfo, LevelArg levelArg)
/*     */   {
/* 118 */     NeedExpandLvSession needExpandLvSession = new NeedExpandLvSession(TeamPlatformConsts.getInstance().EXPAND_LEVEL_SEC, this.roleId, levelArg.levelLowNext, levelArg.levelHighNext, 1);
/*     */     
/*     */ 
/*     */ 
/* 122 */     if (needExpandLvSession.getSessionId() <= 0L)
/*     */     {
/* 124 */       return false;
/*     */     }
/* 126 */     matchInfo.getXMatchInfo().setExpandlvsessionid(needExpandLvSession.getSessionId());
/* 127 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   LevelArg getLevelArg()
/*     */   {
/* 137 */     int leaderLevel = RoleInterface.getLevel(this.roleId);
/* 138 */     int level_high = 0;
/* 139 */     int level_low = 0;
/*     */     
/* 141 */     int nextLevel_high = 150;
/* 142 */     int nextLevel_low = 1;
/*     */     
/* 144 */     TeamPlatformConsts consts = TeamPlatformConsts.getInstance();
/* 145 */     switch (consts.SLECET_NEW__CHANGE_LEVEL)
/*     */     {
/*     */     case 0: 
/* 148 */       level_high = leaderLevel + consts.LEVEL_LITTLE_TOP;
/* 149 */       level_low = leaderLevel + consts.LEVEL_LITTLE_FLOOR;
/*     */       
/* 151 */       nextLevel_high = leaderLevel + consts.LEVEL_BIG_TOP;
/* 152 */       nextLevel_low = leaderLevel + consts.LEVEL_BIG_FLOOR;
/*     */       
/* 154 */       break;
/*     */     case 1: 
/* 156 */       level_high = leaderLevel + consts.LEVEL_BIG_TOP;
/* 157 */       level_low = leaderLevel + consts.LEVEL_BIG_FLOOR;
/* 158 */       break;
/*     */     
/*     */     default: 
/* 161 */       return null;
/*     */     }
/* 163 */     LevelArg levelArg = new LevelArg(level_low, level_high, nextLevel_low, nextLevel_high);
/* 164 */     return levelArg.check() ? levelArg : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   class LevelArg
/*     */   {
/*     */     int levelLow;
/*     */     
/*     */     int levelHigh;
/*     */     
/*     */     int levelLowNext;
/*     */     
/*     */     int levelHighNext;
/*     */     
/*     */ 
/*     */     public LevelArg(int levelLow, int levelHigh, int levelLowNext, int levelHighNext)
/*     */     {
/* 182 */       this.levelLow = levelLow;
/* 183 */       this.levelHigh = levelHigh;
/* 184 */       this.levelLowNext = levelLowNext;
/* 185 */       this.levelHighNext = levelHighNext;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean check()
/*     */     {
/* 195 */       if (this.levelLow > this.levelHigh)
/*     */       {
/* 197 */         return false;
/*     */       }
/* 199 */       if (this.levelLowNext > this.levelHighNext)
/*     */       {
/* 201 */         return false;
/*     */       }
/* 203 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\BeNormalMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */