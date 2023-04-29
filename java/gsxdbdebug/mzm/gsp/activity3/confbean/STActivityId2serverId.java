/*     */ package mzm.gsp.activity3.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class STActivityId2serverId implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STActivityId2serverId> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STActivityId2serverId> all = null;
/*     */   
/*     */   public int activityId;
/*  19 */   public java.util.HashSet<Integer> serverIds = new java.util.HashSet();
/*     */   public int switchid;
/*  21 */   public HashMap<Integer, DayInfo> serverLevel2DayInfo = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*     */     
/*  27 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "serverIds");
/*  28 */     if (collectionElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> _nodeList = collectionElement.elements();
/*  34 */     int _len = _nodeList.size();
/*  35 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  37 */       Element elem = (Element)_nodeList.get(i);
/*  38 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  45 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  52 */         this.serverIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  55 */     this.switchid = Integer.valueOf(rootElement.attributeValue("switchid")).intValue();
/*     */     
/*  57 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "serverLevel2DayInfo");
/*  58 */     if (mapTypeElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> entryNodeList = mapTypeElement.elements();
/*  64 */     int entryLen = entryNodeList.size();
/*  65 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  67 */       Element entryElement = (Element)entryNodeList.get(i);
/*  68 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  73 */         Element keyElem = null;
/*  74 */         Element valueElem = null;
/*     */         
/*  76 */         List<?> _nodeList = entryElement.elements();
/*  77 */         int _len = _nodeList.size();
/*  78 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  80 */           Element elem = (Element)_nodeList.get(j);
/*  81 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  83 */             keyElem = elem;
/*     */           }
/*  85 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.DayInfo")))
/*     */           {
/*  87 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  91 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  93 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         DayInfo _v_;
/*     */         try
/*     */         {
/* 100 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 101 */           _v_ = new DayInfo();
/* 102 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 109 */         this.serverLevel2DayInfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 116 */     _os_.marshal(this.activityId);
/* 117 */     _os_.compact_uint32(this.serverIds.size());
/* 118 */     for (Integer _v_ : this.serverIds)
/*     */     {
/* 120 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 122 */     _os_.marshal(this.switchid);
/* 123 */     _os_.compact_uint32(this.serverLevel2DayInfo.size());
/* 124 */     for (java.util.Map.Entry<Integer, DayInfo> _e_ : this.serverLevel2DayInfo.entrySet())
/*     */     {
/* 126 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 127 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 129 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 134 */     this.activityId = _os_.unmarshal_int();
/* 135 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 138 */       int _v_ = _os_.unmarshal_int();
/* 139 */       this.serverIds.add(Integer.valueOf(_v_));
/*     */     }
/* 141 */     this.switchid = _os_.unmarshal_int();
/* 142 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 145 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 147 */       DayInfo _v_ = new DayInfo();
/* 148 */       _v_.unmarshal(_os_);
/* 149 */       this.serverLevel2DayInfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 151 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 156 */     String path = dir + "mzm.gsp.activity3.confbean.STActivityId2serverId.xml";
/*     */     
/*     */     try
/*     */     {
/* 160 */       all = new HashMap();
/* 161 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 162 */       org.dom4j.Document doc = reader.read(new File(path));
/* 163 */       Element root = doc.getRootElement();
/* 164 */       List<?> nodeList = root.elements();
/* 165 */       int len = nodeList.size();
/* 166 */       for (int i = 0; i < len; i++)
/*     */       {
/* 168 */         Element elem = (Element)nodeList.get(i);
/* 169 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STActivityId2serverId"))
/*     */         {
/*     */ 
/* 172 */           STActivityId2serverId obj = new STActivityId2serverId();
/* 173 */           obj.loadFromXml(elem);
/* 174 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 175 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STActivityId2serverId> all)
/*     */   {
/* 186 */     String path = dir + "mzm.gsp.activity3.confbean.STActivityId2serverId.xml";
/*     */     
/*     */     try
/*     */     {
/* 190 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 191 */       org.dom4j.Document doc = reader.read(new File(path));
/* 192 */       Element root = doc.getRootElement();
/* 193 */       List<?> nodeList = root.elements();
/* 194 */       int len = nodeList.size();
/* 195 */       for (int i = 0; i < len; i++)
/*     */       {
/* 197 */         Element elem = (Element)nodeList.get(i);
/* 198 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STActivityId2serverId"))
/*     */         {
/*     */ 
/* 201 */           STActivityId2serverId obj = new STActivityId2serverId();
/* 202 */           obj.loadFromXml(elem);
/* 203 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 204 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 209 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 215 */     all = new HashMap();
/*     */     
/* 217 */     String path = dir + "mzm.gsp.activity3.confbean.STActivityId2serverId.bny";
/*     */     try
/*     */     {
/* 220 */       File file = new File(path);
/* 221 */       if (file.exists())
/*     */       {
/* 223 */         byte[] bytes = new byte['Ѐ'];
/* 224 */         FileInputStream fis = new FileInputStream(file);
/* 225 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 226 */         int len = 0;
/* 227 */         while ((len = fis.read(bytes)) > 0)
/* 228 */           baos.write(bytes, 0, len);
/* 229 */         fis.close();
/* 230 */         bytes = baos.toByteArray();
/* 231 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 234 */           _os_.unmarshal_int();
/* 235 */           _os_.unmarshal_int();
/* 236 */           _os_.unmarshal_int();
/*     */         }
/* 238 */         _os_.unmarshal_int();
/* 239 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 242 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 244 */           STActivityId2serverId _v_ = new STActivityId2serverId();
/* 245 */           _v_.unmarshal(_os_);
/* 246 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 247 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 252 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 257 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STActivityId2serverId> all)
/*     */   {
/* 264 */     String path = dir + "mzm.gsp.activity3.confbean.STActivityId2serverId.bny";
/*     */     try
/*     */     {
/* 267 */       File file = new File(path);
/* 268 */       if (file.exists())
/*     */       {
/* 270 */         byte[] bytes = new byte['Ѐ'];
/* 271 */         FileInputStream fis = new FileInputStream(file);
/* 272 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 273 */         int len = 0;
/* 274 */         while ((len = fis.read(bytes)) > 0)
/* 275 */           baos.write(bytes, 0, len);
/* 276 */         fis.close();
/* 277 */         bytes = baos.toByteArray();
/* 278 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 279 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 281 */           _os_.unmarshal_int();
/* 282 */           _os_.unmarshal_int();
/* 283 */           _os_.unmarshal_int();
/*     */         }
/* 285 */         _os_.unmarshal_int();
/* 286 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 289 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 291 */           STActivityId2serverId _v_ = new STActivityId2serverId();
/* 292 */           _v_.unmarshal(_os_);
/* 293 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 294 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 299 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 304 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STActivityId2serverId getOld(int key)
/*     */   {
/* 312 */     return (STActivityId2serverId)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STActivityId2serverId get(int key)
/*     */   {
/* 317 */     return (STActivityId2serverId)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STActivityId2serverId> getOldAll()
/*     */   {
/* 322 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STActivityId2serverId> getAll()
/*     */   {
/* 327 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STActivityId2serverId> newAll)
/*     */   {
/* 332 */     oldAll = all;
/* 333 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 338 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\STActivityId2serverId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */