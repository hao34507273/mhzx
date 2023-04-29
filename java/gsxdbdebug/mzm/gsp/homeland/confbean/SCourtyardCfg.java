/*     */ package mzm.gsp.homeland.confbean;
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
/*     */ public class SCourtyardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCourtyardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCourtyardCfg> all = null;
/*     */   
/*     */   public int level;
/*     */   public int id;
/*     */   public int moneyType;
/*     */   public int moneyNum;
/*     */   public int mapId;
/*     */   public int offSetX;
/*     */   public int offSetY;
/*     */   public int npcX;
/*     */   public int npcY;
/*     */   public int npcDir;
/*     */   public int transferX;
/*     */   public int transferY;
/*     */   public int day_clean_max_count;
/*     */   public int add_cleanliness;
/*     */   public int clean_money_type;
/*     */   public int clean_need_money_num_every_cleanliness;
/*     */   public int day_cut_cleanliness;
/*     */   public int max_cleanliness;
/*     */   public int max_beautifual;
/*     */   public int animal_give_birth_x;
/*     */   public int aninal_give_birth_y;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  42 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  43 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  44 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/*  45 */     this.moneyNum = Integer.valueOf(rootElement.attributeValue("moneyNum")).intValue();
/*  46 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/*  47 */     this.offSetX = Integer.valueOf(rootElement.attributeValue("offSetX")).intValue();
/*  48 */     this.offSetY = Integer.valueOf(rootElement.attributeValue("offSetY")).intValue();
/*  49 */     this.npcX = Integer.valueOf(rootElement.attributeValue("npcX")).intValue();
/*  50 */     this.npcY = Integer.valueOf(rootElement.attributeValue("npcY")).intValue();
/*  51 */     this.npcDir = Integer.valueOf(rootElement.attributeValue("npcDir")).intValue();
/*  52 */     this.transferX = Integer.valueOf(rootElement.attributeValue("transferX")).intValue();
/*  53 */     this.transferY = Integer.valueOf(rootElement.attributeValue("transferY")).intValue();
/*  54 */     this.day_clean_max_count = Integer.valueOf(rootElement.attributeValue("day_clean_max_count")).intValue();
/*  55 */     this.add_cleanliness = Integer.valueOf(rootElement.attributeValue("add_cleanliness")).intValue();
/*  56 */     this.clean_money_type = Integer.valueOf(rootElement.attributeValue("clean_money_type")).intValue();
/*  57 */     this.clean_need_money_num_every_cleanliness = Integer.valueOf(rootElement.attributeValue("clean_need_money_num_every_cleanliness")).intValue();
/*  58 */     this.day_cut_cleanliness = Integer.valueOf(rootElement.attributeValue("day_cut_cleanliness")).intValue();
/*  59 */     this.max_cleanliness = Integer.valueOf(rootElement.attributeValue("max_cleanliness")).intValue();
/*  60 */     this.max_beautifual = Integer.valueOf(rootElement.attributeValue("max_beautifual")).intValue();
/*  61 */     this.animal_give_birth_x = Integer.valueOf(rootElement.attributeValue("animal_give_birth_x")).intValue();
/*  62 */     this.aninal_give_birth_y = Integer.valueOf(rootElement.attributeValue("aninal_give_birth_y")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.level);
/*  68 */     _os_.marshal(this.id);
/*  69 */     _os_.marshal(this.moneyType);
/*  70 */     _os_.marshal(this.moneyNum);
/*  71 */     _os_.marshal(this.mapId);
/*  72 */     _os_.marshal(this.offSetX);
/*  73 */     _os_.marshal(this.offSetY);
/*  74 */     _os_.marshal(this.npcX);
/*  75 */     _os_.marshal(this.npcY);
/*  76 */     _os_.marshal(this.npcDir);
/*  77 */     _os_.marshal(this.transferX);
/*  78 */     _os_.marshal(this.transferY);
/*  79 */     _os_.marshal(this.day_clean_max_count);
/*  80 */     _os_.marshal(this.add_cleanliness);
/*  81 */     _os_.marshal(this.clean_money_type);
/*  82 */     _os_.marshal(this.clean_need_money_num_every_cleanliness);
/*  83 */     _os_.marshal(this.day_cut_cleanliness);
/*  84 */     _os_.marshal(this.max_cleanliness);
/*  85 */     _os_.marshal(this.max_beautifual);
/*  86 */     _os_.marshal(this.animal_give_birth_x);
/*  87 */     _os_.marshal(this.aninal_give_birth_y);
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  93 */     this.level = _os_.unmarshal_int();
/*  94 */     this.id = _os_.unmarshal_int();
/*  95 */     this.moneyType = _os_.unmarshal_int();
/*  96 */     this.moneyNum = _os_.unmarshal_int();
/*  97 */     this.mapId = _os_.unmarshal_int();
/*  98 */     this.offSetX = _os_.unmarshal_int();
/*  99 */     this.offSetY = _os_.unmarshal_int();
/* 100 */     this.npcX = _os_.unmarshal_int();
/* 101 */     this.npcY = _os_.unmarshal_int();
/* 102 */     this.npcDir = _os_.unmarshal_int();
/* 103 */     this.transferX = _os_.unmarshal_int();
/* 104 */     this.transferY = _os_.unmarshal_int();
/* 105 */     this.day_clean_max_count = _os_.unmarshal_int();
/* 106 */     this.add_cleanliness = _os_.unmarshal_int();
/* 107 */     this.clean_money_type = _os_.unmarshal_int();
/* 108 */     this.clean_need_money_num_every_cleanliness = _os_.unmarshal_int();
/* 109 */     this.day_cut_cleanliness = _os_.unmarshal_int();
/* 110 */     this.max_cleanliness = _os_.unmarshal_int();
/* 111 */     this.max_beautifual = _os_.unmarshal_int();
/* 112 */     this.animal_give_birth_x = _os_.unmarshal_int();
/* 113 */     this.aninal_give_birth_y = _os_.unmarshal_int();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 119 */     String path = dir + "mzm.gsp.homeland.confbean.SCourtyardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 123 */       all = new java.util.HashMap();
/* 124 */       SAXReader reader = new SAXReader();
/* 125 */       org.dom4j.Document doc = reader.read(new File(path));
/* 126 */       Element root = doc.getRootElement();
/* 127 */       List<?> nodeList = root.elements();
/* 128 */       int len = nodeList.size();
/* 129 */       for (int i = 0; i < len; i++)
/*     */       {
/* 131 */         Element elem = (Element)nodeList.get(i);
/* 132 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SCourtyardCfg"))
/*     */         {
/*     */ 
/* 135 */           SCourtyardCfg obj = new SCourtyardCfg();
/* 136 */           obj.loadFromXml(elem);
/* 137 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 138 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 143 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCourtyardCfg> all)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.homeland.confbean.SCourtyardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       SAXReader reader = new SAXReader();
/* 154 */       org.dom4j.Document doc = reader.read(new File(path));
/* 155 */       Element root = doc.getRootElement();
/* 156 */       List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element elem = (Element)nodeList.get(i);
/* 161 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SCourtyardCfg"))
/*     */         {
/*     */ 
/* 164 */           SCourtyardCfg obj = new SCourtyardCfg();
/* 165 */           obj.loadFromXml(elem);
/* 166 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 167 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 178 */     all = new java.util.HashMap();
/*     */     
/* 180 */     String path = dir + "mzm.gsp.homeland.confbean.SCourtyardCfg.bny";
/*     */     try
/*     */     {
/* 183 */       File file = new File(path);
/* 184 */       if (file.exists())
/*     */       {
/* 186 */         byte[] bytes = new byte['Ѐ'];
/* 187 */         FileInputStream fis = new FileInputStream(file);
/* 188 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 189 */         int len = 0;
/* 190 */         while ((len = fis.read(bytes)) > 0)
/* 191 */           baos.write(bytes, 0, len);
/* 192 */         fis.close();
/* 193 */         bytes = baos.toByteArray();
/* 194 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/* 199 */           _os_.unmarshal_int();
/*     */         }
/* 201 */         _os_.unmarshal_int();
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 205 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 207 */           SCourtyardCfg _v_ = new SCourtyardCfg();
/* 208 */           _v_.unmarshal(_os_);
/* 209 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 215 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCourtyardCfg> all)
/*     */   {
/* 227 */     String path = dir + "mzm.gsp.homeland.confbean.SCourtyardCfg.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           SCourtyardCfg _v_ = new SCourtyardCfg();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCourtyardCfg getOld(int key)
/*     */   {
/* 275 */     return (SCourtyardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCourtyardCfg get(int key)
/*     */   {
/* 280 */     return (SCourtyardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCourtyardCfg> getOldAll()
/*     */   {
/* 285 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCourtyardCfg> getAll()
/*     */   {
/* 290 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCourtyardCfg> newAll)
/*     */   {
/* 295 */     oldAll = all;
/* 296 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 301 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SCourtyardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */