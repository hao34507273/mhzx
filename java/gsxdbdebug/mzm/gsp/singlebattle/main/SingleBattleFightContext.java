/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleBattleFightContext
/*    */   implements FightContext
/*    */ {
/*    */   private final long battleId;
/*    */   private final int battleCfgId;
/*    */   
/*    */   public SingleBattleFightContext(long battleId, int battleCfgId)
/*    */   {
/* 22 */     this.battleId = battleId;
/* 23 */     this.battleCfgId = battleCfgId;
/*    */   }
/*    */   
/* 26 */   private final Map<Integer, EachPlayFightContext> playType2Context = new HashMap();
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 31 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public EachPlayFightContext getPlayFightContext(int playType)
/*    */   {
/* 42 */     return (EachPlayFightContext)this.playType2Context.get(Integer.valueOf(playType));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getBattleId()
/*    */   {
/* 52 */     return this.battleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getBattleCfgId()
/*    */   {
/* 62 */     return this.battleCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getPlayCfgId(int playType)
/*    */   {
/* 72 */     Integer cfgId = (Integer)SingleBattleInterface.getPlayType2CfgId(this.battleCfgId).get(Integer.valueOf(playType));
/* 73 */     return cfgId == null ? -1 : cfgId.intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */