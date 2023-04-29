/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.corps.SCorpsBriefInfoRep;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetCorpsBriefInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Collection<Long> members;
/*    */   
/*    */   public PCGetCorpsBriefInfoReq(long roleId, Collection<Long> members)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.members = members;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     SCorpsBriefInfoRep p = new SCorpsBriefInfoRep();
/* 32 */     for (Iterator i$ = this.members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*    */       
/* 34 */       CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(member, false, false);
/* 35 */       if (corpsInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 39 */         p.corpsbriefinfos.put(Long.valueOf(member), corpsInfo.getBriefInfo()); }
/*    */     }
/* 41 */     p.roleids.addAll(this.members);
/* 42 */     OnlineManager.getInstance().send(this.roleId, p);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCGetCorpsBriefInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */