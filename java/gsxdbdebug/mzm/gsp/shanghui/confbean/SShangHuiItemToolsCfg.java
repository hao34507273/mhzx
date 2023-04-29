/*     */ package mzm.gsp.shanghui.confbean;
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
/*     */ public class SShangHuiItemToolsCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SShangHuiItemToolsCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SShangHuiItemToolsCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int daySellMaxNum;
/*     */   public int dayBuyMaxNum;
/*     */   public boolean isPriceFlow;
/*     */   public int minPrice;
/*     */   public int maxPrice;
/*     */   public int orginialPrice;
/*     */   public boolean isOrginalPriceRefLevel;
/*     */   public int orginalPriceCfgId;
/*     */   public int priceFlowFormulaId;
/*     */   public int openServerLevel;
/*     */   public int bigTypeId;
/*     */   public int SubTypeId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.daySellMaxNum = Integer.valueOf(rootElement.attributeValue("daySellMaxNum")).intValue();
/*  36 */     this.dayBuyMaxNum = Integer.valueOf(rootElement.attributeValue("dayBuyMaxNum")).intValue();
/*  37 */     this.isPriceFlow = Boolean.valueOf(rootElement.attributeValue("isPriceFlow")).booleanValue();
/*  38 */     this.minPrice = Integer.valueOf(rootElement.attributeValue("minPrice")).intValue();
/*  39 */     this.maxPrice = Integer.valueOf(rootElement.attributeValue("maxPrice")).intValue();
/*  40 */     this.orginialPrice = Integer.valueOf(rootElement.attributeValue("orginialPrice")).intValue();
/*  41 */     this.isOrginalPriceRefLevel = Boolean.valueOf(rootElement.attributeValue("isOrginalPriceRefLevel")).booleanValue();
/*  42 */     this.orginalPriceCfgId = Integer.valueOf(rootElement.attributeValue("orginalPriceCfgId")).intValue();
/*  43 */     this.priceFlowFormulaId = Integer.valueOf(rootElement.attributeValue("priceFlowFormulaId")).intValue();
/*  44 */     this.openServerLevel = Integer.valueOf(rootElement.attributeValue("openServerLevel")).intValue();
/*  45 */     this.bigTypeId = Integer.valueOf(rootElement.attributeValue("bigTypeId")).intValue();
/*  46 */     this.SubTypeId = Integer.valueOf(rootElement.attributeValue("SubTypeId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.daySellMaxNum);
/*  53 */     _os_.marshal(this.dayBuyMaxNum);
/*  54 */     _os_.marshal(this.isPriceFlow);
/*  55 */     _os_.marshal(this.minPrice);
/*  56 */     _os_.marshal(this.maxPrice);
/*  57 */     _os_.marshal(this.orginialPrice);
/*  58 */     _os_.marshal(this.isOrginalPriceRefLevel);
/*  59 */     _os_.marshal(this.orginalPriceCfgId);
/*  60 */     _os_.marshal(this.priceFlowFormulaId);
/*  61 */     _os_.marshal(this.openServerLevel);
/*  62 */     _os_.marshal(this.bigTypeId);
/*  63 */     _os_.marshal(this.SubTypeId);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.daySellMaxNum = _os_.unmarshal_int();
/*  71 */     this.dayBuyMaxNum = _os_.unmarshal_int();
/*  72 */     this.isPriceFlow = _os_.unmarshal_boolean();
/*  73 */     this.minPrice = _os_.unmarshal_int();
/*  74 */     this.maxPrice = _os_.unmarshal_int();
/*  75 */     this.orginialPrice = _os_.unmarshal_int();
/*  76 */     this.isOrginalPriceRefLevel = _os_.unmarshal_boolean();
/*  77 */     this.orginalPriceCfgId = _os_.unmarshal_int();
/*  78 */     this.priceFlowFormulaId = _os_.unmarshal_int();
/*  79 */     this.openServerLevel = _os_.unmarshal_int();
/*  80 */     this.bigTypeId = _os_.unmarshal_int();
/*  81 */     this.SubTypeId = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg"))
/*     */         {
/*     */ 
/* 103 */           SShangHuiItemToolsCfg obj = new SShangHuiItemToolsCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SShangHuiItemToolsCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg"))
/*     */         {
/*     */ 
/* 132 */           SShangHuiItemToolsCfg obj = new SShangHuiItemToolsCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SShangHuiItemToolsCfg _v_ = new SShangHuiItemToolsCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SShangHuiItemToolsCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.shanghui.confbean.SShangHuiItemToolsCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SShangHuiItemToolsCfg _v_ = new SShangHuiItemToolsCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SShangHuiItemToolsCfg getOld(int key)
/*     */   {
/* 243 */     return (SShangHuiItemToolsCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SShangHuiItemToolsCfg get(int key)
/*     */   {
/* 248 */     return (SShangHuiItemToolsCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SShangHuiItemToolsCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SShangHuiItemToolsCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SShangHuiItemToolsCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\confbean\SShangHuiItemToolsCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */