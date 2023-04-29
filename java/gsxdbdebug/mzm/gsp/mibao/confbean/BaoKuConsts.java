/*     */ package mzm.gsp.mibao.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class BaoKuConsts
/*     */ {
/*  13 */   private static volatile BaoKuConsts oldInstance = null;
/*     */   
/*  15 */   private static BaoKuConsts instance = new BaoKuConsts();
/*     */   
/*     */   public int maxBuyTimesEveryDay;
/*     */   public int banBuyDays;
/*     */   public int describeTipsId1;
/*     */   
/*     */   public static BaoKuConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static BaoKuConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int describeTipsId2;
/*     */   
/*     */   public int miBaoActivityId;
/*     */   
/*     */   public int onSaleValue;
/*     */   
/*     */   public int onSaleBase;
/*     */   public int yuanBaoIndex;
/*     */   public int exchangeMailId;
/*     */   public int scoreExchangeRate;
/*     */   public int awardedDelayTime;
/*     */   public int itemAwardId;
/*     */   public int exchangeCostItemId;
/*     */   public int exchangeIndex;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.mibao.confbean.BaoKuConsts.xml";
/*     */     try
/*     */     {
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       java.util.List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.maxBuyTimesEveryDay = Integer.valueOf(((Element)data.get("maxBuyTimesEveryDay")).attributeValue("value")).intValue();
/*  74 */       this.banBuyDays = Integer.valueOf(((Element)data.get("banBuyDays")).attributeValue("value")).intValue();
/*  75 */       this.describeTipsId1 = Integer.valueOf(((Element)data.get("describeTipsId1")).attributeValue("value")).intValue();
/*  76 */       this.describeTipsId2 = Integer.valueOf(((Element)data.get("describeTipsId2")).attributeValue("value")).intValue();
/*  77 */       this.miBaoActivityId = Integer.valueOf(((Element)data.get("miBaoActivityId")).attributeValue("value")).intValue();
/*  78 */       this.onSaleValue = Integer.valueOf(((Element)data.get("onSaleValue")).attributeValue("value")).intValue();
/*  79 */       this.onSaleBase = Integer.valueOf(((Element)data.get("onSaleBase")).attributeValue("value")).intValue();
/*  80 */       this.yuanBaoIndex = Integer.valueOf(((Element)data.get("yuanBaoIndex")).attributeValue("value")).intValue();
/*  81 */       this.exchangeMailId = Integer.valueOf(((Element)data.get("exchangeMailId")).attributeValue("value")).intValue();
/*  82 */       this.scoreExchangeRate = Integer.valueOf(((Element)data.get("scoreExchangeRate")).attributeValue("value")).intValue();
/*  83 */       this.awardedDelayTime = Integer.valueOf(((Element)data.get("awardedDelayTime")).attributeValue("value")).intValue();
/*  84 */       this.itemAwardId = Integer.valueOf(((Element)data.get("itemAwardId")).attributeValue("value")).intValue();
/*  85 */       this.exchangeCostItemId = Integer.valueOf(((Element)data.get("exchangeCostItemId")).attributeValue("value")).intValue();
/*  86 */       this.exchangeIndex = Integer.valueOf(((Element)data.get("exchangeIndex")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.mibao.confbean.BaoKuConsts.xml";
/*     */     try
/*     */     {
/*  98 */       SAXReader reader = new SAXReader();
/*  99 */       org.dom4j.Document doc = reader.read(new File(path));
/* 100 */       Element root = doc.getRootElement();
/* 101 */       Map<String, Element> data = new java.util.HashMap();
/* 102 */       java.util.List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element element = (Element)nodeList.get(i);
/* 107 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 110 */           String name = element.attributeValue("name");
/* 111 */           if (data.put(name, element) != null)
/* 112 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 115 */       this.maxBuyTimesEveryDay = Integer.valueOf(((Element)data.get("maxBuyTimesEveryDay")).attributeValue("value")).intValue();
/* 116 */       this.banBuyDays = Integer.valueOf(((Element)data.get("banBuyDays")).attributeValue("value")).intValue();
/* 117 */       this.describeTipsId1 = Integer.valueOf(((Element)data.get("describeTipsId1")).attributeValue("value")).intValue();
/* 118 */       this.describeTipsId2 = Integer.valueOf(((Element)data.get("describeTipsId2")).attributeValue("value")).intValue();
/* 119 */       this.miBaoActivityId = Integer.valueOf(((Element)data.get("miBaoActivityId")).attributeValue("value")).intValue();
/* 120 */       this.onSaleValue = Integer.valueOf(((Element)data.get("onSaleValue")).attributeValue("value")).intValue();
/* 121 */       this.onSaleBase = Integer.valueOf(((Element)data.get("onSaleBase")).attributeValue("value")).intValue();
/* 122 */       this.yuanBaoIndex = Integer.valueOf(((Element)data.get("yuanBaoIndex")).attributeValue("value")).intValue();
/* 123 */       this.exchangeMailId = Integer.valueOf(((Element)data.get("exchangeMailId")).attributeValue("value")).intValue();
/* 124 */       this.scoreExchangeRate = Integer.valueOf(((Element)data.get("scoreExchangeRate")).attributeValue("value")).intValue();
/* 125 */       this.awardedDelayTime = Integer.valueOf(((Element)data.get("awardedDelayTime")).attributeValue("value")).intValue();
/* 126 */       this.itemAwardId = Integer.valueOf(((Element)data.get("itemAwardId")).attributeValue("value")).intValue();
/* 127 */       this.exchangeCostItemId = Integer.valueOf(((Element)data.get("exchangeCostItemId")).attributeValue("value")).intValue();
/* 128 */       this.exchangeIndex = Integer.valueOf(((Element)data.get("exchangeIndex")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 136 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 139 */     String path = dir + "mzm.gsp.mibao.confbean.BaoKuConsts.bny";
/*     */     try
/*     */     {
/* 142 */       File file = new File(path);
/* 143 */       if (file.exists())
/*     */       {
/* 145 */         byte[] bytes = new byte['Ѐ'];
/* 146 */         FileInputStream fis = new FileInputStream(file);
/* 147 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 148 */         int len = 0;
/* 149 */         while ((len = fis.read(bytes)) > 0)
/* 150 */           baos.write(bytes, 0, len);
/* 151 */         fis.close();
/* 152 */         bytes = baos.toByteArray();
/* 153 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 154 */         this.maxBuyTimesEveryDay = _os_.unmarshal_int();
/* 155 */         this.banBuyDays = _os_.unmarshal_int();
/* 156 */         this.describeTipsId1 = _os_.unmarshal_int();
/* 157 */         this.describeTipsId2 = _os_.unmarshal_int();
/* 158 */         this.miBaoActivityId = _os_.unmarshal_int();
/* 159 */         this.onSaleValue = _os_.unmarshal_int();
/* 160 */         this.onSaleBase = _os_.unmarshal_int();
/* 161 */         this.yuanBaoIndex = _os_.unmarshal_int();
/* 162 */         this.exchangeMailId = _os_.unmarshal_int();
/* 163 */         this.scoreExchangeRate = _os_.unmarshal_int();
/* 164 */         this.awardedDelayTime = _os_.unmarshal_int();
/* 165 */         this.itemAwardId = _os_.unmarshal_int();
/* 166 */         this.exchangeCostItemId = _os_.unmarshal_int();
/* 167 */         this.exchangeIndex = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.mibao.confbean.BaoKuConsts.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         this.maxBuyTimesEveryDay = _os_.unmarshal_int();
/* 194 */         this.banBuyDays = _os_.unmarshal_int();
/* 195 */         this.describeTipsId1 = _os_.unmarshal_int();
/* 196 */         this.describeTipsId2 = _os_.unmarshal_int();
/* 197 */         this.miBaoActivityId = _os_.unmarshal_int();
/* 198 */         this.onSaleValue = _os_.unmarshal_int();
/* 199 */         this.onSaleBase = _os_.unmarshal_int();
/* 200 */         this.yuanBaoIndex = _os_.unmarshal_int();
/* 201 */         this.exchangeMailId = _os_.unmarshal_int();
/* 202 */         this.scoreExchangeRate = _os_.unmarshal_int();
/* 203 */         this.awardedDelayTime = _os_.unmarshal_int();
/* 204 */         this.itemAwardId = _os_.unmarshal_int();
/* 205 */         this.exchangeCostItemId = _os_.unmarshal_int();
/* 206 */         this.exchangeIndex = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(BaoKuConsts newInstance)
/*     */   {
/* 217 */     oldInstance = instance;
/* 218 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 223 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\confbean\BaoKuConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */