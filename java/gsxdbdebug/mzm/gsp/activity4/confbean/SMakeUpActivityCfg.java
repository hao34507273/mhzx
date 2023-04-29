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
/*     */ public class SMakeUpActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMakeUpActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMakeUpActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int positionX;
/*     */   public int positionY;
/*     */   public int radius;
/*     */   public int regionId;
/*     */   public int prepareTime;
/*     */   public int turn;
/*     */   public int turnTime;
/*     */   public int noneRepeatTurn;
/*     */   public int questionLibId;
/*     */   public int optionNum;
/*     */   public int rightAwardId;
/*     */   public int wrongAwardId;
/*     */   public int specialAwardId;
/*     */   public int specialAwardNeedNum;
/*     */   public int normalAwardId;
/*     */   public int finishEffectId;
/*     */   public int switchId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  40 */     this.positionX = Integer.valueOf(rootElement.attributeValue("positionX")).intValue();
/*  41 */     this.positionY = Integer.valueOf(rootElement.attributeValue("positionY")).intValue();
/*  42 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/*  43 */     this.regionId = Integer.valueOf(rootElement.attributeValue("regionId")).intValue();
/*  44 */     this.prepareTime = Integer.valueOf(rootElement.attributeValue("prepareTime")).intValue();
/*  45 */     this.turn = Integer.valueOf(rootElement.attributeValue("turn")).intValue();
/*  46 */     this.turnTime = Integer.valueOf(rootElement.attributeValue("turnTime")).intValue();
/*  47 */     this.noneRepeatTurn = Integer.valueOf(rootElement.attributeValue("noneRepeatTurn")).intValue();
/*  48 */     this.questionLibId = Integer.valueOf(rootElement.attributeValue("questionLibId")).intValue();
/*  49 */     this.optionNum = Integer.valueOf(rootElement.attributeValue("optionNum")).intValue();
/*  50 */     this.rightAwardId = Integer.valueOf(rootElement.attributeValue("rightAwardId")).intValue();
/*  51 */     this.wrongAwardId = Integer.valueOf(rootElement.attributeValue("wrongAwardId")).intValue();
/*  52 */     this.specialAwardId = Integer.valueOf(rootElement.attributeValue("specialAwardId")).intValue();
/*  53 */     this.specialAwardNeedNum = Integer.valueOf(rootElement.attributeValue("specialAwardNeedNum")).intValue();
/*  54 */     this.normalAwardId = Integer.valueOf(rootElement.attributeValue("normalAwardId")).intValue();
/*  55 */     this.finishEffectId = Integer.valueOf(rootElement.attributeValue("finishEffectId")).intValue();
/*  56 */     this.switchId = Integer.valueOf(rootElement.attributeValue("switchId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  61 */     _os_.marshal(this.activityId);
/*  62 */     _os_.marshal(this.positionX);
/*  63 */     _os_.marshal(this.positionY);
/*  64 */     _os_.marshal(this.radius);
/*  65 */     _os_.marshal(this.regionId);
/*  66 */     _os_.marshal(this.prepareTime);
/*  67 */     _os_.marshal(this.turn);
/*  68 */     _os_.marshal(this.turnTime);
/*  69 */     _os_.marshal(this.noneRepeatTurn);
/*  70 */     _os_.marshal(this.questionLibId);
/*  71 */     _os_.marshal(this.optionNum);
/*  72 */     _os_.marshal(this.rightAwardId);
/*  73 */     _os_.marshal(this.wrongAwardId);
/*  74 */     _os_.marshal(this.specialAwardId);
/*  75 */     _os_.marshal(this.specialAwardNeedNum);
/*  76 */     _os_.marshal(this.normalAwardId);
/*  77 */     _os_.marshal(this.finishEffectId);
/*  78 */     _os_.marshal(this.switchId);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.activityId = _os_.unmarshal_int();
/*  85 */     this.positionX = _os_.unmarshal_int();
/*  86 */     this.positionY = _os_.unmarshal_int();
/*  87 */     this.radius = _os_.unmarshal_int();
/*  88 */     this.regionId = _os_.unmarshal_int();
/*  89 */     this.prepareTime = _os_.unmarshal_int();
/*  90 */     this.turn = _os_.unmarshal_int();
/*  91 */     this.turnTime = _os_.unmarshal_int();
/*  92 */     this.noneRepeatTurn = _os_.unmarshal_int();
/*  93 */     this.questionLibId = _os_.unmarshal_int();
/*  94 */     this.optionNum = _os_.unmarshal_int();
/*  95 */     this.rightAwardId = _os_.unmarshal_int();
/*  96 */     this.wrongAwardId = _os_.unmarshal_int();
/*  97 */     this.specialAwardId = _os_.unmarshal_int();
/*  98 */     this.specialAwardNeedNum = _os_.unmarshal_int();
/*  99 */     this.normalAwardId = _os_.unmarshal_int();
/* 100 */     this.finishEffectId = _os_.unmarshal_int();
/* 101 */     this.switchId = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 107 */     String path = dir + "mzm.gsp.activity4.confbean.SMakeUpActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 111 */       all = new java.util.HashMap();
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       List<?> nodeList = root.elements();
/* 116 */       int len = nodeList.size();
/* 117 */       for (int i = 0; i < len; i++)
/*     */       {
/* 119 */         Element elem = (Element)nodeList.get(i);
/* 120 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SMakeUpActivityCfg"))
/*     */         {
/*     */ 
/* 123 */           SMakeUpActivityCfg obj = new SMakeUpActivityCfg();
/* 124 */           obj.loadFromXml(elem);
/* 125 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 126 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMakeUpActivityCfg> all)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.activity4.confbean.SMakeUpActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       SAXReader reader = new SAXReader();
/* 142 */       org.dom4j.Document doc = reader.read(new File(path));
/* 143 */       Element root = doc.getRootElement();
/* 144 */       List<?> nodeList = root.elements();
/* 145 */       int len = nodeList.size();
/* 146 */       for (int i = 0; i < len; i++)
/*     */       {
/* 148 */         Element elem = (Element)nodeList.get(i);
/* 149 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SMakeUpActivityCfg"))
/*     */         {
/*     */ 
/* 152 */           SMakeUpActivityCfg obj = new SMakeUpActivityCfg();
/* 153 */           obj.loadFromXml(elem);
/* 154 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 155 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 166 */     all = new java.util.HashMap();
/*     */     
/* 168 */     String path = dir + "mzm.gsp.activity4.confbean.SMakeUpActivityCfg.bny";
/*     */     try
/*     */     {
/* 171 */       File file = new File(path);
/* 172 */       if (file.exists())
/*     */       {
/* 174 */         byte[] bytes = new byte['Ѐ'];
/* 175 */         FileInputStream fis = new FileInputStream(file);
/* 176 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 177 */         int len = 0;
/* 178 */         while ((len = fis.read(bytes)) > 0)
/* 179 */           baos.write(bytes, 0, len);
/* 180 */         fis.close();
/* 181 */         bytes = baos.toByteArray();
/* 182 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/*     */         }
/* 189 */         _os_.unmarshal_int();
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 193 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 195 */           SMakeUpActivityCfg _v_ = new SMakeUpActivityCfg();
/* 196 */           _v_.unmarshal(_os_);
/* 197 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 203 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMakeUpActivityCfg> all)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.activity4.confbean.SMakeUpActivityCfg.bny";
/*     */     try
/*     */     {
/* 218 */       File file = new File(path);
/* 219 */       if (file.exists())
/*     */       {
/* 221 */         byte[] bytes = new byte['Ѐ'];
/* 222 */         FileInputStream fis = new FileInputStream(file);
/* 223 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 224 */         int len = 0;
/* 225 */         while ((len = fis.read(bytes)) > 0)
/* 226 */           baos.write(bytes, 0, len);
/* 227 */         fis.close();
/* 228 */         bytes = baos.toByteArray();
/* 229 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/*     */         }
/* 236 */         _os_.unmarshal_int();
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 240 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 242 */           SMakeUpActivityCfg _v_ = new SMakeUpActivityCfg();
/* 243 */           _v_.unmarshal(_os_);
/* 244 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 245 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 250 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 255 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMakeUpActivityCfg getOld(int key)
/*     */   {
/* 263 */     return (SMakeUpActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMakeUpActivityCfg get(int key)
/*     */   {
/* 268 */     return (SMakeUpActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMakeUpActivityCfg> getOldAll()
/*     */   {
/* 273 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMakeUpActivityCfg> getAll()
/*     */   {
/* 278 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMakeUpActivityCfg> newAll)
/*     */   {
/* 283 */     oldAll = all;
/* 284 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 289 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SMakeUpActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */