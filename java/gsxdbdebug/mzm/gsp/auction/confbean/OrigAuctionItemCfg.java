/*     */ package mzm.gsp.auction.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class OrigAuctionItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, OrigAuctionItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, OrigAuctionItemCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int itemSumTypeId;
/*     */   public int itemTypeId;
/*     */   public int itemCfgId;
/*     */   public int itemWeight;
/*     */   public int itemBindType;
/*     */   public int minServerLevel;
/*     */   public int moneyType;
/*     */   public int yuanBaoType;
/*     */   public int basePrice;
/*     */   public int premiumRate;
/*     */   public int bidBaseTime;
/*     */   public int bidOverTimeUnit;
/*     */   public int bidOverTimeMaxCount;
/*     */   public int bidEndCountDownTime;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.itemSumTypeId = Integer.valueOf(rootElement.attributeValue("itemSumTypeId")).intValue();
/*  38 */     this.itemTypeId = Integer.valueOf(rootElement.attributeValue("itemTypeId")).intValue();
/*  39 */     this.itemCfgId = Integer.valueOf(rootElement.attributeValue("itemCfgId")).intValue();
/*  40 */     this.itemWeight = Integer.valueOf(rootElement.attributeValue("itemWeight")).intValue();
/*  41 */     this.itemBindType = Integer.valueOf(rootElement.attributeValue("itemBindType")).intValue();
/*  42 */     this.minServerLevel = Integer.valueOf(rootElement.attributeValue("minServerLevel")).intValue();
/*  43 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/*  44 */     this.yuanBaoType = Integer.valueOf(rootElement.attributeValue("yuanBaoType")).intValue();
/*  45 */     this.basePrice = Integer.valueOf(rootElement.attributeValue("basePrice")).intValue();
/*  46 */     this.premiumRate = Integer.valueOf(rootElement.attributeValue("premiumRate")).intValue();
/*  47 */     this.bidBaseTime = Integer.valueOf(rootElement.attributeValue("bidBaseTime")).intValue();
/*  48 */     this.bidOverTimeUnit = Integer.valueOf(rootElement.attributeValue("bidOverTimeUnit")).intValue();
/*  49 */     this.bidOverTimeMaxCount = Integer.valueOf(rootElement.attributeValue("bidOverTimeMaxCount")).intValue();
/*  50 */     this.bidEndCountDownTime = Integer.valueOf(rootElement.attributeValue("bidEndCountDownTime")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.itemSumTypeId);
/*  57 */     _os_.marshal(this.itemTypeId);
/*  58 */     _os_.marshal(this.itemCfgId);
/*  59 */     _os_.marshal(this.itemWeight);
/*  60 */     _os_.marshal(this.itemBindType);
/*  61 */     _os_.marshal(this.minServerLevel);
/*  62 */     _os_.marshal(this.moneyType);
/*  63 */     _os_.marshal(this.yuanBaoType);
/*  64 */     _os_.marshal(this.basePrice);
/*  65 */     _os_.marshal(this.premiumRate);
/*  66 */     _os_.marshal(this.bidBaseTime);
/*  67 */     _os_.marshal(this.bidOverTimeUnit);
/*  68 */     _os_.marshal(this.bidOverTimeMaxCount);
/*  69 */     _os_.marshal(this.bidEndCountDownTime);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.itemSumTypeId = _os_.unmarshal_int();
/*  77 */     this.itemTypeId = _os_.unmarshal_int();
/*  78 */     this.itemCfgId = _os_.unmarshal_int();
/*  79 */     this.itemWeight = _os_.unmarshal_int();
/*  80 */     this.itemBindType = _os_.unmarshal_int();
/*  81 */     this.minServerLevel = _os_.unmarshal_int();
/*  82 */     this.moneyType = _os_.unmarshal_int();
/*  83 */     this.yuanBaoType = _os_.unmarshal_int();
/*  84 */     this.basePrice = _os_.unmarshal_int();
/*  85 */     this.premiumRate = _os_.unmarshal_int();
/*  86 */     this.bidBaseTime = _os_.unmarshal_int();
/*  87 */     this.bidOverTimeUnit = _os_.unmarshal_int();
/*  88 */     this.bidOverTimeMaxCount = _os_.unmarshal_int();
/*  89 */     this.bidEndCountDownTime = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.auction.confbean.OrigAuctionItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.auction.confbean.OrigAuctionItemCfg"))
/*     */         {
/*     */ 
/* 111 */           OrigAuctionItemCfg obj = new OrigAuctionItemCfg();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, OrigAuctionItemCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.auction.confbean.OrigAuctionItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.auction.confbean.OrigAuctionItemCfg"))
/*     */         {
/*     */ 
/* 140 */           OrigAuctionItemCfg obj = new OrigAuctionItemCfg();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.auction.confbean.OrigAuctionItemCfg.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           OrigAuctionItemCfg _v_ = new OrigAuctionItemCfg();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, OrigAuctionItemCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.auction.confbean.OrigAuctionItemCfg.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           OrigAuctionItemCfg _v_ = new OrigAuctionItemCfg();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static OrigAuctionItemCfg getOld(int key)
/*     */   {
/* 251 */     return (OrigAuctionItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static OrigAuctionItemCfg get(int key)
/*     */   {
/* 256 */     return (OrigAuctionItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, OrigAuctionItemCfg> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, OrigAuctionItemCfg> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, OrigAuctionItemCfg> newAll)
/*     */   {
/* 271 */     oldAll = all;
/* 272 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 277 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\confbean\OrigAuctionItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */