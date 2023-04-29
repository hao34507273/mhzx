/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import xbean.SwornBuilder;
/*     */ 
/*     */ public class PSetSwornNameReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long swornid;
/*     */   private final String name1;
/*     */   private final String name2;
/*     */   
/*     */   public PSetSwornNameReq(long _roleid, long _swornid, String _name1, String _name2)
/*     */   {
/*  18 */     this.roleid = _roleid;
/*  19 */     this.swornid = _swornid;
/*  20 */     this.name1 = _name1;
/*  21 */     this.name2 = _name2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  29 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  35 */       SwornManager.logInfo("PSetSwornNameReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     SwornBuilder swornBuilder = xtable.Swornbuilder.get(Long.valueOf(this.swornid));
/*  41 */     if (swornBuilder == null)
/*     */     {
/*  43 */       sendResult(1);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (swornBuilder.getLeaderid() != this.roleid)
/*     */     {
/*  49 */       sendResult(2);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (swornBuilder.getStatus() != 1)
/*     */     {
/*  55 */       sendResult(1);
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     int ret = SwornManager.checkSornName(this.name1, this.name2);
/*  61 */     if (ret != 0) {
/*  62 */       if (ret == 1)
/*  63 */         sendResult(3);
/*  64 */       if (ret == 2)
/*  65 */         sendResult(4);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!SwornManager.allocateSwornName(this.name1, this.name2)) {
/*  70 */       sendResult(5);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  76 */     time += mzm.gsp.title.confbean.SwornConsts.getInstance().SWORN_WAIT_TIME * 1000;
/*  77 */     swornBuilder.setName1(this.name1);
/*  78 */     swornBuilder.setName2(this.name2);
/*  79 */     swornBuilder.setStatus(2);
/*  80 */     swornBuilder.setConfirmtime(time);
/*  81 */     swornBuilder.getAgreeids().clear();
/*  82 */     swornBuilder.getAgreeids().add(Long.valueOf(this.roleid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  91 */     mzm.gsp.sworn.SBeginConfirmSwornName res = new mzm.gsp.sworn.SBeginConfirmSwornName(this.swornid, this.roleid, this.name1, this.name2);
/*  92 */     for (Iterator i$ = swornBuilder.getRoleids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  93 */       OnlineManager.getInstance().send(id, res);
/*     */     }
/*     */     
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/* 100 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.sworn.SSetSwornNameError(_code));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PSetSwornNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */