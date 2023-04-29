/*     */ package mzm.gsp.musicgame.confbean;
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
/*     */ public class MusicGameCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, MusicGameCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, MusicGameCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int game_id;
/*     */   public int moduleid;
/*     */   public int game_type;
/*     */   public int turn_sum;
/*     */   public int game_max_time_ms;
/*     */   public int musical_scale_lighting_duration_ms;
/*     */   public int wrong_effect_id;
/*     */   public int wrong_music_id;
/*     */   public int right_award_id;
/*     */   public int wrong_award_id;
/*     */   public int point_upper_limit;
/*     */   public int right_point;
/*     */   public int wrong_point;
/*     */   public int tips_content_id;
/*     */   public String ui_id;
/*     */   public int countdown_length;
/*     */   public int sort_id;
/*     */   public int musical_scale;
/*     */   public int interval_ms;
/*     */   public int effect_id;
/*     */   public int music_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  45 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  46 */     this.name = rootElement.attributeValue("name");
/*  47 */     this.desc = rootElement.attributeValue("desc");
/*  48 */     this.game_id = Integer.valueOf(rootElement.attributeValue("game_id")).intValue();
/*  49 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  50 */     this.game_type = Integer.valueOf(rootElement.attributeValue("game_type")).intValue();
/*  51 */     this.turn_sum = Integer.valueOf(rootElement.attributeValue("turn_sum")).intValue();
/*  52 */     this.game_max_time_ms = Integer.valueOf(rootElement.attributeValue("game_max_time_ms")).intValue();
/*  53 */     this.musical_scale_lighting_duration_ms = Integer.valueOf(rootElement.attributeValue("musical_scale_lighting_duration_ms")).intValue();
/*  54 */     this.wrong_effect_id = Integer.valueOf(rootElement.attributeValue("wrong_effect_id")).intValue();
/*  55 */     this.wrong_music_id = Integer.valueOf(rootElement.attributeValue("wrong_music_id")).intValue();
/*  56 */     this.right_award_id = Integer.valueOf(rootElement.attributeValue("right_award_id")).intValue();
/*  57 */     this.wrong_award_id = Integer.valueOf(rootElement.attributeValue("wrong_award_id")).intValue();
/*  58 */     this.point_upper_limit = Integer.valueOf(rootElement.attributeValue("point_upper_limit")).intValue();
/*  59 */     this.right_point = Integer.valueOf(rootElement.attributeValue("right_point")).intValue();
/*  60 */     this.wrong_point = Integer.valueOf(rootElement.attributeValue("wrong_point")).intValue();
/*  61 */     this.tips_content_id = Integer.valueOf(rootElement.attributeValue("tips_content_id")).intValue();
/*  62 */     this.ui_id = rootElement.attributeValue("ui_id");
/*  63 */     this.countdown_length = Integer.valueOf(rootElement.attributeValue("countdown_length")).intValue();
/*  64 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  65 */     this.musical_scale = Integer.valueOf(rootElement.attributeValue("musical_scale")).intValue();
/*  66 */     this.interval_ms = Integer.valueOf(rootElement.attributeValue("interval_ms")).intValue();
/*  67 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  68 */     this.music_id = Integer.valueOf(rootElement.attributeValue("music_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  73 */     _os_.marshal(this.id);
/*  74 */     _os_.marshal(this.name, "UTF-8");
/*  75 */     _os_.marshal(this.desc, "UTF-8");
/*  76 */     _os_.marshal(this.game_id);
/*  77 */     _os_.marshal(this.moduleid);
/*  78 */     _os_.marshal(this.game_type);
/*  79 */     _os_.marshal(this.turn_sum);
/*  80 */     _os_.marshal(this.game_max_time_ms);
/*  81 */     _os_.marshal(this.musical_scale_lighting_duration_ms);
/*  82 */     _os_.marshal(this.wrong_effect_id);
/*  83 */     _os_.marshal(this.wrong_music_id);
/*  84 */     _os_.marshal(this.right_award_id);
/*  85 */     _os_.marshal(this.wrong_award_id);
/*  86 */     _os_.marshal(this.point_upper_limit);
/*  87 */     _os_.marshal(this.right_point);
/*  88 */     _os_.marshal(this.wrong_point);
/*  89 */     _os_.marshal(this.tips_content_id);
/*  90 */     _os_.marshal(this.ui_id, "UTF-8");
/*  91 */     _os_.marshal(this.countdown_length);
/*  92 */     _os_.marshal(this.sort_id);
/*  93 */     _os_.marshal(this.musical_scale);
/*  94 */     _os_.marshal(this.interval_ms);
/*  95 */     _os_.marshal(this.effect_id);
/*  96 */     _os_.marshal(this.music_id);
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 102 */     this.id = _os_.unmarshal_int();
/* 103 */     this.name = _os_.unmarshal_String("UTF-8");
/* 104 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 105 */     this.game_id = _os_.unmarshal_int();
/* 106 */     this.moduleid = _os_.unmarshal_int();
/* 107 */     this.game_type = _os_.unmarshal_int();
/* 108 */     this.turn_sum = _os_.unmarshal_int();
/* 109 */     this.game_max_time_ms = _os_.unmarshal_int();
/* 110 */     this.musical_scale_lighting_duration_ms = _os_.unmarshal_int();
/* 111 */     this.wrong_effect_id = _os_.unmarshal_int();
/* 112 */     this.wrong_music_id = _os_.unmarshal_int();
/* 113 */     this.right_award_id = _os_.unmarshal_int();
/* 114 */     this.wrong_award_id = _os_.unmarshal_int();
/* 115 */     this.point_upper_limit = _os_.unmarshal_int();
/* 116 */     this.right_point = _os_.unmarshal_int();
/* 117 */     this.wrong_point = _os_.unmarshal_int();
/* 118 */     this.tips_content_id = _os_.unmarshal_int();
/* 119 */     this.ui_id = _os_.unmarshal_String("UTF-8");
/* 120 */     this.countdown_length = _os_.unmarshal_int();
/* 121 */     this.sort_id = _os_.unmarshal_int();
/* 122 */     this.musical_scale = _os_.unmarshal_int();
/* 123 */     this.interval_ms = _os_.unmarshal_int();
/* 124 */     this.effect_id = _os_.unmarshal_int();
/* 125 */     this.music_id = _os_.unmarshal_int();
/* 126 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 131 */     String path = dir + "mzm.gsp.musicgame.confbean.MusicGameCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 135 */       all = new java.util.HashMap();
/* 136 */       SAXReader reader = new SAXReader();
/* 137 */       org.dom4j.Document doc = reader.read(new File(path));
/* 138 */       Element root = doc.getRootElement();
/* 139 */       List<?> nodeList = root.elements();
/* 140 */       int len = nodeList.size();
/* 141 */       for (int i = 0; i < len; i++)
/*     */       {
/* 143 */         Element elem = (Element)nodeList.get(i);
/* 144 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.musicgame.confbean.MusicGameCfgOriginal"))
/*     */         {
/*     */ 
/* 147 */           MusicGameCfgOriginal obj = new MusicGameCfgOriginal();
/* 148 */           obj.loadFromXml(elem);
/* 149 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, MusicGameCfgOriginal> all)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.musicgame.confbean.MusicGameCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       SAXReader reader = new SAXReader();
/* 166 */       org.dom4j.Document doc = reader.read(new File(path));
/* 167 */       Element root = doc.getRootElement();
/* 168 */       List<?> nodeList = root.elements();
/* 169 */       int len = nodeList.size();
/* 170 */       for (int i = 0; i < len; i++)
/*     */       {
/* 172 */         Element elem = (Element)nodeList.get(i);
/* 173 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.musicgame.confbean.MusicGameCfgOriginal"))
/*     */         {
/*     */ 
/* 176 */           MusicGameCfgOriginal obj = new MusicGameCfgOriginal();
/* 177 */           obj.loadFromXml(elem);
/* 178 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 179 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 190 */     all = new java.util.HashMap();
/*     */     
/* 192 */     String path = dir + "mzm.gsp.musicgame.confbean.MusicGameCfgOriginal.bny";
/*     */     try
/*     */     {
/* 195 */       File file = new File(path);
/* 196 */       if (file.exists())
/*     */       {
/* 198 */         byte[] bytes = new byte['Ѐ'];
/* 199 */         FileInputStream fis = new FileInputStream(file);
/* 200 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 201 */         int len = 0;
/* 202 */         while ((len = fis.read(bytes)) > 0)
/* 203 */           baos.write(bytes, 0, len);
/* 204 */         fis.close();
/* 205 */         bytes = baos.toByteArray();
/* 206 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 207 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/* 211 */           _os_.unmarshal_int();
/*     */         }
/* 213 */         _os_.unmarshal_int();
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 217 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 219 */           MusicGameCfgOriginal _v_ = new MusicGameCfgOriginal();
/* 220 */           _v_.unmarshal(_os_);
/* 221 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 227 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 232 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, MusicGameCfgOriginal> all)
/*     */   {
/* 239 */     String path = dir + "mzm.gsp.musicgame.confbean.MusicGameCfgOriginal.bny";
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
/* 266 */           MusicGameCfgOriginal _v_ = new MusicGameCfgOriginal();
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
/*     */ 
/*     */   public static MusicGameCfgOriginal getOld(int key)
/*     */   {
/* 287 */     return (MusicGameCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static MusicGameCfgOriginal get(int key)
/*     */   {
/* 292 */     return (MusicGameCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, MusicGameCfgOriginal> getOldAll()
/*     */   {
/* 297 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, MusicGameCfgOriginal> getAll()
/*     */   {
/* 302 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, MusicGameCfgOriginal> newAll)
/*     */   {
/* 307 */     oldAll = all;
/* 308 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 313 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\confbean\MusicGameCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */