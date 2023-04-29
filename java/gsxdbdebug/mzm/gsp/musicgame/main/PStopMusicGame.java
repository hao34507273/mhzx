/*     */ package mzm.gsp.musicgame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.musicgame.SStopMusicGame;
/*     */ import mzm.gsp.musicgame.confbean.SMusicGameCfg;
/*     */ import mzm.gsp.musicgame.event.MusicGameOver;
/*     */ import mzm.gsp.musicgame.event.MusicGameOverArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MusicGameInfo;
/*     */ import xbean.RoleMusicGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_music_game_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PStopMusicGame extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final boolean isPauseGame;
/*     */   private final boolean isRoleActive;
/*     */   
/*     */   public PStopMusicGame(long roleid, int gameid, boolean isPauseGame, boolean isRoleActive)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.gameid = gameid;
/*  38 */     this.isPauseGame = isPauseGame;
/*  39 */     this.isRoleActive = isRoleActive;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     SMusicGameCfg cfg = SMusicGameCfg.get(this.gameid);
/*  46 */     if (cfg == null)
/*     */     {
/*     */ 
/*  49 */       onFail(-3, null);
/*  50 */       return false;
/*     */     }
/*  52 */     if (!MusicGameManager.isMusicGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  55 */       onFail(-1, null);
/*  56 */       return false;
/*     */     }
/*  58 */     if ((this.isRoleActive) && (!MusicGameManager.checkRoleStatus(this.roleid, 582)))
/*     */     {
/*     */ 
/*  61 */       onFail(-2, null);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  67 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  69 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  71 */     RoleMusicGameInfo xRoleMusicGameInfo = Role_music_game_infos.get(Long.valueOf(this.roleid));
/*  72 */     if (xRoleMusicGameInfo == null)
/*     */     {
/*     */ 
/*  75 */       onFail(-4, null);
/*  76 */       return false;
/*     */     }
/*  78 */     MusicGameInfo xMusicGameInfo = (MusicGameInfo)xRoleMusicGameInfo.getMusic_game_infos().get(Integer.valueOf(this.gameid));
/*  79 */     if (xMusicGameInfo == null)
/*     */     {
/*     */ 
/*  82 */       onFail(-4, null);
/*  83 */       return false;
/*     */     }
/*  85 */     if ((xMusicGameInfo.getGame_state() != 1) || (xMusicGameInfo.getComplete_turn_index() >= cfg.turn_sum))
/*     */     {
/*     */ 
/*     */ 
/*  89 */       onFail(-4, null);
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     xMusicGameInfo.setGame_state(2);
/*  94 */     Session.removeSession(xMusicGameInfo.getSessionid(), this.roleid);
/*  95 */     xMusicGameInfo.setSessionid(-1L);
/*     */     
/*     */ 
/*  98 */     if (!this.isPauseGame)
/*     */     {
/* 100 */       Map.Entry<Integer, Integer> entry = cfg.right_sum_award_info.floorEntry(Integer.valueOf(xMusicGameInfo.getRight_turn_num()));
/* 101 */       if ((entry != null) && (((Integer)entry.getValue()).intValue() > 0))
/*     */       {
/* 103 */         AwardReason awardReason = new AwardReason(LogReason.MUSIC_GAME_RIGHT_SUM_AWARD, this.gameid);
/* 104 */         mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(((Integer)entry.getValue()).intValue(), userid, this.roleid, false, true, awardReason);
/*     */         
/* 106 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 109 */           onFail(-6, null);
/* 110 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 114 */       MusicGameOverArg arg = new MusicGameOverArg(this.roleid, this.gameid, xMusicGameInfo.getComplete_turn_index(), xMusicGameInfo.getRight_turn_num(), xMusicGameInfo.getStart_timestamp(), xMusicGameInfo.getContext());
/*     */       
/*     */ 
/*     */ 
/* 118 */       TriggerEventsManger.getInstance().triggerEvent(new MusicGameOver(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 121 */       xMusicGameInfo.setComplete_turn_index(0);
/* 122 */       xMusicGameInfo.setRight_turn_num(0);
/* 123 */       xMusicGameInfo.setStart_timestamp(-1L);
/* 124 */       xMusicGameInfo.setContext(null);
/*     */       
/* 126 */       StringBuilder sb_1 = new StringBuilder();
/* 127 */       sb_1.append(String.format("[musicgame]PStopMusicGame.processImp@music game stop|roleid=%d|gameid=%d|is_pause_game=%b|is_role_active=%b|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isPauseGame), Boolean.valueOf(this.isRoleActive), Integer.valueOf(arg.completeTrunIndex), Integer.valueOf(arg.rightTurnNum), Long.valueOf(arg.gameStartTimeStamp) }));
/*     */       
/*     */ 
/*     */ 
/* 131 */       MusicGameManager.logger.info(sb_1.toString());
/*     */     }
/* 133 */     SStopMusicGame protocol = new SStopMusicGame();
/* 134 */     protocol.game_id = this.gameid;
/* 135 */     protocol.res = (this.isPauseGame ? 2 : 1);
/* 136 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 138 */     StringBuilder sb = new StringBuilder();
/* 139 */     sb.append(String.format("[musicgame]PStopMusicGame.processImp@stop music game success|roleid=%d|gameid=%d|is_pause_game=%b|is_role_active=%b|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isPauseGame), Boolean.valueOf(this.isRoleActive), Integer.valueOf(xMusicGameInfo.getComplete_turn_index()), Integer.valueOf(xMusicGameInfo.getRight_turn_num()), Long.valueOf(xMusicGameInfo.getStart_timestamp()) }));
/*     */     
/*     */ 
/*     */ 
/* 143 */     MusicGameManager.logger.info(sb.toString());
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 149 */     StringBuilder sb = new StringBuilder();
/* 150 */     sb.append(String.format("[musicgame]PStopMusicGame.processImp@stop music game fail|roleid=%d|gameid=%d|is_pause_game=%b|is_role_active=%b|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Boolean.valueOf(this.isPauseGame), Boolean.valueOf(this.isRoleActive), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 153 */     if (extraInfo != null)
/*     */     {
/* 155 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 157 */         sb.append("|").append((String)entry.getKey());
/* 158 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 161 */     MusicGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\PStopMusicGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */