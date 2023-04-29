/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.indiana.SGetIndianaAwardInfoFail;
/*     */ import mzm.gsp.indiana.SGetIndianaAwardInfoSuccess;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardRoleInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class PCGetIndianaAwardInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   private final int sortid;
/*     */   
/*     */   public PCGetIndianaAwardInfo(long roleid, int activityCfgid, int turn, int sortid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.activityCfgid = activityCfgid;
/*  35 */     this.turn = turn;
/*  36 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  43 */     if (cfg == null)
/*     */     {
/*     */ 
/*  46 */       onFail(-3, null);
/*  47 */       return false;
/*     */     }
/*  49 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  50 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  53 */       onFail(-3, null);
/*  54 */       return false;
/*     */     }
/*  56 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(this.sortid));
/*  57 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if (!IndianaManager.isIndianaSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  66 */       onFail(-1, null);
/*  67 */       return false;
/*     */     }
/*  69 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1993, true))
/*     */     {
/*     */ 
/*  72 */       onFail(-2, null);
/*  73 */       return false;
/*     */     }
/*  75 */     long turnEndTimestamp = IndianaManager.getTurnEndTimestamp(this.activityCfgid, this.turn);
/*  76 */     if (turnEndTimestamp < 0L)
/*     */     {
/*     */ 
/*  79 */       onFail(-3, null);
/*  80 */       return false;
/*     */     }
/*  82 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/*  83 */     if (currTimeInMillis < turnEndTimestamp)
/*     */     {
/*     */ 
/*  86 */       onFail(13, null);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  91 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/*  92 */     if (xIndianaInfo == null)
/*     */     {
/*     */ 
/*  95 */       onFail(14, null);
/*  96 */       return false;
/*     */     }
/*  98 */     IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/*  99 */     if (xIndianaTurnInfo == null)
/*     */     {
/*     */ 
/* 102 */       onFail(14, null);
/* 103 */       return false;
/*     */     }
/* 105 */     xbean.IndianaAwardInfo xIndianaAwardInfo = (xbean.IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(this.sortid));
/* 106 */     if ((xIndianaAwardInfo == null) || (!xIndianaAwardInfo.getGot_award_number()))
/*     */     {
/*     */ 
/* 109 */       onFail(14, null);
/* 110 */       return false;
/*     */     }
/* 112 */     SGetIndianaAwardInfoSuccess protocol = new SGetIndianaAwardInfoSuccess();
/* 113 */     protocol.activity_cfg_id = this.activityCfgid;
/* 114 */     protocol.turn = this.turn;
/* 115 */     protocol.sortid = this.sortid;
/* 116 */     for (Map.Entry<Integer, IndianaAwardRoleInfo> entry : xIndianaAwardInfo.getAward_number_infos().entrySet())
/*     */     {
/* 118 */       int number = ((Integer)entry.getKey()).intValue();
/* 119 */       IndianaAwardRoleInfo xIndianaAwardRoleInfo = (IndianaAwardRoleInfo)entry.getValue();
/* 120 */       mzm.gsp.indiana.IndianaAwardInfo info = new mzm.gsp.indiana.IndianaAwardInfo();
/* 121 */       info.award_number = number;
/* 122 */       info.roleid = xIndianaAwardRoleInfo.getRoleid();
/* 123 */       if ((xIndianaAwardRoleInfo.getRole_name() != null) && (!xIndianaAwardRoleInfo.getRole_name().isEmpty()))
/*     */       {
/* 125 */         info.role_name.setString(xIndianaAwardRoleInfo.getRole_name(), "UTF-8");
/*     */       }
/* 127 */       protocol.award_infos.add(info);
/* 128 */       if (protocol.award_infos.size() >= IndianaManager.MAX_AWARD_NUMBER_NUM) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 133 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 135 */     GameServer.logger().info(String.format("[indiana]PCGetIndianaAwardInfo.processImp@get indiana award info success|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid) }));
/*     */     
/*     */ 
/*     */ 
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 144 */     StringBuilder sb = new StringBuilder();
/* 145 */     sb.append(String.format("[indiana]PCGetIndianaAwardInfo.processImp@get indiana award info fail|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 148 */     if (extraInfo != null)
/*     */     {
/* 150 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 152 */         sb.append("|").append((String)entry.getKey());
/* 153 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 156 */     GameServer.logger().info(sb.toString());
/* 157 */     if (res > 0)
/*     */     {
/* 159 */       SGetIndianaAwardInfoFail protocol = new SGetIndianaAwardInfoFail();
/* 160 */       protocol.res = res;
/* 161 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PCGetIndianaAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */