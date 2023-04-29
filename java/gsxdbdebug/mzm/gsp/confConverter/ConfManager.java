/*    */ package mzm.gsp.confConverter;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.crypto.CipherFactory;
/*    */ 
/*    */ public class ConfManager
/*    */ {
/*  8 */   private static String dirName = "gamedata/xml";
/*  9 */   public static String testkey = "AD67EA2F3BE6E5AD";
/*    */   
/*    */   public static javax.crypto.Cipher cip;
/* 12 */   private HashMap<String, Object> confs = new HashMap();
/*    */   
/* 14 */   private static ConfManager instance = null;
/*    */   
/*    */   public static ConfManager getInstance(String dirName) throws Exception {
/* 17 */     if (instance == null)
/* 18 */       instance = new ConfManager(dirName);
/* 19 */     return instance;
/*    */   }
/*    */   
/*    */   public static ConfManager getInstance() {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */   public ConfManager(String dirName) throws Exception {
/* 27 */     init(dirName);
/*    */   }
/*    */   
/*    */   private void init(String dirName) throws Exception {
/* 31 */     dirName = dirName;
/* 32 */     cip = CipherFactory.getCipher("null", 2, testkey);
/* 33 */     ConfHelper.detectObjectForDirectory(new java.io.File(dirName), new XMLFileFilter(".xml"), new XStreamObjectProcessor()
/*    */     {
/*    */ 
/*    */       public boolean onObjectDetected(Object obj)
/*    */       {
/* 38 */         ConfManager.this.confs.put(obj.getClass().getName(), obj);
/* 39 */         return true; } }, cip);
/*    */   }
/*    */   
/*    */   public synchronized void refresh()
/*    */     throws Exception
/*    */   {
/* 45 */     synchronized (this) {
/* 46 */       getInstance().confs.clear();
/* 47 */       getInstance().init(dirName);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws Exception
/*    */   {
/* 53 */     if (args.length != 2)
/*    */     {
/* 55 */       System.out.println("args error");
/* 56 */       return;
/*    */     }
/* 58 */     cip = CipherFactory.getCipher("null", 2, testkey);
/* 59 */     getInstance(args[0]);
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public Object getconf(String fullname)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: dup
/*    */     //   2: astore_2
/*    */     //   3: monitorenter
/*    */     //   4: aload_0
/*    */     //   5: getfield 1	mzm/gsp/confConverter/ConfManager:confs	Ljava/util/HashMap;
/*    */     //   8: aload_1
/*    */     //   9: invokevirtual 28	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   12: aload_2
/*    */     //   13: monitorexit
/*    */     //   14: areturn
/*    */     //   15: astore_3
/*    */     //   16: aload_2
/*    */     //   17: monitorexit
/*    */     //   18: aload_3
/*    */     //   19: athrow
/*    */     // Line number table:
/*    */     //   Java source line #63	-> byte code offset #0
/*    */     //   Java source line #64	-> byte code offset #4
/*    */     //   Java source line #65	-> byte code offset #15
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	20	0	this	ConfManager
/*    */     //   0	20	1	fullname	String
/*    */     //   2	15	2	Ljava/lang/Object;	Object
/*    */     //   15	4	3	localObject1	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   4	14	15	finally
/*    */     //   15	18	15	finally
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confConverter\ConfManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */