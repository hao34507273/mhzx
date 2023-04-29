/*     */ package mzm.gsp.bubblegame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bubblegame.SStartBubbleGame;
/*     */ import mzm.gsp.bubblegame.confbean.SBubbleGameCfg;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameContext;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameOver;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameOverArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BubbleGameInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleBubbleGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_bubble_game_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PStartBubbleGame extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final boolean isRestartGame;
/*     */   private final int currentPoint;
/*     */   private final BubbleGameContext context;
/*     */   
/*     */   public PStartBubbleGame(long roleid, int gameid, boolean isRestartGame, int currentPoint, BubbleGameContext context)
/*     */   {
/*  39 */     this.roleid = roleid;
/*  40 */     this.gameid = gameid;
/*  41 */     this.isRestartGame = isRestartGame;
/*  42 */     this.currentPoint = currentPoint;
/*  43 */     this.context = context;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!BubbleGameManager.isBubblecGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  52 */       onFail(-1, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if (!BubbleGameManager.checkRoleStatus(this.roleid, 701))
/*     */     {
/*     */ 
/*  58 */       onFail(-2, null);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  64 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  66 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  68 */     RoleBubbleGameInfo xRoleBubbleGameInfo = Role_bubble_game_infos.get(Long.valueOf(this.roleid));
/*  69 */     if (xRoleBubbleGameInfo == null)
/*     */     {
/*  71 */       xRoleBubbleGameInfo = Pod.newRoleBubbleGameInfo();
/*  72 */       Role_bubble_game_infos.insert(Long.valueOf(this.roleid), xRoleBubbleGameInfo);
/*     */     }
/*  74 */     BubbleGameInfo xBubbleGameInfo = (BubbleGameInfo)xRoleBubbleGameInfo.getBubble_game_infos().get(Integer.valueOf(this.gameid));
/*  75 */     if (xBubbleGameInfo == null)
/*     */     {
/*  77 */       xBubbleGameInfo = Pod.newBubbleGameInfo();
/*  78 */       xRoleBubbleGameInfo.getBubble_game_infos().put(Integer.valueOf(this.gameid), xBubbleGameInfo);
/*     */     }
/*     */     
/*  81 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(this.gameid);
/*  82 */     if (cfg == null)
/*     */     {
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     boolean isResumeGame = (!this.isRestartGame) && (xBubbleGameInfo.getStart_timestamp() > 0L);
/*  89 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  91 */     if ((xBubbleGameInfo.getStart_timestamp() > 0L) && (this.isRestartGame))
/*     */     {
/*  93 */       Map.Entry<Integer, Integer> entry = cfg.right_sum_award_info.floorEntry(Integer.valueOf(xBubbleGameInfo.getRight_turn_num()));
/*  94 */       if ((entry != null) && (((Integer)entry.getValue()).intValue() > 0))
/*     */       {
/*  96 */         AwardReason awardReason = new AwardReason(LogReason.BUBBLE_GAME_RIGHT_SUM_AWARD, this.gameid);
/*  97 */         mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(((Integer)entry.getValue()).intValue(), userid, this.roleid, false, true, awardReason);
/*     */         
/*  99 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 102 */           onFail(-6, null);
/* 103 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 107 */       BubbleGameOverArg arg = new BubbleGameOverArg(this.roleid, this.gameid, xBubbleGameInfo.getComplete_turn_index(), xBubbleGameInfo.getRight_turn_num(), xBubbleGameInfo.getStart_timestamp(), xBubbleGameInfo.getContext());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 112 */       TriggerEventsManger.getInstance().triggerEvent(new BubbleGameOver(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 115 */       xBubbleGameInfo.setGame_state(2);
/* 116 */       xBubbleGameInfo.setComplete_turn_index(0);
/* 117 */       xBubbleGameInfo.setRight_turn_num(0);
/* 118 */       Session.removeSession(xBubbleGameInfo.getSessionid(), this.roleid);
/* 119 */       xBubbleGameInfo.setSessionid(-1L);
/* 120 */       xBubbleGameInfo.setStart_timestamp(-1L);
/* 121 */       xBubbleGameInfo.setContext(null);
/*     */       
/* 123 */       StringBuilder sb_1 = new StringBuilder();
/* 124 */       sb_1.append(String.format("[bubblegame]PStartBubbleGame.processImp@bubble game stop|roleid=%d|gameid=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(arg.completeTrunIndex), Integer.valueOf(arg.rightTurnNum), Long.valueOf(arg.gameStartTimeStamp) }));
/*     */       
/*     */ 
/* 127 */       BubbleGameManager.logger.info(sb_1.toString());
/*     */     }
/*     */     
/* 130 */     if ((cfg.point_upper_limit > 0) && (cfg.point_upper_limit <= this.currentPoint))
/*     */     {
/*     */ 
/* 133 */       onFail(-7, null);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     xBubbleGameInfo.setGame_state(1);
/* 139 */     if ((this.isRestartGame) || (xBubbleGameInfo.getStart_timestamp() <= 0L))
/*     */     {
/* 141 */       xBubbleGameInfo.setComplete_turn_index(0);
/* 142 */       xBubbleGameInfo.setRight_turn_num(0);
/* 143 */       xBubbleGameInfo.setStart_timestamp(now);
/* 144 */       xBubbleGameInfo.setContext(this.context);
/*     */     }
/* 146 */     if (xBubbleGameInfo.getSessionid() > 0L)
/*     */     {
/* 148 */       Session.removeSession(xBubbleGameInfo.getSessionid(), this.roleid);
/*     */     }
/* 150 */     xBubbleGameInfo.setSessionid(new ForceStopBubbleGameSession(cfg.tips_time + cfg.countdown_time + cfg.game_time - (int)((now - xBubbleGameInfo.getStart_timestamp()) / 1000L) + BubbleGameManager.GAME_PROTECT_TIME, this.roleid, this.gameid).getSessionId());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 155 */     SStartBubbleGame protocol = new SStartBubbleGame();
/* 156 */     protocol.game_id = this.gameid;
/* 157 */     protocol.complete_turn_index = xBubbleGameInfo.getComplete_turn_index();
/* 158 */     protocol.current_point = this.currentPoint;
/* 159 */     protocol.start_timestamp = ((int)(xBubbleGameInfo.getStart_timestamp() / 1000L));
/* 160 */     protocol.is_resume_game = (isResumeGame ? 1 : 0);
/* 161 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 163 */     StringBuilder sb = new StringBuilder();
/* 164 */     sb.append(String.format("[bubblegame]PStartBubbleGame.processImp@start bubble game success|roleid=%d|gameid=%d|is_restart_game=%b|current_point=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d|is_resume_game=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isRestartGame), Integer.valueOf(this.currentPoint), Integer.valueOf(xBubbleGameInfo.getComplete_turn_index()), Integer.valueOf(xBubbleGameInfo.getRight_turn_num()), Long.valueOf(xBubbleGameInfo.getStart_timestamp()), Boolean.valueOf(isResumeGame) }));
/*     */     
/*     */ 
/*     */ 
/* 168 */     BubbleGameManager.logger.info(sb.toString());
/* 169 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 174 */     StringBuilder sb = new StringBuilder();
/* 175 */     sb.append(String.format("[bubblegame]PStartBubbleGame.processImp@start bubble game fail|roleid=%d|gameid=%d|is_restart_game=%b|current_point=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isRestartGame), Integer.valueOf(this.currentPoint), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 178 */     if (extraInfo != null)
/*     */     {
/* 180 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 182 */         sb.append("|").append((String)entry.getKey());
/* 183 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 186 */     BubbleGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\PStartBubbleGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */