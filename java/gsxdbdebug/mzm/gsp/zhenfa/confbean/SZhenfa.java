/*     */ package mzm.gsp.zhenfa.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SZhenfa implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SZhenfa> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SZhenfa> all = null;
/*     */   
/*     */   public int id;
/*     */   public String zhenfaName;
/*     */   public int icon;
/*     */   public int backIcon;
/*  22 */   public ArrayList<PosAttriBean> posAttriList = new ArrayList();
/*  23 */   public ArrayList<RestrictZhenfaBean> restrictZhenfaList = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.zhenfaName = rootElement.attributeValue("zhenfaName");
/*  29 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  30 */     this.backIcon = Integer.valueOf(rootElement.attributeValue("backIcon")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "posAttriList");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.zhenfa.confbean.PosAttriBean"))
/*     */       {
/*     */         PosAttriBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = new PosAttriBean();
/*  51 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.posAttriList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "restrictZhenfaList");
/*  63 */     if (collectionElement == null)
/*     */     {
/*  65 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  68 */     List<?> _nodeList = collectionElement.elements();
/*  69 */     int _len = _nodeList.size();
/*  70 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  72 */       Element elem = (Element)_nodeList.get(i);
/*  73 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.zhenfa.confbean.RestrictZhenfaBean"))
/*     */       {
/*     */         RestrictZhenfaBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  80 */           _v_ = new RestrictZhenfaBean();
/*  81 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  88 */         this.restrictZhenfaList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  95 */     _os_.marshal(this.id);
/*  96 */     _os_.marshal(this.zhenfaName, "UTF-8");
/*  97 */     _os_.marshal(this.icon);
/*  98 */     _os_.marshal(this.backIcon);
/*  99 */     _os_.compact_uint32(this.posAttriList.size());
/* 100 */     for (PosAttriBean _v_ : this.posAttriList)
/*     */     {
/* 102 */       _os_.marshal(_v_);
/*     */     }
/* 104 */     _os_.compact_uint32(this.restrictZhenfaList.size());
/* 105 */     for (RestrictZhenfaBean _v_ : this.restrictZhenfaList)
/*     */     {
/* 107 */       _os_.marshal(_v_);
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 114 */     this.id = _os_.unmarshal_int();
/* 115 */     this.zhenfaName = _os_.unmarshal_String("UTF-8");
/* 116 */     this.icon = _os_.unmarshal_int();
/* 117 */     this.backIcon = _os_.unmarshal_int();
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 121 */       PosAttriBean _v_ = new PosAttriBean();
/* 122 */       _v_.unmarshal(_os_);
/* 123 */       this.posAttriList.add(_v_);
/*     */     }
/* 125 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 128 */       RestrictZhenfaBean _v_ = new RestrictZhenfaBean();
/* 129 */       _v_.unmarshal(_os_);
/* 130 */       this.restrictZhenfaList.add(_v_);
/*     */     }
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfa.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       all = new java.util.HashMap();
/* 142 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       List<?> nodeList = root.elements();
/* 146 */       int len = nodeList.size();
/* 147 */       for (int i = 0; i < len; i++)
/*     */       {
/* 149 */         Element elem = (Element)nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.zhenfa.confbean.SZhenfa"))
/*     */         {
/*     */ 
/* 153 */           SZhenfa obj = new SZhenfa();
/* 154 */           obj.loadFromXml(elem);
/* 155 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 156 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SZhenfa> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfa.xml";
/*     */     
/*     */     try
/*     */     {
/* 171 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.zhenfa.confbean.SZhenfa"))
/*     */         {
/*     */ 
/* 182 */           SZhenfa obj = new SZhenfa();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 196 */     all = new java.util.HashMap();
/*     */     
/* 198 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfa.bny";
/*     */     try
/*     */     {
/* 201 */       File file = new File(path);
/* 202 */       if (file.exists())
/*     */       {
/* 204 */         byte[] bytes = new byte['Ѐ'];
/* 205 */         FileInputStream fis = new FileInputStream(file);
/* 206 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 207 */         int len = 0;
/* 208 */         while ((len = fis.read(bytes)) > 0)
/* 209 */           baos.write(bytes, 0, len);
/* 210 */         fis.close();
/* 211 */         bytes = baos.toByteArray();
/* 212 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 215 */           _os_.unmarshal_int();
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/*     */         }
/* 219 */         _os_.unmarshal_int();
/* 220 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 223 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 225 */           SZhenfa _v_ = new SZhenfa();
/* 226 */           _v_.unmarshal(_os_);
/* 227 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 228 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 233 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 238 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SZhenfa> all)
/*     */   {
/* 245 */     String path = dir + "mzm.gsp.zhenfa.confbean.SZhenfa.bny";
/*     */     try
/*     */     {
/* 248 */       File file = new File(path);
/* 249 */       if (file.exists())
/*     */       {
/* 251 */         byte[] bytes = new byte['Ѐ'];
/* 252 */         FileInputStream fis = new FileInputStream(file);
/* 253 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 254 */         int len = 0;
/* 255 */         while ((len = fis.read(bytes)) > 0)
/* 256 */           baos.write(bytes, 0, len);
/* 257 */         fis.close();
/* 258 */         bytes = baos.toByteArray();
/* 259 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 260 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 262 */           _os_.unmarshal_int();
/* 263 */           _os_.unmarshal_int();
/* 264 */           _os_.unmarshal_int();
/*     */         }
/* 266 */         _os_.unmarshal_int();
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 270 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 272 */           SZhenfa _v_ = new SZhenfa();
/* 273 */           _v_.unmarshal(_os_);
/* 274 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 275 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 280 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 285 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SZhenfa getOld(int key)
/*     */   {
/* 293 */     return (SZhenfa)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SZhenfa get(int key)
/*     */   {
/* 298 */     return (SZhenfa)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SZhenfa> getOldAll()
/*     */   {
/* 303 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SZhenfa> getAll()
/*     */   {
/* 308 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SZhenfa> newAll)
/*     */   {
/* 313 */     oldAll = all;
/* 314 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 319 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\confbean\SZhenfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */