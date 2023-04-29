/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapEntityType
/*    */   implements Marshal, Comparable<MapEntityType>
/*    */ {
/*    */   public static final int MET_FURNITURE = 0;
/*    */   public static final int MGT_SERVANT = 1;
/*    */   public static final int MGT_EXPLORE_CAT = 2;
/*    */   public static final int MGT_HOME_LAND_BASIC_INFO = 3;
/*    */   public static final int MGT_WORLD_GOAL_INFO = 4;
/*    */   public static final int MGT_FLOOR_TILE = 5;
/*    */   public static final int MGT_WALLPAPER = 6;
/*    */   public static final int MET_CHILDREN = 7;
/*    */   public static final int MET_ANIMAL = 8;
/*    */   public static final int MET_MYSTERY_VISITOR = 9;
/*    */   public static final int MET_BARRIERS = 10;
/*    */   public static final int MET_ROADS = 11;
/*    */   public static final int MET_TERRAIN = 12;
/*    */   public static final int MET_SINGLE_BATTLE_POSITION = 13;
/*    */   public static final int MET_SINGLE_BATTLE_GATHER_ITEM = 14;
/*    */   public static final int MET_SINGLE_BATTLE_BUFF = 15;
/*    */   public static final int MET_GOLD_STATUE = 16;
/*    */   public static final int MET_FLOAT_PARADE = 17;
/*    */   public static final int MET_CAKE_OVEN = 18;
/*    */   public static final int MET_CHRISTMAS_STOCKING = 19;
/*    */   public static final int MET_BALL_BATTLE_GROUND_ITEM = 20;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof MapEntityType)) {
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(")");
/* 66 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MapEntityType _o_) {
/* 70 */     if (_o_ == this) return 0;
/* 71 */     int _c_ = 0;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\MapEntityType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */