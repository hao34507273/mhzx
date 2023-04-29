/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.confbean.SNPCFightCfg;
/*    */ 
/*    */ public class PCNpcFightService extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int npcid;
/*    */   private int serviceid;
/*    */   private long roleid;
/*    */   
/*    */   public PCNpcFightService(long roleid, int npcid, int serviceid)
/*    */   {
/* 18 */     this.npcid = npcid;
/* 19 */     this.serviceid = serviceid;
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!NpcServiceManager.checkNpcService(this.npcid, this.serviceid, this.roleid)) {
/* 26 */       return false;
/*    */     }
/* 28 */     SNPCFightCfg npcFightCfg = NpcServiceManager.getServiceFight(this.serviceid);
/* 29 */     int proRate = xdb.Xdb.random().nextInt(10000);
/* 30 */     int fightid = -1;
/* 31 */     for (Map.Entry<Integer, Integer> entry : npcFightCfg.fightMap.entrySet()) {
/* 32 */       if (((Integer)entry.getValue()).intValue() > proRate) {
/* 33 */         fightid = ((Integer)entry.getKey()).intValue();
/* 34 */         break;
/*    */       }
/*    */     }
/* 37 */     int mapCfgid = MapInterface.getRoleMapId(this.roleid);
/* 38 */     mzm.gsp.fight.main.FightInterface.startPVEFight(this.roleid, fightid, new NpcFightContext(mapCfgid, this.npcid), FightReason.NPC_SREVICE_FIGHT);
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\PCNpcFightService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */