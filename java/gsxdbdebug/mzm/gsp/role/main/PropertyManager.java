/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class PropertyManager
/*     */ {
/*  11 */   private static Map<Integer, Integer> prop2Ret = new HashMap();
/*  12 */   private static Map<Integer, String> prop2Name = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getPro2Ret()
/*     */   {
/*  21 */     return new HashMap(prop2Ret);
/*     */   }
/*     */   
/*     */   static Map<Integer, String> getProperty2Names()
/*     */   {
/*  26 */     return new HashMap(prop2Name);
/*     */   }
/*     */   
/*     */   static String getPropName(int propType)
/*     */   {
/*  31 */     String name = (String)prop2Name.get(Integer.valueOf(propType));
/*  32 */     return name == null ? "NULL" : name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAddRet(int propType)
/*     */   {
/*  43 */     Integer addRet = (Integer)prop2Ret.get(Integer.valueOf(propType));
/*  44 */     return addRet == null ? 0 : addRet.intValue();
/*     */   }
/*     */   
/*     */   static void initProperty()
/*     */   {
/*  49 */     prop2Ret.put(Integer.valueOf(1), Integer.valueOf(30));
/*  50 */     prop2Ret.put(Integer.valueOf(2), Integer.valueOf(0));
/*  51 */     prop2Ret.put(Integer.valueOf(3), Integer.valueOf(31));
/*  52 */     prop2Ret.put(Integer.valueOf(4), Integer.valueOf(0));
/*  53 */     prop2Ret.put(Integer.valueOf(5), Integer.valueOf(32));
/*  54 */     prop2Ret.put(Integer.valueOf(6), Integer.valueOf(0));
/*  55 */     prop2Ret.put(Integer.valueOf(7), Integer.valueOf(33));
/*  56 */     prop2Ret.put(Integer.valueOf(8), Integer.valueOf(34));
/*  57 */     prop2Ret.put(Integer.valueOf(9), Integer.valueOf(35));
/*  58 */     prop2Ret.put(Integer.valueOf(10), Integer.valueOf(36));
/*  59 */     prop2Ret.put(Integer.valueOf(11), Integer.valueOf(0));
/*  60 */     prop2Ret.put(Integer.valueOf(12), Integer.valueOf(0));
/*  61 */     prop2Ret.put(Integer.valueOf(13), Integer.valueOf(0));
/*  62 */     prop2Ret.put(Integer.valueOf(14), Integer.valueOf(37));
/*  63 */     prop2Ret.put(Integer.valueOf(15), Integer.valueOf(38));
/*  64 */     prop2Ret.put(Integer.valueOf(16), Integer.valueOf(39));
/*  65 */     prop2Ret.put(Integer.valueOf(17), Integer.valueOf(40));
/*  66 */     prop2Ret.put(Integer.valueOf(18), Integer.valueOf(41));
/*  67 */     prop2Ret.put(Integer.valueOf(19), Integer.valueOf(42));
/*  68 */     prop2Ret.put(Integer.valueOf(20), Integer.valueOf(43));
/*  69 */     prop2Ret.put(Integer.valueOf(21), Integer.valueOf(44));
/*  70 */     prop2Ret.put(Integer.valueOf(22), Integer.valueOf(45));
/*  71 */     prop2Ret.put(Integer.valueOf(23), Integer.valueOf(46));
/*  72 */     prop2Ret.put(Integer.valueOf(24), Integer.valueOf(47));
/*     */     
/*  74 */     prop2Ret.put(Integer.valueOf(48), Integer.valueOf(0));
/*  75 */     prop2Ret.put(Integer.valueOf(49), Integer.valueOf(0));
/*  76 */     prop2Ret.put(Integer.valueOf(50), Integer.valueOf(0));
/*  77 */     prop2Ret.put(Integer.valueOf(51), Integer.valueOf(0));
/*  78 */     prop2Ret.put(Integer.valueOf(52), Integer.valueOf(0));
/*  79 */     prop2Ret.put(Integer.valueOf(53), Integer.valueOf(0));
/*  80 */     prop2Ret.put(Integer.valueOf(54), Integer.valueOf(0));
/*     */     
/*  82 */     prop2Ret.put(Integer.valueOf(55), Integer.valueOf(0));
/*  83 */     prop2Ret.put(Integer.valueOf(56), Integer.valueOf(0));
/*  84 */     prop2Ret.put(Integer.valueOf(57), Integer.valueOf(0));
/*  85 */     prop2Ret.put(Integer.valueOf(58), Integer.valueOf(0));
/*  86 */     prop2Ret.put(Integer.valueOf(59), Integer.valueOf(0));
/*  87 */     prop2Ret.put(Integer.valueOf(60), Integer.valueOf(0));
/*  88 */     prop2Ret.put(Integer.valueOf(61), Integer.valueOf(0));
/*     */     
/*     */ 
/*  91 */     prop2Ret.put(Integer.valueOf(65), Integer.valueOf(0));
/*  92 */     prop2Ret.put(Integer.valueOf(67), Integer.valueOf(0));
/*  93 */     prop2Ret.put(Integer.valueOf(68), Integer.valueOf(0));
/*  94 */     prop2Ret.put(Integer.valueOf(69), Integer.valueOf(0));
/*  95 */     prop2Ret.put(Integer.valueOf(70), Integer.valueOf(0));
/*  96 */     prop2Ret.put(Integer.valueOf(71), Integer.valueOf(0));
/*  97 */     prop2Ret.put(Integer.valueOf(72), Integer.valueOf(0));
/*  98 */     prop2Ret.put(Integer.valueOf(73), Integer.valueOf(0));
/*  99 */     prop2Ret.put(Integer.valueOf(74), Integer.valueOf(0));
/* 100 */     prop2Ret.put(Integer.valueOf(75), Integer.valueOf(0));
/* 101 */     prop2Ret.put(Integer.valueOf(76), Integer.valueOf(0));
/* 102 */     prop2Ret.put(Integer.valueOf(77), Integer.valueOf(0));
/* 103 */     prop2Ret.put(Integer.valueOf(78), Integer.valueOf(0));
/* 104 */     prop2Ret.put(Integer.valueOf(79), Integer.valueOf(0));
/* 105 */     prop2Ret.put(Integer.valueOf(80), Integer.valueOf(0));
/* 106 */     prop2Ret.put(Integer.valueOf(81), Integer.valueOf(0));
/*     */     
/*     */ 
/* 109 */     prop2Ret.put(Integer.valueOf(82), Integer.valueOf(0));
/* 110 */     prop2Ret.put(Integer.valueOf(83), Integer.valueOf(0));
/*     */     
/*     */ 
/* 113 */     prop2Ret.put(Integer.valueOf(85), Integer.valueOf(0));
/* 114 */     prop2Ret.put(Integer.valueOf(86), Integer.valueOf(0));
/* 115 */     prop2Ret.put(Integer.valueOf(87), Integer.valueOf(0));
/* 116 */     prop2Ret.put(Integer.valueOf(88), Integer.valueOf(0));
/*     */     
/*     */ 
/* 119 */     initProName();
/*     */   }
/*     */   
/*     */   static void initProName()
/*     */   {
/* 124 */     prop2Name.put(Integer.valueOf(1), "最大血量");
/* 125 */     prop2Name.put(Integer.valueOf(2), "当前血量");
/* 126 */     prop2Name.put(Integer.valueOf(3), "最大法力");
/* 127 */     prop2Name.put(Integer.valueOf(4), "当前法力");
/* 128 */     prop2Name.put(Integer.valueOf(5), "最大怒气");
/* 129 */     prop2Name.put(Integer.valueOf(6), "当前怒气");
/* 130 */     prop2Name.put(Integer.valueOf(7), "物攻");
/* 131 */     prop2Name.put(Integer.valueOf(8), "物防");
/* 132 */     prop2Name.put(Integer.valueOf(9), "法攻");
/* 133 */     prop2Name.put(Integer.valueOf(10), "法防");
/* 134 */     prop2Name.put(Integer.valueOf(11), "物理暴击率");
/* 135 */     prop2Name.put(Integer.valueOf(12), "法术暴击率");
/* 136 */     prop2Name.put(Integer.valueOf(13), "治疗暴击率");
/* 137 */     prop2Name.put(Integer.valueOf(14), "物理暴击");
/* 138 */     prop2Name.put(Integer.valueOf(15), "法术暴击");
/* 139 */     prop2Name.put(Integer.valueOf(16), "封印命中");
/* 140 */     prop2Name.put(Integer.valueOf(17), "封印抗性");
/* 141 */     prop2Name.put(Integer.valueOf(18), "物理命中等级");
/* 142 */     prop2Name.put(Integer.valueOf(19), "物理闪避等级");
/* 143 */     prop2Name.put(Integer.valueOf(20), "法术命中等级");
/* 144 */     prop2Name.put(Integer.valueOf(21), "法术闪避等级");
/* 145 */     prop2Name.put(Integer.valueOf(22), "物理反击率");
/* 146 */     prop2Name.put(Integer.valueOf(23), "法术反击率");
/* 147 */     prop2Name.put(Integer.valueOf(24), "速度");
/*     */     
/* 149 */     prop2Name.put(Integer.valueOf(48), "攻击资质");
/* 150 */     prop2Name.put(Integer.valueOf(49), "防御资质");
/* 151 */     prop2Name.put(Integer.valueOf(50), "法力资质");
/* 152 */     prop2Name.put(Integer.valueOf(51), "体力资质");
/* 153 */     prop2Name.put(Integer.valueOf(52), "速度资质");
/* 154 */     prop2Name.put(Integer.valueOf(53), "成长");
/* 155 */     prop2Name.put(Integer.valueOf(54), "寿命");
/*     */     
/*     */ 
/* 158 */     prop2Name.put(Integer.valueOf(55), "伤害增加万分比");
/* 159 */     prop2Name.put(Integer.valueOf(56), "受到伤害增加万分比");
/* 160 */     prop2Name.put(Integer.valueOf(57), "物理伤害增加万分比");
/* 161 */     prop2Name.put(Integer.valueOf(58), "法术伤害增加万分比");
/* 162 */     prop2Name.put(Integer.valueOf(59), "受到物理伤害万分比");
/* 163 */     prop2Name.put(Integer.valueOf(60), "受到法术伤害万分比");
/* 164 */     prop2Name.put(Integer.valueOf(61), "防御增加万分比");
/*     */     
/*     */ 
/* 167 */     prop2Name.put(Integer.valueOf(65), "封印命中率");
/* 168 */     prop2Name.put(Integer.valueOf(67), "封印被命中率");
/* 169 */     prop2Name.put(Integer.valueOf(68), "物理攻击命中率");
/* 170 */     prop2Name.put(Integer.valueOf(69), "物理攻击被命中率");
/* 171 */     prop2Name.put(Integer.valueOf(70), "法术攻击命中率");
/* 172 */     prop2Name.put(Integer.valueOf(71), "法术攻击被命中率");
/* 173 */     prop2Name.put(Integer.valueOf(72), "受到治疗效果固定值");
/* 174 */     prop2Name.put(Integer.valueOf(73), "受到治疗效果万分比");
/* 175 */     prop2Name.put(Integer.valueOf(74), "逃跑几率");
/* 176 */     prop2Name.put(Integer.valueOf(75), "捕捉宠物成功率");
/* 177 */     prop2Name.put(Integer.valueOf(76), "物理伤害波动下限");
/* 178 */     prop2Name.put(Integer.valueOf(77), "物理伤害波动上限");
/* 179 */     prop2Name.put(Integer.valueOf(78), "法术伤害波动下限");
/* 180 */     prop2Name.put(Integer.valueOf(79), "法术伤害波动上限");
/* 181 */     prop2Name.put(Integer.valueOf(80), "治疗效果固定值");
/* 182 */     prop2Name.put(Integer.valueOf(81), "治疗效果万分比");
/*     */     
/*     */ 
/* 185 */     prop2Name.put(Integer.valueOf(82), "物理反击伤害万分比");
/* 186 */     prop2Name.put(Integer.valueOf(83), "法术反击伤害万分比");
/*     */     
/*     */ 
/* 189 */     prop2Name.put(Integer.valueOf(85), "物理暴击等级");
/* 190 */     prop2Name.put(Integer.valueOf(86), "法术暴击等级");
/* 191 */     prop2Name.put(Integer.valueOf(87), "物理暴抗等级");
/* 192 */     prop2Name.put(Integer.valueOf(88), "法术暴抗等级");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getPropCHNInfo(Map<Integer, Integer> props)
/*     */   {
/* 204 */     if ((props == null) || (props.size() == 0))
/*     */     {
/* 206 */       return "NOTHING!";
/*     */     }
/* 208 */     StringBuffer sb = new StringBuffer();
/* 209 */     Iterator<Map.Entry<Integer, Integer>> it = props.entrySet().iterator();
/* 210 */     while (it.hasNext())
/*     */     {
/* 212 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 213 */       if (((Integer)entry.getValue()).intValue() != 0)
/*     */       {
/*     */ 
/*     */ 
/* 217 */         sb.append("\r\n");
/* 218 */         sb.append(getPropName(((Integer)entry.getKey()).intValue()));
/* 219 */         sb.append("=");
/* 220 */         sb.append(entry.getValue());
/*     */       } }
/* 222 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PropertyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */