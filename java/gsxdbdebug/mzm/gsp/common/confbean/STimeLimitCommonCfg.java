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
/*     */ public class STimeLimitCommonCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STimeLimitCommonCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STimeLimitCommonCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int startYear;
/*     */   public int startMonth;
/*     */   public int startDay;
/*     */   public int startHour;
/*     */   public int startMinute;
/*     */   public int endYear;
/*     */   public int endMonth;
/*     */   public int endDay;
/*     */   public int endHour;
/*     */   public int endMinute;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.startYear = Integer.valueOf(rootElement.attributeValue("startYear")).intValue();
/*  34 */     this.startMonth = Integer.valueOf(rootElement.attributeValue("startMonth")).intValue();
/*  35 */     this.startDay = Integer.valueOf(rootElement.attributeValue("startDay")).intValue();
/*  36 */     this.startHour = Integer.valueOf(rootElement.attributeValue("startHour")).intValue();
/*  37 */     this.startMinute = Integer.valueOf(rootElement.attributeValue("startMinute")).intValue();
/*  38 */     this.endYear = Integer.valueOf(rootElement.attributeValue("endYear")).intValue();
/*  39 */     this.endMonth = Integer.valueOf(rootElement.attributeValue("endMonth")).intValue();
/*  40 */     this.endDay = Integer.valueOf(rootElement.attributeValue("endDay")).intValue();
/*  41 */     this.endHour = Integer.valueOf(rootElement.attributeValue("endHour")).intValue();
/*  42 */     this.endMinute = Integer.valueOf(rootElement.attributeValue("endMinute")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.startYear);
/*  49 */     _os_.marshal(this.startMonth);
/*  50 */     _os_.marshal(this.startDay);
/*  51 */     _os_.marshal(this.startHour);
/*  52 */     _os_.marshal(this.startMinute);
/*  53 */     _os_.marshal(this.endYear);
/*  54 */     _os_.marshal(this.endMonth);
/*  55 */     _os_.marshal(this.endDay);
/*  56 */     _os_.marshal(this.endHour);
/*  57 */     _os_.marshal(this.endMinute);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.startYear = _os_.unmarshal_int();
/*  65 */     this.startMonth = _os_.unmarshal_int();
/*  66 */     this.startDay = _os_.unmarshal_int();
/*  67 */     this.startHour = _os_.unmarshal_int();
/*  68 */     this.startMinute = _os_.unmarshal_int();
/*  69 */     this.endYear = _os_.unmarshal_int();
/*  70 */     this.endMonth = _os_.unmarshal_int();
/*  71 */     this.endDay = _os_.unmarshal_int();
/*  72 */     this.endHour = _os_.unmarshal_int();
/*  73 */     this.endMinute = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.common.confbean.STimeLimitCommonCfg.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.common.confbean.STimeLimitCommonCfg"))
/*     */         {
/*     */ 
/*  95 */           STimeLimitCommonCfg obj = new STimeLimitCommonCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, STimeLimitCommonCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.common.confbean.STimeLimitCommonCfg.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.common.confbean.STimeLimitCommonCfg"))
/*     */         {
/*     */ 
/* 124 */           STimeLimitCommonCfg obj = new STimeLimitCommonCfg();
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
/* 140 */     String path = dir + "mzm.gsp.common.confbean.STimeLimitCommonCfg.bny";
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
/* 167 */           STimeLimitCommonCfg _v_ = new STimeLimitCommonCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, STimeLimitCommonCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.common.confbean.STimeLimitCommonCfg.bny";
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
/* 214 */           STimeLimitCommonCfg _v_ = new STimeLimitCommonCfg();
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
/*     */   public static STimeLimitCommonCfg getOld(int key)
/*     */   {
/* 235 */     return (STimeLimitCommonCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STimeLimitCommonCfg get(int key)
/*     */   {
/* 240 */     return (STimeLimitCommonCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STimeLimitCommonCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STimeLimitCommonCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STimeLimitCommonCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\confbean\STimeLimitCommonCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */