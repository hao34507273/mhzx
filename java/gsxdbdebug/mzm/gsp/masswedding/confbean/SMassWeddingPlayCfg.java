/*     */ package mzm.gsp.masswedding.confbean;
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
/*     */ public class SMassWeddingPlayCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMassWeddingPlayCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMassWeddingPlayCfg> all = null;
/*     */   
/*     */   public int num;
/*     */   public int x;
/*     */   public int y;
/*     */   public int controlid;
/*     */   public int controlCount;
/*     */   public int stopSec;
/*     */   public int trigger;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.num = Integer.valueOf(rootElement.attributeValue("num")).intValue();
/*  29 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/*  30 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/*  31 */     this.controlid = Integer.valueOf(rootElement.attributeValue("controlid")).intValue();
/*  32 */     this.controlCount = Integer.valueOf(rootElement.attributeValue("controlCount")).intValue();
/*  33 */     this.stopSec = Integer.valueOf(rootElement.attributeValue("stopSec")).intValue();
/*  34 */     this.trigger = Integer.valueOf(rootElement.attributeValue("trigger")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  39 */     _os_.marshal(this.num);
/*  40 */     _os_.marshal(this.x);
/*  41 */     _os_.marshal(this.y);
/*  42 */     _os_.marshal(this.controlid);
/*  43 */     _os_.marshal(this.controlCount);
/*  44 */     _os_.marshal(this.stopSec);
/*  45 */     _os_.marshal(this.trigger);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  51 */     this.num = _os_.unmarshal_int();
/*  52 */     this.x = _os_.unmarshal_int();
/*  53 */     this.y = _os_.unmarshal_int();
/*  54 */     this.controlid = _os_.unmarshal_int();
/*  55 */     this.controlCount = _os_.unmarshal_int();
/*  56 */     this.stopSec = _os_.unmarshal_int();
/*  57 */     this.trigger = _os_.unmarshal_int();
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  63 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  67 */       all = new java.util.TreeMap();
/*  68 */       SAXReader reader = new SAXReader();
/*  69 */       org.dom4j.Document doc = reader.read(new File(path));
/*  70 */       Element root = doc.getRootElement();
/*  71 */       List<?> nodeList = root.elements();
/*  72 */       int len = nodeList.size();
/*  73 */       for (int i = 0; i < len; i++)
/*     */       {
/*  75 */         Element elem = (Element)nodeList.get(i);
/*  76 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg"))
/*     */         {
/*     */ 
/*  79 */           SMassWeddingPlayCfg obj = new SMassWeddingPlayCfg();
/*  80 */           obj.loadFromXml(elem);
/*  81 */           if (all.put(Integer.valueOf(obj.num), obj) != null) {
/*  82 */             throw new RuntimeException("duplicate key : " + obj.num);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  87 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMassWeddingPlayCfg> all)
/*     */   {
/*  93 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  97 */       SAXReader reader = new SAXReader();
/*  98 */       org.dom4j.Document doc = reader.read(new File(path));
/*  99 */       Element root = doc.getRootElement();
/* 100 */       List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element elem = (Element)nodeList.get(i);
/* 105 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg"))
/*     */         {
/*     */ 
/* 108 */           SMassWeddingPlayCfg obj = new SMassWeddingPlayCfg();
/* 109 */           obj.loadFromXml(elem);
/* 110 */           if (all.put(Integer.valueOf(obj.num), obj) != null) {
/* 111 */             throw new RuntimeException("duplicate key : " + obj.num);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 122 */     all = new java.util.TreeMap();
/*     */     
/* 124 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 141 */           _os_.unmarshal_int();
/* 142 */           _os_.unmarshal_int();
/* 143 */           _os_.unmarshal_int();
/*     */         }
/* 145 */         _os_.unmarshal_int();
/* 146 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 149 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 151 */           SMassWeddingPlayCfg _v_ = new SMassWeddingPlayCfg();
/* 152 */           _v_.unmarshal(_os_);
/* 153 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 159 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMassWeddingPlayCfg> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.masswedding.confbean.SMassWeddingPlayCfg.bny";
/*     */     try
/*     */     {
/* 174 */       File file = new File(path);
/* 175 */       if (file.exists())
/*     */       {
/* 177 */         byte[] bytes = new byte['Ѐ'];
/* 178 */         FileInputStream fis = new FileInputStream(file);
/* 179 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 180 */         int len = 0;
/* 181 */         while ((len = fis.read(bytes)) > 0)
/* 182 */           baos.write(bytes, 0, len);
/* 183 */         fis.close();
/* 184 */         bytes = baos.toByteArray();
/* 185 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/*     */         }
/* 192 */         _os_.unmarshal_int();
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 196 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 198 */           SMassWeddingPlayCfg _v_ = new SMassWeddingPlayCfg();
/* 199 */           _v_.unmarshal(_os_);
/* 200 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 206 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMassWeddingPlayCfg getOld(int key)
/*     */   {
/* 219 */     return (SMassWeddingPlayCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMassWeddingPlayCfg get(int key)
/*     */   {
/* 224 */     return (SMassWeddingPlayCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMassWeddingPlayCfg> getOldAll()
/*     */   {
/* 229 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMassWeddingPlayCfg> getAll()
/*     */   {
/* 234 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMassWeddingPlayCfg> newAll)
/*     */   {
/* 239 */     oldAll = all;
/* 240 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 245 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\confbean\SMassWeddingPlayCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */