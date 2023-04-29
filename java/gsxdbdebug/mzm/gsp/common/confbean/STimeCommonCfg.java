/*     */ package mzm.gsp.common.confbean;
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
/*     */ public class STimeCommonCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STimeCommonCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STimeCommonCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activeHour;
/*     */   public int activeMinute;
/*     */   public int activeWeekDay;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  26 */     this.activeHour = Integer.valueOf(rootElement.attributeValue("activeHour")).intValue();
/*  27 */     this.activeMinute = Integer.valueOf(rootElement.attributeValue("activeMinute")).intValue();
/*  28 */     this.activeWeekDay = Integer.valueOf(rootElement.attributeValue("activeWeekDay")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  33 */     _os_.marshal(this.id);
/*  34 */     _os_.marshal(this.activeHour);
/*  35 */     _os_.marshal(this.activeMinute);
/*  36 */     _os_.marshal(this.activeWeekDay);
/*  37 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  42 */     this.id = _os_.unmarshal_int();
/*  43 */     this.activeHour = _os_.unmarshal_int();
/*  44 */     this.activeMinute = _os_.unmarshal_int();
/*  45 */     this.activeWeekDay = _os_.unmarshal_int();
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  51 */     String path = dir + "mzm.gsp.common.confbean.STimeCommonCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  55 */       all = new java.util.HashMap();
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       List<?> nodeList = root.elements();
/*  60 */       int len = nodeList.size();
/*  61 */       for (int i = 0; i < len; i++)
/*     */       {
/*  63 */         Element elem = (Element)nodeList.get(i);
/*  64 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.common.confbean.STimeCommonCfg"))
/*     */         {
/*     */ 
/*  67 */           STimeCommonCfg obj = new STimeCommonCfg();
/*  68 */           obj.loadFromXml(elem);
/*  69 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  70 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  75 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STimeCommonCfg> all)
/*     */   {
/*  81 */     String path = dir + "mzm.gsp.common.confbean.STimeCommonCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  85 */       SAXReader reader = new SAXReader();
/*  86 */       org.dom4j.Document doc = reader.read(new File(path));
/*  87 */       Element root = doc.getRootElement();
/*  88 */       List<?> nodeList = root.elements();
/*  89 */       int len = nodeList.size();
/*  90 */       for (int i = 0; i < len; i++)
/*     */       {
/*  92 */         Element elem = (Element)nodeList.get(i);
/*  93 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.common.confbean.STimeCommonCfg"))
/*     */         {
/*     */ 
/*  96 */           STimeCommonCfg obj = new STimeCommonCfg();
/*  97 */           obj.loadFromXml(elem);
/*  98 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  99 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 110 */     all = new java.util.HashMap();
/*     */     
/* 112 */     String path = dir + "mzm.gsp.common.confbean.STimeCommonCfg.bny";
/*     */     try
/*     */     {
/* 115 */       File file = new File(path);
/* 116 */       if (file.exists())
/*     */       {
/* 118 */         byte[] bytes = new byte['Ѐ'];
/* 119 */         FileInputStream fis = new FileInputStream(file);
/* 120 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 121 */         int len = 0;
/* 122 */         while ((len = fis.read(bytes)) > 0)
/* 123 */           baos.write(bytes, 0, len);
/* 124 */         fis.close();
/* 125 */         bytes = baos.toByteArray();
/* 126 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 127 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 129 */           _os_.unmarshal_int();
/* 130 */           _os_.unmarshal_int();
/* 131 */           _os_.unmarshal_int();
/*     */         }
/* 133 */         _os_.unmarshal_int();
/* 134 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 137 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 139 */           STimeCommonCfg _v_ = new STimeCommonCfg();
/* 140 */           _v_.unmarshal(_os_);
/* 141 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 142 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 147 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STimeCommonCfg> all)
/*     */   {
/* 159 */     String path = dir + "mzm.gsp.common.confbean.STimeCommonCfg.bny";
/*     */     try
/*     */     {
/* 162 */       File file = new File(path);
/* 163 */       if (file.exists())
/*     */       {
/* 165 */         byte[] bytes = new byte['Ѐ'];
/* 166 */         FileInputStream fis = new FileInputStream(file);
/* 167 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 168 */         int len = 0;
/* 169 */         while ((len = fis.read(bytes)) > 0)
/* 170 */           baos.write(bytes, 0, len);
/* 171 */         fis.close();
/* 172 */         bytes = baos.toByteArray();
/* 173 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 176 */           _os_.unmarshal_int();
/* 177 */           _os_.unmarshal_int();
/* 178 */           _os_.unmarshal_int();
/*     */         }
/* 180 */         _os_.unmarshal_int();
/* 181 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 184 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 186 */           STimeCommonCfg _v_ = new STimeCommonCfg();
/* 187 */           _v_.unmarshal(_os_);
/* 188 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 189 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 194 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 199 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STimeCommonCfg getOld(int key)
/*     */   {
/* 207 */     return (STimeCommonCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STimeCommonCfg get(int key)
/*     */   {
/* 212 */     return (STimeCommonCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STimeCommonCfg> getOldAll()
/*     */   {
/* 217 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STimeCommonCfg> getAll()
/*     */   {
/* 222 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STimeCommonCfg> newAll)
/*     */   {
/* 227 */     oldAll = all;
/* 228 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 233 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\confbean\STimeCommonCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */