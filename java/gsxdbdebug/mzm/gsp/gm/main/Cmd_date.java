/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_date extends CmdBase
/*    */ {
/*  7 */   private String value = "";
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
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return true;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return true;
/*    */     }
/* 26 */     this.value = ((String)this.m_arguments.get(index++));
/* 27 */     if (index != this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 45 */     if (this.value.isEmpty())
/*    */     {
/* 47 */       long currTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 48 */       java.text.SimpleDateFormat sdf = mzm.gsp.util.DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 49 */       GmManager.getInstance().sendResultToGM(this.m_gmRole.getRoleid(), sdf.format(new java.util.Date(currTime)));
/*    */       
/* 51 */       return;
/*    */     }
/*    */     
/* 54 */     mzm.gsp.GameServerInfoManager.setDateForGM(this.value, this.m_gmRole.getRoleid());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */