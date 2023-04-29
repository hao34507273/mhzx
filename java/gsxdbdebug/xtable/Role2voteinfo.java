/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.VoteDatas;
/*    */ import xbean.VoteInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2voteinfo
/*    */ {
/*    */   public static VoteInfo get(Long key)
/*    */   {
/* 12 */     return (VoteInfo)_Tables_.getInstance().role2voteinfo.get(key);
/*    */   }
/*    */   
/*    */   public static VoteInfo get(Long key, VoteInfo value)
/*    */   {
/* 17 */     return (VoteInfo)_Tables_.getInstance().role2voteinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, VoteInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2voteinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2voteinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, VoteInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2voteinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2voteinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, VoteInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2voteinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, VoteInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2voteinfo;
/*    */   }
/*    */   
/*    */   public static VoteInfo select(Long key)
/*    */   {
/* 52 */     (VoteInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public VoteInfo get(VoteInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, VoteDatas> selectActivityid2votedata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, VoteDatas> get(VoteInfo v)
/*    */       {
/* 67 */         return v.getActivityid2votedataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2voteinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */