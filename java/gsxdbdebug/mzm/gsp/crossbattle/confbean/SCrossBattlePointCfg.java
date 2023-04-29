/*     */ package mzm.gsp.crossbattle.confbean;
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
/*     */ public class SCrossBattlePointCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattlePointCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattlePointCfg> all = null;
/*     */   
/*     */   public int activityCfgid;
/*     */   public int durationInMinute;
/*     */   public int prepareDurationInMinute;
/*     */   public int matchDurationInMinute;
/*     */   public int matchIntervalSecond;
/*     */   public int remoteMapCfgid;
/*     */   public int remoteMapX;
/*     */   public int remoteMapY;
/*     */   public int leaveMapNpcCfgid;
/*     */   public int leaveMapNpcServiceCfgid;
/*     */   public int localMapCfgid;
/*     */   public int localMapX;
/*     */   public int localMapY;
/*     */   public int winPoint;
/*     */   public int losePoint;
/*     */   public int winMailCfgid;
/*     */   public int loseMailCfgid;
/*  35 */   public java.util.ArrayList<TimePointInfo> timePoints = new java.util.ArrayList();
/*     */   public int promotionCorpsNum;
/*     */   public int endTimePoint;
/*     */   public int activitySwitch;
/*     */   public int funSwitch;
/*     */   public int lastTimePoint;
/*     */   public int endFightCountDown;
/*     */   public int nextMailCfgid;
/*     */   public int changeMailCfgid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  47 */     this.activityCfgid = Integer.valueOf(rootElement.attributeValue("activityCfgid")).intValue();
/*  48 */     this.durationInMinute = Integer.valueOf(rootElement.attributeValue("durationInMinute")).intValue();
/*  49 */     this.prepareDurationInMinute = Integer.valueOf(rootElement.attributeValue("prepareDurationInMinute")).intValue();
/*  50 */     this.matchDurationInMinute = Integer.valueOf(rootElement.attributeValue("matchDurationInMinute")).intValue();
/*  51 */     this.matchIntervalSecond = Integer.valueOf(rootElement.attributeValue("matchIntervalSecond")).intValue();
/*  52 */     this.remoteMapCfgid = Integer.valueOf(rootElement.attributeValue("remoteMapCfgid")).intValue();
/*  53 */     this.remoteMapX = Integer.valueOf(rootElement.attributeValue("remoteMapX")).intValue();
/*  54 */     this.remoteMapY = Integer.valueOf(rootElement.attributeValue("remoteMapY")).intValue();
/*  55 */     this.leaveMapNpcCfgid = Integer.valueOf(rootElement.attributeValue("leaveMapNpcCfgid")).intValue();
/*  56 */     this.leaveMapNpcServiceCfgid = Integer.valueOf(rootElement.attributeValue("leaveMapNpcServiceCfgid")).intValue();
/*  57 */     this.localMapCfgid = Integer.valueOf(rootElement.attributeValue("localMapCfgid")).intValue();
/*  58 */     this.localMapX = Integer.valueOf(rootElement.attributeValue("localMapX")).intValue();
/*  59 */     this.localMapY = Integer.valueOf(rootElement.attributeValue("localMapY")).intValue();
/*  60 */     this.winPoint = Integer.valueOf(rootElement.attributeValue("winPoint")).intValue();
/*  61 */     this.losePoint = Integer.valueOf(rootElement.attributeValue("losePoint")).intValue();
/*  62 */     this.winMailCfgid = Integer.valueOf(rootElement.attributeValue("winMailCfgid")).intValue();
/*  63 */     this.loseMailCfgid = Integer.valueOf(rootElement.attributeValue("loseMailCfgid")).intValue();
/*     */     
/*  65 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "timePoints");
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
/*  76 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.TimePointInfo"))
/*     */       {
/*     */         TimePointInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  83 */           _v_ = new TimePointInfo();
/*  84 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  91 */         this.timePoints.add(_v_);
/*     */       }
/*     */     }
/*  94 */     this.promotionCorpsNum = Integer.valueOf(rootElement.attributeValue("promotionCorpsNum")).intValue();
/*  95 */     this.endTimePoint = Integer.valueOf(rootElement.attributeValue("endTimePoint")).intValue();
/*  96 */     this.activitySwitch = Integer.valueOf(rootElement.attributeValue("activitySwitch")).intValue();
/*  97 */     this.funSwitch = Integer.valueOf(rootElement.attributeValue("funSwitch")).intValue();
/*  98 */     this.lastTimePoint = Integer.valueOf(rootElement.attributeValue("lastTimePoint")).intValue();
/*  99 */     this.endFightCountDown = Integer.valueOf(rootElement.attributeValue("endFightCountDown")).intValue();
/* 100 */     this.nextMailCfgid = Integer.valueOf(rootElement.attributeValue("nextMailCfgid")).intValue();
/* 101 */     this.changeMailCfgid = Integer.valueOf(rootElement.attributeValue("changeMailCfgid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 106 */     _os_.marshal(this.activityCfgid);
/* 107 */     _os_.marshal(this.durationInMinute);
/* 108 */     _os_.marshal(this.prepareDurationInMinute);
/* 109 */     _os_.marshal(this.matchDurationInMinute);
/* 110 */     _os_.marshal(this.matchIntervalSecond);
/* 111 */     _os_.marshal(this.remoteMapCfgid);
/* 112 */     _os_.marshal(this.remoteMapX);
/* 113 */     _os_.marshal(this.remoteMapY);
/* 114 */     _os_.marshal(this.leaveMapNpcCfgid);
/* 115 */     _os_.marshal(this.leaveMapNpcServiceCfgid);
/* 116 */     _os_.marshal(this.localMapCfgid);
/* 117 */     _os_.marshal(this.localMapX);
/* 118 */     _os_.marshal(this.localMapY);
/* 119 */     _os_.marshal(this.winPoint);
/* 120 */     _os_.marshal(this.losePoint);
/* 121 */     _os_.marshal(this.winMailCfgid);
/* 122 */     _os_.marshal(this.loseMailCfgid);
/* 123 */     _os_.compact_uint32(this.timePoints.size());
/* 124 */     for (TimePointInfo _v_ : this.timePoints)
/*     */     {
/* 126 */       _os_.marshal(_v_);
/*     */     }
/* 128 */     _os_.marshal(this.promotionCorpsNum);
/* 129 */     _os_.marshal(this.endTimePoint);
/* 130 */     _os_.marshal(this.activitySwitch);
/* 131 */     _os_.marshal(this.funSwitch);
/* 132 */     _os_.marshal(this.lastTimePoint);
/* 133 */     _os_.marshal(this.endFightCountDown);
/* 134 */     _os_.marshal(this.nextMailCfgid);
/* 135 */     _os_.marshal(this.changeMailCfgid);
/* 136 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 141 */     this.activityCfgid = _os_.unmarshal_int();
/* 142 */     this.durationInMinute = _os_.unmarshal_int();
/* 143 */     this.prepareDurationInMinute = _os_.unmarshal_int();
/* 144 */     this.matchDurationInMinute = _os_.unmarshal_int();
/* 145 */     this.matchIntervalSecond = _os_.unmarshal_int();
/* 146 */     this.remoteMapCfgid = _os_.unmarshal_int();
/* 147 */     this.remoteMapX = _os_.unmarshal_int();
/* 148 */     this.remoteMapY = _os_.unmarshal_int();
/* 149 */     this.leaveMapNpcCfgid = _os_.unmarshal_int();
/* 150 */     this.leaveMapNpcServiceCfgid = _os_.unmarshal_int();
/* 151 */     this.localMapCfgid = _os_.unmarshal_int();
/* 152 */     this.localMapX = _os_.unmarshal_int();
/* 153 */     this.localMapY = _os_.unmarshal_int();
/* 154 */     this.winPoint = _os_.unmarshal_int();
/* 155 */     this.losePoint = _os_.unmarshal_int();
/* 156 */     this.winMailCfgid = _os_.unmarshal_int();
/* 157 */     this.loseMailCfgid = _os_.unmarshal_int();
/* 158 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 161 */       TimePointInfo _v_ = new TimePointInfo();
/* 162 */       _v_.unmarshal(_os_);
/* 163 */       this.timePoints.add(_v_);
/*     */     }
/* 165 */     this.promotionCorpsNum = _os_.unmarshal_int();
/* 166 */     this.endTimePoint = _os_.unmarshal_int();
/* 167 */     this.activitySwitch = _os_.unmarshal_int();
/* 168 */     this.funSwitch = _os_.unmarshal_int();
/* 169 */     this.lastTimePoint = _os_.unmarshal_int();
/* 170 */     this.endFightCountDown = _os_.unmarshal_int();
/* 171 */     this.nextMailCfgid = _os_.unmarshal_int();
/* 172 */     this.changeMailCfgid = _os_.unmarshal_int();
/* 173 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 182 */       all = new java.util.HashMap();
/* 183 */       SAXReader reader = new SAXReader();
/* 184 */       org.dom4j.Document doc = reader.read(new File(path));
/* 185 */       Element root = doc.getRootElement();
/* 186 */       List<?> nodeList = root.elements();
/* 187 */       int len = nodeList.size();
/* 188 */       for (int i = 0; i < len; i++)
/*     */       {
/* 190 */         Element elem = (Element)nodeList.get(i);
/* 191 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg"))
/*     */         {
/*     */ 
/* 194 */           SCrossBattlePointCfg obj = new SCrossBattlePointCfg();
/* 195 */           obj.loadFromXml(elem);
/* 196 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattlePointCfg> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 212 */       SAXReader reader = new SAXReader();
/* 213 */       org.dom4j.Document doc = reader.read(new File(path));
/* 214 */       Element root = doc.getRootElement();
/* 215 */       List<?> nodeList = root.elements();
/* 216 */       int len = nodeList.size();
/* 217 */       for (int i = 0; i < len; i++)
/*     */       {
/* 219 */         Element elem = (Element)nodeList.get(i);
/* 220 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg"))
/*     */         {
/*     */ 
/* 223 */           SCrossBattlePointCfg obj = new SCrossBattlePointCfg();
/* 224 */           obj.loadFromXml(elem);
/* 225 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 237 */     all = new java.util.HashMap();
/*     */     
/* 239 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg.bny";
/*     */     try
/*     */     {
/* 242 */       File file = new File(path);
/* 243 */       if (file.exists())
/*     */       {
/* 245 */         byte[] bytes = new byte['Ѐ'];
/* 246 */         FileInputStream fis = new FileInputStream(file);
/* 247 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 248 */         int len = 0;
/* 249 */         while ((len = fis.read(bytes)) > 0)
/* 250 */           baos.write(bytes, 0, len);
/* 251 */         fis.close();
/* 252 */         bytes = baos.toByteArray();
/* 253 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 254 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 256 */           _os_.unmarshal_int();
/* 257 */           _os_.unmarshal_int();
/* 258 */           _os_.unmarshal_int();
/*     */         }
/* 260 */         _os_.unmarshal_int();
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 264 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 266 */           SCrossBattlePointCfg _v_ = new SCrossBattlePointCfg();
/* 267 */           _v_.unmarshal(_os_);
/* 268 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 269 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 274 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 279 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattlePointCfg> all)
/*     */   {
/* 286 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg.bny";
/*     */     try
/*     */     {
/* 289 */       File file = new File(path);
/* 290 */       if (file.exists())
/*     */       {
/* 292 */         byte[] bytes = new byte['Ѐ'];
/* 293 */         FileInputStream fis = new FileInputStream(file);
/* 294 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 295 */         int len = 0;
/* 296 */         while ((len = fis.read(bytes)) > 0)
/* 297 */           baos.write(bytes, 0, len);
/* 298 */         fis.close();
/* 299 */         bytes = baos.toByteArray();
/* 300 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 301 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 303 */           _os_.unmarshal_int();
/* 304 */           _os_.unmarshal_int();
/* 305 */           _os_.unmarshal_int();
/*     */         }
/* 307 */         _os_.unmarshal_int();
/* 308 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 311 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 313 */           SCrossBattlePointCfg _v_ = new SCrossBattlePointCfg();
/* 314 */           _v_.unmarshal(_os_);
/* 315 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 316 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 321 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 326 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattlePointCfg getOld(int key)
/*     */   {
/* 334 */     return (SCrossBattlePointCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattlePointCfg get(int key)
/*     */   {
/* 339 */     return (SCrossBattlePointCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattlePointCfg> getOldAll()
/*     */   {
/* 344 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattlePointCfg> getAll()
/*     */   {
/* 349 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattlePointCfg> newAll)
/*     */   {
/* 354 */     oldAll = all;
/* 355 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 360 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattlePointCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */