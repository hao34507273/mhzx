/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class FighterStatuses implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<FighterStatus> statuses;
/*    */   
/*    */   public FighterStatuses()
/*    */   {
/* 12 */     this.statuses = new ArrayList();
/*    */   }
/*    */   
/*    */   public FighterStatuses(ArrayList<FighterStatus> _statuses_) {
/* 16 */     this.statuses = _statuses_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (FighterStatus _v_ : this.statuses)
/* 21 */       if (!_v_._validator_()) return false;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.statuses.size());
/* 27 */     for (FighterStatus _v_ : this.statuses) {
/* 28 */       _os_.marshal(_v_);
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 35 */       FighterStatus _v_ = new FighterStatus();
/* 36 */       _v_.unmarshal(_os_);
/* 37 */       this.statuses.add(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof FighterStatuses)) {
/* 45 */       FighterStatuses _o_ = (FighterStatuses)_o1_;
/* 46 */       if (!this.statuses.equals(_o_.statuses)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.statuses.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.statuses).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\FighterStatuses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */