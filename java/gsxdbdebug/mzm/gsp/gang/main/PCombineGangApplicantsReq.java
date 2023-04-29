/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.SCombineGangApplicantsRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Gang;
/*    */ import xbean.GangCombine;
/*    */ 
/*    */ public class PCombineGangApplicantsReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCombineGangApplicantsReq(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     Long gangid = GangManager.getGangidByRole(this.roleid);
/* 25 */     if (gangid == null) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     SCombineGangApplicantsRes res = new SCombineGangApplicantsRes();
/*    */     
/*    */ 
/* 32 */     GangCombine xCombine = GangManager.getXCombine(gangid.longValue(), false);
/* 33 */     Iterator i$; if (xCombine != null)
/* 34 */       for (i$ = xCombine.getApplicants().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 35 */         if (id != xCombine.getGangid())
/*    */         {
/*    */ 
/*    */ 
/* 39 */           Gang xGang = GangManager.getXGang(id, false);
/* 40 */           if (xGang != null)
/*    */           {
/*    */ 
/* 43 */             mzm.gsp.gang.CombineGang combineGangBean = GangManager.getCombineGangBean(id, xGang);
/* 44 */             res.applicants.add(combineGangBean);
/*    */           }
/*    */         }
/*    */       }
/* 48 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCombineGangApplicantsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */