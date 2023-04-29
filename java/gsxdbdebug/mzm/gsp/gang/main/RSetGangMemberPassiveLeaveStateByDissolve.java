/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ class RSetGangMemberPassiveLeaveStateByDissolve
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final Set<Long> gangMemebers;
/*    */   
/*    */   RSetGangMemberPassiveLeaveStateByDissolve(Set<Long> gangMemebers)
/*    */   {
/* 18 */     this.gangMemebers = gangMemebers;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 24 */     for (Iterator i$ = this.gangMemebers.iterator(); i$.hasNext();) { long memeberId = ((Long)i$.next()).longValue();
/* 25 */       new PSetMemberPassiveLeaveState(memeberId).call();
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PSetMemberPassiveLeaveState
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     PSetMemberPassiveLeaveState(long roleId)
/*    */     {
/* 36 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*    */       
/* 44 */       if (xGangMember == null) {
/* 45 */         return false;
/*    */       }
/*    */       
/* 48 */       Gang xGang = GangManager.getXGang(xGangMember.getGangid(), true);
/*    */       
/* 50 */       if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleId)))
/*    */       {
/* 52 */         GangManager.passiveLeaveGangHandle(xGangMember, this.roleId);
/*    */         
/* 54 */         xGangMember.setIs_in_gang(false);
/*    */       }
/*    */       
/* 57 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RSetGangMemberPassiveLeaveStateByDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */