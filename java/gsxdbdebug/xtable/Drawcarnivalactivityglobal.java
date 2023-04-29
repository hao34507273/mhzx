/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DrawCarnivalActivityInfo;
/*    */ import xbean.DrawCarnivalGlobalInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Drawcarnivalactivityglobal
/*    */ {
/*    */   public static DrawCarnivalGlobalInfo get(Long key)
/*    */   {
/* 12 */     return (DrawCarnivalGlobalInfo)_Tables_.getInstance().drawcarnivalactivityglobal.get(key);
/*    */   }
/*    */   
/*    */   public static DrawCarnivalGlobalInfo get(Long key, DrawCarnivalGlobalInfo value)
/*    */   {
/* 17 */     return (DrawCarnivalGlobalInfo)_Tables_.getInstance().drawcarnivalactivityglobal.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DrawCarnivalGlobalInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().drawcarnivalactivityglobal.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().drawcarnivalactivityglobal.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DrawCarnivalGlobalInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().drawcarnivalactivityglobal.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().drawcarnivalactivityglobal.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, DrawCarnivalGlobalInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().drawcarnivalactivityglobal.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DrawCarnivalGlobalInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().drawcarnivalactivityglobal;
/*    */   }
/*    */   
/*    */   public static DrawCarnivalGlobalInfo select(Long key)
/*    */   {
/* 52 */     (DrawCarnivalGlobalInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public DrawCarnivalGlobalInfo get(DrawCarnivalGlobalInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectAward_pool_yuan_bao_count(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(DrawCarnivalGlobalInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getAward_pool_yuan_bao_count());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, DrawCarnivalActivityInfo> selectActivity_id2info(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, DrawCarnivalActivityInfo> get(DrawCarnivalGlobalInfo v)
/*    */       {
/* 78 */         return v.getActivity_id2infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Drawcarnivalactivityglobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */