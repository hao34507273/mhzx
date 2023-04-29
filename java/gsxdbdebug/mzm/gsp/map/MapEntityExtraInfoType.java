/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapEntityExtraInfoType
/*     */   implements Marshal, Comparable<MapEntityExtraInfoType>
/*     */ {
/*     */   public static final int MET_FURNITURE_DIRECTION = 0;
/*     */   public static final int MET_SERVANT_NAME = 100;
/*     */   public static final int MGT_EXPLORE_CAT_NAME = 200;
/*     */   public static final int MGT_EXPLORE_CAT_OWNER = 201;
/*     */   public static final int MGT_EXPLORE_CAT_DIRECTION = 202;
/*     */   public static final int MGT_EXPLORE_CAT_STATE = 203;
/*     */   public static final int MGT_EXPLORE_CAT_TITLE = 204;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_LEVEL = 300;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_FENG_SHUI = 301;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_CLEANLINESS = 302;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_CREATOR_ROLEID = 303;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_CREATOR_NAME = 304;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_PARTNER_ROLEID = 305;
/*     */   public static final int MGT_HOME_LAND_BASIC_INFO_PARTNER_NAME = 306;
/*     */   public static final int MET_HOME_LAND_BASIC_INFO_COURT_YARD_LEVEL = 307;
/*     */   public static final int MET_HOME_LAND_BASIC_INFO_COURT_YARD_CLEANLINESS = 308;
/*     */   public static final int MET_HOME_LAND_BASIC_INFO_COURT_YARD_BEAUTIFUL = 309;
/*     */   public static final int MGT_WORLD_GOAL_INFO_POINT = 400;
/*     */   public static final int MGT_WORLD_GOAL_INFO_TIMESTAMP = 401;
/*     */   public static final int MET_CHILDREN_ID = 701;
/*     */   public static final int MET_CHILDREN_NAME = 702;
/*     */   public static final int MET_CHILDREN_GENDER = 703;
/*     */   public static final int MET_CHILDREN_PERIOD = 704;
/*     */   public static final int MET_CHILDREN_FASHION = 705;
/*     */   public static final int MET_CHILDREN_MODEL_CFG_ID = 706;
/*     */   public static final int MET_CHILDREN_WEAPON_ID = 707;
/*     */   public static final int MET_ANIMAL_ID = 800;
/*     */   public static final int MET_ANIMAL_STAGE = 801;
/*     */   public static final int MET_EMBRYO_CFG_ID = 802;
/*     */   public static final int MET_EMBRYO_HATCH_DAYS = 803;
/*     */   public static final int MET_ANIMAL_CFG_ID = 804;
/*     */   public static final int MET_ANIMAL_LAST_MATE_TIME = 805;
/*     */   public static final int MET_ANIMAL_NAME = 806;
/*     */   public static final int MET_ANIMAL_AWARD_CFG_ID = 807;
/*     */   public static final int MET_ANIMAL_OWNER_NAME = 808;
/*     */   public static final int MET_SINGLE_BATTLE_POSITION_CAMPID = 1300;
/*     */   public static final int MET_GOLD_STATUE_ROLE_NAME = 1600;
/*     */   public static final int MET_GOLD_STATUE_CORPS_NAME = 1601;
/*     */   public static final int MET_GOLD_STATUE_CORPS_ZONEID = 1602;
/*     */   public static final int MET_GOLD_STATUE_CORPS_BADGEID = 1603;
/*     */   public static final int MET_GOLD_STATUE_CROSS_BATTLE_NO = 1604;
/*     */   public static final int MET_FLOAT_PARADE_MALE = 1700;
/*     */   public static final int MET_FLOAT_PARADE_FEMAIL = 1701;
/*     */   public static final int MET_FLOAT_PARADE_OCP = 1702;
/*     */   public static final int MET_FLOAT_PARADE_VELOCITY = 1703;
/*     */   public static final int MET_CAKE_OVEN_STAGE = 1800;
/*     */   public static final int MET_CHRISTMAS_STOCKING_POS_START = 1900;
/*     */   public static final int MET_CHRISTMAS_STOCKING_POS_END = 1919;
/*     */   public static final int MET_CHRISTMAS_STOCKING_OWNER = 1920;
/*     */   public static final int MET_CHRISTMAS_STOCKING_OWNER_NAME = 1921;
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof MapEntityExtraInfoType)) {
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(MapEntityExtraInfoType _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\MapEntityExtraInfoType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */