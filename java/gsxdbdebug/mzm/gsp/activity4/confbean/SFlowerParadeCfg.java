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
/*     */ public class SFlowerParadeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFlowerParadeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFlowerParadeCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int mapGroupId;
/*     */   public int mapUniqueTime;
/*     */   public int ocpGroupId;
/*     */   public int ocpUniqueTime;
/*     */   public int danceGroupId;
/*     */   public int redbagGroupId;
/*  25 */   public java.util.ArrayList<Integer> startCommonTimeIds = new java.util.ArrayList();
/*     */   public int prepareEffectId;
/*     */   public int prepareTime;
/*     */   public int fireworksEffectId;
/*     */   public int fireworksSoundId;
/*     */   public int restTime;
/*     */   public int singDelayTime;
/*     */   public int endEffectId;
/*     */   public int endRestTime;
/*     */   public int followParadeTime;
/*     */   public int followAliveTime;
/*     */   public int followAwardId;
/*     */   public int followAwardCount;
/*     */   public int danceAwardId;
/*     */   public int danceAwardCount;
/*     */   public int redbagAwardId;
/*     */   public int redbagHandleType;
/*     */   public int paradeVelocity;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  46 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  47 */     this.mapGroupId = Integer.valueOf(rootElement.attributeValue("mapGroupId")).intValue();
/*  48 */     this.mapUniqueTime = Integer.valueOf(rootElement.attributeValue("mapUniqueTime")).intValue();
/*  49 */     this.ocpGroupId = Integer.valueOf(rootElement.attributeValue("ocpGroupId")).intValue();
/*  50 */     this.ocpUniqueTime = Integer.valueOf(rootElement.attributeValue("ocpUniqueTime")).intValue();
/*  51 */     this.danceGroupId = Integer.valueOf(rootElement.attributeValue("danceGroupId")).intValue();
/*  52 */     this.redbagGroupId = Integer.valueOf(rootElement.attributeValue("redbagGroupId")).intValue();
/*     */     
/*  54 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "startCommonTimeIds");
/*  55 */     if (collectionElement == null)
/*     */     {
/*  57 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  60 */     List<?> _nodeList = collectionElement.elements();
/*  61 */     int _len = _nodeList.size();
/*  62 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  64 */       Element elem = (Element)_nodeList.get(i);
/*  65 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  72 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.startCommonTimeIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  82 */     this.prepareEffectId = Integer.valueOf(rootElement.attributeValue("prepareEffectId")).intValue();
/*  83 */     this.prepareTime = Integer.valueOf(rootElement.attributeValue("prepareTime")).intValue();
/*  84 */     this.fireworksEffectId = Integer.valueOf(rootElement.attributeValue("fireworksEffectId")).intValue();
/*  85 */     this.fireworksSoundId = Integer.valueOf(rootElement.attributeValue("fireworksSoundId")).intValue();
/*  86 */     this.restTime = Integer.valueOf(rootElement.attributeValue("restTime")).intValue();
/*  87 */     this.singDelayTime = Integer.valueOf(rootElement.attributeValue("singDelayTime")).intValue();
/*  88 */     this.endEffectId = Integer.valueOf(rootElement.attributeValue("endEffectId")).intValue();
/*  89 */     this.endRestTime = Integer.valueOf(rootElement.attributeValue("endRestTime")).intValue();
/*  90 */     this.followParadeTime = Integer.valueOf(rootElement.attributeValue("followParadeTime")).intValue();
/*  91 */     this.followAliveTime = Integer.valueOf(rootElement.attributeValue("followAliveTime")).intValue();
/*  92 */     this.followAwardId = Integer.valueOf(rootElement.attributeValue("followAwardId")).intValue();
/*  93 */     this.followAwardCount = Integer.valueOf(rootElement.attributeValue("followAwardCount")).intValue();
/*  94 */     this.danceAwardId = Integer.valueOf(rootElement.attributeValue("danceAwardId")).intValue();
/*  95 */     this.danceAwardCount = Integer.valueOf(rootElement.attributeValue("danceAwardCount")).intValue();
/*  96 */     this.redbagAwardId = Integer.valueOf(rootElement.attributeValue("redbagAwardId")).intValue();
/*  97 */     this.redbagHandleType = Integer.valueOf(rootElement.attributeValue("redbagHandleType")).intValue();
/*  98 */     this.paradeVelocity = Integer.valueOf(rootElement.attributeValue("paradeVelocity")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 103 */     _os_.marshal(this.activityId);
/* 104 */     _os_.marshal(this.mapGroupId);
/* 105 */     _os_.marshal(this.mapUniqueTime);
/* 106 */     _os_.marshal(this.ocpGroupId);
/* 107 */     _os_.marshal(this.ocpUniqueTime);
/* 108 */     _os_.marshal(this.danceGroupId);
/* 109 */     _os_.marshal(this.redbagGroupId);
/* 110 */     _os_.compact_uint32(this.startCommonTimeIds.size());
/* 111 */     for (Integer _v_ : this.startCommonTimeIds)
/*     */     {
/* 113 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 115 */     _os_.marshal(this.prepareEffectId);
/* 116 */     _os_.marshal(this.prepareTime);
/* 117 */     _os_.marshal(this.fireworksEffectId);
/* 118 */     _os_.marshal(this.fireworksSoundId);
/* 119 */     _os_.marshal(this.restTime);
/* 120 */     _os_.marshal(this.singDelayTime);
/* 121 */     _os_.marshal(this.endEffectId);
/* 122 */     _os_.marshal(this.endRestTime);
/* 123 */     _os_.marshal(this.followParadeTime);
/* 124 */     _os_.marshal(this.followAliveTime);
/* 125 */     _os_.marshal(this.followAwardId);
/* 126 */     _os_.marshal(this.followAwardCount);
/* 127 */     _os_.marshal(this.danceAwardId);
/* 128 */     _os_.marshal(this.danceAwardCount);
/* 129 */     _os_.marshal(this.redbagAwardId);
/* 130 */     _os_.marshal(this.redbagHandleType);
/* 131 */     _os_.marshal(this.paradeVelocity);
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 137 */     this.activityId = _os_.unmarshal_int();
/* 138 */     this.mapGroupId = _os_.unmarshal_int();
/* 139 */     this.mapUniqueTime = _os_.unmarshal_int();
/* 140 */     this.ocpGroupId = _os_.unmarshal_int();
/* 141 */     this.ocpUniqueTime = _os_.unmarshal_int();
/* 142 */     this.danceGroupId = _os_.unmarshal_int();
/* 143 */     this.redbagGroupId = _os_.unmarshal_int();
/* 144 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 147 */       int _v_ = _os_.unmarshal_int();
/* 148 */       this.startCommonTimeIds.add(Integer.valueOf(_v_));
/*     */     }
/* 150 */     this.prepareEffectId = _os_.unmarshal_int();
/* 151 */     this.prepareTime = _os_.unmarshal_int();
/* 152 */     this.fireworksEffectId = _os_.unmarshal_int();
/* 153 */     this.fireworksSoundId = _os_.unmarshal_int();
/* 154 */     this.restTime = _os_.unmarshal_int();
/* 155 */     this.singDelayTime = _os_.unmarshal_int();
/* 156 */     this.endEffectId = _os_.unmarshal_int();
/* 157 */     this.endRestTime = _os_.unmarshal_int();
/* 158 */     this.followParadeTime = _os_.unmarshal_int();
/* 159 */     this.followAliveTime = _os_.unmarshal_int();
/* 160 */     this.followAwardId = _os_.unmarshal_int();
/* 161 */     this.followAwardCount = _os_.unmarshal_int();
/* 162 */     this.danceAwardId = _os_.unmarshal_int();
/* 163 */     this.danceAwardCount = _os_.unmarshal_int();
/* 164 */     this.redbagAwardId = _os_.unmarshal_int();
/* 165 */     this.redbagHandleType = _os_.unmarshal_int();
/* 166 */     this.paradeVelocity = _os_.unmarshal_int();
/* 167 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 172 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 176 */       all = new java.util.HashMap();
/* 177 */       SAXReader reader = new SAXReader();
/* 178 */       org.dom4j.Document doc = reader.read(new File(path));
/* 179 */       Element root = doc.getRootElement();
/* 180 */       List<?> nodeList = root.elements();
/* 181 */       int len = nodeList.size();
/* 182 */       for (int i = 0; i < len; i++)
/*     */       {
/* 184 */         Element elem = (Element)nodeList.get(i);
/* 185 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SFlowerParadeCfg"))
/*     */         {
/*     */ 
/* 188 */           SFlowerParadeCfg obj = new SFlowerParadeCfg();
/* 189 */           obj.loadFromXml(elem);
/* 190 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 191 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFlowerParadeCfg> all)
/*     */   {
/* 202 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 206 */       SAXReader reader = new SAXReader();
/* 207 */       org.dom4j.Document doc = reader.read(new File(path));
/* 208 */       Element root = doc.getRootElement();
/* 209 */       List<?> nodeList = root.elements();
/* 210 */       int len = nodeList.size();
/* 211 */       for (int i = 0; i < len; i++)
/*     */       {
/* 213 */         Element elem = (Element)nodeList.get(i);
/* 214 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SFlowerParadeCfg"))
/*     */         {
/*     */ 
/* 217 */           SFlowerParadeCfg obj = new SFlowerParadeCfg();
/* 218 */           obj.loadFromXml(elem);
/* 219 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 220 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 225 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 231 */     all = new java.util.HashMap();
/*     */     
/* 233 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeCfg.bny";
/*     */     try
/*     */     {
/* 236 */       File file = new File(path);
/* 237 */       if (file.exists())
/*     */       {
/* 239 */         byte[] bytes = new byte['Ѐ'];
/* 240 */         FileInputStream fis = new FileInputStream(file);
/* 241 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 242 */         int len = 0;
/* 243 */         while ((len = fis.read(bytes)) > 0)
/* 244 */           baos.write(bytes, 0, len);
/* 245 */         fis.close();
/* 246 */         bytes = baos.toByteArray();
/* 247 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 250 */           _os_.unmarshal_int();
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/*     */         }
/* 254 */         _os_.unmarshal_int();
/* 255 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 258 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 260 */           SFlowerParadeCfg _v_ = new SFlowerParadeCfg();
/* 261 */           _v_.unmarshal(_os_);
/* 262 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 263 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 268 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 273 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFlowerParadeCfg> all)
/*     */   {
/* 280 */     String path = dir + "mzm.gsp.activity4.confbean.SFlowerParadeCfg.bny";
/*     */     try
/*     */     {
/* 283 */       File file = new File(path);
/* 284 */       if (file.exists())
/*     */       {
/* 286 */         byte[] bytes = new byte['Ѐ'];
/* 287 */         FileInputStream fis = new FileInputStream(file);
/* 288 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 289 */         int len = 0;
/* 290 */         while ((len = fis.read(bytes)) > 0)
/* 291 */           baos.write(bytes, 0, len);
/* 292 */         fis.close();
/* 293 */         bytes = baos.toByteArray();
/* 294 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 295 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 297 */           _os_.unmarshal_int();
/* 298 */           _os_.unmarshal_int();
/* 299 */           _os_.unmarshal_int();
/*     */         }
/* 301 */         _os_.unmarshal_int();
/* 302 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 305 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 307 */           SFlowerParadeCfg _v_ = new SFlowerParadeCfg();
/* 308 */           _v_.unmarshal(_os_);
/* 309 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 310 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 315 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 320 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFlowerParadeCfg getOld(int key)
/*     */   {
/* 328 */     return (SFlowerParadeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFlowerParadeCfg get(int key)
/*     */   {
/* 333 */     return (SFlowerParadeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFlowerParadeCfg> getOldAll()
/*     */   {
/* 338 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFlowerParadeCfg> getAll()
/*     */   {
/* 343 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFlowerParadeCfg> newAll)
/*     */   {
/* 348 */     oldAll = all;
/* 349 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 354 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SFlowerParadeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */