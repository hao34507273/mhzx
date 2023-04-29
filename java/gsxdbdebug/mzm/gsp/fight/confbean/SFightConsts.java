/*     */ package mzm.gsp.fight.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SFightConsts
/*     */ {
/*  13 */   private static volatile SFightConsts oldInstance = null;
/*     */   
/*  15 */   private static SFightConsts instance = new SFightConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SFightConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFightConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int NORMAL_FIGHTtEAM_MONSTERNUM = 10;
/*  32 */   public int WAIT_CMD_TIME = 27;
/*  33 */   public int ANGER_MAX = 150;
/*  34 */   public int CAPTURE_RATE_MAX = 10000;
/*  35 */   public int DAMAGEWAVEMAX = 500;
/*  36 */   public int DAMAGEWAVEMIN = 65036;
/*  37 */   public double A = 1.0D;
/*  38 */   public double B = 1.0D;
/*  39 */   public double C = 1.0D;
/*  40 */   public double D = 1.0D;
/*  41 */   public double E = 0.1D;
/*  42 */   public double F = 0.1D;
/*  43 */   public double G1 = 1.5D;
/*  44 */   public double G2 = 0.8D;
/*  45 */   public double H = 2.0D;
/*  46 */   public double I = 2.0D;
/*  47 */   public double J = 2.0D;
/*  48 */   public double K = 2.0D;
/*  49 */   public double L = 2.0D;
/*  50 */   public double M = 2.0D;
/*  51 */   public double N = 2.0D;
/*  52 */   public double O = 9.0D;
/*  53 */   public double P = 51.0D;
/*  54 */   public double Q = 0.1D;
/*  55 */   public double R = 3.0D;
/*  56 */   public double S = 3000.0D;
/*  57 */   public double T = 8500.0D;
/*  58 */   public double U = 9000.0D;
/*  59 */   public int DEFAULT_ACTION_DURATION = 500;
/*  60 */   public int DEFAULT_EFFECT_DURATION = 500;
/*  61 */   public int WORDS_DURATION = 1000;
/*  62 */   public int ESCAPE_ACTION_TIME = 500;
/*  63 */   public int CHANGE_MODEL_ACTION_TIME = 2000;
/*  64 */   public int CHANGE_FIGHTER_ACTION_TIME = 2000;
/*  65 */   public int ATTACK_SKILL = 1000;
/*  66 */   public int DEFENCE_SKILL = 110000000;
/*  67 */   public int MAG_SKILL = 110000000;
/*  68 */   public int PROTECT_PLAY_TIME = 2000;
/*  69 */   public int SPEED_FLUCTUATE_RATE = 500;
/*  70 */   public int DAMAGE_RATE_PROTECT = 5000;
/*  71 */   public int DAMAGE_SKILL_PLAY_TIME = 2000;
/*  72 */   public int DRAG_USE_TIMES = 5;
/*  73 */   public int SUMMON_TIMES = 5;
/*  74 */   public int DRAG_USE_SKILL_PLAYId = 160100000;
/*  75 */   public int CAPTURE_SKILL_PLAYId = 160100000;
/*  76 */   public int SUMMON_SKILL_PLAYId = 160100000;
/*  77 */   public int PVP_ESCAPE_RATE = 1000;
/*  78 */   public int PVE_ESCAPE_RATE = 7000;
/*  79 */   public int PVC_ESCAPE_RATE = 7000;
/*  80 */   public int OBSERVER_NUM_LIMIT = 200;
/*  81 */   public int OBSERVER_DIS_NUM = 6;
/*  82 */   public int ENERGY_MAX = 3;
/*  83 */   public int WORDS_ROUND_TIME = 500;
/*  84 */   public int DISSOLVE_EFFECT_TIME = 2500;
/*  85 */   public int BREAK_EFFECT_TIME = 1000;
/*  86 */   public int BEATTACKED_ACTION_ID = 4;
/*  87 */   public int DEATH_ACTION_ID = 3;
/*  88 */   public int BEATTACKED_FLY_ACTION_ID = 5;
/*  89 */   public int CLIENT_CALLBACK_EXTRA_TIME = 333;
/*  90 */   public int EXTRA_PLAY_TIME_MAX_PER_ROUND = 3000;
/*  91 */   public int COMMAND_NAME_LENGTH = 4;
/*  92 */   public int AUTO_WAIT_TIME = 3;
/*  93 */   public int OTHER_ROUND_AUTO__WAIT_TIME = 1;
/*  94 */   public int SEAL_NUM_MAX = 3;
/*     */   public int ASSIST_FELLOW_NUM_1;
/*     */   public int ASSIST_COST_MODIFY_RATE_1;
/*     */   public int ASSIST_FELLOW_NUM_2;
/*     */   public int ASSIST_COST_MODIFY_RATE_2;
/*  99 */   public int checkABS = 10;
/* 100 */   public int SEAL_ACTIONED_ADD_LAST_ROUND = 1;
/* 101 */   public int RELIVE_ACTION_ID = 3;
/* 102 */   public int PK_ESCAPE_RATE = 50;
/* 103 */   public int ARREST_WANTED_RED_ESCAPE_RATE = 0;
/* 104 */   public int ARREST_WANTED_ESCAPE_RATE = 50;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 108 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.fight.confbean.SFightConsts.xml";
/*     */     try
/*     */     {
/* 116 */       SAXReader reader = new SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       Map<String, Element> data = new java.util.HashMap();
/* 120 */       java.util.List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element element = (Element)nodeList.get(i);
/* 125 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 128 */           String name = element.attributeValue("name");
/* 129 */           if (data.put(name, element) != null)
/* 130 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 133 */       this.NORMAL_FIGHTtEAM_MONSTERNUM = Integer.valueOf(((Element)data.get("NORMAL_FIGHTtEAM_MONSTERNUM")).attributeValue("value")).intValue();
/* 134 */       this.WAIT_CMD_TIME = Integer.valueOf(((Element)data.get("WAIT_CMD_TIME")).attributeValue("value")).intValue();
/* 135 */       this.ANGER_MAX = Integer.valueOf(((Element)data.get("ANGER_MAX")).attributeValue("value")).intValue();
/* 136 */       this.CAPTURE_RATE_MAX = Integer.valueOf(((Element)data.get("CAPTURE_RATE_MAX")).attributeValue("value")).intValue();
/* 137 */       this.DAMAGEWAVEMAX = Integer.valueOf(((Element)data.get("DAMAGEWAVEMAX")).attributeValue("value")).intValue();
/* 138 */       this.DAMAGEWAVEMIN = Integer.valueOf(((Element)data.get("DAMAGEWAVEMIN")).attributeValue("value")).intValue();
/* 139 */       this.A = Double.valueOf(((Element)data.get("A")).attributeValue("value")).doubleValue();
/* 140 */       this.B = Double.valueOf(((Element)data.get("B")).attributeValue("value")).doubleValue();
/* 141 */       this.C = Double.valueOf(((Element)data.get("C")).attributeValue("value")).doubleValue();
/* 142 */       this.D = Double.valueOf(((Element)data.get("D")).attributeValue("value")).doubleValue();
/* 143 */       this.E = Double.valueOf(((Element)data.get("E")).attributeValue("value")).doubleValue();
/* 144 */       this.F = Double.valueOf(((Element)data.get("F")).attributeValue("value")).doubleValue();
/* 145 */       this.G1 = Double.valueOf(((Element)data.get("G1")).attributeValue("value")).doubleValue();
/* 146 */       this.G2 = Double.valueOf(((Element)data.get("G2")).attributeValue("value")).doubleValue();
/* 147 */       this.H = Double.valueOf(((Element)data.get("H")).attributeValue("value")).doubleValue();
/* 148 */       this.I = Double.valueOf(((Element)data.get("I")).attributeValue("value")).doubleValue();
/* 149 */       this.J = Double.valueOf(((Element)data.get("J")).attributeValue("value")).doubleValue();
/* 150 */       this.K = Double.valueOf(((Element)data.get("K")).attributeValue("value")).doubleValue();
/* 151 */       this.L = Double.valueOf(((Element)data.get("L")).attributeValue("value")).doubleValue();
/* 152 */       this.M = Double.valueOf(((Element)data.get("M")).attributeValue("value")).doubleValue();
/* 153 */       this.N = Double.valueOf(((Element)data.get("N")).attributeValue("value")).doubleValue();
/* 154 */       this.O = Double.valueOf(((Element)data.get("O")).attributeValue("value")).doubleValue();
/* 155 */       this.P = Double.valueOf(((Element)data.get("P")).attributeValue("value")).doubleValue();
/* 156 */       this.Q = Double.valueOf(((Element)data.get("Q")).attributeValue("value")).doubleValue();
/* 157 */       this.R = Double.valueOf(((Element)data.get("R")).attributeValue("value")).doubleValue();
/* 158 */       this.S = Double.valueOf(((Element)data.get("S")).attributeValue("value")).doubleValue();
/* 159 */       this.T = Double.valueOf(((Element)data.get("T")).attributeValue("value")).doubleValue();
/* 160 */       this.U = Double.valueOf(((Element)data.get("U")).attributeValue("value")).doubleValue();
/* 161 */       this.DEFAULT_ACTION_DURATION = Integer.valueOf(((Element)data.get("DEFAULT_ACTION_DURATION")).attributeValue("value")).intValue();
/* 162 */       this.DEFAULT_EFFECT_DURATION = Integer.valueOf(((Element)data.get("DEFAULT_EFFECT_DURATION")).attributeValue("value")).intValue();
/* 163 */       this.WORDS_DURATION = Integer.valueOf(((Element)data.get("WORDS_DURATION")).attributeValue("value")).intValue();
/* 164 */       this.ESCAPE_ACTION_TIME = Integer.valueOf(((Element)data.get("ESCAPE_ACTION_TIME")).attributeValue("value")).intValue();
/* 165 */       this.CHANGE_MODEL_ACTION_TIME = Integer.valueOf(((Element)data.get("CHANGE_MODEL_ACTION_TIME")).attributeValue("value")).intValue();
/* 166 */       this.CHANGE_FIGHTER_ACTION_TIME = Integer.valueOf(((Element)data.get("CHANGE_FIGHTER_ACTION_TIME")).attributeValue("value")).intValue();
/* 167 */       this.ATTACK_SKILL = Integer.valueOf(((Element)data.get("ATTACK_SKILL")).attributeValue("value")).intValue();
/* 168 */       this.DEFENCE_SKILL = Integer.valueOf(((Element)data.get("DEFENCE_SKILL")).attributeValue("value")).intValue();
/* 169 */       this.MAG_SKILL = Integer.valueOf(((Element)data.get("MAG_SKILL")).attributeValue("value")).intValue();
/* 170 */       this.PROTECT_PLAY_TIME = Integer.valueOf(((Element)data.get("PROTECT_PLAY_TIME")).attributeValue("value")).intValue();
/* 171 */       this.SPEED_FLUCTUATE_RATE = Integer.valueOf(((Element)data.get("SPEED_FLUCTUATE_RATE")).attributeValue("value")).intValue();
/* 172 */       this.DAMAGE_RATE_PROTECT = Integer.valueOf(((Element)data.get("DAMAGE_RATE_PROTECT")).attributeValue("value")).intValue();
/* 173 */       this.DAMAGE_SKILL_PLAY_TIME = Integer.valueOf(((Element)data.get("DAMAGE_SKILL_PLAY_TIME")).attributeValue("value")).intValue();
/* 174 */       this.DRAG_USE_TIMES = Integer.valueOf(((Element)data.get("DRAG_USE_TIMES")).attributeValue("value")).intValue();
/* 175 */       this.SUMMON_TIMES = Integer.valueOf(((Element)data.get("SUMMON_TIMES")).attributeValue("value")).intValue();
/* 176 */       this.DRAG_USE_SKILL_PLAYId = Integer.valueOf(((Element)data.get("DRAG_USE_SKILL_PLAYId")).attributeValue("value")).intValue();
/* 177 */       this.CAPTURE_SKILL_PLAYId = Integer.valueOf(((Element)data.get("CAPTURE_SKILL_PLAYId")).attributeValue("value")).intValue();
/* 178 */       this.SUMMON_SKILL_PLAYId = Integer.valueOf(((Element)data.get("SUMMON_SKILL_PLAYId")).attributeValue("value")).intValue();
/* 179 */       this.PVP_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PVP_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 180 */       this.PVE_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PVE_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 181 */       this.PVC_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PVC_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 182 */       this.OBSERVER_NUM_LIMIT = Integer.valueOf(((Element)data.get("OBSERVER_NUM_LIMIT")).attributeValue("value")).intValue();
/* 183 */       this.OBSERVER_DIS_NUM = Integer.valueOf(((Element)data.get("OBSERVER_DIS_NUM")).attributeValue("value")).intValue();
/* 184 */       this.ENERGY_MAX = Integer.valueOf(((Element)data.get("ENERGY_MAX")).attributeValue("value")).intValue();
/* 185 */       this.WORDS_ROUND_TIME = Integer.valueOf(((Element)data.get("WORDS_ROUND_TIME")).attributeValue("value")).intValue();
/* 186 */       this.DISSOLVE_EFFECT_TIME = Integer.valueOf(((Element)data.get("DISSOLVE_EFFECT_TIME")).attributeValue("value")).intValue();
/* 187 */       this.BREAK_EFFECT_TIME = Integer.valueOf(((Element)data.get("BREAK_EFFECT_TIME")).attributeValue("value")).intValue();
/* 188 */       this.BEATTACKED_ACTION_ID = Integer.valueOf(((Element)data.get("BEATTACKED_ACTION_ID")).attributeValue("value")).intValue();
/* 189 */       this.DEATH_ACTION_ID = Integer.valueOf(((Element)data.get("DEATH_ACTION_ID")).attributeValue("value")).intValue();
/* 190 */       this.BEATTACKED_FLY_ACTION_ID = Integer.valueOf(((Element)data.get("BEATTACKED_FLY_ACTION_ID")).attributeValue("value")).intValue();
/* 191 */       this.CLIENT_CALLBACK_EXTRA_TIME = Integer.valueOf(((Element)data.get("CLIENT_CALLBACK_EXTRA_TIME")).attributeValue("value")).intValue();
/* 192 */       this.EXTRA_PLAY_TIME_MAX_PER_ROUND = Integer.valueOf(((Element)data.get("EXTRA_PLAY_TIME_MAX_PER_ROUND")).attributeValue("value")).intValue();
/* 193 */       this.COMMAND_NAME_LENGTH = Integer.valueOf(((Element)data.get("COMMAND_NAME_LENGTH")).attributeValue("value")).intValue();
/* 194 */       this.AUTO_WAIT_TIME = Integer.valueOf(((Element)data.get("AUTO_WAIT_TIME")).attributeValue("value")).intValue();
/* 195 */       this.OTHER_ROUND_AUTO__WAIT_TIME = Integer.valueOf(((Element)data.get("OTHER_ROUND_AUTO__WAIT_TIME")).attributeValue("value")).intValue();
/* 196 */       this.SEAL_NUM_MAX = Integer.valueOf(((Element)data.get("SEAL_NUM_MAX")).attributeValue("value")).intValue();
/* 197 */       this.ASSIST_FELLOW_NUM_1 = Integer.valueOf(((Element)data.get("ASSIST_FELLOW_NUM_1")).attributeValue("value")).intValue();
/* 198 */       this.ASSIST_COST_MODIFY_RATE_1 = Integer.valueOf(((Element)data.get("ASSIST_COST_MODIFY_RATE_1")).attributeValue("value")).intValue();
/* 199 */       this.ASSIST_FELLOW_NUM_2 = Integer.valueOf(((Element)data.get("ASSIST_FELLOW_NUM_2")).attributeValue("value")).intValue();
/* 200 */       this.ASSIST_COST_MODIFY_RATE_2 = Integer.valueOf(((Element)data.get("ASSIST_COST_MODIFY_RATE_2")).attributeValue("value")).intValue();
/* 201 */       this.checkABS = Integer.valueOf(((Element)data.get("checkABS")).attributeValue("value")).intValue();
/* 202 */       this.SEAL_ACTIONED_ADD_LAST_ROUND = Integer.valueOf(((Element)data.get("SEAL_ACTIONED_ADD_LAST_ROUND")).attributeValue("value")).intValue();
/* 203 */       this.RELIVE_ACTION_ID = Integer.valueOf(((Element)data.get("RELIVE_ACTION_ID")).attributeValue("value")).intValue();
/* 204 */       this.PK_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PK_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 205 */       this.ARREST_WANTED_RED_ESCAPE_RATE = Integer.valueOf(((Element)data.get("ARREST_WANTED_RED_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 206 */       this.ARREST_WANTED_ESCAPE_RATE = Integer.valueOf(((Element)data.get("ARREST_WANTED_ESCAPE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 210 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 215 */     String path = dir + "mzm.gsp.fight.confbean.SFightConsts.xml";
/*     */     try
/*     */     {
/* 218 */       SAXReader reader = new SAXReader();
/* 219 */       org.dom4j.Document doc = reader.read(new File(path));
/* 220 */       Element root = doc.getRootElement();
/* 221 */       Map<String, Element> data = new java.util.HashMap();
/* 222 */       java.util.List<?> nodeList = root.elements();
/* 223 */       int len = nodeList.size();
/* 224 */       for (int i = 0; i < len; i++)
/*     */       {
/* 226 */         Element element = (Element)nodeList.get(i);
/* 227 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 230 */           String name = element.attributeValue("name");
/* 231 */           if (data.put(name, element) != null)
/* 232 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 235 */       this.NORMAL_FIGHTtEAM_MONSTERNUM = Integer.valueOf(((Element)data.get("NORMAL_FIGHTtEAM_MONSTERNUM")).attributeValue("value")).intValue();
/* 236 */       this.WAIT_CMD_TIME = Integer.valueOf(((Element)data.get("WAIT_CMD_TIME")).attributeValue("value")).intValue();
/* 237 */       this.ANGER_MAX = Integer.valueOf(((Element)data.get("ANGER_MAX")).attributeValue("value")).intValue();
/* 238 */       this.CAPTURE_RATE_MAX = Integer.valueOf(((Element)data.get("CAPTURE_RATE_MAX")).attributeValue("value")).intValue();
/* 239 */       this.DAMAGEWAVEMAX = Integer.valueOf(((Element)data.get("DAMAGEWAVEMAX")).attributeValue("value")).intValue();
/* 240 */       this.DAMAGEWAVEMIN = Integer.valueOf(((Element)data.get("DAMAGEWAVEMIN")).attributeValue("value")).intValue();
/* 241 */       this.A = Double.valueOf(((Element)data.get("A")).attributeValue("value")).doubleValue();
/* 242 */       this.B = Double.valueOf(((Element)data.get("B")).attributeValue("value")).doubleValue();
/* 243 */       this.C = Double.valueOf(((Element)data.get("C")).attributeValue("value")).doubleValue();
/* 244 */       this.D = Double.valueOf(((Element)data.get("D")).attributeValue("value")).doubleValue();
/* 245 */       this.E = Double.valueOf(((Element)data.get("E")).attributeValue("value")).doubleValue();
/* 246 */       this.F = Double.valueOf(((Element)data.get("F")).attributeValue("value")).doubleValue();
/* 247 */       this.G1 = Double.valueOf(((Element)data.get("G1")).attributeValue("value")).doubleValue();
/* 248 */       this.G2 = Double.valueOf(((Element)data.get("G2")).attributeValue("value")).doubleValue();
/* 249 */       this.H = Double.valueOf(((Element)data.get("H")).attributeValue("value")).doubleValue();
/* 250 */       this.I = Double.valueOf(((Element)data.get("I")).attributeValue("value")).doubleValue();
/* 251 */       this.J = Double.valueOf(((Element)data.get("J")).attributeValue("value")).doubleValue();
/* 252 */       this.K = Double.valueOf(((Element)data.get("K")).attributeValue("value")).doubleValue();
/* 253 */       this.L = Double.valueOf(((Element)data.get("L")).attributeValue("value")).doubleValue();
/* 254 */       this.M = Double.valueOf(((Element)data.get("M")).attributeValue("value")).doubleValue();
/* 255 */       this.N = Double.valueOf(((Element)data.get("N")).attributeValue("value")).doubleValue();
/* 256 */       this.O = Double.valueOf(((Element)data.get("O")).attributeValue("value")).doubleValue();
/* 257 */       this.P = Double.valueOf(((Element)data.get("P")).attributeValue("value")).doubleValue();
/* 258 */       this.Q = Double.valueOf(((Element)data.get("Q")).attributeValue("value")).doubleValue();
/* 259 */       this.R = Double.valueOf(((Element)data.get("R")).attributeValue("value")).doubleValue();
/* 260 */       this.S = Double.valueOf(((Element)data.get("S")).attributeValue("value")).doubleValue();
/* 261 */       this.T = Double.valueOf(((Element)data.get("T")).attributeValue("value")).doubleValue();
/* 262 */       this.U = Double.valueOf(((Element)data.get("U")).attributeValue("value")).doubleValue();
/* 263 */       this.DEFAULT_ACTION_DURATION = Integer.valueOf(((Element)data.get("DEFAULT_ACTION_DURATION")).attributeValue("value")).intValue();
/* 264 */       this.DEFAULT_EFFECT_DURATION = Integer.valueOf(((Element)data.get("DEFAULT_EFFECT_DURATION")).attributeValue("value")).intValue();
/* 265 */       this.WORDS_DURATION = Integer.valueOf(((Element)data.get("WORDS_DURATION")).attributeValue("value")).intValue();
/* 266 */       this.ESCAPE_ACTION_TIME = Integer.valueOf(((Element)data.get("ESCAPE_ACTION_TIME")).attributeValue("value")).intValue();
/* 267 */       this.CHANGE_MODEL_ACTION_TIME = Integer.valueOf(((Element)data.get("CHANGE_MODEL_ACTION_TIME")).attributeValue("value")).intValue();
/* 268 */       this.CHANGE_FIGHTER_ACTION_TIME = Integer.valueOf(((Element)data.get("CHANGE_FIGHTER_ACTION_TIME")).attributeValue("value")).intValue();
/* 269 */       this.ATTACK_SKILL = Integer.valueOf(((Element)data.get("ATTACK_SKILL")).attributeValue("value")).intValue();
/* 270 */       this.DEFENCE_SKILL = Integer.valueOf(((Element)data.get("DEFENCE_SKILL")).attributeValue("value")).intValue();
/* 271 */       this.MAG_SKILL = Integer.valueOf(((Element)data.get("MAG_SKILL")).attributeValue("value")).intValue();
/* 272 */       this.PROTECT_PLAY_TIME = Integer.valueOf(((Element)data.get("PROTECT_PLAY_TIME")).attributeValue("value")).intValue();
/* 273 */       this.SPEED_FLUCTUATE_RATE = Integer.valueOf(((Element)data.get("SPEED_FLUCTUATE_RATE")).attributeValue("value")).intValue();
/* 274 */       this.DAMAGE_RATE_PROTECT = Integer.valueOf(((Element)data.get("DAMAGE_RATE_PROTECT")).attributeValue("value")).intValue();
/* 275 */       this.DAMAGE_SKILL_PLAY_TIME = Integer.valueOf(((Element)data.get("DAMAGE_SKILL_PLAY_TIME")).attributeValue("value")).intValue();
/* 276 */       this.DRAG_USE_TIMES = Integer.valueOf(((Element)data.get("DRAG_USE_TIMES")).attributeValue("value")).intValue();
/* 277 */       this.SUMMON_TIMES = Integer.valueOf(((Element)data.get("SUMMON_TIMES")).attributeValue("value")).intValue();
/* 278 */       this.DRAG_USE_SKILL_PLAYId = Integer.valueOf(((Element)data.get("DRAG_USE_SKILL_PLAYId")).attributeValue("value")).intValue();
/* 279 */       this.CAPTURE_SKILL_PLAYId = Integer.valueOf(((Element)data.get("CAPTURE_SKILL_PLAYId")).attributeValue("value")).intValue();
/* 280 */       this.SUMMON_SKILL_PLAYId = Integer.valueOf(((Element)data.get("SUMMON_SKILL_PLAYId")).attributeValue("value")).intValue();
/* 281 */       this.PVP_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PVP_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 282 */       this.PVE_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PVE_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 283 */       this.PVC_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PVC_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 284 */       this.OBSERVER_NUM_LIMIT = Integer.valueOf(((Element)data.get("OBSERVER_NUM_LIMIT")).attributeValue("value")).intValue();
/* 285 */       this.OBSERVER_DIS_NUM = Integer.valueOf(((Element)data.get("OBSERVER_DIS_NUM")).attributeValue("value")).intValue();
/* 286 */       this.ENERGY_MAX = Integer.valueOf(((Element)data.get("ENERGY_MAX")).attributeValue("value")).intValue();
/* 287 */       this.WORDS_ROUND_TIME = Integer.valueOf(((Element)data.get("WORDS_ROUND_TIME")).attributeValue("value")).intValue();
/* 288 */       this.DISSOLVE_EFFECT_TIME = Integer.valueOf(((Element)data.get("DISSOLVE_EFFECT_TIME")).attributeValue("value")).intValue();
/* 289 */       this.BREAK_EFFECT_TIME = Integer.valueOf(((Element)data.get("BREAK_EFFECT_TIME")).attributeValue("value")).intValue();
/* 290 */       this.BEATTACKED_ACTION_ID = Integer.valueOf(((Element)data.get("BEATTACKED_ACTION_ID")).attributeValue("value")).intValue();
/* 291 */       this.DEATH_ACTION_ID = Integer.valueOf(((Element)data.get("DEATH_ACTION_ID")).attributeValue("value")).intValue();
/* 292 */       this.BEATTACKED_FLY_ACTION_ID = Integer.valueOf(((Element)data.get("BEATTACKED_FLY_ACTION_ID")).attributeValue("value")).intValue();
/* 293 */       this.CLIENT_CALLBACK_EXTRA_TIME = Integer.valueOf(((Element)data.get("CLIENT_CALLBACK_EXTRA_TIME")).attributeValue("value")).intValue();
/* 294 */       this.EXTRA_PLAY_TIME_MAX_PER_ROUND = Integer.valueOf(((Element)data.get("EXTRA_PLAY_TIME_MAX_PER_ROUND")).attributeValue("value")).intValue();
/* 295 */       this.COMMAND_NAME_LENGTH = Integer.valueOf(((Element)data.get("COMMAND_NAME_LENGTH")).attributeValue("value")).intValue();
/* 296 */       this.AUTO_WAIT_TIME = Integer.valueOf(((Element)data.get("AUTO_WAIT_TIME")).attributeValue("value")).intValue();
/* 297 */       this.OTHER_ROUND_AUTO__WAIT_TIME = Integer.valueOf(((Element)data.get("OTHER_ROUND_AUTO__WAIT_TIME")).attributeValue("value")).intValue();
/* 298 */       this.SEAL_NUM_MAX = Integer.valueOf(((Element)data.get("SEAL_NUM_MAX")).attributeValue("value")).intValue();
/* 299 */       this.ASSIST_FELLOW_NUM_1 = Integer.valueOf(((Element)data.get("ASSIST_FELLOW_NUM_1")).attributeValue("value")).intValue();
/* 300 */       this.ASSIST_COST_MODIFY_RATE_1 = Integer.valueOf(((Element)data.get("ASSIST_COST_MODIFY_RATE_1")).attributeValue("value")).intValue();
/* 301 */       this.ASSIST_FELLOW_NUM_2 = Integer.valueOf(((Element)data.get("ASSIST_FELLOW_NUM_2")).attributeValue("value")).intValue();
/* 302 */       this.ASSIST_COST_MODIFY_RATE_2 = Integer.valueOf(((Element)data.get("ASSIST_COST_MODIFY_RATE_2")).attributeValue("value")).intValue();
/* 303 */       this.checkABS = Integer.valueOf(((Element)data.get("checkABS")).attributeValue("value")).intValue();
/* 304 */       this.SEAL_ACTIONED_ADD_LAST_ROUND = Integer.valueOf(((Element)data.get("SEAL_ACTIONED_ADD_LAST_ROUND")).attributeValue("value")).intValue();
/* 305 */       this.RELIVE_ACTION_ID = Integer.valueOf(((Element)data.get("RELIVE_ACTION_ID")).attributeValue("value")).intValue();
/* 306 */       this.PK_ESCAPE_RATE = Integer.valueOf(((Element)data.get("PK_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 307 */       this.ARREST_WANTED_RED_ESCAPE_RATE = Integer.valueOf(((Element)data.get("ARREST_WANTED_RED_ESCAPE_RATE")).attributeValue("value")).intValue();
/* 308 */       this.ARREST_WANTED_ESCAPE_RATE = Integer.valueOf(((Element)data.get("ARREST_WANTED_ESCAPE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 312 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 316 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 319 */     String path = dir + "mzm.gsp.fight.confbean.SFightConsts.bny";
/*     */     try
/*     */     {
/* 322 */       File file = new File(path);
/* 323 */       if (file.exists())
/*     */       {
/* 325 */         byte[] bytes = new byte['Ѐ'];
/* 326 */         FileInputStream fis = new FileInputStream(file);
/* 327 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 328 */         int len = 0;
/* 329 */         while ((len = fis.read(bytes)) > 0)
/* 330 */           baos.write(bytes, 0, len);
/* 331 */         fis.close();
/* 332 */         bytes = baos.toByteArray();
/* 333 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 334 */         this.NORMAL_FIGHTtEAM_MONSTERNUM = _os_.unmarshal_int();
/* 335 */         this.WAIT_CMD_TIME = _os_.unmarshal_int();
/* 336 */         this.ANGER_MAX = _os_.unmarshal_int();
/* 337 */         this.CAPTURE_RATE_MAX = _os_.unmarshal_int();
/* 338 */         this.DAMAGEWAVEMAX = _os_.unmarshal_int();
/* 339 */         this.DAMAGEWAVEMIN = _os_.unmarshal_int();
/* 340 */         this.A = _os_.unmarshal_float();
/* 341 */         this.B = _os_.unmarshal_float();
/* 342 */         this.C = _os_.unmarshal_float();
/* 343 */         this.D = _os_.unmarshal_float();
/* 344 */         this.E = _os_.unmarshal_float();
/* 345 */         this.F = _os_.unmarshal_float();
/* 346 */         this.G1 = _os_.unmarshal_float();
/* 347 */         this.G2 = _os_.unmarshal_float();
/* 348 */         this.H = _os_.unmarshal_float();
/* 349 */         this.I = _os_.unmarshal_float();
/* 350 */         this.J = _os_.unmarshal_float();
/* 351 */         this.K = _os_.unmarshal_float();
/* 352 */         this.L = _os_.unmarshal_float();
/* 353 */         this.M = _os_.unmarshal_float();
/* 354 */         this.N = _os_.unmarshal_float();
/* 355 */         this.O = _os_.unmarshal_float();
/* 356 */         this.P = _os_.unmarshal_float();
/* 357 */         this.Q = _os_.unmarshal_float();
/* 358 */         this.R = _os_.unmarshal_float();
/* 359 */         this.S = _os_.unmarshal_float();
/* 360 */         this.T = _os_.unmarshal_float();
/* 361 */         this.U = _os_.unmarshal_float();
/* 362 */         this.DEFAULT_ACTION_DURATION = _os_.unmarshal_int();
/* 363 */         this.DEFAULT_EFFECT_DURATION = _os_.unmarshal_int();
/* 364 */         this.WORDS_DURATION = _os_.unmarshal_int();
/* 365 */         this.ESCAPE_ACTION_TIME = _os_.unmarshal_int();
/* 366 */         this.CHANGE_MODEL_ACTION_TIME = _os_.unmarshal_int();
/* 367 */         this.CHANGE_FIGHTER_ACTION_TIME = _os_.unmarshal_int();
/* 368 */         this.ATTACK_SKILL = _os_.unmarshal_int();
/* 369 */         this.DEFENCE_SKILL = _os_.unmarshal_int();
/* 370 */         this.MAG_SKILL = _os_.unmarshal_int();
/* 371 */         this.PROTECT_PLAY_TIME = _os_.unmarshal_int();
/* 372 */         this.SPEED_FLUCTUATE_RATE = _os_.unmarshal_int();
/* 373 */         this.DAMAGE_RATE_PROTECT = _os_.unmarshal_int();
/* 374 */         this.DAMAGE_SKILL_PLAY_TIME = _os_.unmarshal_int();
/* 375 */         this.DRAG_USE_TIMES = _os_.unmarshal_int();
/* 376 */         this.SUMMON_TIMES = _os_.unmarshal_int();
/* 377 */         this.DRAG_USE_SKILL_PLAYId = _os_.unmarshal_int();
/* 378 */         this.CAPTURE_SKILL_PLAYId = _os_.unmarshal_int();
/* 379 */         this.SUMMON_SKILL_PLAYId = _os_.unmarshal_int();
/* 380 */         this.PVP_ESCAPE_RATE = _os_.unmarshal_int();
/* 381 */         this.PVE_ESCAPE_RATE = _os_.unmarshal_int();
/* 382 */         this.PVC_ESCAPE_RATE = _os_.unmarshal_int();
/* 383 */         this.OBSERVER_NUM_LIMIT = _os_.unmarshal_int();
/* 384 */         this.OBSERVER_DIS_NUM = _os_.unmarshal_int();
/* 385 */         this.ENERGY_MAX = _os_.unmarshal_int();
/* 386 */         this.WORDS_ROUND_TIME = _os_.unmarshal_int();
/* 387 */         this.DISSOLVE_EFFECT_TIME = _os_.unmarshal_int();
/* 388 */         this.BREAK_EFFECT_TIME = _os_.unmarshal_int();
/* 389 */         this.BEATTACKED_ACTION_ID = _os_.unmarshal_int();
/* 390 */         this.DEATH_ACTION_ID = _os_.unmarshal_int();
/* 391 */         this.BEATTACKED_FLY_ACTION_ID = _os_.unmarshal_int();
/* 392 */         this.CLIENT_CALLBACK_EXTRA_TIME = _os_.unmarshal_int();
/* 393 */         this.EXTRA_PLAY_TIME_MAX_PER_ROUND = _os_.unmarshal_int();
/* 394 */         this.COMMAND_NAME_LENGTH = _os_.unmarshal_int();
/* 395 */         this.AUTO_WAIT_TIME = _os_.unmarshal_int();
/* 396 */         this.OTHER_ROUND_AUTO__WAIT_TIME = _os_.unmarshal_int();
/* 397 */         this.SEAL_NUM_MAX = _os_.unmarshal_int();
/* 398 */         this.ASSIST_FELLOW_NUM_1 = _os_.unmarshal_int();
/* 399 */         this.ASSIST_COST_MODIFY_RATE_1 = _os_.unmarshal_int();
/* 400 */         this.ASSIST_FELLOW_NUM_2 = _os_.unmarshal_int();
/* 401 */         this.ASSIST_COST_MODIFY_RATE_2 = _os_.unmarshal_int();
/* 402 */         this.checkABS = _os_.unmarshal_int();
/* 403 */         this.SEAL_ACTIONED_ADD_LAST_ROUND = _os_.unmarshal_int();
/* 404 */         this.RELIVE_ACTION_ID = _os_.unmarshal_int();
/* 405 */         this.PK_ESCAPE_RATE = _os_.unmarshal_int();
/* 406 */         this.ARREST_WANTED_RED_ESCAPE_RATE = _os_.unmarshal_int();
/* 407 */         this.ARREST_WANTED_ESCAPE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 412 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 418 */     String path = dir + "mzm.gsp.fight.confbean.SFightConsts.bny";
/*     */     try
/*     */     {
/* 421 */       File file = new File(path);
/* 422 */       if (file.exists())
/*     */       {
/* 424 */         byte[] bytes = new byte['Ѐ'];
/* 425 */         FileInputStream fis = new FileInputStream(file);
/* 426 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 427 */         int len = 0;
/* 428 */         while ((len = fis.read(bytes)) > 0)
/* 429 */           baos.write(bytes, 0, len);
/* 430 */         fis.close();
/* 431 */         bytes = baos.toByteArray();
/* 432 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 433 */         this.NORMAL_FIGHTtEAM_MONSTERNUM = _os_.unmarshal_int();
/* 434 */         this.WAIT_CMD_TIME = _os_.unmarshal_int();
/* 435 */         this.ANGER_MAX = _os_.unmarshal_int();
/* 436 */         this.CAPTURE_RATE_MAX = _os_.unmarshal_int();
/* 437 */         this.DAMAGEWAVEMAX = _os_.unmarshal_int();
/* 438 */         this.DAMAGEWAVEMIN = _os_.unmarshal_int();
/* 439 */         this.A = _os_.unmarshal_float();
/* 440 */         this.B = _os_.unmarshal_float();
/* 441 */         this.C = _os_.unmarshal_float();
/* 442 */         this.D = _os_.unmarshal_float();
/* 443 */         this.E = _os_.unmarshal_float();
/* 444 */         this.F = _os_.unmarshal_float();
/* 445 */         this.G1 = _os_.unmarshal_float();
/* 446 */         this.G2 = _os_.unmarshal_float();
/* 447 */         this.H = _os_.unmarshal_float();
/* 448 */         this.I = _os_.unmarshal_float();
/* 449 */         this.J = _os_.unmarshal_float();
/* 450 */         this.K = _os_.unmarshal_float();
/* 451 */         this.L = _os_.unmarshal_float();
/* 452 */         this.M = _os_.unmarshal_float();
/* 453 */         this.N = _os_.unmarshal_float();
/* 454 */         this.O = _os_.unmarshal_float();
/* 455 */         this.P = _os_.unmarshal_float();
/* 456 */         this.Q = _os_.unmarshal_float();
/* 457 */         this.R = _os_.unmarshal_float();
/* 458 */         this.S = _os_.unmarshal_float();
/* 459 */         this.T = _os_.unmarshal_float();
/* 460 */         this.U = _os_.unmarshal_float();
/* 461 */         this.DEFAULT_ACTION_DURATION = _os_.unmarshal_int();
/* 462 */         this.DEFAULT_EFFECT_DURATION = _os_.unmarshal_int();
/* 463 */         this.WORDS_DURATION = _os_.unmarshal_int();
/* 464 */         this.ESCAPE_ACTION_TIME = _os_.unmarshal_int();
/* 465 */         this.CHANGE_MODEL_ACTION_TIME = _os_.unmarshal_int();
/* 466 */         this.CHANGE_FIGHTER_ACTION_TIME = _os_.unmarshal_int();
/* 467 */         this.ATTACK_SKILL = _os_.unmarshal_int();
/* 468 */         this.DEFENCE_SKILL = _os_.unmarshal_int();
/* 469 */         this.MAG_SKILL = _os_.unmarshal_int();
/* 470 */         this.PROTECT_PLAY_TIME = _os_.unmarshal_int();
/* 471 */         this.SPEED_FLUCTUATE_RATE = _os_.unmarshal_int();
/* 472 */         this.DAMAGE_RATE_PROTECT = _os_.unmarshal_int();
/* 473 */         this.DAMAGE_SKILL_PLAY_TIME = _os_.unmarshal_int();
/* 474 */         this.DRAG_USE_TIMES = _os_.unmarshal_int();
/* 475 */         this.SUMMON_TIMES = _os_.unmarshal_int();
/* 476 */         this.DRAG_USE_SKILL_PLAYId = _os_.unmarshal_int();
/* 477 */         this.CAPTURE_SKILL_PLAYId = _os_.unmarshal_int();
/* 478 */         this.SUMMON_SKILL_PLAYId = _os_.unmarshal_int();
/* 479 */         this.PVP_ESCAPE_RATE = _os_.unmarshal_int();
/* 480 */         this.PVE_ESCAPE_RATE = _os_.unmarshal_int();
/* 481 */         this.PVC_ESCAPE_RATE = _os_.unmarshal_int();
/* 482 */         this.OBSERVER_NUM_LIMIT = _os_.unmarshal_int();
/* 483 */         this.OBSERVER_DIS_NUM = _os_.unmarshal_int();
/* 484 */         this.ENERGY_MAX = _os_.unmarshal_int();
/* 485 */         this.WORDS_ROUND_TIME = _os_.unmarshal_int();
/* 486 */         this.DISSOLVE_EFFECT_TIME = _os_.unmarshal_int();
/* 487 */         this.BREAK_EFFECT_TIME = _os_.unmarshal_int();
/* 488 */         this.BEATTACKED_ACTION_ID = _os_.unmarshal_int();
/* 489 */         this.DEATH_ACTION_ID = _os_.unmarshal_int();
/* 490 */         this.BEATTACKED_FLY_ACTION_ID = _os_.unmarshal_int();
/* 491 */         this.CLIENT_CALLBACK_EXTRA_TIME = _os_.unmarshal_int();
/* 492 */         this.EXTRA_PLAY_TIME_MAX_PER_ROUND = _os_.unmarshal_int();
/* 493 */         this.COMMAND_NAME_LENGTH = _os_.unmarshal_int();
/* 494 */         this.AUTO_WAIT_TIME = _os_.unmarshal_int();
/* 495 */         this.OTHER_ROUND_AUTO__WAIT_TIME = _os_.unmarshal_int();
/* 496 */         this.SEAL_NUM_MAX = _os_.unmarshal_int();
/* 497 */         this.ASSIST_FELLOW_NUM_1 = _os_.unmarshal_int();
/* 498 */         this.ASSIST_COST_MODIFY_RATE_1 = _os_.unmarshal_int();
/* 499 */         this.ASSIST_FELLOW_NUM_2 = _os_.unmarshal_int();
/* 500 */         this.ASSIST_COST_MODIFY_RATE_2 = _os_.unmarshal_int();
/* 501 */         this.checkABS = _os_.unmarshal_int();
/* 502 */         this.SEAL_ACTIONED_ADD_LAST_ROUND = _os_.unmarshal_int();
/* 503 */         this.RELIVE_ACTION_ID = _os_.unmarshal_int();
/* 504 */         this.PK_ESCAPE_RATE = _os_.unmarshal_int();
/* 505 */         this.ARREST_WANTED_RED_ESCAPE_RATE = _os_.unmarshal_int();
/* 506 */         this.ARREST_WANTED_ESCAPE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 511 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFightConsts newInstance)
/*     */   {
/* 517 */     oldInstance = instance;
/* 518 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 523 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\confbean\SFightConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */