/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.StoryWall;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Storywall
/*    */ {
/*    */   public static StoryWall get(Long key)
/*    */   {
/* 12 */     return (StoryWall)_Tables_.getInstance().storywall.get(key);
/*    */   }
/*    */   
/*    */   public static StoryWall get(Long key, StoryWall value)
/*    */   {
/* 17 */     return (StoryWall)_Tables_.getInstance().storywall.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, StoryWall value)
/*    */   {
/* 22 */     _Tables_.getInstance().storywall.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().storywall.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, StoryWall value)
/*    */   {
/* 32 */     return _Tables_.getInstance().storywall.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().storywall.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, StoryWall> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().storywall.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, StoryWall> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().storywall;
/*    */   }
/*    */   
/*    */   public static StoryWall select(Long key)
/*    */   {
/* 52 */     (StoryWall)getTable().select(key, new TField()
/*    */     {
/*    */       public StoryWall get(StoryWall v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStoryrefreshtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StoryWall v)
/*    */       {
/* 67 */         return Long.valueOf(v.getStoryrefreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectStoryids(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(StoryWall v)
/*    */       {
/* 78 */         return v.getStoryidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMaxindex(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(StoryWall v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getMaxindex());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Storywall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */