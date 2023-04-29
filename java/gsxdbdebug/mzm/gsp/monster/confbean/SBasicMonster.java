/*     */ package mzm.gsp.monster.confbean;
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
/*     */ public class SBasicMonster implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBasicMonster> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBasicMonster> all = null;
/*     */   
/*     */   public int id;
/*     */   public int propertyTierId;
/*     */   public int level;
/*     */   public int HP;
/*     */   public int MP;
/*     */   public int PHY_ATK;
/*     */   public int PHY_DEF;
/*     */   public int MAG_ATK;
/*     */   public int MAG_DEF;
/*     */   public int PHY_CRT_LEVEL;
/*     */   public int MAG_CRT_LEVEL;
/*     */   public int PHY_CRT_DEF_LEVEL;
/*     */   public int MAG_CRT_DEF_LEVEL;
/*     */   public int PHY_CRT_RATE;
/*     */   public int MAG_CRT_RATE;
/*     */   public int HEAL_CRT_RATE;
/*     */   public int PHY_CRT;
/*     */   public int MAG_CRT;
/*     */   public int SEAL_HIT_LEVEL;
/*     */   public int SEAL_RES_LEVEL;
/*     */   public int PHY_HIT_LEVEL;
/*     */   public int PHY_DODGE_LEVEL;
/*     */   public int MAG_HIT_LEVEL;
/*     */   public int MAG_DODGE_LEVEL;
/*     */   public int SPEED;
/*     */   public int ANGER;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  47 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  48 */     this.propertyTierId = Integer.valueOf(rootElement.attributeValue("propertyTierId")).intValue();
/*  49 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  50 */     this.HP = Integer.valueOf(rootElement.attributeValue("HP")).intValue();
/*  51 */     this.MP = Integer.valueOf(rootElement.attributeValue("MP")).intValue();
/*  52 */     this.PHY_ATK = Integer.valueOf(rootElement.attributeValue("PHY_ATK")).intValue();
/*  53 */     this.PHY_DEF = Integer.valueOf(rootElement.attributeValue("PHY_DEF")).intValue();
/*  54 */     this.MAG_ATK = Integer.valueOf(rootElement.attributeValue("MAG_ATK")).intValue();
/*  55 */     this.MAG_DEF = Integer.valueOf(rootElement.attributeValue("MAG_DEF")).intValue();
/*  56 */     this.PHY_CRT_LEVEL = Integer.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL")).intValue();
/*  57 */     this.MAG_CRT_LEVEL = Integer.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL")).intValue();
/*  58 */     this.PHY_CRT_DEF_LEVEL = Integer.valueOf(rootElement.attributeValue("PHY_CRT_DEF_LEVEL")).intValue();
/*  59 */     this.MAG_CRT_DEF_LEVEL = Integer.valueOf(rootElement.attributeValue("MAG_CRT_DEF_LEVEL")).intValue();
/*  60 */     this.PHY_CRT_RATE = Integer.valueOf(rootElement.attributeValue("PHY_CRT_RATE")).intValue();
/*  61 */     this.MAG_CRT_RATE = Integer.valueOf(rootElement.attributeValue("MAG_CRT_RATE")).intValue();
/*  62 */     this.HEAL_CRT_RATE = Integer.valueOf(rootElement.attributeValue("HEAL_CRT_RATE")).intValue();
/*  63 */     this.PHY_CRT = Integer.valueOf(rootElement.attributeValue("PHY_CRT")).intValue();
/*  64 */     this.MAG_CRT = Integer.valueOf(rootElement.attributeValue("MAG_CRT")).intValue();
/*  65 */     this.SEAL_HIT_LEVEL = Integer.valueOf(rootElement.attributeValue("SEAL_HIT_LEVEL")).intValue();
/*  66 */     this.SEAL_RES_LEVEL = Integer.valueOf(rootElement.attributeValue("SEAL_RES_LEVEL")).intValue();
/*  67 */     this.PHY_HIT_LEVEL = Integer.valueOf(rootElement.attributeValue("PHY_HIT_LEVEL")).intValue();
/*  68 */     this.PHY_DODGE_LEVEL = Integer.valueOf(rootElement.attributeValue("PHY_DODGE_LEVEL")).intValue();
/*  69 */     this.MAG_HIT_LEVEL = Integer.valueOf(rootElement.attributeValue("MAG_HIT_LEVEL")).intValue();
/*  70 */     this.MAG_DODGE_LEVEL = Integer.valueOf(rootElement.attributeValue("MAG_DODGE_LEVEL")).intValue();
/*  71 */     this.SPEED = Integer.valueOf(rootElement.attributeValue("SPEED")).intValue();
/*  72 */     this.ANGER = Integer.valueOf(rootElement.attributeValue("ANGER")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _os_.marshal(this.id);
/*  78 */     _os_.marshal(this.propertyTierId);
/*  79 */     _os_.marshal(this.level);
/*  80 */     _os_.marshal(this.HP);
/*  81 */     _os_.marshal(this.MP);
/*  82 */     _os_.marshal(this.PHY_ATK);
/*  83 */     _os_.marshal(this.PHY_DEF);
/*  84 */     _os_.marshal(this.MAG_ATK);
/*  85 */     _os_.marshal(this.MAG_DEF);
/*  86 */     _os_.marshal(this.PHY_CRT_LEVEL);
/*  87 */     _os_.marshal(this.MAG_CRT_LEVEL);
/*  88 */     _os_.marshal(this.PHY_CRT_DEF_LEVEL);
/*  89 */     _os_.marshal(this.MAG_CRT_DEF_LEVEL);
/*  90 */     _os_.marshal(this.PHY_CRT_RATE);
/*  91 */     _os_.marshal(this.MAG_CRT_RATE);
/*  92 */     _os_.marshal(this.HEAL_CRT_RATE);
/*  93 */     _os_.marshal(this.PHY_CRT);
/*  94 */     _os_.marshal(this.MAG_CRT);
/*  95 */     _os_.marshal(this.SEAL_HIT_LEVEL);
/*  96 */     _os_.marshal(this.SEAL_RES_LEVEL);
/*  97 */     _os_.marshal(this.PHY_HIT_LEVEL);
/*  98 */     _os_.marshal(this.PHY_DODGE_LEVEL);
/*  99 */     _os_.marshal(this.MAG_HIT_LEVEL);
/* 100 */     _os_.marshal(this.MAG_DODGE_LEVEL);
/* 101 */     _os_.marshal(this.SPEED);
/* 102 */     _os_.marshal(this.ANGER);
/* 103 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 108 */     this.id = _os_.unmarshal_int();
/* 109 */     this.propertyTierId = _os_.unmarshal_int();
/* 110 */     this.level = _os_.unmarshal_int();
/* 111 */     this.HP = _os_.unmarshal_int();
/* 112 */     this.MP = _os_.unmarshal_int();
/* 113 */     this.PHY_ATK = _os_.unmarshal_int();
/* 114 */     this.PHY_DEF = _os_.unmarshal_int();
/* 115 */     this.MAG_ATK = _os_.unmarshal_int();
/* 116 */     this.MAG_DEF = _os_.unmarshal_int();
/* 117 */     this.PHY_CRT_LEVEL = _os_.unmarshal_int();
/* 118 */     this.MAG_CRT_LEVEL = _os_.unmarshal_int();
/* 119 */     this.PHY_CRT_DEF_LEVEL = _os_.unmarshal_int();
/* 120 */     this.MAG_CRT_DEF_LEVEL = _os_.unmarshal_int();
/* 121 */     this.PHY_CRT_RATE = _os_.unmarshal_int();
/* 122 */     this.MAG_CRT_RATE = _os_.unmarshal_int();
/* 123 */     this.HEAL_CRT_RATE = _os_.unmarshal_int();
/* 124 */     this.PHY_CRT = _os_.unmarshal_int();
/* 125 */     this.MAG_CRT = _os_.unmarshal_int();
/* 126 */     this.SEAL_HIT_LEVEL = _os_.unmarshal_int();
/* 127 */     this.SEAL_RES_LEVEL = _os_.unmarshal_int();
/* 128 */     this.PHY_HIT_LEVEL = _os_.unmarshal_int();
/* 129 */     this.PHY_DODGE_LEVEL = _os_.unmarshal_int();
/* 130 */     this.MAG_HIT_LEVEL = _os_.unmarshal_int();
/* 131 */     this.MAG_DODGE_LEVEL = _os_.unmarshal_int();
/* 132 */     this.SPEED = _os_.unmarshal_int();
/* 133 */     this.ANGER = _os_.unmarshal_int();
/* 134 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 139 */     String path = dir + "mzm.gsp.monster.confbean.SBasicMonster.xml";
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
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SBasicMonster"))
/*     */         {
/*     */ 
/* 155 */           SBasicMonster obj = new SBasicMonster();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBasicMonster> all)
/*     */   {
/* 169 */     String path = dir + "mzm.gsp.monster.confbean.SBasicMonster.xml";
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
/* 181 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.monster.confbean.SBasicMonster"))
/*     */         {
/*     */ 
/* 184 */           SBasicMonster obj = new SBasicMonster();
/* 185 */           obj.loadFromXml(elem);
/* 186 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 200 */     String path = dir + "mzm.gsp.monster.confbean.SBasicMonster.bny";
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
/* 227 */           SBasicMonster _v_ = new SBasicMonster();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SBasicMonster> all)
/*     */   {
/* 247 */     String path = dir + "mzm.gsp.monster.confbean.SBasicMonster.bny";
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
/* 274 */           SBasicMonster _v_ = new SBasicMonster();
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
/*     */   public static SBasicMonster getOld(int key)
/*     */   {
/* 295 */     return (SBasicMonster)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBasicMonster get(int key)
/*     */   {
/* 300 */     return (SBasicMonster)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBasicMonster> getOldAll()
/*     */   {
/* 305 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBasicMonster> getAll()
/*     */   {
/* 310 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBasicMonster> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\SBasicMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */