/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Gang;
/*     */ import xbean.GangDutyMembers;
/*     */ import xbean.GangMember;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ class RRecoverDataMoreBangzhu
/*     */   extends LogicRunnable
/*     */ {
/*     */   private final long gangId;
/*     */   
/*     */   RRecoverDataMoreBangzhu(long gangId)
/*     */   {
/*  23 */     this.gangId = gangId;
/*     */   }
/*     */   
/*     */ 
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  30 */     new RDeleteMemberNotInGang(this.gangId).run();
/*     */     
/*     */ 
/*  33 */     Gang xGang = GangManager.getXGang(this.gangId, false);
/*  34 */     if (xGang == null) {
/*  35 */       String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@Gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/*  36 */       GangManager.logger.error(logStr);
/*  37 */       return;
/*     */     }
/*     */     
/*     */ 
/*  41 */     GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/*  42 */     if (xGangDutyMembers == null) {
/*  43 */       String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@xGangDutyMembers BANGZHU_ID is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/*  44 */       GangManager.logger.error(logStr);
/*     */     }
/*  46 */     else if (xGangDutyMembers.getMembers().size() == 1) {
/*  47 */       new RSetBangZhuDutyForce(this.gangId).run();
/*  48 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  53 */     xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/*  54 */     long createTime = xGang.getCreatetime();
/*  55 */     for (Iterator i$ = xGangDutyMembers.getMembers().iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*  56 */       GangMember xGangMember = Role2gangmember.select(Long.valueOf(memberId));
/*  57 */       if (xGangMember == null) {
/*  58 */         String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(memberId) });
/*  59 */         GangManager.logger.error(logStr);
/*  60 */       } else if (xGangMember.getJointime() == createTime) {
/*  61 */         new RSetDuty(this.gangId, memberId).run();
/*  62 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  67 */     long joinTimeShort = 0L;
/*  68 */     for (Iterator i$ = xGangDutyMembers.getMembers().iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*  69 */       GangMember xGangMember = Role2gangmember.select(Long.valueOf(memberId));
/*  70 */       if (xGangMember == null) {
/*  71 */         String logStr = String.format("RCheckOneBangZhuAndRecoverError.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(memberId) });
/*  72 */         GangManager.logger.error(logStr);
/*     */ 
/*     */       }
/*  75 */       else if (joinTimeShort == 0L) {
/*  76 */         joinTimeShort = memberId;
/*     */       } else {
/*  78 */         GangMember xGangMemberShort = Role2gangmember.select(Long.valueOf(joinTimeShort));
/*  79 */         if (xGangMemberShort.getJointime() > xGangMember.getJointime()) {
/*  80 */           joinTimeShort = memberId;
/*     */         }
/*     */       }
/*     */     }
/*  84 */     new RSetDuty(this.gangId, joinTimeShort).run();
/*     */   }
/*     */   
/*     */ 
/*     */   class RSetDuty
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long gangId;
/*     */     
/*     */     private final long roleId;
/*     */     
/*     */ 
/*     */     RSetDuty(long gangId, long roleId)
/*     */     {
/*  98 */       this.gangId = gangId;
/*  99 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 105 */       Gang xGang = GangManager.getXGang(this.gangId, false);
/* 106 */       if (xGang == null) {
/* 107 */         String logStr = String.format("PSetDuty.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 108 */         GangManager.logger.error(logStr);
/* 109 */         return;
/*     */       }
/* 111 */       GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/* 112 */       if (xGangDutyMembers == null) {
/* 113 */         String logStr = String.format("PSetDuty.process@GangDutyMembers BANGZHU_ID is null|gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 114 */         GangManager.logger.error(logStr); return;
/*     */       }
/*     */       Iterator i$;
/* 117 */       if (xGangDutyMembers.getMembers().size() > 0) {
/* 118 */         List<Long> memberList = new ArrayList();
/* 119 */         memberList.addAll(xGangDutyMembers.getMembers());
/* 120 */         for (i$ = memberList.iterator(); i$.hasNext();) { long curRoleId = ((Long)i$.next()).longValue();
/* 121 */           if (this.roleId == curRoleId) {
/* 122 */             new PSetMemberDutyToBangZhuForce(this.gangId, curRoleId).call();
/*     */           } else {
/* 124 */             new PSetMemberDutyToBangZhongForce(this.gangId, curRoleId).call();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RRecoverDataMoreBangzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */