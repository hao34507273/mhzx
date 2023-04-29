/*     */ package mzm.gsp.teamplatform.match;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.JoinTeamByMatchHandler;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MJoinTeamOnNewGuy
/*     */   implements JoinTeamByMatchHandler
/*     */ {
/*     */   static volatile MJoinTeamOnNewGuy instance;
/*     */   
/*     */   public static MJoinTeamOnNewGuy getInstance()
/*     */   {
/*  24 */     if (instance == null)
/*     */     {
/*  26 */       synchronized (MJoinTeamOnNewGuy.class)
/*     */       {
/*  28 */         if (instance == null)
/*     */         {
/*  30 */           instance = new MJoinTeamOnNewGuy();
/*     */         }
/*     */       }
/*     */     }
/*  34 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canJoinTeam(long roleId, TeamInfo teamInfo)
/*     */   {
/*  40 */     if (teamInfo == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     long leaderId = teamInfo.getLeaderId();
/*  45 */     RoleMatchInfo leaderMatchInfo = new RoleMatchInfo(leaderId, false);
/*  46 */     if (!leaderMatchInfo.inMatchQueue())
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!leaderMatchInfo.isTeamMatch())
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!leaderMatchInfo.isTakeNew())
/*     */     {
/*  56 */       return true;
/*     */     }
/*     */     
/*  59 */     List<Integer> levelRange = getNewGuyLevelRange(leaderId, leaderMatchInfo.getRoleMatchActivityCfg());
/*  60 */     if ((levelRange == null) || (levelRange.size() != 2))
/*     */     {
/*  62 */       return false;
/*     */     }
/*  64 */     return canJoinTeam(roleId, teamInfo, leaderMatchInfo, levelRange);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Integer> getNewGuyLevelRange(long leaderId, RoleActivityCfg cfg)
/*     */   {
/*  76 */     return TeamMatchInterface.getRoleNewGuyRange(cfg.getMomCfgId(), cfg.getIndex(), leaderId);
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
/*     */   private boolean canJoinTeam(long roleId, TeamInfo teamInfo, RoleMatchInfo leaderMatchInfo, List<Integer> levelRange)
/*     */   {
/*  90 */     if (isNewGuyEnough(teamInfo, levelRange, leaderMatchInfo.getTakeNewGuyNum()))
/*     */     {
/*  92 */       return !isRoleNewGuy(roleId, levelRange);
/*     */     }
/*  94 */     if (leaderMatchInfo.isMatchNewGuyIng())
/*     */     {
/*  96 */       return isRoleNewGuy(roleId, levelRange);
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isRoleNewGuy(long roleId, List<Integer> levelRange)
/*     */   {
/* 110 */     return isInLevelRange(levelRange, RoleInterface.getLevel(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isNewGuyEnough(TeamInfo teamInfo, List<Integer> levelRange, int takeNewNum)
/*     */   {
/* 122 */     int teamNewGuyNum = getTeamNewGuyNum(teamInfo, levelRange);
/* 123 */     if (teamNewGuyNum < 0)
/*     */     {
/* 125 */       return true;
/*     */     }
/* 127 */     return teamNewGuyNum >= takeNewNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getTeamNewGuyNum(TeamInfo teamInfo, List<Integer> levelRange)
/*     */   {
/* 139 */     return getTeamNewGuyIds(teamInfo, levelRange).size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getTeamNewGuyIds(TeamInfo teamInfo, List<Integer> levelRange)
/*     */   {
/* 151 */     List<Long> newGuyIds = new ArrayList();
/* 152 */     long leaderId = teamInfo.getLeaderId();
/* 153 */     for (Iterator i$ = teamInfo.getTeamMemberList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 155 */       if ((roleId != leaderId) && (isRoleNewGuy(roleId, levelRange)))
/*     */       {
/*     */ 
/*     */ 
/* 159 */         newGuyIds.add(Long.valueOf(roleId)); }
/*     */     }
/* 161 */     return newGuyIds;
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
/*     */   boolean isInLevelRange(List<Integer> levelRange, int level)
/*     */   {
/* 175 */     if (level < ((Integer)levelRange.get(0)).intValue())
/*     */     {
/* 177 */       return false;
/*     */     }
/* 179 */     if (level > ((Integer)levelRange.get(1)).intValue())
/*     */     {
/* 181 */       return false;
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void afterJoinTeam(long roleId, TeamInfo teamInfo)
/*     */   {
/* 194 */     long leaderId = teamInfo.getLeaderId();
/* 195 */     RoleMatchInfo leaderMatchInfo = new RoleMatchInfo(leaderId, false);
/* 196 */     if (!leaderMatchInfo.inMatchQueue())
/*     */     {
/* 198 */       return;
/*     */     }
/* 200 */     if (!leaderMatchInfo.isTakeNew())
/*     */     {
/* 202 */       return;
/*     */     }
/* 204 */     if (!leaderMatchInfo.isMatchNewGuyIng())
/*     */     {
/* 206 */       return;
/*     */     }
/*     */     
/* 209 */     List<Long> newGuyIds = getNewGuysInTeam(leaderId, leaderMatchInfo, teamInfo);
/* 210 */     if (newGuyIds.size() == leaderMatchInfo.getTakeNewGuyNum())
/*     */     {
/* 212 */       if (!newGuyIds.contains(Long.valueOf(roleId)))
/*     */       {
/* 214 */         return;
/*     */       }
/*     */       
/* 217 */       MatchNRTimeTaskManager.getInstance().addTask(new BeNormalMatch(leaderId, 2));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getNewGuysInTeam(long leaderId, RoleMatchInfo roleMatchInfo, TeamInfo teamInfo)
/*     */   {
/* 233 */     List<Integer> levelRange = getNewGuyLevelRange(leaderId, roleMatchInfo.getRoleMatchActivityCfg());
/* 234 */     if ((levelRange == null) || (levelRange.size() != 2))
/*     */     {
/* 236 */       return new ArrayList();
/*     */     }
/* 238 */     return getTeamNewGuyIds(teamInfo, levelRange);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\MJoinTeamOnNewGuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */