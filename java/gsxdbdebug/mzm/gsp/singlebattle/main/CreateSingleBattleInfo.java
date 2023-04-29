/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class CreateSingleBattleInfo
/*    */ {
/*    */   private final int _battleCfgId;
/*    */   private final long _battleId;
/* 11 */   private final Map<Integer, Set<Long>> _campId2roleIds = new HashMap();
/*    */   
/*    */   public CreateSingleBattleInfo(int battleCfgId, long battleId, Map<Integer, Set<Long>> campId2roleIds)
/*    */   {
/* 15 */     this._battleCfgId = battleCfgId;
/* 16 */     this._battleId = battleId;
/* 17 */     this._campId2roleIds.putAll(campId2roleIds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isCreateSuc()
/*    */   {
/* 27 */     return get_battleId() > 0L;
/*    */   }
/*    */   
/*    */   public int get_battleCfgId()
/*    */   {
/* 32 */     return this._battleCfgId;
/*    */   }
/*    */   
/*    */   public long get_battleId()
/*    */   {
/* 37 */     return this._battleId;
/*    */   }
/*    */   
/*    */   public Map<Integer, Set<Long>> get_campId2roleIds()
/*    */   {
/* 42 */     return this._campId2roleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\CreateSingleBattleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */