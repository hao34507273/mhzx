/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LeiTaiBean;
/*    */ import xbean.LeiTaiFight;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Leitai
/*    */ {
/*    */   public static LeiTaiBean get(Long key)
/*    */   {
/* 12 */     return (LeiTaiBean)_Tables_.getInstance().leitai.get(key);
/*    */   }
/*    */   
/*    */   public static LeiTaiBean get(Long key, LeiTaiBean value)
/*    */   {
/* 17 */     return (LeiTaiBean)_Tables_.getInstance().leitai.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LeiTaiBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().leitai.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().leitai.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LeiTaiBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().leitai.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().leitai.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LeiTaiBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().leitai.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LeiTaiBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().leitai;
/*    */   }
/*    */   
/*    */   public static LeiTaiBean select(Long key)
/*    */   {
/* 52 */     (LeiTaiBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LeiTaiBean get(LeiTaiBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, LeiTaiFight> selectFightmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, LeiTaiFight> get(LeiTaiBean v)
/*    */       {
/* 67 */         return v.getFightmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Leitai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */