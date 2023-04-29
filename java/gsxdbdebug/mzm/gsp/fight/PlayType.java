/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayType
/*    */   implements Marshal, Comparable<PlayType>
/*    */ {
/*    */   public static final int PLAY_SKILL = 0;
/*    */   public static final int PLAY_CAPTURE = 1;
/*    */   public static final int PLAY_SUMMON = 2;
/*    */   public static final int PLAY_ESCAPE = 3;
/*    */   public static final int PLAY_TALK = 4;
/*    */   public static final int PLAY_TIP = 5;
/*    */   public static final int PLAY_USEITEM = 6;
/*    */   public static final int PLAY_CHANGE_FIGHT_MAP = 7;
/*    */   public static final int PLAY_FIGHTER_STATUS = 8;
/*    */   public static final int PLAY_CHANGE_FIGHTER = 9;
/*    */   public static final int PLAY_CHANGE_MODEL = 10;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof PlayType)) {
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 53 */     StringBuilder _sb_ = new StringBuilder();
/* 54 */     _sb_.append("(");
/* 55 */     _sb_.append(")");
/* 56 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PlayType _o_) {
/* 60 */     if (_o_ == this) return 0;
/* 61 */     int _c_ = 0;
/* 62 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */