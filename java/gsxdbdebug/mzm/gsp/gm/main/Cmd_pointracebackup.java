/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.point.PGM_PointRaceBackup;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_pointracebackup
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityCfgid;
/*    */   private int zone;
/*    */   private int curIndex;
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
/* 28 */     Integer I_activityCfgid = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_activityCfgid == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.activityCfgid = I_activityCfgid.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_zone = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_zone == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.zone = I_zone.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_curIndex = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_curIndex == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.curIndex = I_curIndex.intValue();
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
/* 71 */     new PGM_PointRaceBackup(this.m_gmRole.getRoleid(), this.activityCfgid, this.zone, this.curIndex).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_pointracebackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */