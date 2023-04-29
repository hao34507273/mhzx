/*     */ package mzm.gsp.skill.confbean;
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
/*     */ public class SEffectPlayCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SEffectPlayCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SEffectPlayCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int effectid;
/*     */   public int modelid;
/*     */   public int lastTime;
/*     */   public int attackEffect;
/*  23 */   public java.util.ArrayList<BeAttackedBean> beAttackedList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.effectid = Integer.valueOf(rootElement.attributeValue("effectid")).intValue();
/*  29 */     this.modelid = Integer.valueOf(rootElement.attributeValue("modelid")).intValue();
/*  30 */     this.lastTime = Integer.valueOf(rootElement.attributeValue("lastTime")).intValue();
/*  31 */     this.attackEffect = Integer.valueOf(rootElement.attributeValue("attackEffect")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "beAttackedList");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.BeAttackedBean"))
/*     */       {
/*     */         BeAttackedBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = new BeAttackedBean();
/*  52 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.beAttackedList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _os_.marshal(this.id);
/*  67 */     _os_.marshal(this.effectid);
/*  68 */     _os_.marshal(this.modelid);
/*  69 */     _os_.marshal(this.lastTime);
/*  70 */     _os_.marshal(this.attackEffect);
/*  71 */     _os_.compact_uint32(this.beAttackedList.size());
/*  72 */     for (BeAttackedBean _v_ : this.beAttackedList)
/*     */     {
/*  74 */       _os_.marshal(_v_);
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.id = _os_.unmarshal_int();
/*  82 */     this.effectid = _os_.unmarshal_int();
/*  83 */     this.modelid = _os_.unmarshal_int();
/*  84 */     this.lastTime = _os_.unmarshal_int();
/*  85 */     this.attackEffect = _os_.unmarshal_int();
/*  86 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  89 */       BeAttackedBean _v_ = new BeAttackedBean();
/*  90 */       _v_.unmarshal(_os_);
/*  91 */       this.beAttackedList.add(_v_);
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  98 */     String path = dir + "mzm.gsp.skill.confbean.SEffectPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 102 */       all = new java.util.HashMap();
/* 103 */       SAXReader reader = new SAXReader();
/* 104 */       org.dom4j.Document doc = reader.read(new File(path));
/* 105 */       Element root = doc.getRootElement();
/* 106 */       List<?> nodeList = root.elements();
/* 107 */       int len = nodeList.size();
/* 108 */       for (int i = 0; i < len; i++)
/*     */       {
/* 110 */         Element elem = (Element)nodeList.get(i);
/* 111 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SEffectPlayCfg"))
/*     */         {
/*     */ 
/* 114 */           SEffectPlayCfg obj = new SEffectPlayCfg();
/* 115 */           obj.loadFromXml(elem);
/* 116 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 117 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 122 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SEffectPlayCfg> all)
/*     */   {
/* 128 */     String path = dir + "mzm.gsp.skill.confbean.SEffectPlayCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 132 */       SAXReader reader = new SAXReader();
/* 133 */       org.dom4j.Document doc = reader.read(new File(path));
/* 134 */       Element root = doc.getRootElement();
/* 135 */       List<?> nodeList = root.elements();
/* 136 */       int len = nodeList.size();
/* 137 */       for (int i = 0; i < len; i++)
/*     */       {
/* 139 */         Element elem = (Element)nodeList.get(i);
/* 140 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SEffectPlayCfg"))
/*     */         {
/*     */ 
/* 143 */           SEffectPlayCfg obj = new SEffectPlayCfg();
/* 144 */           obj.loadFromXml(elem);
/* 145 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 146 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 151 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 157 */     all = new java.util.HashMap();
/*     */     
/* 159 */     String path = dir + "mzm.gsp.skill.confbean.SEffectPlayCfg.bny";
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
/* 186 */           SEffectPlayCfg _v_ = new SEffectPlayCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SEffectPlayCfg> all)
/*     */   {
/* 206 */     String path = dir + "mzm.gsp.skill.confbean.SEffectPlayCfg.bny";
/*     */     try
/*     */     {
/* 209 */       File file = new File(path);
/* 210 */       if (file.exists())
/*     */       {
/* 212 */         byte[] bytes = new byte['Ѐ'];
/* 213 */         FileInputStream fis = new FileInputStream(file);
/* 214 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 215 */         int len = 0;
/* 216 */         while ((len = fis.read(bytes)) > 0)
/* 217 */           baos.write(bytes, 0, len);
/* 218 */         fis.close();
/* 219 */         bytes = baos.toByteArray();
/* 220 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 223 */           _os_.unmarshal_int();
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/*     */         }
/* 227 */         _os_.unmarshal_int();
/* 228 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 231 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 233 */           SEffectPlayCfg _v_ = new SEffectPlayCfg();
/* 234 */           _v_.unmarshal(_os_);
/* 235 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 236 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 241 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SEffectPlayCfg getOld(int key)
/*     */   {
/* 254 */     return (SEffectPlayCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEffectPlayCfg get(int key)
/*     */   {
/* 259 */     return (SEffectPlayCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEffectPlayCfg> getOldAll()
/*     */   {
/* 264 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEffectPlayCfg> getAll()
/*     */   {
/* 269 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEffectPlayCfg> newAll)
/*     */   {
/* 274 */     oldAll = all;
/* 275 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 280 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SEffectPlayCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */