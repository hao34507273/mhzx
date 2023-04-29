/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class PGM_UnBanNpcService extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int npcServiceid;
/*    */   
/*    */   public PGM_UnBanNpcService(long roleid, int npcServiceid)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.npcServiceid = npcServiceid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     NpcInterface.unBanNpcService(this.npcServiceid);
/* 19 */     GmManager.getInstance().sendResultToGM(this.roleid, String.format("解禁npc服务成功,serviceid=%d", new Object[] { Integer.valueOf(this.npcServiceid) }));
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\PGM_UnBanNpcService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */