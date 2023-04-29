/*     */ package mzm.gsp.indiana.confbean;
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
/*     */ public class IndianaCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, IndianaCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, IndianaCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int lottery_item_cfg_id;
/*     */   public int turn;
/*     */   public int sortid;
/*     */   public int cost_money_type;
/*     */   public int cost_money_num;
/*     */   public int special_number_need_yuanbao_num;
/*     */   public int attend_fix_award_id;
/*     */   public int fix_award_id;
/*     */   public int init_award_num;
/*     */   public int extra_award_need_num;
/*     */   public boolean need_log;
/*     */   public boolean need_bulletin;
/*     */   public int expansion_factor_percentage;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  38 */     this.desc = rootElement.attributeValue("desc");
/*  39 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  40 */     this.lottery_item_cfg_id = Integer.valueOf(rootElement.attributeValue("lottery_item_cfg_id")).intValue();
/*  41 */     this.turn = Integer.valueOf(rootElement.attributeValue("turn")).intValue();
/*  42 */     this.sortid = Integer.valueOf(rootElement.attributeValue("sortid")).intValue();
/*  43 */     this.cost_money_type = Integer.valueOf(rootElement.attributeValue("cost_money_type")).intValue();
/*  44 */     this.cost_money_num = Integer.valueOf(rootElement.attributeValue("cost_money_num")).intValue();
/*  45 */     this.special_number_need_yuanbao_num = Integer.valueOf(rootElement.attributeValue("special_number_need_yuanbao_num")).intValue();
/*  46 */     this.attend_fix_award_id = Integer.valueOf(rootElement.attributeValue("attend_fix_award_id")).intValue();
/*  47 */     this.fix_award_id = Integer.valueOf(rootElement.attributeValue("fix_award_id")).intValue();
/*  48 */     this.init_award_num = Integer.valueOf(rootElement.attributeValue("init_award_num")).intValue();
/*  49 */     this.extra_award_need_num = Integer.valueOf(rootElement.attributeValue("extra_award_need_num")).intValue();
/*  50 */     this.need_log = Boolean.valueOf(rootElement.attributeValue("need_log")).booleanValue();
/*  51 */     this.need_bulletin = Boolean.valueOf(rootElement.attributeValue("need_bulletin")).booleanValue();
/*  52 */     this.expansion_factor_percentage = Integer.valueOf(rootElement.attributeValue("expansion_factor_percentage")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.id);
/*  58 */     _os_.marshal(this.desc, "UTF-8");
/*  59 */     _os_.marshal(this.activity_cfg_id);
/*  60 */     _os_.marshal(this.lottery_item_cfg_id);
/*  61 */     _os_.marshal(this.turn);
/*  62 */     _os_.marshal(this.sortid);
/*  63 */     _os_.marshal(this.cost_money_type);
/*  64 */     _os_.marshal(this.cost_money_num);
/*  65 */     _os_.marshal(this.special_number_need_yuanbao_num);
/*  66 */     _os_.marshal(this.attend_fix_award_id);
/*  67 */     _os_.marshal(this.fix_award_id);
/*  68 */     _os_.marshal(this.init_award_num);
/*  69 */     _os_.marshal(this.extra_award_need_num);
/*  70 */     _os_.marshal(this.need_log);
/*  71 */     _os_.marshal(this.need_bulletin);
/*  72 */     _os_.marshal(this.expansion_factor_percentage);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  80 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  81 */     this.lottery_item_cfg_id = _os_.unmarshal_int();
/*  82 */     this.turn = _os_.unmarshal_int();
/*  83 */     this.sortid = _os_.unmarshal_int();
/*  84 */     this.cost_money_type = _os_.unmarshal_int();
/*  85 */     this.cost_money_num = _os_.unmarshal_int();
/*  86 */     this.special_number_need_yuanbao_num = _os_.unmarshal_int();
/*  87 */     this.attend_fix_award_id = _os_.unmarshal_int();
/*  88 */     this.fix_award_id = _os_.unmarshal_int();
/*  89 */     this.init_award_num = _os_.unmarshal_int();
/*  90 */     this.extra_award_need_num = _os_.unmarshal_int();
/*  91 */     this.need_log = _os_.unmarshal_boolean();
/*  92 */     this.need_bulletin = _os_.unmarshal_boolean();
/*  93 */     this.expansion_factor_percentage = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.indiana.confbean.IndianaCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 103 */       all = new java.util.HashMap();
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       List<?> nodeList = root.elements();
/* 108 */       int len = nodeList.size();
/* 109 */       for (int i = 0; i < len; i++)
/*     */       {
/* 111 */         Element elem = (Element)nodeList.get(i);
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.indiana.confbean.IndianaCfgOriginal"))
/*     */         {
/*     */ 
/* 115 */           IndianaCfgOriginal obj = new IndianaCfgOriginal();
/* 116 */           obj.loadFromXml(elem);
/* 117 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 118 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, IndianaCfgOriginal> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.indiana.confbean.IndianaCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.indiana.confbean.IndianaCfgOriginal"))
/*     */         {
/*     */ 
/* 144 */           IndianaCfgOriginal obj = new IndianaCfgOriginal();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 158 */     all = new java.util.HashMap();
/*     */     
/* 160 */     String path = dir + "mzm.gsp.indiana.confbean.IndianaCfgOriginal.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 177 */           _os_.unmarshal_int();
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/*     */         }
/* 181 */         _os_.unmarshal_int();
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 185 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 187 */           IndianaCfgOriginal _v_ = new IndianaCfgOriginal();
/* 188 */           _v_.unmarshal(_os_);
/* 189 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 190 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 195 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, IndianaCfgOriginal> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.indiana.confbean.IndianaCfgOriginal.bny";
/*     */     try
/*     */     {
/* 210 */       File file = new File(path);
/* 211 */       if (file.exists())
/*     */       {
/* 213 */         byte[] bytes = new byte['Ѐ'];
/* 214 */         FileInputStream fis = new FileInputStream(file);
/* 215 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 216 */         int len = 0;
/* 217 */         while ((len = fis.read(bytes)) > 0)
/* 218 */           baos.write(bytes, 0, len);
/* 219 */         fis.close();
/* 220 */         bytes = baos.toByteArray();
/* 221 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/*     */         }
/* 228 */         _os_.unmarshal_int();
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 232 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 234 */           IndianaCfgOriginal _v_ = new IndianaCfgOriginal();
/* 235 */           _v_.unmarshal(_os_);
/* 236 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 237 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 242 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static IndianaCfgOriginal getOld(int key)
/*     */   {
/* 255 */     return (IndianaCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static IndianaCfgOriginal get(int key)
/*     */   {
/* 260 */     return (IndianaCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, IndianaCfgOriginal> getOldAll()
/*     */   {
/* 265 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, IndianaCfgOriginal> getAll()
/*     */   {
/* 270 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, IndianaCfgOriginal> newAll)
/*     */   {
/* 275 */     oldAll = all;
/* 276 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 281 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\confbean\IndianaCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */