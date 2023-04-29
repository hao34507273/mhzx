/*     */ package mzm.gsp.market.confbean;
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
/*     */ public class SMarketItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMarketItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMarketItemCfg> all = null;
/*     */   
/*     */   public int itemid;
/*     */   public int id;
/*     */   public int minprice;
/*     */   public int maxprice;
/*     */   public int forzentime;
/*     */   public int subid;
/*     */   public int priceForBulletin;
/*     */   public double priceRateToRecycle;
/*     */   public int recycleRate;
/*     */   public int minRecycletime;
/*     */   public int maxRecycletime;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.itemid = Integer.valueOf(rootElement.attributeValue("itemid")).intValue();
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.minprice = Integer.valueOf(rootElement.attributeValue("minprice")).intValue();
/*  35 */     this.maxprice = Integer.valueOf(rootElement.attributeValue("maxprice")).intValue();
/*  36 */     this.forzentime = Integer.valueOf(rootElement.attributeValue("forzentime")).intValue();
/*  37 */     this.subid = Integer.valueOf(rootElement.attributeValue("subid")).intValue();
/*  38 */     this.priceForBulletin = Integer.valueOf(rootElement.attributeValue("priceForBulletin")).intValue();
/*  39 */     this.priceRateToRecycle = Double.valueOf(rootElement.attributeValue("priceRateToRecycle")).doubleValue();
/*  40 */     this.recycleRate = Integer.valueOf(rootElement.attributeValue("recycleRate")).intValue();
/*  41 */     this.minRecycletime = Integer.valueOf(rootElement.attributeValue("minRecycletime")).intValue();
/*  42 */     this.maxRecycletime = Integer.valueOf(rootElement.attributeValue("maxRecycletime")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.itemid);
/*  48 */     _os_.marshal(this.id);
/*  49 */     _os_.marshal(this.minprice);
/*  50 */     _os_.marshal(this.maxprice);
/*  51 */     _os_.marshal(this.forzentime);
/*  52 */     _os_.marshal(this.subid);
/*  53 */     _os_.marshal(this.priceForBulletin);
/*  54 */     _os_.marshal(this.priceRateToRecycle);
/*  55 */     _os_.marshal(this.recycleRate);
/*  56 */     _os_.marshal(this.minRecycletime);
/*  57 */     _os_.marshal(this.maxRecycletime);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.itemid = _os_.unmarshal_int();
/*  64 */     this.id = _os_.unmarshal_int();
/*  65 */     this.minprice = _os_.unmarshal_int();
/*  66 */     this.maxprice = _os_.unmarshal_int();
/*  67 */     this.forzentime = _os_.unmarshal_int();
/*  68 */     this.subid = _os_.unmarshal_int();
/*  69 */     this.priceForBulletin = _os_.unmarshal_int();
/*  70 */     this.priceRateToRecycle = _os_.unmarshal_float();
/*  71 */     this.recycleRate = _os_.unmarshal_int();
/*  72 */     this.minRecycletime = _os_.unmarshal_int();
/*  73 */     this.maxRecycletime = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.market.confbean.SMarketItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMarketItemCfg"))
/*     */         {
/*     */ 
/*  95 */           SMarketItemCfg obj = new SMarketItemCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.itemid), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.itemid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMarketItemCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.market.confbean.SMarketItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMarketItemCfg"))
/*     */         {
/*     */ 
/* 124 */           SMarketItemCfg obj = new SMarketItemCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.itemid), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.itemid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.market.confbean.SMarketItemCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SMarketItemCfg _v_ = new SMarketItemCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMarketItemCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.market.confbean.SMarketItemCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SMarketItemCfg _v_ = new SMarketItemCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMarketItemCfg getOld(int key)
/*     */   {
/* 235 */     return (SMarketItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMarketItemCfg get(int key)
/*     */   {
/* 240 */     return (SMarketItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarketItemCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarketItemCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMarketItemCfg> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\confbean\SMarketItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */