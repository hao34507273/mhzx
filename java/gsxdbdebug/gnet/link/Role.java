/*     */ package gnet.link;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import xdb.util.Counter;
/*     */ import xio.Creator;
/*     */ import xio.Manager;
/*     */ import xio.Manager.Coder;
/*     */ import xio.Protocol;
/*     */ import xio.Protocol.Coder;
/*     */ import xio.Protocol.Stub;
/*     */ import xio.Xio;
/*     */ 
/*     */ public class Role
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*  25 */   private final LinkSessons linkSessons = new LinkSessons();
/*     */   
/*  27 */   private static Counter counterSend = new Counter(xdb.Xdb.mbeans(), "gnet.link.Role", "Protocols.send");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static class LinkSessons
/*     */   {
/*  38 */     private Set<Link.Session> sessions = new HashSet();
/*     */     
/*  40 */     private ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int size()
/*     */     {
/*  47 */       this.lock.readLock().lock();
/*     */       try {
/*  49 */         return this.sessions.size();
/*     */       }
/*     */       catch (Exception e) {}finally {
/*  52 */         this.lock.readLock().unlock();
/*     */       }
/*  54 */       return 0;
/*     */     }
/*     */     
/*     */     public Link.Session remove(Link link, int linksid) {
/*  58 */       this.lock.writeLock().lock();
/*     */       try {
/*  60 */         Iterator<Link.Session> iterator = this.sessions.iterator();
/*  61 */         while (iterator.hasNext()) {
/*  62 */           Link.Session session = (Link.Session)iterator.next();
/*  63 */           if ((session.getSid() == linksid) && (session.getLink().getLinkid() == link.getLinkid())) {
/*  64 */             iterator.remove();
/*  65 */             return session;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {}finally {
/*  70 */         this.lock.writeLock().unlock();
/*     */       }
/*  72 */       return null;
/*     */     }
/*     */     
/*     */     public boolean contains(Link link, int linksid) {
/*  76 */       this.lock.readLock().lock();
/*     */       try {
/*  78 */         Iterator<Link.Session> iterator = this.sessions.iterator();
/*  79 */         while (iterator.hasNext()) {
/*  80 */           Link.Session session = (Link.Session)iterator.next();
/*  81 */           if ((session.getSid() == linksid) && (session.getLink().getLinkid() == link.getLinkid())) {
/*  82 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {}finally {
/*  87 */         this.lock.readLock().unlock();
/*     */       }
/*  89 */       return false;
/*     */     }
/*     */     
/*     */     public void addSession(Link.Session session) {
/*  93 */       this.lock.writeLock().lock();
/*     */       try {
/*  95 */         if (this.sessions.contains(session)) {
/*     */           return;
/*     */         }
/*  98 */         this.sessions.add(session);
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 101 */         this.lock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean send(Protocol p2) {
/* 106 */       this.lock.readLock().lock();
/*     */       try {
/* 108 */         boolean ret = false;
/* 109 */         for (Link.Session session : this.sessions) {
/* 110 */           Send p1 = new Send();
/* 111 */           p1.linksids.add(Integer.valueOf(session.getSid()));
/* 112 */           p1.ptype = p2.getType();
/* 113 */           p1.pdata = new OctetsStream().marshal(p2);
/* 114 */           session.getXio().getCreator().getManager().getCoder().checkSend(p2, p1.pdata.size());
/* 115 */           Role.counterSend.increment(p2.getClass().getName());
/* 116 */           boolean send = p1.send(session.getXio());
/* 117 */           if (!ret) {
/* 118 */             ret = send;
/*     */           }
/*     */         }
/* 121 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 124 */         this.lock.readLock().unlock();
/*     */       }
/*     */       
/* 127 */       return false;
/*     */     }
/*     */     
/*     */     public void checkSend(Protocol p2, int dataSize) {
/* 131 */       this.lock.readLock().lock();
/*     */       try {
/* 133 */         for (Link.Session session : this.sessions) {
/* 134 */           session.getXio().getCreator().getManager().getCoder().checkSend(p2, dataSize);
/*     */         }
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 138 */         this.lock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean send(int protocolType, Octets protocolOctets) {
/* 143 */       this.lock.readLock().lock();
/*     */       try {
/* 145 */         boolean ret = false;
/* 146 */         for (Link.Session session : this.sessions) {
/* 147 */           Send p1 = new Send();
/* 148 */           p1.linksids.add(Integer.valueOf(session.getSid()));
/* 149 */           p1.ptype = protocolType;
/* 150 */           p1.pdata = protocolOctets;
/*     */           
/* 152 */           Role.counterSend.increment(((Protocol.Coder)session.getXio().getCreator().getManager().getCoder()).getStub(protocolType).getCls().getName());
/*     */           
/* 154 */           boolean send = p1.send(session.getXio());
/* 155 */           if (!ret) {
/* 156 */             ret = send;
/*     */           }
/*     */         }
/* 159 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 162 */         this.lock.readLock().unlock();
/*     */       }
/* 164 */       return false;
/*     */     }
/*     */     
/*     */     public boolean kick(int error) {
/* 168 */       this.lock.readLock().lock();
/*     */       try {
/* 170 */         boolean ret = false;
/* 171 */         for (Link.Session session : this.sessions) {
/* 172 */           Kick p1 = new Kick();
/* 173 */           p1.linksid = session.getSid();
/* 174 */           p1.action = 1;
/* 175 */           p1.error = error;
/* 176 */           boolean send = p1.send(session.getXio());
/* 177 */           if (!ret) {
/* 178 */             ret = send;
/*     */           }
/*     */         }
/* 181 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 184 */         this.lock.readLock().unlock();
/*     */       }
/* 186 */       return false;
/*     */     }
/*     */     
/*     */     public boolean gacdkick(int error) {
/* 190 */       this.lock.readLock().lock();
/*     */       try {
/* 192 */         boolean ret = false;
/* 193 */         for (Link.Session session : this.sessions) {
/* 194 */           Kick p1 = new Kick();
/* 195 */           p1.linksid = session.getSid();
/* 196 */           p1.action = 3;
/* 197 */           p1.error = error;
/* 198 */           boolean send = p1.send(session.getXio());
/* 199 */           if (!ret) {
/* 200 */             ret = send;
/*     */           }
/*     */         }
/* 203 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 206 */         this.lock.readLock().unlock();
/*     */       }
/* 208 */       return false;
/*     */     }
/*     */     
/*     */     public boolean bind(int pvid) {
/* 212 */       this.lock.readLock().lock();
/*     */       try {
/* 214 */         boolean ret = false;
/* 215 */         for (Link.Session session : this.sessions) {
/* 216 */           Bind p1 = new Bind();
/* 217 */           p1.pvid = pvid;
/* 218 */           p1.linksids.add(Integer.valueOf(session.getSid()));
/* 219 */           boolean send = p1.send(session.getXio());
/* 220 */           if (!ret) {
/* 221 */             ret = send;
/*     */           }
/*     */         }
/* 224 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 227 */         this.lock.readLock().unlock();
/*     */       }
/* 229 */       return false;
/*     */     }
/*     */     
/*     */     public boolean unbind(int pvid) {
/* 233 */       this.lock.readLock().lock();
/*     */       try {
/* 235 */         boolean ret = false;
/* 236 */         for (Link.Session session : this.sessions) {
/* 237 */           UnBind p1 = new UnBind();
/* 238 */           p1.pvid = pvid;
/* 239 */           p1.linksids.add(Integer.valueOf(session.getSid()));
/* 240 */           boolean send = p1.send(session.getXio());
/* 241 */           if (!ret) {
/* 242 */             ret = send;
/*     */           }
/*     */         }
/* 245 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 248 */         this.lock.readLock().unlock();
/*     */       }
/* 250 */       return false;
/*     */     }
/*     */     
/*     */     boolean setLogin(int login, long roleid) {
/* 254 */       this.lock.readLock().lock();
/*     */       try {
/* 256 */         boolean ret = false;
/* 257 */         for (Link.Session session : this.sessions) {
/* 258 */           HashSet<Integer> linksids = new HashSet();
/* 259 */           linksids.add(Integer.valueOf(session.getSid()));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 265 */           boolean send = new SetLogin(session.getSid(), login, roleid).send(session.getXio());
/* 266 */           if (!ret) {
/* 267 */             ret = send;
/*     */           }
/*     */         }
/* 270 */         return ret;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 273 */         this.lock.readLock().unlock();
/*     */       }
/* 275 */       return false;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 280 */       this.lock.readLock().lock();
/*     */       try {
/* 282 */         StringBuilder stringBuilder = new StringBuilder();
/* 283 */         stringBuilder.append("sessions,size:" + this.sessions.size() + "  ");
/* 284 */         for (Link.Session session : this.sessions) {
/* 285 */           stringBuilder.append(session.toString());
/*     */         }
/* 287 */         return stringBuilder.toString();
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 290 */         this.lock.readLock().unlock();
/*     */       }
/* 292 */       return "";
/*     */     }
/*     */     
/*     */     public List<Link.Session> getSessions() {
/* 296 */       List<Link.Session> retSessions = new ArrayList();
/* 297 */       this.lock.writeLock().lock();
/*     */       try {
/* 299 */         retSessions.addAll(this.sessions);
/* 300 */         return retSessions;
/*     */       }
/*     */       catch (Exception e) {}finally {
/* 303 */         this.lock.writeLock().unlock();
/*     */       }
/* 305 */       return retSessions;
/*     */     }
/*     */   }
/*     */   
/*     */   public Role(String userid, long roleid)
/*     */   {
/* 311 */     this.userid = userid;
/* 312 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   public long getRoleid() {
/* 316 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public String getUserid() {
/* 320 */     return this.userid;
/*     */   }
/*     */   
/*     */   public List<Link.Session> getLinkSessions() {
/* 324 */     return this.linkSessons.getSessions();
/*     */   }
/*     */   
/*     */   public boolean isOnline() {
/* 328 */     return this.linkSessons.size() != 0;
/*     */   }
/*     */   
/*     */   void linkBroken(Link link, int linksid)
/*     */   {
/* 333 */     Link.Session ls = this.linkSessons.remove(link, linksid);
/* 334 */     if (null != ls) {
/* 335 */       ls.close();
/*     */     }
/*     */   }
/*     */   
/*     */   void linkAttach(Link link, int linksid)
/*     */   {
/* 341 */     Link.Session session = link.attach(linksid, this);
/* 342 */     this.linkSessons.addSession(session);
/* 343 */     setLogin(1);
/*     */   }
/*     */   
/*     */   public boolean send(Protocol p2) {
/* 347 */     return this.linkSessons.send(p2);
/*     */   }
/*     */   
/*     */   public void checkSendManual(Protocol p2, int dataSize) {
/* 351 */     this.linkSessons.checkSend(p2, dataSize);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean send(int protocolType, Octets protocolOctets)
/*     */   {
/* 362 */     return this.linkSessons.send(protocolType, protocolOctets);
/*     */   }
/*     */   
/*     */   public boolean kick(int error) {
/* 366 */     return this.linkSessons.kick(error);
/*     */   }
/*     */   
/*     */   public boolean gacdkick(int error) {
/* 370 */     return this.linkSessons.gacdkick(error);
/*     */   }
/*     */   
/*     */   public boolean bind(int pvid) {
/* 374 */     return this.linkSessons.bind(pvid);
/*     */   }
/*     */   
/*     */   public boolean unbind(int pvid) {
/* 378 */     return this.linkSessons.unbind(pvid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean setLogin(int login)
/*     */   {
/* 388 */     return this.linkSessons.setLogin(login, this.roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     return "userid=" + this.userid + " roleid=" + this.roleid + this.linkSessons.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getChannel()
/*     */   {
/* 426 */     return Onlines.getInstance().findChannel(this.userid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Role.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */