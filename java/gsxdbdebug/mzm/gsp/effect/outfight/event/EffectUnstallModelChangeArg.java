/*    */ package mzm.gsp.effect.outfight.event;
/*    */ 
/*    */ public class EffectUnstallModelChangeArg {
/*    */   private final long roleId;
/*    */   private final int buffModelChangeCfgId;
/*    */   
/*    */   public EffectUnstallModelChangeArg(long _roleId, int _buffModelChangeCfgId) {
/*  8 */     this.roleId = _roleId;
/*  9 */     this.buffModelChangeCfgId = _buffModelChangeCfgId;
/*    */   }
/*    */   
/*    */   public long getRoleId() {
/* 13 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getBuffModelChangeCfgId() {
/* 17 */     return this.buffModelChangeCfgId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\event\EffectUnstallModelChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */