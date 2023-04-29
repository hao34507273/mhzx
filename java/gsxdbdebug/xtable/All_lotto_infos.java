/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AllLottoInfo;
/*    */ import xbean.AllLottoTurnInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class All_lotto_infos
/*    */ {
/*    */   public static AllLottoInfo get(Long key)
/*    */   {
/* 12 */     return (AllLottoInfo)_Tables_.getInstance().all_lotto_infos.get(key);
/*    */   }
/*    */   
/*    */   public static AllLottoInfo get(Long key, AllLottoInfo value)
/*    */   {
/* 17 */     return (AllLottoInfo)_Tables_.getInstance().all_lotto_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AllLottoInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().all_lotto_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().all_lotto_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AllLottoInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().all_lotto_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().all_lotto_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AllLottoInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().all_lotto_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AllLottoInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().all_lotto_infos;
/*    */   }
/*    */   
/*    */   public static AllLottoInfo select(Long key)
/*    */   {
/* 52 */     (AllLottoInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AllLottoInfo get(AllLottoInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, AllLottoTurnInfo> selectTurn_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, AllLottoTurnInfo> get(AllLottoInfo v)
/*    */       {
/* 67 */         return v.getTurn_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\All_lotto_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */