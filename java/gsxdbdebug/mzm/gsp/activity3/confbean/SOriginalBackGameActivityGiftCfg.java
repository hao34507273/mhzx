/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class SOriginalBackGameActivityGiftCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOriginalBackGameActivityGiftCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOriginalBackGameActivityGiftCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int tier1NeedRecharge;
/*     */   public int tier1GiftTypeId;
/*     */   public int tier2NeedRecharge;
/*     */   public int tier2GiftTypeId;
/*     */   public int tier3NeedRecharge;
/*     */   public int tier3GiftTypeId;
/*     */   public int tier4NeedRecharge;
/*     */   public int tier4GiftTypeId;
/*     */   public int tier5NeedRecharge;
/*     */   public int tier5GiftTypeId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.tier1NeedRecharge = Integer.valueOf(rootElement.attributeValue("tier1NeedRecharge")).intValue();
/*  34 */     this.tier1GiftTypeId = Integer.valueOf(rootElement.attributeValue("tier1GiftTypeId")).intValue();
/*  35 */     this.tier2NeedRecharge = Integer.valueOf(rootElement.attributeValue("tier2NeedRecharge")).intValue();
/*  36 */     this.tier2GiftTypeId = Integer.valueOf(rootElement.attributeValue("tier2GiftTypeId")).intValue();
/*  37 */     this.tier3NeedRecharge = Integer.valueOf(rootElement.attributeValue("tier3NeedRecharge")).intValue();
/*  38 */     this.tier3GiftTypeId = Integer.valueOf(rootElement.attributeValue("tier3GiftTypeId")).intValue();
/*  39 */     this.tier4NeedRecharge = Integer.valueOf(rootElement.attributeValue("tier4NeedRecharge")).intValue();
/*  40 */     this.tier4GiftTypeId = Integer.valueOf(rootElement.attributeValue("tier4GiftTypeId")).intValue();
/*  41 */     this.tier5NeedRecharge = Integer.valueOf(rootElement.attributeValue("tier5NeedRecharge")).intValue();
/*  42 */     this.tier5GiftTypeId = Integer.valueOf(rootElement.attributeValue("tier5GiftTypeId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.tier1NeedRecharge);
/*  49 */     _os_.marshal(this.tier1GiftTypeId);
/*  50 */     _os_.marshal(this.tier2NeedRecharge);
/*  51 */     _os_.marshal(this.tier2GiftTypeId);
/*  52 */     _os_.marshal(this.tier3NeedRecharge);
/*  53 */     _os_.marshal(this.tier3GiftTypeId);
/*  54 */     _os_.marshal(this.tier4NeedRecharge);
/*  55 */     _os_.marshal(this.tier4GiftTypeId);
/*  56 */     _os_.marshal(this.tier5NeedRecharge);
/*  57 */     _os_.marshal(this.tier5GiftTypeId);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.tier1NeedRecharge = _os_.unmarshal_int();
/*  65 */     this.tier1GiftTypeId = _os_.unmarshal_int();
/*  66 */     this.tier2NeedRecharge = _os_.unmarshal_int();
/*  67 */     this.tier2GiftTypeId = _os_.unmarshal_int();
/*  68 */     this.tier3NeedRecharge = _os_.unmarshal_int();
/*  69 */     this.tier3GiftTypeId = _os_.unmarshal_int();
/*  70 */     this.tier4NeedRecharge = _os_.unmarshal_int();
/*  71 */     this.tier4GiftTypeId = _os_.unmarshal_int();
/*  72 */     this.tier5NeedRecharge = _os_.unmarshal_int();
/*  73 */     this.tier5GiftTypeId = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.activity3.confbean.SOriginalBackGameActivityGiftCfg.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SOriginalBackGameActivityGiftCfg"))
/*     */         {
/*     */ 
/*  95 */           SOriginalBackGameActivityGiftCfg obj = new SOriginalBackGameActivityGiftCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOriginalBackGameActivityGiftCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.activity3.confbean.SOriginalBackGameActivityGiftCfg.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SOriginalBackGameActivityGiftCfg"))
/*     */         {
/*     */ 
/* 124 */           SOriginalBackGameActivityGiftCfg obj = new SOriginalBackGameActivityGiftCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 140 */     String path = dir + "mzm.gsp.activity3.confbean.SOriginalBackGameActivityGiftCfg.bny";
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
/* 167 */           SOriginalBackGameActivityGiftCfg _v_ = new SOriginalBackGameActivityGiftCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SOriginalBackGameActivityGiftCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.activity3.confbean.SOriginalBackGameActivityGiftCfg.bny";
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
/* 214 */           SOriginalBackGameActivityGiftCfg _v_ = new SOriginalBackGameActivityGiftCfg();
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
/*     */   public static SOriginalBackGameActivityGiftCfg getOld(int key)
/*     */   {
/* 235 */     return (SOriginalBackGameActivityGiftCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOriginalBackGameActivityGiftCfg get(int key)
/*     */   {
/* 240 */     return (SOriginalBackGameActivityGiftCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalBackGameActivityGiftCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalBackGameActivityGiftCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOriginalBackGameActivityGiftCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SOriginalBackGameActivityGiftCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */