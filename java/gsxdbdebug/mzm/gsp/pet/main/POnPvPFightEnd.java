/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnPvPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 10 */       syncRolePetProperty(roleId);
/* 11 */       xdb.Procedure.execute(new PPetLifeTooLow(roleId));
/*    */     }
/* 13 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).passiveRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 14 */       syncRolePetProperty(roleId);
/* 15 */       xdb.Procedure.execute(new PPetLifeTooLow(roleId));
/*    */     }
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   private void syncRolePetProperty(final long roleId)
/*    */   {
/* 22 */     mzm.gsp.util.LogicProcedure lp = new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 26 */         xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(roleId));
/* 27 */         if (xPetBag == null) {
/* 28 */           return false;
/*    */         }
/* 30 */         long fightPet = xPetBag.getFightpet();
/* 31 */         if (fightPet > 0L)
/*    */         {
/* 33 */           PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(roleId, fightPet);
/* 34 */           if (petOutFightObj != null) {
/* 35 */             petOutFightObj.syncPetInfo();
/*    */           }
/*    */         }
/*    */         
/* 39 */         xbean.Role2PetBean xRole2petbean = xtable.Role2petoutfightbean.get(Long.valueOf(roleId));
/* 40 */         if (xRole2petbean != null) {
/* 41 */           mzm.gsp.util.LogicProcedure lp = xRole2petbean.getAction();
/* 42 */           if (lp != null) {
/* 43 */             xdb.Procedure.execute(lp);
/*    */           }
/* 45 */           xRole2petbean.setAction(null);
/*    */         }
/*    */         
/* 48 */         return true;
/*    */       }
/* 50 */     };
/* 51 */     xdb.Procedure.execute(lp);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPvPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */