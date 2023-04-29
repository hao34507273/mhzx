/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.crossbattle.SNotifyCrossBattleKnockOutRestart;
/*    */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*    */ import mzm.gsp.crossbattle.own.CrossBattleOwnInterface;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.Pair;
/*    */ 
/*    */ public class PRestartKnockOutSendMail extends LogicProcedure
/*    */ {
/*    */   private final int activityCfgId;
/*    */   private final int knockOutType;
/*    */   private final long worldBeginTime;
/*    */   private final int fightStage;
/*    */   private final Map<Long, Pair<Long, String>> corpsIdMap;
/*    */   
/*    */   public PRestartKnockOutSendMail(int activityCfgId, int knockOutType, long worldBeginTime, int fightStage, Map<Long, Pair<Long, String>> corpsIdMap)
/*    */   {
/* 30 */     this.activityCfgId = activityCfgId;
/* 31 */     this.knockOutType = knockOutType;
/* 32 */     this.fightStage = fightStage;
/* 33 */     this.worldBeginTime = worldBeginTime;
/* 34 */     this.corpsIdMap = corpsIdMap;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 41 */     if (sCrossBattleKnockOutCfg == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 47 */     if (knockOutCfg == null)
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/* 53 */     if (knockOutHandler == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     int mailCfgId = knockOutCfg.restart_mail_cfg_id;
/*    */     
/* 60 */     for (Map.Entry<Long, Pair<Long, String>> entry : this.corpsIdMap.entrySet())
/*    */     {
/* 62 */       long corpsId = ((Long)entry.getKey()).longValue();
/* 63 */       Pair<Long, String> opponentCorpsPair = (Pair)entry.getValue();
/* 64 */       List<Long> roleIdList = CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsId, this.activityCfgId, true);
/*    */       
/* 66 */       int fightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, this.activityCfgId, this.knockOutType);
/* 67 */       if (fightZoneId >= 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 72 */         SNotifyCrossBattleKnockOutRestart sNotifyCrossBattleKnockOutRestart = new SNotifyCrossBattleKnockOutRestart();
/* 73 */         sNotifyCrossBattleKnockOutRestart.fight_type = this.knockOutType;
/* 74 */         sNotifyCrossBattleKnockOutRestart.prepare_world_begin_time = (this.worldBeginTime / 1000L);
/* 75 */         sNotifyCrossBattleKnockOutRestart.prepare_world_end_time = ((this.worldBeginTime + knockOutCfg.prepare_world_countdown * 60000L) / 1000L);
/*    */         
/*    */ 
/* 78 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 80 */           List<String> mailContextArgs = knockOutHandler.getRestartKnockOutMailContextArgs(knockOutCfg, fightZoneId, this.fightStage, ((Long)opponentCorpsPair.first).longValue(), (String)opponentCorpsPair.second, this.worldBeginTime);
/*    */           
/*    */ 
/* 83 */           MailInterface.asynBuildAndSendMail(roleId, mailCfgId, new ArrayList(), mailContextArgs, new TLogArg(LogReason.CROSS_BATTLE_RESTART));
/*    */           
/*    */ 
/* 86 */           CrossBattleKnockoutManager.addRoleKnockOutRestart(roleId, this.worldBeginTime, this.knockOutType);
/*    */         }
/* 88 */         OnlineManager.getInstance().sendMulti(sNotifyCrossBattleKnockOutRestart, roleIdList);
/*    */       } }
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PRestartKnockOutSendMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */