/*     */ package mzm.gsp.bubblegame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bubblegame.SStopBubbleGame;
/*     */ import mzm.gsp.bubblegame.confbean.SBubbleGameCfg;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameOver;
/*     */ import mzm.gsp.bubblegame.event.BubbleGameOverArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
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
/*     */ public class PStopBubbleGame extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final boolean isRoleActive;
/*     */   
/*     */   public PStopBubbleGame(long roleid, int gameid, boolean isRoleActive)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.gameid = gameid;
/*  36 */     this.isRoleActive = isRoleActive;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(this.gameid);
/*  43 */     if (cfg == null)
/*     */     {
/*     */ 
/*  46 */       onFail(-3, null);
/*  47 */       return false;
/*     */     }
/*  49 */     if (!BubbleGameManager.isBubblecGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  52 */       onFail(-1, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if ((this.isRoleActive) && (!BubbleGameManager.checkRoleStatus(this.roleid, 702)))
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
/*     */ 
/*  72 */       onFail(-4, null);
/*  73 */       return false;
/*     */     }
/*  75 */     BubbleGameInfo xBubbleGameInfo = (BubbleGameInfo)xRoleBubbleGameInfo.getBubble_game_infos().get(Integer.valueOf(this.gameid));
/*  76 */     if (xBubbleGameInfo == null)
/*     */     {
/*     */ 
/*  79 */       onFail(-4, null);
/*  80 */       return false;
/*     */     }
/*  82 */     if ((xBubbleGameInfo.getGame_state() != 1) || (xBubbleGameInfo.getComplete_turn_index() >= cfg.turn_sum))
/*     */     {
/*     */ 
/*     */ 
/*  86 */       onFail(-4, null);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     Map.Entry<Integer, Integer> entry = cfg.right_sum_award_info.floorEntry(Integer.valueOf(xBubbleGameInfo.getRight_turn_num()));
/*  92 */     if ((entry != null) && (((Integer)entry.getValue()).intValue() > 0))
/*     */     {
/*  94 */       AwardReason awardReason = new AwardReason(LogReason.BUBBLE_GAME_RIGHT_SUM_AWARD, this.gameid);
/*  95 */       mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(((Integer)entry.getValue()).intValue(), userid, this.roleid, false, true, awardReason);
/*  96 */       if (awardModel == null)
/*     */       {
/*     */ 
/*  99 */         onFail(-6, null);
/* 100 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 104 */     BubbleGameOverArg arg = new BubbleGameOverArg(this.roleid, this.gameid, xBubbleGameInfo.getComplete_turn_index(), xBubbleGameInfo.getRight_turn_num(), xBubbleGameInfo.getStart_timestamp(), xBubbleGameInfo.getContext());
/*     */     
/*     */ 
/* 107 */     TriggerEventsManger.getInstance().triggerEvent(new BubbleGameOver(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/* 110 */     xBubbleGameInfo.setGame_state(2);
/* 111 */     xBubbleGameInfo.setComplete_turn_index(0);
/* 112 */     xBubbleGameInfo.setRight_turn_num(0);
/* 113 */     Session.removeSession(xBubbleGameInfo.getSessionid(), this.roleid);
/* 114 */     xBubbleGameInfo.setSessionid(-1L);
/* 115 */     xBubbleGameInfo.setStart_timestamp(-1L);
/* 116 */     xBubbleGameInfo.setContext(null);
/*     */     
/* 118 */     SStopBubbleGame protocol = new SStopBubbleGame();
/* 119 */     protocol.game_id = this.gameid;
/* 120 */     protocol.res = 1;
/* 121 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 123 */     StringBuilder sb = new StringBuilder();
/* 124 */     sb.append(String.format("[bubblegame]PStopBubbleGame.processImp@stop bubble game success|roleid=%d|gameid=%d|is_role_active=%b|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isRoleActive), Integer.valueOf(arg.completeTrunIndex), Integer.valueOf(arg.rightTurnNum), Long.valueOf(arg.gameStartTimeStamp) }));
/*     */     
/*     */ 
/* 127 */     BubbleGameManager.logger.info(sb.toString());
/* 128 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 133 */     StringBuilder sb = new StringBuilder();
/* 134 */     sb.append(String.format("[musicgame]PStopBubbleGame.processImp@stop bubble game fail|roleid=%d|gameid=%d|is_role_active=%b|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isRoleActive), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 137 */     if (extraInfo != null)
/*     */     {
/* 139 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 141 */         sb.append("|").append((String)entry.getKey());
/* 142 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 145 */     BubbleGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\PStopBubbleGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */