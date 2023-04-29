/*     */ package mzm.gsp.musicgame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.musicgame.SStopMusicGame;
/*     */ import mzm.gsp.musicgame.confbean.SMusicGameCfg;
/*     */ import mzm.gsp.musicgame.event.ClientReportMusicGameResult;
/*     */ import mzm.gsp.musicgame.event.ClientReportMusicGameResultArg;
/*     */ import mzm.gsp.musicgame.event.MusicGameOver;
/*     */ import mzm.gsp.musicgame.event.MusicGameOverArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MusicGameInfo;
/*     */ import xbean.RoleMusicGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_music_game_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PReportMusicGameResult extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final int turnIndex;
/*     */   private final int result;
/*     */   
/*     */   public PReportMusicGameResult(long roleid, int gameid, int turnIndex, int result)
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
/*  46 */     SMusicGameCfg cfg = SMusicGameCfg.get(this.gameid);
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
/*  60 */     if (!MusicGameManager.isMusicGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  63 */       onFail(-1, null);
/*  64 */       return false;
/*     */     }
/*  66 */     if (!MusicGameManager.checkRoleStatus(this.roleid, 583))
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
/*  79 */     RoleMusicGameInfo xRoleMusicGameInfo = Role_music_game_infos.get(Long.valueOf(this.roleid));
/*  80 */     if (xRoleMusicGameInfo == null)
/*     */     {
/*     */ 
/*  83 */       onFail(-4, null);
/*  84 */       return false;
/*     */     }
/*  86 */     MusicGameInfo xMusicGameInfo = (MusicGameInfo)xRoleMusicGameInfo.getMusic_game_infos().get(Integer.valueOf(this.gameid));
/*  87 */     if (xMusicGameInfo == null)
/*     */     {
/*     */ 
/*  90 */       onFail(-4, null);
/*  91 */       return false;
/*     */     }
/*  93 */     if ((xMusicGameInfo.getGame_state() != 1) || (xMusicGameInfo.getComplete_turn_index() >= cfg.turn_sum))
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
/* 106 */         AwardReason awardReason = new AwardReason(LogReason.MUSIC_GAME_RIGHT_AWARD, this.gameid);
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
/* 121 */       AwardReason awardReason = new AwardReason(LogReason.MUSIC_GAME_WRONG_AWARD, this.gameid);
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
/* 133 */     xMusicGameInfo.setComplete_turn_index(xMusicGameInfo.getComplete_turn_index() + 1);
/* 134 */     xMusicGameInfo.setRight_turn_num(xMusicGameInfo.getRight_turn_num() + (this.result == 0 ? 1 : 0));
/*     */     
/*     */ 
/* 137 */     TriggerEventsManger.getInstance().triggerEvent(new ClientReportMusicGameResult(), new ClientReportMusicGameResultArg(this.roleid, this.gameid, this.result == 0, xMusicGameInfo.getContext()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */     StringBuilder sb = new StringBuilder();
/* 145 */     sb.append(String.format("[musicgame]PReportMusicGameResult.processImp@report music game result success|roleid=%d|gameid=%d|turn_index=%d|result=%d|complete_turn_index=%d|right_turn_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(this.turnIndex), Integer.valueOf(this.result), Integer.valueOf(xMusicGameInfo.getComplete_turn_index()), Integer.valueOf(xMusicGameInfo.getRight_turn_num()) }));
/*     */     
/*     */ 
/*     */ 
/* 149 */     MusicGameManager.logger.info(sb.toString());
/*     */     
/*     */ 
/* 152 */     if (xMusicGameInfo.getComplete_turn_index() >= cfg.turn_sum)
/*     */     {
/* 154 */       Map.Entry<Integer, Integer> entry = cfg.right_sum_award_info.floorEntry(Integer.valueOf(xMusicGameInfo.getRight_turn_num()));
/* 155 */       if ((entry != null) && (((Integer)entry.getValue()).intValue() > 0))
/*     */       {
/* 157 */         AwardReason awardReason = new AwardReason(LogReason.MUSIC_GAME_RIGHT_SUM_AWARD, this.gameid);
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
/* 168 */       MusicGameOverArg arg = new MusicGameOverArg(this.roleid, this.gameid, xMusicGameInfo.getComplete_turn_index(), xMusicGameInfo.getRight_turn_num(), xMusicGameInfo.getStart_timestamp(), xMusicGameInfo.getContext());
/*     */       
/*     */ 
/*     */ 
/* 172 */       TriggerEventsManger.getInstance().triggerEvent(new MusicGameOver(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/* 175 */       xMusicGameInfo.setGame_state(2);
/* 176 */       xMusicGameInfo.setComplete_turn_index(0);
/* 177 */       xMusicGameInfo.setRight_turn_num(0);
/* 178 */       Session.removeSession(xMusicGameInfo.getSessionid(), this.roleid);
/* 179 */       xMusicGameInfo.setSessionid(-1L);
/* 180 */       xMusicGameInfo.setStart_timestamp(-1L);
/* 181 */       xMusicGameInfo.setContext(null);
/*     */       
/* 183 */       SStopMusicGame protocol = new SStopMusicGame();
/* 184 */       protocol.game_id = this.gameid;
/* 185 */       protocol.res = 1;
/* 186 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 188 */       StringBuilder sb_1 = new StringBuilder();
/* 189 */       sb_1.append(String.format("[musicgame]PReportMusicGameResult.processImp@music game stop|roleid=%d|gameid=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(arg.completeTrunIndex), Integer.valueOf(arg.rightTurnNum), Long.valueOf(arg.gameStartTimeStamp) }));
/*     */       
/*     */ 
/* 192 */       MusicGameManager.logger.info(sb_1.toString());
/*     */     }
/* 194 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 199 */     StringBuilder sb = new StringBuilder();
/* 200 */     sb.append(String.format("[musicgame]PReportMusicGameResult.processImp@report music game result fail|roleid=%d|gameid=%d|turn_index=%d|result=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(this.turnIndex), Integer.valueOf(this.result), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 203 */     if (extraInfo != null)
/*     */     {
/* 205 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 207 */         sb.append("|").append((String)entry.getKey());
/* 208 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 211 */     MusicGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\main\PReportMusicGameResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */