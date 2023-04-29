/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCJoinBanquet
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long masterId;
/*     */   
/*     */   public PCJoinBanquet(long roleId, long masterId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.masterId = masterId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     NoneRealTimeTaskManager.getInstance().addTask(new PJoinBanquet(null));
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   private class PJoinBanquet extends LogicProcedure
/*     */   {
/*     */     private PJoinBanquet() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  47 */       if (!BanquestManager.isBanquestOpen(PCJoinBanquet.this.roleId, true))
/*     */       {
/*  49 */         return false;
/*     */       }
/*  51 */       int guyNum = 0;
/*     */       
/*  53 */       long homelandWorldId = BanquestManager.getHomeLandWorldId(PCJoinBanquet.this.masterId);
/*  54 */       if (homelandWorldId > 0L)
/*     */       {
/*  56 */         guyNum = MapInterface.getRoleNumInWorld(homelandWorldId);
/*  57 */         if ((BanquestManager.needLimitGuyNum()) && (guyNum >= BanquestManager.getBanqustGuyUpLimit()))
/*     */         {
/*  59 */           GameServer.logger().info(String.format("[banquset]PJoinBanquet.processImp@ up to guy num max!|masterId=%d|roleId=%d|guyNum=%d", new Object[] { Long.valueOf(PCJoinBanquet.this.masterId), Long.valueOf(PCJoinBanquet.this.roleId), Integer.valueOf(guyNum) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  64 */           return false;
/*     */         }
/*     */       }
/*  67 */       TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(PCJoinBanquet.this.roleId);
/*  68 */       if ((teamInfo == null) || (!teamInfo.isNormalState(PCJoinBanquet.this.roleId)))
/*     */       {
/*  70 */         return singleJoinBanquest();
/*     */       }
/*     */       
/*  73 */       if (!teamInfo.isLeader(PCJoinBanquet.this.roleId))
/*     */       {
/*  75 */         GameServer.logger().error(String.format("[banquest]PJoinBanquet.processImp@ not leader, cannot do leave action!|roleId=%d|masterId=%d", new Object[] { Long.valueOf(PCJoinBanquet.this.roleId), Long.valueOf(PCJoinBanquet.this.masterId) }));
/*     */         
/*     */ 
/*     */ 
/*  79 */         return false;
/*     */       }
/*  81 */       long teamId = teamInfo.getTeamId();
/*  82 */       List<Long> normalMembers = teamInfo.getTeamNormalList();
/*     */       
/*  84 */       lock(Basic.getTable(), normalMembers);
/*     */       
/*  86 */       teamInfo = TeamInterface.getTeamInfo(teamId, true);
/*     */       
/*  88 */       if (!checkLock(teamInfo, normalMembers))
/*     */       {
/*  90 */         GameServer.logger().error(String.format("[banquest]PJoinBanquet.processImp@ team member state changed!|roleId=%d|masterId=%d", new Object[] { Long.valueOf(PCJoinBanquet.this.roleId), Long.valueOf(PCJoinBanquet.this.masterId) }));
/*     */         
/*     */ 
/*  93 */         return false;
/*     */       }
/*  95 */       int teamGuyNum = teamInfo.getTeamNormalMembersNum();
/*  96 */       if ((BanquestManager.needLimitGuyNum()) && (guyNum + teamGuyNum > BanquestManager.getBanqustGuyUpLimit()))
/*     */       {
/*  98 */         GameServer.logger().info(String.format("[banquset]PJoinBanquet.processImp@ up to guy num max!|masterId=%d|roleId=%d|guyNum=%d|teamGuyNum=%d", new Object[] { Long.valueOf(PCJoinBanquet.this.masterId), Long.valueOf(PCJoinBanquet.this.roleId), Integer.valueOf(guyNum), Integer.valueOf(teamGuyNum) }));
/*     */         
/*     */ 
/*     */ 
/* 102 */         return false;
/*     */       }
/* 104 */       if (!isRoleLvOK(normalMembers))
/*     */       {
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       HomelandInterface.transferHome(PCJoinBanquet.this.masterId, normalMembers);
/* 110 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private boolean singleJoinBanquest()
/*     */     {
/* 116 */       if (!isRoleLvOK(Arrays.asList(new Long[] { Long.valueOf(PCJoinBanquet.this.roleId) })))
/*     */       {
/* 118 */         return false;
/*     */       }
/* 120 */       HomelandInterface.transferHome(PCJoinBanquet.this.masterId, Arrays.asList(new Long[] { Long.valueOf(PCJoinBanquet.this.roleId) }));
/* 121 */       return true;
/*     */     }
/*     */     
/*     */     boolean isRoleLvOK(List<Long> roleIds)
/*     */     {
/* 126 */       if ((roleIds == null) || (roleIds.size() == 0))
/*     */       {
/* 128 */         return false;
/*     */       }
/* 130 */       for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 132 */         int roleLv = RoleInterface.getLevel(roleId);
/* 133 */         if (roleLv < BanquestManager.getJoinMinRoleLv())
/*     */         {
/*     */ 
/*     */ 
/* 137 */           GameServer.logger().info(String.format("[banquset]PJoinBanquet.canJoinBanquest@ role level not enough to join banquest!|masterId=%d|roleId=%d|roleLv=%d", new Object[] { Long.valueOf(PCJoinBanquet.this.masterId), Long.valueOf(roleId), Integer.valueOf(roleLv) }));
/*     */           
/*     */ 
/*     */ 
/* 141 */           if (roleIds.size() > 1)
/*     */           {
/* 143 */             String name = RoleInterface.getName(roleId);
/* 144 */             BanquestManager.sendBanquestNotice(roleIds, false, 8, new String[] { name, BanquestManager.getJoinMinRoleLv() + "" });
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 149 */             BanquestManager.sendBanquestNotice(roleIds, false, 7, new String[] { BanquestManager.getJoinMinRoleLv() + "" });
/*     */           }
/*     */           
/* 152 */           return false;
/*     */         } }
/* 154 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean checkLock(TeamInfo teamInfo, List<Long> normalMembers)
/*     */     {
/* 166 */       if (teamInfo == null)
/*     */       {
/* 168 */         return false;
/*     */       }
/* 170 */       List<Long> tempMembers = teamInfo.getTeamNormalList();
/* 171 */       if ((tempMembers.size() != normalMembers.size()) || (!tempMembers.containsAll(normalMembers)))
/*     */       {
/* 173 */         return false;
/*     */       }
/* 175 */       if (!teamInfo.isLeader(PCJoinBanquet.this.roleId))
/*     */       {
/* 177 */         return false;
/*     */       }
/* 179 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PCJoinBanquet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */