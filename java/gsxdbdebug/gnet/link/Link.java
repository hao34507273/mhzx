/*     */ package gnet.link;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import xio.Xio;
/*     */ 
/*     */ public final class Link
/*     */ {
/*     */   private final Xio io;
/*  12 */   private int linkid = 0;
/*  13 */   private boolean isWebLink = false;
/*  14 */   private Map<Integer, Role> roles = new HashMap();
/*     */   
/*     */   public String toString()
/*     */   {
/*  18 */     return this.io == null ? "io is null" : this.io.toString();
/*     */   }
/*     */   
/*     */   public synchronized int getLinkid() {
/*  22 */     return this.linkid;
/*     */   }
/*     */   
/*     */   public synchronized void setLinkid(int linkid) {
/*  26 */     this.linkid = linkid;
/*     */   }
/*     */   
/*     */   public synchronized boolean isWebLink() {
/*  30 */     return this.isWebLink;
/*     */   }
/*     */   
/*     */   public synchronized void setIsWebLink(boolean isWebLink) {
/*  34 */     this.isWebLink = isWebLink;
/*     */   }
/*     */   
/*     */   public final class Session {
/*     */     private final int sid;
/*     */     
/*     */     private Session(int sid) {
/*  41 */       this.sid = sid;
/*     */     }
/*     */     
/*     */     void close() {
/*  45 */       Link.this.remove(this.sid);
/*     */     }
/*     */     
/*     */     public final int getSid() {
/*  49 */       return this.sid;
/*     */     }
/*     */     
/*     */     public Link getLink() {
/*  53 */       return Link.this;
/*     */     }
/*     */     
/*     */     public Xio getXio() {
/*  57 */       return Link.this.io;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*  62 */       return Link.this.io.toString() + "," + this.sid;
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj)
/*     */     {
/*  67 */       if ((obj instanceof Session)) {
/*  68 */         Session session = (Session)obj;
/*  69 */         if (session.getSid() != getSid()) {
/*  70 */           return false;
/*     */         }
/*  72 */         if (session.getLink().getLinkid() != getLink().getLinkid()) {
/*  73 */           return false;
/*     */         }
/*  75 */         return true;
/*     */       }
/*  77 */       return false;
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/*  82 */       return this.sid;
/*     */     }
/*     */   }
/*     */   
/*     */   Link(Xio link) {
/*  87 */     this.io = link;
/*     */   }
/*     */   
/*     */   public Xio getXio() {
/*  91 */     return this.io;
/*     */   }
/*     */   
/*     */   public synchronized Role find(Integer linksid) {
/*  95 */     return (Role)this.roles.get(linksid);
/*     */   }
/*     */   
/*     */   synchronized Session attach(int linksid, Role role)
/*     */   {
/* 100 */     Role old = (Role)this.roles.put(Integer.valueOf(linksid), role);
/* 101 */     if (null != old)
/* 102 */       xdb.Trace.info("role rebind link " + old + "->" + role);
/* 103 */     return new Session(linksid, null);
/*     */   }
/*     */   
/*     */   private synchronized void remove(int linksid) {
/* 107 */     this.roles.remove(Integer.valueOf(linksid));
/*     */   }
/*     */   
/*     */   Session newSession(int linksid) {
/* 111 */     return new Session(linksid, null);
/*     */   }
/*     */   
/*     */   Collection<Role> close() {
/*     */     Map<Integer, Role> tmp;
/* 116 */     synchronized (this) {
/* 117 */       tmp = this.roles;
/* 118 */       this.roles = new HashMap();
/*     */     }
/* 120 */     for (Object entry : tmp.entrySet()) {
/* 121 */       Role role = (Role)((Map.Entry)entry).getValue();
/* 122 */       role.linkBroken(this, ((Integer)((Map.Entry)entry).getKey()).intValue());
/*     */     }
/* 124 */     this.io.close();
/* 125 */     return tmp.values();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Link.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */