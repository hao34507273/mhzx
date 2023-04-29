/*     */ package mzm.gsp.qingfu.confbean;
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
/*     */ public class SRMBGiftBagAwardOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SRMBGiftBagAwardOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SRMBGiftBagAwardOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public int tier;
/*     */   public int buy_max_times;
/*     */   public int day;
/*     */   public String title;
/*     */   public String desc;
/*     */   public int award_cfg_id;
/*     */   public int product_service_id;
/*     */   public int activity_cfg_id;
/*     */   public int send_award_mail_cfgid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.name = rootElement.attributeValue("name");
/*  34 */     this.tier = Integer.valueOf(rootElement.attributeValue("tier")).intValue();
/*  35 */     this.buy_max_times = Integer.valueOf(rootElement.attributeValue("buy_max_times")).intValue();
/*  36 */     this.day = Integer.valueOf(rootElement.attributeValue("day")).intValue();
/*  37 */     this.title = rootElement.attributeValue("title");
/*  38 */     this.desc = rootElement.attributeValue("desc");
/*  39 */     this.award_cfg_id = Integer.valueOf(rootElement.attributeValue("award_cfg_id")).intValue();
/*  40 */     this.product_service_id = Integer.valueOf(rootElement.attributeValue("product_service_id")).intValue();
/*  41 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  42 */     this.send_award_mail_cfgid = Integer.valueOf(rootElement.attributeValue("send_award_mail_cfgid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.name, "UTF-8");
/*  49 */     _os_.marshal(this.tier);
/*  50 */     _os_.marshal(this.buy_max_times);
/*  51 */     _os_.marshal(this.day);
/*  52 */     _os_.marshal(this.title, "UTF-8");
/*  53 */     _os_.marshal(this.desc, "UTF-8");
/*  54 */     _os_.marshal(this.award_cfg_id);
/*  55 */     _os_.marshal(this.product_service_id);
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.send_award_mail_cfgid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.name = _os_.unmarshal_String("UTF-8");
/*  65 */     this.tier = _os_.unmarshal_int();
/*  66 */     this.buy_max_times = _os_.unmarshal_int();
/*  67 */     this.day = _os_.unmarshal_int();
/*  68 */     this.title = _os_.unmarshal_String("UTF-8");
/*  69 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  70 */     this.award_cfg_id = _os_.unmarshal_int();
/*  71 */     this.product_service_id = _os_.unmarshal_int();
/*  72 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  73 */     this.send_award_mail_cfgid = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.qingfu.confbean.SRMBGiftBagAwardOriginalCfg.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SRMBGiftBagAwardOriginalCfg"))
/*     */         {
/*     */ 
/*  95 */           SRMBGiftBagAwardOriginalCfg obj = new SRMBGiftBagAwardOriginalCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, SRMBGiftBagAwardOriginalCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.qingfu.confbean.SRMBGiftBagAwardOriginalCfg.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.SRMBGiftBagAwardOriginalCfg"))
/*     */         {
/*     */ 
/* 124 */           SRMBGiftBagAwardOriginalCfg obj = new SRMBGiftBagAwardOriginalCfg();
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
/* 140 */     String path = dir + "mzm.gsp.qingfu.confbean.SRMBGiftBagAwardOriginalCfg.bny";
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
/* 167 */           SRMBGiftBagAwardOriginalCfg _v_ = new SRMBGiftBagAwardOriginalCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SRMBGiftBagAwardOriginalCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.qingfu.confbean.SRMBGiftBagAwardOriginalCfg.bny";
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
/* 214 */           SRMBGiftBagAwardOriginalCfg _v_ = new SRMBGiftBagAwardOriginalCfg();
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
/*     */   public static SRMBGiftBagAwardOriginalCfg getOld(int key)
/*     */   {
/* 235 */     return (SRMBGiftBagAwardOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRMBGiftBagAwardOriginalCfg get(int key)
/*     */   {
/* 240 */     return (SRMBGiftBagAwardOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRMBGiftBagAwardOriginalCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRMBGiftBagAwardOriginalCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRMBGiftBagAwardOriginalCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\SRMBGiftBagAwardOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */