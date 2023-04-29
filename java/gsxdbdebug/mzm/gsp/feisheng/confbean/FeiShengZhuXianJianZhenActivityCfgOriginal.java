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
/*     */ public class FeiShengZhuXianJianZhenActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int activity_map_transfer_x;
/*     */   public int activity_map_transfer_y;
/*     */   public int out_map_cfg_id;
/*     */   public int out_map_transfer_x;
/*     */   public int out_map_transfer_y;
/*     */   public int award_id;
/*     */   public int daily_try_max_times;
/*     */   public int effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*     */   public int collect_item_tips_id;
/*     */   public int collect_item_tips_duration_in_second;
/*     */   public int collect_item_duration_in_second;
/*     */   public int commit_item_npc_controller_id;
/*     */   public int item_controller_id;
/*     */   public int item_refresh_num;
/*     */   public int commit_item_npc_id;
/*     */   public int commit_item_npc_service_id;
/*     */   public int commit_item_cfg_id;
/*     */   public int commit_item_num;
/*     */   public int collect_item_success_effect_id;
/*     */   public int collect_item_success_effect_duration;
/*     */   public int kill_monster_tips_id;
/*     */   public int kill_monster_tips_duration_in_second;
/*     */   public int kill_monster_duration_in_second;
/*     */   public int monster_controller_id;
/*     */   public int monster_group_id;
/*     */   public int kill_monster_num;
/*     */   public int kill_monster_success_effect_id;
/*     */   public int kill_monster_success_effect_duration;
/*     */   public int delay_leave_interval;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  60 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  61 */     this.desc = rootElement.attributeValue("desc");
/*  62 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  63 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  64 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  65 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  66 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  67 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  68 */     this.activity_map_transfer_x = Integer.valueOf(rootElement.attributeValue("activity_map_transfer_x")).intValue();
/*  69 */     this.activity_map_transfer_y = Integer.valueOf(rootElement.attributeValue("activity_map_transfer_y")).intValue();
/*  70 */     this.out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("out_map_cfg_id")).intValue();
/*  71 */     this.out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("out_map_transfer_x")).intValue();
/*  72 */     this.out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("out_map_transfer_y")).intValue();
/*  73 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  74 */     this.daily_try_max_times = Integer.valueOf(rootElement.attributeValue("daily_try_max_times")).intValue();
/*  75 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  76 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  77 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*  78 */     this.collect_item_tips_id = Integer.valueOf(rootElement.attributeValue("collect_item_tips_id")).intValue();
/*  79 */     this.collect_item_tips_duration_in_second = Integer.valueOf(rootElement.attributeValue("collect_item_tips_duration_in_second")).intValue();
/*  80 */     this.collect_item_duration_in_second = Integer.valueOf(rootElement.attributeValue("collect_item_duration_in_second")).intValue();
/*  81 */     this.commit_item_npc_controller_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_controller_id")).intValue();
/*  82 */     this.item_controller_id = Integer.valueOf(rootElement.attributeValue("item_controller_id")).intValue();
/*  83 */     this.item_refresh_num = Integer.valueOf(rootElement.attributeValue("item_refresh_num")).intValue();
/*  84 */     this.commit_item_npc_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_id")).intValue();
/*  85 */     this.commit_item_npc_service_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_service_id")).intValue();
/*  86 */     this.commit_item_cfg_id = Integer.valueOf(rootElement.attributeValue("commit_item_cfg_id")).intValue();
/*  87 */     this.commit_item_num = Integer.valueOf(rootElement.attributeValue("commit_item_num")).intValue();
/*  88 */     this.collect_item_success_effect_id = Integer.valueOf(rootElement.attributeValue("collect_item_success_effect_id")).intValue();
/*  89 */     this.collect_item_success_effect_duration = Integer.valueOf(rootElement.attributeValue("collect_item_success_effect_duration")).intValue();
/*  90 */     this.kill_monster_tips_id = Integer.valueOf(rootElement.attributeValue("kill_monster_tips_id")).intValue();
/*  91 */     this.kill_monster_tips_duration_in_second = Integer.valueOf(rootElement.attributeValue("kill_monster_tips_duration_in_second")).intValue();
/*  92 */     this.kill_monster_duration_in_second = Integer.valueOf(rootElement.attributeValue("kill_monster_duration_in_second")).intValue();
/*  93 */     this.monster_controller_id = Integer.valueOf(rootElement.attributeValue("monster_controller_id")).intValue();
/*  94 */     this.monster_group_id = Integer.valueOf(rootElement.attributeValue("monster_group_id")).intValue();
/*  95 */     this.kill_monster_num = Integer.valueOf(rootElement.attributeValue("kill_monster_num")).intValue();
/*  96 */     this.kill_monster_success_effect_id = Integer.valueOf(rootElement.attributeValue("kill_monster_success_effect_id")).intValue();
/*  97 */     this.kill_monster_success_effect_duration = Integer.valueOf(rootElement.attributeValue("kill_monster_success_effect_duration")).intValue();
/*  98 */     this.delay_leave_interval = Integer.valueOf(rootElement.attributeValue("delay_leave_interval")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 103 */     _os_.marshal(this.id);
/* 104 */     _os_.marshal(this.desc, "UTF-8");
/* 105 */     _os_.marshal(this.activity_cfg_id);
/* 106 */     _os_.marshal(this.moduleid);
/* 107 */     _os_.marshal(this.serverlevel);
/* 108 */     _os_.marshal(this.npc_id);
/* 109 */     _os_.marshal(this.npc_service_id);
/* 110 */     _os_.marshal(this.activity_map_cfg_id);
/* 111 */     _os_.marshal(this.activity_map_transfer_x);
/* 112 */     _os_.marshal(this.activity_map_transfer_y);
/* 113 */     _os_.marshal(this.out_map_cfg_id);
/* 114 */     _os_.marshal(this.out_map_transfer_x);
/* 115 */     _os_.marshal(this.out_map_transfer_y);
/* 116 */     _os_.marshal(this.award_id);
/* 117 */     _os_.marshal(this.daily_try_max_times);
/* 118 */     _os_.marshal(this.effect_id);
/* 119 */     _os_.marshal(this.effect_coord_x);
/* 120 */     _os_.marshal(this.effect_coord_y);
/* 121 */     _os_.marshal(this.collect_item_tips_id);
/* 122 */     _os_.marshal(this.collect_item_tips_duration_in_second);
/* 123 */     _os_.marshal(this.collect_item_duration_in_second);
/* 124 */     _os_.marshal(this.commit_item_npc_controller_id);
/* 125 */     _os_.marshal(this.item_controller_id);
/* 126 */     _os_.marshal(this.item_refresh_num);
/* 127 */     _os_.marshal(this.commit_item_npc_id);
/* 128 */     _os_.marshal(this.commit_item_npc_service_id);
/* 129 */     _os_.marshal(this.commit_item_cfg_id);
/* 130 */     _os_.marshal(this.commit_item_num);
/* 131 */     _os_.marshal(this.collect_item_success_effect_id);
/* 132 */     _os_.marshal(this.collect_item_success_effect_duration);
/* 133 */     _os_.marshal(this.kill_monster_tips_id);
/* 134 */     _os_.marshal(this.kill_monster_tips_duration_in_second);
/* 135 */     _os_.marshal(this.kill_monster_duration_in_second);
/* 136 */     _os_.marshal(this.monster_controller_id);
/* 137 */     _os_.marshal(this.monster_group_id);
/* 138 */     _os_.marshal(this.kill_monster_num);
/* 139 */     _os_.marshal(this.kill_monster_success_effect_id);
/* 140 */     _os_.marshal(this.kill_monster_success_effect_duration);
/* 141 */     _os_.marshal(this.delay_leave_interval);
/* 142 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 147 */     this.id = _os_.unmarshal_int();
/* 148 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 149 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 150 */     this.moduleid = _os_.unmarshal_int();
/* 151 */     this.serverlevel = _os_.unmarshal_int();
/* 152 */     this.npc_id = _os_.unmarshal_int();
/* 153 */     this.npc_service_id = _os_.unmarshal_int();
/* 154 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/* 155 */     this.activity_map_transfer_x = _os_.unmarshal_int();
/* 156 */     this.activity_map_transfer_y = _os_.unmarshal_int();
/* 157 */     this.out_map_cfg_id = _os_.unmarshal_int();
/* 158 */     this.out_map_transfer_x = _os_.unmarshal_int();
/* 159 */     this.out_map_transfer_y = _os_.unmarshal_int();
/* 160 */     this.award_id = _os_.unmarshal_int();
/* 161 */     this.daily_try_max_times = _os_.unmarshal_int();
/* 162 */     this.effect_id = _os_.unmarshal_int();
/* 163 */     this.effect_coord_x = _os_.unmarshal_int();
/* 164 */     this.effect_coord_y = _os_.unmarshal_int();
/* 165 */     this.collect_item_tips_id = _os_.unmarshal_int();
/* 166 */     this.collect_item_tips_duration_in_second = _os_.unmarshal_int();
/* 167 */     this.collect_item_duration_in_second = _os_.unmarshal_int();
/* 168 */     this.commit_item_npc_controller_id = _os_.unmarshal_int();
/* 169 */     this.item_controller_id = _os_.unmarshal_int();
/* 170 */     this.item_refresh_num = _os_.unmarshal_int();
/* 171 */     this.commit_item_npc_id = _os_.unmarshal_int();
/* 172 */     this.commit_item_npc_service_id = _os_.unmarshal_int();
/* 173 */     this.commit_item_cfg_id = _os_.unmarshal_int();
/* 174 */     this.commit_item_num = _os_.unmarshal_int();
/* 175 */     this.collect_item_success_effect_id = _os_.unmarshal_int();
/* 176 */     this.collect_item_success_effect_duration = _os_.unmarshal_int();
/* 177 */     this.kill_monster_tips_id = _os_.unmarshal_int();
/* 178 */     this.kill_monster_tips_duration_in_second = _os_.unmarshal_int();
/* 179 */     this.kill_monster_duration_in_second = _os_.unmarshal_int();
/* 180 */     this.monster_controller_id = _os_.unmarshal_int();
/* 181 */     this.monster_group_id = _os_.unmarshal_int();
/* 182 */     this.kill_monster_num = _os_.unmarshal_int();
/* 183 */     this.kill_monster_success_effect_id = _os_.unmarshal_int();
/* 184 */     this.kill_monster_success_effect_duration = _os_.unmarshal_int();
/* 185 */     this.delay_leave_interval = _os_.unmarshal_int();
/* 186 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengZhuXianJianZhenActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       all = new java.util.HashMap();
/* 196 */       SAXReader reader = new SAXReader();
/* 197 */       org.dom4j.Document doc = reader.read(new File(path));
/* 198 */       Element root = doc.getRootElement();
/* 199 */       List<?> nodeList = root.elements();
/* 200 */       int len = nodeList.size();
/* 201 */       for (int i = 0; i < len; i++)
/*     */       {
/* 203 */         Element elem = (Element)nodeList.get(i);
/* 204 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengZhuXianJianZhenActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 207 */           FeiShengZhuXianJianZhenActivityCfgOriginal obj = new FeiShengZhuXianJianZhenActivityCfgOriginal();
/* 208 */           obj.loadFromXml(elem);
/* 209 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> all)
/*     */   {
/* 221 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengZhuXianJianZhenActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 225 */       SAXReader reader = new SAXReader();
/* 226 */       org.dom4j.Document doc = reader.read(new File(path));
/* 227 */       Element root = doc.getRootElement();
/* 228 */       List<?> nodeList = root.elements();
/* 229 */       int len = nodeList.size();
/* 230 */       for (int i = 0; i < len; i++)
/*     */       {
/* 232 */         Element elem = (Element)nodeList.get(i);
/* 233 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengZhuXianJianZhenActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 236 */           FeiShengZhuXianJianZhenActivityCfgOriginal obj = new FeiShengZhuXianJianZhenActivityCfgOriginal();
/* 237 */           obj.loadFromXml(elem);
/* 238 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 239 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 244 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 250 */     all = new java.util.HashMap();
/*     */     
/* 252 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengZhuXianJianZhenActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 255 */       File file = new File(path);
/* 256 */       if (file.exists())
/*     */       {
/* 258 */         byte[] bytes = new byte['Ѐ'];
/* 259 */         FileInputStream fis = new FileInputStream(file);
/* 260 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 261 */         int len = 0;
/* 262 */         while ((len = fis.read(bytes)) > 0)
/* 263 */           baos.write(bytes, 0, len);
/* 264 */         fis.close();
/* 265 */         bytes = baos.toByteArray();
/* 266 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 269 */           _os_.unmarshal_int();
/* 270 */           _os_.unmarshal_int();
/* 271 */           _os_.unmarshal_int();
/*     */         }
/* 273 */         _os_.unmarshal_int();
/* 274 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 277 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 279 */           FeiShengZhuXianJianZhenActivityCfgOriginal _v_ = new FeiShengZhuXianJianZhenActivityCfgOriginal();
/* 280 */           _v_.unmarshal(_os_);
/* 281 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 282 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 287 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 292 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> all)
/*     */   {
/* 299 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengZhuXianJianZhenActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 302 */       File file = new File(path);
/* 303 */       if (file.exists())
/*     */       {
/* 305 */         byte[] bytes = new byte['Ѐ'];
/* 306 */         FileInputStream fis = new FileInputStream(file);
/* 307 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 308 */         int len = 0;
/* 309 */         while ((len = fis.read(bytes)) > 0)
/* 310 */           baos.write(bytes, 0, len);
/* 311 */         fis.close();
/* 312 */         bytes = baos.toByteArray();
/* 313 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 314 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 316 */           _os_.unmarshal_int();
/* 317 */           _os_.unmarshal_int();
/* 318 */           _os_.unmarshal_int();
/*     */         }
/* 320 */         _os_.unmarshal_int();
/* 321 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 324 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 326 */           FeiShengZhuXianJianZhenActivityCfgOriginal _v_ = new FeiShengZhuXianJianZhenActivityCfgOriginal();
/* 327 */           _v_.unmarshal(_os_);
/* 328 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 329 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 334 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 339 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FeiShengZhuXianJianZhenActivityCfgOriginal getOld(int key)
/*     */   {
/* 347 */     return (FeiShengZhuXianJianZhenActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengZhuXianJianZhenActivityCfgOriginal get(int key)
/*     */   {
/* 352 */     return (FeiShengZhuXianJianZhenActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> getOldAll()
/*     */   {
/* 357 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> getAll()
/*     */   {
/* 362 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengZhuXianJianZhenActivityCfgOriginal> newAll)
/*     */   {
/* 367 */     oldAll = all;
/* 368 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 373 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengZhuXianJianZhenActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */