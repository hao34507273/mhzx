/*     */ package mzm.gsp.guide.confbean;
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
/*     */ public class SCreateHomeGuide implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCreateHomeGuide> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCreateHomeGuide> all = null;
/*     */   
/*     */   public int guideid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.guideid = Integer.valueOf(rootElement.attributeValue("guideid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  27 */     _os_.marshal(this.guideid);
/*  28 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  33 */     this.guideid = _os_.unmarshal_int();
/*  34 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  39 */     String path = dir + "mzm.gsp.guide.confbean.SCreateHomeGuide.xml";
/*     */     
/*     */     try
/*     */     {
/*  43 */       all = new java.util.HashMap();
/*  44 */       SAXReader reader = new SAXReader();
/*  45 */       org.dom4j.Document doc = reader.read(new File(path));
/*  46 */       Element root = doc.getRootElement();
/*  47 */       List<?> nodeList = root.elements();
/*  48 */       int len = nodeList.size();
/*  49 */       for (int i = 0; i < len; i++)
/*     */       {
/*  51 */         Element elem = (Element)nodeList.get(i);
/*  52 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.guide.confbean.SCreateHomeGuide"))
/*     */         {
/*     */ 
/*  55 */           SCreateHomeGuide obj = new SCreateHomeGuide();
/*  56 */           obj.loadFromXml(elem);
/*  57 */           if (all.put(Integer.valueOf(obj.guideid), obj) != null) {
/*  58 */             throw new RuntimeException("duplicate key : " + obj.guideid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  63 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCreateHomeGuide> all)
/*     */   {
/*  69 */     String path = dir + "mzm.gsp.guide.confbean.SCreateHomeGuide.xml";
/*     */     
/*     */     try
/*     */     {
/*  73 */       SAXReader reader = new SAXReader();
/*  74 */       org.dom4j.Document doc = reader.read(new File(path));
/*  75 */       Element root = doc.getRootElement();
/*  76 */       List<?> nodeList = root.elements();
/*  77 */       int len = nodeList.size();
/*  78 */       for (int i = 0; i < len; i++)
/*     */       {
/*  80 */         Element elem = (Element)nodeList.get(i);
/*  81 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.guide.confbean.SCreateHomeGuide"))
/*     */         {
/*     */ 
/*  84 */           SCreateHomeGuide obj = new SCreateHomeGuide();
/*  85 */           obj.loadFromXml(elem);
/*  86 */           if (all.put(Integer.valueOf(obj.guideid), obj) != null) {
/*  87 */             throw new RuntimeException("duplicate key : " + obj.guideid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/*  98 */     all = new java.util.HashMap();
/*     */     
/* 100 */     String path = dir + "mzm.gsp.guide.confbean.SCreateHomeGuide.bny";
/*     */     try
/*     */     {
/* 103 */       File file = new File(path);
/* 104 */       if (file.exists())
/*     */       {
/* 106 */         byte[] bytes = new byte['Ѐ'];
/* 107 */         FileInputStream fis = new FileInputStream(file);
/* 108 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 109 */         int len = 0;
/* 110 */         while ((len = fis.read(bytes)) > 0)
/* 111 */           baos.write(bytes, 0, len);
/* 112 */         fis.close();
/* 113 */         bytes = baos.toByteArray();
/* 114 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 115 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 117 */           _os_.unmarshal_int();
/* 118 */           _os_.unmarshal_int();
/* 119 */           _os_.unmarshal_int();
/*     */         }
/* 121 */         _os_.unmarshal_int();
/* 122 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 125 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 127 */           SCreateHomeGuide _v_ = new SCreateHomeGuide();
/* 128 */           _v_.unmarshal(_os_);
/* 129 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 130 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 135 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCreateHomeGuide> all)
/*     */   {
/* 147 */     String path = dir + "mzm.gsp.guide.confbean.SCreateHomeGuide.bny";
/*     */     try
/*     */     {
/* 150 */       File file = new File(path);
/* 151 */       if (file.exists())
/*     */       {
/* 153 */         byte[] bytes = new byte['Ѐ'];
/* 154 */         FileInputStream fis = new FileInputStream(file);
/* 155 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 156 */         int len = 0;
/* 157 */         while ((len = fis.read(bytes)) > 0)
/* 158 */           baos.write(bytes, 0, len);
/* 159 */         fis.close();
/* 160 */         bytes = baos.toByteArray();
/* 161 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 164 */           _os_.unmarshal_int();
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/*     */         }
/* 168 */         _os_.unmarshal_int();
/* 169 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 172 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 174 */           SCreateHomeGuide _v_ = new SCreateHomeGuide();
/* 175 */           _v_.unmarshal(_os_);
/* 176 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 182 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 187 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCreateHomeGuide getOld(int key)
/*     */   {
/* 195 */     return (SCreateHomeGuide)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCreateHomeGuide get(int key)
/*     */   {
/* 200 */     return (SCreateHomeGuide)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCreateHomeGuide> getOldAll()
/*     */   {
/* 205 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCreateHomeGuide> getAll()
/*     */   {
/* 210 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCreateHomeGuide> newAll)
/*     */   {
/* 215 */     oldAll = all;
/* 216 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 221 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\confbean\SCreateHomeGuide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */