/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.FightAgainstInfo;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_GetStageBetInfo;
/*     */ import mzm.gsp.crossbattle.SGetFinalStageBetInfoFail;
/*     */ import mzm.gsp.crossbattle.SGetSelectionStageBetInfoFail;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockoutBetInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleFightZoneInfo;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetKnockoutStageBetInfo
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int knockoutType;
/*     */   private final int fightZoneid;
/*     */   private final int stage;
/*     */   
/*     */   public PCGetKnockoutStageBetInfo(long roleid, int activityCfgid, int KnockoutType, int fightZoneid, int stage)
/*     */   {
/*  39 */     this.roleid = roleid;
/*  40 */     this.activityCfgid = activityCfgid;
/*  41 */     this.knockoutType = KnockoutType;
/*  42 */     this.fightZoneid = fightZoneid;
/*  43 */     this.stage = stage;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     SCrossBattleKnockoutBetInfo cfg = CrossBattleBetManager.getCrossBattleKnockoutBetInfo(this.activityCfgid, this.knockoutType);
/*     */     
/*  51 */     if (cfg == null)
/*     */     {
/*     */ 
/*  54 */       onFail(-3, null);
/*  55 */       return false;
/*     */     }
/*  57 */     if ((this.fightZoneid <= 0) || (this.fightZoneid > CrossBattleBetManager.getKnockoutFightZoneNum(this.knockoutType)))
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if ((this.stage <= 0) || (this.stage > CrossBattleKnockoutInterface.getKnockOutStageSize(this.activityCfgid, this.knockoutType)))
/*     */     {
/*     */ 
/*     */ 
/*  67 */       onFail(-3, null);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!CrossBattleBetManager.isCrossBattleKnockoutBetSwitchOpenForRole(this.roleid, this.activityCfgid, this.knockoutType))
/*     */     {
/*     */ 
/*  74 */       onFail(-1, null);
/*  75 */       return false;
/*     */     }
/*  77 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, this.knockoutType == 1 ? 1414 : 1416, true))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */       onFail(-2, null);
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     Pair<Integer, Boolean> pair = CrossBattleKnockoutInterface.getNowFightStage(this.knockoutType);
/*  89 */     if (pair == null)
/*     */     {
/*     */ 
/*  92 */       onFail(-3, null);
/*  93 */       return false;
/*     */     }
/*  95 */     int currentStage = ((Integer)pair.first).intValue();
/*  96 */     boolean needRefresh = ((Boolean)pair.second).booleanValue();
/*  97 */     CrossBattleFightZoneInfo fightZoneInfo = CrossBattleKnockoutInterface.getCrossBattleKnockOutFightZoneInfo(this.activityCfgid, this.knockoutType, this.fightZoneid);
/*     */     
/*  99 */     if ((fightZoneInfo == null) || ((currentStage == this.stage) && (needRefresh)))
/*     */     {
/*     */ 
/* 102 */       GetKnockOutContext context = new GetKnockOutContext();
/* 103 */       context.oper_type = 3;
/* 104 */       context.content.replace(new GetKnockOutContext_GetStageBetInfo(this.roleid, this.stage).marshal(new OctetsStream()));
/* 105 */       if (!CrossBattleKnockoutInterface.getCrossBattleKnockOutInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/* 109 */         onFail(1, null);
/* 110 */         return false;
/*     */       }
/* 112 */       StringBuilder sb = new StringBuilder();
/* 113 */       sb.append(String.format("[crossbattle_bet]PCGetKnockoutStageBetInfo.processImp@gs has no knockout data|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage) }));
/*     */       
/*     */ 
/* 116 */       CrossBattleBetManager.logger.info(sb.toString());
/* 117 */       return true;
/*     */     }
/* 119 */     List<FightAgainstInfo> fightInfos = fightZoneInfo.getStagefightAgainstList(this.stage);
/* 120 */     CrossBattleBetManager.refreshXKnockoutStageBetInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, fightInfos);
/*     */     
/* 122 */     if (!GrcInterface.getCrossBattleKnockoutStageBetInfo(this.activityCfgid, this.knockoutType, this.fightZoneid, this.stage, fightInfos.size(), this.roleid, 0))
/*     */     {
/*     */ 
/*     */ 
/* 126 */       onFail(1, null);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     StringBuilder sb = new StringBuilder();
/* 131 */     sb.append(String.format("[crossbattle_bet]PCGetKnockoutStageBetInfo.processImp@get knockout stage bet info from grc|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage) }));
/*     */     
/*     */ 
/* 134 */     CrossBattleBetManager.logger.info(sb.toString());
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 140 */     StringBuilder sb = new StringBuilder();
/* 141 */     sb.append(String.format("[crossbattle_bet]PCGetKnockoutStageBetInfo.processImp@get knockout stage bet info fail|roleid=%d|activity_cfg_id=%d|knockout_type=%d|fight_zone_id=%d|stage=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.knockoutType), Integer.valueOf(this.fightZoneid), Integer.valueOf(this.stage), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 144 */     if (extraInfo != null)
/*     */     {
/* 146 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 148 */         sb.append("|").append((String)entry.getKey());
/* 149 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 152 */     CrossBattleBetManager.logger.info(sb.toString());
/* 153 */     if (res > 0)
/*     */     {
/* 155 */       switch (this.knockoutType)
/*     */       {
/*     */ 
/*     */       case 1: 
/* 159 */         SGetSelectionStageBetInfoFail protocol = new SGetSelectionStageBetInfoFail();
/* 160 */         protocol.res = res;
/* 161 */         OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */         
/* 163 */         break;
/*     */       
/*     */       case 2: 
/* 166 */         SGetFinalStageBetInfoFail protocol = new SGetFinalStageBetInfoFail();
/* 167 */         protocol.res = res;
/* 168 */         OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */         
/* 170 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PCGetKnockoutStageBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */