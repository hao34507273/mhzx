/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import hub.NotifyIndianaAwardRoleInfo;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class PBrdAwardRoleInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   private final int sortid;
/*     */   
/*     */   public PBrdAwardRoleInfo(int activityCfgid, int turn, int sortid)
/*     */   {
/*  27 */     this.activityCfgid = activityCfgid;
/*  28 */     this.turn = turn;
/*  29 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  36 */     if (cfg == null)
/*     */     {
/*     */ 
/*  39 */       onFail(-3, null);
/*  40 */       return false;
/*     */     }
/*  42 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  43 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  46 */       onFail(-3, null);
/*  47 */       return false;
/*     */     }
/*  49 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(this.sortid));
/*  50 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  53 */       onFail(-3, null);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  59 */     lock(Indiana_infos.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*     */     
/*  61 */     xbean.IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  62 */     if (xIndianaInfo == null)
/*     */     {
/*     */ 
/*  65 */       onFail(-5, null);
/*  66 */       return false;
/*     */     }
/*  68 */     IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/*  69 */     if (xIndianaTurnInfo == null)
/*     */     {
/*     */ 
/*  72 */       onFail(-5, null);
/*  73 */       return false;
/*     */     }
/*  75 */     IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(this.sortid));
/*  76 */     if (xIndianaAwardInfo == null)
/*     */     {
/*     */ 
/*  79 */       onFail(-5, null);
/*  80 */       return false;
/*     */     }
/*  82 */     if (xIndianaAwardInfo.getNeed_broadcast_numbers().isEmpty())
/*     */     {
/*     */ 
/*  85 */       onFail(-8, null);
/*  86 */       return false;
/*     */     }
/*  88 */     NotifyIndianaAwardRoleInfo data = new NotifyIndianaAwardRoleInfo();
/*  89 */     data.activity_cfg_id = this.activityCfgid;
/*  90 */     data.turn = this.turn;
/*  91 */     data.sortid = this.sortid;
/*  92 */     for (Iterator i$ = xIndianaAwardInfo.getNeed_broadcast_numbers().iterator(); i$.hasNext();) { int number = ((Integer)i$.next()).intValue();
/*     */       
/*  94 */       xbean.IndianaAwardRoleInfo xIndianaAwardRoleInfo = (xbean.IndianaAwardRoleInfo)xIndianaAwardInfo.getAward_number_infos().get(Integer.valueOf(number));
/*  95 */       if ((xIndianaAwardRoleInfo != null) && 
/*     */       
/*     */ 
/*     */ 
/*  99 */         (xIndianaAwardRoleInfo.getRoleid() > 0L) && (GameServerInfoManager.isRoleInOwnServer(xIndianaAwardRoleInfo.getRoleid())) && (xIndianaAwardRoleInfo.getRole_name() != null) && (!xIndianaAwardRoleInfo.getRole_name().isEmpty()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 105 */         hub.IndianaAwardRoleInfo roleInfo = new hub.IndianaAwardRoleInfo();
/* 106 */         roleInfo.roleid = xIndianaAwardRoleInfo.getRoleid();
/* 107 */         roleInfo.role_name.setString(xIndianaAwardRoleInfo.getRole_name(), "UTF-8");
/* 108 */         data.award_role_infos.put(Integer.valueOf(number), roleInfo);
/*     */       } }
/* 110 */     if (!data.award_role_infos.isEmpty())
/*     */     {
/* 112 */       mzm.gsp.crossserver.main.CrossServerInterface.broadcastIndianaAwardRoleInfo(data);
/*     */     }
/* 114 */     xIndianaAwardInfo.getNeed_broadcast_numbers().clear();
/* 115 */     GameServer.logger().info(String.format("[indiana]PBrdAwardRoleInfo.processImp@broadcast award role info success|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid) }));
/*     */     
/*     */ 
/*     */ 
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 124 */     StringBuilder sb = new StringBuilder();
/* 125 */     sb.append(String.format("[indiana]PBrdAwardRoleInfo.processImp@broadcast award role info fail|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 128 */     if (extraInfo != null)
/*     */     {
/* 130 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 132 */         sb.append("|").append((String)entry.getKey());
/* 133 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 136 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PBrdAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */