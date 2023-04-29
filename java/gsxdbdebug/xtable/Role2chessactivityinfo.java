/*    */ package xtable;
/*    */ 
/*    */ import xbean.ChessActivityInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2chessactivityinfo
/*    */ {
/*    */   public static ChessActivityInfo get(Long key)
/*    */   {
/* 12 */     return (ChessActivityInfo)_Tables_.getInstance().role2chessactivityinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ChessActivityInfo get(Long key, ChessActivityInfo value)
/*    */   {
/* 17 */     return (ChessActivityInfo)_Tables_.getInstance().role2chessactivityinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChessActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2chessactivityinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2chessactivityinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChessActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2chessactivityinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2chessactivityinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ChessActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2chessactivityinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChessActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2chessactivityinfo;
/*    */   }
/*    */   
/*    */   public static ChessActivityInfo select(Long key)
/*    */   {
/* 52 */     (ChessActivityInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ChessActivityInfo get(ChessActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectToday_win_count(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ChessActivityInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getToday_win_count());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectToday_lose_count(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ChessActivityInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getToday_lose_count());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectToday_draw_count(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ChessActivityInfo v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getToday_draw_count());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chessactivityinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */