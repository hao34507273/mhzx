/*     */ package mzm.gsp.feisheng.confbean;
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
/*     */ public class FeiShengFightActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengFightActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengFightActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int award_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*     */   public int daily_get_team_member_award_max_times;
/*     */   public int sort_id;
/*     */   public int fight_cfg_id;
/*     */   public int team_leader_award_id;
/*     */   public int team_member_award_id;
/*     */   public int image_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  40 */     this.desc = rootElement.attributeValue("desc");
/*  41 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  42 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  43 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  44 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  45 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  46 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  47 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  48 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  49 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  50 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*  51 */     this.daily_get_team_member_award_max_times = Integer.valueOf(rootElement.attributeValue("daily_get_team_member_award_max_times")).intValue();
/*  52 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  53 */     this.fight_cfg_id = Integer.valueOf(rootElement.attributeValue("fight_cfg_id")).intValue();
/*  54 */     this.team_leader_award_id = Integer.valueOf(rootElement.attributeValue("team_leader_award_id")).intValue();
/*  55 */     this.team_member_award_id = Integer.valueOf(rootElement.attributeValue("team_member_award_id")).intValue();
/*  56 */     this.image_id = Integer.valueOf(rootElement.attributeValue("image_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  61 */     _os_.marshal(this.id);
/*  62 */     _os_.marshal(this.desc, "UTF-8");
/*  63 */     _os_.marshal(this.activity_cfg_id);
/*  64 */     _os_.marshal(this.moduleid);
/*  65 */     _os_.marshal(this.serverlevel);
/*  66 */     _os_.marshal(this.npc_id);
/*  67 */     _os_.marshal(this.npc_service_id);
/*  68 */     _os_.marshal(this.award_id);
/*  69 */     _os_.marshal(this.activity_map_cfg_id);
/*  70 */     _os_.marshal(this.effect_id);
/*  71 */     _os_.marshal(this.effect_coord_x);
/*  72 */     _os_.marshal(this.effect_coord_y);
/*  73 */     _os_.marshal(this.daily_get_team_member_award_max_times);
/*  74 */     _os_.marshal(this.sort_id);
/*  75 */     _os_.marshal(this.fight_cfg_id);
/*  76 */     _os_.marshal(this.team_leader_award_id);
/*  77 */     _os_.marshal(this.team_member_award_id);
/*  78 */     _os_.marshal(this.image_id);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.id = _os_.unmarshal_int();
/*  85 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  86 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  87 */     this.moduleid = _os_.unmarshal_int();
/*  88 */     this.serverlevel = _os_.unmarshal_int();
/*  89 */     this.npc_id = _os_.unmarshal_int();
/*  90 */     this.npc_service_id = _os_.unmarshal_int();
/*  91 */     this.award_id = _os_.unmarshal_int();
/*  92 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/*  93 */     this.effect_id = _os_.unmarshal_int();
/*  94 */     this.effect_coord_x = _os_.unmarshal_int();
/*  95 */     this.effect_coord_y = _os_.unmarshal_int();
/*  96 */     this.daily_get_team_member_award_max_times = _os_.unmarshal_int();
/*  97 */     this.sort_id = _os_.unmarshal_int();
/*  98 */     this.fight_cfg_id = _os_.unmarshal_int();
/*  99 */     this.team_leader_award_id = _os_.unmarshal_int();
/* 100 */     this.team_member_award_id = _os_.unmarshal_int();
/* 101 */     this.image_id = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 107 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengFightActivityCfgOriginal.xml";
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
/* 120 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengFightActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 123 */           FeiShengFightActivityCfgOriginal obj = new FeiShengFightActivityCfgOriginal();
/* 124 */           obj.loadFromXml(elem);
/* 125 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 126 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengFightActivityCfgOriginal> all)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengFightActivityCfgOriginal.xml";
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
/* 149 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengFightActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 152 */           FeiShengFightActivityCfgOriginal obj = new FeiShengFightActivityCfgOriginal();
/* 153 */           obj.loadFromXml(elem);
/* 154 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 155 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 168 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengFightActivityCfgOriginal.bny";
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
/* 195 */           FeiShengFightActivityCfgOriginal _v_ = new FeiShengFightActivityCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengFightActivityCfgOriginal> all)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengFightActivityCfgOriginal.bny";
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
/* 242 */           FeiShengFightActivityCfgOriginal _v_ = new FeiShengFightActivityCfgOriginal();
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
/*     */   public static FeiShengFightActivityCfgOriginal getOld(int key)
/*     */   {
/* 263 */     return (FeiShengFightActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengFightActivityCfgOriginal get(int key)
/*     */   {
/* 268 */     return (FeiShengFightActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengFightActivityCfgOriginal> getOldAll()
/*     */   {
/* 273 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengFightActivityCfgOriginal> getAll()
/*     */   {
/* 278 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengFightActivityCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengFightActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */