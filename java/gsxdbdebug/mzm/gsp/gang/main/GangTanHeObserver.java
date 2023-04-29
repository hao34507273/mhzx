/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.SSyncTanHeSuccess;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GangMember;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ 
/*     */ public class GangTanHeObserver
/*     */   extends MilliObserver
/*     */ {
/*  24 */   private static Map<Long, GangTanHeObserver> tanHeObserverMap = new ConcurrentHashMap();
/*     */   
/*     */ 
/*     */   private long gangId;
/*     */   
/*     */ 
/*     */   public GangTanHeObserver(long gangId, long intervalMilliSeconds)
/*     */   {
/*  32 */     super(intervalMilliSeconds);
/*  33 */     this.gangId = gangId;
/*  34 */     tanHeObserverMap.put(Long.valueOf(gangId), this);
/*     */   }
/*     */   
/*     */   public boolean update()
/*     */   {
/*  39 */     Procedure.execute(new PTanheUpdate(this.gangId));
/*  40 */     return false;
/*     */   }
/*     */   
/*     */   public static void stopTanHe(long gangId) {
/*  44 */     GangTanHeObserver observer = (GangTanHeObserver)tanHeObserverMap.remove(Long.valueOf(gangId));
/*  45 */     if (observer != null) {
/*  46 */       observer.stopTimer();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PTanheUpdate extends LogicProcedure
/*     */   {
/*     */     private long gangId;
/*     */     
/*     */     public PTanheUpdate(long gangId) {
/*  55 */       this.gangId = gangId;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  60 */       xbean.Gang xGang = xtable.Gang.select(Long.valueOf(this.gangId));
/*  61 */       if (xGang == null) {
/*  62 */         return false;
/*     */       }
/*  64 */       if (xGang.getTanheroleid() == 0L) {
/*  65 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  69 */       lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(xGang.getTanheroleid()), Long.valueOf(xGang.getBangzhuid()) }));
/*  70 */       xGang = xtable.Gang.get(Long.valueOf(this.gangId));
/*  71 */       long oldBangZHuId = xGang.getBangzhuid();
/*  72 */       long tanheId = xGang.getTanheroleid();
/*     */       
/*  74 */       if ((!GangManager.isInGang(xGang, tanheId)) || (!GangManager.isInGang(xGang, oldBangZHuId))) {
/*  75 */         xGang.setTanheendtime(0L);
/*  76 */         xGang.setTanheroleid(0L);
/*  77 */         return false;
/*     */       }
/*     */       
/*  80 */       if (xGang.getTanheroleid() == xGang.getBangzhuid()) {
/*  81 */         xGang.setTanheendtime(0L);
/*  82 */         xGang.setTanheroleid(0L);
/*  83 */         return false;
/*     */       }
/*  85 */       GangMember xOldBangZhu = Role2gangmember.get(Long.valueOf(oldBangZHuId));
/*  86 */       GangMember xNewBangZHu = Role2gangmember.get(Long.valueOf(tanheId));
/*     */       
/*  88 */       if (xOldBangZhu.getDuty() != SGangConst.getInstance().BANGZHU_ID) {
/*  89 */         xGang.setTanheendtime(0L);
/*  90 */         xGang.setTanheroleid(0L);
/*  91 */         return false;
/*     */       }
/*  93 */       SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xNewBangZHu);
/*     */       
/*  95 */       if (!dutyCfg.isCanTanHe) {
/*  96 */         xGang.setTanheendtime(0L);
/*  97 */         xGang.setTanheroleid(0L);
/*  98 */         return false;
/*     */       }
/* 100 */       int tanheDuty = xNewBangZHu.getDuty();
/*     */       
/* 102 */       GangManager.changeDutyRelation(oldBangZHuId, xOldBangZhu, this.gangId, xGang, SGangConst.getInstance().BANGZHONG_ID, tanheId, tanheDuty);
/*     */       
/*     */ 
/* 105 */       GangManager.changeDutyRelation(tanheId, xNewBangZHu, this.gangId, xGang, SGangConst.getInstance().BANGZHU_ID, tanheId, tanheDuty);
/*     */       
/* 107 */       xGang.setBangzhuid(xGang.getTanheroleid());
/* 108 */       xGang.setTanheendtime(0L);
/* 109 */       xGang.setTanheroleid(0L);
/*     */       
/* 111 */       GangManager.sendMail(xGang, SGangConst.getInstance().CHANG_BANGZHU_MAIL_ID, new TLogArg(LogReason.GANG_TANHE_SUCCESS_MAIL, SGangConst.getInstance().CHANG_BANGZHU_MAIL_ID), new String[] { RoleInterface.getName(tanheId), xGang.getName() });
/* 112 */       GangManager.sendMail(tanheId, SGangConst.getInstance().AUTO_BE_BANGZHU_MAIL_ID, new TLogArg(LogReason.GANG_TANHE_AUTO_BANGZHU_MAIL, SGangConst.getInstance().AUTO_BE_BANGZHU_MAIL_ID), new String[] { xGang.getName() });
/* 113 */       GangManager.sendMail(oldBangZHuId, SGangConst.getInstance().TANHE_OLD_BANGZHU_MAIL_ID, new TLogArg(LogReason.GANG_TANHEED_BANGZHU_MAIL, SGangConst.getInstance().TANHE_OLD_BANGZHU_MAIL_ID), new String[] { RoleInterface.getName(tanheId) });
/*     */       
/* 115 */       SSyncTanHeSuccess sSyncTanHeSuccess = new SSyncTanHeSuccess();
/* 116 */       sSyncTanHeSuccess.tanheid = tanheId;
/* 117 */       sSyncTanHeSuccess.bangzhuid = oldBangZHuId;
/*     */       
/*     */ 
/* 120 */       GangManager.asyncApplicants(tanheId, this.gangId);
/*     */       
/* 122 */       StringBuilder tLogStr = new StringBuilder();
/*     */       
/* 124 */       tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(tanheId)).append("|").append(tanheId).append("|").append(xGang.getBangzhuid()).append("|").append(this.gangId).append("|").append(xNewBangZHu.getDuty()).append("|").append(GangTanheLogEnum.SUCCESS).append("|").append(xGang.getDisplayid());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */       TLogManager.getInstance().addLog(tanheId, "GangTanHe", tLogStr.toString());
/*     */       
/* 134 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangTanHeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */