/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ 
/*    */ public class POnPvEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).escapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 13 */       syncRoleProperty(roleId);
/*    */     }
/* 15 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).diedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 17 */       syncRoleProperty(roleId);
/*    */     }
/* 19 */     for (Iterator i$ = ((PVEFightEndArg)this.arg).alivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 21 */       syncRoleProperty(roleId);
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private void syncRoleProperty(final long roleId)
/*    */   {
/* 28 */     mzm.gsp.util.LogicProcedure p = new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 33 */         RoleOutFightObj obj = RoleInterface.getRoleOutFightObject(roleId);
/* 34 */         obj.syncClientRoleProperty();
/* 35 */         return false;
/*    */       }
/* 37 */     };
/* 38 */     p.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */