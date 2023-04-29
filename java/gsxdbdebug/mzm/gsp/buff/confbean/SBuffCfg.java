/*     */ package mzm.gsp.buff.confbean;
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
/*     */ public class SBuffCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBuffCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBuffCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public String name;
/*     */   public int bufStateType;
/*     */   public int mapEffect;
/*     */   public int offlineEffect;
/*     */   public int effectType;
/*     */   public int acculumaeCout;
/*     */   public int acculumaeCoutLimit;
/*     */   public int persistTime;
/*     */   public boolean canDelete;
/*  29 */   public java.util.ArrayList<BuffEffect> effectList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.templatename = rootElement.attributeValue("templatename");
/*  35 */     this.name = rootElement.attributeValue("name");
/*  36 */     this.bufStateType = Integer.valueOf(rootElement.attributeValue("bufStateType")).intValue();
/*  37 */     this.mapEffect = Integer.valueOf(rootElement.attributeValue("mapEffect")).intValue();
/*  38 */     this.offlineEffect = Integer.valueOf(rootElement.attributeValue("offlineEffect")).intValue();
/*  39 */     this.effectType = Integer.valueOf(rootElement.attributeValue("effectType")).intValue();
/*  40 */     this.acculumaeCout = Integer.valueOf(rootElement.attributeValue("acculumaeCout")).intValue();
/*  41 */     this.acculumaeCoutLimit = Integer.valueOf(rootElement.attributeValue("acculumaeCoutLimit")).intValue();
/*  42 */     this.persistTime = Integer.valueOf(rootElement.attributeValue("persistTime")).intValue();
/*  43 */     this.canDelete = Boolean.valueOf(rootElement.attributeValue("canDelete")).booleanValue();
/*     */     
/*  45 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectList");
/*  46 */     if (collectionElement == null)
/*     */     {
/*  48 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  51 */     List<?> _nodeList = collectionElement.elements();
/*  52 */     int _len = _nodeList.size();
/*  53 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  55 */       Element elem = (Element)_nodeList.get(i);
/*  56 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.buff.confbean.BuffEffect"))
/*     */       {
/*     */         BuffEffect _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  63 */           _v_ = new BuffEffect();
/*  64 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  71 */         this.effectList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _os_.marshal(this.id);
/*  79 */     _os_.marshal(this.templatename, "UTF-8");
/*  80 */     _os_.marshal(this.name, "UTF-8");
/*  81 */     _os_.marshal(this.bufStateType);
/*  82 */     _os_.marshal(this.mapEffect);
/*  83 */     _os_.marshal(this.offlineEffect);
/*  84 */     _os_.marshal(this.effectType);
/*  85 */     _os_.marshal(this.acculumaeCout);
/*  86 */     _os_.marshal(this.acculumaeCoutLimit);
/*  87 */     _os_.marshal(this.persistTime);
/*  88 */     _os_.marshal(this.canDelete);
/*  89 */     _os_.compact_uint32(this.effectList.size());
/*  90 */     for (BuffEffect _v_ : this.effectList)
/*     */     {
/*  92 */       _os_.marshal(_v_);
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     this.id = _os_.unmarshal_int();
/* 100 */     this.templatename = _os_.unmarshal_String("UTF-8");
/* 101 */     this.name = _os_.unmarshal_String("UTF-8");
/* 102 */     this.bufStateType = _os_.unmarshal_int();
/* 103 */     this.mapEffect = _os_.unmarshal_int();
/* 104 */     this.offlineEffect = _os_.unmarshal_int();
/* 105 */     this.effectType = _os_.unmarshal_int();
/* 106 */     this.acculumaeCout = _os_.unmarshal_int();
/* 107 */     this.acculumaeCoutLimit = _os_.unmarshal_int();
/* 108 */     this.persistTime = _os_.unmarshal_int();
/* 109 */     this.canDelete = _os_.unmarshal_boolean();
/* 110 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 113 */       BuffEffect _v_ = new BuffEffect();
/* 114 */       _v_.unmarshal(_os_);
/* 115 */       this.effectList.add(_v_);
/*     */     }
/* 117 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 122 */     String path = dir + "mzm.gsp.buff.confbean.SBuffCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 126 */       all = new java.util.HashMap();
/* 127 */       SAXReader reader = new SAXReader();
/* 128 */       org.dom4j.Document doc = reader.read(new File(path));
/* 129 */       Element root = doc.getRootElement();
/* 130 */       List<?> nodeList = root.elements();
/* 131 */       int len = nodeList.size();
/* 132 */       for (int i = 0; i < len; i++)
/*     */       {
/* 134 */         Element elem = (Element)nodeList.get(i);
/* 135 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.buff.confbean.SBuffCfg"))
/*     */         {
/*     */ 
/* 138 */           SBuffCfg obj = new SBuffCfg();
/* 139 */           obj.loadFromXml(elem);
/* 140 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 141 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 146 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBuffCfg> all)
/*     */   {
/* 152 */     String path = dir + "mzm.gsp.buff.confbean.SBuffCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 156 */       SAXReader reader = new SAXReader();
/* 157 */       org.dom4j.Document doc = reader.read(new File(path));
/* 158 */       Element root = doc.getRootElement();
/* 159 */       List<?> nodeList = root.elements();
/* 160 */       int len = nodeList.size();
/* 161 */       for (int i = 0; i < len; i++)
/*     */       {
/* 163 */         Element elem = (Element)nodeList.get(i);
/* 164 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.buff.confbean.SBuffCfg"))
/*     */         {
/*     */ 
/* 167 */           SBuffCfg obj = new SBuffCfg();
/* 168 */           obj.loadFromXml(elem);
/* 169 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 175 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 181 */     all = new java.util.HashMap();
/*     */     
/* 183 */     String path = dir + "mzm.gsp.buff.confbean.SBuffCfg.bny";
/*     */     try
/*     */     {
/* 186 */       File file = new File(path);
/* 187 */       if (file.exists())
/*     */       {
/* 189 */         byte[] bytes = new byte['Ѐ'];
/* 190 */         FileInputStream fis = new FileInputStream(file);
/* 191 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 192 */         int len = 0;
/* 193 */         while ((len = fis.read(bytes)) > 0)
/* 194 */           baos.write(bytes, 0, len);
/* 195 */         fis.close();
/* 196 */         bytes = baos.toByteArray();
/* 197 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/*     */         }
/* 204 */         _os_.unmarshal_int();
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 208 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 210 */           SBuffCfg _v_ = new SBuffCfg();
/* 211 */           _v_.unmarshal(_os_);
/* 212 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 213 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 218 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 223 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBuffCfg> all)
/*     */   {
/* 230 */     String path = dir + "mzm.gsp.buff.confbean.SBuffCfg.bny";
/*     */     try
/*     */     {
/* 233 */       File file = new File(path);
/* 234 */       if (file.exists())
/*     */       {
/* 236 */         byte[] bytes = new byte['Ѐ'];
/* 237 */         FileInputStream fis = new FileInputStream(file);
/* 238 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 239 */         int len = 0;
/* 240 */         while ((len = fis.read(bytes)) > 0)
/* 241 */           baos.write(bytes, 0, len);
/* 242 */         fis.close();
/* 243 */         bytes = baos.toByteArray();
/* 244 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 245 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 247 */           _os_.unmarshal_int();
/* 248 */           _os_.unmarshal_int();
/* 249 */           _os_.unmarshal_int();
/*     */         }
/* 251 */         _os_.unmarshal_int();
/* 252 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 255 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 257 */           SBuffCfg _v_ = new SBuffCfg();
/* 258 */           _v_.unmarshal(_os_);
/* 259 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 260 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 265 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 270 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBuffCfg getOld(int key)
/*     */   {
/* 278 */     return (SBuffCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBuffCfg get(int key)
/*     */   {
/* 283 */     return (SBuffCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBuffCfg> getOldAll()
/*     */   {
/* 288 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBuffCfg> getAll()
/*     */   {
/* 293 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBuffCfg> newAll)
/*     */   {
/* 298 */     oldAll = all;
/* 299 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 304 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\confbean\SBuffCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */