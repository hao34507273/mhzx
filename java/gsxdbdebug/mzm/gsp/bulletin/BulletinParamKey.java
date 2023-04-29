/*    */ package mzm.gsp.bulletin;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BulletinParamKey
/*    */   implements Marshal, Comparable<BulletinParamKey>
/*    */ {
/*    */   public static final int ROLE_NAME1 = 1;
/*    */   public static final int ROLE_NAME2 = 2;
/*    */   public static final int ACTIVITY_NAME = 3;
/*    */   public static final int ITEM_ID = 4;
/*    */   public static final int PLACE_NAME = 5;
/*    */   public static final int EQUIP_LING_LEVEL = 6;
/*    */   public static final int MONSTER_ID = 7;
/*    */   public static final int GANG_NAME = 8;
/*    */   public static final int GANG_ID = 9;
/*    */   public static final int IS_SUPER = 10;
/*    */   public static final int BAOTU_ID = 11;
/*    */   public static final int LOTTERY_ID = 12;
/*    */   public static final int VICTORY_COUNT = 13;
/*    */   public static final int JIU_XIAO_LEFT_MINUTE = 14;
/*    */   public static final int ITEM_NUM = 15;
/*    */   public static final int MONSTER_NAME = 16;
/*    */   public static final int STAR_LEVEL = 17;
/*    */   public static final int ROLE_NAME3 = 18;
/*    */   public static final int RANK = 19;
/*    */   public static final int RATE = 20;
/*    */   public static final int PET_ID = 21;
/*    */   public static final int NEXT_MONSTER_NAME = 22;
/*    */   public static final int HUASHENG_X_SKILL = 23;
/*    */   public static final int HB_TIME = 24;
/*    */   public static final int SKILL_ID = 25;
/*    */   public static final int SKILL_ID2 = 26;
/*    */   public static final int JIU_XIAO_ACTIVITYID = 27;
/*    */   public static final int EXPLORE_CAT_PARTNER_CFG_ID = 28;
/*    */   public static final int CORPS_NAME = 29;
/*    */   public static final int RANK_UP_SELECTION_STAGE = 30;
/*    */   public static final int SELECTION_TITLE = 31;
/*    */   public static final int SELECTION_FIGHT_ZONE = 32;
/*    */   public static final int ZONE_ID = 33;
/*    */   public static final int EFFECT_ID = 34;
/*    */   public static final int MESSAGE = 35;
/*    */   public static final int VISIBLE_MONSTER_TYPE_ID = 36;
/*    */   public static final int VISIBLE_MONSTER_TYPE_ID_2 = 37;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof BulletinParamKey)) {
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BulletinParamKey _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bulletin\BulletinParamKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */