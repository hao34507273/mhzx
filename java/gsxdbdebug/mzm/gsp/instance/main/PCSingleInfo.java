/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ public class PCSingleInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int instancecfgid;
/*    */   private int process;
/*    */   
/*    */   public PCSingleInfo(long roleid, int instancecfgid, int process)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.instancecfgid = instancecfgid;
/* 15 */     this.process = process;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if ((!OpenInterface.getOpenStatus(4)) || (OpenInterface.isBanPlay(this.roleid, 4)))
/*    */     {
/* 23 */       OpenInterface.sendBanPlayMsg(this.roleid, 4);
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     xbean.InstanceBean xInstanceBean = xtable.Role2instance.get(Long.valueOf(this.roleid));
/* 28 */     SingleInstance.reqSingleInfo(this.roleid, this.instancecfgid, this.process, xInstanceBean);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCSingleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */