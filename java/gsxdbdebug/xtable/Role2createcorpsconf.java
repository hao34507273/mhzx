/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.CreateCorpsConfBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2createcorpsconf
/*    */ {
/*    */   public static CreateCorpsConfBean get(Long key)
/*    */   {
/* 12 */     return (CreateCorpsConfBean)_Tables_.getInstance().role2createcorpsconf.get(key);
/*    */   }
/*    */   
/*    */   public static CreateCorpsConfBean get(Long key, CreateCorpsConfBean value)
/*    */   {
/* 17 */     return (CreateCorpsConfBean)_Tables_.getInstance().role2createcorpsconf.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CreateCorpsConfBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2createcorpsconf.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2createcorpsconf.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CreateCorpsConfBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2createcorpsconf.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2createcorpsconf.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CreateCorpsConfBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2createcorpsconf.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CreateCorpsConfBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2createcorpsconf;
/*    */   }
/*    */   
/*    */   public static List<Long> selectAllroles(Long key)
/*    */   {
/* 52 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(CreateCorpsConfBean v)
/*    */       {
/* 56 */         return v.getAllrolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectAcceptroles(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(CreateCorpsConfBean v)
/*    */       {
/* 67 */         return v.getAcceptrolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSessionid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(CreateCorpsConfBean v)
/*    */       {
/* 78 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCorpsbadge(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(CreateCorpsConfBean v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getCorpsbadge());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2createcorpsconf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */