/*     */ package mzm.gsp.mysteryshop.confbean;
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
/*     */ public class CSMysteryShopConstsCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CSMysteryShopConstsCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CSMysteryShopConstsCfg> all = null;
/*     */   
/*     */   public int shopType;
/*     */   public int MIN_ROLE_LEVLE_FOR_MYSTERY_SHOP;
/*     */   public int GOODS_GRID_NUM;
/*     */   public int DAILY_MAX_REFRESH_TIMES;
/*     */   public double SALE_PROMPT_THRESHOLD;
/*     */   public int SALE_MIN;
/*     */   public int SALE_COLOR_1;
/*     */   public double SALE_RANGE_1;
/*     */   public int SALE_COLOR_2;
/*     */   public double SALE_RANGE_2;
/*     */   public int SALE_COLOR_3;
/*     */   public double SALE_RANGE_3;
/*     */   public double BULLETIN_MIN_SALE;
/*     */   public int FREE_REFRESH_TIMES_CONDITION;
/*     */   public int MAX_FREE_REFRESH_TIMES;
/*     */   public int HOVER_TIPS_ID;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.shopType = Integer.valueOf(rootElement.attributeValue("shopType")).intValue();
/*  38 */     this.MIN_ROLE_LEVLE_FOR_MYSTERY_SHOP = Integer.valueOf(rootElement.attributeValue("MIN_ROLE_LEVLE_FOR_MYSTERY_SHOP")).intValue();
/*  39 */     this.GOODS_GRID_NUM = Integer.valueOf(rootElement.attributeValue("GOODS_GRID_NUM")).intValue();
/*  40 */     this.DAILY_MAX_REFRESH_TIMES = Integer.valueOf(rootElement.attributeValue("DAILY_MAX_REFRESH_TIMES")).intValue();
/*  41 */     this.SALE_PROMPT_THRESHOLD = Double.valueOf(rootElement.attributeValue("SALE_PROMPT_THRESHOLD")).doubleValue();
/*  42 */     this.SALE_MIN = Integer.valueOf(rootElement.attributeValue("SALE_MIN")).intValue();
/*  43 */     this.SALE_COLOR_1 = Integer.valueOf(rootElement.attributeValue("SALE_COLOR_1")).intValue();
/*  44 */     this.SALE_RANGE_1 = Double.valueOf(rootElement.attributeValue("SALE_RANGE_1")).doubleValue();
/*  45 */     this.SALE_COLOR_2 = Integer.valueOf(rootElement.attributeValue("SALE_COLOR_2")).intValue();
/*  46 */     this.SALE_RANGE_2 = Double.valueOf(rootElement.attributeValue("SALE_RANGE_2")).doubleValue();
/*  47 */     this.SALE_COLOR_3 = Integer.valueOf(rootElement.attributeValue("SALE_COLOR_3")).intValue();
/*  48 */     this.SALE_RANGE_3 = Double.valueOf(rootElement.attributeValue("SALE_RANGE_3")).doubleValue();
/*  49 */     this.BULLETIN_MIN_SALE = Double.valueOf(rootElement.attributeValue("BULLETIN_MIN_SALE")).doubleValue();
/*  50 */     this.FREE_REFRESH_TIMES_CONDITION = Integer.valueOf(rootElement.attributeValue("FREE_REFRESH_TIMES_CONDITION")).intValue();
/*  51 */     this.MAX_FREE_REFRESH_TIMES = Integer.valueOf(rootElement.attributeValue("MAX_FREE_REFRESH_TIMES")).intValue();
/*  52 */     this.HOVER_TIPS_ID = Integer.valueOf(rootElement.attributeValue("HOVER_TIPS_ID")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.shopType);
/*  58 */     _os_.marshal(this.MIN_ROLE_LEVLE_FOR_MYSTERY_SHOP);
/*  59 */     _os_.marshal(this.GOODS_GRID_NUM);
/*  60 */     _os_.marshal(this.DAILY_MAX_REFRESH_TIMES);
/*  61 */     _os_.marshal(this.SALE_PROMPT_THRESHOLD);
/*  62 */     _os_.marshal(this.SALE_MIN);
/*  63 */     _os_.marshal(this.SALE_COLOR_1);
/*  64 */     _os_.marshal(this.SALE_RANGE_1);
/*  65 */     _os_.marshal(this.SALE_COLOR_2);
/*  66 */     _os_.marshal(this.SALE_RANGE_2);
/*  67 */     _os_.marshal(this.SALE_COLOR_3);
/*  68 */     _os_.marshal(this.SALE_RANGE_3);
/*  69 */     _os_.marshal(this.BULLETIN_MIN_SALE);
/*  70 */     _os_.marshal(this.FREE_REFRESH_TIMES_CONDITION);
/*  71 */     _os_.marshal(this.MAX_FREE_REFRESH_TIMES);
/*  72 */     _os_.marshal(this.HOVER_TIPS_ID);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.shopType = _os_.unmarshal_int();
/*  79 */     this.MIN_ROLE_LEVLE_FOR_MYSTERY_SHOP = _os_.unmarshal_int();
/*  80 */     this.GOODS_GRID_NUM = _os_.unmarshal_int();
/*  81 */     this.DAILY_MAX_REFRESH_TIMES = _os_.unmarshal_int();
/*  82 */     this.SALE_PROMPT_THRESHOLD = _os_.unmarshal_float();
/*  83 */     this.SALE_MIN = _os_.unmarshal_int();
/*  84 */     this.SALE_COLOR_1 = _os_.unmarshal_int();
/*  85 */     this.SALE_RANGE_1 = _os_.unmarshal_float();
/*  86 */     this.SALE_COLOR_2 = _os_.unmarshal_int();
/*  87 */     this.SALE_RANGE_2 = _os_.unmarshal_float();
/*  88 */     this.SALE_COLOR_3 = _os_.unmarshal_int();
/*  89 */     this.SALE_RANGE_3 = _os_.unmarshal_float();
/*  90 */     this.BULLETIN_MIN_SALE = _os_.unmarshal_float();
/*  91 */     this.FREE_REFRESH_TIMES_CONDITION = _os_.unmarshal_int();
/*  92 */     this.MAX_FREE_REFRESH_TIMES = _os_.unmarshal_int();
/*  93 */     this.HOVER_TIPS_ID = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 103 */       all = new java.util.HashMap();
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       List<?> nodeList = root.elements();
/* 108 */       int len = nodeList.size();
/* 109 */       for (int i = 0; i < len; i++)
/*     */       {
/* 111 */         Element elem = (Element)nodeList.get(i);
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg"))
/*     */         {
/*     */ 
/* 115 */           CSMysteryShopConstsCfg obj = new CSMysteryShopConstsCfg();
/* 116 */           obj.loadFromXml(elem);
/* 117 */           if (all.put(Integer.valueOf(obj.shopType), obj) != null) {
/* 118 */             throw new RuntimeException("duplicate key : " + obj.shopType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, CSMysteryShopConstsCfg> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg"))
/*     */         {
/*     */ 
/* 144 */           CSMysteryShopConstsCfg obj = new CSMysteryShopConstsCfg();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.shopType), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.shopType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 158 */     all = new java.util.HashMap();
/*     */     
/* 160 */     String path = dir + "mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 177 */           _os_.unmarshal_int();
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/*     */         }
/* 181 */         _os_.unmarshal_int();
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 185 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 187 */           CSMysteryShopConstsCfg _v_ = new CSMysteryShopConstsCfg();
/* 188 */           _v_.unmarshal(_os_);
/* 189 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 190 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 195 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, CSMysteryShopConstsCfg> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.mysteryshop.confbean.CSMysteryShopConstsCfg.bny";
/*     */     try
/*     */     {
/* 210 */       File file = new File(path);
/* 211 */       if (file.exists())
/*     */       {
/* 213 */         byte[] bytes = new byte['Ѐ'];
/* 214 */         FileInputStream fis = new FileInputStream(file);
/* 215 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 216 */         int len = 0;
/* 217 */         while ((len = fis.read(bytes)) > 0)
/* 218 */           baos.write(bytes, 0, len);
/* 219 */         fis.close();
/* 220 */         bytes = baos.toByteArray();
/* 221 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/*     */         }
/* 228 */         _os_.unmarshal_int();
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 232 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 234 */           CSMysteryShopConstsCfg _v_ = new CSMysteryShopConstsCfg();
/* 235 */           _v_.unmarshal(_os_);
/* 236 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 237 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 242 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static CSMysteryShopConstsCfg getOld(int key)
/*     */   {
/* 255 */     return (CSMysteryShopConstsCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CSMysteryShopConstsCfg get(int key)
/*     */   {
/* 260 */     return (CSMysteryShopConstsCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CSMysteryShopConstsCfg> getOldAll()
/*     */   {
/* 265 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CSMysteryShopConstsCfg> getAll()
/*     */   {
/* 270 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CSMysteryShopConstsCfg> newAll)
/*     */   {
/* 275 */     oldAll = all;
/* 276 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 281 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\confbean\CSMysteryShopConstsCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */