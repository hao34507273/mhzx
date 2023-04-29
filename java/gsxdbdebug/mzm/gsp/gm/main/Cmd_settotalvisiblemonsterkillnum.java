/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.visiblemonsterfight.main.PGM_SetTotalVisibleMonsterKillNum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_settotalvisiblemonsterkillnum
/*    */   extends CmdBase
/*    */ {
/*    */   private int activity_cfg_id;
/*    */   private int monster_type;
/*    */   private int monster_kill_times;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 20 */     if (this.m_arguments == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     int index = 0;
/*    */     
/* 25 */     if (index >= this.m_arguments.size()) {
/* 26 */       return false;
/*    */     }
/* 28 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_activity_cfg_id == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_monster_type = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_monster_type == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.monster_type = I_monster_type.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_monster_kill_times = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_monster_kill_times == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.monster_kill_times = I_monster_kill_times.intValue();
/*    */     
/* 52 */     if (index != this.m_arguments.size()) {
/* 53 */       return false;
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 71 */     new PGM_SetTotalVisibleMonsterKillNum(this.m_gmRole.getRoleid(), this.activity_cfg_id, this.monster_type, this.monster_kill_times).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_settotalvisiblemonsterkillnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */