/*    */ package xtable;
/*    */ 
/*    */ import xbean.ChineseValentineAwardRecord;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2chinesevalentineaward
/*    */ {
/*    */   public static ChineseValentineAwardRecord get(Long key)
/*    */   {
/* 12 */     return (ChineseValentineAwardRecord)_Tables_.getInstance().role2chinesevalentineaward.get(key);
/*    */   }
/*    */   
/*    */   public static ChineseValentineAwardRecord get(Long key, ChineseValentineAwardRecord value)
/*    */   {
/* 17 */     return (ChineseValentineAwardRecord)_Tables_.getInstance().role2chinesevalentineaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChineseValentineAwardRecord value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2chinesevalentineaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2chinesevalentineaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChineseValentineAwardRecord value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2chinesevalentineaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2chinesevalentineaward.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ChineseValentineAwardRecord> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2chinesevalentineaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChineseValentineAwardRecord> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2chinesevalentineaward;
/*    */   }
/*    */   
/*    */   public static ChineseValentineAwardRecord select(Long key)
/*    */   {
/* 52 */     (ChineseValentineAwardRecord)getTable().select(key, new TField()
/*    */     {
/*    */       public ChineseValentineAwardRecord get(ChineseValentineAwardRecord v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectAwardcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ChineseValentineAwardRecord v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getAwardcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ChineseValentineAwardRecord v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chinesevalentineaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */