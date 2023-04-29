/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.PGM_setbangzhongduty;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_setbangzhongduty
/*    */   extends CmdBase
/*    */ {
/*    */   private long gangid;
/*    */   private long bangzhongid;
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
/* 27 */     Long L_gangid = parseLong((String)this.m_arguments.get(index++));
/* 28 */     if (L_gangid == null)
/* 29 */       return false;
/* 30 */     this.gangid = L_gangid.longValue();
/*    */     
/* 32 */     if (index >= this.m_arguments.size()) {
/* 33 */       return false;
/*    */     }
/* 35 */     Long L_bangzhongid = parseLong((String)this.m_arguments.get(index++));
/* 36 */     if (L_bangzhongid == null)
/* 37 */       return false;
/* 38 */     this.bangzhongid = L_bangzhongid.longValue();
/*    */     
/* 40 */     if (index != this.m_arguments.size()) {
/* 41 */       return false;
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 59 */     new PGM_setbangzhongduty(this.m_gmRole.getRoleid(), this.gangid, this.bangzhongid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setbangzhongduty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */