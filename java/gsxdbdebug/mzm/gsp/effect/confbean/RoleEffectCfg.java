/*     */ package mzm.gsp.effect.confbean;
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
/*     */ public class RoleEffectCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, RoleEffectCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, RoleEffectCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String effectname;
/*     */   public String classname;
/*     */   public String description;
/*     */   public int baseProp;
/*     */   public int fightProp;
/*     */   public int effectType;
/*     */   public int fenmu;
/*  26 */   public java.util.ArrayList<String> parameters = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.effectname = rootElement.attributeValue("effectname");
/*  32 */     this.classname = rootElement.attributeValue("classname");
/*  33 */     this.description = rootElement.attributeValue("description");
/*  34 */     this.baseProp = Integer.valueOf(rootElement.attributeValue("baseProp")).intValue();
/*  35 */     this.fightProp = Integer.valueOf(rootElement.attributeValue("fightProp")).intValue();
/*  36 */     this.effectType = Integer.valueOf(rootElement.attributeValue("effectType")).intValue();
/*  37 */     this.fenmu = Integer.valueOf(rootElement.attributeValue("fenmu")).intValue();
/*     */     
/*  39 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "parameters");
/*  40 */     if (collectionElement == null)
/*     */     {
/*  42 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  45 */     List<?> _nodeList = collectionElement.elements();
/*  46 */     int _len = _nodeList.size();
/*  47 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  49 */       Element elem = (Element)_nodeList.get(i);
/*  50 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  57 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  64 */         this.parameters.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _os_.marshal(this.id);
/*  72 */     _os_.marshal(this.effectname, "UTF-8");
/*  73 */     _os_.marshal(this.classname, "UTF-8");
/*  74 */     _os_.marshal(this.description, "UTF-8");
/*  75 */     _os_.marshal(this.baseProp);
/*  76 */     _os_.marshal(this.fightProp);
/*  77 */     _os_.marshal(this.effectType);
/*  78 */     _os_.marshal(this.fenmu);
/*  79 */     _os_.compact_uint32(this.parameters.size());
/*  80 */     for (String _v_ : this.parameters)
/*     */     {
/*  82 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     this.id = _os_.unmarshal_int();
/*  90 */     this.effectname = _os_.unmarshal_String("UTF-8");
/*  91 */     this.classname = _os_.unmarshal_String("UTF-8");
/*  92 */     this.description = _os_.unmarshal_String("UTF-8");
/*  93 */     this.baseProp = _os_.unmarshal_int();
/*  94 */     this.fightProp = _os_.unmarshal_int();
/*  95 */     this.effectType = _os_.unmarshal_int();
/*  96 */     this.fenmu = _os_.unmarshal_int();
/*  97 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 100 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 101 */       this.parameters.add(_v_);
/*     */     }
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 108 */     String path = dir + "mzm.gsp.effect.confbean.RoleEffectCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 112 */       all = new java.util.HashMap();
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.effect.confbean.RoleEffectCfg"))
/*     */         {
/*     */ 
/* 124 */           RoleEffectCfg obj = new RoleEffectCfg();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, RoleEffectCfg> all)
/*     */   {
/* 138 */     String path = dir + "mzm.gsp.effect.confbean.RoleEffectCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 142 */       SAXReader reader = new SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       List<?> nodeList = root.elements();
/* 146 */       int len = nodeList.size();
/* 147 */       for (int i = 0; i < len; i++)
/*     */       {
/* 149 */         Element elem = (Element)nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.effect.confbean.RoleEffectCfg"))
/*     */         {
/*     */ 
/* 153 */           RoleEffectCfg obj = new RoleEffectCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 167 */     all = new java.util.HashMap();
/*     */     
/* 169 */     String path = dir + "mzm.gsp.effect.confbean.RoleEffectCfg.bny";
/*     */     try
/*     */     {
/* 172 */       File file = new File(path);
/* 173 */       if (file.exists())
/*     */       {
/* 175 */         byte[] bytes = new byte['Ѐ'];
/* 176 */         FileInputStream fis = new FileInputStream(file);
/* 177 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 178 */         int len = 0;
/* 179 */         while ((len = fis.read(bytes)) > 0)
/* 180 */           baos.write(bytes, 0, len);
/* 181 */         fis.close();
/* 182 */         bytes = baos.toByteArray();
/* 183 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 184 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/* 188 */           _os_.unmarshal_int();
/*     */         }
/* 190 */         _os_.unmarshal_int();
/* 191 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 194 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 196 */           RoleEffectCfg _v_ = new RoleEffectCfg();
/* 197 */           _v_.unmarshal(_os_);
/* 198 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 199 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 204 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 209 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, RoleEffectCfg> all)
/*     */   {
/* 216 */     String path = dir + "mzm.gsp.effect.confbean.RoleEffectCfg.bny";
/*     */     try
/*     */     {
/* 219 */       File file = new File(path);
/* 220 */       if (file.exists())
/*     */       {
/* 222 */         byte[] bytes = new byte['Ѐ'];
/* 223 */         FileInputStream fis = new FileInputStream(file);
/* 224 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 225 */         int len = 0;
/* 226 */         while ((len = fis.read(bytes)) > 0)
/* 227 */           baos.write(bytes, 0, len);
/* 228 */         fis.close();
/* 229 */         bytes = baos.toByteArray();
/* 230 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 231 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/* 235 */           _os_.unmarshal_int();
/*     */         }
/* 237 */         _os_.unmarshal_int();
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 241 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 243 */           RoleEffectCfg _v_ = new RoleEffectCfg();
/* 244 */           _v_.unmarshal(_os_);
/* 245 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 246 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 251 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static RoleEffectCfg getOld(int key)
/*     */   {
/* 264 */     return (RoleEffectCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static RoleEffectCfg get(int key)
/*     */   {
/* 269 */     return (RoleEffectCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, RoleEffectCfg> getOldAll()
/*     */   {
/* 274 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, RoleEffectCfg> getAll()
/*     */   {
/* 279 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, RoleEffectCfg> newAll)
/*     */   {
/* 284 */     oldAll = all;
/* 285 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 290 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\confbean\RoleEffectCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */