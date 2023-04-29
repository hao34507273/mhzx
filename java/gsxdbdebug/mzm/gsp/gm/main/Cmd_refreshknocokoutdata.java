/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.knockout.PGM_RefreshKnockOutFightZoneInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_refreshknocokoutdata
/*    */   extends CmdBase
/*    */ {
/*    */   private int activityCfgId;
/*    */   private int knockOutType;
/*    */   private int refreshFightZone;
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
/* 28 */     Integer I_activityCfgId = parseInt((String)this.m_arguments.get(index++));
/* 29 */     if (I_activityCfgId == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     this.activityCfgId = I_activityCfgId.intValue();
/*    */     
/* 34 */     if (index >= this.m_arguments.size()) {
/* 35 */       return false;
/*    */     }
/* 37 */     Integer I_knockOutType = parseInt((String)this.m_arguments.get(index++));
/* 38 */     if (I_knockOutType == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     this.knockOutType = I_knockOutType.intValue();
/*    */     
/* 43 */     if (index >= this.m_arguments.size()) {
/* 44 */       return false;
/*    */     }
/* 46 */     Integer I_refreshFightZone = parseInt((String)this.m_arguments.get(index++));
/* 47 */     if (I_refreshFightZone == null) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.refreshFightZone = I_refreshFightZone.intValue();
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
/* 71 */     new PGM_RefreshKnockOutFightZoneInfo(this.m_gmRole.getRoleid(), this.activityCfgId, this.knockOutType, this.refreshFightZone).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_refreshknocokoutdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */