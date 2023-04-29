/*     */ package mzm.gsp.skill.confbean;
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
/*     */ public class SAction implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAction> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAction> all = null;
/*     */   
/*     */   public int id;
/*     */   public int modelid;
/*     */   public int actionid;
/*     */   public int duration;
/*  22 */   public ArrayList<BeAttackedBean> beAttackedList = new ArrayList();
/*  23 */   public ArrayList<Integer> effectlateTimes = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.modelid = Integer.valueOf(rootElement.attributeValue("modelid")).intValue();
/*  29 */     this.actionid = Integer.valueOf(rootElement.attributeValue("actionid")).intValue();
/*  30 */     this.duration = Integer.valueOf(rootElement.attributeValue("duration")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "beAttackedList");
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
/*  43 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.BeAttackedBean"))
/*     */       {
/*     */         BeAttackedBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = new BeAttackedBean();
/*  51 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.beAttackedList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectlateTimes");
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
/*  73 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  80 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  87 */         this.effectlateTimes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  94 */     _os_.marshal(this.id);
/*  95 */     _os_.marshal(this.modelid);
/*  96 */     _os_.marshal(this.actionid);
/*  97 */     _os_.marshal(this.duration);
/*  98 */     _os_.compact_uint32(this.beAttackedList.size());
/*  99 */     for (BeAttackedBean _v_ : this.beAttackedList)
/*     */     {
/* 101 */       _os_.marshal(_v_);
/*     */     }
/* 103 */     _os_.compact_uint32(this.effectlateTimes.size());
/* 104 */     for (Integer _v_ : this.effectlateTimes)
/*     */     {
/* 106 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 113 */     this.id = _os_.unmarshal_int();
/* 114 */     this.modelid = _os_.unmarshal_int();
/* 115 */     this.actionid = _os_.unmarshal_int();
/* 116 */     this.duration = _os_.unmarshal_int();
/* 117 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 120 */       BeAttackedBean _v_ = new BeAttackedBean();
/* 121 */       _v_.unmarshal(_os_);
/* 122 */       this.beAttackedList.add(_v_);
/*     */     }
/* 124 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 127 */       int _v_ = _os_.unmarshal_int();
/* 128 */       this.effectlateTimes.add(Integer.valueOf(_v_));
/*     */     }
/* 130 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 135 */     String path = dir + "mzm.gsp.skill.confbean.SAction.xml";
/*     */     
/*     */     try
/*     */     {
/* 139 */       all = new java.util.HashMap();
/* 140 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 141 */       org.dom4j.Document doc = reader.read(new File(path));
/* 142 */       Element root = doc.getRootElement();
/* 143 */       List<?> nodeList = root.elements();
/* 144 */       int len = nodeList.size();
/* 145 */       for (int i = 0; i < len; i++)
/*     */       {
/* 147 */         Element elem = (Element)nodeList.get(i);
/* 148 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SAction"))
/*     */         {
/*     */ 
/* 151 */           SAction obj = new SAction();
/* 152 */           obj.loadFromXml(elem);
/* 153 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAction> all)
/*     */   {
/* 165 */     String path = dir + "mzm.gsp.skill.confbean.SAction.xml";
/*     */     
/*     */     try
/*     */     {
/* 169 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 170 */       org.dom4j.Document doc = reader.read(new File(path));
/* 171 */       Element root = doc.getRootElement();
/* 172 */       List<?> nodeList = root.elements();
/* 173 */       int len = nodeList.size();
/* 174 */       for (int i = 0; i < len; i++)
/*     */       {
/* 176 */         Element elem = (Element)nodeList.get(i);
/* 177 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.SAction"))
/*     */         {
/*     */ 
/* 180 */           SAction obj = new SAction();
/* 181 */           obj.loadFromXml(elem);
/* 182 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 194 */     all = new java.util.HashMap();
/*     */     
/* 196 */     String path = dir + "mzm.gsp.skill.confbean.SAction.bny";
/*     */     try
/*     */     {
/* 199 */       File file = new File(path);
/* 200 */       if (file.exists())
/*     */       {
/* 202 */         byte[] bytes = new byte['Ѐ'];
/* 203 */         FileInputStream fis = new FileInputStream(file);
/* 204 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 205 */         int len = 0;
/* 206 */         while ((len = fis.read(bytes)) > 0)
/* 207 */           baos.write(bytes, 0, len);
/* 208 */         fis.close();
/* 209 */         bytes = baos.toByteArray();
/* 210 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 211 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/* 215 */           _os_.unmarshal_int();
/*     */         }
/* 217 */         _os_.unmarshal_int();
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 221 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 223 */           SAction _v_ = new SAction();
/* 224 */           _v_.unmarshal(_os_);
/* 225 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 231 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 236 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAction> all)
/*     */   {
/* 243 */     String path = dir + "mzm.gsp.skill.confbean.SAction.bny";
/*     */     try
/*     */     {
/* 246 */       File file = new File(path);
/* 247 */       if (file.exists())
/*     */       {
/* 249 */         byte[] bytes = new byte['Ѐ'];
/* 250 */         FileInputStream fis = new FileInputStream(file);
/* 251 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 252 */         int len = 0;
/* 253 */         while ((len = fis.read(bytes)) > 0)
/* 254 */           baos.write(bytes, 0, len);
/* 255 */         fis.close();
/* 256 */         bytes = baos.toByteArray();
/* 257 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 258 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 260 */           _os_.unmarshal_int();
/* 261 */           _os_.unmarshal_int();
/* 262 */           _os_.unmarshal_int();
/*     */         }
/* 264 */         _os_.unmarshal_int();
/* 265 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 268 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 270 */           SAction _v_ = new SAction();
/* 271 */           _v_.unmarshal(_os_);
/* 272 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 273 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 278 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 283 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAction getOld(int key)
/*     */   {
/* 291 */     return (SAction)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAction get(int key)
/*     */   {
/* 296 */     return (SAction)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAction> getOldAll()
/*     */   {
/* 301 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAction> getAll()
/*     */   {
/* 306 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAction> newAll)
/*     */   {
/* 311 */     oldAll = all;
/* 312 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 317 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\SAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */