/*     */ package mzm.gsp.item.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class EquipItemCfgConsts
/*     */ {
/*  13 */   private static volatile EquipItemCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static EquipItemCfgConsts instance = new EquipItemCfgConsts();
/*     */   public int QILIN_NEED_ITEM_ID;
/*     */   public int FUHUN_NEED_ITEM_ID;
/*     */   public int PRIMARY_LUCKY_ITEM_ID;
/*     */   public int MIDDLE_LUCKY_ITEM_ID;
/*     */   public int SENIOR_LUCKY_ITEM_ID;
/*     */   public int LUCKY_ITEM_ID;
/*     */   
/*  23 */   public static EquipItemCfgConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static EquipItemCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int ZHENLIN_STONE_ITEM_ID;
/*     */   
/*     */   public int SAME_LEVEL_DEC_LIN_LEVEL;
/*     */   
/*     */   public int DIFF_LEVEL_DEC_LIN_LEVEL;
/*     */   
/*     */   public int CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL;
/*     */   
/*     */   public int DIE_USEPOINT_DEC_VALUE;
/*     */   
/*     */   public int USEPOINT_DEC_RATE;
/*     */   
/*     */   public int USEPOINT_DEC_VALUE;
/*     */   public int USEPOINT_WARN_VALUE;
/*     */   public int MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL;
/*     */   public int EQUIP_MAKE_MIN_LEVEL;
/*     */   public int EQUIP_QILIN_MAX_LIN_LEVEL;
/*     */   public int EQUIP_GUIJI_MIN_LIN_LEVEL;
/*     */   public int EQUIP_ANNOUNCE_MIN_LIN_LEVEL;
/*     */   public int BOUND_FIX_TIP_MAX_USEPOINT;
/*     */   public int MAKE_SUCC_EFFECT_ID;
/*     */   public int QILIN_SUCC_EFFECT_ID;
/*     */   public int QILIN_FAIL_EFFECT_ID;
/*     */   public int INHEIRT_SUCC_EFFECT_ID;
/*     */   public int TRANSFER_SUCC_EFFECT_ID;
/*     */   public int EQUIP_MAKE_YUANBAO_PRICE_DELTA;
/*     */   public int MAX_JIGAO;
/*     */   public int MIN_JIGAO;
/*     */   public int MAX_JIAOGAO;
/*     */   public int MIN_JIAOGAO;
/*     */   public int MAX_YIBAN;
/*     */   public int MIN_YIBAN;
/*     */   public int MAX_JIAODI;
/*     */   public int MIN_JIAODI;
/*     */   public int MAX_JIDI;
/*     */   public int MIN_JIDI;
/*     */   public int MIN_LEVEL_FOR_QILIN;
/*     */   public int MAX_NUM_NUM;
/*     */   public int EQUIP_MAKE_OPEN_LEVEL;
/*     */   public int EQUIP_QILIN_OPEN_LEVEL;
/*     */   public int EQUIP_XIHUN_OPEN_LEVEL;
/*     */   public int EQUIP_INHERIT_OPEN_LEVEL;
/*     */   public int EQUIP_FUHUN_OPEN_LEVEL;
/*     */   public int MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP;
/*     */   public int EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL;
/*     */   public int MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL;
/*     */   public int MIN_EQUIP_LEVEL_FOR_DISASSEMBLE;
/*     */   public int MIN_EQUIP_COLOR_FOR_DISASSEMBLE;
/*     */   public boolean IS_BIND_EQUIP_CAN_DISASSEMBLE;
/*     */   public int EQUIP_DISASSEMBLE_PRICE_RATE;
/*     */   public int EQUIP_DISASSEMBLE_OUT_PUT_ITEMID;
/*     */   public int N_LEVEL_EQUIP_MAKE_SWITCH;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  86 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.item.confbean.EquipItemCfgConsts.xml";
/*     */     try
/*     */     {
/*  94 */       SAXReader reader = new SAXReader();
/*  95 */       org.dom4j.Document doc = reader.read(new File(path));
/*  96 */       Element root = doc.getRootElement();
/*  97 */       Map<String, Element> data = new java.util.HashMap();
/*  98 */       java.util.List<?> nodeList = root.elements();
/*  99 */       int len = nodeList.size();
/* 100 */       for (int i = 0; i < len; i++)
/*     */       {
/* 102 */         Element element = (Element)nodeList.get(i);
/* 103 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 106 */           String name = element.attributeValue("name");
/* 107 */           if (data.put(name, element) != null)
/* 108 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 111 */       this.QILIN_NEED_ITEM_ID = Integer.valueOf(((Element)data.get("QILIN_NEED_ITEM_ID")).attributeValue("value")).intValue();
/* 112 */       this.FUHUN_NEED_ITEM_ID = Integer.valueOf(((Element)data.get("FUHUN_NEED_ITEM_ID")).attributeValue("value")).intValue();
/* 113 */       this.PRIMARY_LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("PRIMARY_LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 114 */       this.MIDDLE_LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("MIDDLE_LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 115 */       this.SENIOR_LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("SENIOR_LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 116 */       this.LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 117 */       this.ZHENLIN_STONE_ITEM_ID = Integer.valueOf(((Element)data.get("ZHENLIN_STONE_ITEM_ID")).attributeValue("value")).intValue();
/* 118 */       this.SAME_LEVEL_DEC_LIN_LEVEL = Integer.valueOf(((Element)data.get("SAME_LEVEL_DEC_LIN_LEVEL")).attributeValue("value")).intValue();
/* 119 */       this.DIFF_LEVEL_DEC_LIN_LEVEL = Integer.valueOf(((Element)data.get("DIFF_LEVEL_DEC_LIN_LEVEL")).attributeValue("value")).intValue();
/* 120 */       this.CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL = Integer.valueOf(((Element)data.get("CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL")).attributeValue("value")).intValue();
/* 121 */       this.DIE_USEPOINT_DEC_VALUE = Integer.valueOf(((Element)data.get("DIE_USEPOINT_DEC_VALUE")).attributeValue("value")).intValue();
/* 122 */       this.USEPOINT_DEC_RATE = Integer.valueOf(((Element)data.get("USEPOINT_DEC_RATE")).attributeValue("value")).intValue();
/* 123 */       this.USEPOINT_DEC_VALUE = Integer.valueOf(((Element)data.get("USEPOINT_DEC_VALUE")).attributeValue("value")).intValue();
/* 124 */       this.USEPOINT_WARN_VALUE = Integer.valueOf(((Element)data.get("USEPOINT_WARN_VALUE")).attributeValue("value")).intValue();
/* 125 */       this.MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL = Integer.valueOf(((Element)data.get("MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 126 */       this.EQUIP_MAKE_MIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_MAKE_MIN_LEVEL")).attributeValue("value")).intValue();
/* 127 */       this.EQUIP_QILIN_MAX_LIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_QILIN_MAX_LIN_LEVEL")).attributeValue("value")).intValue();
/* 128 */       this.EQUIP_GUIJI_MIN_LIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_GUIJI_MIN_LIN_LEVEL")).attributeValue("value")).intValue();
/* 129 */       this.EQUIP_ANNOUNCE_MIN_LIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_ANNOUNCE_MIN_LIN_LEVEL")).attributeValue("value")).intValue();
/* 130 */       this.BOUND_FIX_TIP_MAX_USEPOINT = Integer.valueOf(((Element)data.get("BOUND_FIX_TIP_MAX_USEPOINT")).attributeValue("value")).intValue();
/* 131 */       this.MAKE_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("MAKE_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 132 */       this.QILIN_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("QILIN_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 133 */       this.QILIN_FAIL_EFFECT_ID = Integer.valueOf(((Element)data.get("QILIN_FAIL_EFFECT_ID")).attributeValue("value")).intValue();
/* 134 */       this.INHEIRT_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("INHEIRT_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 135 */       this.TRANSFER_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("TRANSFER_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 136 */       this.EQUIP_MAKE_YUANBAO_PRICE_DELTA = Integer.valueOf(((Element)data.get("EQUIP_MAKE_YUANBAO_PRICE_DELTA")).attributeValue("value")).intValue();
/* 137 */       this.MAX_JIGAO = Integer.valueOf(((Element)data.get("MAX_JIGAO")).attributeValue("value")).intValue();
/* 138 */       this.MIN_JIGAO = Integer.valueOf(((Element)data.get("MIN_JIGAO")).attributeValue("value")).intValue();
/* 139 */       this.MAX_JIAOGAO = Integer.valueOf(((Element)data.get("MAX_JIAOGAO")).attributeValue("value")).intValue();
/* 140 */       this.MIN_JIAOGAO = Integer.valueOf(((Element)data.get("MIN_JIAOGAO")).attributeValue("value")).intValue();
/* 141 */       this.MAX_YIBAN = Integer.valueOf(((Element)data.get("MAX_YIBAN")).attributeValue("value")).intValue();
/* 142 */       this.MIN_YIBAN = Integer.valueOf(((Element)data.get("MIN_YIBAN")).attributeValue("value")).intValue();
/* 143 */       this.MAX_JIAODI = Integer.valueOf(((Element)data.get("MAX_JIAODI")).attributeValue("value")).intValue();
/* 144 */       this.MIN_JIAODI = Integer.valueOf(((Element)data.get("MIN_JIAODI")).attributeValue("value")).intValue();
/* 145 */       this.MAX_JIDI = Integer.valueOf(((Element)data.get("MAX_JIDI")).attributeValue("value")).intValue();
/* 146 */       this.MIN_JIDI = Integer.valueOf(((Element)data.get("MIN_JIDI")).attributeValue("value")).intValue();
/* 147 */       this.MIN_LEVEL_FOR_QILIN = Integer.valueOf(((Element)data.get("MIN_LEVEL_FOR_QILIN")).attributeValue("value")).intValue();
/* 148 */       this.MAX_NUM_NUM = Integer.valueOf(((Element)data.get("MAX_NUM_NUM")).attributeValue("value")).intValue();
/* 149 */       this.EQUIP_MAKE_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_MAKE_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 150 */       this.EQUIP_QILIN_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_QILIN_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 151 */       this.EQUIP_XIHUN_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_XIHUN_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 152 */       this.EQUIP_INHERIT_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_INHERIT_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 153 */       this.EQUIP_FUHUN_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_FUHUN_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 154 */       this.MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP = Integer.valueOf(((Element)data.get("MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP")).attributeValue("value")).intValue();
/* 155 */       this.EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL")).attributeValue("value")).intValue();
/* 156 */       this.MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL = Integer.valueOf(((Element)data.get("MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL")).attributeValue("value")).intValue();
/* 157 */       this.MIN_EQUIP_LEVEL_FOR_DISASSEMBLE = Integer.valueOf(((Element)data.get("MIN_EQUIP_LEVEL_FOR_DISASSEMBLE")).attributeValue("value")).intValue();
/* 158 */       this.MIN_EQUIP_COLOR_FOR_DISASSEMBLE = Integer.valueOf(((Element)data.get("MIN_EQUIP_COLOR_FOR_DISASSEMBLE")).attributeValue("value")).intValue();
/* 159 */       this.IS_BIND_EQUIP_CAN_DISASSEMBLE = Boolean.valueOf(((Element)data.get("IS_BIND_EQUIP_CAN_DISASSEMBLE")).attributeValue("value")).booleanValue();
/* 160 */       this.EQUIP_DISASSEMBLE_PRICE_RATE = Integer.valueOf(((Element)data.get("EQUIP_DISASSEMBLE_PRICE_RATE")).attributeValue("value")).intValue();
/* 161 */       this.EQUIP_DISASSEMBLE_OUT_PUT_ITEMID = Integer.valueOf(((Element)data.get("EQUIP_DISASSEMBLE_OUT_PUT_ITEMID")).attributeValue("value")).intValue();
/* 162 */       this.N_LEVEL_EQUIP_MAKE_SWITCH = Integer.valueOf(((Element)data.get("N_LEVEL_EQUIP_MAKE_SWITCH")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 166 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 171 */     String path = dir + "mzm.gsp.item.confbean.EquipItemCfgConsts.xml";
/*     */     try
/*     */     {
/* 174 */       SAXReader reader = new SAXReader();
/* 175 */       org.dom4j.Document doc = reader.read(new File(path));
/* 176 */       Element root = doc.getRootElement();
/* 177 */       Map<String, Element> data = new java.util.HashMap();
/* 178 */       java.util.List<?> nodeList = root.elements();
/* 179 */       int len = nodeList.size();
/* 180 */       for (int i = 0; i < len; i++)
/*     */       {
/* 182 */         Element element = (Element)nodeList.get(i);
/* 183 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 186 */           String name = element.attributeValue("name");
/* 187 */           if (data.put(name, element) != null)
/* 188 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 191 */       this.QILIN_NEED_ITEM_ID = Integer.valueOf(((Element)data.get("QILIN_NEED_ITEM_ID")).attributeValue("value")).intValue();
/* 192 */       this.FUHUN_NEED_ITEM_ID = Integer.valueOf(((Element)data.get("FUHUN_NEED_ITEM_ID")).attributeValue("value")).intValue();
/* 193 */       this.PRIMARY_LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("PRIMARY_LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 194 */       this.MIDDLE_LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("MIDDLE_LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 195 */       this.SENIOR_LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("SENIOR_LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 196 */       this.LUCKY_ITEM_ID = Integer.valueOf(((Element)data.get("LUCKY_ITEM_ID")).attributeValue("value")).intValue();
/* 197 */       this.ZHENLIN_STONE_ITEM_ID = Integer.valueOf(((Element)data.get("ZHENLIN_STONE_ITEM_ID")).attributeValue("value")).intValue();
/* 198 */       this.SAME_LEVEL_DEC_LIN_LEVEL = Integer.valueOf(((Element)data.get("SAME_LEVEL_DEC_LIN_LEVEL")).attributeValue("value")).intValue();
/* 199 */       this.DIFF_LEVEL_DEC_LIN_LEVEL = Integer.valueOf(((Element)data.get("DIFF_LEVEL_DEC_LIN_LEVEL")).attributeValue("value")).intValue();
/* 200 */       this.CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL = Integer.valueOf(((Element)data.get("CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL")).attributeValue("value")).intValue();
/* 201 */       this.DIE_USEPOINT_DEC_VALUE = Integer.valueOf(((Element)data.get("DIE_USEPOINT_DEC_VALUE")).attributeValue("value")).intValue();
/* 202 */       this.USEPOINT_DEC_RATE = Integer.valueOf(((Element)data.get("USEPOINT_DEC_RATE")).attributeValue("value")).intValue();
/* 203 */       this.USEPOINT_DEC_VALUE = Integer.valueOf(((Element)data.get("USEPOINT_DEC_VALUE")).attributeValue("value")).intValue();
/* 204 */       this.USEPOINT_WARN_VALUE = Integer.valueOf(((Element)data.get("USEPOINT_WARN_VALUE")).attributeValue("value")).intValue();
/* 205 */       this.MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL = Integer.valueOf(((Element)data.get("MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL")).attributeValue("value")).intValue();
/* 206 */       this.EQUIP_MAKE_MIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_MAKE_MIN_LEVEL")).attributeValue("value")).intValue();
/* 207 */       this.EQUIP_QILIN_MAX_LIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_QILIN_MAX_LIN_LEVEL")).attributeValue("value")).intValue();
/* 208 */       this.EQUIP_GUIJI_MIN_LIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_GUIJI_MIN_LIN_LEVEL")).attributeValue("value")).intValue();
/* 209 */       this.EQUIP_ANNOUNCE_MIN_LIN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_ANNOUNCE_MIN_LIN_LEVEL")).attributeValue("value")).intValue();
/* 210 */       this.BOUND_FIX_TIP_MAX_USEPOINT = Integer.valueOf(((Element)data.get("BOUND_FIX_TIP_MAX_USEPOINT")).attributeValue("value")).intValue();
/* 211 */       this.MAKE_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("MAKE_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 212 */       this.QILIN_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("QILIN_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 213 */       this.QILIN_FAIL_EFFECT_ID = Integer.valueOf(((Element)data.get("QILIN_FAIL_EFFECT_ID")).attributeValue("value")).intValue();
/* 214 */       this.INHEIRT_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("INHEIRT_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 215 */       this.TRANSFER_SUCC_EFFECT_ID = Integer.valueOf(((Element)data.get("TRANSFER_SUCC_EFFECT_ID")).attributeValue("value")).intValue();
/* 216 */       this.EQUIP_MAKE_YUANBAO_PRICE_DELTA = Integer.valueOf(((Element)data.get("EQUIP_MAKE_YUANBAO_PRICE_DELTA")).attributeValue("value")).intValue();
/* 217 */       this.MAX_JIGAO = Integer.valueOf(((Element)data.get("MAX_JIGAO")).attributeValue("value")).intValue();
/* 218 */       this.MIN_JIGAO = Integer.valueOf(((Element)data.get("MIN_JIGAO")).attributeValue("value")).intValue();
/* 219 */       this.MAX_JIAOGAO = Integer.valueOf(((Element)data.get("MAX_JIAOGAO")).attributeValue("value")).intValue();
/* 220 */       this.MIN_JIAOGAO = Integer.valueOf(((Element)data.get("MIN_JIAOGAO")).attributeValue("value")).intValue();
/* 221 */       this.MAX_YIBAN = Integer.valueOf(((Element)data.get("MAX_YIBAN")).attributeValue("value")).intValue();
/* 222 */       this.MIN_YIBAN = Integer.valueOf(((Element)data.get("MIN_YIBAN")).attributeValue("value")).intValue();
/* 223 */       this.MAX_JIAODI = Integer.valueOf(((Element)data.get("MAX_JIAODI")).attributeValue("value")).intValue();
/* 224 */       this.MIN_JIAODI = Integer.valueOf(((Element)data.get("MIN_JIAODI")).attributeValue("value")).intValue();
/* 225 */       this.MAX_JIDI = Integer.valueOf(((Element)data.get("MAX_JIDI")).attributeValue("value")).intValue();
/* 226 */       this.MIN_JIDI = Integer.valueOf(((Element)data.get("MIN_JIDI")).attributeValue("value")).intValue();
/* 227 */       this.MIN_LEVEL_FOR_QILIN = Integer.valueOf(((Element)data.get("MIN_LEVEL_FOR_QILIN")).attributeValue("value")).intValue();
/* 228 */       this.MAX_NUM_NUM = Integer.valueOf(((Element)data.get("MAX_NUM_NUM")).attributeValue("value")).intValue();
/* 229 */       this.EQUIP_MAKE_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_MAKE_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 230 */       this.EQUIP_QILIN_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_QILIN_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 231 */       this.EQUIP_XIHUN_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_XIHUN_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 232 */       this.EQUIP_INHERIT_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_INHERIT_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 233 */       this.EQUIP_FUHUN_OPEN_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_FUHUN_OPEN_LEVEL")).attributeValue("value")).intValue();
/* 234 */       this.MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP = Integer.valueOf(((Element)data.get("MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP")).attributeValue("value")).intValue();
/* 235 */       this.EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL = Integer.valueOf(((Element)data.get("EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL")).attributeValue("value")).intValue();
/* 236 */       this.MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL = Integer.valueOf(((Element)data.get("MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL")).attributeValue("value")).intValue();
/* 237 */       this.MIN_EQUIP_LEVEL_FOR_DISASSEMBLE = Integer.valueOf(((Element)data.get("MIN_EQUIP_LEVEL_FOR_DISASSEMBLE")).attributeValue("value")).intValue();
/* 238 */       this.MIN_EQUIP_COLOR_FOR_DISASSEMBLE = Integer.valueOf(((Element)data.get("MIN_EQUIP_COLOR_FOR_DISASSEMBLE")).attributeValue("value")).intValue();
/* 239 */       this.IS_BIND_EQUIP_CAN_DISASSEMBLE = Boolean.valueOf(((Element)data.get("IS_BIND_EQUIP_CAN_DISASSEMBLE")).attributeValue("value")).booleanValue();
/* 240 */       this.EQUIP_DISASSEMBLE_PRICE_RATE = Integer.valueOf(((Element)data.get("EQUIP_DISASSEMBLE_PRICE_RATE")).attributeValue("value")).intValue();
/* 241 */       this.EQUIP_DISASSEMBLE_OUT_PUT_ITEMID = Integer.valueOf(((Element)data.get("EQUIP_DISASSEMBLE_OUT_PUT_ITEMID")).attributeValue("value")).intValue();
/* 242 */       this.N_LEVEL_EQUIP_MAKE_SWITCH = Integer.valueOf(((Element)data.get("N_LEVEL_EQUIP_MAKE_SWITCH")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 250 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 253 */     String path = dir + "mzm.gsp.item.confbean.EquipItemCfgConsts.bny";
/*     */     try
/*     */     {
/* 256 */       File file = new File(path);
/* 257 */       if (file.exists())
/*     */       {
/* 259 */         byte[] bytes = new byte['Ѐ'];
/* 260 */         FileInputStream fis = new FileInputStream(file);
/* 261 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 262 */         int len = 0;
/* 263 */         while ((len = fis.read(bytes)) > 0)
/* 264 */           baos.write(bytes, 0, len);
/* 265 */         fis.close();
/* 266 */         bytes = baos.toByteArray();
/* 267 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 268 */         this.QILIN_NEED_ITEM_ID = _os_.unmarshal_int();
/* 269 */         this.FUHUN_NEED_ITEM_ID = _os_.unmarshal_int();
/* 270 */         this.PRIMARY_LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 271 */         this.MIDDLE_LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 272 */         this.SENIOR_LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 273 */         this.LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 274 */         this.ZHENLIN_STONE_ITEM_ID = _os_.unmarshal_int();
/* 275 */         this.SAME_LEVEL_DEC_LIN_LEVEL = _os_.unmarshal_int();
/* 276 */         this.DIFF_LEVEL_DEC_LIN_LEVEL = _os_.unmarshal_int();
/* 277 */         this.CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL = _os_.unmarshal_int();
/* 278 */         this.DIE_USEPOINT_DEC_VALUE = _os_.unmarshal_int();
/* 279 */         this.USEPOINT_DEC_RATE = _os_.unmarshal_int();
/* 280 */         this.USEPOINT_DEC_VALUE = _os_.unmarshal_int();
/* 281 */         this.USEPOINT_WARN_VALUE = _os_.unmarshal_int();
/* 282 */         this.MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL = _os_.unmarshal_int();
/* 283 */         this.EQUIP_MAKE_MIN_LEVEL = _os_.unmarshal_int();
/* 284 */         this.EQUIP_QILIN_MAX_LIN_LEVEL = _os_.unmarshal_int();
/* 285 */         this.EQUIP_GUIJI_MIN_LIN_LEVEL = _os_.unmarshal_int();
/* 286 */         this.EQUIP_ANNOUNCE_MIN_LIN_LEVEL = _os_.unmarshal_int();
/* 287 */         this.BOUND_FIX_TIP_MAX_USEPOINT = _os_.unmarshal_int();
/* 288 */         this.MAKE_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 289 */         this.QILIN_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 290 */         this.QILIN_FAIL_EFFECT_ID = _os_.unmarshal_int();
/* 291 */         this.INHEIRT_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 292 */         this.TRANSFER_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 293 */         this.EQUIP_MAKE_YUANBAO_PRICE_DELTA = _os_.unmarshal_int();
/* 294 */         this.MAX_JIGAO = _os_.unmarshal_int();
/* 295 */         this.MIN_JIGAO = _os_.unmarshal_int();
/* 296 */         this.MAX_JIAOGAO = _os_.unmarshal_int();
/* 297 */         this.MIN_JIAOGAO = _os_.unmarshal_int();
/* 298 */         this.MAX_YIBAN = _os_.unmarshal_int();
/* 299 */         this.MIN_YIBAN = _os_.unmarshal_int();
/* 300 */         this.MAX_JIAODI = _os_.unmarshal_int();
/* 301 */         this.MIN_JIAODI = _os_.unmarshal_int();
/* 302 */         this.MAX_JIDI = _os_.unmarshal_int();
/* 303 */         this.MIN_JIDI = _os_.unmarshal_int();
/* 304 */         this.MIN_LEVEL_FOR_QILIN = _os_.unmarshal_int();
/* 305 */         this.MAX_NUM_NUM = _os_.unmarshal_int();
/* 306 */         this.EQUIP_MAKE_OPEN_LEVEL = _os_.unmarshal_int();
/* 307 */         this.EQUIP_QILIN_OPEN_LEVEL = _os_.unmarshal_int();
/* 308 */         this.EQUIP_XIHUN_OPEN_LEVEL = _os_.unmarshal_int();
/* 309 */         this.EQUIP_INHERIT_OPEN_LEVEL = _os_.unmarshal_int();
/* 310 */         this.EQUIP_FUHUN_OPEN_LEVEL = _os_.unmarshal_int();
/* 311 */         this.MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP = _os_.unmarshal_int();
/* 312 */         this.EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL = _os_.unmarshal_int();
/* 313 */         this.MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL = _os_.unmarshal_int();
/* 314 */         this.MIN_EQUIP_LEVEL_FOR_DISASSEMBLE = _os_.unmarshal_int();
/* 315 */         this.MIN_EQUIP_COLOR_FOR_DISASSEMBLE = _os_.unmarshal_int();
/* 316 */         this.IS_BIND_EQUIP_CAN_DISASSEMBLE = _os_.unmarshal_boolean();
/* 317 */         this.EQUIP_DISASSEMBLE_PRICE_RATE = _os_.unmarshal_int();
/* 318 */         this.EQUIP_DISASSEMBLE_OUT_PUT_ITEMID = _os_.unmarshal_int();
/* 319 */         this.N_LEVEL_EQUIP_MAKE_SWITCH = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 324 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 330 */     String path = dir + "mzm.gsp.item.confbean.EquipItemCfgConsts.bny";
/*     */     try
/*     */     {
/* 333 */       File file = new File(path);
/* 334 */       if (file.exists())
/*     */       {
/* 336 */         byte[] bytes = new byte['Ѐ'];
/* 337 */         FileInputStream fis = new FileInputStream(file);
/* 338 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 339 */         int len = 0;
/* 340 */         while ((len = fis.read(bytes)) > 0)
/* 341 */           baos.write(bytes, 0, len);
/* 342 */         fis.close();
/* 343 */         bytes = baos.toByteArray();
/* 344 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 345 */         this.QILIN_NEED_ITEM_ID = _os_.unmarshal_int();
/* 346 */         this.FUHUN_NEED_ITEM_ID = _os_.unmarshal_int();
/* 347 */         this.PRIMARY_LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 348 */         this.MIDDLE_LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 349 */         this.SENIOR_LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 350 */         this.LUCKY_ITEM_ID = _os_.unmarshal_int();
/* 351 */         this.ZHENLIN_STONE_ITEM_ID = _os_.unmarshal_int();
/* 352 */         this.SAME_LEVEL_DEC_LIN_LEVEL = _os_.unmarshal_int();
/* 353 */         this.DIFF_LEVEL_DEC_LIN_LEVEL = _os_.unmarshal_int();
/* 354 */         this.CHUANCHENG_UPPER_MAIN_EQUIP_MIN_LEVEL = _os_.unmarshal_int();
/* 355 */         this.DIE_USEPOINT_DEC_VALUE = _os_.unmarshal_int();
/* 356 */         this.USEPOINT_DEC_RATE = _os_.unmarshal_int();
/* 357 */         this.USEPOINT_DEC_VALUE = _os_.unmarshal_int();
/* 358 */         this.USEPOINT_WARN_VALUE = _os_.unmarshal_int();
/* 359 */         this.MAX_DELTA_OF_EQUIP_LEVEL_TO_ROLE_LEVEL = _os_.unmarshal_int();
/* 360 */         this.EQUIP_MAKE_MIN_LEVEL = _os_.unmarshal_int();
/* 361 */         this.EQUIP_QILIN_MAX_LIN_LEVEL = _os_.unmarshal_int();
/* 362 */         this.EQUIP_GUIJI_MIN_LIN_LEVEL = _os_.unmarshal_int();
/* 363 */         this.EQUIP_ANNOUNCE_MIN_LIN_LEVEL = _os_.unmarshal_int();
/* 364 */         this.BOUND_FIX_TIP_MAX_USEPOINT = _os_.unmarshal_int();
/* 365 */         this.MAKE_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 366 */         this.QILIN_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 367 */         this.QILIN_FAIL_EFFECT_ID = _os_.unmarshal_int();
/* 368 */         this.INHEIRT_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 369 */         this.TRANSFER_SUCC_EFFECT_ID = _os_.unmarshal_int();
/* 370 */         this.EQUIP_MAKE_YUANBAO_PRICE_DELTA = _os_.unmarshal_int();
/* 371 */         this.MAX_JIGAO = _os_.unmarshal_int();
/* 372 */         this.MIN_JIGAO = _os_.unmarshal_int();
/* 373 */         this.MAX_JIAOGAO = _os_.unmarshal_int();
/* 374 */         this.MIN_JIAOGAO = _os_.unmarshal_int();
/* 375 */         this.MAX_YIBAN = _os_.unmarshal_int();
/* 376 */         this.MIN_YIBAN = _os_.unmarshal_int();
/* 377 */         this.MAX_JIAODI = _os_.unmarshal_int();
/* 378 */         this.MIN_JIAODI = _os_.unmarshal_int();
/* 379 */         this.MAX_JIDI = _os_.unmarshal_int();
/* 380 */         this.MIN_JIDI = _os_.unmarshal_int();
/* 381 */         this.MIN_LEVEL_FOR_QILIN = _os_.unmarshal_int();
/* 382 */         this.MAX_NUM_NUM = _os_.unmarshal_int();
/* 383 */         this.EQUIP_MAKE_OPEN_LEVEL = _os_.unmarshal_int();
/* 384 */         this.EQUIP_QILIN_OPEN_LEVEL = _os_.unmarshal_int();
/* 385 */         this.EQUIP_XIHUN_OPEN_LEVEL = _os_.unmarshal_int();
/* 386 */         this.EQUIP_INHERIT_OPEN_LEVEL = _os_.unmarshal_int();
/* 387 */         this.EQUIP_FUHUN_OPEN_LEVEL = _os_.unmarshal_int();
/* 388 */         this.MIN_EQUIP_MAKE_COUNT_FOR_OUTPUT_ORANGE_EQUIP = _os_.unmarshal_int();
/* 389 */         this.EQUIP_QILIN_USE_ZHENLINGSHI_LEVEL = _os_.unmarshal_int();
/* 390 */         this.MIN_COUNT_FOR_OUTPUT_ORANGE_EQUIP_SKILL = _os_.unmarshal_int();
/* 391 */         this.MIN_EQUIP_LEVEL_FOR_DISASSEMBLE = _os_.unmarshal_int();
/* 392 */         this.MIN_EQUIP_COLOR_FOR_DISASSEMBLE = _os_.unmarshal_int();
/* 393 */         this.IS_BIND_EQUIP_CAN_DISASSEMBLE = _os_.unmarshal_boolean();
/* 394 */         this.EQUIP_DISASSEMBLE_PRICE_RATE = _os_.unmarshal_int();
/* 395 */         this.EQUIP_DISASSEMBLE_OUT_PUT_ITEMID = _os_.unmarshal_int();
/* 396 */         this.N_LEVEL_EQUIP_MAKE_SWITCH = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 401 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(EquipItemCfgConsts newInstance)
/*     */   {
/* 407 */     oldInstance = instance;
/* 408 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 413 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\EquipItemCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */