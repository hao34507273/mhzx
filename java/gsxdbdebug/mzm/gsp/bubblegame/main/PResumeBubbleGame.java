/*     */ package mzm.gsp.bubblegame.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.bubblegame.SStartBubbleGame;
/*     */ import mzm.gsp.bubblegame.confbean.SBubbleGameCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BubbleGameInfo;
/*     */ import xbean.RoleBubbleGameInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_bubble_game_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PResumeBubbleGame extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int gameid;
/*     */   private final int currentPoint;
/*     */   
/*     */   public PResumeBubbleGame(long roleid, int gameid, int currentPoint)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.gameid = gameid;
/*  28 */     this.currentPoint = currentPoint;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     SBubbleGameCfg cfg = SBubbleGameCfg.get(this.gameid);
/*  35 */     if (cfg == null)
/*     */     {
/*     */ 
/*  38 */       onFail(-3, null);
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!BubbleGameManager.isBubblecGameSwitchOpenForRole(this.roleid, this.gameid))
/*     */     {
/*     */ 
/*  45 */       onFail(-1, null);
/*  46 */       return false;
/*     */     }
/*  48 */     if (!BubbleGameManager.checkRoleStatus(this.roleid, 701))
/*     */     {
/*     */ 
/*  51 */       onFail(-2, null);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  57 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  59 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  61 */     RoleBubbleGameInfo xRoleBubbleGameInfo = Role_bubble_game_infos.get(Long.valueOf(this.roleid));
/*  62 */     if (xRoleBubbleGameInfo == null)
/*     */     {
/*     */ 
/*  65 */       onFail(-4, null);
/*  66 */       return false;
/*     */     }
/*  68 */     BubbleGameInfo xBubbleGameInfo = (BubbleGameInfo)xRoleBubbleGameInfo.getBubble_game_infos().get(Integer.valueOf(this.gameid));
/*  69 */     if (xBubbleGameInfo == null)
/*     */     {
/*     */ 
/*  72 */       onFail(-4, null);
/*  73 */       return false;
/*     */     }
/*  75 */     if ((xBubbleGameInfo.getGame_state() != 1) || (xBubbleGameInfo.getComplete_turn_index() >= cfg.turn_sum))
/*     */     {
/*     */ 
/*     */ 
/*  79 */       onFail(-4, null);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if ((cfg.point_upper_limit > 0) && (cfg.point_upper_limit <= this.currentPoint))
/*     */     {
/*     */ 
/*  86 */       onFail(-7, null);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     SStartBubbleGame protocol = new SStartBubbleGame();
/*  92 */     protocol.game_id = this.gameid;
/*  93 */     protocol.complete_turn_index = xBubbleGameInfo.getComplete_turn_index();
/*  94 */     protocol.current_point = this.currentPoint;
/*  95 */     protocol.start_timestamp = ((int)(xBubbleGameInfo.getStart_timestamp() / 1000L));
/*  96 */     protocol.is_resume_game = 1;
/*  97 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  99 */     StringBuilder sb = new StringBuilder();
/* 100 */     sb.append(String.format("[bubblegame]PResumeBubbleGame.processImp@resume bubble game success|roleid=%d|gameid=%d|current_point=%d|complete_turn_index=%d|right_turn_num=%d|start_timestamp=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(this.currentPoint), Integer.valueOf(xBubbleGameInfo.getComplete_turn_index()), Integer.valueOf(xBubbleGameInfo.getRight_turn_num()), Long.valueOf(xBubbleGameInfo.getStart_timestamp()) }));
/*     */     
/*     */ 
/*     */ 
/* 104 */     BubbleGameManager.logger.info(sb.toString());
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 110 */     StringBuilder sb = new StringBuilder();
/* 111 */     sb.append(String.format("[bubblegame]PResumeBubbleGame.processImp@resume bubble game fail|roleid=%d|gameid=%d|current_point=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.gameid), Integer.valueOf(this.currentPoint), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 114 */     if (extraInfo != null)
/*     */     {
/* 116 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 118 */         sb.append("|").append((String)entry.getKey());
/* 119 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 122 */     BubbleGameManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\main\PResumeBubbleGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */