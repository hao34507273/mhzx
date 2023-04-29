/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangDutyMembers;
/*     */ import xbean.GangGlobal;
/*     */ import xbean.GangMember;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class RPrintGsLogForBangzhuError extends LogicRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  19 */     GangGlobal xGlobal = GangManager.getXGlobal(false);
/*  20 */     if ((xGlobal == null) || (xGlobal.getAllgangids().isEmpty())) {
/*  21 */       return;
/*     */     }
/*  23 */     for (Iterator i$ = xGlobal.getAllgangids().iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/*  24 */       xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangid));
/*  25 */       if (xGang == null) {
/*  26 */         String logStr = String.format("RPrintGsLogForBangzhuError.process@invalid gangid in set|gangid=%d", new Object[] { Long.valueOf(gangid) });
/*  27 */         GangManager.logger.error(logStr);
/*     */       }
/*     */       else
/*     */       {
/*  31 */         GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/*  32 */         if (xGangDutyMembers != null)
/*     */         {
/*  34 */           if (xGangDutyMembers.getMembers().size() > 1)
/*     */           {
/*  36 */             printMoreBangzhuErrorLog(gangid, xGangDutyMembers.getMembers()); } else { long bangzhuid;
/*  37 */             GangMember xGangMember; if (xGangDutyMembers.getMembers().size() == 1)
/*     */             {
/*     */ 
/*  40 */               Iterator<Long> iter = xGangDutyMembers.getMembers().iterator();
/*  41 */               bangzhuid = ((Long)iter.next()).longValue();
/*  42 */               xGangMember = Role2gangmember.select(Long.valueOf(bangzhuid));
/*  43 */               if (xGangMember == null) {
/*  44 */                 String logStr = String.format("RPrintGsLogForBangzhuError.process@invalid gangid in set|gangid=%d", new Object[] { Long.valueOf(gangid) });
/*  45 */                 GangManager.logger.error(logStr);
/*     */ 
/*     */               }
/*  48 */               else if (xGangMember.getGangid() != gangid) {
/*  49 */                 printOneUnRealBangzhuErrorLog(gangid, bangzhuid);
/*     */               }
/*  51 */               else if (xGangMember.getDuty() != SGangConst.getInstance().BANGZHU_ID) {
/*  52 */                 printOneRealBangzhuDutyErrorLog(gangid, bangzhuid);
/*     */               }
/*     */               else
/*     */               {
/*  56 */                 Set<Long> memberList = GangManager.getMembers(xGang);
/*  57 */                 for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*  58 */                   if (bangzhuid != memberId) {
/*  59 */                     xGangMember = Role2gangmember.select(Long.valueOf(memberId));
/*  60 */                     if (xGangMember.getDuty() == SGangConst.getInstance().BANGZHU_ID) {
/*  61 */                       printOneUnRealBangzhuErrorLog(gangid, bangzhuid, memberId);
/*  62 */                       break;
/*     */                     }
/*     */                   }
/*     */                 }
/*  66 */               } } else if (xGangDutyMembers.getMembers().size() == 0)
/*     */             {
/*  68 */               printNoneBangzhuErrorLog(gangid);
/*     */             }
/*     */           }
/*  71 */         } else { String logStr = String.format("RPrintGsLogForBangzhuError.process@BANGZHU_ID GangDutyMembers is null |gangid=%d", new Object[] { Long.valueOf(gangid) });
/*  72 */           GangManager.logger.error(logStr);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void printMoreBangzhuErrorLog(long gangId, Set<Long> bangzhuRoleIds) {
/*  79 */     StringBuilder tlogStr = new StringBuilder();
/*  80 */     tlogStr.append("RPrintGsLogForBangzhuError.printMoreBangzhuErrorLog@ more real bangzhu error|zoneid=").append(GameServer.getZoneid()).append("|").append("gangid=").append(gangId).append("|");
/*     */     
/*     */ 
/*  83 */     int index = 1;
/*  84 */     for (Iterator i$ = bangzhuRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*  85 */       tlogStr.append("roleid").append(index).append("=").append(roleId).append("|");
/*     */     }
/*  87 */     GangManager.logger.info(tlogStr.toString());
/*     */   }
/*     */   
/*     */   private void printOneUnRealBangzhuErrorLog(long gangId, long roleId) {
/*  91 */     StringBuilder tlogStr = new StringBuilder();
/*  92 */     tlogStr.append("RPrintGsLogForBangzhuError.printOneUnRealBangzhuErrorLog@ oneunreal bangzhu error|zoneid=").append(GameServer.getZoneid()).append("|").append("gangid=").append(gangId).append("|").append("roleId=").append(roleId);
/*     */     
/*     */ 
/*     */ 
/*  96 */     GameServer.logger().info(tlogStr.toString());
/*     */   }
/*     */   
/*     */   private void printOneRealBangzhuDutyErrorLog(long gangId, long roleId) {
/* 100 */     StringBuilder tlogStr = new StringBuilder();
/* 101 */     tlogStr.append("RPrintGsLogForBangzhuError.printOneUnRealBangzhuErrorLog@ onereal bangzhu but duty is not bangzhu error|zoneid=").append(GameServer.getZoneid()).append("|").append("gangid=").append(gangId).append("|").append("roleId=").append(roleId);
/*     */     
/*     */ 
/*     */ 
/* 105 */     GameServer.logger().info(tlogStr.toString());
/*     */   }
/*     */   
/*     */   private void printOneUnRealBangzhuErrorLog(long gangId, long bangzhuId, long unrealbangzhuId) {
/* 109 */     StringBuilder tlogStr = new StringBuilder();
/* 110 */     tlogStr.append("RPrintGsLogForBangzhuError.printOneUnRealBangzhuErrorLog@ two bangzhu duty and oneunreal bangzhu error|zoneid=").append(GameServer.getZoneid()).append("|").append("gangid=").append(gangId).append("|").append("realbangzhuId=").append(bangzhuId).append("|").append("unrealbangzhuId=").append(unrealbangzhuId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 115 */     GameServer.logger().info(tlogStr.toString());
/*     */   }
/*     */   
/*     */   private void printNoneBangzhuErrorLog(long gangId) {
/* 119 */     StringBuilder tlogStr = new StringBuilder();
/* 120 */     tlogStr.append("RPrintGsLogForBangzhuError.printNoneBangzhuErrorLog@ none bangzhu error|zoneid=").append(GameServer.getZoneid()).append("|").append("gangid=").append(gangId);
/*     */     
/*     */ 
/* 123 */     GameServer.logger().info(tlogStr.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RPrintGsLogForBangzhuError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */