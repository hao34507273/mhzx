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
/*     */ public class SLifeSkillActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLifeSkillActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLifeSkillActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int lifeSkillId;
/*     */   public int openId;
/*     */   public int openServerLevel;
/*     */   public int openLivelyLowRate;
/*     */   public int openLifeSkillLevel;
/*     */   public int npcCfgId;
/*     */   public int npcServiceCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  30 */     this.lifeSkillId = Integer.valueOf(rootElement.attributeValue("lifeSkillId")).intValue();
/*  31 */     this.openId = Integer.valueOf(rootElement.attributeValue("openId")).intValue();
/*  32 */     this.openServerLevel = Integer.valueOf(rootElement.attributeValue("openServerLevel")).intValue();
/*  33 */     this.openLivelyLowRate = Integer.valueOf(rootElement.attributeValue("openLivelyLowRate")).intValue();
/*  34 */     this.openLifeSkillLevel = Integer.valueOf(rootElement.attributeValue("openLifeSkillLevel")).intValue();
/*  35 */     this.npcCfgId = Integer.valueOf(rootElement.attributeValue("npcCfgId")).intValue();
/*  36 */     this.npcServiceCfgId = Integer.valueOf(rootElement.attributeValue("npcServiceCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  41 */     _os_.marshal(this.activityId);
/*  42 */     _os_.marshal(this.lifeSkillId);
/*  43 */     _os_.marshal(this.openId);
/*  44 */     _os_.marshal(this.openServerLevel);
/*  45 */     _os_.marshal(this.openLivelyLowRate);
/*  46 */     _os_.marshal(this.openLifeSkillLevel);
/*  47 */     _os_.marshal(this.npcCfgId);
/*  48 */     _os_.marshal(this.npcServiceCfgId);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  54 */     this.activityId = _os_.unmarshal_int();
/*  55 */     this.lifeSkillId = _os_.unmarshal_int();
/*  56 */     this.openId = _os_.unmarshal_int();
/*  57 */     this.openServerLevel = _os_.unmarshal_int();
/*  58 */     this.openLivelyLowRate = _os_.unmarshal_int();
/*  59 */     this.openLifeSkillLevel = _os_.unmarshal_int();
/*  60 */     this.npcCfgId = _os_.unmarshal_int();
/*  61 */     this.npcServiceCfgId = _os_.unmarshal_int();
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  67 */     String path = dir + "mzm.gsp.activity4.confbean.SLifeSkillActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  71 */       all = new java.util.HashMap();
/*  72 */       SAXReader reader = new SAXReader();
/*  73 */       org.dom4j.Document doc = reader.read(new File(path));
/*  74 */       Element root = doc.getRootElement();
/*  75 */       List<?> nodeList = root.elements();
/*  76 */       int len = nodeList.size();
/*  77 */       for (int i = 0; i < len; i++)
/*     */       {
/*  79 */         Element elem = (Element)nodeList.get(i);
/*  80 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SLifeSkillActivityCfg"))
/*     */         {
/*     */ 
/*  83 */           SLifeSkillActivityCfg obj = new SLifeSkillActivityCfg();
/*  84 */           obj.loadFromXml(elem);
/*  85 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/*  86 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  91 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLifeSkillActivityCfg> all)
/*     */   {
/*  97 */     String path = dir + "mzm.gsp.activity4.confbean.SLifeSkillActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 101 */       SAXReader reader = new SAXReader();
/* 102 */       org.dom4j.Document doc = reader.read(new File(path));
/* 103 */       Element root = doc.getRootElement();
/* 104 */       List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element elem = (Element)nodeList.get(i);
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.SLifeSkillActivityCfg"))
/*     */         {
/*     */ 
/* 112 */           SLifeSkillActivityCfg obj = new SLifeSkillActivityCfg();
/* 113 */           obj.loadFromXml(elem);
/* 114 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 115 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 120 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 126 */     all = new java.util.HashMap();
/*     */     
/* 128 */     String path = dir + "mzm.gsp.activity4.confbean.SLifeSkillActivityCfg.bny";
/*     */     try
/*     */     {
/* 131 */       File file = new File(path);
/* 132 */       if (file.exists())
/*     */       {
/* 134 */         byte[] bytes = new byte['Ѐ'];
/* 135 */         FileInputStream fis = new FileInputStream(file);
/* 136 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 137 */         int len = 0;
/* 138 */         while ((len = fis.read(bytes)) > 0)
/* 139 */           baos.write(bytes, 0, len);
/* 140 */         fis.close();
/* 141 */         bytes = baos.toByteArray();
/* 142 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 143 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 145 */           _os_.unmarshal_int();
/* 146 */           _os_.unmarshal_int();
/* 147 */           _os_.unmarshal_int();
/*     */         }
/* 149 */         _os_.unmarshal_int();
/* 150 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 153 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 155 */           SLifeSkillActivityCfg _v_ = new SLifeSkillActivityCfg();
/* 156 */           _v_.unmarshal(_os_);
/* 157 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 163 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLifeSkillActivityCfg> all)
/*     */   {
/* 175 */     String path = dir + "mzm.gsp.activity4.confbean.SLifeSkillActivityCfg.bny";
/*     */     try
/*     */     {
/* 178 */       File file = new File(path);
/* 179 */       if (file.exists())
/*     */       {
/* 181 */         byte[] bytes = new byte['Ѐ'];
/* 182 */         FileInputStream fis = new FileInputStream(file);
/* 183 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 184 */         int len = 0;
/* 185 */         while ((len = fis.read(bytes)) > 0)
/* 186 */           baos.write(bytes, 0, len);
/* 187 */         fis.close();
/* 188 */         bytes = baos.toByteArray();
/* 189 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 192 */           _os_.unmarshal_int();
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/*     */         }
/* 196 */         _os_.unmarshal_int();
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 200 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 202 */           SLifeSkillActivityCfg _v_ = new SLifeSkillActivityCfg();
/* 203 */           _v_.unmarshal(_os_);
/* 204 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 205 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 210 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLifeSkillActivityCfg getOld(int key)
/*     */   {
/* 223 */     return (SLifeSkillActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLifeSkillActivityCfg get(int key)
/*     */   {
/* 228 */     return (SLifeSkillActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLifeSkillActivityCfg> getOldAll()
/*     */   {
/* 233 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLifeSkillActivityCfg> getAll()
/*     */   {
/* 238 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLifeSkillActivityCfg> newAll)
/*     */   {
/* 243 */     oldAll = all;
/* 244 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 249 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SLifeSkillActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */