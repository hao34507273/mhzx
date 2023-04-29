/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ class NpcLocationChecker
/*    */   implements ConditionChecker
/*    */ {
/*  9 */   private static final Logger logger = Logger.getLogger(NpcServiceManager.class);
/*    */   
/*    */   private final long roleid;
/*    */   private final int npcid;
/*    */   
/*    */   public NpcLocationChecker(long roleid, int npcid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.npcid = npcid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check()
/*    */   {
/* 23 */     if (!MapInterface.isNpcExist(this.npcid))
/*    */     {
/* 25 */       if (logger.isDebugEnabled())
/*    */       {
/* 27 */         logger.debug(String.format("[npc]NpcLocationChecker.check@npc不存在|roleid=%d|npcid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.npcid) }));
/*    */       }
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (!MapInterface.isNearByNPC(this.roleid, this.npcid))
/*    */     {
/* 34 */       if (logger.isDebugEnabled())
/*    */       {
/* 36 */         logger.debug(String.format("[npc]NpcLocationChecker.check@玩家不再npc旁边|roleid=%d|npcid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.npcid) }));
/*    */       }
/*    */       
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcLocationChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */