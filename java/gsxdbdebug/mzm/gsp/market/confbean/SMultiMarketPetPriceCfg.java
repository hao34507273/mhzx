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
/*     */ public class SMultiMarketPetPriceCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMultiMarketPetPriceCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMultiMarketPetPriceCfg> all = null;
/*     */   
/*     */   public int xml_data_type;
/*     */   public int id;
/*     */   public int pet_price_skill_num_param;
/*     */   public int pet_price_skill_num_power_param;
/*     */   public int pet_price_skill_num_ratio_param;
/*     */   public double pet_max_price_param;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.xml_data_type = Integer.valueOf(rootElement.attributeValue("xml_data_type")).intValue();
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.pet_price_skill_num_param = Integer.valueOf(rootElement.attributeValue("pet_price_skill_num_param")).intValue();
/*  30 */     this.pet_price_skill_num_power_param = Integer.valueOf(rootElement.attributeValue("pet_price_skill_num_power_param")).intValue();
/*  31 */     this.pet_price_skill_num_ratio_param = Integer.valueOf(rootElement.attributeValue("pet_price_skill_num_ratio_param")).intValue();
/*  32 */     this.pet_max_price_param = Double.valueOf(rootElement.attributeValue("pet_max_price_param")).doubleValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  37 */     _os_.marshal(this.xml_data_type);
/*  38 */     _os_.marshal(this.id);
/*  39 */     _os_.marshal(this.pet_price_skill_num_param);
/*  40 */     _os_.marshal(this.pet_price_skill_num_power_param);
/*  41 */     _os_.marshal(this.pet_price_skill_num_ratio_param);
/*  42 */     _os_.marshal(this.pet_max_price_param);
/*  43 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  48 */     this.xml_data_type = _os_.unmarshal_int();
/*  49 */     this.id = _os_.unmarshal_int();
/*  50 */     this.pet_price_skill_num_param = _os_.unmarshal_int();
/*  51 */     this.pet_price_skill_num_power_param = _os_.unmarshal_int();
/*  52 */     this.pet_price_skill_num_ratio_param = _os_.unmarshal_int();
/*  53 */     this.pet_max_price_param = _os_.unmarshal_float();
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  59 */     String path = dir + "mzm.gsp.market.confbean.SMultiMarketPetPriceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  63 */       all = new java.util.HashMap();
/*  64 */       SAXReader reader = new SAXReader();
/*  65 */       org.dom4j.Document doc = reader.read(new File(path));
/*  66 */       Element root = doc.getRootElement();
/*  67 */       List<?> nodeList = root.elements();
/*  68 */       int len = nodeList.size();
/*  69 */       for (int i = 0; i < len; i++)
/*     */       {
/*  71 */         Element elem = (Element)nodeList.get(i);
/*  72 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMultiMarketPetPriceCfg"))
/*     */         {
/*     */ 
/*  75 */           SMultiMarketPetPriceCfg obj = new SMultiMarketPetPriceCfg();
/*  76 */           obj.loadFromXml(elem);
/*  77 */           if (all.put(Integer.valueOf(obj.xml_data_type), obj) != null) {
/*  78 */             throw new RuntimeException("duplicate key : " + obj.xml_data_type);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  83 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMultiMarketPetPriceCfg> all)
/*     */   {
/*  89 */     String path = dir + "mzm.gsp.market.confbean.SMultiMarketPetPriceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  93 */       SAXReader reader = new SAXReader();
/*  94 */       org.dom4j.Document doc = reader.read(new File(path));
/*  95 */       Element root = doc.getRootElement();
/*  96 */       List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element elem = (Element)nodeList.get(i);
/* 101 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.market.confbean.SMultiMarketPetPriceCfg"))
/*     */         {
/*     */ 
/* 104 */           SMultiMarketPetPriceCfg obj = new SMultiMarketPetPriceCfg();
/* 105 */           obj.loadFromXml(elem);
/* 106 */           if (all.put(Integer.valueOf(obj.xml_data_type), obj) != null) {
/* 107 */             throw new RuntimeException("duplicate key : " + obj.xml_data_type);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 112 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 118 */     all = new java.util.HashMap();
/*     */     
/* 120 */     String path = dir + "mzm.gsp.market.confbean.SMultiMarketPetPriceCfg.bny";
/*     */     try
/*     */     {
/* 123 */       File file = new File(path);
/* 124 */       if (file.exists())
/*     */       {
/* 126 */         byte[] bytes = new byte['Ѐ'];
/* 127 */         FileInputStream fis = new FileInputStream(file);
/* 128 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 129 */         int len = 0;
/* 130 */         while ((len = fis.read(bytes)) > 0)
/* 131 */           baos.write(bytes, 0, len);
/* 132 */         fis.close();
/* 133 */         bytes = baos.toByteArray();
/* 134 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 135 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 137 */           _os_.unmarshal_int();
/* 138 */           _os_.unmarshal_int();
/* 139 */           _os_.unmarshal_int();
/*     */         }
/* 141 */         _os_.unmarshal_int();
/* 142 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 145 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 147 */           SMultiMarketPetPriceCfg _v_ = new SMultiMarketPetPriceCfg();
/* 148 */           _v_.unmarshal(_os_);
/* 149 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 155 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMultiMarketPetPriceCfg> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.market.confbean.SMultiMarketPetPriceCfg.bny";
/*     */     try
/*     */     {
/* 170 */       File file = new File(path);
/* 171 */       if (file.exists())
/*     */       {
/* 173 */         byte[] bytes = new byte['Ѐ'];
/* 174 */         FileInputStream fis = new FileInputStream(file);
/* 175 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 176 */         int len = 0;
/* 177 */         while ((len = fis.read(bytes)) > 0)
/* 178 */           baos.write(bytes, 0, len);
/* 179 */         fis.close();
/* 180 */         bytes = baos.toByteArray();
/* 181 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 184 */           _os_.unmarshal_int();
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/*     */         }
/* 188 */         _os_.unmarshal_int();
/* 189 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 192 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 194 */           SMultiMarketPetPriceCfg _v_ = new SMultiMarketPetPriceCfg();
/* 195 */           _v_.unmarshal(_os_);
/* 196 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 202 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 207 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMultiMarketPetPriceCfg getOld(int key)
/*     */   {
/* 215 */     return (SMultiMarketPetPriceCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMultiMarketPetPriceCfg get(int key)
/*     */   {
/* 220 */     return (SMultiMarketPetPriceCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMultiMarketPetPriceCfg> getOldAll()
/*     */   {
/* 225 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMultiMarketPetPriceCfg> getAll()
/*     */   {
/* 230 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMultiMarketPetPriceCfg> newAll)
/*     */   {
/* 235 */     oldAll = all;
/* 236 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 241 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\confbean\SMultiMarketPetPriceCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */