/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CClearQQGroupReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangMember;
/*    */ import xbean.OutGangStatus;
/*    */ import xtable.Role2gangmember;
/*    */ import xtable.Role2outgang;
/*    */ 
/*    */ public class PCClearQQGroupReq extends GangProcedure<CClearQQGroupReq>
/*    */ {
/*    */   public PCClearQQGroupReq(CClearQQGroupReq protocol)
/*    */   {
/* 15 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CClearQQGroupReq protocol)
/*    */   {
/* 21 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(roleId));
/* 22 */     if (xGangMember == null)
/*    */     {
/* 24 */       SGangNormalResult result = new SGangNormalResult();
/* 25 */       result.result = 46;
/* 26 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */       
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(xGangMember.getGangid()));
/* 32 */     if (xGang == null)
/*    */     {
/* 34 */       Role2outgang.remove(Long.valueOf(roleId));
/*    */     }
/*    */     else {
/* 37 */       lock(xtable.Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(xGang.getBangzhuid()), Long.valueOf(xGang.getGrouproleid()) }));
/*    */       
/* 39 */       xbean.Gang xGangClearQQGroup = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/*    */       
/* 41 */       if (xGangClearQQGroup.getBangzhuid() == roleId)
/*    */       {
/* 43 */         Role2outgang.remove(Long.valueOf(xGangClearQQGroup.getGrouproleid()));
/* 44 */         xGangClearQQGroup.setGroupopenid("");
/* 45 */         xGangClearQQGroup.setGrouproleid(0L);
/*    */       }
/*    */       else {
/* 48 */         OutGangStatus xOutGangStatus = Role2outgang.get(Long.valueOf(roleId));
/* 49 */         if ((xOutGangStatus != null) && (xOutGangStatus.getGangid() != xGangMember.getGangid()))
/*    */         {
/* 51 */           Role2outgang.remove(Long.valueOf(roleId));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCClearQQGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */