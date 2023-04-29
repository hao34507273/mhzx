/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.SwornBuilder;
/*    */ 
/*    */ public class PAgreeCreateSworn extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long swornid;
/*    */   
/*    */   public PAgreeCreateSworn(long _roleid, long _swornid)
/*    */   {
/* 16 */     this.roleid = _roleid;
/* 17 */     this.swornid = _swornid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*    */     {
/* 24 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     SwornBuilder swornBuilder = xtable.Swornbuilder.get(Long.valueOf(this.swornid));
/* 29 */     if (swornBuilder == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (!swornBuilder.getRoleids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (swornBuilder.getStatus() != 0)
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (swornBuilder.getAgreeids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     swornBuilder.getAgreeids().add(Long.valueOf(this.roleid));
/*    */     
/*    */ 
/*    */ 
/* 53 */     mzm.gsp.sworn.SAgreeCreateSwornRes res = new mzm.gsp.sworn.SAgreeCreateSwornRes(this.swornid, this.roleid);
/* 54 */     for (Iterator i$ = swornBuilder.getRoleids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 55 */       OnlineManager.getInstance().send(id, res);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 60 */     if (swornBuilder.getAgreeids().containsAll(swornBuilder.getRoleids())) {
/* 61 */       long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 62 */       time += mzm.gsp.title.confbean.SwornConsts.getInstance().SET_TITLE_WAIT_TIME * 1000;
/* 63 */       swornBuilder.setStatus(1);
/* 64 */       swornBuilder.getAgreeids().clear();
/* 65 */       swornBuilder.setConfirmtime(time);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 74 */       mzm.gsp.sworn.SBeginSetSwornName res = new mzm.gsp.sworn.SBeginSetSwornName(this.swornid, swornBuilder.getLeaderid());
/* 75 */       OnlineManager.getInstance().sendMulti(res, swornBuilder.getRoleids());
/*    */     }
/*    */     
/*    */ 
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PAgreeCreateSworn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */