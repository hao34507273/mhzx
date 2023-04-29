/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.SDispatchLiHeRes;
/*     */ import mzm.gsp.gang.SSyncCangKuLiHeChange;
/*     */ import mzm.gsp.gang.cache.GangCacheManager;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.CangKu;
/*     */ import xbean.GangMember;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class PDispatchLiHeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private List<Long> offerRoleList;
/*     */   
/*     */   public PDispatchLiHeReq(long roleId, List<Long> offerRoleList)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.offerRoleList = offerRoleList;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     List<Long> lockList = new ArrayList();
/*  33 */     lockList.add(Long.valueOf(this.roleId));
/*  34 */     lockList.addAll(this.offerRoleList);
/*     */     
/*  36 */     lock(Role2gangmember.getTable(), lockList);
/*     */     
/*  38 */     GangMember xMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  39 */     if (xMember == null)
/*  40 */       return false;
/*  41 */     long gangId = xMember.getGangid();
/*     */     
/*  43 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  44 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleId))) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (SGangConst.getInstance().BANGZHU_ID != xMember.getDuty()) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     int xLiheNum = xGang.getCangku().getLihenum();
/*     */     
/*  54 */     if (xLiheNum < this.offerRoleList.size()) {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*  59 */     SDispatchLiHeRes res = new SDispatchLiHeRes();
/*  60 */     for (Iterator i$ = this.offerRoleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  61 */       GangMember rMember = Role2gangmember.get(Long.valueOf(r));
/*  62 */       if ((rMember != null) && 
/*     */       
/*     */ 
/*  65 */         (GangManager.isInGang(xGang, this.roleId)) && 
/*     */         
/*     */ 
/*     */ 
/*  69 */         (GangManager.getDiffDay(rMember.getJointime(), nowMillis) >= SGangConst.getInstance().CAN_GET_LIHE_NEED_JOIN_DAY) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  74 */         (!DateTimeUtils.isInThisWeek(rMember.getLastgetlihetime())))
/*     */       {
/*     */ 
/*  77 */         int restLiheNum = xGang.getCangku().getLihenum();
/*  78 */         if (restLiheNum <= 0) {
/*     */           break;
/*     */         }
/*  81 */         xGang.getCangku().setLihenum(restLiheNum - 1);
/*     */         
/*  83 */         rMember.setLastgetlihetime(nowMillis);
/*  84 */         res.roleidlist.add(Long.valueOf(r));
/*     */         
/*  86 */         mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(r, SGangConst.getInstance().LIHE_MAIL_ID, null, null, new TLogArg(mzm.gsp.tlog.LogReason.GANG_LIHE_ADD, SGangConst.getInstance().LIHE_MAIL_ID));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */         StringBuilder tLogStr = new StringBuilder();
/*     */         
/*  96 */         tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(this.roleId)).append("|").append(this.roleId).append("|").append(RoleInterface.getLevel(this.roleId)).append("|").append(gangId).append("|").append(r).append("|").append(xGang.getDisplayid());
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */         TLogManager.getInstance().addLog(this.roleId, "GangLiHe", tLogStr.toString());
/*     */         
/*     */ 
/* 106 */         GangCacheManager.changeMemberGetLiHeTime(gangId, r, nowMillis);
/*     */       }
/*     */     }
/* 109 */     if (res.roleidlist.size() > 0) {
/* 110 */       GangManager.broadcast(xGang, res);
/*     */       
/* 112 */       SSyncCangKuLiHeChange change = new SSyncCangKuLiHeChange();
/* 113 */       change.lihenum = xGang.getCangku().getLihenum();
/* 114 */       GangManager.broadcast(xGang, change);
/*     */     }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PDispatchLiHeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */