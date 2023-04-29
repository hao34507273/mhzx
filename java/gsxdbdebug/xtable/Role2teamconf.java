/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.TeamConfirmBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2teamconf
/*    */ {
/*    */   public static TeamConfirmBean get(Long key)
/*    */   {
/* 12 */     return (TeamConfirmBean)_Tables_.getInstance().role2teamconf.get(key);
/*    */   }
/*    */   
/*    */   public static TeamConfirmBean get(Long key, TeamConfirmBean value)
/*    */   {
/* 17 */     return (TeamConfirmBean)_Tables_.getInstance().role2teamconf.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TeamConfirmBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2teamconf.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2teamconf.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TeamConfirmBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2teamconf.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2teamconf.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TeamConfirmBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2teamconf.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TeamConfirmBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2teamconf;
/*    */   }
/*    */   
/*    */   public static List<Long> selectAllroles(Long key)
/*    */   {
/* 52 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(TeamConfirmBean v)
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
/*    */       public List<Long> get(TeamConfirmBean v)
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
/*    */       public Long get(TeamConfirmBean v)
/*    */       {
/* 78 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectEndtime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(TeamConfirmBean v)
/*    */       {
/* 89 */         return Long.valueOf(v.getEndtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectConfirmtype(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(TeamConfirmBean v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getConfirmtype());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2teamconf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */