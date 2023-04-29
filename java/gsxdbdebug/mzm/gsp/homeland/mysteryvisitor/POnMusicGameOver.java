/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.homeland.SAttendMysteryVisitorFail;
/*     */ import mzm.gsp.homeland.SAttendMysteryVisitorSuccess;
/*     */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*     */ import mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorMusicGameCfg;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappear;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappearArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.musicgame.event.MusicGameOverArg;
/*     */ import mzm.gsp.musicgame.event.MusicGameOverProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnMusicGameOver extends MusicGameOverProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if ((SMysteryVisitorMusicGameCfg.get(((MusicGameOverArg)this.arg).gameid) == null) || (!(((MusicGameOverArg)this.arg).context instanceof MysteryVisitorMusicGameContext)))
/*     */     {
/*     */ 
/*     */ 
/*  40 */       return false;
/*     */     }
/*  42 */     long roleid = ((MusicGameOverArg)this.arg).roleid;
/*  43 */     int gameid = ((MusicGameOverArg)this.arg).gameid;
/*  44 */     int rightTurnNum = ((MusicGameOverArg)this.arg).rightTurnNum;
/*     */     
/*  46 */     SMusicGameMysteryVisitorCfg cfg = SMusicGameMysteryVisitorCfg.get(SMysteryVisitorMusicGameCfg.get(gameid).mystery_visitor_cfg_id);
/*  47 */     if (cfg == null)
/*     */     {
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpenForRole(roleid))
/*     */     {
/*     */ 
/*  56 */       onFail(roleid, cfg.id, gameid, rightTurnNum, -1, null);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     String userid = RoleInterface.getUserId(roleid);
/*  61 */     long partnerid = MarriageInterface.getMarriedRoleid(roleid, false);
/*  62 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/*  65 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  67 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*  68 */       if (MarriageInterface.getMarriedRoleid(roleid, true) >= 0L)
/*     */       {
/*     */ 
/*  71 */         onFail(roleid, cfg.id, gameid, rightTurnNum, 5, null);
/*  72 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  77 */       long marriageid = MarriageInterface.getMarriedId(roleid, false);
/*  78 */       if (marriageid < 0L)
/*     */       {
/*     */ 
/*  81 */         onFail(roleid, cfg.id, gameid, rightTurnNum, 5, null);
/*  82 */         return false;
/*     */       }
/*  84 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/*  86 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/*  88 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(partnerid) }));
/*     */       
/*  90 */       lock(xtable.Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*  91 */       if ((MarriageInterface.getMarriedRoleid(roleid, true) != partnerid) || (MarriageInterface.getMarriedId(roleid, true) != marriageid))
/*     */       {
/*     */ 
/*     */ 
/*  95 */         onFail(roleid, cfg.id, gameid, rightTurnNum, 5, null);
/*  96 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 100 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/* 102 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 105 */       Map<String, Object> extraInfo = new HashMap();
/* 106 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 107 */       onFail(roleid, cfg.id, gameid, rightTurnNum, 1, extraInfo);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     int courdyardAestheticsDegree = HomelandInterface.getCourtYardBeautiful(roleid);
/* 112 */     if (courdyardAestheticsDegree < 0)
/*     */     {
/*     */ 
/* 115 */       onFail(roleid, cfg.id, gameid, rightTurnNum, 4, null);
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(roleid));
/* 120 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 123 */       return false;
/*     */     }
/* 125 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() <= 0)
/*     */     {
/*     */ 
/* 128 */       onFail(roleid, cfg.id, gameid, rightTurnNum, 3, null);
/* 129 */       return false;
/*     */     }
/* 131 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() != cfg.id)
/*     */     {
/*     */ 
/* 134 */       onFail(roleid, cfg.id, gameid, rightTurnNum, -4, null);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     if ((rightTurnNum >= cfg.need_right_num) && (cfg.award_id > 0))
/*     */     {
/* 140 */       AwardReason awardReason = new AwardReason(LogReason.MYSTERY_VISITOR_AWARD, cfg.award_id);
/* 141 */       mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, awardReason);
/* 142 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 145 */         onFail(roleid, cfg.id, gameid, rightTurnNum, 2, null);
/* 146 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 150 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(-1);
/* 151 */     ActivityInterface.addActivityCount(userid, roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/* 152 */     TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorDisappear(), new MysteryVisitorDisappearArg(roleid));
/*     */     
/* 154 */     SAttendMysteryVisitorSuccess protocol = new SAttendMysteryVisitorSuccess();
/* 155 */     protocol.mystery_visitor_cfg_id = cfg.id;
/* 156 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 158 */     StringBuilder sb = new StringBuilder();
/* 159 */     sb.append(String.format("[mysteryvisitor]POnMusicGameOver.processImp@music game over process success|roleid=%d|mystery_visitor_cfg_id=%d|gameid=%d|right_turn_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfg.id), Integer.valueOf(gameid), Integer.valueOf(rightTurnNum) }));
/*     */     
/*     */ 
/* 162 */     MysteryVisitorManager.logger.info(sb.toString());
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(long roleid, int mysteryVisitorCfgid, int gameid, int rightTurnNum, int res, Map<String, Object> extraInfo)
/*     */   {
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append(String.format("[mysteryvisitor]POnMusicGameOver.processImp@music game over process fail|roleid=%d|mystery_visitor_cfg_id=%d|gameid=%d|right_turn_num=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(mysteryVisitorCfgid), Integer.valueOf(gameid), Integer.valueOf(rightTurnNum), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 173 */     if (extraInfo != null)
/*     */     {
/* 175 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 177 */         sb.append("|").append((String)entry.getKey());
/* 178 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 181 */     MysteryVisitorManager.logger.info(sb.toString());
/* 182 */     if (res > 0)
/*     */     {
/* 184 */       SAttendMysteryVisitorFail protocol = new SAttendMysteryVisitorFail();
/* 185 */       protocol.res = res;
/* 186 */       OnlineManager.getInstance().send(roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\POnMusicGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */