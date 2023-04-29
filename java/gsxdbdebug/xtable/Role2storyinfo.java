/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.StoryInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2storyinfo
/*    */ {
/*    */   public static StoryInfo get(Long key)
/*    */   {
/* 12 */     return (StoryInfo)_Tables_.getInstance().role2storyinfo.get(key);
/*    */   }
/*    */   
/*    */   public static StoryInfo get(Long key, StoryInfo value)
/*    */   {
/* 17 */     return (StoryInfo)_Tables_.getInstance().role2storyinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, StoryInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2storyinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2storyinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, StoryInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2storyinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2storyinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, StoryInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2storyinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, StoryInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2storyinfo;
/*    */   }
/*    */   
/*    */   public static StoryInfo select(Long key)
/*    */   {
/* 52 */     (StoryInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public StoryInfo get(StoryInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectStoryids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(StoryInfo v)
/*    */       {
/* 67 */         return v.getStoryidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectReadtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StoryInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getReadtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectAwardtime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StoryInfo v)
/*    */       {
/* 89 */         return Long.valueOf(v.getAwardtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStorytime(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StoryInfo v)
/*    */       {
/* :0 */         return Long.valueOf(v.getStorytime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2storyinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */