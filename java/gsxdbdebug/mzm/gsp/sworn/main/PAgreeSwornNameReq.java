/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.SwornBuilder;
/*    */ 
/*    */ public class PAgreeSwornNameReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long swornid;
/*    */   
/*    */   public PAgreeSwornNameReq(long _roleid, long _swornid)
/*    */   {
/* 15 */     this.roleid = _roleid;
/* 16 */     this.swornid = _swornid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if ((!mzm.gsp.open.main.OpenInterface.getOpenStatus(100)) || (mzm.gsp.open.main.OpenInterface.isBanPlay(this.roleid, 100)))
/*    */     {
/* 23 */       mzm.gsp.open.main.OpenInterface.sendBanPlayMsg(this.roleid, 100);
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     SwornBuilder swornBuilder = xtable.Swornbuilder.get(Long.valueOf(this.swornid));
/* 28 */     if (swornBuilder == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (!swornBuilder.getRoleids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (swornBuilder.getStatus() != 2)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (swornBuilder.getAgreeids().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     swornBuilder.getAgreeids().add(Long.valueOf(this.roleid));
/*    */     
/*    */ 
/*    */ 
/* 52 */     mzm.gsp.sworn.SAgreeSwornNameRes res = new mzm.gsp.sworn.SAgreeSwornNameRes(this.swornid, this.roleid);
/* 53 */     for (Iterator i$ = swornBuilder.getRoleids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 54 */       OnlineManager.getInstance().send(id, res);
/*    */     }
/*    */     
/*    */     mzm.gsp.sworn.SBeginSetSwornTitle res;
/*    */     Iterator i$;
/* 59 */     if (swornBuilder.getAgreeids().containsAll(swornBuilder.getRoleids())) {
/* 60 */       long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 61 */       time += mzm.gsp.title.confbean.SwornConsts.getInstance().SET_TITLE_WAIT_TIME * 1000;
/* 62 */       swornBuilder.setStatus(3);
/* 63 */       swornBuilder.getAgreeids().clear();
/* 64 */       swornBuilder.setConfirmtime(time);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 73 */       res = new mzm.gsp.sworn.SBeginSetSwornTitle(this.swornid);
/* 74 */       for (i$ = swornBuilder.getRoleids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 75 */         OnlineManager.getInstance().send(id, res);
/*    */       }
/*    */     }
/*    */     
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PAgreeSwornNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */