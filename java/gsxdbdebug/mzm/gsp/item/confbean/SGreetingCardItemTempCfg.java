/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SGreetingCardItemTempCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGreetingCardItemTempCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGreetingCardItemTempCfg> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public ArrayList<String> resourcePaths = new ArrayList();
/*  20 */   public ArrayList<String> bgNames = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "resourcePaths");
/*  27 */     if (collectionElement == null)
/*     */     {
/*  29 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  32 */     List<?> _nodeList = collectionElement.elements();
/*  33 */     int _len = _nodeList.size();
/*  34 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  36 */       Element elem = (Element)_nodeList.get(i);
/*  37 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  44 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  51 */         this.resourcePaths.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  55 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "bgNames");
/*  56 */     if (collectionElement == null)
/*     */     {
/*  58 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  61 */     List<?> _nodeList = collectionElement.elements();
/*  62 */     int _len = _nodeList.size();
/*  63 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  65 */       Element elem = (Element)_nodeList.get(i);
/*  66 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  73 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         this.bgNames.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  87 */     _os_.marshal(this.id);
/*  88 */     _os_.compact_uint32(this.resourcePaths.size());
/*  89 */     for (String _v_ : this.resourcePaths)
/*     */     {
/*  91 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  93 */     _os_.compact_uint32(this.bgNames.size());
/*  94 */     for (String _v_ : this.bgNames)
/*     */     {
/*  96 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 103 */     this.id = _os_.unmarshal_int();
/* 104 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 107 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 108 */       this.resourcePaths.add(_v_);
/*     */     }
/* 110 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 113 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 114 */       this.bgNames.add(_v_);
/*     */     }
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.item.confbean.SGreetingCardItemTempCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       all = new java.util.HashMap();
/* 126 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 127 */       org.dom4j.Document doc = reader.read(new File(path));
/* 128 */       Element root = doc.getRootElement();
/* 129 */       List<?> nodeList = root.elements();
/* 130 */       int len = nodeList.size();
/* 131 */       for (int i = 0; i < len; i++)
/*     */       {
/* 133 */         Element elem = (Element)nodeList.get(i);
/* 134 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SGreetingCardItemTempCfg"))
/*     */         {
/*     */ 
/* 137 */           SGreetingCardItemTempCfg obj = new SGreetingCardItemTempCfg();
/* 138 */           obj.loadFromXml(elem);
/* 139 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 145 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGreetingCardItemTempCfg> all)
/*     */   {
/* 151 */     String path = dir + "mzm.gsp.item.confbean.SGreetingCardItemTempCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 155 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 156 */       org.dom4j.Document doc = reader.read(new File(path));
/* 157 */       Element root = doc.getRootElement();
/* 158 */       List<?> nodeList = root.elements();
/* 159 */       int len = nodeList.size();
/* 160 */       for (int i = 0; i < len; i++)
/*     */       {
/* 162 */         Element elem = (Element)nodeList.get(i);
/* 163 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SGreetingCardItemTempCfg"))
/*     */         {
/*     */ 
/* 166 */           SGreetingCardItemTempCfg obj = new SGreetingCardItemTempCfg();
/* 167 */           obj.loadFromXml(elem);
/* 168 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 169 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 174 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 180 */     all = new java.util.HashMap();
/*     */     
/* 182 */     String path = dir + "mzm.gsp.item.confbean.SGreetingCardItemTempCfg.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 199 */           _os_.unmarshal_int();
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/*     */         }
/* 203 */         _os_.unmarshal_int();
/* 204 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 207 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 209 */           SGreetingCardItemTempCfg _v_ = new SGreetingCardItemTempCfg();
/* 210 */           _v_.unmarshal(_os_);
/* 211 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 212 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 217 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 222 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGreetingCardItemTempCfg> all)
/*     */   {
/* 229 */     String path = dir + "mzm.gsp.item.confbean.SGreetingCardItemTempCfg.bny";
/*     */     try
/*     */     {
/* 232 */       File file = new File(path);
/* 233 */       if (file.exists())
/*     */       {
/* 235 */         byte[] bytes = new byte['Ѐ'];
/* 236 */         FileInputStream fis = new FileInputStream(file);
/* 237 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 238 */         int len = 0;
/* 239 */         while ((len = fis.read(bytes)) > 0)
/* 240 */           baos.write(bytes, 0, len);
/* 241 */         fis.close();
/* 242 */         bytes = baos.toByteArray();
/* 243 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 246 */           _os_.unmarshal_int();
/* 247 */           _os_.unmarshal_int();
/* 248 */           _os_.unmarshal_int();
/*     */         }
/* 250 */         _os_.unmarshal_int();
/* 251 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 254 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 256 */           SGreetingCardItemTempCfg _v_ = new SGreetingCardItemTempCfg();
/* 257 */           _v_.unmarshal(_os_);
/* 258 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 259 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 264 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 269 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGreetingCardItemTempCfg getOld(int key)
/*     */   {
/* 277 */     return (SGreetingCardItemTempCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGreetingCardItemTempCfg get(int key)
/*     */   {
/* 282 */     return (SGreetingCardItemTempCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGreetingCardItemTempCfg> getOldAll()
/*     */   {
/* 287 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGreetingCardItemTempCfg> getAll()
/*     */   {
/* 292 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGreetingCardItemTempCfg> newAll)
/*     */   {
/* 297 */     oldAll = all;
/* 298 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 303 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SGreetingCardItemTempCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */