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
/*     */ public class SMarketPetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMarketPetCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMarketPetCfg> all = null;
/*     */   
/*     */   public int petid;
/*     */   public int id;
/*     */   public int minprice;
/*     */   public int maxprice;
/*     */   public int forzentime;
/*     */   public int subid;
/*     */   public int minPoint;
/*     */   public int priceForBulletin;
/*     */   public double priceRateToRecycle;
/*     */   public int recycleRate;
/*     */   public int minRecycletime;
/*     */   public int maxRecycletime;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.petid = Integer.valueOf(rootElement.attributeValue("petid")).intValue();
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.minprice = Integer.valueOf(rootElement.attributeValue("minprice")).intValue();
/*  36 */     this.maxprice = Integer.valueOf(rootElement.attributeValue("maxprice")).intValue();
/*  37 */     this.forzentime = Integer.valueOf(rootElement.attributeValue("forzentime")).intValue();
/*  38 */     this.subid = Integer.valueOf(rootElement.attributeValue("subid")).intValue();
/*  39 */     this.minPoint = Integer.valueOf(rootElement.attributeValue("minPoint")).intValue();
/*  40 */     this.priceForBulletin = Integer.valueOf(rootElement.attributeValue("priceForBulletin")).intValue();
/*  41 */     this.priceRateToRecycle = Double.valueOf(rootElement.attributeValue("priceRateToRecycle")).doubleValue();
/*  42 */     this.recycleRate = Integer.valueOf(rootElement.attributeValue("recycleRate")).intValue();
/*  43 */     this.minRecycletime = Integer.valueOf(rootElement.attributeValue("minRecycletime")).intValue();
/*  44 */     this.maxRecycletime = Integer.valueOf(rootElement.attributeValue("maxRecycletime")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     _os_.marshal(this.petid);
/*  50 */     _os_.marshal(this.id);
/*  51 */     _os_.marshal(this.minprice);
/*  52 */     _os_.marshal(this.maxprice);
/*  53 */     _os_.marshal(this.forzentime);
/*  54 */     _os_.marshal(this.subid);
/*  55 */     _os_.marshal(this.minPoint);
/*  56 */     _os_.marshal(this.priceForBulletin);
/*  57 */     _os_.marshal(this.priceRateToRecycle);
/*  58 */     _os_.marshal(this.recycleRate);
/*  59 */     _os_.marshal(this.minRecycletime);
/*  60 */     _os_.marshal(this.maxRecycletime);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     this.petid = _os_.unmarshal_int();
/*  67 */     this.id = _os_.unmarshal_int();
/*  68 */     this.minprice = _os_.unmarshal_int();
/*  69 */     this.maxprice = _os_.unmarshal_int();
/*  70 */     this.forzentime = _os_.unmarshal_int();
/*  71 */     this.subid = _os_.unmarshal_int();
/*  72 */     this.minPoint = _os_.unmarshal_int();
/*  73 */     this.priceForBulletin = _os_.unmarshal_int();
/*  74 */     this.priceRateToRecycle = _os_.unmarshal_float();
/*  75 */     this.recycleRate = _os_.unmarshal_int();
/*  76 */     this.minRecycletime = _os_.unmarshal_int();
/*  77 */     this.maxRecycletime = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.market.confbean.SMarketPetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       all = new java.util.HashMap();
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMarketPetCfg"))
/*     */         {
/*     */ 
/*  99 */           SMarketPetCfg obj = new SMarketPetCfg();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.petid), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.petid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 107 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMarketPetCfg> all)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.market.confbean.SMarketPetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMarketPetCfg"))
/*     */         {
/*     */ 
/* 128 */           SMarketPetCfg obj = new SMarketPetCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.petid), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.petid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 142 */     all = new java.util.HashMap();
/*     */     
/* 144 */     String path = dir + "mzm.gsp.market.confbean.SMarketPetCfg.bny";
/*     */     try
/*     */     {
/* 147 */       File file = new File(path);
/* 148 */       if (file.exists())
/*     */       {
/* 150 */         byte[] bytes = new byte['Ѐ'];
/* 151 */         FileInputStream fis = new FileInputStream(file);
/* 152 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 153 */         int len = 0;
/* 154 */         while ((len = fis.read(bytes)) > 0)
/* 155 */           baos.write(bytes, 0, len);
/* 156 */         fis.close();
/* 157 */         bytes = baos.toByteArray();
/* 158 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 159 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 169 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 171 */           SMarketPetCfg _v_ = new SMarketPetCfg();
/* 172 */           _v_.unmarshal(_os_);
/* 173 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 179 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMarketPetCfg> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.market.confbean.SMarketPetCfg.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           SMarketPetCfg _v_ = new SMarketPetCfg();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMarketPetCfg getOld(int key)
/*     */   {
/* 239 */     return (SMarketPetCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMarketPetCfg get(int key)
/*     */   {
/* 244 */     return (SMarketPetCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarketPetCfg> getOldAll()
/*     */   {
/* 249 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarketPetCfg> getAll()
/*     */   {
/* 254 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMarketPetCfg> newAll)
/*     */   {
/* 259 */     oldAll = all;
/* 260 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 265 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\confbean\SMarketPetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */