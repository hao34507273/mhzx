/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.SRefreshGongXunRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PRefreshGongXunReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PRefreshGongXunReq(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     Gang gang = GangInterface.getGangByRoleId(this.roleid, false);
/* 28 */     if (gang == null) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     Set<Long> members = GangManager.getMembers(gang.xGang);
/* 33 */     SRefreshGongXunRes res = new SRefreshGongXunRes();
/* 34 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */       
/* 36 */       GangMember xMember = Role2gangmember.select(Long.valueOf(r));
/* 37 */       if (xMember != null)
/*    */       {
/*    */ 
/* 40 */         if (DateTimeUtils.isInThisWeek(xMember.getGongxun_timestamp()))
/*    */         {
/* 42 */           res.roleid2gongxun.put(Long.valueOf(r), Integer.valueOf(xMember.getGongxun()));
/*    */         }
/*    */       }
/*    */     }
/* 46 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PRefreshGongXunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */