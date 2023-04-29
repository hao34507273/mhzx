/*     */ package mzm.gsp.visiblemonsterfight.confbean;
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
/*     */ public class SDeamonTransferMapCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SDeamonTransferMapCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SDeamonTransferMapCfg> all = null;
/*     */   
/*     */   public int mapId;
/*     */   public int awardLevel;
/*     */   public int npcid;
/*     */   public int npcServiceid;
/*  22 */   public ArrayList<Integer> fightids = new ArrayList();
/*     */   public int skyNpcid;
/*     */   public int skyNpcServiceid;
/*  25 */   public ArrayList<Integer> skyFightids = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/*  30 */     this.awardLevel = Integer.valueOf(rootElement.attributeValue("awardLevel")).intValue();
/*  31 */     this.npcid = Integer.valueOf(rootElement.attributeValue("npcid")).intValue();
/*  32 */     this.npcServiceid = Integer.valueOf(rootElement.attributeValue("npcServiceid")).intValue();
/*     */     
/*  34 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "fightids");
/*  35 */     if (collectionElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> _nodeList = collectionElement.elements();
/*  41 */     int _len = _nodeList.size();
/*  42 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  44 */       Element elem = (Element)_nodeList.get(i);
/*  45 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  52 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.fightids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  62 */     this.skyNpcid = Integer.valueOf(rootElement.attributeValue("skyNpcid")).intValue();
/*  63 */     this.skyNpcServiceid = Integer.valueOf(rootElement.attributeValue("skyNpcServiceid")).intValue();
/*     */     
/*  65 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "skyFightids");
/*  66 */     if (collectionElement == null)
/*     */     {
/*  68 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  71 */     List<?> _nodeList = collectionElement.elements();
/*  72 */     int _len = _nodeList.size();
/*  73 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  75 */       Element elem = (Element)_nodeList.get(i);
/*  76 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  83 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  90 */         this.skyFightids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  97 */     _os_.marshal(this.mapId);
/*  98 */     _os_.marshal(this.awardLevel);
/*  99 */     _os_.marshal(this.npcid);
/* 100 */     _os_.marshal(this.npcServiceid);
/* 101 */     _os_.compact_uint32(this.fightids.size());
/* 102 */     for (Integer _v_ : this.fightids)
/*     */     {
/* 104 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 106 */     _os_.marshal(this.skyNpcid);
/* 107 */     _os_.marshal(this.skyNpcServiceid);
/* 108 */     _os_.compact_uint32(this.skyFightids.size());
/* 109 */     for (Integer _v_ : this.skyFightids)
/*     */     {
/* 111 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 118 */     this.mapId = _os_.unmarshal_int();
/* 119 */     this.awardLevel = _os_.unmarshal_int();
/* 120 */     this.npcid = _os_.unmarshal_int();
/* 121 */     this.npcServiceid = _os_.unmarshal_int();
/* 122 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 125 */       int _v_ = _os_.unmarshal_int();
/* 126 */       this.fightids.add(Integer.valueOf(_v_));
/*     */     }
/* 128 */     this.skyNpcid = _os_.unmarshal_int();
/* 129 */     this.skyNpcServiceid = _os_.unmarshal_int();
/* 130 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 133 */       int _v_ = _os_.unmarshal_int();
/* 134 */       this.skyFightids.add(Integer.valueOf(_v_));
/*     */     }
/* 136 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 141 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 145 */       all = new java.util.HashMap();
/* 146 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg"))
/*     */         {
/*     */ 
/* 157 */           SDeamonTransferMapCfg obj = new SDeamonTransferMapCfg();
/* 158 */           obj.loadFromXml(elem);
/* 159 */           if (all.put(Integer.valueOf(obj.mapId), obj) != null) {
/* 160 */             throw new RuntimeException("duplicate key : " + obj.mapId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDeamonTransferMapCfg> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 175 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 176 */       org.dom4j.Document doc = reader.read(new File(path));
/* 177 */       Element root = doc.getRootElement();
/* 178 */       List<?> nodeList = root.elements();
/* 179 */       int len = nodeList.size();
/* 180 */       for (int i = 0; i < len; i++)
/*     */       {
/* 182 */         Element elem = (Element)nodeList.get(i);
/* 183 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg"))
/*     */         {
/*     */ 
/* 186 */           SDeamonTransferMapCfg obj = new SDeamonTransferMapCfg();
/* 187 */           obj.loadFromXml(elem);
/* 188 */           if (all.put(Integer.valueOf(obj.mapId), obj) != null) {
/* 189 */             throw new RuntimeException("duplicate key : " + obj.mapId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 194 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 200 */     all = new java.util.HashMap();
/*     */     
/* 202 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg.bny";
/*     */     try
/*     */     {
/* 205 */       File file = new File(path);
/* 206 */       if (file.exists())
/*     */       {
/* 208 */         byte[] bytes = new byte['Ѐ'];
/* 209 */         FileInputStream fis = new FileInputStream(file);
/* 210 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 211 */         int len = 0;
/* 212 */         while ((len = fis.read(bytes)) > 0)
/* 213 */           baos.write(bytes, 0, len);
/* 214 */         fis.close();
/* 215 */         bytes = baos.toByteArray();
/* 216 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 219 */           _os_.unmarshal_int();
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/*     */         }
/* 223 */         _os_.unmarshal_int();
/* 224 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 227 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 229 */           SDeamonTransferMapCfg _v_ = new SDeamonTransferMapCfg();
/* 230 */           _v_.unmarshal(_os_);
/* 231 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 232 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 237 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 242 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDeamonTransferMapCfg> all)
/*     */   {
/* 249 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SDeamonTransferMapCfg.bny";
/*     */     try
/*     */     {
/* 252 */       File file = new File(path);
/* 253 */       if (file.exists())
/*     */       {
/* 255 */         byte[] bytes = new byte['Ѐ'];
/* 256 */         FileInputStream fis = new FileInputStream(file);
/* 257 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 258 */         int len = 0;
/* 259 */         while ((len = fis.read(bytes)) > 0)
/* 260 */           baos.write(bytes, 0, len);
/* 261 */         fis.close();
/* 262 */         bytes = baos.toByteArray();
/* 263 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 264 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 266 */           _os_.unmarshal_int();
/* 267 */           _os_.unmarshal_int();
/* 268 */           _os_.unmarshal_int();
/*     */         }
/* 270 */         _os_.unmarshal_int();
/* 271 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 274 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 276 */           SDeamonTransferMapCfg _v_ = new SDeamonTransferMapCfg();
/* 277 */           _v_.unmarshal(_os_);
/* 278 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 279 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 284 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 289 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SDeamonTransferMapCfg getOld(int key)
/*     */   {
/* 297 */     return (SDeamonTransferMapCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDeamonTransferMapCfg get(int key)
/*     */   {
/* 302 */     return (SDeamonTransferMapCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDeamonTransferMapCfg> getOldAll()
/*     */   {
/* 307 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDeamonTransferMapCfg> getAll()
/*     */   {
/* 312 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDeamonTransferMapCfg> newAll)
/*     */   {
/* 317 */     oldAll = all;
/* 318 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 323 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\confbean\SDeamonTransferMapCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */