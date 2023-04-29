/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chat.main.ChatInterface;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.SCanvassInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.CrossBattleOwnActivityInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleOwnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Corps;
/*     */ import xtable.Role_cross_battle_own_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCanvassInCrossBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final long targetCorpsid;
/*     */   private final Octets text;
/*     */   
/*     */   public PCCanvassInCrossBattle(long roleid, int activityCfgid, long targetCorpsid, Octets text)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.activityCfgid = activityCfgid;
/*  38 */     this.targetCorpsid = targetCorpsid;
/*  39 */     this.text = text;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (this.targetCorpsid < 0L)
/*     */     {
/*     */ 
/*  48 */       onFail(-3, null, 0L);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!CrossBattleOwnManager.isCrossBattleVoteStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  54 */       onFail(-1, null, 0L);
/*  55 */       return false;
/*     */     }
/*  57 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1304, true))
/*     */     {
/*     */ 
/*  60 */       onFail(-2, null, 0L);
/*  61 */       return false;
/*     */     }
/*  63 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  64 */     if (cfg == null)
/*     */     {
/*     */ 
/*  67 */       onFail(-3, null, 0L);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  73 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  75 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  77 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  78 */     RoleCrossBattleOwnInfo xRoleCrossBattleOwnInfo = Role_cross_battle_own_infos.get(Long.valueOf(this.roleid));
/*  79 */     if (xRoleCrossBattleOwnInfo == null)
/*     */     {
/*  81 */       xRoleCrossBattleOwnInfo = Pod.newRoleCrossBattleOwnInfo();
/*  82 */       Role_cross_battle_own_infos.insert(Long.valueOf(this.roleid), xRoleCrossBattleOwnInfo);
/*     */     }
/*  84 */     CrossBattleOwnActivityInfo xCrossBattleOwnActivityInfo = (CrossBattleOwnActivityInfo)xRoleCrossBattleOwnInfo.getCross_battle_own_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  86 */     if (xCrossBattleOwnActivityInfo == null)
/*     */     {
/*  88 */       xCrossBattleOwnActivityInfo = Pod.newCrossBattleOwnActivityInfo();
/*  89 */       xCrossBattleOwnActivityInfo.setVote_times(0);
/*  90 */       xCrossBattleOwnActivityInfo.setVote_timestamp(now);
/*  91 */       xRoleCrossBattleOwnInfo.getCross_battle_own_activity_infos().put(Integer.valueOf(this.activityCfgid), xCrossBattleOwnActivityInfo);
/*     */     }
/*  93 */     if (now - xCrossBattleOwnActivityInfo.getCanvass_timestamp() < CrossBattleConsts.getInstance().CANVASS_COOLDOWN_TIME_IN_SECOND * 1000L)
/*     */     {
/*     */ 
/*  96 */       onFail(6, null, xCrossBattleOwnActivityInfo.getCanvass_timestamp());
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     lock(Corps.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.targetCorpsid) }));
/* 101 */     CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByCorpsId(this.targetCorpsid, true);
/* 102 */     if (corpsInfo == null)
/*     */     {
/*     */ 
/* 105 */       onFail(-3, null, xCrossBattleOwnActivityInfo.getCanvass_timestamp());
/* 106 */       return false;
/*     */     }
/* 108 */     if (!corpsInfo.getAllMemberIds().contains(Long.valueOf(this.roleid)))
/*     */     {
/*     */ 
/* 111 */       onFail(3, null, xCrossBattleOwnActivityInfo.getCanvass_timestamp());
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     if (!CrossBattleOwnManager.isInVoteStage(this.activityCfgid))
/*     */     {
/*     */ 
/* 118 */       onFail(2, null, xCrossBattleOwnActivityInfo.getCanvass_timestamp());
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 123 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 124 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(this.targetCorpsid));
/* 125 */     if (xAttendCorpsInfo == null)
/*     */     {
/*     */ 
/* 128 */       onFail(4, null, xCrossBattleOwnActivityInfo.getCanvass_timestamp());
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     if (!ChatInterface.chatInTrumpet(userid, this.roleid, cfg.canvass_trumpet_cfg_id, 2, this.text))
/*     */     {
/*     */ 
/* 135 */       onFail(5, null, xCrossBattleOwnActivityInfo.getCanvass_timestamp());
/* 136 */       return false;
/*     */     }
/* 138 */     xCrossBattleOwnActivityInfo.setCanvass_timestamp(now);
/*     */     
/* 140 */     StringBuilder sb = new StringBuilder();
/* 141 */     sb.append(String.format("[crossbattle_own]PCCanvassInCrossBattle.processImp@canvass in cross battle success|roleid=%d|activity_cfg_id=%d|target_corps_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.targetCorpsid) }));
/*     */     
/*     */ 
/* 144 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 145 */     CrossBattleOwnTLogManager.addVoteStageTLog(this.roleid, this.activityCfgid, 4, 1, this.targetCorpsid, xAttendCorpsInfo.getVote_num());
/*     */     
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, long canvassTimestamp)
/*     */   {
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     sb.append(String.format("[crossbattle_own]PCCanvassInCrossBattle.processImp@canvass in cross battle fail|roleid=%d|activity_cfg_id=%d|target_corps_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.targetCorpsid), Integer.valueOf(res) }));
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
/* 164 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 165 */     if (res > 0)
/*     */     {
/* 167 */       SCanvassInCrossBattleFail protocol = new SCanvassInCrossBattleFail();
/* 168 */       protocol.res = res;
/* 169 */       protocol.canvass_timestamp = ((int)(canvassTimestamp / 1000L));
/* 170 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCCanvassInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */