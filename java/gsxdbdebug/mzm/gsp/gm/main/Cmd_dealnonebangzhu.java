/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gang.main.RGM_dealnonebangzhu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_dealnonebangzhu
/*    */   extends CmdBase
/*    */ {
/*    */   private long gangid;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 18 */     if (this.m_arguments == null) {
/* 19 */       return false;
/*    */     }
/* 21 */     int index = 0;
/*    */     
/* 23 */     if (index >= this.m_arguments.size()) {
/* 24 */       return false;
/*    */     }
/* 26 */     Long L_gangid = parseLong((String)this.m_arguments.get(index++));
/* 27 */     if (L_gangid == null)
/* 28 */       return false;
/* 29 */     this.gangid = L_gangid.longValue();
/*    */     
/* 31 */     if (index != this.m_arguments.size()) {
/* 32 */       return false;
/*    */     }
/* 34 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 50 */     new RGM_dealnonebangzhu(this.m_gmRole.getRoleid(), this.gangid).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_dealnonebangzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */