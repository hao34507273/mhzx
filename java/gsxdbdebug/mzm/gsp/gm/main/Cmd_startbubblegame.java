/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.bubblegame.main.PGM_StartBubbleGame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_startbubblegame
/*    */   extends CmdBase
/*    */ {
/*    */   private int game_id;
/*    */   private int is_restart_game;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 19 */     if (this.m_arguments == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int index = 0;
/*    */     
/* 24 */     if (index >= this.m_arguments.size()) {
/* 25 */       return false;
/*    */     }
/* 27 */     Integer I_game_id = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_game_id == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.game_id = I_game_id.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_is_restart_game = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_is_restart_game == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.is_restart_game = I_is_restart_game.intValue();
/*    */     
/* 42 */     if (index != this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 60 */     new PGM_StartBubbleGame(this.m_gmRole.getRoleid(), this.game_id, this.is_restart_game == 1).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_startbubblegame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */