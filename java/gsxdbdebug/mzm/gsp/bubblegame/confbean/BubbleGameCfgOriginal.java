/*     */ package mzm.gsp.bubblegame.confbean;
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
/*     */ public class BubbleGameCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, BubbleGameCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, BubbleGameCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int game_id;
/*     */   public int moduleid;
/*     */   public int turn_sum;
/*     */   public int game_time;
/*     */   public int game_over_effect_id;
/*     */   public int right_award_id;
/*     */   public int wrong_award_id;
/*     */   public int point_upper_limit;
/*     */   public int right_point;
/*     */   public int wrong_point;
/*     */   public int tips_content_id;
/*     */   public String ui_id;
/*     */   public int model_id;
/*     */   public int tips_time;
/*     */   public int countdown_time;
/*     */   public int sort_id;
/*     */   public int duration;
/*     */   public int drop_duration_ms;
/*     */   public int drop_interval_ms;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  43 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  44 */     this.name = rootElement.attributeValue("name");
/*  45 */     this.desc = rootElement.attributeValue("desc");
/*  46 */     this.game_id = Integer.valueOf(rootElement.attributeValue("game_id")).intValue();
/*  47 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  48 */     this.turn_sum = Integer.valueOf(rootElement.attributeValue("turn_sum")).intValue();
/*  49 */     this.game_time = Integer.valueOf(rootElement.attributeValue("game_time")).intValue();
/*  50 */     this.game_over_effect_id = Integer.valueOf(rootElement.attributeValue("game_over_effect_id")).intValue();
/*  51 */     this.right_award_id = Integer.valueOf(rootElement.attributeValue("right_award_id")).intValue();
/*  52 */     this.wrong_award_id = Integer.valueOf(rootElement.attributeValue("wrong_award_id")).intValue();
/*  53 */     this.point_upper_limit = Integer.valueOf(rootElement.attributeValue("point_upper_limit")).intValue();
/*  54 */     this.right_point = Integer.valueOf(rootElement.attributeValue("right_point")).intValue();
/*  55 */     this.wrong_point = Integer.valueOf(rootElement.attributeValue("wrong_point")).intValue();
/*  56 */     this.tips_content_id = Integer.valueOf(rootElement.attributeValue("tips_content_id")).intValue();
/*  57 */     this.ui_id = rootElement.attributeValue("ui_id");
/*  58 */     this.model_id = Integer.valueOf(rootElement.attributeValue("model_id")).intValue();
/*  59 */     this.tips_time = Integer.valueOf(rootElement.attributeValue("tips_time")).intValue();
/*  60 */     this.countdown_time = Integer.valueOf(rootElement.attributeValue("countdown_time")).intValue();
/*  61 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  62 */     this.duration = Integer.valueOf(rootElement.attributeValue("duration")).intValue();
/*  63 */     this.drop_duration_ms = Integer.valueOf(rootElement.attributeValue("drop_duration_ms")).intValue();
/*  64 */     this.drop_interval_ms = Integer.valueOf(rootElement.attributeValue("drop_interval_ms")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _os_.marshal(this.id);
/*  70 */     _os_.marshal(this.name, "UTF-8");
/*  71 */     _os_.marshal(this.desc, "UTF-8");
/*  72 */     _os_.marshal(this.game_id);
/*  73 */     _os_.marshal(this.moduleid);
/*  74 */     _os_.marshal(this.turn_sum);
/*  75 */     _os_.marshal(this.game_time);
/*  76 */     _os_.marshal(this.game_over_effect_id);
/*  77 */     _os_.marshal(this.right_award_id);
/*  78 */     _os_.marshal(this.wrong_award_id);
/*  79 */     _os_.marshal(this.point_upper_limit);
/*  80 */     _os_.marshal(this.right_point);
/*  81 */     _os_.marshal(this.wrong_point);
/*  82 */     _os_.marshal(this.tips_content_id);
/*  83 */     _os_.marshal(this.ui_id, "UTF-8");
/*  84 */     _os_.marshal(this.model_id);
/*  85 */     _os_.marshal(this.tips_time);
/*  86 */     _os_.marshal(this.countdown_time);
/*  87 */     _os_.marshal(this.sort_id);
/*  88 */     _os_.marshal(this.duration);
/*  89 */     _os_.marshal(this.drop_duration_ms);
/*  90 */     _os_.marshal(this.drop_interval_ms);
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     this.id = _os_.unmarshal_int();
/*  97 */     this.name = _os_.unmarshal_String("UTF-8");
/*  98 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  99 */     this.game_id = _os_.unmarshal_int();
/* 100 */     this.moduleid = _os_.unmarshal_int();
/* 101 */     this.turn_sum = _os_.unmarshal_int();
/* 102 */     this.game_time = _os_.unmarshal_int();
/* 103 */     this.game_over_effect_id = _os_.unmarshal_int();
/* 104 */     this.right_award_id = _os_.unmarshal_int();
/* 105 */     this.wrong_award_id = _os_.unmarshal_int();
/* 106 */     this.point_upper_limit = _os_.unmarshal_int();
/* 107 */     this.right_point = _os_.unmarshal_int();
/* 108 */     this.wrong_point = _os_.unmarshal_int();
/* 109 */     this.tips_content_id = _os_.unmarshal_int();
/* 110 */     this.ui_id = _os_.unmarshal_String("UTF-8");
/* 111 */     this.model_id = _os_.unmarshal_int();
/* 112 */     this.tips_time = _os_.unmarshal_int();
/* 113 */     this.countdown_time = _os_.unmarshal_int();
/* 114 */     this.sort_id = _os_.unmarshal_int();
/* 115 */     this.duration = _os_.unmarshal_int();
/* 116 */     this.drop_duration_ms = _os_.unmarshal_int();
/* 117 */     this.drop_interval_ms = _os_.unmarshal_int();
/* 118 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 123 */     String path = dir + "mzm.gsp.bubblegame.confbean.BubbleGameCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 127 */       all = new java.util.HashMap();
/* 128 */       SAXReader reader = new SAXReader();
/* 129 */       org.dom4j.Document doc = reader.read(new File(path));
/* 130 */       Element root = doc.getRootElement();
/* 131 */       List<?> nodeList = root.elements();
/* 132 */       int len = nodeList.size();
/* 133 */       for (int i = 0; i < len; i++)
/*     */       {
/* 135 */         Element elem = (Element)nodeList.get(i);
/* 136 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.bubblegame.confbean.BubbleGameCfgOriginal"))
/*     */         {
/*     */ 
/* 139 */           BubbleGameCfgOriginal obj = new BubbleGameCfgOriginal();
/* 140 */           obj.loadFromXml(elem);
/* 141 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 142 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 147 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, BubbleGameCfgOriginal> all)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.bubblegame.confbean.BubbleGameCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 157 */       SAXReader reader = new SAXReader();
/* 158 */       org.dom4j.Document doc = reader.read(new File(path));
/* 159 */       Element root = doc.getRootElement();
/* 160 */       List<?> nodeList = root.elements();
/* 161 */       int len = nodeList.size();
/* 162 */       for (int i = 0; i < len; i++)
/*     */       {
/* 164 */         Element elem = (Element)nodeList.get(i);
/* 165 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.bubblegame.confbean.BubbleGameCfgOriginal"))
/*     */         {
/*     */ 
/* 168 */           BubbleGameCfgOriginal obj = new BubbleGameCfgOriginal();
/* 169 */           obj.loadFromXml(elem);
/* 170 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 182 */     all = new java.util.HashMap();
/*     */     
/* 184 */     String path = dir + "mzm.gsp.bubblegame.confbean.BubbleGameCfgOriginal.bny";
/*     */     try
/*     */     {
/* 187 */       File file = new File(path);
/* 188 */       if (file.exists())
/*     */       {
/* 190 */         byte[] bytes = new byte['Ѐ'];
/* 191 */         FileInputStream fis = new FileInputStream(file);
/* 192 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 193 */         int len = 0;
/* 194 */         while ((len = fis.read(bytes)) > 0)
/* 195 */           baos.write(bytes, 0, len);
/* 196 */         fis.close();
/* 197 */         bytes = baos.toByteArray();
/* 198 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/* 203 */           _os_.unmarshal_int();
/*     */         }
/* 205 */         _os_.unmarshal_int();
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 209 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 211 */           BubbleGameCfgOriginal _v_ = new BubbleGameCfgOriginal();
/* 212 */           _v_.unmarshal(_os_);
/* 213 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 219 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 224 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, BubbleGameCfgOriginal> all)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.bubblegame.confbean.BubbleGameCfgOriginal.bny";
/*     */     try
/*     */     {
/* 234 */       File file = new File(path);
/* 235 */       if (file.exists())
/*     */       {
/* 237 */         byte[] bytes = new byte['Ѐ'];
/* 238 */         FileInputStream fis = new FileInputStream(file);
/* 239 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 240 */         int len = 0;
/* 241 */         while ((len = fis.read(bytes)) > 0)
/* 242 */           baos.write(bytes, 0, len);
/* 243 */         fis.close();
/* 244 */         bytes = baos.toByteArray();
/* 245 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 246 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 248 */           _os_.unmarshal_int();
/* 249 */           _os_.unmarshal_int();
/* 250 */           _os_.unmarshal_int();
/*     */         }
/* 252 */         _os_.unmarshal_int();
/* 253 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 256 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 258 */           BubbleGameCfgOriginal _v_ = new BubbleGameCfgOriginal();
/* 259 */           _v_.unmarshal(_os_);
/* 260 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 261 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 266 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 271 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static BubbleGameCfgOriginal getOld(int key)
/*     */   {
/* 279 */     return (BubbleGameCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static BubbleGameCfgOriginal get(int key)
/*     */   {
/* 284 */     return (BubbleGameCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, BubbleGameCfgOriginal> getOldAll()
/*     */   {
/* 289 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, BubbleGameCfgOriginal> getAll()
/*     */   {
/* 294 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, BubbleGameCfgOriginal> newAll)
/*     */   {
/* 299 */     oldAll = all;
/* 300 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 305 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\confbean\BubbleGameCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */