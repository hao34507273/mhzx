/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.indiana.SGetAttendIndianaNumSuccess;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class PCGetAttendIndianaNum extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   
/*     */   public PCGetAttendIndianaNum(long roleid, int activityCfgid, int turn)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*  33 */     this.turn = turn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  40 */     if (cfg == null)
/*     */     {
/*     */ 
/*  43 */       onFail(-3, null);
/*  44 */       return false;
/*     */     }
/*  46 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  47 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  50 */       onFail(-3, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if (!IndianaManager.isIndianaSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  56 */       onFail(-1, null);
/*  57 */       return false;
/*     */     }
/*  59 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1992, true))
/*     */     {
/*     */ 
/*  62 */       onFail(-2, null);
/*  63 */       return false;
/*     */     }
/*  65 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/*  66 */     long turnBeginTimestamp = IndianaManager.getTurnBeginTimestamp(this.activityCfgid, this.turn);
/*  67 */     long turnEndTimestamp = IndianaManager.getTurnEndTimestamp(this.activityCfgid, this.turn);
/*  68 */     if ((turnBeginTimestamp < 0L) || (turnEndTimestamp < 0L))
/*     */     {
/*     */ 
/*  71 */       onFail(-3, null);
/*  72 */       return false;
/*     */     }
/*  74 */     SGetAttendIndianaNumSuccess protocol = new SGetAttendIndianaNumSuccess();
/*  75 */     protocol.activity_cfg_id = this.activityCfgid;
/*  76 */     protocol.turn = this.turn;
/*  77 */     if (currTimeInMillis < turnBeginTimestamp)
/*     */     {
/*  79 */       for (int sortid = 1; sortid <= turnInfo.award_infos.size(); sortid++)
/*     */       {
/*  81 */         protocol.attend_nums.add(Integer.valueOf(0));
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  87 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  88 */       lock(Indiana_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  89 */       IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  90 */       if (xIndianaInfo == null)
/*     */       {
/*  92 */         xIndianaInfo = Pod.newIndianaInfo();
/*  93 */         Indiana_infos.insert(Long.valueOf(globalActivityCfgid), xIndianaInfo);
/*     */       }
/*  95 */       IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/*  96 */       if (xIndianaTurnInfo == null)
/*     */       {
/*  98 */         xIndianaTurnInfo = Pod.newIndianaTurnInfo();
/*  99 */         xIndianaInfo.getTurn_infos().put(Integer.valueOf(this.turn), xIndianaTurnInfo);
/*     */       }
/* 101 */       for (int sortid = 1; sortid <= turnInfo.award_infos.size(); sortid++)
/*     */       {
/* 103 */         IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(sortid));
/* 104 */         if (xIndianaAwardInfo != null)
/*     */         {
/* 106 */           protocol.attend_nums.add(Integer.valueOf(xIndianaAwardInfo.getAttend_role_num()));
/*     */         }
/*     */         else
/*     */         {
/* 110 */           protocol.attend_nums.add(Integer.valueOf(0));
/*     */         }
/* 112 */         if ((xIndianaAwardInfo == null) || ((currTimeInMillis < turnEndTimestamp) && (currTimeInMillis - xIndianaAwardInfo.getAttend_role_num_timestamp() > IndianaManager.REFRESH_INTERVAL_IN_SECOND * 1000L)))
/*     */         {
/*     */ 
/* 115 */           if (!GrcInterface.getAttendIndianaNum(this.activityCfgid, this.turn, sortid))
/*     */           {
/* 117 */             GameServer.logger().error(String.format("[indiana]PCGetAttendIndianaNum.processImp@get attend indiana num communication error|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(sortid) }));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 127 */     GameServer.logger().info(String.format("[indiana]PCGetAttendIndianaNum.processImp@get attend indiana number success|roleid=%d|activity_cfg_id=%d|turn=%d|attend_nums=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), protocol.attend_nums.toString() }));
/*     */     
/*     */ 
/*     */ 
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 136 */     StringBuilder sb = new StringBuilder();
/* 137 */     sb.append(String.format("[indiana]PCGetAttendIndianaNum.processImp@get attend indiana number fail|roleid=%d|activity_cfg_id=%d|turn=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 140 */     if (extraInfo != null)
/*     */     {
/* 142 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 144 */         sb.append("|").append((String)entry.getKey());
/* 145 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 148 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PCGetAttendIndianaNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */