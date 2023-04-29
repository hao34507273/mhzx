/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ 
/*    */ public class HulaFightContext
/*    */   implements FightContext
/*    */ {
/*    */   private final long roleid;
/*    */   private final long worldid;
/*    */   private final int seq;
/*    */   private final int modelId;
/*    */   private final int fightCfgId;
/*    */   private FightReason reason;
/*    */   
/*    */   public HulaFightContext(long roleid, long worldid, int seq, int modelId, int fightCfgId, FightReason fightReason)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.worldid = worldid;
/* 20 */     this.seq = seq;
/* 21 */     this.modelId = modelId;
/* 22 */     this.fightCfgId = fightCfgId;
/* 23 */     this.reason = fightReason;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 28 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public long getWorldid()
/*    */   {
/* 33 */     return this.worldid;
/*    */   }
/*    */   
/*    */   public int getSeq()
/*    */   {
/* 38 */     return this.seq;
/*    */   }
/*    */   
/*    */   public int getModelId()
/*    */   {
/* 43 */     return this.modelId;
/*    */   }
/*    */   
/*    */   public int getFightCfgId()
/*    */   {
/* 48 */     return this.fightCfgId;
/*    */   }
/*    */   
/*    */   public FightReason getReason()
/*    */   {
/* 53 */     return this.reason;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 59 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */