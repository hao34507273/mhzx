/*     */ package mzm.gsp.wanted.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PageManager<T>
/*     */ {
/*  20 */   protected final ReentrantReadWriteLock recordsLock = new ReentrantReadWriteLock();
/*     */   
/*  22 */   protected final List<T> records = new ArrayList();
/*     */   
/*  24 */   protected final List<T> removedFromRecords = new ArrayList();
/*     */   private final int countPerPage;
/*     */   
/*     */   public PageManager(int countPerPage)
/*     */   {
/*  29 */     this.countPerPage = countPerPage;
/*     */   }
/*     */   
/*     */   public void loadData()
/*     */   {
/*  34 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  39 */         PageManager.this.loadDataFromDB();
/*  40 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void loadDataFromDB()
/*     */     throws Exception;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void deleteRecordInDB(T paramT);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void addRecordToDB(T paramT);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCountPerPage()
/*     */   {
/*  69 */     return this.countPerPage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTotalPage()
/*     */   {
/*  79 */     this.recordsLock.readLock().lock();
/*     */     try
/*     */     {
/*  82 */       return (this.records.size() + this.countPerPage - 1) / this.countPerPage;
/*     */     }
/*     */     finally
/*     */     {
/*  86 */       this.recordsLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<T> getPageFromHead(int pageNo)
/*     */   {
/*  99 */     if (pageNo < 1)
/*     */     {
/* 101 */       return null;
/*     */     }
/* 103 */     this.recordsLock.readLock().lock();
/*     */     try
/*     */     {
/* 106 */       List<T> result = new ArrayList();
/* 107 */       int totalPageCount = getTotalPage();
/* 108 */       List<T> localList1; if (totalPageCount == 0)
/*     */       {
/* 110 */         return result;
/*     */       }
/* 112 */       if (pageNo > totalPageCount)
/*     */       {
/* 114 */         return null;
/*     */       }
/*     */       
/* 117 */       int nextPageBeginIndex = pageNo * this.countPerPage;
/* 118 */       int leftPos = nextPageBeginIndex - this.countPerPage;
/* 119 */       int rightPos = nextPageBeginIndex > this.records.size() ? this.records.size() : nextPageBeginIndex;
/*     */       
/* 121 */       for (int i = leftPos; i < rightPos; i++)
/*     */       {
/* 123 */         result.add(this.records.get(i));
/*     */       }
/* 125 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 129 */       this.recordsLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<T> getPageFromTail(int pageNo)
/*     */   {
/* 142 */     if (pageNo < 1)
/*     */     {
/* 144 */       return null;
/*     */     }
/* 146 */     this.recordsLock.readLock().lock();
/*     */     try
/*     */     {
/* 149 */       List<T> result = new ArrayList();
/* 150 */       int totalPageCount = getTotalPage();
/* 151 */       List<T> localList1; if (totalPageCount == 0)
/*     */       {
/* 153 */         return result;
/*     */       }
/* 155 */       if (pageNo > totalPageCount)
/*     */       {
/* 157 */         return null;
/*     */       }
/* 159 */       int nextPageBeginIndex = this.records.size() - pageNo * this.countPerPage - 1;
/* 160 */       int rightPos = this.countPerPage + nextPageBeginIndex;
/* 161 */       int leftPos = nextPageBeginIndex > -1 ? nextPageBeginIndex : -1;
/*     */       
/* 163 */       for (int i = rightPos; i > leftPos; i--)
/*     */       {
/* 165 */         result.add(this.records.get(i));
/*     */       }
/* 167 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 171 */       this.recordsLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void deleteRecord(final T t)
/*     */     throws Exception
/*     */   {
/* 182 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 187 */         PageManager.this.deleteRecordInDB(t);
/* 188 */         PageManager.this.deleteRecordFromList(t);
/* 189 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void deleteRecordFromList(T t) throws Exception
/*     */   {
/* 196 */     this.recordsLock.writeLock().lock();
/*     */     try
/*     */     {
/* 199 */       if (this.records.remove(t))
/*     */       {
/* 201 */         this.removedFromRecords.add(t);
/* 202 */         onDeleteRecordFromList(t);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 207 */       this.recordsLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected abstract void onDeleteRecordFromList(T paramT)
/*     */     throws Exception;
/*     */   
/*     */ 
/*     */   public void addRecord(final T t)
/*     */     throws Exception
/*     */   {
/* 220 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 225 */         PageManager.this.addRecordToDB(t);
/* 226 */         PageManager.this.addRecordToList(t);
/* 227 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void addRecordToList(T t) throws Exception
/*     */   {
/* 234 */     this.recordsLock.writeLock().lock();
/*     */     try
/*     */     {
/* 237 */       if (this.records.contains(t)) {
/*     */         return;
/*     */       }
/*     */       
/* 241 */       this.records.add(t);
/* 242 */       onAddRecordToList(t);
/*     */     }
/*     */     finally
/*     */     {
/* 246 */       this.recordsLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void onAddRecordToList(T paramT)
/*     */     throws Exception;
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean containsRecord(T t)
/*     */   {
/* 260 */     this.recordsLock.readLock().lock();
/*     */     try
/*     */     {
/* 263 */       return this.records.contains(t);
/*     */     }
/*     */     finally
/*     */     {
/* 267 */       this.recordsLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<T> getRemovedFromRecords()
/*     */   {
/* 273 */     return this.removedFromRecords;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\PageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */