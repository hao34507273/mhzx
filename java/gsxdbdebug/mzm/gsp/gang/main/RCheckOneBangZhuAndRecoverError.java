/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Gang;
/*    */ import xbean.GangDutyMembers;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ 
/*    */ class RCheckOneBangZhuAndRecoverError
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gangId;
/*    */   
/*    */   RCheckOneBangZhuAndRecoverError(long gangId)
/*    */   {
/* 24 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 31 */     new RDeleteMemberNotInGang(this.gangId).run();
/*    */     
/*    */ 
/* 34 */     Gang xGang = GangManager.getXGang(this.gangId, false);
/* 35 */     if (xGang == null) {
/* 36 */       String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@Gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 37 */       GangManager.logger.error(logStr);
/* 38 */       return;
/*    */     }
/* 40 */     Set<Long> gangMemberSet = GangManager.getMembers(xGang);
/*    */     
/*    */ 
/* 43 */     GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/* 44 */     if (xGangDutyMembers == null) {
/* 45 */       String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@xGangDutyMembers BANGZHU_ID is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 46 */       GangManager.logger.error(logStr);
/*    */     }
/* 48 */     else if (xGangDutyMembers.getMembers().size() == 1) {
/* 49 */       new RSetBangZhuDutyForce(this.gangId).run();
/* 50 */       return;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 55 */     long createTime = xGang.getCreatetime();
/* 56 */     for (Iterator i$ = gangMemberSet.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/* 57 */       GangMember xGangMember = Role2gangmember.select(Long.valueOf(memberId));
/* 58 */       if ((xGangMember != null) && (xGangMember.getJointime() == createTime) && (xGangMember.getGangid() == this.gangId)) {
/* 59 */         new PSetMemberDutyToBangZhuForce(this.gangId, memberId).call();
/* 60 */         return;
/*    */       }
/*    */     }
/*    */     
/* 64 */     List<Integer> dutyList = new ArrayList();
/* 65 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().FUBANGZHU_ID));
/* 66 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().ZHANGLAO_ID));
/* 67 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().TANGZHU_ID));
/* 68 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().XIANGZHU_ID));
/* 69 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().JINGYING_ID));
/* 70 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().BANGZHONG_ID));
/* 71 */     dutyList.add(Integer.valueOf(SGangConst.getInstance().XUETU_ID));
/*    */     
/* 73 */     for (Integer dutyId : dutyList) {
/* 74 */       xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(dutyId);
/* 75 */       if ((xGangDutyMembers != null) && (xGangDutyMembers.getMembers().size() > 0)) {
/* 76 */         List<Long> memberList = new ArrayList();
/* 77 */         memberList.addAll(xGangDutyMembers.getMembers());
/* 78 */         for (i$ = memberList.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/* 79 */           GangMember xRecoverGangMember = Role2gangmember.select(Long.valueOf(memberId));
/*    */           
/* 81 */           if (xRecoverGangMember == null) {
/* 82 */             String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(memberId) });
/* 83 */             GangManager.logger.error(logStr);
/*    */           }
/*    */           else {
/* 86 */             new PSetMemberDutyToBangZhuForce(this.gangId, memberId).call(); return;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     Iterator i$;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RCheckOneBangZhuAndRecoverError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */