/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.TitleSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2titlesession
/*    */ {
/*    */   public static TitleSessionInfo get(Long key)
/*    */   {
/* 12 */     return (TitleSessionInfo)_Tables_.getInstance().role2titlesession.get(key);
/*    */   }
/*    */   
/*    */   public static TitleSessionInfo get(Long key, TitleSessionInfo value)
/*    */   {
/* 17 */     return (TitleSessionInfo)_Tables_.getInstance().role2titlesession.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TitleSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2titlesession.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2titlesession.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TitleSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2titlesession.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2titlesession.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TitleSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2titlesession.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TitleSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2titlesession;
/*    */   }
/*    */   
/*    */   public static TitleSessionInfo select(Long key)
/*    */   {
/* 52 */     (TitleSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public TitleSessionInfo get(TitleSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectAppsession(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(TitleSessionInfo v)
/*    */       {
/* 67 */         return v.getAppsessionAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectTitlesession(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(TitleSessionInfo v)
/*    */       {
/* 78 */         return v.getTitlesessionAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2titlesession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */