/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.huanhun.SynGangHelpInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangHelpInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Gang;
/*    */ import xtable.Gang2hunhelp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynGangHelpInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PSynGangHelpInfo(long roleId)
/*    */   {
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 32 */     long gangId = GangInterface.getGangId(this.roleId);
/* 33 */     if (gangId <= 0L)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(gangId) }));
/* 39 */     if (gangId != GangInterface.getGangId(this.roleId))
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     GangHelpInfo xHelpInfo = Gang2hunhelp.get(Long.valueOf(gangId));
/* 45 */     if (xHelpInfo == null)
/*    */     {
/* 47 */       return false;
/*    */     }
/* 49 */     SynGangHelpInfo p = new SynGangHelpInfo();
/* 50 */     GangHelpManager.fillGangHelpInfo(p.ganghelpinfo, xHelpInfo);
/* 51 */     OnlineManager.getInstance().send(this.roleId, p);
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PSynGangHelpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */