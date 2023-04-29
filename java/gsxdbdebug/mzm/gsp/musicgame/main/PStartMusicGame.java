/*     */ package mzm.gsp.musicgame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.musicgame.SStartMusicGame;
/*     */ import mzm.gsp.musicgame.confbean.SMusicGameCfg;
/*     */ import mzm.gsp.musicgame.event.MusicGameContext;
/*     */ import mzm.gsp.musicgame.event.MusicGameOver;
/*     */ import mzm.gsp.musicgame.event.MusicGameOverArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MusicGameInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMusicGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_music_game_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PStartMusicGame extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final boolean isRestartGame;
/*     */   private final int currentPoint;
/*     */   private final MusicGameContext context;
/*     */   
/*     */   public PStartMusicGame(long roleid, int gameid, boolean isRestartGame, int currentPoint, MusicGameContext context)
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
/*  49 */     if (!MusicGameManager.isMusicGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  52 */       onFail(-1, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if (!MusicGameManager.checkRoleStatus(this.roleid, 581))
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
/*  68 */     RoleMusicGameInfo xRoleMusicGameInfo = Role_music_game_infos.get(Long.valueOf(this.roleid));
/*  69 */     if (xRoleMusicGameInfo == null)
/*     */     {
/*  71 */       xRoleMusicGameInfo = Pod.newRoleMusicGameInfo();
/*  72 */       Role_music_game_infos.insert(Long.valueOf(this.roleid), xRoleMusicGameInfo);
/*     */     }
/*  74 */     MusicGameInfo xMusicGameInfo = (MusicGameInfo)xRoleMusicGameInfo.getMusic_game_infos().get(Integer.valueOf(this.gameid));
/*  75 */     if (xMusicGameInfo == null)
/*     */     {
/*  77 */       xMusicGameInfo = Pod.newMusicGameInfo();
/*  78 */       xRoleMusicGameInfo.getMusic_game_infos().put(Integer.valueOf(this.gameid), xMusicGameInfo);
/*     */     }
/*     */     
/*  81 */     SMusicGameCfg cfg = SMusicGameCfg.get(this.gameid);
/*  82 */     if (cfg == null)
/*     */     {
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  90 */     if ((xMusicGameInfo.getStart_timestamp() > 0L) && (this.isRestartGame))
/*     */     {
/*  92 */       Map.Entry<Integer, Integer> entry = cfg.right_sum_award_info.floorEntry(Integer.valueOf(xMusicGameInfo.getRight_turn_num()));
/*  93 */       if ((entry != null) && (((Integer)entry.getValue()).intValue() > 0))
/*     */       {
/*  95 */         AwardReason awardReason = new AwardReason(LogReason.MUSIC_GAME_RIGHT_SUM_AWARD, this.gameid);
/*  96 */         mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(((Integer)entry.getValue()).intValue(), userid, this.roleid, false, true, awardReason);
/*     */         
/*  98 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 101 */           onFail(-6, null);
/* 102 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 106 */       MusicGameOverArg arg = new MusicGameOverArg(this.roleid, this.gameid, xMusicGameInfo.getComplete_turn_index(), xMusicGameInfo.getRight_turn_num(), xMusicGameInfo.getStart_timestamp(), xMusicGameInfo.getContext());
/*     */       
/*     */ 
/*     */ 
/* 110 */       TriggerEventsManger.getInstance().triggerEvent(new MusicGameOver(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 113 */       xMusicGameInfo.setGame_state(2);
/* 114 */       xMusicGameInfo.setComplete_turn_index(0);
/* 115 */       xMusicGameInfo.setRight_turn_num(0);
/* 116 */       if (xMusicGameInfo.getSessionid() > 0L)
/*     */       {
/* 118 */         Session.removeSession(xMusicGameInfo.getSessionid(), this.roleid);
/* 119 */         xMusicGameInfo.setSessionid(-1L);
/*     */       }
/* 121 */       xMusicGameInfo.setStart_timestamp(-1L);
/* 122 */       xMusicGameInfo.setContext(null);
/*     */       
/* 124 */       StringBuilder sb_1 = new StringBuilder();
/* 125 */       sb_1.append(String.format("[musicgame]PStartMusicGame.processImp@music game stop|roleid=%d|gameid=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(arg.completeTrunIndex), Integer.valueOf(arg.rightTurnNum), Long.valueOf(arg.gameStartTimeStamp) }));
/*     */       
/*     */ 
/* 128 */       MusicGameManager.logger.info(sb_1.toString());
/*     */     }
/*     */     
/* 131 */     if ((cfg.point_upper_limit > 0) && (cfg.point_upper_limit <= this.currentPoint))
/*     */     {
/*     */ 
/* 134 */       onFail(-7, null);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     xMusicGameInfo.setGame_state(1);
/* 139 */     if ((this.isRestartGame) || (xMusicGameInfo.getStart_timestamp() < 0L))
/*     */     {
/* 141 */       xMusicGameInfo.setComplete_turn_index(0);
/* 142 */       xMusicGameInfo.setRight_turn_num(0);
/* 143 */       xMusicGameInfo.setStart_timestamp(now);
/* 144 */       xMusicGameInfo.setContext(this.context);
/*     */     }
/* 146 */     if (xMusicGameInfo.getSessionid() > 0L)
/*     */     {
/* 148 */       Session.removeSession(xMusicGameInfo.getSessionid(), this.roleid);
/*     */     }
/* 150 */     xMusicGameInfo.setSessionid(new ForceStopMusicGameSession((cfg.game_max_time_ms - (now - xMusicGameInfo.getStart_timestamp())) / 1000L, this.roleid, this.gameid).getSessionId());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 155 */     SStartMusicGame protocol = new SStartMusicGame();
/* 156 */     protocol.game_id = this.gameid;
/* 157 */     protocol.complete_turn_index = xMusicGameInfo.getComplete_turn_index();
/* 158 */     protocol.current_point = this.currentPoint;
/* 159 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 161 */     StringBuilder sb = new StringBuilder();
/* 162 */     sb.append(String.format("[musicgame]PStartMusicGame.processImp@start music game success|roleid=%d|gameid=%d|is_restart_game=%b|current_point=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isRestartGame), Integer.valueOf(this.currentPoint), Integer.valueOf(xMusicGameInfo.getComplete_turn_index()), Integer.valueOf(xMusicGameInfo.getRight_turn_num()), Long.valueOf(xMusicGameInfo.getStart_timestamp()) }));
/*     */     
/*     */ 
/*     */ 
/* 166 */     MusicGameManager.logger.info(sb.toString());
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 172 */     StringBuilder sb = new StringBuilder();
/* 173 */     sb.append(String.format("[musicgame]PStartMusicGame.processImp@start music game fail|roleid=%d|gameid=%d|is_restart_game=%b|current_point=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isRestartGame), Integer.valueOf(this.currentPoint), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 176 */     if (extraInfo != null)
/*     */     {
/* 178 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 180 */         sb.append("|").append((String)entry.getKey());
/* 181 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 184 */     MusicGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\PStartMusicGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */