/*     */ package mzm.gsp.activity.confbean;
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
/*     */ public class SJingjiPhaseCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SJingjiPhaseCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SJingjiPhaseCfg> all = null;
/*     */   
/*     */   public int pahse;
/*     */   public int id;
/*     */   public String phaseName;
/*     */   public int minWinPoint;
/*     */   public int maxWinPoint;
/*     */   public int firstWinRewardId;
/*     */   public int fiveFightRewardId;
/*     */   public int seasonRewardId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.pahse = Integer.valueOf(rootElement.attributeValue("pahse")).intValue();
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.phaseName = rootElement.attributeValue("phaseName");
/*  32 */     this.minWinPoint = Integer.valueOf(rootElement.attributeValue("minWinPoint")).intValue();
/*  33 */     this.maxWinPoint = Integer.valueOf(rootElement.attributeValue("maxWinPoint")).intValue();
/*  34 */     this.firstWinRewardId = Integer.valueOf(rootElement.attributeValue("firstWinRewardId")).intValue();
/*  35 */     this.fiveFightRewardId = Integer.valueOf(rootElement.attributeValue("fiveFightRewardId")).intValue();
/*  36 */     this.seasonRewardId = Integer.valueOf(rootElement.attributeValue("seasonRewardId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  41 */     _os_.marshal(this.pahse);
/*  42 */     _os_.marshal(this.id);
/*  43 */     _os_.marshal(this.phaseName, "UTF-8");
/*  44 */     _os_.marshal(this.minWinPoint);
/*  45 */     _os_.marshal(this.maxWinPoint);
/*  46 */     _os_.marshal(this.firstWinRewardId);
/*  47 */     _os_.marshal(this.fiveFightRewardId);
/*  48 */     _os_.marshal(this.seasonRewardId);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  54 */     this.pahse = _os_.unmarshal_int();
/*  55 */     this.id = _os_.unmarshal_int();
/*  56 */     this.phaseName = _os_.unmarshal_String("UTF-8");
/*  57 */     this.minWinPoint = _os_.unmarshal_int();
/*  58 */     this.maxWinPoint = _os_.unmarshal_int();
/*  59 */     this.firstWinRewardId = _os_.unmarshal_int();
/*  60 */     this.fiveFightRewardId = _os_.unmarshal_int();
/*  61 */     this.seasonRewardId = _os_.unmarshal_int();
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  67 */     String path = dir + "mzm.gsp.activity.confbean.SJingjiPhaseCfg.xml";
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
/*  80 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SJingjiPhaseCfg"))
/*     */         {
/*     */ 
/*  83 */           SJingjiPhaseCfg obj = new SJingjiPhaseCfg();
/*  84 */           obj.loadFromXml(elem);
/*  85 */           if (all.put(Integer.valueOf(obj.pahse), obj) != null) {
/*  86 */             throw new RuntimeException("duplicate key : " + obj.pahse);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  91 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SJingjiPhaseCfg> all)
/*     */   {
/*  97 */     String path = dir + "mzm.gsp.activity.confbean.SJingjiPhaseCfg.xml";
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
/* 109 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SJingjiPhaseCfg"))
/*     */         {
/*     */ 
/* 112 */           SJingjiPhaseCfg obj = new SJingjiPhaseCfg();
/* 113 */           obj.loadFromXml(elem);
/* 114 */           if (all.put(Integer.valueOf(obj.pahse), obj) != null) {
/* 115 */             throw new RuntimeException("duplicate key : " + obj.pahse);
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
/* 128 */     String path = dir + "mzm.gsp.activity.confbean.SJingjiPhaseCfg.bny";
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
/* 155 */           SJingjiPhaseCfg _v_ = new SJingjiPhaseCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SJingjiPhaseCfg> all)
/*     */   {
/* 175 */     String path = dir + "mzm.gsp.activity.confbean.SJingjiPhaseCfg.bny";
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
/* 202 */           SJingjiPhaseCfg _v_ = new SJingjiPhaseCfg();
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
/*     */   public static SJingjiPhaseCfg getOld(int key)
/*     */   {
/* 223 */     return (SJingjiPhaseCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SJingjiPhaseCfg get(int key)
/*     */   {
/* 228 */     return (SJingjiPhaseCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SJingjiPhaseCfg> getOldAll()
/*     */   {
/* 233 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SJingjiPhaseCfg> getAll()
/*     */   {
/* 238 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SJingjiPhaseCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SJingjiPhaseCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */