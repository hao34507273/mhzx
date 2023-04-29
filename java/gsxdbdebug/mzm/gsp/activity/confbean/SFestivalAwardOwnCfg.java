/*     */ package mzm.gsp.activity.confbean;
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
/*     */ public class SFestivalAwardOwnCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFestivalAwardOwnCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFestivalAwardOwnCfg> all = null;
/*     */   
/*     */   public int anyone;
/*  19 */   public java.util.ArrayList<FestivalAwardOwnCfg> festivalAwardOwnCfgs = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.anyone = Integer.valueOf(rootElement.attributeValue("anyone")).intValue();
/*     */     
/*  25 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "festivalAwardOwnCfgs");
/*  26 */     if (collectionElement == null)
/*     */     {
/*  28 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  31 */     List<?> _nodeList = collectionElement.elements();
/*  32 */     int _len = _nodeList.size();
/*  33 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  35 */       Element elem = (Element)_nodeList.get(i);
/*  36 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.FestivalAwardOwnCfg"))
/*     */       {
/*     */         FestivalAwardOwnCfg _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  43 */           _v_ = new FestivalAwardOwnCfg();
/*  44 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  51 */         this.festivalAwardOwnCfgs.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  58 */     _os_.marshal(this.anyone);
/*  59 */     _os_.compact_uint32(this.festivalAwardOwnCfgs.size());
/*  60 */     for (FestivalAwardOwnCfg _v_ : this.festivalAwardOwnCfgs)
/*     */     {
/*  62 */       _os_.marshal(_v_);
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.anyone = _os_.unmarshal_int();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  73 */       FestivalAwardOwnCfg _v_ = new FestivalAwardOwnCfg();
/*  74 */       _v_.unmarshal(_os_);
/*  75 */       this.festivalAwardOwnCfgs.add(_v_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  82 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardOwnCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  86 */       all = new java.util.HashMap();
/*  87 */       SAXReader reader = new SAXReader();
/*  88 */       org.dom4j.Document doc = reader.read(new File(path));
/*  89 */       Element root = doc.getRootElement();
/*  90 */       List<?> nodeList = root.elements();
/*  91 */       int len = nodeList.size();
/*  92 */       for (int i = 0; i < len; i++)
/*     */       {
/*  94 */         Element elem = (Element)nodeList.get(i);
/*  95 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SFestivalAwardOwnCfg"))
/*     */         {
/*     */ 
/*  98 */           SFestivalAwardOwnCfg obj = new SFestivalAwardOwnCfg();
/*  99 */           obj.loadFromXml(elem);
/* 100 */           if (all.put(Integer.valueOf(obj.anyone), obj) != null) {
/* 101 */             throw new RuntimeException("duplicate key : " + obj.anyone);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 106 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFestivalAwardOwnCfg> all)
/*     */   {
/* 112 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardOwnCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 116 */       SAXReader reader = new SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       List<?> nodeList = root.elements();
/* 120 */       int len = nodeList.size();
/* 121 */       for (int i = 0; i < len; i++)
/*     */       {
/* 123 */         Element elem = (Element)nodeList.get(i);
/* 124 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SFestivalAwardOwnCfg"))
/*     */         {
/*     */ 
/* 127 */           SFestivalAwardOwnCfg obj = new SFestivalAwardOwnCfg();
/* 128 */           obj.loadFromXml(elem);
/* 129 */           if (all.put(Integer.valueOf(obj.anyone), obj) != null) {
/* 130 */             throw new RuntimeException("duplicate key : " + obj.anyone);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 141 */     all = new java.util.HashMap();
/*     */     
/* 143 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardOwnCfg.bny";
/*     */     try
/*     */     {
/* 146 */       File file = new File(path);
/* 147 */       if (file.exists())
/*     */       {
/* 149 */         byte[] bytes = new byte['Ѐ'];
/* 150 */         FileInputStream fis = new FileInputStream(file);
/* 151 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 152 */         int len = 0;
/* 153 */         while ((len = fis.read(bytes)) > 0)
/* 154 */           baos.write(bytes, 0, len);
/* 155 */         fis.close();
/* 156 */         bytes = baos.toByteArray();
/* 157 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 158 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 160 */           _os_.unmarshal_int();
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/*     */         }
/* 164 */         _os_.unmarshal_int();
/* 165 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 168 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 170 */           SFestivalAwardOwnCfg _v_ = new SFestivalAwardOwnCfg();
/* 171 */           _v_.unmarshal(_os_);
/* 172 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 173 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 178 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 183 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFestivalAwardOwnCfg> all)
/*     */   {
/* 190 */     String path = dir + "mzm.gsp.activity.confbean.SFestivalAwardOwnCfg.bny";
/*     */     try
/*     */     {
/* 193 */       File file = new File(path);
/* 194 */       if (file.exists())
/*     */       {
/* 196 */         byte[] bytes = new byte['Ѐ'];
/* 197 */         FileInputStream fis = new FileInputStream(file);
/* 198 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 199 */         int len = 0;
/* 200 */         while ((len = fis.read(bytes)) > 0)
/* 201 */           baos.write(bytes, 0, len);
/* 202 */         fis.close();
/* 203 */         bytes = baos.toByteArray();
/* 204 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 207 */           _os_.unmarshal_int();
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/*     */         }
/* 211 */         _os_.unmarshal_int();
/* 212 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 215 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 217 */           SFestivalAwardOwnCfg _v_ = new SFestivalAwardOwnCfg();
/* 218 */           _v_.unmarshal(_os_);
/* 219 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 220 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 225 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 230 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFestivalAwardOwnCfg getOld(int key)
/*     */   {
/* 238 */     return (SFestivalAwardOwnCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFestivalAwardOwnCfg get(int key)
/*     */   {
/* 243 */     return (SFestivalAwardOwnCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFestivalAwardOwnCfg> getOldAll()
/*     */   {
/* 248 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFestivalAwardOwnCfg> getAll()
/*     */   {
/* 253 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFestivalAwardOwnCfg> newAll)
/*     */   {
/* 258 */     oldAll = all;
/* 259 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 264 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SFestivalAwardOwnCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */