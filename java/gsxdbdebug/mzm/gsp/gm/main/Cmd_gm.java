/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import xbean.GMStatus;
/*    */ 
/*    */ public class Cmd_gm extends CmdBase {
/*    */   protected boolean parse() {
/*  7 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 13 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 19 */     long gmId = this.m_gmRole.getRoleid();
/*    */     
/* 21 */     if (this.m_arguments.size() != 1)
/*    */     {
/* 23 */       sendError("格式错误");
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     if (((String)this.m_arguments.get(0)).equals("on"))
/*    */     {
/* 29 */       GMStatus gmStatus = xtable.Gmstatus.get(Long.valueOf(gmId));
/* 30 */       if (gmStatus == null)
/*    */       {
/* 32 */         gmStatus = xbean.Pod.newGMStatus();
/* 33 */         xtable.Gmstatus.insert(Long.valueOf(gmId), gmStatus);
/*    */       }
/*    */       
/* 36 */       gmStatus.setStatus(1);
/*    */       
/* 38 */       mzm.gsp.gm.SUserIsGM data = new mzm.gsp.gm.SUserIsGM();
/* 39 */       mzm.gsp.online.main.OnlineManager.getInstance().send(this.m_gmRole.getRoleid(), data);
/* 40 */       return;
/*    */     }
/* 42 */     if (((String)this.m_arguments.get(0)).equals("off"))
/*    */     {
/* 44 */       GMStatus gmStatus = xtable.Gmstatus.get(Long.valueOf(gmId));
/* 45 */       if (gmStatus == null) {
/* 46 */         return;
/*    */       }
/* 48 */       gmStatus.setStatus(2);
/* 49 */       return;
/*    */     }
/*    */     
/* 52 */     sendError("格式错误");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */