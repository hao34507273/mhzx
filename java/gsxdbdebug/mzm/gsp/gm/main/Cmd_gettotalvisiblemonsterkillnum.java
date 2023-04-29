/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.visiblemonsterfight.main.PGM_GetTotalVisibleMonsterKillNum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_gettotalvisiblemonsterkillnum
/*    */   extends CmdBase
/*    */ {
/*    */   private int activity_cfg_id;
/*    */   private int monster_type;
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
/* 27 */     Integer I_activity_cfg_id = parseInt((String)this.m_arguments.get(index++));
/* 28 */     if (I_activity_cfg_id == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     this.activity_cfg_id = I_activity_cfg_id.intValue();
/*    */     
/* 33 */     if (index >= this.m_arguments.size()) {
/* 34 */       return false;
/*    */     }
/* 36 */     Integer I_monster_type = parseInt((String)this.m_arguments.get(index++));
/* 37 */     if (I_monster_type == null) {
/* 38 */       return false;
/*    */     }
/* 40 */     this.monster_type = I_monster_type.intValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 61 */     new PGM_GetTotalVisibleMonsterKillNum(this.m_gmRole.getRoleid(), this.activity_cfg_id, this.monster_type).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_gettotalvisiblemonsterkillnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */