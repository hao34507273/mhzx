/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class PlayFighterStatus implements Marshal
/*    */ {
/*    */   public HashMap<Integer, FighterStatuses> fightermap;
/*    */   
/*    */   public PlayFighterStatus()
/*    */   {
/* 14 */     this.fightermap = new HashMap();
/*    */   }
/*    */   
/*    */   public PlayFighterStatus(HashMap<Integer, FighterStatuses> _fightermap_) {
/* 18 */     this.fightermap = _fightermap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (Map.Entry<Integer, FighterStatuses> _e_ : this.fightermap.entrySet()) {
/* 23 */       if (!((FighterStatuses)_e_.getValue())._validator_()) return false;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.fightermap.size());
/* 30 */     for (Map.Entry<Integer, FighterStatuses> _e_ : this.fightermap.entrySet()) {
/* 31 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 32 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 40 */       int _k_ = _os_.unmarshal_int();
/* 41 */       FighterStatuses _v_ = new FighterStatuses();
/* 42 */       _v_.unmarshal(_os_);
/* 43 */       this.fightermap.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof PlayFighterStatus)) {
/* 51 */       PlayFighterStatus _o_ = (PlayFighterStatus)_o1_;
/* 52 */       if (!this.fightermap.equals(_o_.fightermap)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.fightermap.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.fightermap).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayFighterStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */