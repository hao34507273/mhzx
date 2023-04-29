/*    */ package gnet;
/*    */ 
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
/*    */ import org.w3c.dom.Document;
/*    */ import xio.Engine;
/*    */ import xio.Protocol;
/*    */ import xio.Xio;
/*    */ 
/*    */ public class GDeliveryManager extends xio.Manager
/*    */ {
/* 11 */   private static GDeliveryManager instance = null;
/* 12 */   private Xio gdelivery = null;
/* 13 */   private final Object mutex = new Object();
/*    */   
/*    */   public GDeliveryManager() {
/* 16 */     instance = this;
/*    */   }
/*    */   
/*    */   public static GDeliveryManager getInstance() {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void loadConf(String conf)
/*    */     throws Exception
/*    */   {
/* 28 */     Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(conf);
/* 29 */     Engine.getInstance().register(new xio.XioConf(doc.getDocumentElement()));
/*    */   }
/*    */   
/*    */   protected void addXio(Xio xio)
/*    */   {
/* 34 */     synchronized (this.mutex) {
/* 35 */       this.gdelivery = xio;
/* 36 */       xdb.Trace.warn("Gdelivery Manager AddXio " + xio);
/*    */       
/*    */ 
/* 39 */       GdeliveryHelper.regisGameServer();
/*    */     }
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public Xio get()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 5	gnet/GDeliveryManager:mutex	Ljava/lang/Object;
/*    */     //   4: dup
/*    */     //   5: astore_1
/*    */     //   6: monitorenter
/*    */     //   7: aload_0
/*    */     //   8: getfield 2	gnet/GDeliveryManager:gdelivery	Lxio/Xio;
/*    */     //   11: aload_1
/*    */     //   12: monitorexit
/*    */     //   13: areturn
/*    */     //   14: astore_2
/*    */     //   15: aload_1
/*    */     //   16: monitorexit
/*    */     //   17: aload_2
/*    */     //   18: athrow
/*    */     // Line number table:
/*    */     //   Java source line #45	-> byte code offset #0
/*    */     //   Java source line #46	-> byte code offset #7
/*    */     //   Java source line #47	-> byte code offset #14
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	19	0	this	GDeliveryManager
/*    */     //   5	11	1	Ljava/lang/Object;	Object
/*    */     //   14	4	2	localObject1	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   7	13	14	finally
/*    */     //   14	17	14	finally
/*    */   }
/*    */   
/*    */   protected void removeXio(Xio xio, Throwable e)
/*    */   {
/* 52 */     synchronized (this.mutex) {
/* 53 */       this.gdelivery = null;
/* 54 */       xdb.Trace.warn("Gdelivery Manager removeXio " + xio, e);
/*    */     }
/*    */   }
/*    */   
/*    */   public int size()
/*    */   {
/* 60 */     synchronized (this.mutex) {
/* 61 */       if (this.gdelivery != null)
/* 62 */         return 1;
/* 63 */       return 0;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean send(Protocol p) {
/* 68 */     synchronized (this.mutex) {
/* 69 */       if (this.gdelivery != null)
/* 70 */         return p.send(this.gdelivery);
/* 71 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GDeliveryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */