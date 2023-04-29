/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnPvPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 14 */       syncRoleProperty(roleId);
/*    */     }
/*    */     
/* 17 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 19 */       syncRoleProperty(roleId);
/*    */     }
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   private void syncRoleProperty(final long roleId)
/*    */   {
/* 26 */     LogicProcedure p = new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 31 */         RoleOutFightObj obj = RoleInterface.getRoleOutFightObject(roleId);
/* 32 */         obj.syncClientRoleProperty();
/* 33 */         return false;
/*    */       }
/* 35 */     };
/* 36 */     p.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnPvPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */