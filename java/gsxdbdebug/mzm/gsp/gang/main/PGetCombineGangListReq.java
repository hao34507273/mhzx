/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.SGetCombineGangListRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Gang;
/*    */ import xbean.GangCombine;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ public class PGetCombineGangListReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetCombineGangListReq(long roleid)
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
/* 28 */     Gang xGang = GangManager.getXGang(gangid.longValue(), false);
/* 29 */     if (xGang == null) {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     if (!GangManager.isLeader(xGang, this.roleid)) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     GangGlobal xGlobal = GangManager.getXGlobal(false);
/*    */     
/*    */ 
/* 41 */     if (!GangManager.checkCombineVitality(xGang)) {
/* 42 */       GangManager.sendNormalResult(this.roleid, 131, new Object[0]);
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     int validCount = GangManager.getCombineValidCount(xGang);
/*    */     
/* 48 */     SGetCombineGangListRes res = new SGetCombineGangListRes();
/*    */     Iterator i$;
/* 50 */     if (xGlobal != null) {
/* 51 */       for (i$ = xGlobal.getAllgangids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 52 */         if (id != gangid.longValue())
/*    */         {
/*    */ 
/*    */ 
/* 56 */           Gang xOtherGang = GangManager.getXGang(id, false);
/*    */           
/* 58 */           if (xOtherGang != null)
/*    */           {
/*    */ 
/* 61 */             GangCombine xOtherCombine = GangManager.getXCombine(id, false);
/*    */             
/*    */ 
/* 64 */             if ((!GangManager.isCombining(id, xOtherCombine, xGlobal)) && 
/*    */             
/*    */ 
/*    */ 
/*    */ 
/* 69 */               (GangManager.checkCombineGangsMemberCount(xOtherGang, xGang)))
/*    */             {
/*    */ 
/*    */ 
/* 73 */               int count = GangManager.getCombineValidCount(xOtherGang);
/* 74 */               int capacity = GangManager.getNormalMemberCapacity(xOtherGang);
/* 75 */               if (count + validCount <= capacity) {
/* 76 */                 mzm.gsp.gang.CombineGang gangBean = GangManager.getCombineGangBean(id, xOtherGang);
/* 77 */                 if (gangBean != null)
/* 78 */                   res.gangs.add(gangBean);
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 85 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGetCombineGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */