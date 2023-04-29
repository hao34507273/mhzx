/*     */ package mzm.gsp.gang.cache;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.gang.MemberInfo;
/*     */ 
/*     */ public class Gang
/*     */ {
/*  12 */   private Map<Long, Member> members = new java.util.HashMap();
/*     */   
/*  14 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */ 
/*     */   public boolean addMember(long roleid, Member member)
/*     */   {
/*  19 */     this.lock.writeLock().lock();
/*     */     try {
/*  21 */       Member old = (Member)this.members.put(Long.valueOf(roleid), member);
/*     */       boolean bool;
/*  23 */       if (old != null) {
/*  24 */         return false;
/*     */       }
/*     */       
/*  27 */       return true;
/*     */     } finally {
/*  29 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean removeMember(long roleid) {
/*  34 */     this.lock.writeLock().lock();
/*     */     try {
/*  36 */       Member member = (Member)this.members.remove(Long.valueOf(roleid));
/*     */       boolean bool;
/*  38 */       if (member != null) {
/*  39 */         return false;
/*     */       }
/*     */       
/*  42 */       return true;
/*     */     } finally {
/*  44 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Member getMember(long roleid) {
/*  49 */     this.lock.readLock().lock();
/*     */     try {
/*  51 */       return (Member)this.members.get(Long.valueOf(roleid));
/*     */     } finally {
/*  53 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillMemberListBean(java.util.List<MemberInfo> memberListBean)
/*     */   {
/*  59 */     this.lock.readLock().lock();
/*     */     try {
/*  61 */       Iterator<Map.Entry<Long, Member>> iter = this.members.entrySet().iterator();
/*  62 */       while (iter.hasNext()) {
/*  63 */         Map.Entry<Long, Member> entry = (Map.Entry)iter.next();
/*  64 */         long memberid = ((Long)entry.getKey()).longValue();
/*  65 */         Member member = (Member)entry.getValue();
/*     */         
/*  67 */         MemberInfo memberInfoBean = new MemberInfo();
/*  68 */         member.fillMemberInfoBean(memberid, memberInfoBean);
/*  69 */         memberListBean.add(memberInfoBean);
/*     */       }
/*     */     } finally {
/*  72 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOnlineCount()
/*     */   {
/*  81 */     int onlineCount = 0;
/*  82 */     this.lock.readLock().lock();
/*     */     try {
/*  84 */       Iterator<Member> iter = this.members.values().iterator();
/*  85 */       while (iter.hasNext()) {
/*  86 */         Member member = (Member)iter.next();
/*  87 */         long offlineTime = member.getOfflineTime();
/*  88 */         if (offlineTime <= 0L) {
/*  89 */           onlineCount++;
/*     */         }
/*     */       }
/*     */     } finally {
/*  93 */       this.lock.readLock().unlock();
/*     */     }
/*  95 */     return onlineCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 102 */     StringBuilder sb = new StringBuilder();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 109 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\cache\Gang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */