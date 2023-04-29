/*     */ package mzm.gsp.npc.confbean;
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
/*     */ public class SServiceConditon implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SServiceConditon> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SServiceConditon> all = null;
/*     */   
/*     */   public int id;
/*     */   public int teamNumMin;
/*     */   public int teamNumMax;
/*     */   public int teamState;
/*     */   public int menpai;
/*     */   public int sex;
/*     */   public int levelMax;
/*     */   public int levelMin;
/*     */   public int teamLevelMin;
/*     */   public int factionState;
/*     */   public int marriedState;
/*     */   public int forceDivorce;
/*     */   public int jieBaiState;
/*     */   public int bianShenState;
/*     */   public int shiTuState;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.teamNumMin = Integer.valueOf(rootElement.attributeValue("teamNumMin")).intValue();
/*  38 */     this.teamNumMax = Integer.valueOf(rootElement.attributeValue("teamNumMax")).intValue();
/*  39 */     this.teamState = Integer.valueOf(rootElement.attributeValue("teamState")).intValue();
/*  40 */     this.menpai = Integer.valueOf(rootElement.attributeValue("menpai")).intValue();
/*  41 */     this.sex = Integer.valueOf(rootElement.attributeValue("sex")).intValue();
/*  42 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*  43 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  44 */     this.teamLevelMin = Integer.valueOf(rootElement.attributeValue("teamLevelMin")).intValue();
/*  45 */     this.factionState = Integer.valueOf(rootElement.attributeValue("factionState")).intValue();
/*  46 */     this.marriedState = Integer.valueOf(rootElement.attributeValue("marriedState")).intValue();
/*  47 */     this.forceDivorce = Integer.valueOf(rootElement.attributeValue("forceDivorce")).intValue();
/*  48 */     this.jieBaiState = Integer.valueOf(rootElement.attributeValue("jieBaiState")).intValue();
/*  49 */     this.bianShenState = Integer.valueOf(rootElement.attributeValue("bianShenState")).intValue();
/*  50 */     this.shiTuState = Integer.valueOf(rootElement.attributeValue("shiTuState")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.teamNumMin);
/*  57 */     _os_.marshal(this.teamNumMax);
/*  58 */     _os_.marshal(this.teamState);
/*  59 */     _os_.marshal(this.menpai);
/*  60 */     _os_.marshal(this.sex);
/*  61 */     _os_.marshal(this.levelMax);
/*  62 */     _os_.marshal(this.levelMin);
/*  63 */     _os_.marshal(this.teamLevelMin);
/*  64 */     _os_.marshal(this.factionState);
/*  65 */     _os_.marshal(this.marriedState);
/*  66 */     _os_.marshal(this.forceDivorce);
/*  67 */     _os_.marshal(this.jieBaiState);
/*  68 */     _os_.marshal(this.bianShenState);
/*  69 */     _os_.marshal(this.shiTuState);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.teamNumMin = _os_.unmarshal_int();
/*  77 */     this.teamNumMax = _os_.unmarshal_int();
/*  78 */     this.teamState = _os_.unmarshal_int();
/*  79 */     this.menpai = _os_.unmarshal_int();
/*  80 */     this.sex = _os_.unmarshal_int();
/*  81 */     this.levelMax = _os_.unmarshal_int();
/*  82 */     this.levelMin = _os_.unmarshal_int();
/*  83 */     this.teamLevelMin = _os_.unmarshal_int();
/*  84 */     this.factionState = _os_.unmarshal_int();
/*  85 */     this.marriedState = _os_.unmarshal_int();
/*  86 */     this.forceDivorce = _os_.unmarshal_int();
/*  87 */     this.jieBaiState = _os_.unmarshal_int();
/*  88 */     this.bianShenState = _os_.unmarshal_int();
/*  89 */     this.shiTuState = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.npc.confbean.SServiceConditon.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.SServiceConditon"))
/*     */         {
/*     */ 
/* 111 */           SServiceConditon obj = new SServiceConditon();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SServiceConditon> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.npc.confbean.SServiceConditon.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.SServiceConditon"))
/*     */         {
/*     */ 
/* 140 */           SServiceConditon obj = new SServiceConditon();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.npc.confbean.SServiceConditon.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           SServiceConditon _v_ = new SServiceConditon();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SServiceConditon> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.npc.confbean.SServiceConditon.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           SServiceConditon _v_ = new SServiceConditon();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SServiceConditon getOld(int key)
/*     */   {
/* 251 */     return (SServiceConditon)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SServiceConditon get(int key)
/*     */   {
/* 256 */     return (SServiceConditon)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SServiceConditon> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SServiceConditon> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SServiceConditon> newAll)
/*     */   {
/* 271 */     oldAll = all;
/* 272 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 277 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\confbean\SServiceConditon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */