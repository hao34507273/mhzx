/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class MMH_GM_GoFault extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public MMH_GM_GoFault(long gmRoleid, long roleid)
/*    */   {
/* 12 */     this.gmRoleid = gmRoleid;
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 19 */     new MMH_ForceTransferWhenFault(this.roleid).doProcess();
/* 20 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "go fault done");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GM_GoFault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */