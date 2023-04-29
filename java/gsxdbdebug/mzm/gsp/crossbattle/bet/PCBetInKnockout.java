/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_BetInKnockout;
/*     */ import mzm.gsp.crossbattle.SBetInFinalFail;
/*     */ import mzm.gsp.crossbattle.SBetInSelectionFail;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleBetTimesInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_cross_battle_bet_times_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBetInKnockout extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   private final int fightIndex;
/*     */   private final long betCorpsid;
/*     */   private final int sortid;
/*     */   
/*     */   public PCBetInKnockout(long roleid, int activityCfgid, int knockoutType, int fightZoneid, int stage, int fightIndex, long betCorpsid, int sortid)
/*     */   {
/*  42 */     this.roleid = roleid;
/*  43 */     this.activityCfgid = activityCfgid;
/*  44 */     this.knockoutType = knockoutType;
/*  45 */     this.fightZoneid = fightZoneid;
/*  46 */     this.stage = stage;
/*  47 */     this.fightIndex = fightIndex;
/*  48 */     this.betCorpsid = betCorpsid;
/*  49 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  55 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(this.activityCfgid, this.knockoutType);
/*     */     
/*  57 */     if ((cfg == null) || (!cfg.bet_infos.containsKey(Integer.valueOf(this.sortid))))
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if ((this.fightZoneid <= 0) || (this.fightZoneid > CrossBattleBetManager.getKnockoutFightZoneNum(this.knockoutType)))
/*     */     {
/*     */ 
/*  66 */       onFail(-3, null);
/*  67 */       return false;
/*     */     }
/*  69 */     if ((this.stage <= 0) || (this.stage > CrossBattleKnockoutInterface.getKnockOutStageSize(this.activityCfgid, this.knockoutType)))
/*     */     {
/*     */ 
/*     */ 
/*  73 */       onFail(-3, null);
/*  74 */       return false;
/*     */     }
/*  76 */     if ((this.fightIndex <= 0) || (this.fightIndex > CrossBattleKnockoutInterface.getKnockOutStageFightNum(this.activityCfgid, this.knockoutType, this.stage)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  81 */       onFail(-3, null);
/*  82 */       return false;
/*     */     }
/*  84 */     if (this.betCorpsid < 0L)
/*     */     {
/*     */ 
/*  87 */       onFail(-3, null);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (!CrossBattleBetManager.isCrossBattleKnockoutBetSwitchOpenForRole(this.roleid, this.activityCfgid, this.knockoutType))
/*     */     {
/*     */ 
/*  94 */       onFail(-1, null);
/*  95 */       return false;
/*     */     }
/*  97 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, this.knockoutType == 1 ? 1413 : 1415, true))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 102 */       onFail(-2, null);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     if (!CrossBattleBetManager.isInKnockoutBetTime(this.activityCfgid, this.knockoutType, this.stage))
/*     */     {
/*     */ 
/* 109 */       onFail(4, null);
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/* 115 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/* 117 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 118 */     if (RoleInterface.getLevel(this.roleid) < cfg.bet_level_limit)
/*     */     {
/*     */ 
/* 121 */       onFail(11, null);
/* 122 */       return false;
/*     */     }
/* 124 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 125 */     RoleCrossBattleBetTimesInfo xRoleCrossBattleBetTimesInfo = Role_cross_battle_bet_times_infos.get(Long.valueOf(this.roleid));
/* 126 */     if (xRoleCrossBattleBetTimesInfo == null)
/*     */     {
/* 128 */       xRoleCrossBattleBetTimesInfo = Pod.newRoleCrossBattleBetTimesInfo();
/* 129 */       xRoleCrossBattleBetTimesInfo.setTimestamp(currTimeInMillis);
/* 130 */       Role_cross_battle_bet_times_infos.insert(Long.valueOf(this.roleid), xRoleCrossBattleBetTimesInfo);
/*     */     }
/* 132 */     if (DateTimeUtils.needDailyReset(xRoleCrossBattleBetTimesInfo.getTimestamp(), currTimeInMillis, 0))
/*     */     {
/* 134 */       xRoleCrossBattleBetTimesInfo.setTimes(0);
/* 135 */       xRoleCrossBattleBetTimesInfo.setTimestamp(currTimeInMillis);
/*     */     }
/* 137 */     if (xRoleCrossBattleBetTimesInfo.getTimes() >= CrossBattleConsts.getInstance().DAILY_BET_TIMES_UPPER_LIMIT)
/*     */     {
/*     */ 
/* 140 */       onFail(13, null);
/* 141 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 145 */     CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(this.activityCfgid, this.knockoutType, this.fightZoneid);
/*     */     
/* 147 */     if (fightZoneInfo == null)
/*     */     {
/*     */ 
/* 150 */       GetKnockOutContext context = new GetKnockOutContext();
/* 151 */       context.oper_type = 5;
/* 152 */       context.content.replace(new GetKnockOutContext_BetInKnockout(this.roleid, this.stage, this.fightIndex, this.betCorpsid, this.sortid).marshal(new OctetsStream()));
/*     */       
/* 154 */       if (!CrossBattleKnockoutInterface.getCrossBattleKnockOutInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/* 158 */         onFail(1, null);
/* 159 */         return false;
/*     */       }
/* 161 */       StringBuilder sb = new StringBuilder();
/* 162 */       sb.append(String.format("[crossbattle_bet]PCBetInKnockout.processImp@gs has no knockout data|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corpsid=%d|sortid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.sortid) }));
/*     */       
/*     */ 
/*     */ 
/* 166 */       CrossBattleBetManager.logger.info(sb.toString());
/* 167 */       return true;
/*     */     }
/*     */     
/* 170 */     int res = CrossBattleBetManager.betInKnockout(this.roleid, this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, this.fightIndex, this.betCorpsid, this.sortid, fightZoneInfo);
/*     */     
/* 172 */     if (res != 0)
/*     */     {
/* 174 */       onFail(res, null);
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     StringBuilder sb = new StringBuilder();
/* 179 */     sb.append(String.format("[crossbattle_bet]PCBetInKnockout.processImp@bet in knockout success|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corpsid=%d|sortid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.sortid) }));
/*     */     
/*     */ 
/*     */ 
/* 183 */     CrossBattleBetManager.logger.info(sb.toString());
/* 184 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 189 */     StringBuilder sb = new StringBuilder();
/* 190 */     sb.append(String.format("[crossbattle_bet]PCBetInKnockout.processImp@bet in knockout fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|fight_index=%d|bet_corpsid=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(this.fightIndex), Long.valueOf(this.betCorpsid), Integer.valueOf(this.sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*     */ 
/* 194 */     if (extraInfo != null)
/*     */     {
/* 196 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 198 */         sb.append("|").append((String)entry.getKey());
/* 199 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 202 */     CrossBattleBetManager.logger.info(sb.toString());
/* 203 */     if (res > 0)
/*     */     {
/* 205 */       switch (this.knockoutType)
/*     */       {
/*     */ 
/*     */       case 1: 
/* 209 */         SBetInSelectionFail protocol = new SBetInSelectionFail();
/* 210 */         protocol.res = res;
/* 211 */         OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */         
/* 213 */         break;
/*     */       
/*     */       case 2: 
/* 216 */         SBetInFinalFail protocol = new SBetInFinalFail();
/* 217 */         protocol.res = res;
/* 218 */         OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */         
/* 220 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PCBetInKnockout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */