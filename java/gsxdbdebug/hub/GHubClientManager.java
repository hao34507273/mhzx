/*     */ package hub;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Document;
/*     */ import xdb.Xdb;
/*     */ import xio.Engine;
/*     */ import xio.Manager;
/*     */ import xio.Protocol;
/*     */ import xio.Xio;
/*     */ 
/*     */ public class GHubClientManager extends Manager
/*     */ {
/*     */   final class XioInfo
/*     */   {
/*     */     private volatile int hubid;
/*     */     
/*     */     XioInfo() {}
/*     */     
/*     */     public int getHubid()
/*     */     {
/*  32 */       return this.hubid;
/*     */     }
/*     */   }
/*     */   
/*  36 */   private static GHubClientManager instance = null;
/*     */   
/*     */   public static GHubClientManager getInstance()
/*     */   {
/*  40 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void loadConf(String conf)
/*     */     throws Exception
/*     */   {
/*  50 */     Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(conf);
/*  51 */     Engine.getInstance().register(new xio.XioConf(doc.getDocumentElement()));
/*     */   }
/*     */   
/*  54 */   private final List<Integer> hubids = new ArrayList();
/*  55 */   private final Map<Integer, Xio> hubidToXioMap = new HashMap();
/*  56 */   private Map<Xio, XioInfo> xioToInfoMap = new HashMap();
/*     */   
/*  58 */   private final Lock mutex = new java.util.concurrent.locks.ReentrantLock();
/*     */   
/*     */   public GHubClientManager()
/*     */   {
/*  62 */     instance = this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void beforeSend(Protocol p, Xio to)
/*     */   {
/*  71 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/*  73 */       GameServer.logger().debug(String.format("[hub]GHubClientManager.beforeSend@dump send protocol|protocol=%s|to=%s", new Object[] { p, to }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void addXio(Xio xio)
/*     */   {
/*  81 */     boolean added = false;
/*  82 */     if (Engine.isOpen())
/*     */     {
/*  84 */       this.mutex.lock();
/*     */       try
/*     */       {
/*  87 */         added = ((super.getMaxSize() <= 0) || (this.xioToInfoMap.size() < super.getMaxSize())) && (null == this.xioToInfoMap.put(xio, new XioInfo()));
/*     */ 
/*     */       }
/*     */       finally
/*     */       {
/*  92 */         this.mutex.unlock();
/*     */       }
/*     */     }
/*  95 */     if (!added)
/*     */     {
/*  97 */       GameServer.logger().info(String.format("[hub]GHubClientManager.addXio@add xio failed|xio=%s|size=%d/%d", new Object[] { xio.toString(), Integer.valueOf(size()), Integer.valueOf(getMaxSize()) }));
/*     */       
/*     */ 
/* 100 */       xio.close();
/*     */     }
/*     */     else
/*     */     {
/* 104 */       GameServer.logger().info(String.format(String.format("[xiomgr]XioManager.addXio@add xio success|xio=%s", new Object[] { xio.toString() }), new Object[0]));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 109 */     GHubHelper.regisGameServer(xio);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void removeXio(Xio xio, Throwable e)
/*     */   {
/* 115 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 118 */       XioInfo info = (XioInfo)this.xioToInfoMap.remove(xio);
/* 119 */       if (null != info)
/*     */       {
/* 121 */         Integer hubid = Integer.valueOf(info.getHubid());
/* 122 */         if (0 != hubid.intValue())
/*     */         {
/* 124 */           this.hubidToXioMap.remove(hubid);
/*     */           
/* 126 */           GameServer.logger().info(String.format("[hub]GHubClientManager.removeXio@remove xio success|hubid=%d", new Object[] { hubid }), e);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 133 */       this.mutex.unlock();
/*     */     }
/*     */     
/* 136 */     KeepAliveManager.getInstance().removeXio(xio);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void close()
/*     */   {
/* 142 */     super.close();
/*     */     
/*     */ 
/* 145 */     Map<Xio, XioInfo> tmp = null;
/* 146 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 149 */       tmp = this.xioToInfoMap;
/* 150 */       this.xioToInfoMap = new HashMap();
/* 151 */       this.hubids.clear();
/* 152 */       this.hubidToXioMap.clear();
/*     */     }
/*     */     finally
/*     */     {
/* 156 */       this.mutex.unlock();
/*     */     }
/*     */     
/* 159 */     for (Map.Entry<Xio, XioInfo> e : tmp.entrySet())
/*     */     {
/* 161 */       ((Xio)e.getKey()).close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int size()
/*     */   {
/* 168 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 171 */       return this.xioToInfoMap.size();
/*     */     }
/*     */     finally
/*     */     {
/* 175 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Xio get()
/*     */   {
/* 182 */     this.mutex.lock();
/*     */     try {
/*     */       Xio localXio;
/* 185 */       if (this.xioToInfoMap.isEmpty())
/*     */       {
/* 187 */         return null;
/*     */       }
/* 189 */       return (Xio)this.xioToInfoMap.keySet().iterator().next();
/*     */     }
/*     */     finally
/*     */     {
/* 193 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void execute(Protocol p)
/*     */   {
/* 200 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 202 */       GameServer.logger().debug(String.format("[hub]GHubClientManager.execute@begin dispatch protocol|protocol=%s", new Object[] { p }));
/*     */     }
/*     */     
/* 205 */     super.execute(p);
/*     */   }
/*     */   
/*     */   public XioInfo getXioInfo(Xio xio)
/*     */   {
/* 210 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 213 */       return (XioInfo)this.xioToInfoMap.get(xio);
/*     */     }
/*     */     finally
/*     */     {
/* 217 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Xio getXio(int hubid)
/*     */   {
/* 223 */     Xio xio = null;
/*     */     
/* 225 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 228 */       xio = (Xio)this.hubidToXioMap.get(Integer.valueOf(hubid));
/*     */     }
/*     */     finally
/*     */     {
/* 232 */       this.mutex.unlock();
/*     */     }
/* 234 */     return xio;
/*     */   }
/*     */   
/*     */   public int getHubid(Xio xio)
/*     */   {
/* 239 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 242 */       XioInfo xioInfo = (XioInfo)this.xioToInfoMap.get(xio);
/* 243 */       if (null != xioInfo)
/*     */       {
/* 245 */         return xioInfo.hubid;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 250 */       this.mutex.unlock();
/*     */     }
/*     */     
/* 253 */     return 0;
/*     */   }
/*     */   
/*     */   public void sendPing()
/*     */   {
/* 258 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 261 */       if (this.hubidToXioMap.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 266 */       ping = new Ping();
/* 267 */       ping.direction = -1;
/* 268 */       ping.src_id = mzm.gsp.GameServerInfoManager.getZoneId();
/* 269 */       ping.code = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 271 */       for (Map.Entry<Integer, Xio> entry : this.hubidToXioMap.entrySet())
/*     */       {
/* 273 */         ping.dst_id = ((Integer)entry.getKey()).intValue();
/* 274 */         ping.send((Xio)entry.getValue());
/*     */       }
/*     */     }
/*     */     finally {
/*     */       Ping ping;
/* 279 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Xio getRouteXio()
/*     */   {
/* 285 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 288 */       if (this.hubids.isEmpty())
/*     */       {
/* 290 */         return null;
/*     */       }
/*     */       
/* 293 */       int size = this.hubids.size();
/* 294 */       int index = Xdb.random().nextInt(size);
/* 295 */       for (int i = 0; i < size; i++)
/*     */       {
/* 297 */         int hubid = ((Integer)this.hubids.get(index++ % size)).intValue();
/* 298 */         Xio to = (Xio)this.hubidToXioMap.get(Integer.valueOf(hubid));
/* 299 */         if (to != null)
/*     */         {
/* 301 */           return to;
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 307 */       this.mutex.unlock();
/*     */     }
/*     */     
/* 310 */     return null;
/*     */   }
/*     */   
/*     */   public Collection<Xio> getRouteXios()
/*     */   {
/* 315 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 318 */       if (this.hubids.isEmpty())
/*     */       {
/* 320 */         return null;
/*     */       }
/*     */       
/* 323 */       Object xios = new ArrayList();
/* 324 */       int size = this.hubids.size();
/* 325 */       int needXioNum = size / 2 + 1;
/* 326 */       int index = Xdb.random().nextInt(size);
/* 327 */       for (int i = 0; i < size; i++)
/*     */       {
/* 329 */         int hubid = ((Integer)this.hubids.get(index++ % size)).intValue();
/* 330 */         Xio to = (Xio)this.hubidToXioMap.get(Integer.valueOf(hubid));
/* 331 */         if (to != null)
/*     */         {
/* 333 */           ((List)xios).add(to);
/* 334 */           if (((List)xios).size() >= needXioNum) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 340 */       return (int)xios;
/*     */     }
/*     */     finally
/*     */     {
/* 344 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean send(int hubid, Protocol proto)
/*     */   {
/* 350 */     Xio xio = getXio(hubid);
/* 351 */     if (xio == null)
/*     */     {
/* 353 */       return false;
/*     */     }
/*     */     
/* 356 */     return proto.send(xio);
/*     */   }
/*     */   
/*     */   public boolean send(Protocol proto)
/*     */   {
/* 361 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 364 */       if (this.hubids.isEmpty())
/*     */       {
/* 366 */         return false;
/*     */       }
/*     */       
/* 369 */       int size = this.hubids.size();
/* 370 */       int index = Xdb.random().nextInt(size);
/* 371 */       for (int i = 0; i < size; i++)
/*     */       {
/* 373 */         int hubid = ((Integer)this.hubids.get(index++ % size)).intValue();
/* 374 */         Xio to = (Xio)this.hubidToXioMap.get(Integer.valueOf(hubid));
/* 375 */         if ((to != null) && (proto.send(to)))
/*     */         {
/* 377 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 383 */       this.mutex.unlock();
/*     */     }
/*     */     
/* 386 */     return false;
/*     */   }
/*     */   
/*     */   public int onRegisGameServerRsp(RegisterGameServerRsp rsp)
/*     */   {
/* 391 */     Xio xio = rsp.getConnection();
/*     */     
/* 393 */     this.mutex.lock();
/*     */     try
/*     */     {
/* 396 */       int retcode = rsp.retcode;
/* 397 */       int hubid = rsp.hubid;
/* 398 */       if (retcode != 0)
/*     */       {
/* 400 */         GameServer.logger().error(String.format("[hub]GHubClientManager.onRegisGameServerRsp@regis game server error|retcode=%d|hubid=%d|xio=%s", new Object[] { Integer.valueOf(retcode), Integer.valueOf(hubid), xio.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 404 */         return -1;
/*     */       }
/*     */       
/* 407 */       XioInfo info = (XioInfo)this.xioToInfoMap.get(xio);
/* 408 */       int j; if (null == info)
/*     */       {
/* 410 */         GameServer.logger().error(String.format("[hub]GHubClientManager.onRegisGameServerRsp@xio info is null|retcode=%d|hubid=%d|xio=%s", new Object[] { Integer.valueOf(retcode), Integer.valueOf(hubid), xio.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 415 */         return -1;
/*     */       }
/*     */       
/* 418 */       if (hubid < 1)
/*     */       {
/* 420 */         GameServer.logger().error(String.format("[hub]GHubClientManager.onRegisGameServerRsp@invalid hubid|retcode=%d|hubid=%d|xio=%s", new Object[] { Integer.valueOf(retcode), Integer.valueOf(hubid), xio.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 424 */         return -1;
/*     */       }
/*     */       
/* 427 */       Xio oldXio = (Xio)this.hubidToXioMap.get(Integer.valueOf(hubid));
/* 428 */       int k; if (null != oldXio)
/*     */       {
/* 430 */         GameServer.logger().error(String.format("[hub]GHubClientManager.onRegisGameServerRsp@repeated hubid|retcode=%d|hubid=%d|xio=%s|old_xio=%s", new Object[] { Integer.valueOf(retcode), Integer.valueOf(hubid), xio.toString(), oldXio.toString() }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 435 */         xio.close();
/*     */         
/* 437 */         return -1;
/*     */       }
/*     */       
/* 440 */       info.hubid = hubid;
/* 441 */       this.hubidToXioMap.put(Integer.valueOf(hubid), xio);
/* 442 */       this.hubids.add(Integer.valueOf(hubid));
/*     */       
/* 444 */       GameServer.logger().info(String.format("[hub]GHubClientManager.onRegisGameServerRsp@regis game server success|retcode=%d|hubid=%d|xio=%s", new Object[] { Integer.valueOf(retcode), Integer.valueOf(hubid), xio.toString() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 449 */       return 0;
/*     */     }
/*     */     finally
/*     */     {
/* 453 */       this.mutex.unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\GHubClientManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */