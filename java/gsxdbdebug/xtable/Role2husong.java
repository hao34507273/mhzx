/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.HuSongDataBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2husong
/*    */ {
/*    */   public static HuSongDataBean get(Long key)
/*    */   {
/* 12 */     return (HuSongDataBean)_Tables_.getInstance().role2husong.get(key);
/*    */   }
/*    */   
/*    */   public static HuSongDataBean get(Long key, HuSongDataBean value)
/*    */   {
/* 17 */     return (HuSongDataBean)_Tables_.getInstance().role2husong.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HuSongDataBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2husong.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2husong.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HuSongDataBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2husong.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2husong.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, HuSongDataBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2husong.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HuSongDataBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2husong;
/*    */   }
/*    */   
/*    */   public static HuSongDataBean select(Long key)
/*    */   {
/* 52 */     (HuSongDataBean)getTable().select(key, new TField()
/*    */     {
/*    */       public HuSongDataBean get(HuSongDataBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectParammap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(HuSongDataBean v)
/*    */       {
/* 67 */         return v.getParammapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSpecialcount(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(HuSongDataBean v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getSpecialcount());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2husong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */