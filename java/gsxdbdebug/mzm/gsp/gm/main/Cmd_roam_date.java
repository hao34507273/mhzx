/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_roam_date extends CmdBase
/*    */ {
/*    */   private String value;
/*  8 */   private int roam_zoneid = 0;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 27 */     this.value = ((String)this.m_arguments.get(index++));
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return true;
/*    */     }
/* 31 */     Integer I_roam_zoneid = parseInt((String)this.m_arguments.get(index++));
/* 32 */     if (I_roam_zoneid == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     this.roam_zoneid = I_roam_zoneid.intValue();
/*    */     
/* 37 */     if (index != this.m_arguments.size()) {
/* 38 */       return false;
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 55 */     if (!mzm.gsp.GameServerInfoManager.setDateForGM(this.value, this.m_gmRole.getRoleid()))
/*    */     {
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     mzm.gsp.crossserver.main.CrossServerInterface.setRoamServerDateForGM(this.roam_zoneid, this.value);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_roam_date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */