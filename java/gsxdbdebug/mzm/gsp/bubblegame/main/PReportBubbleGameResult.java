/*     */ package mzm.gsp.bubblegame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bubblegame.SStopBubbleGame;
/*     */ import mzm.gsp.bubblegame.confbean.SBubbleGameCfg;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameOver;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameOverArg;
/*     */ import mzm.gsp.bubblegame.event.ClientReportBubbleGameResult;
/*     */ import mzm.gsp.bubblegame.event.ClientReportBubbleGameResultArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BubbleGameInfo;
/*     */ import xbean.RoleBubbleGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_bubble_game_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PReportBubbleGameResult extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final int turnIndex;
/*     */   private final int result;
/*     */   
/*     */   public PReportBubbleGameResult(long roleid, int gameid, int turnIndex, int result)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.gameid = gameid;
/*  39 */     this.turnIndex = turnIndex;
/*  40 */     this.result = result;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(this.gameid);
/*  47 */     if (cfg == null)
/*     */     {
/*     */ 
/*  50 */       onFail(-3, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if ((this.result != 0) && (this.result != 1))
/*     */     {
/*     */ 
/*     */ 
/*  57 */       onFail(-3, null);
/*  58 */       return false;
/*     */     }
/*  60 */     if (!BubbleGameManager.isBubblecGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  63 */       onFail(-1, null);
/*  64 */       return false;
/*     */     }
/*  66 */     if (!BubbleGameManager.checkRoleStatus(this.roleid, 703))
/*     */     {
/*     */ 
/*  69 */       onFail(-2, null);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  75 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  77 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  79 */     RoleBubbleGameInfo xRoleBubbleGameInfo = Role_bubble_game_infos.get(Long.valueOf(this.roleid));
/*  80 */     if (xRoleBubbleGameInfo == null)
/*     */     {
/*     */ 
/*  83 */       onFail(-4, null);
/*  84 */       return false;
/*     */     }
/*  86 */     BubbleGameInfo xBubbleGameInfo = (BubbleGameInfo)xRoleBubbleGameInfo.getBubble_game_infos().get(Integer.valueOf(this.gameid));
/*  87 */     if (xBubbleGameInfo == null)
/*     */     {
/*     */ 
/*  90 */       onFail(-4, null);
/*  91 */       return false;
/*     */     }
/*  93 */     if ((xBubbleGameInfo.getGame_state() != 1) || (xBubbleGameInfo.getComplete_turn_index() >= cfg.turn_sum))
/*     */     {
/*     */ 
/*     */ 
/*  97 */       onFail(-4, null);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     if (this.result == 0)
/*     */     {
/* 104 */       if (cfg.right_award_id > 0)
/*     */       {
/* 106 */         AwardReason awardReason = new AwardReason(LogReason.BUBBLE_GAME_RIGHT_AWARD, this.gameid);
/* 107 */         AwardModel awardModel = AwardInterface.award(cfg.right_award_id, userid, this.roleid, false, true, awardReason);
/*     */         
/* 109 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 112 */           onFail(-5, null);
/* 113 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/* 119 */     else if (cfg.wrong_award_id > 0)
/*     */     {
/* 121 */       AwardReason awardReason = new AwardReason(LogReason.BUBBLE_GAME_WRONG_AWARD, this.gameid);
/* 122 */       AwardModel awardModel = AwardInterface.award(cfg.wrong_award_id, userid, this.roleid, false, true, awardReason);
/*     */       
/* 124 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 127 */         onFail(-5, null);
/* 128 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 133 */     xBubbleGameInfo.setComplete_turn_index(xBubbleGameInfo.getComplete_turn_index() + 1);
/* 134 */     xBubbleGameInfo.setRight_turn_num(xBubbleGameInfo.getRight_turn_num() + this.result == 0 ? 1 : 0);
/*     */     
/*     */ 
/* 137 */     TriggerEventsManger.getInstance().triggerEvent(new ClientReportBubbleGameResult(), new ClientReportBubbleGameResultArg(this.roleid, this.gameid, this.result == 0, xBubbleGameInfo.getContext()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */     StringBuilder sb = new StringBuilder();
/* 145 */     sb.append(String.format("[bubblegame]PReportBubbleGameResult.processImp@report bubble game result success|roleid=%d|gameid=%d|turn_index=%d|result=%d|complete_turn_index=%d|right_turn_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(this.turnIndex), Integer.valueOf(this.result), Integer.valueOf(xBubbleGameInfo.getComplete_turn_index()), Integer.valueOf(xBubbleGameInfo.getRight_turn_num()) }));
/*     */     
/*     */ 
/*     */ 
/* 149 */     BubbleGameManager.logger.info(sb.toString());
/*     */     
/*     */ 
/* 152 */     if (xBubbleGameInfo.getComplete_turn_index() >= cfg.turn_sum)
/*     */     {
/* 154 */       Map.Entry<Integer, Integer> entry = cfg.right_sum_award_info.floorEntry(Integer.valueOf(xBubbleGameInfo.getRight_turn_num()));
/* 155 */       if ((entry != null) && (((Integer)entry.getValue()).intValue() > 0))
/*     */       {
/* 157 */         AwardReason awardReason = new AwardReason(LogReason.BUBBLE_GAME_RIGHT_SUM_AWARD, this.gameid);
/* 158 */         AwardModel awardModel = AwardInterface.award(((Integer)entry.getValue()).intValue(), userid, this.roleid, false, true, awardReason);
/*     */         
/* 160 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 163 */           onFail(-6, null);
/* 164 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 168 */       BubbleGameOverArg arg = new BubbleGameOverArg(this.roleid, this.gameid, xBubbleGameInfo.getComplete_turn_index(), xBubbleGameInfo.getRight_turn_num(), xBubbleGameInfo.getStart_timestamp(), xBubbleGameInfo.getContext());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 173 */       TriggerEventsManger.getInstance().triggerEvent(new BubbleGameOver(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 176 */       xBubbleGameInfo.setGame_state(2);
/* 177 */       xBubbleGameInfo.setComplete_turn_index(0);
/* 178 */       xBubbleGameInfo.setRight_turn_num(0);
/* 179 */       Session.removeSession(xBubbleGameInfo.getSessionid(), this.roleid);
/* 180 */       xBubbleGameInfo.setSessionid(-1L);
/* 181 */       xBubbleGameInfo.setStart_timestamp(-1L);
/* 182 */       xBubbleGameInfo.setContext(null);
/*     */       
/* 184 */       SStopBubbleGame protocol = new SStopBubbleGame();
/* 185 */       protocol.game_id = this.gameid;
/* 186 */       protocol.res = 1;
/* 187 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 189 */       StringBuilder sb_1 = new StringBuilder();
/* 190 */       sb_1.append(String.format("[bubblegame]PReportBubbleGameResult.processImp@bubble game stop|roleid=%d|gameid=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(arg.completeTrunIndex), Integer.valueOf(arg.rightTurnNum), Long.valueOf(arg.gameStartTimeStamp) }));
/*     */       
/*     */ 
/* 193 */       BubbleGameManager.logger.info(sb_1.toString());
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 200 */     StringBuilder sb = new StringBuilder();
/* 201 */     sb.append(String.format("[bubblegame]PReportBubbleGameResult.processImp@report bubble game result fail|roleid=%d|gameid=%d|turn_index=%d|result=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(this.turnIndex), Integer.valueOf(this.result), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 204 */     if (extraInfo != null)
/*     */     {
/* 206 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 208 */         sb.append("|").append((String)entry.getKey());
/* 209 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 212 */     BubbleGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\PReportBubbleGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */