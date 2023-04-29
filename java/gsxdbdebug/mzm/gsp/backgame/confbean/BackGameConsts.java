/*     */ package mzm.gsp.backgame.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class BackGameConsts
/*     */ {
/*  13 */   private static volatile BackGameConsts oldInstance = null;
/*     */   
/*  15 */   private static BackGameConsts instance = new BackGameConsts();
/*     */   
/*     */   public int scoreResetTime;
/*     */   public int awardReserveExpMaxDay;
/*     */   public int awardReserveExpMinDay;
/*     */   
/*     */   public static BackGameConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static BackGameConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getReserverExpRate;
/*     */   
/*     */   public int getReserverExpRateBase;
/*     */   
/*     */   public int lastTime;
/*     */   
/*     */   public int needOffLineTime;
/*     */   public int scoreGetMeansTipsId;
/*     */   public int tipsId1;
/*     */   public int tipsId2;
/*     */   public int tipsId3;
/*     */   public int limitDeltaDay;
/*     */   public int yuanBaoExchangeRate;
/*     */   public int activeExchangeRate;
/*     */   public int minRoleLevel;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.backgame.confbean.BackGameConsts.xml";
/*     */     try
/*     */     {
/*  57 */       SAXReader reader = new SAXReader();
/*  58 */       org.dom4j.Document doc = reader.read(new File(path));
/*  59 */       Element root = doc.getRootElement();
/*  60 */       Map<String, Element> data = new java.util.HashMap();
/*  61 */       java.util.List<?> nodeList = root.elements();
/*  62 */       int len = nodeList.size();
/*  63 */       for (int i = 0; i < len; i++)
/*     */       {
/*  65 */         Element element = (Element)nodeList.get(i);
/*  66 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  69 */           String name = element.attributeValue("name");
/*  70 */           if (data.put(name, element) != null)
/*  71 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  74 */       this.scoreResetTime = Integer.valueOf(((Element)data.get("scoreResetTime")).attributeValue("value")).intValue();
/*  75 */       this.awardReserveExpMaxDay = Integer.valueOf(((Element)data.get("awardReserveExpMaxDay")).attributeValue("value")).intValue();
/*  76 */       this.awardReserveExpMinDay = Integer.valueOf(((Element)data.get("awardReserveExpMinDay")).attributeValue("value")).intValue();
/*  77 */       this.getReserverExpRate = Integer.valueOf(((Element)data.get("getReserverExpRate")).attributeValue("value")).intValue();
/*  78 */       this.getReserverExpRateBase = Integer.valueOf(((Element)data.get("getReserverExpRateBase")).attributeValue("value")).intValue();
/*  79 */       this.lastTime = Integer.valueOf(((Element)data.get("lastTime")).attributeValue("value")).intValue();
/*  80 */       this.needOffLineTime = Integer.valueOf(((Element)data.get("needOffLineTime")).attributeValue("value")).intValue();
/*  81 */       this.scoreGetMeansTipsId = Integer.valueOf(((Element)data.get("scoreGetMeansTipsId")).attributeValue("value")).intValue();
/*  82 */       this.tipsId1 = Integer.valueOf(((Element)data.get("tipsId1")).attributeValue("value")).intValue();
/*  83 */       this.tipsId2 = Integer.valueOf(((Element)data.get("tipsId2")).attributeValue("value")).intValue();
/*  84 */       this.tipsId3 = Integer.valueOf(((Element)data.get("tipsId3")).attributeValue("value")).intValue();
/*  85 */       this.limitDeltaDay = Integer.valueOf(((Element)data.get("limitDeltaDay")).attributeValue("value")).intValue();
/*  86 */       this.yuanBaoExchangeRate = Integer.valueOf(((Element)data.get("yuanBaoExchangeRate")).attributeValue("value")).intValue();
/*  87 */       this.activeExchangeRate = Integer.valueOf(((Element)data.get("activeExchangeRate")).attributeValue("value")).intValue();
/*  88 */       this.minRoleLevel = Integer.valueOf(((Element)data.get("minRoleLevel")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  97 */     String path = dir + "mzm.gsp.backgame.confbean.BackGameConsts.xml";
/*     */     try
/*     */     {
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       Map<String, Element> data = new java.util.HashMap();
/* 104 */       java.util.List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element element = (Element)nodeList.get(i);
/* 109 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 112 */           String name = element.attributeValue("name");
/* 113 */           if (data.put(name, element) != null)
/* 114 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 117 */       this.scoreResetTime = Integer.valueOf(((Element)data.get("scoreResetTime")).attributeValue("value")).intValue();
/* 118 */       this.awardReserveExpMaxDay = Integer.valueOf(((Element)data.get("awardReserveExpMaxDay")).attributeValue("value")).intValue();
/* 119 */       this.awardReserveExpMinDay = Integer.valueOf(((Element)data.get("awardReserveExpMinDay")).attributeValue("value")).intValue();
/* 120 */       this.getReserverExpRate = Integer.valueOf(((Element)data.get("getReserverExpRate")).attributeValue("value")).intValue();
/* 121 */       this.getReserverExpRateBase = Integer.valueOf(((Element)data.get("getReserverExpRateBase")).attributeValue("value")).intValue();
/* 122 */       this.lastTime = Integer.valueOf(((Element)data.get("lastTime")).attributeValue("value")).intValue();
/* 123 */       this.needOffLineTime = Integer.valueOf(((Element)data.get("needOffLineTime")).attributeValue("value")).intValue();
/* 124 */       this.scoreGetMeansTipsId = Integer.valueOf(((Element)data.get("scoreGetMeansTipsId")).attributeValue("value")).intValue();
/* 125 */       this.tipsId1 = Integer.valueOf(((Element)data.get("tipsId1")).attributeValue("value")).intValue();
/* 126 */       this.tipsId2 = Integer.valueOf(((Element)data.get("tipsId2")).attributeValue("value")).intValue();
/* 127 */       this.tipsId3 = Integer.valueOf(((Element)data.get("tipsId3")).attributeValue("value")).intValue();
/* 128 */       this.limitDeltaDay = Integer.valueOf(((Element)data.get("limitDeltaDay")).attributeValue("value")).intValue();
/* 129 */       this.yuanBaoExchangeRate = Integer.valueOf(((Element)data.get("yuanBaoExchangeRate")).attributeValue("value")).intValue();
/* 130 */       this.activeExchangeRate = Integer.valueOf(((Element)data.get("activeExchangeRate")).attributeValue("value")).intValue();
/* 131 */       this.minRoleLevel = Integer.valueOf(((Element)data.get("minRoleLevel")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 139 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 142 */     String path = dir + "mzm.gsp.backgame.confbean.BackGameConsts.bny";
/*     */     try
/*     */     {
/* 145 */       File file = new File(path);
/* 146 */       if (file.exists())
/*     */       {
/* 148 */         byte[] bytes = new byte['Ѐ'];
/* 149 */         FileInputStream fis = new FileInputStream(file);
/* 150 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 151 */         int len = 0;
/* 152 */         while ((len = fis.read(bytes)) > 0)
/* 153 */           baos.write(bytes, 0, len);
/* 154 */         fis.close();
/* 155 */         bytes = baos.toByteArray();
/* 156 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 157 */         this.scoreResetTime = _os_.unmarshal_int();
/* 158 */         this.awardReserveExpMaxDay = _os_.unmarshal_int();
/* 159 */         this.awardReserveExpMinDay = _os_.unmarshal_int();
/* 160 */         this.getReserverExpRate = _os_.unmarshal_int();
/* 161 */         this.getReserverExpRateBase = _os_.unmarshal_int();
/* 162 */         this.lastTime = _os_.unmarshal_int();
/* 163 */         this.needOffLineTime = _os_.unmarshal_int();
/* 164 */         this.scoreGetMeansTipsId = _os_.unmarshal_int();
/* 165 */         this.tipsId1 = _os_.unmarshal_int();
/* 166 */         this.tipsId2 = _os_.unmarshal_int();
/* 167 */         this.tipsId3 = _os_.unmarshal_int();
/* 168 */         this.limitDeltaDay = _os_.unmarshal_int();
/* 169 */         this.yuanBaoExchangeRate = _os_.unmarshal_int();
/* 170 */         this.activeExchangeRate = _os_.unmarshal_int();
/* 171 */         this.minRoleLevel = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.backgame.confbean.BackGameConsts.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         this.scoreResetTime = _os_.unmarshal_int();
/* 198 */         this.awardReserveExpMaxDay = _os_.unmarshal_int();
/* 199 */         this.awardReserveExpMinDay = _os_.unmarshal_int();
/* 200 */         this.getReserverExpRate = _os_.unmarshal_int();
/* 201 */         this.getReserverExpRateBase = _os_.unmarshal_int();
/* 202 */         this.lastTime = _os_.unmarshal_int();
/* 203 */         this.needOffLineTime = _os_.unmarshal_int();
/* 204 */         this.scoreGetMeansTipsId = _os_.unmarshal_int();
/* 205 */         this.tipsId1 = _os_.unmarshal_int();
/* 206 */         this.tipsId2 = _os_.unmarshal_int();
/* 207 */         this.tipsId3 = _os_.unmarshal_int();
/* 208 */         this.limitDeltaDay = _os_.unmarshal_int();
/* 209 */         this.yuanBaoExchangeRate = _os_.unmarshal_int();
/* 210 */         this.activeExchangeRate = _os_.unmarshal_int();
/* 211 */         this.minRoleLevel = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(BackGameConsts newInstance)
/*     */   {
/* 222 */     oldInstance = instance;
/* 223 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 228 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\confbean\BackGameConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */