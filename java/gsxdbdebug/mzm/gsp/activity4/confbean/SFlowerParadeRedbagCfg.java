/*     */ package mzm.gsp.activity4.confbean;
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
/*     */ public class SFlowerParadeRedbagCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFlowerParadeRedbagCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFlowerParadeRedbagCfg> all = null;
/*     */   
/*     */   public int groupId;
/*  19 */   public java.util.LinkedList<FlowerParadeTipBean> tipList = new java.util.LinkedList();
/*     */   public int countMin;
/*     */   public int countMax;
/*     */   public int countPercent;
/*     */   public int roleMaxGot;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.groupId = Integer.valueOf(rootElement.attributeValue("groupId")).intValue();
/*     */     
/*  29 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "tipList");
/*  30 */     if (collectionElement == null)
/*     */     {
/*  32 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  35 */     List<?> _nodeList = collectionElement.elements();
/*  36 */     int _len = _nodeList.size();
/*  37 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  39 */       Element elem = (Element)_nodeList.get(i);
/*  40 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.FlowerParadeTipBean"))
/*     */       {
/*     */         FlowerParadeTipBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  47 */           _v_ = new FlowerParadeTipBean();
/*  48 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  55 */         this.tipList.add(_v_);
/*     */       }
/*     */     }
/*  58 */     this.countMin = Integer.valueOf(rootElement.attributeValue("countMin")).intValue();
/*  59 */     this.countMax = Integer.valueOf(rootElement.attributeValue("countMax")).intValue();
/*  60 */     this.countPercent = Integer.valueOf(rootElement.attributeValue("countPercent")).intValue();
/*  61 */     this.roleMaxGot = Integer.valueOf(rootElement.attributeValue("roleMaxGot")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _os_.marshal(this.groupId);
/*  67 */     _os_.compact_uint32(this.tipList.size());
/*  68 */     for (FlowerParadeTipBean _v_ : this.tipList)
/*     */     {
/*  70 */       _os_.marshal(_v_);
/*     */     }
/*  72 */     _os_.marshal(this.countMin);
/*  73 */     _os_.marshal(this.countMax);
/*  74 */     _os_.marshal(this.countPercent);
/*  75 */     _os_.marshal(this.roleMaxGot);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.groupId = _os_.unmarshal_int();
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  85 */       FlowerParadeTipBean _v_ = new FlowerParadeTipBean();
/*  86 */       _v_.unmarshal(_os_);
/*  87 */       this.tipList.add(_v_);
/*     */     }
/*  89 */     this.countMin = _os_.unmarshal_int();
/*  90 */     this.countMax = _os_.unmarshal_int();
/*  91 */     this.countPercent = _os_.unmarshal_int();
/*  92 */     this.roleMaxGot = _os_.unmarshal_int();
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  98 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg.xml";
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
/* 111 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg"))
/*     */         {
/*     */ 
/* 114 */           SFlowerParadeRedbagCfg obj = new SFlowerParadeRedbagCfg();
/* 115 */           obj.loadFromXml(elem);
/* 116 */           if (all.put(Integer.valueOf(obj.groupId), obj) != null) {
/* 117 */             throw new RuntimeException("duplicate key : " + obj.groupId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 122 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFlowerParadeRedbagCfg> all)
/*     */   {
/* 128 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg.xml";
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
/* 140 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg"))
/*     */         {
/*     */ 
/* 143 */           SFlowerParadeRedbagCfg obj = new SFlowerParadeRedbagCfg();
/* 144 */           obj.loadFromXml(elem);
/* 145 */           if (all.put(Integer.valueOf(obj.groupId), obj) != null) {
/* 146 */             throw new RuntimeException("duplicate key : " + obj.groupId);
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
/* 159 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg.bny";
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
/* 186 */           SFlowerParadeRedbagCfg _v_ = new SFlowerParadeRedbagCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SFlowerParadeRedbagCfg> all)
/*     */   {
/* 206 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg.bny";
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
/* 233 */           SFlowerParadeRedbagCfg _v_ = new SFlowerParadeRedbagCfg();
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
/*     */   public static SFlowerParadeRedbagCfg getOld(int key)
/*     */   {
/* 254 */     return (SFlowerParadeRedbagCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFlowerParadeRedbagCfg get(int key)
/*     */   {
/* 259 */     return (SFlowerParadeRedbagCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFlowerParadeRedbagCfg> getOldAll()
/*     */   {
/* 264 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFlowerParadeRedbagCfg> getAll()
/*     */   {
/* 269 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFlowerParadeRedbagCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SFlowerParadeRedbagCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */