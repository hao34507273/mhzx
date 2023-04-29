/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.indiana.IndianaLog;
/*     */ import mzm.gsp.indiana.SGetIndianaLogsSuccess;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaAwardRoleInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class PCGetIndianaLogs extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetIndianaLogs(long roleid, int activityCfgid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  37 */     if (cfg == null)
/*     */     {
/*     */ 
/*  40 */       onFail(-3, null);
/*  41 */       return false;
/*     */     }
/*  43 */     if (!IndianaManager.isIndianaSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  46 */       onFail(-1, null);
/*  47 */       return false;
/*     */     }
/*  49 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1994, true))
/*     */     {
/*     */ 
/*  52 */       onFail(-2, null);
/*  53 */       return false;
/*     */     }
/*  55 */     SGetIndianaLogsSuccess protocol = new SGetIndianaLogsSuccess();
/*  56 */     protocol.activity_cfg_id = this.activityCfgid;
/*  57 */     int passTurn = IndianaManager.getCurrentPassTurn(this.activityCfgid);
/*  58 */     if (passTurn <= 0)
/*     */     {
/*  60 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/*  62 */       GameServer.logger().info(String.format("[indiana]PCGetIndianaLogs.processImp@get indiana logs success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  65 */       return true;
/*     */     }
/*     */     
/*  68 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  69 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  70 */     if (xIndianaInfo == null)
/*     */     {
/*  72 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/*  74 */       GameServer.logger().info(String.format("[indiana]PCGetIndianaLogs.processImp@get indiana logs success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  77 */       return true;
/*     */     }
/*  79 */     for (int turn = passTurn; turn >= 1; turn--)
/*     */     {
/*  81 */       SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(turn));
/*  82 */       if (turnInfo == null)
/*     */       {
/*     */ 
/*  85 */         onFail(-3, null);
/*  86 */         return false;
/*     */       }
/*  88 */       IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(turn));
/*  89 */       if (xIndianaTurnInfo != null)
/*     */       {
/*     */ 
/*     */ 
/*  93 */         for (int sortid = 1; sortid <= turnInfo.award_infos.size(); sortid++)
/*     */         {
/*  95 */           SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(sortid));
/*  96 */           if (awardInfo == null)
/*     */           {
/*     */ 
/*  99 */             onFail(-3, null);
/* 100 */             return false;
/*     */           }
/* 102 */           if (awardInfo.need_log)
/*     */           {
/*     */ 
/*     */ 
/* 106 */             IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(sortid));
/* 107 */             if (xIndianaAwardInfo != null)
/*     */             {
/*     */ 
/*     */ 
/* 111 */               if (xIndianaAwardInfo.getGot_award_number())
/*     */               {
/*     */ 
/*     */ 
/* 115 */                 for (Map.Entry<Integer, IndianaAwardRoleInfo> entry : xIndianaAwardInfo.getAward_number_infos().entrySet())
/*     */                 {
/* 117 */                   int number = ((Integer)entry.getKey()).intValue();
/* 118 */                   IndianaAwardRoleInfo xIndianaAwardRoleInfo = (IndianaAwardRoleInfo)entry.getValue();
/* 119 */                   IndianaLog log = new IndianaLog();
/* 120 */                   log.turn = turn;
/* 121 */                   log.sortid = sortid;
/* 122 */                   log.award_number = number;
/* 123 */                   log.roleid = xIndianaAwardRoleInfo.getRoleid();
/* 124 */                   if ((xIndianaAwardRoleInfo.getRole_name() != null) && (!xIndianaAwardRoleInfo.getRole_name().isEmpty()))
/*     */                   {
/* 126 */                     log.role_name.setString(xIndianaAwardRoleInfo.getRole_name(), "UTF-8");
/*     */                   }
/* 128 */                   protocol.logs.add(log);
/* 129 */                   if (protocol.logs.size() >= IndianaManager.MAX_LOG_NUM)
/*     */                   {
/* 131 */                     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */                     
/* 133 */                     GameServer.logger().info(String.format("[indiana]PCGetIndianaLogs.processImp@get indiana logs success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */                     
/*     */ 
/*     */ 
/* 137 */                     return true;
/*     */                   }
/*     */                 } } }
/*     */           }
/*     */         } } }
/* 142 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 144 */     GameServer.logger().info(String.format("[indiana]PCGetIndianaLogs.processImp@get indiana logs success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     sb.append(String.format("[indiana]PCGetIndianaLogs.processImp@get indiana logs fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 156 */     if (extraInfo != null)
/*     */     {
/* 158 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 160 */         sb.append("|").append((String)entry.getKey());
/* 161 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 164 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PCGetIndianaLogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */