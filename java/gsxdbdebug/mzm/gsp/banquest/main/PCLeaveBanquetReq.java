/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.homeland.confbean.SBanquetConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
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
/*     */ public class PCLeaveBanquetReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long masterId;
/*     */   
/*     */   public PCLeaveBanquetReq(long roleId, long masterId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.masterId = masterId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     NoneRealTimeTaskManager.getInstance().addTask(new LeaveBanquetReq(null));
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   private class LeaveBanquetReq
/*     */     extends LogicProcedure
/*     */   {
/*     */     private LeaveBanquetReq() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  45 */       if (!BanquestManager.isInMasterHome(PCLeaveBanquetReq.this.roleId, PCLeaveBanquetReq.this.masterId))
/*     */       {
/*  47 */         GameServer.logger().error(String.format("[banquest]PCLeaveBanquetReq.processImp@ not in master homeland!|roleId=%d|masterId=%d", new Object[] { Long.valueOf(PCLeaveBanquetReq.this.roleId), Long.valueOf(PCLeaveBanquetReq.this.masterId) }));
/*     */         
/*     */ 
/*  50 */         return false;
/*     */       }
/*  52 */       TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(PCLeaveBanquetReq.this.roleId);
/*  53 */       if ((teamInfo == null) || (!teamInfo.isNormalState(PCLeaveBanquetReq.this.roleId)))
/*     */       {
/*     */ 
/*  56 */         MapInterface.transferToScene(PCLeaveBanquetReq.this.roleId, SBanquetConsts.getInstance().TRANSFORM_MAP_ID);
/*  57 */         return true;
/*     */       }
/*     */       
/*  60 */       if (!teamInfo.isLeader(PCLeaveBanquetReq.this.roleId))
/*     */       {
/*  62 */         GameServer.logger().error(String.format("[banquest]PCLeaveBanquetReq.processImp@ not leader, cannot do leave action!|roleId=%d|masterId=%d", new Object[] { Long.valueOf(PCLeaveBanquetReq.this.roleId), Long.valueOf(PCLeaveBanquetReq.this.masterId) }));
/*     */         
/*     */ 
/*     */ 
/*  66 */         return false;
/*     */       }
/*  68 */       long teamId = teamInfo.getTeamId();
/*  69 */       List<Long> normalMembers = teamInfo.getTeamNormalList();
/*     */       
/*  71 */       lock(Basic.getTable(), normalMembers);
/*     */       
/*  73 */       teamInfo = TeamInterface.getTeamInfo(teamId, true);
/*     */       
/*  75 */       if (!PCLeaveBanquetReq.this.checkLock(teamInfo, normalMembers))
/*     */       {
/*  77 */         GameServer.logger().error(String.format("[banquest]PCLeaveBanquetReq.processImp@ team member state changed!|roleId=%d|masterId=%d", new Object[] { Long.valueOf(PCLeaveBanquetReq.this.roleId), Long.valueOf(PCLeaveBanquetReq.this.masterId) }));
/*     */         
/*     */ 
/*     */ 
/*  81 */         return false;
/*     */       }
/*     */       
/*  84 */       for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*     */         
/*  86 */         MapInterface.transferToScene(memberId, SBanquetConsts.getInstance().TRANSFORM_MAP_ID);
/*     */       }
/*  88 */       return true;
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
/*     */   private boolean checkLock(TeamInfo teamInfo, List<Long> normalMembers)
/*     */   {
/* 103 */     if (teamInfo == null)
/*     */     {
/* 105 */       return false;
/*     */     }
/* 107 */     List<Long> tempMembers = teamInfo.getTeamNormalList();
/* 108 */     if ((tempMembers.size() != normalMembers.size()) || (!tempMembers.containsAll(normalMembers)))
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/* 114 */       return false;
/*     */     }
/* 116 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PCLeaveBanquetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */