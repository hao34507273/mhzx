/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.prison.main.PrisonPageManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.WantedInfo;
/*    */ import xtable.Role2wantedinfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     WantedInfo xWantedInfo = Role2wantedinfo.get((Long)this.arg);
/*    */     
/* 15 */     if (WantedInterface.isHongMing(((Long)this.arg).longValue()))
/*    */     {
/* 17 */       if (!RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 1651, true))
/*    */       {
/* 19 */         RoleStatusInterface.setStatus(((Long)this.arg).longValue(), 1651, false);
/*    */       }
/*    */       
/* 22 */       if ((xWantedInfo != null) && (!PrisonPageManager.getInstance().containsRecord(this.arg)))
/*    */       {
/* 24 */         WantedPageManager.getInstance().addRoleToWantedList(((Long)this.arg).longValue(), xWantedInfo);
/*    */       }
/*    */       
/* 27 */       if ((xWantedInfo == null) && (!PrisonPageManager.getInstance().containsRecord(this.arg)))
/*    */       {
/* 29 */         WantedInterface.addRoleWantedInfo(((Long)this.arg).longValue());
/*    */       }
/*    */       
/*    */ 
/* 33 */       WantedManager.startNPCFightSession(((Long)this.arg).longValue(), xWantedInfo);
/*    */     }
/*    */     else
/*    */     {
/* 37 */       if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 1651, true))
/*    */       {
/* 39 */         RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 1651);
/*    */       }
/*    */       
/* 42 */       if (xWantedInfo != null)
/*    */       {
/* 44 */         WantedInterface.removeRoleWantedInfo(((Long)this.arg).longValue());
/*    */       }
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */