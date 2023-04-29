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
/*     */ public class SMarketSupplyItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMarketSupplyItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMarketSupplyItemCfg> all = null;
/*     */   
/*     */   public int itemid;
/*     */   public int id;
/*     */   public int minServerLevel;
/*     */   public int minMarketItemNum;
/*     */   public int persistMinutes;
/*     */   public int minSupplyNum;
/*     */   public int maxSupplyNum;
/*     */   public int daySupplyNum;
/*  26 */   public java.util.ArrayList<PriceRate2Weight> priceRate2Weight = new java.util.ArrayList();
/*     */   public int extraRate;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.itemid = Integer.valueOf(rootElement.attributeValue("itemid")).intValue();
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.minServerLevel = Integer.valueOf(rootElement.attributeValue("minServerLevel")).intValue();
/*  34 */     this.minMarketItemNum = Integer.valueOf(rootElement.attributeValue("minMarketItemNum")).intValue();
/*  35 */     this.persistMinutes = Integer.valueOf(rootElement.attributeValue("persistMinutes")).intValue();
/*  36 */     this.minSupplyNum = Integer.valueOf(rootElement.attributeValue("minSupplyNum")).intValue();
/*  37 */     this.maxSupplyNum = Integer.valueOf(rootElement.attributeValue("maxSupplyNum")).intValue();
/*  38 */     this.daySupplyNum = Integer.valueOf(rootElement.attributeValue("daySupplyNum")).intValue();
/*     */     
/*  40 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "priceRate2Weight");
/*  41 */     if (collectionElement == null)
/*     */     {
/*  43 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  46 */     List<?> _nodeList = collectionElement.elements();
/*  47 */     int _len = _nodeList.size();
/*  48 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  50 */       Element elem = (Element)_nodeList.get(i);
/*  51 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.PriceRate2Weight"))
/*     */       {
/*     */         PriceRate2Weight _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  58 */           _v_ = new PriceRate2Weight();
/*  59 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  66 */         this.priceRate2Weight.add(_v_);
/*     */       }
/*     */     }
/*  69 */     this.extraRate = Integer.valueOf(rootElement.attributeValue("extraRate")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _os_.marshal(this.itemid);
/*  75 */     _os_.marshal(this.id);
/*  76 */     _os_.marshal(this.minServerLevel);
/*  77 */     _os_.marshal(this.minMarketItemNum);
/*  78 */     _os_.marshal(this.persistMinutes);
/*  79 */     _os_.marshal(this.minSupplyNum);
/*  80 */     _os_.marshal(this.maxSupplyNum);
/*  81 */     _os_.marshal(this.daySupplyNum);
/*  82 */     _os_.compact_uint32(this.priceRate2Weight.size());
/*  83 */     for (PriceRate2Weight _v_ : this.priceRate2Weight)
/*     */     {
/*  85 */       _os_.marshal(_v_);
/*     */     }
/*  87 */     _os_.marshal(this.extraRate);
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.itemid = _os_.unmarshal_int();
/*  94 */     this.id = _os_.unmarshal_int();
/*  95 */     this.minServerLevel = _os_.unmarshal_int();
/*  96 */     this.minMarketItemNum = _os_.unmarshal_int();
/*  97 */     this.persistMinutes = _os_.unmarshal_int();
/*  98 */     this.minSupplyNum = _os_.unmarshal_int();
/*  99 */     this.maxSupplyNum = _os_.unmarshal_int();
/* 100 */     this.daySupplyNum = _os_.unmarshal_int();
/* 101 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 104 */       PriceRate2Weight _v_ = new PriceRate2Weight();
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.priceRate2Weight.add(_v_);
/*     */     }
/* 108 */     this.extraRate = _os_.unmarshal_int();
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 114 */     String path = dir + "mzm.gsp.market.confbean.SMarketSupplyItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 118 */       all = new java.util.HashMap();
/* 119 */       SAXReader reader = new SAXReader();
/* 120 */       org.dom4j.Document doc = reader.read(new File(path));
/* 121 */       Element root = doc.getRootElement();
/* 122 */       List<?> nodeList = root.elements();
/* 123 */       int len = nodeList.size();
/* 124 */       for (int i = 0; i < len; i++)
/*     */       {
/* 126 */         Element elem = (Element)nodeList.get(i);
/* 127 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMarketSupplyItemCfg"))
/*     */         {
/*     */ 
/* 130 */           SMarketSupplyItemCfg obj = new SMarketSupplyItemCfg();
/* 131 */           obj.loadFromXml(elem);
/* 132 */           if (all.put(Integer.valueOf(obj.itemid), obj) != null) {
/* 133 */             throw new RuntimeException("duplicate key : " + obj.itemid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 138 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMarketSupplyItemCfg> all)
/*     */   {
/* 144 */     String path = dir + "mzm.gsp.market.confbean.SMarketSupplyItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 148 */       SAXReader reader = new SAXReader();
/* 149 */       org.dom4j.Document doc = reader.read(new File(path));
/* 150 */       Element root = doc.getRootElement();
/* 151 */       List<?> nodeList = root.elements();
/* 152 */       int len = nodeList.size();
/* 153 */       for (int i = 0; i < len; i++)
/*     */       {
/* 155 */         Element elem = (Element)nodeList.get(i);
/* 156 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMarketSupplyItemCfg"))
/*     */         {
/*     */ 
/* 159 */           SMarketSupplyItemCfg obj = new SMarketSupplyItemCfg();
/* 160 */           obj.loadFromXml(elem);
/* 161 */           if (all.put(Integer.valueOf(obj.itemid), obj) != null) {
/* 162 */             throw new RuntimeException("duplicate key : " + obj.itemid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 167 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 173 */     all = new java.util.HashMap();
/*     */     
/* 175 */     String path = dir + "mzm.gsp.market.confbean.SMarketSupplyItemCfg.bny";
/*     */     try
/*     */     {
/* 178 */       File file = new File(path);
/* 179 */       if (file.exists())
/*     */       {
/* 181 */         byte[] bytes = new byte['Ѐ'];
/* 182 */         FileInputStream fis = new FileInputStream(file);
/* 183 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 184 */         int len = 0;
/* 185 */         while ((len = fis.read(bytes)) > 0)
/* 186 */           baos.write(bytes, 0, len);
/* 187 */         fis.close();
/* 188 */         bytes = baos.toByteArray();
/* 189 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 192 */           _os_.unmarshal_int();
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/*     */         }
/* 196 */         _os_.unmarshal_int();
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 200 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 202 */           SMarketSupplyItemCfg _v_ = new SMarketSupplyItemCfg();
/* 203 */           _v_.unmarshal(_os_);
/* 204 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 205 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 210 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMarketSupplyItemCfg> all)
/*     */   {
/* 222 */     String path = dir + "mzm.gsp.market.confbean.SMarketSupplyItemCfg.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/*     */         }
/* 243 */         _os_.unmarshal_int();
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 247 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 249 */           SMarketSupplyItemCfg _v_ = new SMarketSupplyItemCfg();
/* 250 */           _v_.unmarshal(_os_);
/* 251 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMarketSupplyItemCfg getOld(int key)
/*     */   {
/* 270 */     return (SMarketSupplyItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMarketSupplyItemCfg get(int key)
/*     */   {
/* 275 */     return (SMarketSupplyItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarketSupplyItemCfg> getOldAll()
/*     */   {
/* 280 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarketSupplyItemCfg> getAll()
/*     */   {
/* 285 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMarketSupplyItemCfg> newAll)
/*     */   {
/* 290 */     oldAll = all;
/* 291 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 296 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\confbean\SMarketSupplyItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */