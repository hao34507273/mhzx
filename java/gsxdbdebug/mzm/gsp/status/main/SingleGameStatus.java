/*     */ package mzm.gsp.status.main;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Map;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ class SingleGameStatus
/*     */ {
/*     */   private int status;
/*     */   private final Map<Integer, Integer> disallowSatus;
/*     */   private boolean toClient;
/*     */   private String statusName;
/*     */   
/*     */   SingleGameStatus()
/*     */   {
/*  17 */     this.disallowSatus = new java.util.HashMap();
/*  18 */     this.toClient = true;
/*     */   }
/*     */   
/*     */   SingleGameStatus(Node node) {
/*  22 */     this();
/*     */     
/*  24 */     Element element = (Element)node;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/*  32 */       this.statusName = element.getAttribute("name");
/*     */       
/*     */ 
/*  35 */       String statusFrom = "mzm.gsp.status.StatusEnum";
/*  36 */       Class<?> clazz = Class.forName(statusFrom);
/*  37 */       Object object = clazz.newInstance();
/*  38 */       this.status = clazz.getDeclaredField(this.statusName).getInt(object);
/*     */       
/*  40 */       this.toClient = Boolean.valueOf(element.getAttribute("toClient").toLowerCase()).booleanValue();
/*     */       
/*  42 */       Node mutex = element.getElementsByTagName("disallow").item(0);
/*  43 */       if (mutex != null) {
/*  44 */         Class<?> clazzTip = Class.forName("mzm.gsp.status.ErrorCode");
/*  45 */         Object objTip = clazzTip.newInstance();
/*  46 */         for (Node attri = mutex.getFirstChild(); attri != null; attri = attri.getNextSibling()) {
/*  47 */           if (attri.getNodeType() == 1)
/*     */           {
/*  49 */             Element elementState = (Element)attri;
/*     */             
/*  51 */             String disAllowName = elementState.getAttribute("name");
/*     */             
/*  53 */             String tip = elementState.getAttribute("tip");
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */             int disAllowStatus = clazz.getDeclaredField(disAllowName).getInt(object);
/*  64 */             int tipValue = clazzTip.getDeclaredField(tip).getInt(objTip);
/*  65 */             if (this.disallowSatus.containsKey(Integer.valueOf(disAllowStatus))) {
/*  66 */               throw new RuntimeException(String.format("%s配置了相同的disAllowStatus,%s", new Object[] { this.statusName, disAllowName }));
/*     */             }
/*  68 */             if (disAllowStatus == this.status) {
/*  69 */               throw new RuntimeException(String.format("状态自身不能够限制状态自身的设置statusName=%s", new Object[] { this.statusName }));
/*     */             }
/*  71 */             this.disallowSatus.put(Integer.valueOf(disAllowStatus), Integer.valueOf(tipValue));
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  76 */       throw new RuntimeException(e);
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
/*     */   int getStatus()
/*     */   {
/* 100 */     return this.status;
/*     */   }
/*     */   
/*     */   void setStatus(int status) {
/* 104 */     this.status = status;
/*     */   }
/*     */   
/*     */   String getName() {
/* 108 */     return this.statusName;
/*     */   }
/*     */   
/*     */   Map<Integer, Integer> getMutexStatus() {
/* 112 */     return this.disallowSatus;
/*     */   }
/*     */   
/*     */   boolean isToClient() {
/* 116 */     return this.toClient;
/*     */   }
/*     */   
/*     */   void setToClient(boolean toClient) {
/* 120 */     this.toClient = toClient;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\SingleGameStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */