/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.SwornBuilder;
/*    */ 
/*    */ public class PSetSwornTitleReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long swornid;
/*    */   private final String title;
/*    */   
/*    */   public PSetSwornTitleReq(long _roleid, long _swornid, String _title)
/*    */   {
/* 18 */     this.roleid = _roleid;
/* 19 */     this.swornid = _swornid;
/* 20 */     this.title = _title;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*    */     {
/* 27 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*    */     {
/* 33 */       SwornManager.logInfo("PSetSwornTitleReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     if (!SwornManager.checkSornTitle(this.title)) {
/* 39 */       sendResult(2);
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     SwornBuilder swornBuilder = xtable.Swornbuilder.get(Long.valueOf(this.swornid));
/* 45 */     if (swornBuilder == null)
/*    */     {
/* 47 */       sendResult(1);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (swornBuilder.getStatus() != 3)
/*    */     {
/* 53 */       sendResult(1);
/* 54 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 58 */     if (!swornBuilder.getRoleids().contains(Long.valueOf(this.roleid))) {
/* 59 */       sendResult(1);
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     if (swornBuilder.getTitles().keySet().contains(Long.valueOf(this.roleid))) {
/* 65 */       sendResult(1);
/* 66 */       return false;
/*    */     }
/*    */     
/* 69 */     swornBuilder.getTitles().put(Long.valueOf(this.roleid), this.title);
/* 70 */     OnlineManager.getInstance().send(this.roleid, new mzm.gsp.sworn.SSetSwornTitleRes(0));
/* 71 */     mzm.gsp.sworn.SRoleSwornTitle res = new mzm.gsp.sworn.SRoleSwornTitle(this.swornid, this.roleid, this.title);
/* 72 */     for (Iterator i$ = swornBuilder.getRoleids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 73 */       OnlineManager.getInstance().send(id, res);
/*    */     }
/*    */     
/*    */ 
/* 77 */     if (swornBuilder.getTitles().keySet().containsAll(swornBuilder.getRoleids())) {
/* 78 */       long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 79 */       time += mzm.gsp.title.confbean.SwornConsts.getInstance().PAY_SILVER_WAIT_TIME * 1000;
/* 80 */       swornBuilder.setStatus(4);
/* 81 */       swornBuilder.setConfirmtime(time);
/* 82 */       swornBuilder.getAgreeids().clear();
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 90 */       OnlineManager.getInstance().send(swornBuilder.getLeaderid(), new mzm.gsp.sworn.SAllSwornTitleOK(this.swornid));
/*    */     }
/*    */     
/* 93 */     return true;
/*    */   }
/*    */   
/*    */   void sendResult(int _code) {
/* 97 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.sworn.SSetSwornTitleRes(_code));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PSetSwornTitleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */