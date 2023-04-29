/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnPvEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVEFightEndArg)this.arg).escapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 10 */       syncRolePetProperty(roleId);
/* 11 */       xdb.Procedure.execute(new PPetLifeTooLow(roleId));
/*    */     }
/* 13 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVEFightEndArg)this.arg).diedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 14 */       syncRolePetProperty(roleId);
/* 15 */       xdb.Procedure.execute(new PPetLifeTooLow(roleId));
/*    */     }
/* 17 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVEFightEndArg)this.arg).alivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 18 */       syncRolePetProperty(roleId);
/* 19 */       xdb.Procedure.execute(new PPetLifeTooLow(roleId));
/*    */     }
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   private void syncRolePetProperty(final long roleId) {
/* 25 */     mzm.gsp.util.LogicProcedure lp = new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 29 */         xbean.PetBag xPetBag = xtable.Role2petbag.get(Long.valueOf(roleId));
/* 30 */         if (xPetBag == null) {
/* 31 */           return false;
/*    */         }
/* 33 */         long fightPet = xPetBag.getFightpet();
/* 34 */         if (fightPet > 0L)
/*    */         {
/* 36 */           PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(roleId, fightPet);
/* 37 */           if (petOutFightObj != null) {
/* 38 */             petOutFightObj.syncPetInfo();
/*    */           }
/*    */         }
/*    */         
/* 42 */         xbean.Role2PetBean xRole2petbean = xtable.Role2petoutfightbean.get(Long.valueOf(roleId));
/* 43 */         if (xRole2petbean != null) {
/* 44 */           mzm.gsp.util.LogicProcedure lp = xRole2petbean.getAction();
/* 45 */           if (lp != null) {
/* 46 */             xdb.Procedure.execute(lp);
/*    */           }
/* 48 */           xRole2petbean.setAction(null);
/*    */         }
/*    */         
/* 51 */         return true;
/*    */       }
/* 53 */     };
/* 54 */     xdb.Procedure.execute(lp);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */