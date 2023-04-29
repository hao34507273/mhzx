/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.alllotto.AllLottoLog;
/*     */ import mzm.gsp.alllotto.SGetAllLottoLogsSuccess;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllLottoAwardRoleInfo;
/*     */ import xbean.AllLottoInfo;
/*     */ import xbean.AllLottoTurnInfo;
/*     */ import xtable.All_lotto_infos;
/*     */ 
/*     */ public class PCGetAllLottoLogs extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int num;
/*     */   
/*     */   public PCGetAllLottoLogs(long roleid, int activityCfgid, int num)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.activityCfgid = activityCfgid;
/*  31 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (this.num < 0)
/*     */     {
/*     */ 
/*  40 */       onFail(-3, null);
/*  41 */       return false;
/*     */     }
/*  43 */     SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/*  44 */     if (cfg == null)
/*     */     {
/*     */ 
/*  47 */       onFail(-3, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!AllLottoManager.isAllLottoSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  53 */       onFail(-1, null);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 2032, true))
/*     */     {
/*     */ 
/*  59 */       onFail(-2, null);
/*  60 */       return false;
/*     */     }
/*  62 */     SGetAllLottoLogsSuccess protocol = new SGetAllLottoLogsSuccess();
/*  63 */     protocol.activity_cfg_id = this.activityCfgid;
/*  64 */     protocol.num = this.num;
/*     */     
/*  66 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  67 */     lock(All_lotto_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  68 */     AllLottoInfo xAllLottoInfo = All_lotto_infos.get(Long.valueOf(globalActivityCfgid));
/*  69 */     if (xAllLottoInfo != null)
/*     */     {
/*  71 */       int logNum = 0;
/*  72 */       for (int turn = cfg.turn_infos.size(); turn >= 1; turn--)
/*     */       {
/*  74 */         AllLottoTurnInfo xAllLottoTurnInfo = (AllLottoTurnInfo)xAllLottoInfo.getTurn_infos().get(Integer.valueOf(turn));
/*  75 */         if ((xAllLottoTurnInfo != null) && (!xAllLottoTurnInfo.getAward_role_infos().isEmpty()))
/*     */         {
/*     */ 
/*     */ 
/*  79 */           for (AllLottoAwardRoleInfo xAllLottoAwardRoleInfo : xAllLottoTurnInfo.getAward_role_infos())
/*     */           {
/*  81 */             logNum++;
/*  82 */             AllLottoLog log = new AllLottoLog();
/*  83 */             protocol.logs.add(log);
/*  84 */             log.turn = turn;
/*  85 */             log.role_info.roleid = xAllLottoAwardRoleInfo.getRoleid();
/*  86 */             log.role_info.role_name.setString(xAllLottoAwardRoleInfo.getRole_name(), "UTF-8");
/*  87 */             log.role_info.occupation = xAllLottoAwardRoleInfo.getOccupation();
/*  88 */             log.role_info.gender = xAllLottoAwardRoleInfo.getGender();
/*  89 */             log.role_info.level = xAllLottoAwardRoleInfo.getLevel();
/*  90 */             log.role_info.avatarid = xAllLottoAwardRoleInfo.getAvatarid();
/*  91 */             log.role_info.avatar_frameid = xAllLottoAwardRoleInfo.getAvatar_frameid();
/*  92 */             if ((this.num > 0) && (this.num <= logNum)) {
/*     */               break;
/*     */             }
/*     */             
/*  96 */             if (AllLottoManager.MAX_LOG_NUM <= logNum) {
/*     */               break;
/*     */             }
/*     */           }
/*     */           
/* 101 */           if ((this.num > 0) && (this.num <= logNum)) {
/*     */             break;
/*     */           }
/*     */           
/* 105 */           if (AllLottoManager.MAX_LOG_NUM <= logNum) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 111 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 113 */     GameServer.logger().info(String.format("[alllotto]PCGetAllLottoLogs.processImp@get all lotto logs success|roleid=%d|activity_cfg_id=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.num) }));
/*     */     
/*     */ 
/*     */ 
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 122 */     StringBuilder sb = new StringBuilder();
/* 123 */     sb.append(String.format("[alllotto]PCGetAllLottoLogs.processImp@get all lotto logs fail|roleid=%d|activity_cfg_id=%d|num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.num), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 126 */     if (extraInfo != null)
/*     */     {
/* 128 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 130 */         sb.append("|").append((String)entry.getKey());
/* 131 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 134 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\PCGetAllLottoLogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */