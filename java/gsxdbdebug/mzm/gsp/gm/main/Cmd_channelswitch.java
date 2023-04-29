/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.idip.main.PGMChannelSwitch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_channelswitch
/*    */   extends CmdBase
/*    */ {
/*    */   private String channel;
/*    */   private int open;
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
/* 27 */     this.channel = ((String)this.m_arguments.get(index++));
/* 28 */     if (index >= this.m_arguments.size()) {
/* 29 */       return false;
/*    */     }
/* 31 */     Integer I_open = parseInt((String)this.m_arguments.get(index++));
/* 32 */     if (I_open == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     this.open = I_open.intValue();
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
/*    */ 
/*    */   protected void run()
/*    */   {
/* 56 */     new PGMChannelSwitch(this.m_gmRole.getRoleid(), this.channel, this.open).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_channelswitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */