/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.pk.event.MoralValueChangeArg;
/*    */ import mzm.gsp.pk.event.MoralValueChangedProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.wanted.SNotifyWanted;
/*    */ 
/*    */ public class POnRoleMoralValueChanged extends MoralValueChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if (((MoralValueChangeArg)this.arg).newValue > SPKConsts.getInstance().WANTED_MORAL_VALUE)
/*    */     {
/* 19 */       if (RoleStatusInterface.containsStatus(((MoralValueChangeArg)this.arg).roleId, 1651, true))
/*    */       {
/*    */ 
/* 22 */         RoleStatusInterface.unsetStatus(((MoralValueChangeArg)this.arg).roleId, 1651);
/*    */         
/* 24 */         WantedInterface.removeRoleWantedInfo(((MoralValueChangeArg)this.arg).roleId);
/*    */       }
/* 26 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 31 */     if (RoleStatusInterface.containsStatus(((MoralValueChangeArg)this.arg).roleId, 1651, true))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     RoleStatusInterface.setStatus(((MoralValueChangeArg)this.arg).roleId, 1651, false);
/*    */     
/*    */ 
/* 40 */     WantedInterface.addRoleWantedInfo(((MoralValueChangeArg)this.arg).roleId);
/*    */     
/* 42 */     if (OpenInterface.getOpenStatus(412))
/*    */     {
/* 44 */       SNotifyWanted notifyWanted = new SNotifyWanted();
/* 45 */       notifyWanted.name.setString(RoleInterface.getName(((MoralValueChangeArg)this.arg).roleId), "utf-8");
/* 46 */       OnlineManager.getInstance().sendAll(notifyWanted);
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnRoleMoralValueChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */