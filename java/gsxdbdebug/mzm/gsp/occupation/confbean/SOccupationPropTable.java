/*     */ package mzm.gsp.occupation.confbean;
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
/*     */ public class SOccupationPropTable implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOccupationPropTable> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOccupationPropTable> all = null;
/*     */   
/*     */   public int id;
/*     */   public String occupationName;
/*     */   public int occupationId;
/*     */   public int modelPath;
/*     */   public int gender;
/*     */   public boolean isAssist;
/*     */   public int occupationType;
/*     */   public int CON;
/*     */   public int STR;
/*     */   public int SPR;
/*     */   public int STA;
/*     */   public int DEX;
/*     */   public int HP;
/*     */   public int MP;
/*     */   public double PHY_ATK;
/*     */   public double MAG_ATK;
/*     */   public double PHY_DEF;
/*     */   public double MAG_DEF;
/*     */   public double PHY_CRT_LEVEL;
/*     */   public double MAG_CRT_LEVEL;
/*     */   public double PHY_CRT_DEF_LEVEL;
/*     */   public double MAG_CRT_DEF_LEVEL;
/*     */   public double PHY_CRT_RATE;
/*     */   public double MAG_CRT_RATE;
/*     */   public double PHY_CRT;
/*     */   public double MAG_CRT;
/*     */   public double SEAL_HIT_LEVEL;
/*     */   public double SEAL_RES_LEVEL;
/*     */   public double PHY_HIT_LEVEL;
/*     */   public double PHY_DODAGE_LEVEL;
/*     */   public double MAG_HIT_LEVEL;
/*     */   public double MAG_DODAGE_LEVEL;
/*     */   public double SPEED;
/*     */   public int CON_PER_LEVEL_EXPREE_ID;
/*     */   public int STR_PER_LEVEL_EXPREE_ID;
/*     */   public int SPR_PER_LEVEL_EXPREE_ID;
/*     */   public int STA_PER_LEVEL_EXPREE_ID;
/*     */   public int DEX_PER_LEVEL_EXPREE_ID;
/*     */   public double CON_PER_LEVEL;
/*     */   public double STR_PER_LEVEL;
/*     */   public double SPR_PER_LEVEL;
/*     */   public double STA_PER_LEVEL;
/*     */   public double DEX_PER_LEVEL;
/*     */   public double HP_PER_LEVEL;
/*     */   public double MP_PER_LEVEL;
/*     */   public double PHY_ATK_PER_LEVEL;
/*     */   public double MAG_ATK_PER_LEVEL;
/*     */   public double PHY_DEF_PER_LEVEL;
/*     */   public double MAG_DEF_PER_LEVEL;
/*     */   public double PHY_CRT_LEVEL_PER_LEVEL;
/*     */   public double MAG_CRT_LEVEL_PER_LEVEL;
/*     */   public double PHY_CRT_LEVEL_DEF_PER_LEVEL;
/*     */   public double MAG_CRT_LEVEL_DEF_PER_LEVEL;
/*     */   public double PHY_CRT_RATE_PER_LEVEL;
/*     */   public double MAG_CRT_RATE_PER_LEVEL;
/*     */   public double PHY_CRT_PER_LEVEL;
/*     */   public double MAG_CRT_PER_LEVEL;
/*     */   public double SEAL_HIT_LEVEL_PER_LEVEL;
/*     */   public double SEAL_RES_LEVEL_PER_LEVEL;
/*     */   public double PHY_HIT_LEVEL_PER_LEVEL;
/*     */   public double PHY_DODAGE_LEVEL_PER_LEVEL;
/*     */   public double MAG_HIT_LEVEL_PER_LEVEL;
/*     */   public double MAG_DODAGE_LEVEL_PER_LEVEL;
/*     */   public double SPEED_PER_LEVEL;
/*     */   public int RECOMMEND_ASIGN_STR;
/*     */   public int RECOMMEND_ASIGN_SPR;
/*     */   public int RECOMMEND_ASIGN_CON;
/*     */   public int RECOMMEND_ASIGN_STA;
/*     */   public int RECOMMEND_ASIGN_DEX;
/*     */   public int OCCUPATION_MAP_ID;
/*     */   public int addPointCaseId;
/*     */   public int switchId;
/*     */   public int defaultAvatarId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  94 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  95 */     this.occupationName = rootElement.attributeValue("occupationName");
/*  96 */     this.occupationId = Integer.valueOf(rootElement.attributeValue("occupationId")).intValue();
/*  97 */     this.modelPath = Integer.valueOf(rootElement.attributeValue("modelPath")).intValue();
/*  98 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  99 */     this.isAssist = Boolean.valueOf(rootElement.attributeValue("isAssist")).booleanValue();
/* 100 */     this.occupationType = Integer.valueOf(rootElement.attributeValue("occupationType")).intValue();
/* 101 */     this.CON = Integer.valueOf(rootElement.attributeValue("CON")).intValue();
/* 102 */     this.STR = Integer.valueOf(rootElement.attributeValue("STR")).intValue();
/* 103 */     this.SPR = Integer.valueOf(rootElement.attributeValue("SPR")).intValue();
/* 104 */     this.STA = Integer.valueOf(rootElement.attributeValue("STA")).intValue();
/* 105 */     this.DEX = Integer.valueOf(rootElement.attributeValue("DEX")).intValue();
/* 106 */     this.HP = Integer.valueOf(rootElement.attributeValue("HP")).intValue();
/* 107 */     this.MP = Integer.valueOf(rootElement.attributeValue("MP")).intValue();
/* 108 */     this.PHY_ATK = Double.valueOf(rootElement.attributeValue("PHY_ATK")).doubleValue();
/* 109 */     this.MAG_ATK = Double.valueOf(rootElement.attributeValue("MAG_ATK")).doubleValue();
/* 110 */     this.PHY_DEF = Double.valueOf(rootElement.attributeValue("PHY_DEF")).doubleValue();
/* 111 */     this.MAG_DEF = Double.valueOf(rootElement.attributeValue("MAG_DEF")).doubleValue();
/* 112 */     this.PHY_CRT_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL")).doubleValue();
/* 113 */     this.MAG_CRT_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL")).doubleValue();
/* 114 */     this.PHY_CRT_DEF_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_DEF_LEVEL")).doubleValue();
/* 115 */     this.MAG_CRT_DEF_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_DEF_LEVEL")).doubleValue();
/* 116 */     this.PHY_CRT_RATE = Double.valueOf(rootElement.attributeValue("PHY_CRT_RATE")).doubleValue();
/* 117 */     this.MAG_CRT_RATE = Double.valueOf(rootElement.attributeValue("MAG_CRT_RATE")).doubleValue();
/* 118 */     this.PHY_CRT = Double.valueOf(rootElement.attributeValue("PHY_CRT")).doubleValue();
/* 119 */     this.MAG_CRT = Double.valueOf(rootElement.attributeValue("MAG_CRT")).doubleValue();
/* 120 */     this.SEAL_HIT_LEVEL = Double.valueOf(rootElement.attributeValue("SEAL_HIT_LEVEL")).doubleValue();
/* 121 */     this.SEAL_RES_LEVEL = Double.valueOf(rootElement.attributeValue("SEAL_RES_LEVEL")).doubleValue();
/* 122 */     this.PHY_HIT_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_HIT_LEVEL")).doubleValue();
/* 123 */     this.PHY_DODAGE_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_DODAGE_LEVEL")).doubleValue();
/* 124 */     this.MAG_HIT_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_HIT_LEVEL")).doubleValue();
/* 125 */     this.MAG_DODAGE_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_DODAGE_LEVEL")).doubleValue();
/* 126 */     this.SPEED = Double.valueOf(rootElement.attributeValue("SPEED")).doubleValue();
/* 127 */     this.CON_PER_LEVEL_EXPREE_ID = Integer.valueOf(rootElement.attributeValue("CON_PER_LEVEL_EXPREE_ID")).intValue();
/* 128 */     this.STR_PER_LEVEL_EXPREE_ID = Integer.valueOf(rootElement.attributeValue("STR_PER_LEVEL_EXPREE_ID")).intValue();
/* 129 */     this.SPR_PER_LEVEL_EXPREE_ID = Integer.valueOf(rootElement.attributeValue("SPR_PER_LEVEL_EXPREE_ID")).intValue();
/* 130 */     this.STA_PER_LEVEL_EXPREE_ID = Integer.valueOf(rootElement.attributeValue("STA_PER_LEVEL_EXPREE_ID")).intValue();
/* 131 */     this.DEX_PER_LEVEL_EXPREE_ID = Integer.valueOf(rootElement.attributeValue("DEX_PER_LEVEL_EXPREE_ID")).intValue();
/* 132 */     this.CON_PER_LEVEL = Double.valueOf(rootElement.attributeValue("CON_PER_LEVEL")).doubleValue();
/* 133 */     this.STR_PER_LEVEL = Double.valueOf(rootElement.attributeValue("STR_PER_LEVEL")).doubleValue();
/* 134 */     this.SPR_PER_LEVEL = Double.valueOf(rootElement.attributeValue("SPR_PER_LEVEL")).doubleValue();
/* 135 */     this.STA_PER_LEVEL = Double.valueOf(rootElement.attributeValue("STA_PER_LEVEL")).doubleValue();
/* 136 */     this.DEX_PER_LEVEL = Double.valueOf(rootElement.attributeValue("DEX_PER_LEVEL")).doubleValue();
/* 137 */     this.HP_PER_LEVEL = Double.valueOf(rootElement.attributeValue("HP_PER_LEVEL")).doubleValue();
/* 138 */     this.MP_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MP_PER_LEVEL")).doubleValue();
/* 139 */     this.PHY_ATK_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_ATK_PER_LEVEL")).doubleValue();
/* 140 */     this.MAG_ATK_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_ATK_PER_LEVEL")).doubleValue();
/* 141 */     this.PHY_DEF_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_DEF_PER_LEVEL")).doubleValue();
/* 142 */     this.MAG_DEF_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_DEF_PER_LEVEL")).doubleValue();
/* 143 */     this.PHY_CRT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL_PER_LEVEL")).doubleValue();
/* 144 */     this.MAG_CRT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL_PER_LEVEL")).doubleValue();
/* 145 */     this.PHY_CRT_LEVEL_DEF_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL_DEF_PER_LEVEL")).doubleValue();
/* 146 */     this.MAG_CRT_LEVEL_DEF_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL_DEF_PER_LEVEL")).doubleValue();
/* 147 */     this.PHY_CRT_RATE_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_RATE_PER_LEVEL")).doubleValue();
/* 148 */     this.MAG_CRT_RATE_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_RATE_PER_LEVEL")).doubleValue();
/* 149 */     this.PHY_CRT_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_PER_LEVEL")).doubleValue();
/* 150 */     this.MAG_CRT_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_PER_LEVEL")).doubleValue();
/* 151 */     this.SEAL_HIT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("SEAL_HIT_LEVEL_PER_LEVEL")).doubleValue();
/* 152 */     this.SEAL_RES_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("SEAL_RES_LEVEL_PER_LEVEL")).doubleValue();
/* 153 */     this.PHY_HIT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_HIT_LEVEL_PER_LEVEL")).doubleValue();
/* 154 */     this.PHY_DODAGE_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_DODAGE_LEVEL_PER_LEVEL")).doubleValue();
/* 155 */     this.MAG_HIT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_HIT_LEVEL_PER_LEVEL")).doubleValue();
/* 156 */     this.MAG_DODAGE_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_DODAGE_LEVEL_PER_LEVEL")).doubleValue();
/* 157 */     this.SPEED_PER_LEVEL = Double.valueOf(rootElement.attributeValue("SPEED_PER_LEVEL")).doubleValue();
/* 158 */     this.RECOMMEND_ASIGN_STR = Integer.valueOf(rootElement.attributeValue("RECOMMEND_ASIGN_STR")).intValue();
/* 159 */     this.RECOMMEND_ASIGN_SPR = Integer.valueOf(rootElement.attributeValue("RECOMMEND_ASIGN_SPR")).intValue();
/* 160 */     this.RECOMMEND_ASIGN_CON = Integer.valueOf(rootElement.attributeValue("RECOMMEND_ASIGN_CON")).intValue();
/* 161 */     this.RECOMMEND_ASIGN_STA = Integer.valueOf(rootElement.attributeValue("RECOMMEND_ASIGN_STA")).intValue();
/* 162 */     this.RECOMMEND_ASIGN_DEX = Integer.valueOf(rootElement.attributeValue("RECOMMEND_ASIGN_DEX")).intValue();
/* 163 */     this.OCCUPATION_MAP_ID = Integer.valueOf(rootElement.attributeValue("OCCUPATION_MAP_ID")).intValue();
/* 164 */     this.addPointCaseId = Integer.valueOf(rootElement.attributeValue("addPointCaseId")).intValue();
/* 165 */     this.switchId = Integer.valueOf(rootElement.attributeValue("switchId")).intValue();
/* 166 */     this.defaultAvatarId = Integer.valueOf(rootElement.attributeValue("defaultAvatarId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 171 */     _os_.marshal(this.id);
/* 172 */     _os_.marshal(this.occupationName, "UTF-8");
/* 173 */     _os_.marshal(this.occupationId);
/* 174 */     _os_.marshal(this.modelPath);
/* 175 */     _os_.marshal(this.gender);
/* 176 */     _os_.marshal(this.isAssist);
/* 177 */     _os_.marshal(this.occupationType);
/* 178 */     _os_.marshal(this.CON);
/* 179 */     _os_.marshal(this.STR);
/* 180 */     _os_.marshal(this.SPR);
/* 181 */     _os_.marshal(this.STA);
/* 182 */     _os_.marshal(this.DEX);
/* 183 */     _os_.marshal(this.HP);
/* 184 */     _os_.marshal(this.MP);
/* 185 */     _os_.marshal(this.PHY_ATK);
/* 186 */     _os_.marshal(this.MAG_ATK);
/* 187 */     _os_.marshal(this.PHY_DEF);
/* 188 */     _os_.marshal(this.MAG_DEF);
/* 189 */     _os_.marshal(this.PHY_CRT_LEVEL);
/* 190 */     _os_.marshal(this.MAG_CRT_LEVEL);
/* 191 */     _os_.marshal(this.PHY_CRT_DEF_LEVEL);
/* 192 */     _os_.marshal(this.MAG_CRT_DEF_LEVEL);
/* 193 */     _os_.marshal(this.PHY_CRT_RATE);
/* 194 */     _os_.marshal(this.MAG_CRT_RATE);
/* 195 */     _os_.marshal(this.PHY_CRT);
/* 196 */     _os_.marshal(this.MAG_CRT);
/* 197 */     _os_.marshal(this.SEAL_HIT_LEVEL);
/* 198 */     _os_.marshal(this.SEAL_RES_LEVEL);
/* 199 */     _os_.marshal(this.PHY_HIT_LEVEL);
/* 200 */     _os_.marshal(this.PHY_DODAGE_LEVEL);
/* 201 */     _os_.marshal(this.MAG_HIT_LEVEL);
/* 202 */     _os_.marshal(this.MAG_DODAGE_LEVEL);
/* 203 */     _os_.marshal(this.SPEED);
/* 204 */     _os_.marshal(this.CON_PER_LEVEL_EXPREE_ID);
/* 205 */     _os_.marshal(this.STR_PER_LEVEL_EXPREE_ID);
/* 206 */     _os_.marshal(this.SPR_PER_LEVEL_EXPREE_ID);
/* 207 */     _os_.marshal(this.STA_PER_LEVEL_EXPREE_ID);
/* 208 */     _os_.marshal(this.DEX_PER_LEVEL_EXPREE_ID);
/* 209 */     _os_.marshal(this.CON_PER_LEVEL);
/* 210 */     _os_.marshal(this.STR_PER_LEVEL);
/* 211 */     _os_.marshal(this.SPR_PER_LEVEL);
/* 212 */     _os_.marshal(this.STA_PER_LEVEL);
/* 213 */     _os_.marshal(this.DEX_PER_LEVEL);
/* 214 */     _os_.marshal(this.HP_PER_LEVEL);
/* 215 */     _os_.marshal(this.MP_PER_LEVEL);
/* 216 */     _os_.marshal(this.PHY_ATK_PER_LEVEL);
/* 217 */     _os_.marshal(this.MAG_ATK_PER_LEVEL);
/* 218 */     _os_.marshal(this.PHY_DEF_PER_LEVEL);
/* 219 */     _os_.marshal(this.MAG_DEF_PER_LEVEL);
/* 220 */     _os_.marshal(this.PHY_CRT_LEVEL_PER_LEVEL);
/* 221 */     _os_.marshal(this.MAG_CRT_LEVEL_PER_LEVEL);
/* 222 */     _os_.marshal(this.PHY_CRT_LEVEL_DEF_PER_LEVEL);
/* 223 */     _os_.marshal(this.MAG_CRT_LEVEL_DEF_PER_LEVEL);
/* 224 */     _os_.marshal(this.PHY_CRT_RATE_PER_LEVEL);
/* 225 */     _os_.marshal(this.MAG_CRT_RATE_PER_LEVEL);
/* 226 */     _os_.marshal(this.PHY_CRT_PER_LEVEL);
/* 227 */     _os_.marshal(this.MAG_CRT_PER_LEVEL);
/* 228 */     _os_.marshal(this.SEAL_HIT_LEVEL_PER_LEVEL);
/* 229 */     _os_.marshal(this.SEAL_RES_LEVEL_PER_LEVEL);
/* 230 */     _os_.marshal(this.PHY_HIT_LEVEL_PER_LEVEL);
/* 231 */     _os_.marshal(this.PHY_DODAGE_LEVEL_PER_LEVEL);
/* 232 */     _os_.marshal(this.MAG_HIT_LEVEL_PER_LEVEL);
/* 233 */     _os_.marshal(this.MAG_DODAGE_LEVEL_PER_LEVEL);
/* 234 */     _os_.marshal(this.SPEED_PER_LEVEL);
/* 235 */     _os_.marshal(this.RECOMMEND_ASIGN_STR);
/* 236 */     _os_.marshal(this.RECOMMEND_ASIGN_SPR);
/* 237 */     _os_.marshal(this.RECOMMEND_ASIGN_CON);
/* 238 */     _os_.marshal(this.RECOMMEND_ASIGN_STA);
/* 239 */     _os_.marshal(this.RECOMMEND_ASIGN_DEX);
/* 240 */     _os_.marshal(this.OCCUPATION_MAP_ID);
/* 241 */     _os_.marshal(this.addPointCaseId);
/* 242 */     _os_.marshal(this.switchId);
/* 243 */     _os_.marshal(this.defaultAvatarId);
/* 244 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 249 */     this.id = _os_.unmarshal_int();
/* 250 */     this.occupationName = _os_.unmarshal_String("UTF-8");
/* 251 */     this.occupationId = _os_.unmarshal_int();
/* 252 */     this.modelPath = _os_.unmarshal_int();
/* 253 */     this.gender = _os_.unmarshal_int();
/* 254 */     this.isAssist = _os_.unmarshal_boolean();
/* 255 */     this.occupationType = _os_.unmarshal_int();
/* 256 */     this.CON = _os_.unmarshal_int();
/* 257 */     this.STR = _os_.unmarshal_int();
/* 258 */     this.SPR = _os_.unmarshal_int();
/* 259 */     this.STA = _os_.unmarshal_int();
/* 260 */     this.DEX = _os_.unmarshal_int();
/* 261 */     this.HP = _os_.unmarshal_int();
/* 262 */     this.MP = _os_.unmarshal_int();
/* 263 */     this.PHY_ATK = _os_.unmarshal_float();
/* 264 */     this.MAG_ATK = _os_.unmarshal_float();
/* 265 */     this.PHY_DEF = _os_.unmarshal_float();
/* 266 */     this.MAG_DEF = _os_.unmarshal_float();
/* 267 */     this.PHY_CRT_LEVEL = _os_.unmarshal_float();
/* 268 */     this.MAG_CRT_LEVEL = _os_.unmarshal_float();
/* 269 */     this.PHY_CRT_DEF_LEVEL = _os_.unmarshal_float();
/* 270 */     this.MAG_CRT_DEF_LEVEL = _os_.unmarshal_float();
/* 271 */     this.PHY_CRT_RATE = _os_.unmarshal_float();
/* 272 */     this.MAG_CRT_RATE = _os_.unmarshal_float();
/* 273 */     this.PHY_CRT = _os_.unmarshal_float();
/* 274 */     this.MAG_CRT = _os_.unmarshal_float();
/* 275 */     this.SEAL_HIT_LEVEL = _os_.unmarshal_float();
/* 276 */     this.SEAL_RES_LEVEL = _os_.unmarshal_float();
/* 277 */     this.PHY_HIT_LEVEL = _os_.unmarshal_float();
/* 278 */     this.PHY_DODAGE_LEVEL = _os_.unmarshal_float();
/* 279 */     this.MAG_HIT_LEVEL = _os_.unmarshal_float();
/* 280 */     this.MAG_DODAGE_LEVEL = _os_.unmarshal_float();
/* 281 */     this.SPEED = _os_.unmarshal_float();
/* 282 */     this.CON_PER_LEVEL_EXPREE_ID = _os_.unmarshal_int();
/* 283 */     this.STR_PER_LEVEL_EXPREE_ID = _os_.unmarshal_int();
/* 284 */     this.SPR_PER_LEVEL_EXPREE_ID = _os_.unmarshal_int();
/* 285 */     this.STA_PER_LEVEL_EXPREE_ID = _os_.unmarshal_int();
/* 286 */     this.DEX_PER_LEVEL_EXPREE_ID = _os_.unmarshal_int();
/* 287 */     this.CON_PER_LEVEL = _os_.unmarshal_float();
/* 288 */     this.STR_PER_LEVEL = _os_.unmarshal_float();
/* 289 */     this.SPR_PER_LEVEL = _os_.unmarshal_float();
/* 290 */     this.STA_PER_LEVEL = _os_.unmarshal_float();
/* 291 */     this.DEX_PER_LEVEL = _os_.unmarshal_float();
/* 292 */     this.HP_PER_LEVEL = _os_.unmarshal_float();
/* 293 */     this.MP_PER_LEVEL = _os_.unmarshal_float();
/* 294 */     this.PHY_ATK_PER_LEVEL = _os_.unmarshal_float();
/* 295 */     this.MAG_ATK_PER_LEVEL = _os_.unmarshal_float();
/* 296 */     this.PHY_DEF_PER_LEVEL = _os_.unmarshal_float();
/* 297 */     this.MAG_DEF_PER_LEVEL = _os_.unmarshal_float();
/* 298 */     this.PHY_CRT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 299 */     this.MAG_CRT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 300 */     this.PHY_CRT_LEVEL_DEF_PER_LEVEL = _os_.unmarshal_float();
/* 301 */     this.MAG_CRT_LEVEL_DEF_PER_LEVEL = _os_.unmarshal_float();
/* 302 */     this.PHY_CRT_RATE_PER_LEVEL = _os_.unmarshal_float();
/* 303 */     this.MAG_CRT_RATE_PER_LEVEL = _os_.unmarshal_float();
/* 304 */     this.PHY_CRT_PER_LEVEL = _os_.unmarshal_float();
/* 305 */     this.MAG_CRT_PER_LEVEL = _os_.unmarshal_float();
/* 306 */     this.SEAL_HIT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 307 */     this.SEAL_RES_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 308 */     this.PHY_HIT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 309 */     this.PHY_DODAGE_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 310 */     this.MAG_HIT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 311 */     this.MAG_DODAGE_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 312 */     this.SPEED_PER_LEVEL = _os_.unmarshal_float();
/* 313 */     this.RECOMMEND_ASIGN_STR = _os_.unmarshal_int();
/* 314 */     this.RECOMMEND_ASIGN_SPR = _os_.unmarshal_int();
/* 315 */     this.RECOMMEND_ASIGN_CON = _os_.unmarshal_int();
/* 316 */     this.RECOMMEND_ASIGN_STA = _os_.unmarshal_int();
/* 317 */     this.RECOMMEND_ASIGN_DEX = _os_.unmarshal_int();
/* 318 */     this.OCCUPATION_MAP_ID = _os_.unmarshal_int();
/* 319 */     this.addPointCaseId = _os_.unmarshal_int();
/* 320 */     this.switchId = _os_.unmarshal_int();
/* 321 */     this.defaultAvatarId = _os_.unmarshal_int();
/* 322 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 327 */     String path = dir + "mzm.gsp.occupation.confbean.SOccupationPropTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 331 */       all = new java.util.HashMap();
/* 332 */       SAXReader reader = new SAXReader();
/* 333 */       org.dom4j.Document doc = reader.read(new File(path));
/* 334 */       Element root = doc.getRootElement();
/* 335 */       List<?> nodeList = root.elements();
/* 336 */       int len = nodeList.size();
/* 337 */       for (int i = 0; i < len; i++)
/*     */       {
/* 339 */         Element elem = (Element)nodeList.get(i);
/* 340 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.occupation.confbean.SOccupationPropTable"))
/*     */         {
/*     */ 
/* 343 */           SOccupationPropTable obj = new SOccupationPropTable();
/* 344 */           obj.loadFromXml(elem);
/* 345 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 346 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 351 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOccupationPropTable> all)
/*     */   {
/* 357 */     String path = dir + "mzm.gsp.occupation.confbean.SOccupationPropTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 361 */       SAXReader reader = new SAXReader();
/* 362 */       org.dom4j.Document doc = reader.read(new File(path));
/* 363 */       Element root = doc.getRootElement();
/* 364 */       List<?> nodeList = root.elements();
/* 365 */       int len = nodeList.size();
/* 366 */       for (int i = 0; i < len; i++)
/*     */       {
/* 368 */         Element elem = (Element)nodeList.get(i);
/* 369 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.occupation.confbean.SOccupationPropTable"))
/*     */         {
/*     */ 
/* 372 */           SOccupationPropTable obj = new SOccupationPropTable();
/* 373 */           obj.loadFromXml(elem);
/* 374 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 375 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 380 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 386 */     all = new java.util.HashMap();
/*     */     
/* 388 */     String path = dir + "mzm.gsp.occupation.confbean.SOccupationPropTable.bny";
/*     */     try
/*     */     {
/* 391 */       File file = new File(path);
/* 392 */       if (file.exists())
/*     */       {
/* 394 */         byte[] bytes = new byte['Ѐ'];
/* 395 */         FileInputStream fis = new FileInputStream(file);
/* 396 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 397 */         int len = 0;
/* 398 */         while ((len = fis.read(bytes)) > 0)
/* 399 */           baos.write(bytes, 0, len);
/* 400 */         fis.close();
/* 401 */         bytes = baos.toByteArray();
/* 402 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 403 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 405 */           _os_.unmarshal_int();
/* 406 */           _os_.unmarshal_int();
/* 407 */           _os_.unmarshal_int();
/*     */         }
/* 409 */         _os_.unmarshal_int();
/* 410 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 413 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 415 */           SOccupationPropTable _v_ = new SOccupationPropTable();
/* 416 */           _v_.unmarshal(_os_);
/* 417 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 418 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 423 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 428 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOccupationPropTable> all)
/*     */   {
/* 435 */     String path = dir + "mzm.gsp.occupation.confbean.SOccupationPropTable.bny";
/*     */     try
/*     */     {
/* 438 */       File file = new File(path);
/* 439 */       if (file.exists())
/*     */       {
/* 441 */         byte[] bytes = new byte['Ѐ'];
/* 442 */         FileInputStream fis = new FileInputStream(file);
/* 443 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 444 */         int len = 0;
/* 445 */         while ((len = fis.read(bytes)) > 0)
/* 446 */           baos.write(bytes, 0, len);
/* 447 */         fis.close();
/* 448 */         bytes = baos.toByteArray();
/* 449 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 450 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 452 */           _os_.unmarshal_int();
/* 453 */           _os_.unmarshal_int();
/* 454 */           _os_.unmarshal_int();
/*     */         }
/* 456 */         _os_.unmarshal_int();
/* 457 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 460 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 462 */           SOccupationPropTable _v_ = new SOccupationPropTable();
/* 463 */           _v_.unmarshal(_os_);
/* 464 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 465 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 470 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 475 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOccupationPropTable getOld(int key)
/*     */   {
/* 483 */     return (SOccupationPropTable)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOccupationPropTable get(int key)
/*     */   {
/* 488 */     return (SOccupationPropTable)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOccupationPropTable> getOldAll()
/*     */   {
/* 493 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOccupationPropTable> getAll()
/*     */   {
/* 498 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOccupationPropTable> newAll)
/*     */   {
/* 503 */     oldAll = all;
/* 504 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 509 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\occupation\confbean\SOccupationPropTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */