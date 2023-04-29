/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.PCObserveEndReq;
/*    */ import mzm.gsp.leitai.confbean.SLeiTaiConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class PCPVPOther extends LogicProcedure
/*    */ {
/*    */   private long passiveRoleid;
/*    */   private long activeRoleid;
/*    */   
/*    */   public PCPVPOther(long activeRoleid, long passiveRoleid)
/*    */   {
/* 20 */     this.activeRoleid = activeRoleid;
/* 21 */     this.passiveRoleid = passiveRoleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     if (FightInterface.isInObserving(this.activeRoleid)) {
/* 27 */       return false;
/*    */     }
/* 29 */     boolean activeIsTeam = false;
/* 30 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.activeRoleid);
/* 31 */     if (normalList.contains(Long.valueOf(this.activeRoleid))) {
/* 32 */       if (normalList.contains(Long.valueOf(this.passiveRoleid))) {
/* 33 */         LeiTaiManager.sendNormalResult(this.activeRoleid, 5, new String[0]);
/* 34 */         return false;
/*    */       }
/* 36 */       activeIsTeam = true;
/* 37 */       if (this.activeRoleid != ((Long)normalList.get(0)).longValue()) {
/* 38 */         LeiTaiManager.sendNormalResult(this.activeRoleid, 4, new String[0]);
/* 39 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 44 */     if (!MapInterface.isRoleInPkZone(SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID, this.activeRoleid))
/*    */     {
/* 46 */       LeiTaiManager.sendNormalResult(this.activeRoleid, 1, new String[0]);
/* 47 */       return false;
/*    */     }
/* 49 */     if (!MapInterface.isRoleInPkZone(SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID, this.passiveRoleid))
/*    */     {
/* 51 */       LeiTaiManager.sendNormalResult(this.activeRoleid, 2, new String[0]);
/* 52 */       return false;
/*    */     }
/* 54 */     boolean passiveIsTeam = false;
/* 55 */     List<Long> passiveNormalList = TeamInterface.getNormalRoleList(this.passiveRoleid);
/* 56 */     if (passiveNormalList.contains(Long.valueOf(this.passiveRoleid))) {
/* 57 */       this.passiveRoleid = ((Long)passiveNormalList.get(0)).longValue();
/* 58 */       passiveIsTeam = true;
/*    */     }
/* 60 */     boolean retStatus = RoleStatusInterface.checkCansetStatus(normalList, 88, true, normalList);
/*    */     
/* 62 */     if (!retStatus) {
/* 63 */       return false;
/*    */     }
/* 65 */     boolean otherRet = RoleStatusInterface.checkCansetStatus(passiveNormalList, 89, true, normalList);
/*    */     
/* 67 */     if (!otherRet) {
/* 68 */       return false;
/*    */     }
/* 70 */     if (FightInterface.isInObserving(this.passiveRoleid))
/*    */     {
/* 72 */       boolean ret = new PCObserveEndReq(this.passiveRoleid).call();
/* 73 */       if (ret) {
/* 74 */         final boolean activeTeam = activeIsTeam;
/* 75 */         final boolean passiveTeam = passiveIsTeam;
/*    */         
/* 77 */         Procedure.execute(new LogicProcedure()
/*    */         {
/*    */           protected boolean processImp() throws Exception
/*    */           {
/* 81 */             LeiTaiManager.getInstance().fightOthers(PCPVPOther.this.activeRoleid, activeTeam, PCPVPOther.this.passiveRoleid, passiveTeam);
/* 82 */             return true;
/*    */           }
/*    */         });
/*    */       } else {
/* 86 */         return false;
/*    */       }
/*    */     } else {
/* 89 */       LeiTaiManager.getInstance().fightOthers(this.activeRoleid, activeIsTeam, this.passiveRoleid, passiveIsTeam);
/*    */     }
/*    */     
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\PCPVPOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */