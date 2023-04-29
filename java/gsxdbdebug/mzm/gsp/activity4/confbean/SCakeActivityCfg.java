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
/*     */ public class SCakeActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCakeActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCakeActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int switchId;
/*     */   public int stateId;
/*     */   public int cookTurn;
/*     */   public int historyNum;
/*     */   public int prepareTime;
/*     */   public int cookPrepareTime;
/*     */   public int collectionCheckId;
/*     */   public int collectMaterialItemId;
/*     */   public int materialController;
/*     */   public int triggerCountMax;
/*     */   public int triggerCountMin;
/*     */   public double triggerCountRet;
/*     */   public int eachTurnCanGetMaxNum;
/*     */   public int cookTime;
/*     */   public int giftFixAwardId;
/*     */   public int giftMaterialItemId;
/*     */   public int randomRangeTopLimit;
/*     */   public int randomRangeFloorLimit;
/*     */   public int makeCakeTime;
/*     */   public int selfCookCountMax;
/*     */   public int helpCookCountMax;
/*     */   public int cakeRangeMax;
/*     */   public int useOtherCakeCountMax;
/*     */   public int useSelfCakeCountMax;
/*     */   public int cakeMailId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  47 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  48 */     this.switchId = Integer.valueOf(rootElement.attributeValue("switchId")).intValue();
/*  49 */     this.stateId = Integer.valueOf(rootElement.attributeValue("stateId")).intValue();
/*  50 */     this.cookTurn = Integer.valueOf(rootElement.attributeValue("cookTurn")).intValue();
/*  51 */     this.historyNum = Integer.valueOf(rootElement.attributeValue("historyNum")).intValue();
/*  52 */     this.prepareTime = Integer.valueOf(rootElement.attributeValue("prepareTime")).intValue();
/*  53 */     this.cookPrepareTime = Integer.valueOf(rootElement.attributeValue("cookPrepareTime")).intValue();
/*  54 */     this.collectionCheckId = Integer.valueOf(rootElement.attributeValue("collectionCheckId")).intValue();
/*  55 */     this.collectMaterialItemId = Integer.valueOf(rootElement.attributeValue("collectMaterialItemId")).intValue();
/*  56 */     this.materialController = Integer.valueOf(rootElement.attributeValue("materialController")).intValue();
/*  57 */     this.triggerCountMax = Integer.valueOf(rootElement.attributeValue("triggerCountMax")).intValue();
/*  58 */     this.triggerCountMin = Integer.valueOf(rootElement.attributeValue("triggerCountMin")).intValue();
/*  59 */     this.triggerCountRet = Double.valueOf(rootElement.attributeValue("triggerCountRet")).doubleValue();
/*  60 */     this.eachTurnCanGetMaxNum = Integer.valueOf(rootElement.attributeValue("eachTurnCanGetMaxNum")).intValue();
/*  61 */     this.cookTime = Integer.valueOf(rootElement.attributeValue("cookTime")).intValue();
/*  62 */     this.giftFixAwardId = Integer.valueOf(rootElement.attributeValue("giftFixAwardId")).intValue();
/*  63 */     this.giftMaterialItemId = Integer.valueOf(rootElement.attributeValue("giftMaterialItemId")).intValue();
/*  64 */     this.randomRangeTopLimit = Integer.valueOf(rootElement.attributeValue("randomRangeTopLimit")).intValue();
/*  65 */     this.randomRangeFloorLimit = Integer.valueOf(rootElement.attributeValue("randomRangeFloorLimit")).intValue();
/*  66 */     this.makeCakeTime = Integer.valueOf(rootElement.attributeValue("makeCakeTime")).intValue();
/*  67 */     this.selfCookCountMax = Integer.valueOf(rootElement.attributeValue("selfCookCountMax")).intValue();
/*  68 */     this.helpCookCountMax = Integer.valueOf(rootElement.attributeValue("helpCookCountMax")).intValue();
/*  69 */     this.cakeRangeMax = Integer.valueOf(rootElement.attributeValue("cakeRangeMax")).intValue();
/*  70 */     this.useOtherCakeCountMax = Integer.valueOf(rootElement.attributeValue("useOtherCakeCountMax")).intValue();
/*  71 */     this.useSelfCakeCountMax = Integer.valueOf(rootElement.attributeValue("useSelfCakeCountMax")).intValue();
/*  72 */     this.cakeMailId = Integer.valueOf(rootElement.attributeValue("cakeMailId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _os_.marshal(this.activityId);
/*  78 */     _os_.marshal(this.switchId);
/*  79 */     _os_.marshal(this.stateId);
/*  80 */     _os_.marshal(this.cookTurn);
/*  81 */     _os_.marshal(this.historyNum);
/*  82 */     _os_.marshal(this.prepareTime);
/*  83 */     _os_.marshal(this.cookPrepareTime);
/*  84 */     _os_.marshal(this.collectionCheckId);
/*  85 */     _os_.marshal(this.collectMaterialItemId);
/*  86 */     _os_.marshal(this.materialController);
/*  87 */     _os_.marshal(this.triggerCountMax);
/*  88 */     _os_.marshal(this.triggerCountMin);
/*  89 */     _os_.marshal(this.triggerCountRet);
/*  90 */     _os_.marshal(this.eachTurnCanGetMaxNum);
/*  91 */     _os_.marshal(this.cookTime);
/*  92 */     _os_.marshal(this.giftFixAwardId);
/*  93 */     _os_.marshal(this.giftMaterialItemId);
/*  94 */     _os_.marshal(this.randomRangeTopLimit);
/*  95 */     _os_.marshal(this.randomRangeFloorLimit);
/*  96 */     _os_.marshal(this.makeCakeTime);
/*  97 */     _os_.marshal(this.selfCookCountMax);
/*  98 */     _os_.marshal(this.helpCookCountMax);
/*  99 */     _os_.marshal(this.cakeRangeMax);
/* 100 */     _os_.marshal(this.useOtherCakeCountMax);
/* 101 */     _os_.marshal(this.useSelfCakeCountMax);
/* 102 */     _os_.marshal(this.cakeMailId);
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 108 */     this.activityId = _os_.unmarshal_int();
/* 109 */     this.switchId = _os_.unmarshal_int();
/* 110 */     this.stateId = _os_.unmarshal_int();
/* 111 */     this.cookTurn = _os_.unmarshal_int();
/* 112 */     this.historyNum = _os_.unmarshal_int();
/* 113 */     this.prepareTime = _os_.unmarshal_int();
/* 114 */     this.cookPrepareTime = _os_.unmarshal_int();
/* 115 */     this.collectionCheckId = _os_.unmarshal_int();
/* 116 */     this.collectMaterialItemId = _os_.unmarshal_int();
/* 117 */     this.materialController = _os_.unmarshal_int();
/* 118 */     this.triggerCountMax = _os_.unmarshal_int();
/* 119 */     this.triggerCountMin = _os_.unmarshal_int();
/* 120 */     this.triggerCountRet = _os_.unmarshal_float();
/* 121 */     this.eachTurnCanGetMaxNum = _os_.unmarshal_int();
/* 122 */     this.cookTime = _os_.unmarshal_int();
/* 123 */     this.giftFixAwardId = _os_.unmarshal_int();
/* 124 */     this.giftMaterialItemId = _os_.unmarshal_int();
/* 125 */     this.randomRangeTopLimit = _os_.unmarshal_int();
/* 126 */     this.randomRangeFloorLimit = _os_.unmarshal_int();
/* 127 */     this.makeCakeTime = _os_.unmarshal_int();
/* 128 */     this.selfCookCountMax = _os_.unmarshal_int();
/* 129 */     this.helpCookCountMax = _os_.unmarshal_int();
/* 130 */     this.cakeRangeMax = _os_.unmarshal_int();
/* 131 */     this.useOtherCakeCountMax = _os_.unmarshal_int();
/* 132 */     this.useSelfCakeCountMax = _os_.unmarshal_int();
/* 133 */     this.cakeMailId = _os_.unmarshal_int();
/* 134 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 139 */     String path = dir + "mzm.gsp.activity4.confbean.SCakeActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 143 */       all = new java.util.HashMap();
/* 144 */       SAXReader reader = new SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       List<?> nodeList = root.elements();
/* 148 */       int len = nodeList.size();
/* 149 */       for (int i = 0; i < len; i++)
/*     */       {
/* 151 */         Element elem = (Element)nodeList.get(i);
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SCakeActivityCfg"))
/*     */         {
/*     */ 
/* 155 */           SCakeActivityCfg obj = new SCakeActivityCfg();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCakeActivityCfg> all)
/*     */   {
/* 169 */     String path = dir + "mzm.gsp.activity4.confbean.SCakeActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 173 */       SAXReader reader = new SAXReader();
/* 174 */       org.dom4j.Document doc = reader.read(new File(path));
/* 175 */       Element root = doc.getRootElement();
/* 176 */       List<?> nodeList = root.elements();
/* 177 */       int len = nodeList.size();
/* 178 */       for (int i = 0; i < len; i++)
/*     */       {
/* 180 */         Element elem = (Element)nodeList.get(i);
/* 181 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SCakeActivityCfg"))
/*     */         {
/*     */ 
/* 184 */           SCakeActivityCfg obj = new SCakeActivityCfg();
/* 185 */           obj.loadFromXml(elem);
/* 186 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 198 */     all = new java.util.HashMap();
/*     */     
/* 200 */     String path = dir + "mzm.gsp.activity4.confbean.SCakeActivityCfg.bny";
/*     */     try
/*     */     {
/* 203 */       File file = new File(path);
/* 204 */       if (file.exists())
/*     */       {
/* 206 */         byte[] bytes = new byte['Ѐ'];
/* 207 */         FileInputStream fis = new FileInputStream(file);
/* 208 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 209 */         int len = 0;
/* 210 */         while ((len = fis.read(bytes)) > 0)
/* 211 */           baos.write(bytes, 0, len);
/* 212 */         fis.close();
/* 213 */         bytes = baos.toByteArray();
/* 214 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 215 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/* 219 */           _os_.unmarshal_int();
/*     */         }
/* 221 */         _os_.unmarshal_int();
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 225 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 227 */           SCakeActivityCfg _v_ = new SCakeActivityCfg();
/* 228 */           _v_.unmarshal(_os_);
/* 229 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 230 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 235 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCakeActivityCfg> all)
/*     */   {
/* 247 */     String path = dir + "mzm.gsp.activity4.confbean.SCakeActivityCfg.bny";
/*     */     try
/*     */     {
/* 250 */       File file = new File(path);
/* 251 */       if (file.exists())
/*     */       {
/* 253 */         byte[] bytes = new byte['Ѐ'];
/* 254 */         FileInputStream fis = new FileInputStream(file);
/* 255 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 256 */         int len = 0;
/* 257 */         while ((len = fis.read(bytes)) > 0)
/* 258 */           baos.write(bytes, 0, len);
/* 259 */         fis.close();
/* 260 */         bytes = baos.toByteArray();
/* 261 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 262 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 264 */           _os_.unmarshal_int();
/* 265 */           _os_.unmarshal_int();
/* 266 */           _os_.unmarshal_int();
/*     */         }
/* 268 */         _os_.unmarshal_int();
/* 269 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 272 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 274 */           SCakeActivityCfg _v_ = new SCakeActivityCfg();
/* 275 */           _v_.unmarshal(_os_);
/* 276 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 277 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 282 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 287 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCakeActivityCfg getOld(int key)
/*     */   {
/* 295 */     return (SCakeActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCakeActivityCfg get(int key)
/*     */   {
/* 300 */     return (SCakeActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCakeActivityCfg> getOldAll()
/*     */   {
/* 305 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCakeActivityCfg> getAll()
/*     */   {
/* 310 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCakeActivityCfg> newAll)
/*     */   {
/* 315 */     oldAll = all;
/* 316 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 321 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SCakeActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */