/*     */ package mzm.gsp.homeland.confbean;
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
/*     */ public class SFurnitureBuyCountCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFurnitureBuyCountCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFurnitureBuyCountCfg> all = null;
/*     */   
/*     */   public int itemId;
/*     */   public int id;
/*     */   public int weight;
/*     */   public int maxBuyNum;
/*     */   public int buyMoneyType;
/*     */   public int buyMoneyNum;
/*     */   public int sellMoneyType;
/*     */   public int sellMoneyNum;
/*     */   public int freshNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*  33 */     this.maxBuyNum = Integer.valueOf(rootElement.attributeValue("maxBuyNum")).intValue();
/*  34 */     this.buyMoneyType = Integer.valueOf(rootElement.attributeValue("buyMoneyType")).intValue();
/*  35 */     this.buyMoneyNum = Integer.valueOf(rootElement.attributeValue("buyMoneyNum")).intValue();
/*  36 */     this.sellMoneyType = Integer.valueOf(rootElement.attributeValue("sellMoneyType")).intValue();
/*  37 */     this.sellMoneyNum = Integer.valueOf(rootElement.attributeValue("sellMoneyNum")).intValue();
/*  38 */     this.freshNum = Integer.valueOf(rootElement.attributeValue("freshNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  43 */     _os_.marshal(this.itemId);
/*  44 */     _os_.marshal(this.id);
/*  45 */     _os_.marshal(this.weight);
/*  46 */     _os_.marshal(this.maxBuyNum);
/*  47 */     _os_.marshal(this.buyMoneyType);
/*  48 */     _os_.marshal(this.buyMoneyNum);
/*  49 */     _os_.marshal(this.sellMoneyType);
/*  50 */     _os_.marshal(this.sellMoneyNum);
/*  51 */     _os_.marshal(this.freshNum);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  57 */     this.itemId = _os_.unmarshal_int();
/*  58 */     this.id = _os_.unmarshal_int();
/*  59 */     this.weight = _os_.unmarshal_int();
/*  60 */     this.maxBuyNum = _os_.unmarshal_int();
/*  61 */     this.buyMoneyType = _os_.unmarshal_int();
/*  62 */     this.buyMoneyNum = _os_.unmarshal_int();
/*  63 */     this.sellMoneyType = _os_.unmarshal_int();
/*  64 */     this.sellMoneyNum = _os_.unmarshal_int();
/*  65 */     this.freshNum = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  71 */     String path = dir + "mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  75 */       all = new java.util.HashMap();
/*  76 */       SAXReader reader = new SAXReader();
/*  77 */       org.dom4j.Document doc = reader.read(new File(path));
/*  78 */       Element root = doc.getRootElement();
/*  79 */       List<?> nodeList = root.elements();
/*  80 */       int len = nodeList.size();
/*  81 */       for (int i = 0; i < len; i++)
/*     */       {
/*  83 */         Element elem = (Element)nodeList.get(i);
/*  84 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg"))
/*     */         {
/*     */ 
/*  87 */           SFurnitureBuyCountCfg obj = new SFurnitureBuyCountCfg();
/*  88 */           obj.loadFromXml(elem);
/*  89 */           if (all.put(Integer.valueOf(obj.itemId), obj) != null) {
/*  90 */             throw new RuntimeException("duplicate key : " + obj.itemId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  95 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFurnitureBuyCountCfg> all)
/*     */   {
/* 101 */     String path = dir + "mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg"))
/*     */         {
/*     */ 
/* 116 */           SFurnitureBuyCountCfg obj = new SFurnitureBuyCountCfg();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.itemId), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.itemId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 130 */     all = new java.util.HashMap();
/*     */     
/* 132 */     String path = dir + "mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg.bny";
/*     */     try
/*     */     {
/* 135 */       File file = new File(path);
/* 136 */       if (file.exists())
/*     */       {
/* 138 */         byte[] bytes = new byte['Ѐ'];
/* 139 */         FileInputStream fis = new FileInputStream(file);
/* 140 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 141 */         int len = 0;
/* 142 */         while ((len = fis.read(bytes)) > 0)
/* 143 */           baos.write(bytes, 0, len);
/* 144 */         fis.close();
/* 145 */         bytes = baos.toByteArray();
/* 146 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 147 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 149 */           _os_.unmarshal_int();
/* 150 */           _os_.unmarshal_int();
/* 151 */           _os_.unmarshal_int();
/*     */         }
/* 153 */         _os_.unmarshal_int();
/* 154 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 157 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 159 */           SFurnitureBuyCountCfg _v_ = new SFurnitureBuyCountCfg();
/* 160 */           _v_.unmarshal(_os_);
/* 161 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 162 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 167 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFurnitureBuyCountCfg> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg.bny";
/*     */     try
/*     */     {
/* 182 */       File file = new File(path);
/* 183 */       if (file.exists())
/*     */       {
/* 185 */         byte[] bytes = new byte['Ѐ'];
/* 186 */         FileInputStream fis = new FileInputStream(file);
/* 187 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 188 */         int len = 0;
/* 189 */         while ((len = fis.read(bytes)) > 0)
/* 190 */           baos.write(bytes, 0, len);
/* 191 */         fis.close();
/* 192 */         bytes = baos.toByteArray();
/* 193 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/*     */         }
/* 200 */         _os_.unmarshal_int();
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 204 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 206 */           SFurnitureBuyCountCfg _v_ = new SFurnitureBuyCountCfg();
/* 207 */           _v_.unmarshal(_os_);
/* 208 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 214 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFurnitureBuyCountCfg getOld(int key)
/*     */   {
/* 227 */     return (SFurnitureBuyCountCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFurnitureBuyCountCfg get(int key)
/*     */   {
/* 232 */     return (SFurnitureBuyCountCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFurnitureBuyCountCfg> getOldAll()
/*     */   {
/* 237 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFurnitureBuyCountCfg> getAll()
/*     */   {
/* 242 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFurnitureBuyCountCfg> newAll)
/*     */   {
/* 247 */     oldAll = all;
/* 248 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 253 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SFurnitureBuyCountCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */