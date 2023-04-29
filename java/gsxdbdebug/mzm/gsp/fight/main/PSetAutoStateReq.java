/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FightCache;
/*    */ import xbean.Pod;
/*    */ import xtable.Basic;
/*    */ import xtable.Rolefightcache;
/*    */ 
/*    */ public class PSetAutoStateReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int autoState;
/*    */   
/*    */   public PSetAutoStateReq(long roleid, int autoState)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.autoState = autoState;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/* 24 */     if (fight != null)
/*    */     {
/* 26 */       lock(Basic.getTable(), fight.getLockRoles());
/*    */     }
/*    */     
/* 29 */     FightCache fightCache = Rolefightcache.get(Long.valueOf(this.roleid));
/* 30 */     if (fightCache == null) {
/* 31 */       fightCache = Pod.newFightCache();
/* 32 */       fightCache.setIsauto(false);
/* 33 */       Rolefightcache.insert(Long.valueOf(this.roleid), fightCache);
/*    */     }
/*    */     
/* 36 */     if (this.autoState == 1) {
/* 37 */       if (fightCache.getIsauto()) {
/* 38 */         return false;
/*    */       }
/* 40 */       if (fight != null) {
/* 41 */         FightGroupRole groupRole = fight.getGroupRole(this.roleid);
/* 42 */         if (groupRole == null) {
/* 43 */           return false;
/*    */         }
/* 45 */         if (groupRole != null) {
/* 46 */           groupRole.setAuto(true);
/*    */         }
/* 48 */         if ((fight.allHasCmdOrAuto()) && ((fight.isInPrepare1Flow()) || (fight.isInPrepare2Flow()))) {
/* 49 */           for (Fighter fighter : groupRole.getExistedFighters()) {
/* 50 */             if ((fighter.isRole()) || (fighter.isPet()) || (fighter.isChild())) {
/* 51 */               fighter.setDefautOper();
/* 52 */               fighter.broadCastSelectOperInTeam();
/*    */             }
/*    */           }
/* 55 */           fight.cancelRoundPrapare2Session();
/* 56 */           fight.onPlayBefore();
/* 57 */         } else if (fight.isInPrepare2Flow()) {
/* 58 */           for (Fighter fighter : groupRole.getExistedFighters()) {
/* 59 */             if ((fighter.isRole()) || (fighter.isPet()) || (fighter.isChild())) {
/* 60 */               fighter.setDefautOper();
/* 61 */               fighter.broadCastSelectOperInTeam();
/*    */             }
/*    */           }
/*    */         }
/*    */         
/* 66 */         return true;
/*    */       }
/*    */       
/* 69 */       fightCache.setIsauto(true);
/*    */     }
/*    */     else
/*    */     {
/* 73 */       if (!fightCache.getIsauto()) {
/* 74 */         return false;
/*    */       }
/* 76 */       fightCache.setIsauto(false);
/*    */     }
/*    */     
/*    */ 
/* 80 */     FightInterface.syncAutoState(this.roleid);
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PSetAutoStateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */