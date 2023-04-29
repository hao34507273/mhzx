/*     */ package mzm.gsp.team.heart;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.confbean.HeartConsts;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HeartInfo;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2heart;
/*     */ import xtable.Role2task;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PJoinTeam
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long teamId;
/*     */   private long curTime;
/*     */   
/*     */   public PJoinTeam(long teamId)
/*     */   {
/*  32 */     this.teamId = teamId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!HeartManager.isHeartModuleOpen())
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(this.teamId, false);
/*  49 */     if ((teamInfo == null) || (!teamInfo.isTeamExist()))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!teamInfo.isFull())
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     List<Long> members = teamInfo.getTeamMemberList();
/*     */     
/*     */ 
/*  61 */     getUserLock(members);
/*     */     
/*  63 */     Lockeys.lock(Role2task.getTable(), members);
/*     */     
/*  65 */     teamInfo = TeamInterface.getTeamInfo(teamInfo.getTeamId(), true);
/*     */     
/*  67 */     if (!isLockEqual(teamInfo, members))
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[heart]PonJoinTeam.processImp@ check lock fail!", new Object[0]));
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     List<Long> nmMembers = teamInfo.getTeamNormalList();
/*  74 */     if (nmMembers.size() < getTriggerGuyMin())
/*     */     {
/*  76 */       return false;
/*     */     }
/*  78 */     this.curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  80 */     Map<Integer, Long> ran2roleId = new HashMap();
/*     */     
/*  82 */     for (Iterator i$ = nmMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  84 */       if (HeartManager.getTriggerTimeAndCheck(roleId, this.curTime) < getDayTriggerTime())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  89 */         if (!ranHeart(roleId, ran2roleId))
/*     */         {
/*  91 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*  95 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean ranHeart(long roleId, Map<Integer, Long> ran2roleId)
/*     */   {
/* 107 */     int seed = HeartManager.getRanSeedByLv(RoleInterface.getLevel(roleId));
/* 108 */     if (seed <= 0)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[heart]PonJoinTeam.ranHeart@ get seed error!|roleId=%d|lv=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)) }));
/*     */       
/*     */ 
/* 113 */       return false;
/*     */     }
/* 115 */     int ran = Xdb.random().nextInt(seed);
/* 116 */     Long orgRoleId = (Long)ran2roleId.get(Integer.valueOf(ran));
/* 117 */     if (orgRoleId == null)
/*     */     {
/* 119 */       ran2roleId.put(Integer.valueOf(ran), Long.valueOf(roleId));
/* 120 */       return true;
/*     */     }
/* 122 */     getMatch(roleId, orgRoleId.longValue());
/* 123 */     ran2roleId.remove(Integer.valueOf(ran));
/* 124 */     GameServer.logger().info(String.format("[heart]PonJoinTeam.ranHeart@ trigger heart!|roleId1=%d|roleId2=%d", new Object[] { orgRoleId, Long.valueOf(roleId) }));
/*     */     
/* 126 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void getMatch(long roleId1, long roleId2)
/*     */   {
/* 137 */     addTriggerTime(roleId1, roleId2);
/* 138 */     addTriggerTime(roleId2, roleId1);
/* 139 */     HeartManager.sendBothSGetHeart(roleId1, roleId2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addTriggerTime(long roleId, long otherRoleId)
/*     */   {
/* 149 */     HeartInfo xHeartInfo = Role2heart.get(Long.valueOf(roleId));
/* 150 */     int oldTime = xHeartInfo.getTriggertime();
/*     */     
/* 152 */     if (oldTime >= getDayTriggerTime())
/*     */     {
/*     */ 
/* 155 */       return;
/*     */     }
/* 157 */     xHeartInfo.setTriggertime(oldTime + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, String> getUserLock(List<Long> members)
/*     */   {
/* 167 */     Map<Long, String> roleidToUserid = new HashMap();
/* 168 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 170 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/* 172 */     Lockeys.lock(User.getTable(), roleidToUserid.values());
/* 173 */     return roleidToUserid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isLockEqual(TeamInfo teamInfo, List<Long> members)
/*     */   {
/* 185 */     if (teamInfo == null)
/*     */     {
/* 187 */       return false;
/*     */     }
/* 189 */     if (!teamInfo.isFull())
/*     */     {
/* 191 */       return false;
/*     */     }
/* 193 */     List<Long> tmpMembers = teamInfo.getTeamMemberList();
/* 194 */     if ((tmpMembers.size() != members.size()) || (!tmpMembers.containsAll(members)))
/*     */     {
/* 196 */       return false;
/*     */     }
/* 198 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getTriggerGuyMin()
/*     */   {
/* 208 */     return 2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getDayTriggerTime()
/*     */   {
/* 218 */     return HeartConsts.getInstance().RAN_MAX_PER_DAY;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\heart\PJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */