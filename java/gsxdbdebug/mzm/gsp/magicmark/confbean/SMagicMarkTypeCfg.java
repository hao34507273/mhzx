/*     */ package mzm.gsp.magicmark.confbean;
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
/*     */ public class SMagicMarkTypeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMagicMarkTypeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMagicMarkTypeCfg> all = null;
/*     */   
/*     */   public int magicMarkType;
/*     */   public String magicMarkName;
/*     */   public int magicMarkModelid;
/*     */   public int iconid;
/*  22 */   public ArrayList<Integer> passiveSkillList = new ArrayList();
/*  23 */   public ArrayList<Integer> effectSkillList = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.magicMarkType = Integer.valueOf(rootElement.attributeValue("magicMarkType")).intValue();
/*  28 */     this.magicMarkName = rootElement.attributeValue("magicMarkName");
/*  29 */     this.magicMarkModelid = Integer.valueOf(rootElement.attributeValue("magicMarkModelid")).intValue();
/*  30 */     this.iconid = Integer.valueOf(rootElement.attributeValue("iconid")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "passiveSkillList");
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
/*  43 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  57 */         this.passiveSkillList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  61 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectSkillList");
/*  62 */     if (collectionElement == null)
/*     */     {
/*  64 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  67 */     List<?> _nodeList = collectionElement.elements();
/*  68 */     int _len = _nodeList.size();
/*  69 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  71 */       Element elem = (Element)_nodeList.get(i);
/*  72 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  79 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  86 */         this.effectSkillList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  93 */     _os_.marshal(this.magicMarkType);
/*  94 */     _os_.marshal(this.magicMarkName, "UTF-8");
/*  95 */     _os_.marshal(this.magicMarkModelid);
/*  96 */     _os_.marshal(this.iconid);
/*  97 */     _os_.compact_uint32(this.passiveSkillList.size());
/*  98 */     for (Integer _v_ : this.passiveSkillList)
/*     */     {
/* 100 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 102 */     _os_.compact_uint32(this.effectSkillList.size());
/* 103 */     for (Integer _v_ : this.effectSkillList)
/*     */     {
/* 105 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 112 */     this.magicMarkType = _os_.unmarshal_int();
/* 113 */     this.magicMarkName = _os_.unmarshal_String("UTF-8");
/* 114 */     this.magicMarkModelid = _os_.unmarshal_int();
/* 115 */     this.iconid = _os_.unmarshal_int();
/* 116 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 119 */       int _v_ = _os_.unmarshal_int();
/* 120 */       this.passiveSkillList.add(Integer.valueOf(_v_));
/*     */     }
/* 122 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 125 */       int _v_ = _os_.unmarshal_int();
/* 126 */       this.effectSkillList.add(Integer.valueOf(_v_));
/*     */     }
/* 128 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       all = new java.util.HashMap();
/* 138 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 139 */       org.dom4j.Document doc = reader.read(new File(path));
/* 140 */       Element root = doc.getRootElement();
/* 141 */       List<?> nodeList = root.elements();
/* 142 */       int len = nodeList.size();
/* 143 */       for (int i = 0; i < len; i++)
/*     */       {
/* 145 */         Element elem = (Element)nodeList.get(i);
/* 146 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg"))
/*     */         {
/*     */ 
/* 149 */           SMagicMarkTypeCfg obj = new SMagicMarkTypeCfg();
/* 150 */           obj.loadFromXml(elem);
/* 151 */           if (all.put(Integer.valueOf(obj.magicMarkType), obj) != null) {
/* 152 */             throw new RuntimeException("duplicate key : " + obj.magicMarkType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 157 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMagicMarkTypeCfg> all)
/*     */   {
/* 163 */     String path = dir + "mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 167 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 168 */       org.dom4j.Document doc = reader.read(new File(path));
/* 169 */       Element root = doc.getRootElement();
/* 170 */       List<?> nodeList = root.elements();
/* 171 */       int len = nodeList.size();
/* 172 */       for (int i = 0; i < len; i++)
/*     */       {
/* 174 */         Element elem = (Element)nodeList.get(i);
/* 175 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg"))
/*     */         {
/*     */ 
/* 178 */           SMagicMarkTypeCfg obj = new SMagicMarkTypeCfg();
/* 179 */           obj.loadFromXml(elem);
/* 180 */           if (all.put(Integer.valueOf(obj.magicMarkType), obj) != null) {
/* 181 */             throw new RuntimeException("duplicate key : " + obj.magicMarkType);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 192 */     all = new java.util.HashMap();
/*     */     
/* 194 */     String path = dir + "mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 211 */           _os_.unmarshal_int();
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/*     */         }
/* 215 */         _os_.unmarshal_int();
/* 216 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 219 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 221 */           SMagicMarkTypeCfg _v_ = new SMagicMarkTypeCfg();
/* 222 */           _v_.unmarshal(_os_);
/* 223 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 224 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 229 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 234 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMagicMarkTypeCfg> all)
/*     */   {
/* 241 */     String path = dir + "mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg.bny";
/*     */     try
/*     */     {
/* 244 */       File file = new File(path);
/* 245 */       if (file.exists())
/*     */       {
/* 247 */         byte[] bytes = new byte['Ѐ'];
/* 248 */         FileInputStream fis = new FileInputStream(file);
/* 249 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 250 */         int len = 0;
/* 251 */         while ((len = fis.read(bytes)) > 0)
/* 252 */           baos.write(bytes, 0, len);
/* 253 */         fis.close();
/* 254 */         bytes = baos.toByteArray();
/* 255 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 256 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 258 */           _os_.unmarshal_int();
/* 259 */           _os_.unmarshal_int();
/* 260 */           _os_.unmarshal_int();
/*     */         }
/* 262 */         _os_.unmarshal_int();
/* 263 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 266 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 268 */           SMagicMarkTypeCfg _v_ = new SMagicMarkTypeCfg();
/* 269 */           _v_.unmarshal(_os_);
/* 270 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 271 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 276 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 281 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMagicMarkTypeCfg getOld(int key)
/*     */   {
/* 289 */     return (SMagicMarkTypeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMagicMarkTypeCfg get(int key)
/*     */   {
/* 294 */     return (SMagicMarkTypeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMagicMarkTypeCfg> getOldAll()
/*     */   {
/* 299 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMagicMarkTypeCfg> getAll()
/*     */   {
/* 304 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMagicMarkTypeCfg> newAll)
/*     */   {
/* 309 */     oldAll = all;
/* 310 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 315 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\confbean\SMagicMarkTypeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */